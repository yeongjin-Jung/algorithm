package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _1003_피보나치함수 {
	private static int zero_cnt = 0;
	private static int one_cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int[] arr = new int[tc * 2];

		for (int i = 0; i < tc; i++) {

			int num = Integer.parseInt(br.readLine());
			zero_cnt = 0;
			one_cnt = 0;

			fibonacci(num);
			sb.append(zero_cnt + " " + one_cnt + '\n');
			arr[i * 2] = zero_cnt;
			arr[i * 2 + 1] = one_cnt;

		}

		System.out.println(sb);
	}

	static int fibonacci(int n) {
		if (n == 0) {
			zero_cnt++;
			return 0;
		} else if (n == 1) {
			one_cnt++;
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}
