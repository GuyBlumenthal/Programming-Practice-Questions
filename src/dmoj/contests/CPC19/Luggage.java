package dmoj.contests.CPC19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Luggage {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] luggageHeights = Arrays.stream(in.readLine().split(" "))
				.mapToInt((str) -> Integer.parseInt(str))
				.toArray();
		
		st.nextToken();
		int maxHeightDiff = Integer.parseInt(st.nextToken());
		int maxLuggCount = 1;

		for (int i = 0; i < luggageHeights.length; i++) {
			maxLuggCount = Math.max(maxLuggCount, getMaxDiff(luggageHeights[i], luggageHeights, maxHeightDiff));
		}
		
		System.out.print(maxLuggCount);
		in.close();
		
	}
	
	public static int getMaxDiff(int selectedHeight, int[] allHeights, int maxTotalHeightDiff) {
		
		int count = 0;
		
		for (int i = 0; i < allHeights.length; i++) {
			int thisDiff = selectedHeight - allHeights[i];
			if (thisDiff >= 0) {
				if (thisDiff <= maxTotalHeightDiff) {
					count++;
				}
			}
		}
		
		return count;
	}
	
}
