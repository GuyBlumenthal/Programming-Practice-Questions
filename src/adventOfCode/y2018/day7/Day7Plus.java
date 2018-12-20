package adventOfCode.y2018.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day7Plus {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(new File(
				"C:\\Users\\guybl\\git\\Programming-Practice-Questions\\src\\AdventOfCode\\y2018\\day7\\Day7Input")));

		int[] dependanciesPerLetter = new int[26];
		ArrayList<ArrayList<Character>> relienciesPerLetter = new ArrayList<ArrayList<Character>>();
		Elf[] elves = new Elf[5];
		int time = 0;

		for (int i = 0; i < dependanciesPerLetter.length; i++) {
			dependanciesPerLetter[i] = 0;
			relienciesPerLetter.add(i, new ArrayList<Character>());
		}

		for (int i = 0; i < elves.length; i++) {
			elves[i] = new Elf();
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

			for (int i = 0; i < elves.length; i++) {

				if (!elves[i].isWorking()) {

					try {
						dependanciesPerLetter[elves[i].pickLetter(dependanciesPerLetter)] = -1;
					} catch (ArrayIndexOutOfBoundsException e) {

					}
				}

			}

			for (int i = 0; i < elves.length; i++) {
				if (elves[i].work()) {
					char finishedLetter = elves[i].getLetter();
					for (char c : relienciesPerLetter.get(finishedLetter - 65)) {
						dependanciesPerLetter[c - 65]--;
					}

				}
			}

			for (int i = 0; i < elves.length; i++) {

				if (!elves[i].isWorking()) {

					try {
						dependanciesPerLetter[elves[i].pickLetter(dependanciesPerLetter)] = -1;
					} catch (ArrayIndexOutOfBoundsException e) {

					}
				}

			}

			isFinished = true;
			for (int i = 0; i < elves.length; i++) {
				if (elves[i].isWorking() == true) {
					isFinished = false;
				}
			}

			time++;

			System.out.println("Current Time: " + time);

			for (int i = 0; i < elves.length; i++) {
				System.out.println("Elf " + i + " - " + elves[i].letterWorkingOn);
			}

		}

		System.out.println(time);

		bf.close();

	}

	public static class Elf {

		public char letterWorkingOn;
		public int duration;

		public Elf() {

		}

		public void giveLetter(char c) {

			letterWorkingOn = c;
			duration = 60 + (c - 64);

		}

		public boolean work() {

			duration--;
			if (duration == 0) {
				return true;
			} else {
				return false;
			}

		}

		public char getLetter() {
			char temp = letterWorkingOn;
			letterWorkingOn = 0;
			return temp;
		}

		public int pickLetter(int[] dependanciesPerLetter) {

			if (duration <= 0) {
				for (int i = 0; i < dependanciesPerLetter.length; i++) {

					if (dependanciesPerLetter[i] == 0) {

						giveLetter((char) (i + 65));
						return i;
					}

				}
			}

			return -1;

		}

		public boolean isWorking() {
			return duration > 0;
		}

	}

}
