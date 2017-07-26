package com.lanqiao.algo;

import java.util.Scanner;

/**
 * 算法训练 区间k大数查询
 * 
 * 问题描述<br>
 * 给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。<br>
 * 
 * 输入格式<br>
 * 第一行包含一个数n，表示序列长度。<br>
 * 
 * 第二行包含n个正整数，表示给定的序列。<br>
 * 
 * 第三个包含一个正整数m，表示询问个数。<br>
 * 
 * 接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。<br>
 * 
 * 输出格式<br>
 * 总共输出m行，每行一个数，表示询问的答案。<br>
 * 样例输入<br>
 * 5<br>
 * 1 2 3 4 5<br>
 * 2<br>
 * 1 5 2<br>
 * 2 3 2<br>
 * 样例输出<br>
 * 4<br>
 * 2<br>
 * 数据规模与约定<br>
 * 对于30%的数据，n,m<=100；<br>
 * 
 * 对于100%的数据，n,m<=1000；<br>
 * 
 * 保证k<=(r-l+1)，序列中的数<=106。<br>
 * 
 * 总结：排序 查找
 * 
 * @author Chain
 *
 */
public class Algo001 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] da = new int[n];
		for (int i = 0; i < n; i++)
			da[i] = in.nextInt();
		int m = in.nextInt();
		int[][] qu = new int[m][3];
		for (int i = 0; i < m; i++) {
			qu[i][0] = in.nextInt() - 1;
			qu[i][1] = in.nextInt() - 1;
			qu[i][2] = in.nextInt();
		}
		in.close();

		for (int i = 0; i < m; i++) {
			int l = qu[i][0];
			int r = qu[i][1];
			int k = qu[i][2];
			int tlen = r - l + 1;
			int[] t = new int[tlen];
			for (int j = 0; j < t.length; j++)
				t[j] = da[l + j];
			mySort(t);
			System.out.println(t[tlen - k]);
		}
	}

	// 选择排序
	private static void mySort(int[] da) {
		for (int i = 0; i < da.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < da.length; j++)
				if (da[min] > da[j])
					min = j;
			if (min != i)
				swap(da, i, min);
		}
	}

	private static void swap(int[] da, int i, int min) {
		da[i] ^= da[min];
		da[min] ^= da[i];
		da[i] ^= da[min];
	}

}
