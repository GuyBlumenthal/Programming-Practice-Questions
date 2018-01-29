package projectEuler;

import java.util.ArrayList;

/**
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 */
public class Problem3 {

	public static void main(String[] args) {

		ArrayList<Long> factors = new ArrayList<Long>();

		factors.add(600851475143l);

		for (int i = 0; i < factors.size(); i++) {

			long num = factors.get(i);

			boolean isPrime = true;

			for (long j = 2; j <= Math.sqrt(num); j++) {

				if (num % j == 0) {
					isPrime = false;
					factors.add(j);
					factors.add(num / j);
				}

			}

			if (isPrime == false) {
				i--;
				factors.remove(num);
			}

		}

		long max = 0l;
		
		for (Object o : factors.toArray()) {

			if (max < (long) o) {
				max = (long) o;
			}
			
		}
		
		System.out.println(max);

	}

}
