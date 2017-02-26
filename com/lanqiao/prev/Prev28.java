package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * �������� �ع�ȡ��
 * 
 * @author Chain
 *
 */
public class Prev28 {

	private static int n;
	private static int m;
	private static int k;
	private static int total;
	private static int[][] martix;
	private static int many;

	// ����ֻ���û��߲���,���ܻ�(��)
	// ������ֻ�����һ�����
	// ��֦�������������Ҫ��,����Ҫ�����б�������һ����,��������
	public static void main(String[] args) throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String[] pbuf = bufr.readLine().split(" ");
		n = new Integer(pbuf[0]);
		m = new Integer(pbuf[1]);
		k = new Integer(pbuf[2]);
		martix = new int[n][m];
		for (int i = 0; i < n; i++) {
			pbuf = bufr.readLine().split(" ");
			for (int j = 0; j < m; j++)
				martix[i][j] = new Integer(pbuf[j]);
		}
		bufr.close();

		total = n * m;
		int[] select = new int[k];
		for (int i = 0; i < total; i++) {
			Arrays.fill(select, -1);
			int x = i / m;
			int y = i % m;
			take(0, select, -1, x, y);
		}

		System.out.println(many);
	}

	private static void take(int num, int[] select, int maxValue, int startx, int starty) {

		if (m - startx < k && n - starty < k)
			return;

		if (startx > m - 1 || starty > n - 1)
			return;

		if (num > k)
			return;

		// ��֦
		int val = martix[startx][starty];
		if (maxValue >= val)
			return;

		if (num == k) {
			many++;
			return;
		}

		select[num++] = val;
		if (val > maxValue)
			maxValue = val;

		// ����
		take(num, select, maxValue, startx + 1, starty);
		// ����
		take(num, select, maxValue, startx, starty + 1);
	}

}
