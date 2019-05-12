package cccCompetitions.Y2011;

import java.util.Scanner;

public class S2 {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] studentAnswers = new String[sc.nextInt()];
		int count = 0;
		
		for (int i = 0; i < studentAnswers.length; i++) {
			studentAnswers[i] = sc.next();
		}
		
		for (int i = 0; i < studentAnswers.length; i++) {
			if (studentAnswers[i].equals(sc.next())) {
				count ++;
			}
		}
		
		System.out.println(count);
		
		sc.close();
		
	}
	
}
