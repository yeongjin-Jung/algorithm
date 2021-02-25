package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2606_바이러스 {

	private static int n, cnt;
	private static int ssang;
	private static int[][] map;
	private static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		ssang = sc.nextInt();

		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= ssang; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			map[v1][v2] = 1;
			map[v2][v1] = 1;

		}

		cnt = 0;
		dfs(1);

		System.out.println(cnt);

	}

	static void dfs(int start) {

		visited[start] = true;

		for (int i = 1; i <= n; i++) {
			if (map[start][i] == 1 && !visited[i]) {
				dfs(i);
				cnt++;
			}
		}

	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(start);

		visited[start] = true;

		while (!q.isEmpty()) {

			int tmp = q.poll();
			for (int i = 1; i <= n; i++) {
				if (map[tmp][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					cnt++;
				}
			}

		}

	}

}
