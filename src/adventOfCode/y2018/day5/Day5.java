package adventOfCode.y2018.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Day5 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(new File(
				"C:\\Users\\guybl\\git\\Programming-Practice-Questions\\src\\AdventOfCode\\y2018\\day5\\Day5Input")));

		char[] polymerInput = bf.readLine().toCharArray();

		ArrayList<Character> polymer = new ArrayList<Character>();

		for (int i = 0; i < polymerInput.length; i++) {
			polymer.add(polymerInput[i]);
		}

		char pastUnit = 1;

		boolean noChange = true;

		do {

			pastUnit = 0;
			noChange = true;

			for (int i = 0; i < polymer.size(); i++) {

				char curr = polymer.get(i);

				if (Math.abs(curr - pastUnit) == 32 && pastUnit != 0) {

					pastUnit = 0;
					noChange = false;
					polymer.remove(i - 1);
					polymer.remove(i - 1);
					break;

				} else {

					pastUnit = curr;

				}

			}

		} while (!noChange);

		System.out.print(polymer.size());

		bf.close();

	}
}
