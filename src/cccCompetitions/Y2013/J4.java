package cccCompetitions.Y2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// We start inputting all of our information

		// We begin with the maximum amount of time that we have to complete our
		// chores
		int maxTime = Integer.parseInt(sc.nextLine());

		// Next, we get our amount of chores so that we know how many times to
		// scan the console
		int amountOfChores = Integer.parseInt(sc.nextLine());

		// Now we initialize our array that will hold all of the chores we need
		// to complete
		ArrayList<Integer> availableChores = new ArrayList<Integer>();

		// We are going to be looping for each amount of chores that we scanned
		// in earlier
		for (int i = 0; i < amountOfChores; i++) {

			// We are now adding all of the chores to our ArrayList
			availableChores.add(Integer.parseInt(sc.nextLine()));

		}

		// Now we sort the array in ascending order so the smallest numbers are
		// in the first indexes
		Collections.sort(availableChores);

		// We are about to start counting our chores so we need to keep a memory
		// of how much time has passed and how many chores we have completed.
		int currentTime = 0;
		int choreNumber = 0;

		// Now all we need to do is to loop through the array, starting at the
		// lowest numbers in the lowest indexes, and add their times to the
		// amount of time passed and increment the chores completed counter.
		// This way we ensure that we complete as many chores in as little time
		// as possible.
		for (int i = 0; i < availableChores.size(); i++) {

			if ((availableChores.get(i) + currentTime > maxTime) == false) {

				// The expression check if we pass our time limit if we were to
				// add this chore's time and if we don't, we bump up the time
				// and increment the chore counter
				currentTime += availableChores.get(i);
				choreNumber++;

			} else {

				// If we hit the max time, we break the loop because we know all
				// other numbers are either the same or larger and therefore
				// won't fit either into our time remaining
				break;

			}

		}

		//All that's left is to output our final chore number!		
		System.out.println(choreNumber);

		sc.close();

	}

}
