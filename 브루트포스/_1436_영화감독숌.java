package 브루트포스;

import java.util.Scanner;

public class _1436_영화감독숌 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int Num = 0;
		int cnt = 0;
		String str = "";

		while (true) {
			Num++;

			str = Integer.toString(Num);
			if (str.contains("666")) {
				cnt++;
				if (cnt == n) {
					break;
				}
			}
		}

		System.out.println(str);

	}
}
