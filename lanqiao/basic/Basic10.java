package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 十进制转十六进制
 * 
 * 总结：循环 整除 求余 判断
 * 
 * @author Lenovo
 *
 */
public class Basic10 {

	private static final char c[] = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F', };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		method1(n);
		method2(n);
	}

	private static void method2(int n) {
		// TODO Auto-generated method stub
		String hex = "";
		if (n == 0)
			System.out.println(0);
		while (n > 0) {
			int t = (int) n & 0xf;
			hex += c[t];
			n >>>= 4;
		}
		System.out.println(new StringBuilder(hex).reverse());
	}

	private static void method1(final int n) {
		// TODO Auto-generated method stub
		String hex = Long.toHexString(n).toUpperCase();
		System.out.println(hex);
	}

}
