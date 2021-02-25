package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15651_N과M3 {
	static int[] num;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		

		num = new int[N + 1];
		visited = new boolean[N + 1];
		dfs(N, M ,0 );

		System.out.println(sb);
	}

	// 조합
	static void dfs(int N, int M, int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) { // 현재 결과배열을 출력		
				sb.append(num[i] + " ");
			}
			sb.append("\n");
			return; // DFS 종료
		}
		for (int i = 1; i <= N; i++) {
				num[count] = i;
				dfs(N, M ,count + 1);
		}
	}
}