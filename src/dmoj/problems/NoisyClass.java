package dmoj.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class NoisyClass {

	static TreeMap<Integer, ArrayList<Integer>> noisyStudents = new TreeMap<Integer, ArrayList<Integer>>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numOfStudents = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= numOfStudents; i++) {

			noisyStudents.put(i, new ArrayList<Integer>());

		}

		int connections = Integer.parseInt(sc.nextLine());
		String[] incomingConnection;

		for (int i = 0; i < connections; i++) {

			incomingConnection = sc.nextLine().split(" ");

			ArrayList<Integer> curr = noisyStudents.get(Integer.parseInt(incomingConnection[0]));

			curr.add(Integer.parseInt(incomingConnection[1]));

			noisyStudents.put(Integer.parseInt(incomingConnection[0]), curr);

		}

		while (noisyStudents.size() != 0) {

			if (!removeUndistractedChildren()) {
				break;

			}

		}

		if (noisyStudents.size() != 0) {
			System.out.println("N");
		} else {
			System.out.println("Y");
		}

		sc.close();

	}

	public static boolean removeUndistractedChildren() {

		boolean removed = false;
		List<Integer> students = new ArrayList<Integer>();
		students.addAll(noisyStudents.keySet());

		for (int student : students) {

			if (!isDistracted(student)) {
				noisyStudents.remove(student);
				removed = true;
			}

		}

		return removed;

	}

	public static boolean isDistracted(int student) {

		for (ArrayList<Integer> curr : noisyStudents.values()) {

			if (curr.contains(student)) {
				return true;
			}

		}

		return false;

	}

}
