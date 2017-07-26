package com.lanqiao.self;

import java.util.Scanner;

import org.junit.Test;

//素数环
public class Chapter7x05 {

	@Test
	public void test() {
		Scanner in = new Scanner(System.in);
		try {
			int n = in.nextInt();
			long begin = System.currentTimeMillis();
			fun(n);
			long end = System.currentTimeMillis();
			System.out.println("time used: " + (end - begin));
		} finally {
			in.close();
		}
	}

	private void fun(int n) {
		int p = n << 1;
		// 生成缓存
		boolean[] a = new boolean[p];
		a[1] = true;
		for (int i = 2; i < p; i++)
			a[i] = isPrime(i);

		boolean[] flag = new boolean[n];
		int[] dat = new int[n];
		dat[0] = 1;
		flag[0] = true;
		make(a, n, dat, flag, 1);

	}

	private void make(boolean[] buf, int n, int[] dat, boolean[] flag, int cur) {
		if (cur == n) {
			for (int i : dat)
				System.out.print(i + " ");
			System.out.println();
			return;
		}

		for (int i = 1; i < n; i++) {
			if (flag[i] || !buf[i + 1 + dat[cur - 1]])
				continue;
			flag[i] = true;
			dat[cur] = i + 1;
			make(buf, n, dat, flag, cur + 1);
			flag[i] = false;
			dat[cur] = 0;
		}
	}

	private boolean isPrime(int n) {
		int p = (int) Math.sqrt(n);
		for (int i = 2; i <= p; i++)
			if (n % i == 0)
				return false;
		return true;
	}
}
