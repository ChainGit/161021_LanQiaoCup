package com.lanqiao.study;

// �ݹ��ѭ��
// ��ӡ0-9
public class Study01a {

	// ѭ���͵ݹ��������
	// �ݹ���Ҫ�г���,����������ִ����ȥ
	// �ݹ����Ƶ���,���������
	public static void main(String[] args) {
		fun1();
		System.out.println();
		fun2(9, 0);
		System.out.println();
		fun3(0, 9);
	}

	// �ݹ�
	private static void fun3(int begin, final int end) {
		System.out.println(begin);
		if (begin < end)
			fun3(begin + 1, end);
	}

	// �ݹ�
	private static void fun2(int begin, final int end) {
		if (begin > end)
			fun2(begin - 1, end);
		System.out.println(begin);
	}

	// ѭ��
	private static void fun1() {
		for (int i = 0; i < 10; i++)
			System.out.println(i);
	}
}
