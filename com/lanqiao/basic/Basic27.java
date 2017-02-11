package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ 2n�ʺ�����
 * 
 * ��������<br>
 * ����һ��n*n�����̣���������һЩλ�ò��ܷŻʺ�����Ҫ�������з���n���ڻʺ��n���׻ʺ�<br>
 * ʹ����������ڻʺ󶼲���ͬһ�С�ͬһ�л�ͬһ���Խ����ϣ�����������׻ʺ󶼲���ͬһ�С�<br>
 * ͬһ�л�ͬһ���Խ����ϡ����ܹ��ж����ַŷ���nС�ڵ���8�� �����ʽ<br>
 * ����ĵ�һ��Ϊһ������n����ʾ���̵Ĵ�С��<br>
 * ������n�У�ÿ��n��0��1�����������һ������Ϊ1����ʾ��Ӧ��λ�ÿ��ԷŻʺ����һ������Ϊ0����ʾ��Ӧ��λ�ò����ԷŻʺ�<br>
 * �����ʽ<br>
 * ���һ����������ʾ�ܹ��ж����ַŷ���<br>
 * ��������<br>
 * 4<br>
 * 1 1 1 1<br>
 * 1 1 1 1<br>
 * 1 1 1 1<br>
 * 1 1 1 1<br>
 * �������<br>
 * 2<br>
 * ��������<br>
 * 4<br>
 * 1 0 1 1<br>
 * 1 1 1 1<br>
 * 1 1 1 1<br>
 * 1 1 1 1<br>
 * �������<br>
 * 0<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺�ַ��� �����ж�
 * 
 * @author Chain
 *
 */
public class Basic27 {

	private static int bqueen[];// �ڻʺ�
	private static int wqueen[];// �׻ʺ�
	private static boolean chessboard[][];// 1:�ܷ� 0:���ܷ�
	private static int count = 0;
	private static int n;

	// ��k���ʺ󣬼���k�лʺ󣬴洢����ÿһ���ʺ��ڸ��е�λ��j
	private static void putWhiteQueen(int k) {
		int i;
		int j;
		for (i = 0; i < k - 1; i++) {
			// �ж��кͶԽ���
			int judge = wqueen[i] - wqueen[k - 1];
			if (judge == 0 || Math.abs(k - 1 - i) == Math.abs(judge))
				// ������ò��ɹ��򷵻���һ��(��)����
				return;
		}
		// ÿ�γɹ�������׻ʺ�,�ص�������һ�з��úڻʺ�
		if (k == n) {
			// ���׻ʺ�ķ���λ����ʱ��Ϊfalse
			for (int p = 0; p < n; p++)
				chessboard[p][wqueen[p]] = false;
			// ���� blackQueue
			putBlackQueen(0);
			// ���׻ʺ�ķ���λ�ûָ�Ϊtrue
			for (int p = 0; p < n; p++)
				chessboard[p][wqueen[p]] = true;
			return;
		}
		// �ʺ󲻻����ͬһ��
		for (j = 0; j < n; j++) {
			if (chessboard[k][j]) {
				wqueen[k] = j;
				// ���ûʺ�������һ�м�����֤
				putWhiteQueen(k + 1);
			}
		}
	}

	private static void putBlackQueen(int k) {
		int i;
		int j;
		for (i = 0; i < k - 1; i++) {
			int judge = bqueen[i] - bqueen[k - 1];
			if (judge == 0 || Math.abs(k - 1 - i) == Math.abs(judge))
				return;
		}
		// ֻ�е��ڻʺ�Ҳ�ɹ����õ����һ�к�,������óɹ�,count+1
		if (k == n) {
			count++;
			return;
		}
		for (j = 0; j < n; j++) {
			if (chessboard[k][j]) {
				bqueen[k] = j;
				putBlackQueen(k + 1);
			}
		}
	}

	// �ݹ鷨
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		chessboard = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				chessboard[i][j] = in.nextInt() == 1 ? true : false;
		in.close();

		wqueen = new int[n];
		bqueen = new int[n];

		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(chessboard[i][j] + " ");
			System.out.println();
		}
		System.out.println();

		putWhiteQueen(0);// whiteQueue

		System.out.println(count);
	}
}
