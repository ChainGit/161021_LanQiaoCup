package com.lanqiao.self;

import java.util.Scanner;

import org.junit.Test;

//例题7-3：分数拆分
public class Chapter7x03 {

	@Test
	public void test() {
		Scanner in = new Scanner(System.in);
		try {
			int k = in.nextInt();
			long begin = System.currentTimeMillis();
			fun(k);
			long end = System.currentTimeMillis();
			System.out.println("time used: " + (end - begin));
		} finally {
			in.close();
		}
	}

	private void fun(int k) {
		int k2 = k << 1;
		for (int y = 1; y <= k2; y++) {
			int a = k * y;
			int b = y - k;
			if (y - k < 1)
				continue;
			if (a % b != 0)
				continue;
			int x = a / b;
			if (x < k2)
				continue;
			if (x * y / (x + y) == k) {
				System.out.printf("1/%d = 1/%d + 1/%d", k, x, y);
				System.out.println();
			}
		}

	}
}
