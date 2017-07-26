package com.lanqiao.prev;

import java.util.Scanner;

/**
 * 历届试题 数字游戏
 * 
 * @author Chain
 *
 */
public class Prev23 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		long k = in.nextInt();
		long t = in.nextInt();
		in.close();

		// mathod1(n, k, t);
		mathod2(n, k, t);
	}

	// 总结规律：栋栋报第i+1次时的数字x=[n*n*i+(n+1)*n/2]%k
	private static void mathod2(long n, long k, long t) {
		long base = ((n + 1) * n) >> 1;
		long delta = n * n;
		long x = 1;
		long sum = x;
		for (int i = 0; i < t - 1; i++) {
			x = (delta * i + base + x) % k;
			sum += x;
			// System.out.println(x);
		}
		System.out.println(sum);
	}

	// 部分超时,且数据使用了int,题目要求数字会很大
	@SuppressWarnings("unused")
	@Deprecated
	private static void mathod1(int n, int k, int t) {
		int len = (t - 1) * n;
		int sum = 1;
		// 东东第一个说
		int before = 1;
		int now;
		for (int i = 1; i <= len; i++) {
			now = before + i;
			if (now > k - 1)
				now %= k;
			if (i % n == 0)
				sum += now;
			before = now;
			// System.out.println(now);
		}
		System.out.println(sum);
	}
}
