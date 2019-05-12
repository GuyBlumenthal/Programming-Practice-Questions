package projectEuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Problem5 {

	public static void main(String[] args) {

		HashMap<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();

		for (int i = 1; i <= 20; i++) {

			ArrayList<Integer> factors = findPrimeFactors(i);

			int[] currFactors = new int[Collections.max(factors) + 1];

			for (int j = 0; j < currFactors.length; j++) {
				currFactors[j] = 0;
			}

			for (int j : factors) {

				currFactors[j]++;

			}

			for (int j = 0; j < currFactors.length; j++) {
				if (currFactors[j] != 0) {
					try {
						primeFactors.put(j, Math.max(currFactors[j], primeFactors.get(j)));
					} catch (NullPointerException e) {
						primeFactors.put(j, currFactors[j]);
					}
				}
			}

		}

		long product = 1;
		
		for (int i : primeFactors.keySet()) {
			product *= Math.pow(i, primeFactors.get(i));
		}
		
		System.out.println(product);

	}

	public static ArrayList<Integer> findPrimeFactors(int x) {

		ArrayList<Integer> factors = new ArrayList<Integer>();

		factors.add(x);

		for (int i = 0; i < factors.size(); i++) {

			int num = factors.get(i);

			boolean isPrime = true;
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					isPrime = false;
					factors.add(j);
					factors.add(num / j);
					break;
				}
			}

			if (!isPrime) {
				factors.remove(i);
				i--;
			}

		}

		return factors;

	}

}
