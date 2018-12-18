package dmoj.contests.DMOPC14;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PerfectTiming {

	public static void main(String[] args) {

		GregorianCalendar c = new GregorianCalendar();
		Scanner sc = new Scanner(System.in);

		String[] in = sc.nextLine().split(" ");

		Point start = new Point(Integer.parseInt(in[0]), Integer.parseInt(in[1]));

		in = sc.nextLine().split(" ");

		Point end = new Point(Integer.parseInt(in[0]), Integer.parseInt(in[1]));

		String[] inDate = sc.nextLine().split(":");

		int distance = (Math.abs(start.x - end.x)) + (Math.abs(start.y - end.y));

		c.set(Calendar.YEAR, Integer.parseInt(inDate[0]));
		c.set(Calendar.MONTH, Integer.parseInt(inDate[1]));
		c.set(Calendar.DATE, Integer.parseInt(inDate[2]));
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(inDate[3]));
		c.set(Calendar.MINUTE, Integer.parseInt(inDate[4]));
		c.set(Calendar.SECOND, Integer.parseInt(inDate[5]));

		c.add(Calendar.SECOND, distance);

		DecimalFormat df = new DecimalFormat("00");

		if ((c.get(Calendar.MONTH) == Calendar.FEBRUARY) && (c.get(Calendar.DATE) == 29) && !(c.getActualMaximum(Calendar.DAY_OF_YEAR) > 365)) {
			System.out.println("What?");
		}
		
		System.out.printf("%s:%s:%s:%s:%s:%s", c.get(Calendar.YEAR), df.format(c.get(Calendar.MONTH)),
				df.format(c.get(Calendar.DATE)), df.format(c.get(Calendar.HOUR_OF_DAY)),
				df.format(c.get(Calendar.MINUTE)), df.format(c.get(Calendar.SECOND)));

		sc.close();
	}

	private static class Point {

		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
