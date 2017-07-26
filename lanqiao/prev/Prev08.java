package com.lanqiao.prev;

import java.util.Scanner;

/**
 * 
 * 历届试题 买不到的数目
 * 
 * 总结：数论 动态规划
 * 
 * @author Chain
 *
 */
@SuppressWarnings("unused")
public class Prev08 {

	// 题设并不严谨,输入的两个数字不能相同，且最小的数字必须大于1,不能同为偶数或奇数
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		in.close();

		// method1(a, b);
		method2(a, b);
	}

	// 从最小公倍数开始递减判断
	private static void method2(int a, int b) {
		int com = getMinConMul(a, b);
		int min = a > b ? b : a;
		int max = a > b ? a : b;
		int i = com - 1;
		for (; i > -1; i--) {
			int divmax = i / max;
			int j = 0;
			boolean canMake = false;
			for (; j <= divmax && !canMake; j++) {
				int summax = j * max;
				int divmin = (i - summax) / min;
				for (int k = 0; k <= divmin; k++) {
					int sumtmp = summax + k * min;
					if (sumtmp > i)
						break;
					if (sumtmp == i) {
						canMake = true;
						break;
					}
				}
			}
			if (!canMake)
				break;
		}
		System.out.println(i);
	}

	// 计算最小公倍数
	private static int getMinConMul(int a, int b) {
		int q = 1;
		boolean canDiv = true;
		while (canDiv) {
			canDiv = false;
			for (int i = 2; i <= (a > b ? b : a); i++)
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

	// 摘自：http://blog.csdn.net/jingqi814/article/details/21734449
	private static void method1(int a, int b) {
		System.out.println(a * b - a - b);
	}
}
