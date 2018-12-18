package adventOfCode.y2018.day3;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day3Plus {

	static final int size = 1000;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new FileReader(
				new File("C:\\Users\\guybl\\git\\Programming-Practice-Questions\\src\\AdventOfCode\\y2018\\day3\\Day3Input")));

		int id;
		String[] stPoint;
		String[] stDimension;

		Point point;
		Dimension dimension;

		HashMap<Point, Integer> cut = new HashMap<Point, Integer>();
		ArrayList<String> goodIds = new ArrayList<String>();

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {

				cut.put(new Point(i, j), 0);

			}

		}

		for (int i = 1; i <= 1373; i++) {
			goodIds.add(i + "");
		}

		while (sc.hasNextLine()) {

			id = Integer.parseInt(sc.next().substring(1));
			sc.next();
			stPoint = sc.next().split(",");
			stDimension = sc.next().split("x");

			point = new Point(Integer.parseInt(stPoint[0]),
					Integer.parseInt(stPoint[1].substring(0, stPoint[1].length() - 1)));

			dimension = new Dimension(Integer.parseInt(stDimension[0]), Integer.parseInt(stDimension[1]));

			for (int i = point.x; i < point.x + dimension.width; i++) {

				for (int j = point.y; j < point.y + dimension.height; j++) {

					int cutSquare = cut.get(new Point(i, j));

					if (cutSquare == 0) {
						cut.put(new Point(i, j), id);
					} else {
						goodIds.remove(id + "");
						goodIds.remove(cutSquare + "");
					}

				}

			}

		}

		System.out.println(goodIds.toArray()[0]);
		sc.close();

	}

}
