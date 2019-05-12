package cccCompetitions.Y2019;

import java.util.Scanner;

public class S2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			
			int targetMean = sc.nextInt();
			
			int dist = 0;
			
			while (!isCorrect(targetMean, dist)) {
				dist++;
			}
			
			System.out.println((targetMean - dist) + " " + (targetMean + dist));
			
		}
		
		sc.close();

	}
	
	public static boolean isCorrect(int targetMean, int dist) {
		
		return isPrime(targetMean - dist) && isPrime(targetMean + dist);
		
	}
	
	public static boolean isPrime(int x) {

		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;

	}

}
