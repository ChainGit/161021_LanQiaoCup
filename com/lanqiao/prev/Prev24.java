package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * �������� �ʾ�
 * 
 * @author Chain
 *
 */
public class Prev24 {

	// �������ݳ�ʱ

	private static int[][] house;
	private static int[][] station;
	// �洢ÿ������ÿ���ʾֵľ���
	private static double[][] dat;
	private static int n;
	private static int m;
	private static int k;
	// ���·��ѡ��
	private static double mlen;
	// ���·��ʱ��ѡ���ʾ�
	private static int[] select;

	// ժ�ԣ�http://www.cnblogs.com/zswbky/p/5431944.html
	public static void main(String[] args) throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String[] pbuf = bufr.readLine().split(" ");
		n = new Integer(pbuf[0]);
		m = new Integer(pbuf[1]);
		k = new Integer(pbuf[2]);
		house = new int[n][2];
		station = new int[m][2];
		dat = new double[n][m];
		for (int i = 0; i < n; i++) {
			pbuf = bufr.readLine().split(" ");
			house[i][0] = new Integer(pbuf[0]);
			house[i][1] = new Integer(pbuf[1]);
		}
		for (int i = 0; i < m; i++) {
			pbuf = bufr.readLine().split(" ");
			station[i][0] = new Integer(pbuf[0]);
			station[i][1] = new Integer(pbuf[1]);
		}
		bufr.close();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				dat[i][j] = Math
						.sqrt(Math.pow((house[i][0] - station[j][0]), 2) + Math.pow((house[i][1] - station[j][1]), 2));

		int[] choose = new int[k];
		for (int i = 0; i < m - k + 1; i++) {
			for (int j = 0; j < k; j++)
				choose[j] = -1;
			dfs(i, 1, choose);
		}

		// System.out.println(mlen);

		for (int i = 0; i < select.length; i++)
			System.out.print((select[i] + 1) + " ");
		System.out.println();
	}

	private static void dfs(int station, int num, int[] choose) {
		if (station > m - 1)
			return;

		if (num > k)
			return;

		// ѡ����k���ʾ�,�����ʱ��·������
		choose[num - 1] = station;
		if (num == k) {
			calc(choose);
			return;
		}

		num++;
		for (int i = station + 1; i < m - k + num; i++)
			dfs(i, num, choose);
	}

	// �����ʱ��·������
	private static void calc(int[] choose) {
		double tlen = 0;
		for (int i = 0; i < n; i++) {
			tlen += getMin(i, choose);
		}
		BigDecimal bdt = new BigDecimal(tlen);
		BigDecimal bdm = new BigDecimal(mlen);
		if (bdt.subtract(bdm).doubleValue() < 0.0 || bdm.equals(new BigDecimal(0))) {
			mlen = tlen;
			select = choose.clone();
		}
	}

	// ��ȡ����ҵ������������С�ľ���
	private static double getMin(int which, int[] choose) {
		double[] tmp = new double[choose.length];
		for (int i = 0; i < choose.length; i++)
			tmp[i] = dat[which][choose[i]];
		Arrays.sort(tmp);
		return tmp[0];
	}
}
