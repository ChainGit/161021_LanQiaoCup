package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 
 * ������ϰ �������
 * 
 * ��������<br>
 * �����������󣬷ֱ���m*s��s*n��С���������������˵Ľ����<br>
 * �����ʽ<br>
 * ��һ�У��ո����������������m,s,n����������200����<br>
 * ������m�У�ÿ��s���ո��������������ʾ����A��i��j����<br>
 * ������s�У�ÿ��n���ո��������������ʾ����B��i��j����<br>
 * �����ʽ<br>
 * m�У�ÿ��n���ո��������������������ľ���C��i��j����ֵ��<br>
 * ��������<br>
 * 2 3 2<br>
 * 1 0 -1<br>
 * 1 1 -3<br>
 * 0 3<br>
 * 1 2<br>
 * 3 1<br>
 * �������<br>
 * -3 2<br>
 * -8 2<br>
 * 
 * ��ʾ<br>
 * ����CӦ����m��n�У�����C(i,j)���ھ���A��i�������������B��j�����������ڻ���<br>
 * ����������C(1,1)=(1,0,-1)*(0,1,3) = 1 * 0 +0*1+(-1)*3=-3<br>
 * 
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺��ά���� ѭ�� ����
 * 
 * @author Chain
 *
 */
public class Basic17 {

	// nextInt()��ʱ̫��,����һ�ζ���ת������
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int s = in.nextInt();
		int n = in.nextInt();
		int[][] a = new int[m][s];
		int[][] b = new int[s][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < s; j++)
				a[i][j] = in.nextInt();
		for (int i = 0; i < s; i++)
			for (int j = 0; j < n; j++)
				b[i][j] = in.nextInt();
		in.close();

		System.out.println();
		printMatrix(a, m, s);
		System.out.println();
		printMatrix(b, s, n);
		System.out.println();

		// ���������
		int[][] c = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				for (int p = 0; p < s; p++)
					c[i][j] += a[i][p] * b[p][j];

		System.out.println();
		printMatrix(c, m, n);
	}

	private static void printMatrix(int[][] m, int l, int c) {
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < c; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}
}
