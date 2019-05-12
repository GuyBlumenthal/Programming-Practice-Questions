package cccCompetitions.Y2019;

import java.util.ArrayList;
import java.util.Scanner;

public class S5 {

	static int maxNum = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] s1 = sc.nextLine().split(" ");
		
		int triangleSize = Integer.parseInt(s1[0]);
		int subTriangleSize = Integer.parseInt(s1[1]);
		
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < triangleSize; i++) {
			
			String[] currInput = sc.nextLine().split(" ");
			
			ArrayList<Integer> row = new ArrayList<Integer>();
			
			for (String s : currInput) {
				row.add(Integer.parseInt(s));
				maxNum = Math.max(maxNum, Integer.parseInt(s));
			}
			
			triangle.add(row);
			
		}

		int sum = 0;
		int[] subElements = new int[triangleSize(subTriangleSize)];

		for (int startingRow = 0; startingRow <= triangle.size() - subTriangleSize; startingRow++) {

			for (int startingPosition = 0; startingPosition < triangle.get(startingRow).size(); startingPosition++) {

				int index = 0;
				
				for (int lookUpRow = startingRow; lookUpRow < startingRow + subTriangleSize; lookUpRow++) {

					for (int lookUpPosition = startingPosition; lookUpPosition <= startingPosition
							+ (lookUpRow - startingRow); lookUpPosition++) {
						subElements[index] = triangle.get(lookUpRow).get(lookUpPosition);
						index ++;
					}

				}
				
				int maxElement = maxArrayElement(subElements);
				sum += maxElement;

			}

		}

		System.out.println(sum);
		
		sc.close();

	}
	
	public static int maxArrayElement(int[] day) {

		int max = 0;

		for (int i = 0; i < day.length; i++) {
			if (day[i] == maxNum) {
				return day[i];
			}
			max = Math.max(max, day[i]);
		}

		return max;
	}

	public static int triangleSize(int subSize) {
		int sum = 0;
		for (int i = 1; i <= subSize; i++) {
			sum += i;
		}
		return sum;
	}

}
