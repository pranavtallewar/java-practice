import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

public class CallRestDemo {
	private static final String APP_URL = "https://jsonmock.hackerrank.com/api/football_matches";

	public static void main(String[] args) throws IOException {
		int year = 2012;
		int matchDrawn = 0;
		System.out.println("Calling first Time");
		String responseStr = getResponse(year, 0);

		if (!responseStr.isEmpty()) {
			int total_pages = getTotalPages(responseStr);
			System.out.println("Total_Pages:" + total_pages);
			int i = 1;
			Pattern p = Pattern.compile("team1goals\":\"(\\d+)\",\"team2goals\":\"(\\d+)");
			Matcher m = null;

			while (i <= total_pages) {
				StringBuffer sb = new StringBuffer();
				if (i != 1) {
					sb.append(getResponse(year, i));
					m = p.matcher(sb.toString());
				} else {
					m = p.matcher(responseStr);
				}
				while (m.find()) {
					System.out.println("pattern matched");
					int n1 = Integer.parseInt(m.group(1));
					int n2 = Integer.parseInt(m.group(2));
					System.out.println("team1Goals=" + n1 + ",team2goals=" + n2);
					if (n1 == n2) {
						matchDrawn++;
					}
				}
				i++;
				sb = null;
				System.out.println("MatchDrawn=" + matchDrawn);
			}
		}
		System.out.println(matchDrawn);

	}

	static int getTotalPages(String response) {
		Pattern p = Pattern.compile("total_pages\":(\\d+)");
		Matcher m = p.matcher(response.toString());

		int total_pages = 0;
		if (m.find()) {
			total_pages = Integer.parseInt(m.group(1));
		}
		return total_pages;
	}

	static String getResponse(int year, int page) throws IOException {
		HttpsURLConnection conn = null;
		final StringBuffer response = new StringBuffer();

		final StringBuffer strUrl = new StringBuffer(
				"https://jsonmock.hackerrank.com/api/football_matches?year=" + year);
		if (page > 0)
			strUrl.append("&page=" + page);
		System.out.println("Calling api:" + strUrl.toString());

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
			System.out.println(response.toString());
		} finally {
			conn.disconnect();
		}

		return response.toString();
	}

	public static String getAppUrl() {
		return APP_URL;
	}

}

class Data {
	String competition;
	int year;
	String round;
	String team1;
	String team2;
	String team1goals;
	String team2goals;

	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getTeam1goals() {
		return team1goals;
	}

	public void setTeam1goals(String team1goals) {
		this.team1goals = team1goals;
	}

	public String getTeam2goals() {
		return team2goals;
	}

	public void setTeam2goals(String team2goals) {
		this.team2goals = team2goals;
	}

	@Override
	public String toString() {
		return "Data [competition=" + competition + ", year=" + year + ", round=" + round + ", team1=" + team1
				+ ", team2=" + team2 + ", team1goals=" + team1goals + ", team2goals=" + team2goals + "]";
	}

}

class MatchResponse {
	int page;
	int per_page;
	int total;
	int total_pages;
	List<Data> data;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MatchResponse [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages="
				+ total_pages + ", data=" + data + "]";
	}

}
