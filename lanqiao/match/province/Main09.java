package com.lanqiao.match.province;

import java.util.Scanner;

/*
9�����ɿ���
��ͯ��������KλС���ѵ�С�������͡�С���ó�����ص��ɿ����д�С�����ǡ� 
С��һ����N���ɿ��������е�i����Hi x Wi�ķ�����ɵĳ����Ρ�

Ϊ�˹�ƽ�����С����Ҫ���� N ���ɿ������г�K���ɿ����ָ�С�����ǡ��г����ɿ�����Ҫ���㣺
1. ��״�������Σ��߳�������  
2. ��С��ͬ  

����һ��6x5���ɿ��������г�6��2x2���ɿ�������2��3x3���ɿ�����
��ȻС�����Ƕ�ϣ���õ����ɿ��������ܴ����ܰ�СHi��������ı߳��Ƕ���ô��

���� 
��һ�а�����������N��K��(1 <= N, K <= 100000) 
����N��ÿ�а�����������Hi��Wi��(1 <= Hi, Wi <= 100000) 
���뱣֤ÿλС���������ܻ��һ��1x1���ɿ����� 

��� 
����г����������ɿ��������ܵı߳���

�������룺 
2 10 
6 5 
5 6 
��������� 
2

��ԴԼ���� 
��ֵ�ڴ����ģ���������� < 256M 
CPU���� < 1000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ����������롭�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣 
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ� 
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��

�����������ı߿���ȥ�ݼ����ң������ֲ��ң�����������С��Χ
 */
public class Main09 {

	private static int n;
	private static int k;
	private static int[][] dat;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		dat = new int[n][2];

		int min = 0;
		// �߳�����ɿ����ı߳�����
		int max = 0;

		for (int i = 0; i < n; i++) {
			dat[i][0] = in.nextInt();
			dat[i][1] = in.nextInt();
			int a = dat[i][0];
			int b = dat[i][1];
			int tmax = a > b ? a : b;
			if (tmax > max)
				max = tmax;
		}
		in.close();

		// ���ֲ���
		while (min < max - 1) {
			// ���min+maxΪ��������mid�൱��mid-1����Ӱ����
			int mid = (min + max) >> 1;
			if (!check(mid))
				max = mid - 1;
			else
				min = mid + 1;
		}

		System.out.println(min);

	}

	private static boolean check(int base) {
		int res = 0;
		for (int i = 0; i < n; i++) {
			int a = dat[i][0] / base;
			int b = dat[i][1] / base;
			res += a * b;
		}
		if (res >= k)
			return true;
		return false;
	}

}
