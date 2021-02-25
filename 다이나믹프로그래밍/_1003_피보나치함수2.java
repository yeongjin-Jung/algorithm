package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003_피보나치함수2 {
	static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1] + '\n');
		}

		System.out.println(sb);

	}

	static Integer[] fibonacci(int N) {

		if (dp[N][0] == null || dp[N][1] == null) {

			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}

		return dp[N];
	}
}
