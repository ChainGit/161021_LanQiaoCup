package com.lanqiao.prev;

import java.util.Scanner;

/**
 * 
 * �������� �򲻵�����Ŀ
 * 
 * �ܽ᣺���� ��̬�滮
 * 
 * @author Chain
 *
 */
@SuppressWarnings("unused")
public class Prev08 {

	// ���貢���Ͻ�,������������ֲ�����ͬ������С�����ֱ������1,����ͬΪż��������
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		in.close();

		// method1(a, b);
		method2(a, b);
	}

	// ����С��������ʼ�ݼ��ж�
	private static void method2(int a, int b) {
		int com = getMinConMul(a, b);
		int min = a > b ? b : a;
		int max = a > b ? a : b;
		int i = com - 1;
		for (; i > -1; i--) {
			int divmax = i / max;
			int j = 0;
			boolean canMake = false;
			for (; j <= divmax && !canMake; j++) {
				int summax = j * max;
				int divmin = (i - summax) / min;
				for (int k = 0; k <= divmin; k++) {
					int sumtmp = summax + k * min;
					if (sumtmp > i)
						break;
					if (sumtmp == i) {
						canMake = true;
						break;
					}
				}
			}
			if (!canMake)
				break;
		}
		System.out.println(i);
	}

	// ������С������
	private static int getMinConMul(int a, int b) {
		int q = 1;
		boolean canDiv = true;
		while (canDiv) {
			canDiv = false;
			for (int i = 2; i <= (a > b ? b : a); i++)
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

	// ժ�ԣ�http://blog.csdn.net/jingqi814/article/details/21734449
	private static void method1(int a, int b) {
		System.out.println(a * b - a - b);
	}
}
