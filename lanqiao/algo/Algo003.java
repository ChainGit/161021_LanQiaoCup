package com.lanqiao.algo;

import java.util.Scanner;

/**
 * �㷨ѵ�� K����
 * 
 * ��������<br>
 * ���һ����Ȼ��N��K���Ʊ�ʾ����������ڵ���λ���������ڵ����֣���ô���Ǿ�˵�������K��������LλK��������K��������Ŀ��<br>
 * ����K = 4��L = 2��ʱ������K����Ϊ11��13��20��22��30��31��33 ��7����<br>
 * ���������Ŀ�ܴ������������1000000007ȡģ���ֵ��
 * 
 * �����ʽ<br>
 * �������������������K��L��<br>
 * 
 * �����ʽ<br>
 * ���һ����������ʾ�𰸶�1000000007ȡģ���ֵ��<br>
 * ��������<br>
 * 4 2<br>
 * �������<br>
 * 7<br>
 * ���ݹ�ģ��Լ��<br>
 * ����30%�����ݣ�KL <= 106��<br>
 * 
 * ����50%�����ݣ�K <= 16�� L <= 10��<br>
 * 
 * ����100%�����ݣ�1 <= K,L <= 100��<br>
 * 
 * �ܽ᣺ ��̬�滮
 * 
 * @author Chain
 *
 */
public class Algo003 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();// k����
		int l = in.nextInt();// lλ
		in.close();

		int mod = 1000000007;

		// ��̬�滮����ʾ����Ϊl,��β����Ϊk
		int[][] dat = new int[l][k];
		// ������Ϊ1ʱ,k���Ƶ�����������k����
		for (int j = 1; j < k; j++)
			dat[0][j] = 1;

		// �ӳ���Ϊ2��ʼ,�𲽽��ÿһ������iʱ���ж������
		for (int i = 1; i < l; i++)
			// ��i-1��
			for (int m = 0; m < k; m++)
				// ��i��
				for (int n = 0; n < k; n++)
					if (n != m - 1 && n != m + 1)
						// ����Ϊiʱ�Ŀ���Ϊ��һ�����ܵĺ�,״̬ת��
						dat[i][m] = (dat[i][m] + dat[i - 1][n]) % mod;

		int x = 0;
		for (int i = 0; i < k; i++)
			x = (x + dat[l - 1][i]) % mod;

		System.out.println(x % mod);
	}
}
