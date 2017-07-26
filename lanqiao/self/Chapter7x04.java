package com.lanqiao.self;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

// 按字典顺序枚举全排列
public class Chapter7x04 {

	@Test
	public void test() {
		Scanner in = new Scanner(System.in);
		try {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();
			long begin = System.currentTimeMillis();
			fun(arr);
			long end = System.currentTimeMillis();
			System.out.println("time used: " + (end - begin));
		} finally {
			in.close();
		}
	}

	private void fun(int[] a) {
		Arrays.sort(a);
		int len = a.length;
		int[] pos = new int[len];
		boolean[] chs = new boolean[len];
		make(a, pos, chs, 0);
	}

	private void make(int[] a, int[] t, boolean[] chs, int cur) {
		int len = a.length;
		if (cur == len) {
			for (int i = 0; i < len; i++)
				System.out.print(t[i]);
			System.out.println();
			return;
		}
		for (int i = 0; i < len; i++) {
			if (chs[i])
				continue;
			chs[i] = true;
			t[cur] = a[i];
			make(a, t, chs, cur + 1);
			t[cur] = 0;
			chs[i] = false;
		}
	}
}
