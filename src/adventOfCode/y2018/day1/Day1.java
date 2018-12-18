package adventOfCode.y2018.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(
				new File("C:\\Users\\guybl\\git\\AdventOfCode\\src\\y2018\\day1\\Day1Input")));

		long frequency = 0;

		while (bf.ready()) {

			frequency += Long.parseLong(bf.readLine());

		}
		
		bf.close();
		System.out.println(frequency);

	}

}
