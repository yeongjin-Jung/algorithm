package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1012_유기농배추 {

	private static int m;
	private static int n;
	private static int k;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {

			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();

			map = new int[n][m];
			visited = new boolean[n][m];

			for (int i = 0; i < k; i++) {

				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				map[v2][v1] = 1;
			}

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {

					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(new Point(i, j));
						cnt++;
					}
				}
			}

			System.out.println(cnt);

		}

	}

	private static void bfs(Point p) {

		Queue<Point> q = new LinkedList<Point>();
		q.add(p);
		visited[p.x][p.y] = true;

		while (!q.isEmpty()) {

			Point tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int next_x = tmp.x + dx[i];
				int next_y = tmp.y + dy[i];

				if (isPossible(next_x, next_y)) {

					q.add(new Point(next_x, next_y));
					visited[next_x][next_y] = true;
				}
			}

		}

	}

	static boolean isPossible(int nx, int ny) {

		if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
			return true;
		}

		return false;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
