package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7576_토마토 {

	private static int m;
	private static int n;
	static int[][] map;
	static int[][] visit;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<Point> q = new LinkedList<Point>();

		m = sc.nextInt();
		n = sc.nextInt();

	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
