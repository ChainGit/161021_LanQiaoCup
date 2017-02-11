package com.lanqiao.prev;

import java.util.Scanner;

/**
 * �������� ����������
 * 
 * �ܽ᣺���鼯
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

		// ����Ϊ1�ı�����������,�����жϴ���
		int t = n;
		// ��ÿ�ε�[L,R]ֻ���ж����MAX����СMIN�Ƿ�����MAX-MIN==R-L,��������
		// ���һ���������ݳ�ʱ,�ʸĽ��㷨
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
