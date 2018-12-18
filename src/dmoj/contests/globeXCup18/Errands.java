package dmoj.contests.globeXCup18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Errands {

	static TreeMap<Integer, ArrayList<Integer>> houseNeighbours;
	static Queue<Integer> houses = new LinkedList<Integer>();
	static TreeMap<Integer, Integer> houseDistance = new TreeMap<Integer, Integer>();
	static ArrayList<Integer> visited = new ArrayList<Integer>();

	static int N;
	static int M;
	static int Q;
	static int C;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		Q = sc.nextInt();
		C = sc.nextInt();

		houseNeighbours = new TreeMap<Integer, ArrayList<Integer>>();

		for (int i = 1; i <= N; i++) {

			houseNeighbours.put(i, new ArrayList<Integer>());

		}

		int u, v;
		Integer[] a = new Integer[1], b = new Integer[1];

		for (int i = 0; i < M; i++) {

			u = sc.nextInt();
			v = sc.nextInt();

			houseNeighbours.get(u).add(v);
			houseNeighbours.get(v).add(u);

		}

		for (int i = 0; i < Q; i++) {

			a[0] = sc.nextInt();
			b[0] = sc.nextInt();

			int aDistance = countRoute(Arrays.asList(a), 0);
			houses.clear();
			visited.clear();

			int bDistance = countRoute(Arrays.asList(b), 0);
			houses.clear();
			visited.clear();

			if (!(aDistance > N) && !(bDistance > N)) {
				System.out.println(aDistance + bDistance);
			} else {
				System.out.println("This is a scam!");
			}

		}

		sc.close();

	}

	public static int countRoute(List<Integer> x, int steps) throws StackOverflowError {

		List<Integer> l = new LinkedList<Integer>();

		if (x.contains(C)) {
			return steps;
		}

		for (int i : x) {

			for (int j : houseNeighbours.get(i)) {
				if (!l.contains(j) && !visited.contains(j)) {
					visited.add(j);
					l.add(j);
				}

			}

		}

		if (l.size() == 0) {
			return N + 1;
		} else {
			return countRoute(l, steps + 1);
		}
	}

	public static boolean isCloser(int x, int steps) {

		if (houseDistance.containsKey(x)) {
			if (houseDistance.get(x) < steps) {
				return false;
			}
		}

		return true;

	}

}
