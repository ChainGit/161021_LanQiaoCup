package com.lanqiao.prev;

import java.util.Scanner;

/**
 * �������� ���ҵ�����
 * 
 * ��������<br>
 * С���������Ŀ����������3�������顣���ڽ������춼�ڼӰ��ء�Ϊ����ʿ����С�Ŵ����ÿ���鷢һ�����ң��ݴ����ܲ��ԣ�������Ҫ���ǣ�<br>
 * 
 * 1. ����ĺ�������������ͬ<br>
 * 
 * 2. �����ڱ�����ƽ�ֺ��ң���Ȼ�ǲ��ܴ���ģ�<br>
 * 
 * 3. �����ṩ����1,2��������С��������Լ�ָ����<br>
 * 
 * �����ʽ<br>
 * �����������������a, b, c����ʾÿ�������ڼӰ���������ÿո�ֿ���a,b,c<30��<br>
 * �����ʽ<br>
 * ���һ������������ʾÿ�����ҵ�������<br>
 * ��������1<br>
 * 2 4 5<br>
 * �������1<br>
 * 20<br>
 * ��������2<br>
 * 3 1 1<br>
 * �������2<br>
 * 3<br>
 * 
 * �ܽ᣺��С������
 * 
 * @author Chain
 *
 */
public class Prev01 {

	private static final int LEN = 3;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p[] = new int[LEN];
		for (int i = 0; i < LEN; i++)
			p[i] = in.nextInt();
		in.close();

		// ���������С������
		int s = 1;
		for (int i = 0; i < LEN; i++)
			s = getMinDiv(s, p[i]);

		System.out.println(s);
	}

	// �������������С������
	private static int getMinDiv(int a, int b) {
		int q = 1;
		boolean canDiv = true;
		while (canDiv) {
			canDiv = false;
			for (int i = 2; i <= min(a, b); i++)
				if (a % i == 0 && b % i == 0) {
					a /= i;
					b /= i;
					q *= i;
					canDiv = true;
					break;
				}
		}
		return a * b * q;
	}

	private static int min(int a, int b) {
		return a > b ? b : a;
	}

}
