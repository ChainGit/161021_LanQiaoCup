package com.lanqiao.study;

//m��A,n��B�ܹ���������
public class Study02c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fun(3, 2));
	}

	// ����ĸ�ֳ�������Ӫ
	private static int fun(int m, int n) {
		// TODO Auto-generated method stub
		if (m == 0 || n == 0)
			return 1;
		return fun(m - 1, n) + fun(m, n - 1);
	}

}
