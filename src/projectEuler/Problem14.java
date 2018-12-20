package projectEuler;

import java.util.HashMap;

public class Problem14 {

	static HashMap<Integer, Integer> chains = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {

		int maxChain = 0;

		for (int i = 1; i <= 1000000; i++) {
			maxChain = Math.max(maxChain, chainLength(i));
		}
		
		System.out.println(maxChain);

	}

	public static int chainLength(int x) {

		if (x == 1) {
			return 1;
		} else if (x % 2 == 0) {
			chains.put(x, chainLength(x / 2) + 1);
			return chains.get(x);
		} else {
			chains.put(x, chainLength(3 * x + 1) + 1);
			return chains.get(x);
		}

	}

}
