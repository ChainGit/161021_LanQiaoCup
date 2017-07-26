package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ ʱ��ת��
 * 
 * ����һ������Ϊ��λ��ʱ��t��Ҫ����H:M:S�ĸ�ʽ����ʾ���ʱ�䡣<br>
 * H��ʾʱ�䣬M��ʾ���ӣ���S��ʾ�룬���Ƕ���������û��ǰ���ġ�0����<br>
 * ���磬��t=0����Ӧ����ǡ�0:0:0������t=3661���������1:1:1����
 * 
 * �����ʽ ����ֻ��һ�У���һ������t��0<=t<=86399���� <br>
 * �����ʽ ���ֻ��һ�У����ԡ�H:M:S���ĸ�ʽ����ʾ��ʱ�䣬���������š�<br>
 * �������� 0 ������� 0:0:0 <br>
 * �������� 5436 ������� 1:30:36<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺ȡ�� �����ַ�������
 * 
 * @author Chain
 *
 */
public class Basic14 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		test1(n);
		test2(n);
		test3(n);
	}

	// ˮ�ɻ�������
	private static void test1(int n) {
		int hour = n / 3600;
		int min = n % 3600 / 60;
		int sec = n % 60;
		System.out.println(hour + ":" + min + ":" + sec);
	}

	// �Ӽ�������
	private static void test2(int n) {
		int hour = n / 3600;
		int tmp = n - hour * 3600;
		int min = tmp / 60;
		int sec = tmp - min * 60;
		System.out.println(hour + ":" + min + ":" + sec);
	}

	// ����ѭ��,��Ϊ����t����,t���Ϊһ�������24*60*60-1
	private static void test3(int n) {
		for (int h = 0; h < 24; h++)
			for (int m = 0; m < 59; m++)
				for (int s = 0; s < 59; s++)
					if (s + m * 60 + h * 3600 == n)
						System.out.println(h + ":" + m + ":" + s);
	}
}
