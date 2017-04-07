package com.lanqiao.study;

//�ַ������
public class Study01c {

	// û��������,���Ҹ�������������ԵĲ���
	// �ݹ���ջ����
	public static void main(String[] args) {
		String s1 = "123";
		String s2 = "123";

		System.out.println(s1.equals(s2));
		System.out.println(fun1(s1, s2));
		System.out.println(fun2(s1, s2));
	}

	private static boolean fun2(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		if (c1.length != c2.length)
			return false;

		return fun2x(c1, c2, 0);
	}

	private static boolean fun2x(char[] c1, char[] c2, int index) {
		if (index >= c1.length)
			return true;

		if (c1[index] != c2[index])
			return false;
		else
			return fun2x(c1, c2, index + 1);
	}

	private static boolean fun1(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		if (c1.length != c2.length)
			return false;

		for (int i = 0; i < c1.length; i++)
			if (c1[i] != c2[i])
				return false;

		return true;
	}

}
