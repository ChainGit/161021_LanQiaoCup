package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ ����ȡ��
 * 
 * ��������<br>
 * ����ȡ�������ؾ���ı�ȡ��������ǰ������������ȡ���Ѿ�ȡ��������ת90�ȡ�һ��ʼλ�ھ������Ͻǣ��������¡�<br>
 * �����ʽ<br>
 * �����һ��������������200��������m, n����ʾ������к��С�������m��ÿ��n����������ʾ�������<br>
 * �����ʽ<br>
 * ���ֻ��һ�У���mn������Ϊ����������ȡ���õ��Ľ������֮����һ���ո�ָ�����ĩ��Ҫ�ж���Ŀո�<br>
 * ��������<br>
 * 3 3<br>
 * 1 2 3<br>
 * 4 5 6<br>
 * 7 8 9<br>
 * �������<br>
 * 1 4 7 8 9 6 3 2 5<br>
 * ��������<br>
 * 3 2<br>
 * 1 2<br>
 * 3 4<br>
 * 5 6<br>
 * �������<br>
 * 1 3 5 6 4 2<br>
 * 
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺��ά���� ѭ��
 * 
 * @author Chain
 *
 */
public class Basic25 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] a = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = in.nextInt();
		in.close();

		System.out.println();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}

		// 4��ȡ���ݷ�ʽ
		int i = 0;
		int j = 0;
		while (a[i][j] != -1) {

			// ����
			while (i < m && a[i][j] != -1) {
				System.out.print(a[i][j] + " ");
				a[i++][j] = -1;
			}

			i--;
			j++;

			// ����
			while (j < n && a[i][j] != -1) {
				System.out.print(a[i][j] + " ");
				a[i][j++] = -1;
			}

			i--;
			j--;

			// ����
			while (i > -1 && a[i][j] != -1) {
				System.out.print(a[i][j] + " ");
				a[i--][j] = -1;
			}

			i++;
			j--;

			// ����
			while (j > -1 && a[i][j] != -1) {
				System.out.print(a[i][j] + " ");
				a[i][j--] = -1;
			}

			i++;
			j++;
		}
		System.out.println();
	}

}
