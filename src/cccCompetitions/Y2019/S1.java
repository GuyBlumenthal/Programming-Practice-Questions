package cccCompetitions.Y2019;

import java.util.Scanner;

public class S1 {

	static int tR;
	static int tL;
	static int bL;
	static int bR;

	public static void main(String[] args) {

		tL = 1;
		tR = 2;
		bL = 3;
		bR = 4;
		
		Scanner sc = new Scanner(System.in);
		
		char[] process = sc.nextLine().toCharArray();
		
		for (char c : process) {
			
			if (c == 'H') {
				horizontalFlip();
			} else if (c == 'V'){
				verticalFlip();
			}
			
		}
		
		System.out.println(tL + " " + tR);
		System.out.println(bL + " " + bR);
		
		sc.close();
		
	}

	public static void verticalFlip() {

		int topTemp = tL;
		int botTemp = bL;
		
		tL = tR;
		tR = topTemp;
		
		bL = bR;
		bR = botTemp;
		
	}

	public static void horizontalFlip() {

		int leftTemp = tL;
		int rightTemp = tR;
		
		tL = bL;
		bL = leftTemp;
		
		tR = bR;
		bR = rightTemp;
		
	}

}
