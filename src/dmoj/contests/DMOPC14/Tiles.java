package dmoj.contests.DMOPC14;

import java.util.Scanner;

public class Tiles {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		String[] in = sc.nextLine().split(" ");

		int w = Integer.parseInt(in[0]);
		int l = Integer.parseInt(in[1]);
		
		int t = Integer.parseInt(sc.nextLine());
		
		sc.close();
		System.out.println(Math.floorDiv(w, t) * Math.floorDiv(l, t));
		
	}
	
}
