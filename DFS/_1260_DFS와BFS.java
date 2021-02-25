package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1260_DFS와BFS {
	static int V;
	static int E;
	static int goal;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		goal = sc.nextInt();

		map = new int[V + 1][V + 1];
		visit = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			map[v1][v2] = 1;
			map[v2][v1] = 1;
		}
		dfs(goal);
		System.out.println();
		
		visit = new boolean[V+1];
		bfs(goal);

	}

	static void dfs(int start) {
		System.out.print(start + " ");
		visit[start] = true;

		for (int i = 1; i <= V; i++) {
			if (map[start][i] == 1 && !visit[i]) {
				dfs(i);
			}

		}
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for (int i = 1; i <= V; i++) {
				if(map[temp][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
}