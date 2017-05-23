package com.lanqiao.study;

public class Study04c {

	private static long cut = 0l;

	// 买不到的数目(筛法+欧几里得)
	public static void main(String[] args) {
		start();

		end();
	}

	private static void fun(int x, int y) {

	}

	public static void start() {
		cut = System.currentTimeMillis();
	}

	public static void end() {
		System.out.println("spend: " + (System.currentTimeMillis() - cut));
	}
}
