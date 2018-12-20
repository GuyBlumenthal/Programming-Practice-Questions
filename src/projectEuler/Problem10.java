package projectEuler;

public class Problem10 {

	public static void main(String[] args) {
		
		long sum = 0;
		
		for (long i = 2; i < 2 * Math.pow(10, 6); i++) {
			if (isPrime(i))
				sum += i;
		}
		
		System.out.println(sum);
		
	}
	
	public static boolean isPrime(long x) {

		for (long i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;

	}
	
}
