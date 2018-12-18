package dmoj.contests.globeXCup18;

import java.util.Scanner;

public class MagicalFunctions {

	static long a, b, c, d, e;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] in = sc.nextLine().split(" ");

		a = Integer.parseInt(in[0]);
		b = Integer.parseInt(in[1]);
		c = Integer.parseInt(in[2]);
		d = Integer.parseInt(in[3]);
		e = Integer.parseInt(in[4]);

		long x = Integer.parseInt(in[5]);

		System.out.println(Math.round(f(x) % (Math.pow(10, 9) + 7)));
		
		sc.close();

	}

	public static double f(long x) {

		if (x == 0) {
			return e;
		} else {

			return a * f(Math.floorDiv(x, b)) + c * f(Math.floorDiv(x, d));

		}

	}

}
