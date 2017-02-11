package com.lanqiao.prev;

import java.util.Scanner;

/**
 * 历届试题 连号区间数
 * 
 * 总结：并查集
 * 
 * @author Chain
 *
 */
public class Prev07 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] dat = new int[n];
		for (int i = 0; i < n; i++)
			dat[i] = in.nextInt();
		in.close();

		// 长度为1的本身满足题意,减少判断次数
		int t = n;
		// 对每次的[L,R]只需判断最大MAX和最小MIN是否满足MAX-MIN==R-L,无需排序
		// 最后一个测试数据超时,故改进算法
		for (int i = 0; i < n; i++) {
			int max = dat[i];
			int min = max;
			for (int j = i + 1; j < n; j++) {
				int tp = dat[j];
				if (max < tp)
					max = tp;
				else if (min > tp)
					min = tp;
				if (max - min == j - i)
					t++;
			}
		}

		System.out.println(t);
	}
}
