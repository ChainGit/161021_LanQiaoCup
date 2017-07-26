package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 查找整数
 * 
 * 总结：循环判断
 * 
 * @author Lenovo
 *
 */
public class Basic05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
		// method2();
	}

	public static void method1() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int[] n = new int[len];
		for (int i = 0; i < len && in.hasNext(); i++)
			n[i] = in.nextInt();
		int x = in.nextInt();
		int i = 0;
		for (; i < len; i++)
			if (n[i] == x) {
				System.out.println(i + 1);
				break;
			}
		if (i == len)
			System.out.println(-1);
		in.close();
	}

	// 这个方法有误，比如字符串有23，而需要查找2
	@Deprecated
	public static void method2() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		String s = "";
		for (int i = 0; i < len && in.hasNext(); i++)
			s += Integer.toString(in.nextInt());
		String x = in.next();
		int pos = s.indexOf(x);
		System.out.println(pos == -1 ? -1 : pos + 1);
		in.close();
	}

}
