package 브루트포스;

import java.util.Scanner;

public class _1018_체스판다시칠하기 {
	public static boolean[][] map;
	public static int min = 64;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		map = new boolean[N][M];

		/*
		 * Scanner 의 경우 공백자로 구분하다가 개행으로 입력되면 스트림에 개행이 남아있어서 의도와 달리 첫 번째 String 입력은 개행이
		 * 저장된다. 그렇기 때문에 nextLine() 을 통해 문자열 입력 전의 int와 String 입력 사이의 개행을 없애주도록 한다.
		 */

		sc.nextLine();

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine().trim();

			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W') {
					map[i][j] = true;
				} else {
					map[i][j] = false;

				}
			}
		}

		int N_row = N - 7;
		int M_col = M - 7;

		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {
				find(i, j);
			}
		}
		System.out.println(min);

	}

	public static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;

		int count = 0;

		boolean FirstBoolean = map[x][y];

		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {

				if (map[i][j] != FirstBoolean) {
					count++;
				}

				/*
				 * 다음 칸은 색이 바뀌므로 true라면 false로, false 라면 true 로 값을 변경한다.
				 */
				FirstBoolean = (!FirstBoolean);
			}

			FirstBoolean = !FirstBoolean;

		}

		/*
		 * 첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와 첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의 색칠 할 개수(64 -
		 * count) 중 최솟값을 count 에 저장
		 */
		count = Math.min(count, 64 - count);
		
		
		
		min = Math.min(min, count);

	}
}