package dmoj.problems;

import java.util.Scanner;
import java.util.TreeMap;

public class BankNotes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		String[] in1 = sc.nextLine().split(" ");
		String[] in2 = sc.nextLine().split(" ");

		
		
		TreeMap<Integer, Integer> bankNotes = new TreeMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			try {
				bankNotes.put(Integer.parseInt(in1[i]), Integer.parseInt(in2[i]));
			} catch (Exception e) {

			}
		}

		int balance = Integer.parseInt(sc.nextLine());
		int notesUsed = 0;
		Pair<Integer, Integer> highestNote;

		while (balance != 0) {

			highestNote = maxNote(bankNotes);

			if (balance - highestNote.left >= 0) {

				balance -= highestNote.left;

				if (highestNote.right == 1) {
					bankNotes.remove(highestNote.left);
				} else {
					bankNotes.put(highestNote.left, highestNote.right - 1);
				}
				notesUsed++;
			} else {
				bankNotes.remove(highestNote.left);
			}

		}

		System.out.println(notesUsed);

		sc.close();

	}

	public static Pair<Integer, Integer> maxNote(TreeMap<Integer, Integer> notes) {

		int max = 0;

		for (int note : notes.keySet()) {

			max = Math.max(note, max);

		}

		return new Pair<Integer, Integer>(max, notes.get(max));

	}

	public static class Pair<L, R> {

		public final L left;
		public final R right;

		public Pair(L left, R right) {
			this.left = left;
			this.right = right;
		}

	}

}
