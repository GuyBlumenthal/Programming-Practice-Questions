package cccCompetitions.Y2013;

import java.util.Scanner;

public class J1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// First we have to scan for the ages of the two youngest children at
		// which point we can parse the strings as Integers
		int youngestChild = Integer.parseInt(sc.nextLine());
		int middleChild = Integer.parseInt(sc.nextLine());

		// Now, we need to identify the pattern from the two children

		int agePattern = middleChild - youngestChild;

		// To get the age of the oldest child all we have to do is age the age
		// pattern to the middle child's age

		int oldestChild = middleChild + agePattern;

		// We're done! All we have to do is just print out our answer

		System.out.println(oldestChild); // The method automatically converts
											// our Integer to a String luckily

		sc.close();

	}

}
