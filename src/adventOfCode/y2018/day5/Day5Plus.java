package adventOfCode.y2018.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Day5Plus {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(new File(
				"C:\\Users\\guybl\\git\\Programming-Practice-Questions\\src\\AdventOfCode\\y2018\\day5\\Day5Input")));

		char[] polymerInput = bf.readLine().toCharArray();

		ArrayList<Character> originalPolymer = new ArrayList<Character>();

		for (int i = 0; i < polymerInput.length; i++) {
			originalPolymer.add(polymerInput[i]);
		}

		ArrayList<Character> shortendPolymer = new ArrayList<Character>();
		
		int minLength = originalPolymer.size();
		
		for (int i = 0; i < 26; i++) {

			for (char c : originalPolymer) {
				
				if (!(c - 'A' == i || c - 'a' == i)) {
					shortendPolymer.add(c);
				}
				
				
			}
			
			minLength = Math.min(minLength, getLengthOfPolymer(shortendPolymer));
			shortendPolymer.clear();
		}
		
		System.out.println(minLength);

		bf.close();

	}

	public static int getLengthOfPolymer(ArrayList<Character> polymer) {

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

		return polymer.size();

	}

}
