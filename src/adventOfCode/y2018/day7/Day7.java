package adventOfCode.y2018.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day7 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(new File(
				"C:\\Users\\guybl\\git\\Programming-Practice-Questions\\src\\AdventOfCode\\y2018\\day7\\Day7Input")));

		int[] dependanciesPerLetter = new int[26];
		ArrayList<ArrayList<Character>> relienciesPerLetter = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> order = new ArrayList<Character>();

		for (int i = 0; i < dependanciesPerLetter.length; i++) {
			dependanciesPerLetter[i] = 0;
			relienciesPerLetter.add(i, new ArrayList<Character>());
		}

		String[] in;
		int pre;
		int post;

		while (bf.ready()) {

			in = bf.readLine().split(" ");

			pre = in[1].toCharArray()[0];
			post = in[7].toCharArray()[0];

			dependanciesPerLetter[post - 65]++;
			relienciesPerLetter.get(pre - 65).add((char) post);

		}

		for (int i = 0; i < relienciesPerLetter.size(); i++) {

			ArrayList<Character> c = relienciesPerLetter.get(i);

			System.out.print((char) (i + 65) + " (" + dependanciesPerLetter[i] + ") --> ");

			for (char cx : c) {
				System.out.print(cx);
				if (c.indexOf(cx) != c.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();

		}

		boolean isFinished = false;

		while (!isFinished) {

			for (int i = 0; i < dependanciesPerLetter.length; i++) {

				if (dependanciesPerLetter[i] == 0) {
					order.add((char) (i + 65));
					dependanciesPerLetter[i] = -1;
					for (char c : relienciesPerLetter.get(i)) {
						dependanciesPerLetter[c - 65]--;
					}
					break;
				}

			}
			isFinished = true;
			for (int i = 0; i < dependanciesPerLetter.length; i++) {
				if (dependanciesPerLetter[i] != -1) {
					isFinished = false;
				}
			}

		}

		for (int i = 0; i < order.size(); i++) {
			System.out.print(order.get(i));
		}

		bf.close();

	}

}
