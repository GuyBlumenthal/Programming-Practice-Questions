package adventOfCode.y2018.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1Plus {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(
				new File("C:\\Users\\guybl\\eclipse-workspace\\AdventOfCode\\src\\y2018\\day1\\Day1Input")));

		long frequency = 0;
		ArrayList<Long> visited = new ArrayList<Long>();

		while (bf.ready()) {

			if (visited.contains(frequency)) {
				System.out.println(frequency);
				bf.close();
				return;
			} else {

				visited.add(frequency);
				frequency += Long.parseLong(bf.readLine());

				if (!bf.ready()) {
					bf = new BufferedReader(new FileReader(new File(
							"C:\\Users\\guybl\\eclipse-workspace\\AdventOfCode\\src\\y2018\\day1\\Day1Input")));
				}

			}

		}

	}

}
