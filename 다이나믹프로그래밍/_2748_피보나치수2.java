package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2748_피보나치수2 {
	static long[] dp = new long[91];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		dp[0] = 0;
		dp[1] = 1;

		int n = Integer.parseInt(br.readLine());

		Arrays.fill(dp, -1);

		System.out.println(fibonacci(n));
	}

	static long fibonacci(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (dp[n] == -1) {
			dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
		}
		return dp[n];

	}
}
