package com.lanqiao.self;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

//例题7-2：最大乘积
public class Chapter7x02 {

	@Test
	public void test() {
		Scanner in = new Scanner(System.in);
		try {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();
			long begin = System.currentTimeMillis();
			fun(n, arr);
			long end = System.currentTimeMillis();
			System.out.println("time used: " + (end - begin));
		} finally {
			in.close();
		}
	}

	private void fun(int n, int[] arr) {
		Arrays.sort(arr);
		long[] buf = new long[n];
		buf[0] = arr[0];
		for (int i = 1; i < n; i++)
			buf[i] = buf[i - 1] * arr[i];

		long max = 0;
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++) {
				long now = buf[j];
				long before = i - 1 < 0 ? 1 : buf[i - 1];
				long current = now / before;
				if (current > max)
					max = current;
			}

		System.out.println(max < 0 ? 0 : max);
	}

}
