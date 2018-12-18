package dmoj.contests.globeXCup18;

import java.util.Scanner;

public class MarkGambling {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		double[] marks = new double[n];
		double count = 0;
		double sum = 0;
		double average;

		String[] in = sc.nextLine().split(" ");
		
		for (int i = 0; i < marks.length; i++) {
			marks[i] = Double.parseDouble(in[i]);
			count++;
			sum += marks[i];
		}

		average = sum / count;

		double over = 0;

		for (double i : marks) {
			if (i > average) {
				over++;
			}
		}

		if (over > marks.length / 2) {
			System.out.print("Winnie should take the risk");
		} else {
			System.out.print("That's too risky");
		}

		sc.close();
		
	}

}
