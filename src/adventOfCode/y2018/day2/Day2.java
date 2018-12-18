package adventOfCode.y2018.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(
				new File("C:\\Users\\guybl\\eclipse-workspace\\AdventOfCode\\src\\y2018\\day2\\Day2Input")));

		int a = 0;
		int b = 0;

		while (bf.ready()) {

			switch (checkLetters(bf.readLine())) {

			case NONE:
				break;
			case TWO:
				a++;
				break;
			case THREE:
				b++;
				break;
			case BOTH:
				a++;
				b++;
				break;

			}

		}

		System.out.println(a * b);

		bf.close();

	}

	public static CheckSumAddition checkLetters(String id) {

		int[] lettersFound = new int[26];

		for (int i = 0; i < lettersFound.length; i++) {
			lettersFound[i] = 0;
		}

		char[] characters = id.toCharArray();
		int curr;

		for (char c : characters) {

			curr = c - 97;
			lettersFound[curr]++;

		}

		CheckSumAddition result = CheckSumAddition.NONE;

		for (int i : lettersFound) {

			if (i == 3) {

				if (result == CheckSumAddition.NONE) {
					result = CheckSumAddition.THREE;
				} else if (result == CheckSumAddition.TWO) {
					return CheckSumAddition.BOTH;
				}

			} else if (i == 2) {

				if (result == CheckSumAddition.NONE) {
					result = CheckSumAddition.TWO;
				} else if (result == CheckSumAddition.THREE) {
					return CheckSumAddition.BOTH;
				}

			}

		}

		return result;

	}

	public static enum CheckSumAddition {
		NONE, TWO, THREE, BOTH;
	}

}
