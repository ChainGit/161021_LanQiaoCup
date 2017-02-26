package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * �������� �������
 * 
 * @author Chain
 *
 */
public class Prev26 {

	// �ǿ��Ӿ���
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

		// ��ÿ���Ӿ���ֱ�������
		// method1(n, m, martix);
		// ���к���,�ֿ�����,�����ظ�����
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

	// �����ĳһ�ε����Ԫ�غ�
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
		// �����Ӿ���
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
