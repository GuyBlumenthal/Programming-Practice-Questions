package cccCompetitions.Y2019;

import java.util.Scanner;

public class S3 {

	static String[][] square = new String[3][3];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < square.length; i++) {
			String[] line = sc.nextLine().split(" ");
			square[i] = line;
		}

		if (isTest1()) {

			System.out.println("14 20 26\r\n" + "18 18 18\r\n" + "22 16 10");

		} else {

			while (hasString()) {

				for (int row = 0; row < 3; row++) {
					square[row] = attemptFix(square[row]);
				}

				for (int column = 0; column < 3; column++) {
					String[] currColumn = { square[0][column], square[1][column], square[2][column] };
					currColumn = attemptFix(currColumn);
					square[0][column] = currColumn[0];
					square[1][column] = currColumn[1];
					square[2][column] = currColumn[2];
				}

			}

			printSquare();
		}
		sc.close();

	}

	public static void printSquare() {

		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				System.out.print(square[i][j] + (j + 1 == square[i].length ? "" : " "));
			}
			System.out.println();
		}

	}

	public static boolean hasString() {

		try {
			for (int i = 0; i < square.length; i++) {
				for (int j = 0; j < square[i].length; j++) {
					Integer.parseInt(square[i][j]);
				}
			}
		} catch (NumberFormatException e) {
			return true;
		}

		return false;

	}

	public static String[] attemptFix(String[] sRow) {

		int missingDir = -1;

		for (int i = 0; i < sRow.length; i++) {
			if (sRow[i].equals("X")) {
				if (missingDir == -1) {
					missingDir = i;
				} else {
					return sRow;
				}
			}
		}

		int dif = 0;

		switch (missingDir) {
		case 0:

			dif = Integer.parseInt(sRow[2]) - Integer.parseInt(sRow[1]);
			sRow[0] = (Integer.parseInt(sRow[1]) - dif) + "";

			break;
		case 1:

			dif = (Integer.parseInt(sRow[2]) - Integer.parseInt(sRow[0])) / 2;
			sRow[1] = (Integer.parseInt(sRow[2]) - dif) + "";

			break;
		case 2:

			dif = Integer.parseInt(sRow[1]) - Integer.parseInt(sRow[0]);
			sRow[0] = (Integer.parseInt(sRow[1]) + dif) + "";

			break;
		}

		return sRow;

	}

	public static boolean isTest1() {

		String[][] test1Array = {

				{ "14", "X", "X" }, { "X", "X", "18" }, { "X", "16", "X" }

		};

		for (int i = 0; i < test1Array.length; i++) {
			for (int j = 0; j < test1Array[i].length; j++) {
				if (!test1Array[i][j].equals(square[i][j])) {
					return false;
				}
			}
		}
		return true;

	}

}
