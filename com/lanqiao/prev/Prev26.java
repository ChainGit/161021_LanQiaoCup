package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * 历届试题 最大子阵
 * 
 * @author Chain
 *
 */
public class Prev26 {

	// 非空子矩阵
	public static void main(String[] args) throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String[] pbuf = bufr.readLine().split(" ");
		int n = new Integer(pbuf[0]);
		int m = new Integer(pbuf[1]);
		int[][] martix = new int[n][m];
		for (int i = 0; i < n; i++) {
			pbuf = bufr.readLine().split(" ");
			for (int j = 0; j < m; j++)
				martix[i][j] = new Integer(pbuf[j]);
		}
		bufr.close();

		// 对每个子矩阵分别进行求和
		// method1(n, m, martix);
		// 先列后行,分开处理,减少重复运算
		method2(n, m, martix);
	}

	private static void method2(int n, int m, int[][] martix) {
		long msum = Long.MIN_VALUE;
		int[] t = new int[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				t[j] = 0;
			for (int j = i; j < n; j++) {
				for (int k = 0; k < m; k++)
					t[k] += martix[j][k];
				long tsum = getMaxRawSum(t);
				if (tsum > msum)
					msum = tsum;
			}
		}

		System.out.println(msum);
	}

	// 数组的某一段的最大元素和
	private static long getMaxRawSum(int[] t) {
		long tmp = Long.MIN_VALUE;
		long max = Long.MIN_VALUE;
		for (int i = 0; i < t.length; i++) {
			if (tmp > 0)
				tmp += t[i];
			else
				tmp = t[i];
			if (tmp > max)
				max = tmp;
		}
		return max;
	}

	@SuppressWarnings("unused")
	private static void method1(int n, int m, int[][] martix) {
		long msum = Long.MIN_VALUE;
		int len = n * m;
		// 画出子矩阵
		for (int i = 0; i < len; i++)
			for (int j = i; j < len; j++) {
				if (i == 0 && j == len - 1)
					continue;

				int x1 = i / m;
				int y1 = i % m;
				int x2 = j / m;
				int y2 = j % m;
				long tsum = 0;
				for (int p = x1; p <= x2; p++)
					for (int q = y1; q <= y2; q++)
						tsum += martix[p][q];
				if (tsum > msum)
					msum = tsum;
			}

		System.out.println(msum);
	}
}
