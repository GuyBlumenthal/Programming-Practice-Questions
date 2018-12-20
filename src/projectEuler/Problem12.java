package projectEuler;

public class Problem12 {

	public static void main(String[] args) {

		int curr = 1;
		int naturalNumber = 2;
		
		while (!(numberOfDivisors(curr) > 500)) {
			
			curr += naturalNumber;
			naturalNumber++;
			
		}
		
		System.out.println(curr);

	}

	public static int numberOfDivisors(int x) {

		int numOfDivisors = 0;

		for (int i = 1; i <= Math.sqrt(x); i++) {

			if (x % i == 0) {
				numOfDivisors++;

				if (i != Math.sqrt(x)) {
					numOfDivisors++;
				}
			}

		}

		return numOfDivisors;

	}

}
