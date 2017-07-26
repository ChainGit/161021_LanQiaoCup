package com.lanqiao.test;

import org.junit.Test;

public class Test01 {

	@Test
	public void test() {
		int[] a = new int[10];
		for (int i = 0; i < 1000_000_000; i++) {
			int r = (int) (Math.random() * 10 + 0);
			a[r]++;
		}

		for (int i : a)
			System.out.println(i);
	}

}
