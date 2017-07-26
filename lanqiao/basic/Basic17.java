package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 
 * 基础练习 矩阵相乘
 * 
 * 问题描述<br>
 * 输入两个矩阵，分别是m*s，s*n大小。输出两个矩阵相乘的结果。<br>
 * 输入格式<br>
 * 第一行，空格隔开的三个正整数m,s,n（均不超过200）。<br>
 * 接下来m行，每行s个空格隔开的整数，表示矩阵A（i，j）。<br>
 * 接下来s行，每行n个空格隔开的整数，表示矩阵B（i，j）。<br>
 * 输出格式<br>
 * m行，每行n个空格隔开的整数，输出相乘後的矩阵C（i，j）的值。<br>
 * 样例输入<br>
 * 2 3 2<br>
 * 1 0 -1<br>
 * 1 1 -3<br>
 * 0 3<br>
 * 1 2<br>
 * 3 1<br>
 * 样例输出<br>
 * -3 2<br>
 * -8 2<br>
 * 
 * 提示<br>
 * 矩阵C应该是m行n列，其中C(i,j)等于矩阵A第i行行向量与矩阵B第j列列向量的内积。<br>
 * 例如样例中C(1,1)=(1,0,-1)*(0,1,3) = 1 * 0 +0*1+(-1)*3=-3<br>
 * 
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：二维数组 循环 矩阵
 * 
 * @author Chain
 *
 */
public class Basic17 {

	// nextInt()耗时太多,不如一次读出转化处理
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int s = in.nextInt();
		int n = in.nextInt();
		int[][] a = new int[m][s];
		int[][] b = new int[s][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < s; j++)
				a[i][j] = in.nextInt();
		for (int i = 0; i < s; i++)
			for (int j = 0; j < n; j++)
				b[i][j] = in.nextInt();
		in.close();

		System.out.println();
		printMatrix(a, m, s);
		System.out.println();
		printMatrix(b, s, n);
		System.out.println();

		// 矩阵的性质
		int[][] c = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				for (int p = 0; p < s; p++)
					c[i][j] += a[i][p] * b[p][j];

		System.out.println();
		printMatrix(c, m, n);
	}

	private static void printMatrix(int[][] m, int l, int c) {
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}
}
