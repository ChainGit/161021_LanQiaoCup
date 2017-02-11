package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ �߾��ȼӷ�
 * 
 * ��������<br>
 * ����һ��������n�����n!��ֵ��<br>
 * ����n!=1*2*3*��*n��<br>
 * �㷨����<br>
 * n!���ܴܺ󣬶�������ܱ�ʾ��������Χ���ޣ���Ҫʹ�ø߾��ȼ���ķ�����ʹ��һ������A����ʾһ��������a��A[0]��ʾa�ĸ�λ��A[1]��ʾa��ʮλ���������ơ�<br>
 * ��a����һ������k��Ϊ������A��ÿһ��Ԫ�ض�����k����ע�⴦����Ӧ�Ľ�λ��<br>
 * ���Ƚ�a��Ϊ1��Ȼ���2����3�����˵�nʱ�����õ���n!��ֵ��<br>
 * �����ʽ<br>
 * �������һ��������n��n<=1000��<br>
 * �����ʽ<br>
 * ���n!��׼ȷֵ��<br>
 * ��������<br>
 * 10<br>
 * �������<br>
 * 3628800<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺�߾���
 * 
 * @author Chain
 *
 */
public class Basic30 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		// ��ʼ���ݳ���ֵΪ4000,��ʼ����ֵ�൱��1
		// ��̬�ڴ��ٿ��ٱȽϺ�ʱ,��ֱ������4000,ֻ��4M�ڴ�ռ��
		byte[] d = new byte[4000];
		d[d.length - 1] = 1;

		for (int i = 1; i <= n; i++) {
			int r = 0;
			int zelen = getZeroLength(d);
			int j = d.length - 1;
			for (; j > zelen - 1; j--) {
				int t = d[j] * i + r;
				d[j] = (byte) (t % 10);
				r = t / 10;
			}
			while (r != 0) {
				d[j--] = (byte) (r % 10);
				r /= 10;
			}
			print(i, d);
		}
	}

	private static void print(int n, byte[] d) {
		int zelen = getZeroLength(d);
		System.out.print(n + "!=");
		for (int i = zelen; i < d.length; i++)
			System.out.print(d[i]);
		System.out.println();
	}

	private static int getZeroLength(byte[] data) {
		for (int i = 0; i < data.length; i++)
			if (data[i] != 0)
				return i;
		return 0;
	}

}
