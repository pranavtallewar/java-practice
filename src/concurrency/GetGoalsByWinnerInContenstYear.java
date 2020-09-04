package concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetGoalsByWinnerInContenstYear {

	public static void main(String[] args) throws Exception {
		Instant start = Instant.now();
		int year = 2011;
		String contestName = "UEFA Champions League";
		String footballCompetitionResult = new Request("/football_competitions", year, contestName).call();
		String winner = getWinner(footballCompetitionResult);

		System.out.println(contestName + "-" + year + " Winner is " + winner);

		FootBallMatchStats teamgoals1 = new FootBallMatchStats(year, winner, null);
		FootBallMatchStats teamgoals2 = new FootBallMatchStats(year, null, winner);

		Integer totalGoalsByWinner = getGoalsMadeByWinner(teamgoals1, teamgoals2);
		System.out.println(
				"Total goals made by " + winner + " is" + totalGoalsByWinner + " in " + contestName + "-" + year);
		Instant end = Instant.now();
		System.out.println("Total time:"+ Duration.between(start, end).getSeconds()+" seconds..");
	}

	static Integer getGoalsMadeByWinner(FootBallMatchStats f1, FootBallMatchStats f2) throws InterruptedException, ExecutionException {
		Integer totalGoals = 0;
		
		ExecutorService executors = Executors.newFixedThreadPool(2);
		List<Future<Integer>> teamGoals = new ArrayList<Future<Integer>>();
		teamGoals.add(executors.submit(f1));
		teamGoals.add(executors.submit(f2));
		
		executors.shutdown();
		
		for(Future<Integer> teamGoal : teamGoals) {
			totalGoals += teamGoal.get();
			System.out.println(totalGoals);// 61
		}
		
		return totalGoals;
	}

	static String getWinner(String response) {
		String winner = null;
		Pattern p = Pattern.compile("winner\":\"(\\w+)");
		Matcher m = p.matcher(response);
		if (m.find()) {
			winner = m.group(1);
		}
		return winner;
	}
}
