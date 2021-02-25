package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class _15649_N과M_SWAP {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		boolean[] visited = new boolean[n];
		int[] output = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		perm(arr, output, visited, 0, n, m);

	}

	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			for (int i = 0; i < depth; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

//	static void perm_swap(int[] arr, int depth, int n, int r) {
//
//		if (depth == r) {
//			for (int i = 0; i < r; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
//			return;
//		}
//
//		for (int i = depth; i < n; i++) {
//
//			swap(arr, depth, i);
//			perm_swap(arr, depth + 1, n, r);
//			swap(arr, depth, i);
//		}
//
//	}
//
//	static void swap(int[] arr, int depth, int i) {
//
//		int temp = arr[depth];
//		arr[depth] = arr[i];
//		arr[i] = temp;
//	}
}
