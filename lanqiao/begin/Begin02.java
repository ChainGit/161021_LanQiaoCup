package com.lanqiao.begin;

import java.util.Scanner;

/**
 * 问题描述 : 求1+2+3+...+n的值。
 * 输入格式 : 输入包括一个整数n。 
 * 输出格式 : 输出一行，包括一个整数，表示1+2+3+...+n的值。 
 * 样例输入 : 4
 * 样例输出 : 10 
 * 样例输入 : 100
 * 样例输出 : 5050 
 * 数据规模与约定 : 1 <= n <= 1,000,000,000。
 * 
 * 总结：大数的处理，求和公式
 * 
 * @author Lenovo
 *
 */
public class Begin02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long i = in.nextInt();
		long s = 0;
		s = (i * (i + 1)) >> 1;
		System.out.println(s);
		in.close();
	}

}
