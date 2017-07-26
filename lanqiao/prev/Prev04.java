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
public class Prev04 {

	// ����������δ��ʱ,ƽ����ʱ200ms
	// ���ʹ��DFS���ÿһ���ߵ�·���ٶ�·�������жϻᳬʱ

	private int m;
	private int n;
	private int len;
	private int[][] dat;
	// ���·�Ƿ��߹�,����ѡ��
	private boolean[][] flag;
	// ���·��
	private int min;
	// ���ӵĺ͵�һ��
	private int half;
	// ���ڼ�����Ƿ���������
	private int res;
	// ���ڼ�����ı��
	private boolean chk[][] = null;

	public static void main(String[] args) {
		new Prev04().method();
	}

	private void method() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		dat = new int[m][n];
		int sum = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				dat[i][j] = in.nextInt();
				sum += dat[i][j];
			}
		in.close();

		// ���Ӻ�Ϊ�����϶����ܱ��ֳ���������ͬ�Ĳ���
		if (sum % 2 == 0)
			half = sum >> 1;
		else {
			System.out.println(0);
			return;
		}

		flag = new boolean[m][n];
		chk = new boolean[m][n];

		len = m * n;// len!=dat.length,dat.length��ָ����Row;
		min = len;

		// ʼ�մ����Ͻǿ�ʼ��
		check(0, 0, 0, 0);

		// ������·��Ϊlen,����û���ҵ����Խ����ӷֳ���������ͬ�Ĳ���
		if (min != len)
			System.out.println(min);
		else
			System.out.println(0);
	}

	// ����DFS���ж����߹����ӵĺ�sump�Ƿ����half,����ÿ���ڵ�ǰ�ߵĸ��������������ҳ����߸���
	private void check(int a, int b, int sump, int foot) {
		// ��������Ѿ��߹�
		if (flag[a][b])
			return;

		if (sump > half)
			return;
		if (sump == half && foot < min)
			if (isTwo())
				min = foot;

		for (int i = 0; i < 4; i++) {
			flag[a][b] = true;
			sump += dat[a][b];
			foot++;
			switch (i) {
			// ��
			case 0:
				if (b < n - 1)
					check(a, b + 1, sump, foot);
				break;
			// ��
			case 1:
				if (a < m - 1)
					check(a + 1, b, sump, foot);
				break;
			// ��
			case 2:
				if (b > 0)
					check(a, b - 1, sump, foot);
				break;
			// ��
			case 3:
				if (a > 0)
					check(a - 1, b, sump, foot);
				break;
			}
			flag[a][b] = false;
			sump -= dat[a][b];
			foot--;
		}
	}

	// ����Ƿ���������,������һ��⵽true,��ͳ����������(��������)��true��
	// �����ټ��false,��ͳ����������(��������)��false��.���������ͳ��֮���Ƿ��������
	// ����
	// true true false
	// false true false
	private boolean isTwo() {
		res = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				chk[i][j] = false;

		loop1: for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (flag[i][j]) {
					judge(true, i, j);
					break loop1;
				}

		loop2: for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (!flag[i][j]) {
					judge(false, i, j);
					break loop2;
				}

		if (res == len)
			return true;
		else
			return false;
	}

	private void judge(boolean kind, int a, int b) {
		if (!chk[a][b] && flag[a][b] == kind) {
			res++;
			chk[a][b] = true;

			for (int k = 0; k < 4; k++) {
				switch (k) {
				// ��
				case 0:
					if (b < n - 1)
						judge(kind, a, b + 1);
					break;
				// ��
				case 1:
					if (a < m - 1)
						judge(kind, a + 1, b);
					break;
				// ��
				case 2:
					if (b > 0)
						judge(kind, a, b - 1);
					break;
				// ��
				case 3:
					if (a > 0)
						judge(kind, a - 1, b);
					break;
				}
			}
		}
	}

}
