package projectEuler;

public class Problem7 {

	public static void main(String[] args) {

		int prime = 0;
		int curr = 1;
		
		while (prime != 10001) {
			
			curr++;

			if (isPrime(curr)) {
				prime++;
			}

		}

		System.out.println(curr);

	}

	public static boolean isPrime(int x) {

		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;

	}

}
