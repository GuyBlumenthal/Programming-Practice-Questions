package cccCompetitions.Y2013;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// First we need to input the user's input, a String

		// Luckily we can utilize the fact that a String is actually an array of
		// Characters

		char[] inputLetters = sc.nextLine().toCharArray();

		// Now we will initialize the array with all of the valid characters on
		// the sign

		char[] validCharacters = { 'I', 'O', 'S', 'H', 'Z', 'X', 'N' };

		// Now we can just compare each letter to a predefined list of valid
		// Characters.

		// However, we are going to keep track if ANY character is invalid and
		// then use this letter

		boolean isWordValid = true;

		for (int i = 0; i < inputLetters.length; i++) {

			// This for loop goes through all of the Characters in the input
			// array

			for (int j = 0; j < validCharacters.length; j++) {

				// Now we have each inputLetter looping through each
				// validCharacter and seeing if it is valid

				if (!(inputLetters[i] == validCharacters[j])) {

					// If this character is invalid then we know the whole word
					// will be invalid

					isWordValid = false;

				}

			}

			if (!isWordValid) {

				// At this point, if we know the word is invalid there is no
				// reason to check the other characters and therefore we can
				// break the for loop

				break;

			}

		}

		// Now we're done so we can use a ternary operator to keep the printLine
		// method on one line instead of including an if/else statement
		
		System.out.println(isWordValid ? "YES" : "NO");

		sc.close();

	}

}
