package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2667_단지번호붙이기 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	private static int n;
	private static int[][] map;
	private static boolean[][] visited;
	private static ArrayList<Integer> result;
	private static int dangeCnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = sc.next();

			for (int j = 0; j < str.length(); j++) {

				map[i][j] = (int) str.charAt(j) - '0';
			}
		}

		result = new ArrayList<Integer>();

		dangeCnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(new Point(i, j));
					dangeCnt++;
				}
			}
		}

		System.out.println(dangeCnt);

		Collections.sort(result);

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	static void dfs(Point p) {

		int cnt = 1;
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
					cnt++;
				}
			}
		}

		result.add(cnt);

	}

	static boolean isPossible(int nx, int ny) {
		if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] == 1) {
			return true;
		}
		return false;
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
