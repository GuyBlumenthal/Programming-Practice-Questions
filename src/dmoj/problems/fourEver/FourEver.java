package dmoj.problems.fourEver;

import java.util.HashMap;
import java.util.Scanner;

public class FourEver {

	static HashMap<Integer, String> lengthOfNumber = new HashMap<Integer, String>();

	static String[] numbers = { "1 = one	11 = eleven	30 = thirty", "2 = two	12 = twelve	40 = forty",
			"3 = three	13 = thirteen	50 = fifty", "4 = four	14 = fourteen	60 = sixty",
			"5 = five	15 = fifteen	70 = seventy", "6 = six	16 = sixteen	80 = eighty",
			"7 = seven	17 = seventeen	90 = ninety", "8 = eight	18 = eighteen", "9 = nine	19 = nineteen",
			"10 = ten	20 = twenty" };

	public static void main(String[] args) {

		initArray();

		Scanner sc = new Scanner(System.in);
		int select = Integer.parseInt(sc.nextLine());

		while (select != -1) {

			select = createWordFrom(select).length();
			System.out.println(select);

			if (select == 4) {
				select = -1;
			}
		}

		sc.close();

	}

	public static String createWordFrom(int num) {

		String sNum = Integer.toString(num);

		if (sNum.length() > 3) {
			return createWordFrom(Integer.parseInt(sNum.substring(0, sNum.length() - 3)), 1)
					+ createWordFrom(Integer.parseInt(sNum.substring(sNum.length() - 3)));
		} else {
			return createWordForHundreds(num);
		}

	}

	public static String createWordFrom(int num, int counter) {

		String sNum = Integer.toString(num);

		if (sNum.length() > 3) {
			return createWordFrom(Integer.parseInt(sNum.substring(0, sNum.length() - 3)), counter + 1)
					+ createWordFrom(Integer.parseInt(sNum.substring(sNum.length() - 3)), counter);
		} else {
			String result = createWordForHundreds(num);
			if (result.length() == 0) {
				return "";
			}
			return result + getSuffix(counter);
		}

	}

	public static String createWordForHundreds(int num) {

		if (lengthOfNumber.containsKey(num)) {
			return lengthOfNumber.get(num);
		}

		String sNum = Integer.toString(num);

		String result = "";

		if (sNum.length() >= 3) {
			result += lengthOfNumber.get(Integer.parseInt(sNum.substring(0, 1))) + "hundred";
		}

		if (lengthOfNumber.containsKey(num - Integer.parseInt(sNum.substring(0, 1)) * 100)) {
			result += lengthOfNumber.get(num - Integer.parseInt(sNum.substring(0, 1)) * 100);
		} else if (num - Integer.parseInt(sNum.substring(0, 1)) * 100 != 0){

			if (sNum.length() >= 2) {
				result += lengthOfNumber
						.get(10 * Integer.parseInt(sNum.substring(sNum.length() - 2, sNum.length() - 1)));
			}

			if (Integer.parseInt(sNum.substring(sNum.length() - 1)) != 0)
				result += lengthOfNumber.get(Integer.parseInt(sNum.substring(sNum.length() - 1)));
		}

		return result;

	}

	public static String getSuffix(int counter) {

		switch (counter) {

		case 1:
			return "thousand";
		case 2:
			return "million";
		case 3:
			return "billion";

		}

		return "";

	}

	public static int findMaxNumberFitting(int num) {

		int max = 0;

		for (int i : lengthOfNumber.keySet()) {

			if (num - i >= 0) {
				max = Math.max(max, i);
			}

		}

		return max;

	}

	public static void initArray() {

		String[] in;
		String[] curr;

		for (int i = 0; i < numbers.length; i++) {
			in = numbers[i].split("	");

			for (int j = 0; j < in.length; j++) {

				curr = in[j].split(" = ");

				lengthOfNumber.put(Integer.parseInt(curr[0].replaceAll(" ", "")), curr[1]);

			}

		}

	}

}
