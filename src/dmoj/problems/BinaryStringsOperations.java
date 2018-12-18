package dmoj.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryStringsOperations {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] in = sc.nextLine().split(" ");

		int q = Integer.parseInt(in[1]);

		LinkedList<String> binaryString = new LinkedList<String>(Arrays.asList(sc.nextLine().split("")));

		for (int loops = 0; loops < q; loops++) {

			in = sc.nextLine().split(" ");

			if (in[0].equals("1")) {
				binaryString = update(Integer.parseInt(in[1]), Integer.parseInt(in[2]), binaryString);
			} else if (in[0].equals("2")) {
				System.out.println(query(Integer.parseInt(in[1]), Integer.parseInt(in[2]), binaryString));
			}

		}

		sc.close();

	}

	public static LinkedList<String> update(int i, int l, LinkedList<String> binaryString) {

		LinkedList<String> preReverse = new LinkedList<String>(binaryString.subList(i, i + l));

		for (int j = 0; j < l; j++) {

			binaryString.set(j + i, preReverse.get(l - j -1));

		}

		return binaryString;

	}

	public static int query(int i, int l, LinkedList<String> binaryString) {

		LinkedList<String> subArray = new LinkedList<String>(binaryString.subList(i, i + l));
		
		int max = 0;
		int curr = 0;

		for (int j = 0; j < subArray.size(); j++) {

			if (subArray.get(j).equals("1")) {
				curr++;
				max = Math.max(curr, max);
			} else {
				curr = 0;
			}

		}

		return max;

	}

}
