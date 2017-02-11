package com.lanqiao.prev;

import java.util.Scanner;

/**
 * �������� ������
 * 
 * �ܽ᣺����
 * 
 * @author Chain
 *
 */
public class Prev03 {

	// �ж���������n = a + b/c
	private int res = 0;
	// �洢ÿһ������
	private int dat[] = new int[9];
	// ��ֵ�Ƿ��Ѿ���ѡ��,�ų��ظ�
	private boolean flag[] = new boolean[9];
	// �洢n
	private int n = 0;

	public static void main(String[] args) {
		new Prev03().method();
	}

	private void method() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();

		makeArr(0);

		System.out.println(res);
	}

	// �ݹ��г���������DFS,��362880��
	private void makeArr(int start) {
		if (start == 9)
			check();
		else
			for (int i = 0; i < 9; i++) {
				if (flag[i])
					continue;
				dat[start] = i + 1;
				flag[i] = true;
				makeArr(start + 1);
				flag[i] = false;
			}

	}

	// ����Ƿ���ϴ�����
	private void check() {
		// n = a + b / c
		// a�������Ϊ1λ���Ϊ7λ
		// b�������Ϊ1λ,�Ϊ7λ,�ұ����c��
		// c�������Ϊ1λ,�Ϊ4λ
		for (int i = 0; i < 8; i++) {
			int a = sum(0, i);
			if (a >= n)
				return;
			for (int j = 8; j > 4; j--) {
				int b = sum(i + 1, j - 1);
				int c = sum(j, 8);
				if (b > c && b % c == 0 && a + b / c == n) {
					// System.out.println(n + "=" + a + "+" + b + "/" + c);
					res++;
				}
			}
		}
	}

	// ���ĳһ�εĺ�,����dat�зֽ��a,b,c,����ͷҲ����β
	private int sum(int from, int to) {
		int sum = 0;
		for (int i = from; i <= to; i++)
			sum = sum * 10 + dat[i];
		return sum;
	}
}
