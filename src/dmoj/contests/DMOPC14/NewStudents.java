package dmoj.contests.DMOPC14;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NewStudents {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int i = Integer.parseInt(sc.nextLine());

		int sum = 0;
		int students = 0;

		for (int j = 0; j < i; j++) {

			sum += Integer.parseInt(sc.nextLine());
			students++;

		}
		
		int s = Integer.parseInt(sc.nextLine());
		
		for (int j = 0; j < s; j++) {
			
			students++;
			sum += Integer.parseInt(sc.nextLine());
			DecimalFormat df = new DecimalFormat("###.000");	
			System.out.println(df.format(Math.round(sum / (students * 1.0) * 1000) / 1000.0));
			
		}
		
		sc.close();

	}

}
