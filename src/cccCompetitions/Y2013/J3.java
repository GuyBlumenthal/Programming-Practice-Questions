package cccCompetitions.Y2013;

import java.util.ArrayList;
import java.util.Scanner;

public class J3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// We are going to input the starting year from the console and
		// immediately parse it as an Integer to remove the need for another
		// line of code

		int currentYear = Integer.parseInt(sc.nextLine());

		// We also store what our next unique year is going to be.
		// We initialize with -1 because we know that we will never reach the
		// year -1

		int finalYear = -1;

		// We are going to keep track of whether or not we have found a unique
		// year, for use in the while loop
		boolean isUnique = false;

		// We are going to loop as long as we haven't found a unique year yet
		// Also, this list is going to be our way of keeping track of what
		// numbers the year contains
		ArrayList<Character> yearNumbers = new ArrayList<Character>();

		// We want to start with a year above the current number so that if the
		// year they give us is a unique year, we don't count it

		currentYear++;

		while (isUnique == false) {

			// This is the code that identifies whether the number is unique

			char[] individualYearNums = Integer.toString(currentYear).toCharArray();

			// We start by assuming that the number is going to be unique
			isUnique = true;

			for (int i = 0; i < individualYearNums.length; i++) {

				// Now we loop through each character/number in the year

				if (!yearNumbers.contains(individualYearNums[i])) {

					// If our List does not contain the number, we add the
					// number and continue

					yearNumbers.add(individualYearNums[i]);
					continue;

				} else {

					// If it does contain it, we know that we don't have a
					// unique number

					isUnique = false;

					break;

				}

			}

			if (isUnique) {

				// If our year is unique we know that we have found our final
				// year and we break the loop

				finalYear = currentYear;
				break;

			}

			// Now we increment and clear our year number list
			currentYear++;					
			yearNumbers.clear();

		}

		// At this point, we output the final year to the user
		System.out.println(finalYear);

		sc.close();

	}

}
