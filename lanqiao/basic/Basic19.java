package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ �����Ĵ���
 * 
 * ���Ĵ�����һ��������ַ��������������Ҷ��ʹ����������һ���ġ�С������Ϊ���Ĵ����������ġ����ڸ���һ����������һ���ǻ��ĵģ�����������ٵĽ�������ʹ�øô����һ�������Ļ��Ĵ���<br>
 * �����Ķ����ǣ������������ڵ��ַ�<br>
 * ����mamad<br>
 * ��һ�ν��� ad : mamda<br>
 * �ڶ��ν��� md : madma<br>
 * �����ν��� ma : madam (���ģ�������)<br>
 * �����ʽ<br>
 * ��һ����һ������N����ʾ���������ַ����ĳ���(N <= 8000)<br>
 * �ڶ�����һ���ַ���������ΪN.ֻ����Сд��ĸ<br>
 * �����ʽ<br>
 * ������ܣ�������ٵĽ���������<br>
 * �������Impossible<br>
 * ��������<br>
 * 5<br>
 * mamad<br>
 * �������<br>
 * 3<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺̰���㷨
 * 
 * @author Chain
 *
 */
public class Basic19 {

	/**
	 * ˼·�� ̰�ķ�,�ڶ��������ʱ�����������ڵ�ǰ������õ�ѡ��Ҳ����˵�������������Ž���������ǣ����������Ľ�����ĳ�������ϵľֲ����Ž⡣
	 * 
	 * ����ʹ�õ�iλ�������last-iλһ��,���������
	 * 
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int n = in.nextInt();
		String s = in.next();
		in.close();
		char[] str = s.toCharArray();
		int step = 0;
		for (int i = 0; i < n; i++) {
			int p = n - 1 - i;
			int j = i + 1;
			boolean isAlone = true;
			for (; j < n; j++)
				if (str[i] == str[j]) {
					isAlone = false;
					break;
				}
			if (!isAlone && j != i && j != p && j < n) {
				// ��������Ҫ���ڽ����Ĵ���
				step += n - j;
				// �˴�ֱ�ӽ���
				swap(str, p, j);
				print(str);
			}
		}
		System.out.println(step);
	}

	private static void swap(char[] str, int i, int j) {
		char tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}

	private static void print(char[] str) {
		for (int i = 0; i < str.length; i++)
			System.out.print(str[i]);
		System.out.println();
	}

}
