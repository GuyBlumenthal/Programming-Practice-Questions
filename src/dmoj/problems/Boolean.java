package dmoj.problems;

import java.util.Scanner;

public class Boolean {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] nots = sc.nextLine().split(" ");
		
		boolean initState = nots[nots.length - 1].equals("True");
		
		if (nots.length % 2 == 0) {
			System.out.println(initState ? "False" : "True");
		} else {
			System.out.println(initState ? "True" : "False");
		}
		
		sc.close();
		
	}
	
}
