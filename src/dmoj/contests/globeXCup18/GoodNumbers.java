package dmoj.contests.globeXCup18;

import java.util.Scanner;

public class GoodNumbers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		int goodNumbers = 0;
		String nextString;

		for (int i = 0; i < n; i++) {

			nextString = sc.nextLine();

			if (isPrime(Integer.parseInt(nextString)) && isPrime(sumOfNum(nextString))) {

				goodNumbers++;

			}

		}

		System.out.print(goodNumbers);

		sc.close();

	}

	public static int sumOfNum(String num) {

		String[] digits = num.split("");

		int sumOfNum = 0;

		for (String s : digits) {

			sumOfNum += Integer.parseInt(s);

		}

		return sumOfNum;

	}

	public static boolean isPrime(int p) {

		for (int i = 2; i <= Math.sqrt(p); i++) {

			if ((p % i) == 0) {
				return false;
			}

		}

		return true;

	}

}
