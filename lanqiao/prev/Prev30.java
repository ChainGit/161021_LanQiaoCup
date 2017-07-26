package com.lanqiao.prev;

import java.util.Scanner;

/**
 * 历届试题 波动数列
 * 
 * @author Chain
 *
 */
public class Prev30 {

	// 摘自官方答案
	public static void main(String[] args) {
		int mod = 100000007;
		int n, s, a, b, i, j, t;
		int x[][] = new int[1001][1001];
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		sc.close();
		b %= n;
		b *= -1;
		while (b < 0)
			b += n;
		a %= n;
		s %= n;
		while (s < 0)
			s += n;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				x[i][j] = 0;
		x[1][a] = x[1][b] = 1;
		for (i = 1; i < n - 1; i++)
			for (j = 0; j < n; j++) {
				t = (j + a * (i + 1)) % n;
				x[i + 1][t] += x[i][j];
				x[i + 1][t] %= mod;
				t = (j + b * (i + 1)) % n;
				t %= n;
				x[i + 1][t] += x[i][j];
				x[i + 1][t] %= mod;
			}
		System.out.println(x[n - 1][s]);
	}
}
