package concurrency;

import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

public class FootBallMatchStats implements Callable<Integer> {
	private int year;
	private String team1;
	private String team2;

	private int pool;

	public FootBallMatchStats(int year, String team1, String team2) {
		this.year = year;
		this.team1 = team1;
		this.team2 = team2;
	}

	@Override
	public Integer call() throws Exception {
		return getDrawnMatches(year, team1, team2);
	}

	public static void main(String[] args) throws Exception {

		System.out.println("TotalMatchDrawn=" + new FootBallMatchStats(2012, null, null).call());
	}

	public Integer getDrawnMatches(int year, String team1, String team2) throws Exception {

		String pageResponse = new Request("/football_matches", year, team1, team2, 0).call();
		int total_pages = getTotalPages(pageResponse);
		
		System.out.println("Pages to scan:" + total_pages);
		pool = (total_pages < 10) ? total_pages : 80;

		List<Future<String>> responseFutures = getReqFutures(total_pages);

		List<Future<Integer>> processFutures = getProcessFutures(responseFutures);

		Integer matchDrawn = countDrawnMatches(processFutures);

		return matchDrawn;
	}

	private Integer countDrawnMatches(List<Future<Integer>> processFutures)
			throws InterruptedException, ExecutionException {
		int j = 0;
		int matchDrawn = 0;

		for (Future<Integer> processFuture : processFutures) {
			Integer data = processFuture.get();
			matchDrawn += data;
			j++;
		}
		System.out.println("Response processed successfully for " + j + " pages");
		return matchDrawn;
	}

	private List<Future<Integer>> getProcessFutures(List<Future<String>> responseFutures)
			throws InterruptedException, ExecutionException {
		ExecutorService processExecutors = Executors.newFixedThreadPool(pool);
		List<Future<Integer>> processFutures = new ArrayList<Future<Integer>>();
		for (Future<String> response : responseFutures) {
			String res = response.get();

			String responseToExtract = null;
			if (null != team1)
				responseToExtract = "team1";
			if (null != team2)
				responseToExtract = "team2";

			processFutures.add(processExecutors.submit(new ResponseProcess(res, responseToExtract)));
		}
		processExecutors.shutdown();

		return processFutures;

	}

	private List<Future<String>> getReqFutures(int total_pages) {
		ExecutorService requestExecutors = Executors.newFixedThreadPool(pool);

		List<Future<String>> responseFutures = new ArrayList<Future<String>>();
		int i = 0;
		for (i = 1; i <= total_pages; i++) {
			responseFutures.add(requestExecutors.submit(new Request("/football_matches", year, team1, team2, i)));
		}
		requestExecutors.shutdown();
		System.out.println("API responses retrieved for " + --i + " pages");
		return responseFutures;
	}

	static int getTotalPages(String response) {
		Pattern p = Pattern.compile("total_pages\":(\\d+)");
		Matcher m = p.matcher(response);

		int total_pages = 0;
		if (m.find()) {
			total_pages = Integer.parseInt(m.group(1));
		}
		return total_pages;
	}

}

class Request implements Callable<String> {

	private String api;
	private int page;
	private int year;
	private String contestName;
	private String team1;
	private String team2;

	private static final String APP_URL = "https://jsonmock.hackerrank.com/api";

	public Request(String api, int page, int year) {
		this.api = api;
		this.page = page;
		this.year = year;
	}

	public Request(String api, int year, String contestName) {
		this.api = api;
		this.year = year;
		this.contestName = contestName;
	}

	public Request(String api, int year, String team1, String team2, int page) {
		this.api = api;
		this.page = page;
		this.year = year;
		this.team1 = team1;
		this.team2 = team2;
	}

	@Override
	public String call() throws Exception {

		final StringBuffer response = new StringBuffer();

		final StringBuffer strUrl = new StringBuffer(APP_URL);
		strUrl.append(api);
		strUrl.append("?year=" + year);

		if (null != contestName && !contestName.isEmpty())
			strUrl.append("&name=" + URLEncoder.encode(contestName, "UTF-8"));

		if (null != team1 && !team1.isEmpty())
			strUrl.append("&team1=" + URLEncoder.encode(team1, "UTF-8"));

		if (null != team2 && !team2.isEmpty())
			strUrl.append("&team2=" + URLEncoder.encode(team2, "UTF-8"));

		if (page > 0)
			strUrl.append("&page=" + page);

		// System.out.println("Calling api:" + strUrl.toString());
		HttpsURLConnection conn = null;
		try {
			URL url = new URL(strUrl.toString());
			conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode:" + responseCode);
			} else {
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					response.append(sc.nextLine());
				}
				sc.close();
			}
		} finally {
			conn.disconnect();
		}

		return response.toString();
	}

	@Override
	public String toString() {
		return "Request [api=" + api + ", page=" + page + ", year=" + year + ", contestName=" + contestName + "]";
	}

}

class ResponseProcess implements Callable<Integer> {

	private String responseToProcess;
	private String responseToExtract;

	public ResponseProcess(String responseToProcess, String responseToExtract) {
		this.responseToProcess = responseToProcess;
		this.responseToExtract = responseToExtract;
	}

	@Override
	public Integer call() throws Exception {
		int metrics = 0;
		if (responseToExtract == null)
			metrics = extractMatchDrawn();
		else
			metrics = extractTeamGoals(responseToExtract);

		return metrics;
	}

	public Integer extractMatchDrawn() {
		int matchDrawn = 0;
		Pattern p = Pattern.compile("team1goals\":\"(\\d+)\",\"team2goals\":\"(\\d+)");

		Matcher m = p.matcher(responseToProcess);
		while (m.find()) {
			int n1 = Integer.parseInt(m.group(1));
			int n2 = Integer.parseInt(m.group(2));
			if (n1 == n2) {
				matchDrawn++;
			}
		}
		return matchDrawn;
	}

	public Integer extractTeamGoals(String team) {
		int extractGoals = 0;
		Pattern p = null;

		if (team.equalsIgnoreCase("team1"))
			p = Pattern.compile("team1goals\":\"(\\d+)");
		else if (team.equalsIgnoreCase("team2"))
			p = Pattern.compile("team2goals\":\"(\\d+)");

		Matcher m = p.matcher(responseToProcess);
		while (m.find()) {
			extractGoals += Integer.parseInt(m.group(1));
		}

		return extractGoals;
	}

}