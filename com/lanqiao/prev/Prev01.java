package com.lanqiao.prev;

import java.util.Scanner;

/**
 * 历届试题 核桃的数量
 * 
 * 问题描述<br>
 * 小张是软件项目经理，他带领3个开发组。工期紧，今天都在加班呢。为鼓舞士气，小张打算给每个组发一袋核桃（据传言能补脑）。他的要求是：<br>
 * 
 * 1. 各组的核桃数量必须相同<br>
 * 
 * 2. 各组内必须能平分核桃（当然是不能打碎的）<br>
 * 
 * 3. 尽量提供满足1,2条件的最小数量（节约闹革命嘛）<br>
 * 
 * 输入格式<br>
 * 输入包含三个正整数a, b, c，表示每个组正在加班的人数，用空格分开（a,b,c<30）<br>
 * 输出格式<br>
 * 输出一个正整数，表示每袋核桃的数量。<br>
 * 样例输入1<br>
 * 2 4 5<br>
 * 样例输出1<br>
 * 20<br>
 * 样例输入2<br>
 * 3 1 1<br>
 * 样例输出2<br>
 * 3<br>
 * 
 * 总结：最小公倍数
 * 
 * @author Chain
 *
 */
public class Prev01 {

	private static final int LEN = 3;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p[] = new int[LEN];
		for (int i = 0; i < LEN; i++)
			p[i] = in.nextInt();
		in.close();

		// 依次求出最小公倍数
		int s = 1;
		for (int i = 0; i < LEN; i++)
			s = getMinDiv(s, p[i]);

		System.out.println(s);
	}

	// 求出两个数的最小公倍数
	private static int getMinDiv(int a, int b) {
		int q = 1;
		boolean canDiv = true;
		while (canDiv) {
			canDiv = false;
			for (int i = 2; i <= min(a, b); i++)
				if (a % i == 0 && b % i == 0) {
					a /= i;
					b /= i;
					q *= i;
					canDiv = true;
					break;
				}
		}
		return a * b * q;
	}

	private static int min(int a, int b) {
		return a > b ? b : a;
	}

}
