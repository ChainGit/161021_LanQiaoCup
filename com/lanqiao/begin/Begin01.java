package com.lanqiao.begin;

import java.util.Scanner;

/**
 * 问题描述 : 输入A、B，输出A+B。
 * 输入格式 : 输入的第一行包括两个整数，由空格分隔，分别表示A、B。 
 * 输出格式 : 输出一行，包括一个整数，表示A+B的值。
 * 
 * 样例输入 : 12 45 样例输出 : 57
 * 
 * 数据规模与约定 : -10000 <= A, B <= 10000
 * 
 * 总结：基本的输入输出，有符号数的加法
 * 
 * @author Lenovo
 *
 */
public class Begin01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer a = in.nextInt();
		Integer b = in.nextInt();
		System.out.println(a + b);
		in.close();
	}
}
