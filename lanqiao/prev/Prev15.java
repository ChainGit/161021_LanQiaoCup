package com.lanqiao.prev;

import java.util.Scanner;

/**
 * 历届试题 格子刷油漆
 * 
 * 总结：动态规划
 * 
 * @author Chain
 *
 */
public class Prev15 {

	private static final long mod = 10_0000_0007;

	// 动态规划必然有状态转移方程
	// 由当前已涂格子,推出下一个该涂的格子
	// 摘自：http://blog.csdn.net/u010126535/article/details/20651999
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		method1(n);
	}

	private static void method1(int n) {
		if (n == 1) {
			System.out.println(2);
			return;
		}

		long sum = 0;
		long[] a = new long[n];
		long[] d = new long[n];

		d[0] = 1;
		d[1] = 2;
		a[0] = 1;
		a[1] = 6;

		for (int i = 2; i < n; i++) {
			d[i] = (d[i - 1] << 1) % mod;
			a[i] = ((a[i - 1] << 1) + (a[i - 2] << 2) + d[i]) % mod;
		}

		sum = (a[n - 1] << 2) % mod;

		for (int i = 1; i < n - 1; i++)
			sum = (sum + ((d[i] * a[n - i - 2] % mod + d[n - 1 - i] * a[i - 1] % mod) << 2)) % mod;

		System.out.println(sum);
	}

}
