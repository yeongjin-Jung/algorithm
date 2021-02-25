package 백트래킹;

import java.nio.file.Path;
import java.util.Scanner;

public class _9663_N_Queen {

	static int[] queen;
	static int n;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		queen = new int[n]; // 퀸을 배치할 행의 번호를 1~N번까지 사용 예정
		backtrack(0);
		System.out.println(ans);
	}

	static void backtrack(int row) {
		if (row == n) {
			ans++;
			return;
		}
		for (int j = 0; j < n; j++) {
			queen[row] = j;
			if (isOk(row)) { // 지금 row행의 퀸을 j번에 놓은게 괜찮다면??
				backtrack(row + 1);
			} // 지금 놨던 퀸이 자리가 안좋으면 ? 그냥 다음 j로 넘어가겠지.
		}
	}

	static boolean isOk(int col) {
		// 지금 row행에 놓은 퀸이 이전 퀸들에 영향을 안받는 자리에 있는지 확인
		for (int i = 0; i < col; i++) {
			// 현재 row 위치에 퀸이 있음
			if (queen[col] == queen[i])
				return false;
			/*
			 * 대각선상에 놓여있는 경우 (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
			 */
			if (Math.abs(col - i) == Math.abs(queen[i] - queen[col])) {
				return false;
			}
		}
		return true;
	}

}