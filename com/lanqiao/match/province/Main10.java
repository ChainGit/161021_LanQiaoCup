package com.lanqiao.match.province;

import java.util.Scanner;

/*
10��k������
����һ������ΪN�����У�A1, A2, �� AN���������һ��������������Ai, Ai+1, �� Aj(i <= j)֮����K�ı��������Ǿͳ��������[i, j]��K�����䡣 
��������������ܹ��ж��ٸ�K�������� 
����
��һ�а�����������N��K��(1 <= N, K <= 100000) 
����N��ÿ�а���һ������Ai��(1 <= Ai <= 100000) 
���
���һ������������K���������Ŀ�� 
���磬 
���룺 
5 2 
1 
2 
3 
4 
5 
����Ӧ������� 
6
��ԴԼ���� 
��ֵ�ڴ����ģ���������� < 256M 
CPU���� < 3000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ����������롭�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣 
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ� 
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��

�����������Ķ�̬�滮����һ�����棬����i������j���ĺͣ��ȼ��ڣ��ӵ�1������j��-��1������i����
 */
public class Main10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] dat = new int[n];
		int[] buf = new int[n];
		dat[0] = in.nextInt();
		for (int i = 1; i < n; i++) {
			dat[i] = in.nextInt();
			// �����ӵ�һ������i�ĺ͵�buf
			buf[i] = buf[i - 1] + dat[i];
		}
		in.close();

		int sum = 0;
		for (int i = 0; i < n; i++) {
			// �����������k������
			if (dat[i] % k == 0)
				sum++;
			// ������������k������
			for (int j = i + 1; j < n; j++)
				if ((buf[j] - buf[i]) % k == 0)
					sum++;
		}

		System.out.println(sum);
	}

}
