package com.lanqiao.study;

//Ñî»ÔÈý½ÇÐÎ
public class Study02b {

	public static void main(String[] args) {
		print(5);
		System.out.println(fun(5, 3));
	}

	private static void print(int x) {
		int[][] dat = new int[x][x];
		for (int i = 0; i < x; i++)
			for (int j = 0; j <= i; j++)
				dat[i][j] = fun(i + 1, j + 1);

		for (int i = 0; i < x; i++) {
			for (int j = i; j < x; j++)
				System.out.print("   ");
			for (int j = 0; j <= i; j++)
				System.out.printf("%6d", dat[i][j]);
			System.out.println();
		}
	}

	private static int fun(int n, int m) {
		if (n == 1)
			return 1;
		if (m == 0 || m == n)
			return 1;

		return fun(n - 1, m) + fun(n - 1, m - 1);
	}
}
