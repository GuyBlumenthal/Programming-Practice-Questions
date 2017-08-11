package cccCompetitions.Y2013;

import java.util.HashMap;
import java.util.Scanner;

public class J5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// We scan in all of the information that we need before taking in the
		// games.
		int favouriteTeam = Integer.parseInt(sc.nextLine());
		int amountOfGamesPlayed = Integer.parseInt(sc.nextLine());

		// We create an array that will hold each value of the game (The four
		// values) into a 2 Dimensional array
		int[][] games = new int[amountOfGamesPlayed][4];

		for (int i = 0; i < amountOfGamesPlayed; i++) {

			// We split the game into different Integers represented as Strings
			// by each space
			String[] currentGame = sc.nextLine().split(" ");

			for (int j = 0; j < currentGame.length; j++) {

				// We then parse each value and put it into the proper game
				// value slot
				games[i][j] = Integer.parseInt(currentGame[j]);

			}

		}

		// We set up the season, setting each team's score to 0
		int[] score = { 0, 0, 0, 0 };

		// The following array is going to be used to establish which games have
		// been played and which have not

		HashMap<String, Integer> gamesPlayed = new HashMap<String, Integer>();

		// We will start with all games at null. If team A wins, it will be -1.
		// If team B wins, it will be 1
		gamesPlayed.put("1 2", null);
		gamesPlayed.put("1 3", null);
		gamesPlayed.put("1 4", null);
		gamesPlayed.put("2 3", null);
		gamesPlayed.put("2 4", null);
		gamesPlayed.put("3 4", null);

		for (int[] currentGame : games) {

			// We use an enhanced for loop here to go through each game and add
			// a score to each team that played

			// Now we pull from the game all of the values into variables to
			// make our code much more readable
			int teamA = currentGame[0];
			int teamB = currentGame[1];

			int scoreA = currentGame[2];
			int scoreB = currentGame[3];

			if (scoreA > scoreB) {

				// Team A won and we now identify what team that is and add a
				// points to their score

				score[teamA - 1] += 3;

				// We want to set the game in our array to -1

				gamesPlayed.replace(teamA + " " + teamB, -1);

			} else if (scoreA < scoreB) {

				// Team B won and we now identify what team that is and add a
				// points to their score

				score[teamB - 1] += 3;

				// We want to set the game in our array to 1

				gamesPlayed.replace(teamA + " " + teamB, 1);

			} else {

				// Its a tie and we identify which teams played and points to
				// both team's score

				score[teamA - 1]++;
				score[teamB - 1]++;

				// We want to set the game in our array to 0

				gamesPlayed.replace(teamA + " " + teamB, 0);

			}

		}

		// At this point, we have each teams score and we now need to find out
		// how many times our favorite team would win in all remaining variants

		//We now want to loop through each null game and see all the posibilities

		sc.close();

	}

}
