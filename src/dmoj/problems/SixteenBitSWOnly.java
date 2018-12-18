package dmoj.problems;

import java.util.Scanner;

public class SixteenBitSWOnly {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		String[] in;

		long a;
		long b;
		long p;

		for (int i = 0; i < n; i++) {

			in = sc.nextLine().split(" ");

			a = Long.parseLong(in[0]);
			b = Long.parseLong(in[1]);

			p = Long.parseLong(in[2]);

			if (a * b == p) {
				System.out.println("POSSIBLE DOUBLE SIGMA");
			} else {
				System.out.println("16 BIT S/W ONLY");
			}

		}
		
		sc.close();

	}

}
