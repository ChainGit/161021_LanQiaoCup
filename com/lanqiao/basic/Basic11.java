package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 十六进制转十进制
 * 
 * 总结：进制转换 字符处理 判断
 * 
 * @author Lenovo
 *
 */
public class Basic11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();

		method1(str);
		method2(str);
	}

	private static void method2(final String str) {
		// TODO Auto-generated method stub
		System.out.println(Long.parseLong(str, 16));
	}

	private static void method1(final String str) {
		// TODO Auto-generated method stub
		char c[] = str.toCharArray();
		int i = 0;
		long sum = 0;
		while (i < c.length) {
			int t = 0;
			if (c[i] > 47 && c[i] < 59)
				t = c[i] - 48;
			else if (c[i] > 64 && c[i] < 71)
				t = c[i] - 55;// c[i] - 65 + 10;
			i++;
			sum = (sum << 4) + t;
		}
		System.out.println(sum);
	}

}
