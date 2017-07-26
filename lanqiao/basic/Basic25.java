package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 回形取数
 * 
 * 问题描述<br>
 * 回形取数就是沿矩阵的边取数，若当前方向上无数可取或已经取过，则左转90度。一开始位于矩阵左上角，方向向下。<br>
 * 输入格式<br>
 * 输入第一行是两个不超过200的正整数m, n，表示矩阵的行和列。接下来m行每行n个整数，表示这个矩阵。<br>
 * 输出格式<br>
 * 输出只有一行，共mn个数，为输入矩阵回形取数得到的结果。数之间用一个空格分隔，行末不要有多余的空格。<br>
 * 样例输入<br>
 * 3 3<br>
 * 1 2 3<br>
 * 4 5 6<br>
 * 7 8 9<br>
 * 样例输出<br>
 * 1 4 7 8 9 6 3 2 5<br>
 * 样例输入<br>
 * 3 2<br>
 * 1 2<br>
 * 3 4<br>
 * 5 6<br>
 * 样例输出<br>
 * 1 3 5 6 4 2<br>
 * 
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：二维数组 循环
 * 
 * @author Chain
 *
 */
public class Basic25 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] a = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = in.nextInt();
		in.close();

		System.out.println();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}

		// 4种取数据方式
		int i = 0;
		int j = 0;
		while (a[i][j] != -1) {

			// 向下
			while (i < m && a[i][j] != -1) {
				System.out.print(a[i][j] + " ");
				a[i++][j] = -1;
			}

			i--;
			j++;

			// 向右
			while (j < n && a[i][j] != -1) {
				System.out.print(a[i][j] + " ");
				a[i][j++] = -1;
			}

			i--;
			j--;

			// 向上
			while (i > -1 && a[i][j] != -1) {
				System.out.print(a[i][j] + " ");
				a[i--][j] = -1;
			}

			i++;
			j--;

			// 向左
			while (j > -1 && a[i][j] != -1) {
				System.out.print(a[i][j] + " ");
				a[i][j--] = -1;
			}

			i++;
			j++;
		}
		System.out.println();
	}

}
