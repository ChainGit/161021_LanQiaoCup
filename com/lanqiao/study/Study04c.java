package com.lanqiao.study;

public class Study04c {

	private static long cut = 0l;

	// �򲻵�����Ŀ(ɸ��+ŷ�����)
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
