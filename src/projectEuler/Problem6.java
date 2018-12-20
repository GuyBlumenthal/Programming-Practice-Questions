package projectEuler;

public class Problem6 {

	public static void main(String[] args) {
		
		int sum = 0;
		int squareSum = 0;
		
		for (int i = 1; i <= 100; i ++) {
			
			sum += i;
			squareSum += Math.pow(i, 2);
			
		}
		
		int sumSquare = (int) Math.pow(sum, 2);
		
		System.out.println(sumSquare - squareSum);
		
		
		
	}
	
}
