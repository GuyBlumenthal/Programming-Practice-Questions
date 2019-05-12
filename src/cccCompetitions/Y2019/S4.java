package cccCompetitions.Y2019;

import java.util.Scanner;

public class S4 {

	static int maxDaySize;
	static int targetDays;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numOfAttractions = sc.nextInt();
		maxDaySize = sc.nextInt();

		int[] attractions = new int[numOfAttractions];

		for (int i = 0; i < attractions.length; i++) {
			attractions[i] = sc.nextInt();
		}

		targetDays = (int) Math.ceil(((double) attractions.length) / ((double) (maxDaySize)));
		System.out.println((int) maxValue(1, attractions));

		sc.close();
		
	}

	public static double maxValue(int day, int[] attractionList) {

		if (attractionList.length <= maxDaySize) {
			return maxAttractionValue(attractionList);
		}
		
		double maxValue = 0;

		for (int i = 1; i <= maxDaySize; i++) {

			if ((minRemainingDays(attractionList.length - i) + day) <= targetDays) {
				
				double dayValue = getValueOfDayWithLength(i, attractionList) + maxValue(day + 1, truncatedAttractionList(attractionList, i));
				
				maxValue = Math.max(dayValue, maxValue);
				
			}

		}

		return maxValue;

	}
	
	public static double getValueOfDayWithLength(int i, int[] attractionList) {
		
		int[] dayList = new int[i];
		
		for (int j = 0; j < dayList.length; j++) {
			dayList[j] = attractionList [j];
		}
		
		return maxAttractionValue(dayList);
		
	}

	public static int[] truncatedAttractionList(int[] attractionList, int attractionsVisited) {

		int[] truncList = new int[attractionList.length - attractionsVisited];

		for (int i = 0; i < truncList.length; i++) {
			truncList[i] = attractionList[i + attractionsVisited];
		}

		return truncList;

	}

	public static int maxAttractionValue(int[] day) {

		int max = 0;

		for (int i = 0; i < day.length; i++) {
			max = Math.max(max, day[i]);
		}

		return max;
	}

	public static int minRemainingDays(int attractionListlength) {

		return (int) Math.ceil(((double) attractionListlength) / ((double) (maxDaySize)));

	}

}
