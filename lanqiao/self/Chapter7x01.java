package com.lanqiao.self;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

//例题7-1：除法
public class Chapter7x01 {

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
		// 标记是否数字已经选择
		boolean[] chs = new boolean[10];

		for (int f = 0; f < 10; f++)
			for (int g = 0; g < 10; g++)
				for (int h = 0; h < 10; h++)
					for (int i = 0; i < 10; i++)
						for (int j = 0; j < 10; j++) {
							Arrays.fill(chs, false);
							if (!(check(chs, f) && check(chs, g) && check(chs, h) && check(chs, i) && check(chs, j)))
								continue;
							int down = f * 10000 + g * 1000 + h * 100 + i * 10 + j;
							int up = n * down;
							if (up > 98765)
								continue;
							int a = up / 10000;
							int b = up / 1000 % 10;
							int c = up / 100 % 10;
							int d = up / 10 % 10;
							int e = up % 10;
							if (!(check(chs, a) && check(chs, b) && check(chs, c) && check(chs, d) && check(chs, e)))
								continue;
							System.out.printf("%d%d%d%d%d / %d%d%d%d%d = %d", a, b, c, d, e, f, g, h, i, j, n);
							System.out.println();
						}
	}

	private boolean check(boolean[] chs, int f) {
		if (!chs[f]) {
			chs[f] = true;
			return true;
		}
		return false;
	}
}
