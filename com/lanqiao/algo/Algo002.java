package com.lanqiao.algo;

import java.util.Scanner;

/**
 * �㷨ѵ�� �����С������
 * 
 * ��������<br>
 * ��֪һ��������N���ʴ�1~N����ѡ�������������ǵ���С������������Ϊ���١�<br>
 * 
 * �����ʽ<br>
 * ����һ��������N��<br>
 * 
 * �����ʽ<br>
 * ���һ����������ʾ���ҵ�����С��������<br>
 * ��������<br>
 * 9<br>
 * �������<br>
 * 504<br>
 * ���ݹ�ģ��Լ��<br>
 * 1 <= N <= 106��<br>
 * 
 * �ܽ᣺̰��
 * 
 * @author Chain
 *
 */
public class Algo002 {

	// ǰ��������������������
	// ժ�ԣ�http://www.cnblogs.com/PJQOOO/p/4394313.html
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		long s = 0;

		// �ٷ����ݲ���ʧ��
		// 95152*95151*95150=861460772824848
		// ��95152��ż��
		if (n % 2 != 0)
			s = (long) (n * (n - 1) * (n - 2));
		else if (n % 3 != 0)
			s = (long) (n * (n - 1) * (n - 3));
		else
			s = (long) ((n - 1) * (n - 2) * (n - 3));

		System.out.println(s & 0xffff_ffff);

	}
}
