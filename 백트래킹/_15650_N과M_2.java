package 백트래킹;

import java.util.Scanner;

public class _15650_N과M_2 {

	private static int[] arr;
	private static boolean[] visited;
	private static int[] output;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		arr = new int[n];
		visited = new boolean[n];
		output = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		perm(0, n, m);

	}

	static void perm(int depth, int n, int r) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();

			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				output[depth] = i+1;
				if(depth == 0 || output[depth-1] < output[depth]) {
					perm(depth + 1, n, r);
				}
				visited[i] = false;					

			}

		}
	}
}
