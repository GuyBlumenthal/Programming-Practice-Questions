package projectEuler;

/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {

	public static void main(String[] args) {

		int num = 0;

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {

				if (isPalindrome(i * j) && i * j > num) {
					num = i * j;
				}

			}
		}

		System.out.println(num);

	}

	public static boolean isPalindrome(int number) {

		String[] stringNum = Integer.toString(number).split("");

		boolean isPalindrome = true;

		for (int i = 0; i < stringNum.length; i++) {

			if (!stringNum[i].equals(stringNum[stringNum.length - (i + 1)])) {
				isPalindrome = false;
			}

		}

		return isPalindrome;

	}

}
