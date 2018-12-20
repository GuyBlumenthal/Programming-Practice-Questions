package projectEuler;

public class Problem9 {

	public static void main(String[] args) {
		
		for (int c = 0; c <= 998; c++) {
			
			for (int b = 0; b < c; b++) {
				
				for (int a = 0; a < b; a++) {
					
					if (a + b + c == 1000) {
						if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
							System.out.println(a * b * c);
						}
					}
					
				}
				
			}
			
		}
		
	}
	
}
