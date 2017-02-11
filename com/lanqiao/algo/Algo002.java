package com.lanqiao.algo;

import java.util.Scanner;

/**
 * 算法训练 最大最小公倍数
 * 
 * 问题描述<br>
 * 已知一个正整数N，问从1~N中任选出三个数，他们的最小公倍数最大可以为多少。<br>
 * 
 * 输入格式<br>
 * 输入一个正整数N。<br>
 * 
 * 输出格式<br>
 * 输出一个整数，表示你找到的最小公倍数。<br>
 * 样例输入<br>
 * 9<br>
 * 样例输出<br>
 * 504<br>
 * 数据规模与约定<br>
 * 1 <= N <= 106。<br>
 * 
 * 总结：贪心
 * 
 * @author Chain
 *
 */
public class Algo002 {

	// 前提条件：三个数都互质
	// 摘自：http://www.cnblogs.com/PJQOOO/p/4394313.html
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		long s = 0;

		// 官方数据测试失败
		// 95152*95151*95150=861460772824848
		// 而95152是偶数
		if (n % 2 != 0)
			s = (long) (n * (n - 1) * (n - 2));
		else if (n % 3 != 0)
			s = (long) (n * (n - 1) * (n - 3));
		else
			s = (long) ((n - 1) * (n - 2) * (n - 3));

		System.out.println(s & 0xffff_ffff);

	}
}
