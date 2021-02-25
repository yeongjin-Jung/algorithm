package 백트래킹;

import java.util.Scanner;

public class _15649_N과M {

	private static int[] arr;
	private static int[] result;
	private static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		arr = new int[n];
		result = new int[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		perm(0, n, m);
		
		permutation(0,n, m);

	}

	static void perm(int depth, int n, int r) {

		if (depth == r) {
			for (int i = 0; i < depth; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				result[depth] = arr[i];
				perm(depth + 1, n, r);
				visited[i] = false;
			}
		}

	}
	
	
	static void permutation(int depth , int n , int r) {
		if(depth ==r) {
			for (int i = 0; i < depth; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, depth , i);
			permutation(depth+1, n, r);
			swap(arr, depth , i);
		}
	}
	
	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
	

}
