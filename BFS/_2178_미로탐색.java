package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2178_미로탐색 {
	private static int n;
	private static int m;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int min = Integer.MAX_VALUE;
	private static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {

			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(new Point(0, 0));

		System.out.println(map[n - 1][m - 1]);

	}

	static void bfs(Point p) {

		Queue<Point> q = new LinkedList<Point>();
		visited[p.x][p.y] = true;
		q.add(p);

		while (!q.isEmpty()) {
			Point tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int next_x = tmp.x + dx[i];
				int next_y = tmp.y + dy[i];

				if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m && !visited[next_x][next_y]
						&& map[next_x][next_y] == 1) {
					q.add(new Point(next_x, next_y));
					visited[next_x][next_y] = true;
					map[next_x][next_y] = map[tmp.x][tmp.y] + 1;
				}

			}

		}

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
