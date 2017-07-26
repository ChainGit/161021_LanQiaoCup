package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ �ַ����Ա�
 * 
 * �����������ɴ�д��ĸ��Сд��ĸ��ɵ��ַ���(���Ƚ���1��10֮��)������֮��Ĺ�ϵ������4�����֮һ��<br>
 * 1�������ַ������Ȳ��ȡ����� Beijing �� Hebei<br>
 * 2�������ַ�������������ȣ�������Ӧλ���ϵ��ַ���ȫһ��(���ִ�Сд)������ Beijing �� Beijing<br>
 * 3�������ַ���������ȣ���Ӧλ���ϵ��ַ����ڲ����ִ�Сд��ǰ���²��ܴﵽ��ȫһ�£�Ҳ����˵���������������2�������� beijing ��
 * BEIjing<br>
 * 4�������ַ���������ȣ����Ǽ�ʹ�ǲ����ִ�СдҲ����ʹ�������ַ���һ�¡����� Beijing �� Nanjing<br>
 * ����ж�����������ַ���֮��Ĺ�ϵ�����������е���һ�࣬������������ı�š�<br>
 * �����ʽ<br>
 * �������У�ÿ�ж���һ���ַ���<br>
 * �����ʽ<br>
 * ����һ�����֣������������ַ����Ĺ�ϵ���<br>
 * ��������<br>
 * BEIjing<br>
 * beiJing<br>
 * �������<br>
 * 3<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺�ַ��� ��Сд
 * 
 * @author Chain
 *
 */
public class Basic15 {

	// ���������ȡ���Сд����λ�Ƚ�
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		in.close();

		System.out.println(test1(s1, s2));
		System.out.println(test2(s1, s2));
	}

	// ʹ��JavaAPI
	private static int test1(String s1, String s2) {
		if (s1.length() != s2.length())
			return 1;
		else {
			if (s1.equals(s2))
				return 2;
			else if (s1.toLowerCase().equals(s2.toLowerCase()))
				return 3;
			else
				return 4;
		}
		// return -1;
	}

	// �Զ���equals����
	private static int test2(String s1, String s2) {
		if (s1.length() != s2.length())
			return 1;
		else {
			if (myEquals(s1, s2))
				return 2;
			else if (myEquals(myToLowerCase(s1), myToLowerCase(s2)))
				return 3;
			else
				return 4;
		}
		// return -1;
	}

	// ת��ĸΪСд
	private static String myToLowerCase(String s) {
		char[] a = s.toCharArray();
		for (int i = 0; i < a.length; i++)
			if (a[i] > 64 && a[i] < 91)
				a[i] += 32;
		return new String(a);
	}

	// �ȳ��ַ���,����Ƚ�
	private static boolean myEquals(String s1, String s2) {
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		int len1 = a1.length;
		int len2 = a2.length;
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

}
