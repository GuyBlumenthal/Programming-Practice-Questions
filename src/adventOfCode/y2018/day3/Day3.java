package adventOfCode.y2018.day3;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Day3 {

	static final int size = 1000;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new FileReader(
				new File("C:\\Users\\guybl\\git\\Programming-Practice-Questions\\src\\AdventOfCode\\y2018\\day3\\Day3Input")));

		String[] stPoint;
		String[] stDimension;

		Point point;
		Dimension dimension;

		boolean[][] cut = new boolean[size][size];
		boolean[][] counted = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cut[i][j] = false;
				counted[i][j] = false;
			}
		}

		while (sc.hasNextLine()) {

			sc.next();
			sc.next();
			stPoint = sc.next().split(",");
			stDimension = sc.next().split("x");

			point = new Point(Integer.parseInt(stPoint[0]),
					Integer.parseInt(stPoint[1].substring(0, stPoint[1].length() - 1)));

			dimension = new Dimension(Integer.parseInt(stDimension[0]), Integer.parseInt(stDimension[1]));

			for (int i = point.x; i < point.x + dimension.width; i++) {
			
				for (int j = point.y; j < point.y + dimension.height; j++) {
					
					if (cut[i][j]) {
						counted[i][j] = true;
					}
					
					cut[i][j] = true;
					
				}
				
			}
			
		}
		
		int cutSquares = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (counted[i][j]) {
					cutSquares++;
				}
			}
		}
		
		System.out.println(cutSquares);

		sc.close();

	}

}
