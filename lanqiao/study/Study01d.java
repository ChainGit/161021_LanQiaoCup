package com.lanqiao.study;

// ��n������ȡm����(n>=m,���Ż�)�ж�����ȡ��
// Cnm
public class Study01d {

	// ע�����ݹ�Ĳ�κͷ��صĴ���
	public static void main(String[] args) {
		System.out.println(fun1(10, 3));
		System.out.println(fun1(3, 2));
	}

	private static int fun1(int n, int m) {
		if (n < m)
			return 0;

		if (n == m || m == 0)
			return 1;

		// �ֳ������֣�ƽ�������
		return fun1(n - 1, m - 1) + fun1(n - 1, m);
	}

}
