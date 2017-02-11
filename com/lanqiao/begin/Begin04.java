package com.lanqiao.begin;

import java.util.Scanner;

/**
 * Fibonacci 斐波那契数列
 * 
 * 总结：大的问题分解成局部求解，分配律的应用，数列，取模
 * 
 * @author Lenovo
 *
 */
public class Begin04 {

	private static final int NUM = 10007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fn_2 = 1, fn_1 = 1, t = 1;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 3; i <= n; i++) {
			t = (fn_1 + fn_2) % NUM;
			fn_2 = fn_1;
			fn_1 = t;
		}
		System.out.println(t);
		in.close();
	}

}
