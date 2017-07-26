package com.lanqiao.algo;

import java.util.Scanner;

/**
 * �㷨ѵ�� ����k������ѯ
 * 
 * ��������<br>
 * ����һ�����У�ÿ��ѯ�������е�l��������r�����е�K��������ĸ���<br>
 * 
 * �����ʽ<br>
 * ��һ�а���һ����n����ʾ���г��ȡ�<br>
 * 
 * �ڶ��а���n������������ʾ���������С�<br>
 * 
 * ����������һ��������m����ʾѯ�ʸ�����<br>
 * 
 * ������m�У�ÿ��������l,r,K����ʾѯ�����д������ҵ�l��������r�����У��Ӵ���С��K��������ĸ�������Ԫ�ش�1��ʼ��š�<br>
 * 
 * �����ʽ<br>
 * �ܹ����m�У�ÿ��һ��������ʾѯ�ʵĴ𰸡�<br>
 * ��������<br>
 * 5<br>
 * 1 2 3 4 5<br>
 * 2<br>
 * 1 5 2<br>
 * 2 3 2<br>
 * �������<br>
 * 4<br>
 * 2<br>
 * ���ݹ�ģ��Լ��<br>
 * ����30%�����ݣ�n,m<=100��<br>
 * 
 * ����100%�����ݣ�n,m<=1000��<br>
 * 
 * ��֤k<=(r-l+1)�������е���<=106��<br>
 * 
 * �ܽ᣺���� ����
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

	// ѡ������
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
