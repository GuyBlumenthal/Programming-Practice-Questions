package dmoj.contests.globeXCup18;

import java.util.Scanner;

public class RoundingErrors {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		int up = 0;
		int down = 0;

		double num = 0;
		
		for (int i = 0; i < n; i++) {
			
			num = Double.parseDouble(sc.nextLine());
			
			if (Math.round(num) > num) {
				up ++;
			} else {
				down++;
			}
			
		}
		
		sc.close();
		System.out.println(up);
		System.out.println(down);
		
	}

}
