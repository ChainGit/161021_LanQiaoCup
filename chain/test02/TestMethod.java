package com.chain.part1.tool00.utils;

/**
 * 一些用于测试的常用方法
 * 
 * @version 20170101
 * @author Chain
 *
 */
public class TestMethod {

	public static void main(String[] args) {
		print(new int[] { 1, 5, 2, 5, 3 });

		// other test
		// print(null);
		// print(new int[0]);
	}

	/**
	 * 打印出整数数组，用于main的测试
	 * 
	 * @param a
	 *            要打印的整形数组
	 */
	protected static void print(int[] a) {
		if (a == null || a.length < 1)
			throw new RuntimeException("array is null or empty");
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
	}
}
