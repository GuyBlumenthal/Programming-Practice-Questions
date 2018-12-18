package adventOfCode.y2018.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2Plus {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(
				new File("C:\\Users\\guybl\\git\\AdventOfCode\\src\\y2018\\day2\\Day2Input")));

		ArrayList<char[]> ids = new ArrayList<char[]>();
		char[] thisId;

		while (bf.ready()) {

			thisId = bf.readLine().toCharArray();

			for (char[] chars : ids) {

				boolean close = true;
				int dissimilarElement = -1;

				for (int i = 0; i < thisId.length; i++) {

					if (thisId[i] != chars[i]) {

						if (close) {
							dissimilarElement = i;
							close = false;
						} else {
							dissimilarElement = -1;
							break;
						}

					}

				}

				if (dissimilarElement != -1) {

					for (int i = 0; i < thisId.length; i++) {
						if (i != dissimilarElement) {
							System.out.print(thisId[i]);
						}
					}

					bf.close();
					return;

				}

			}

			ids.add(thisId);

		}

		bf.close();

	}

}
