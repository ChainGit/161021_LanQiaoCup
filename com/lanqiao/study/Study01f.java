package com.lanqiao.study;

//�����ַ�������󹫹������еĳ���
//�㷨���ɽ⣬���У��Ż���
public class Study01f {

	// �ݹ鲻�Ͻ�������Ĺ�ģ���ݹ鴫�ݵĲ�������һ���Ǳ仯��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fun("aasopc", "davfs"));
	}

	// ƽ�������
	private static int fun(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0)
			return 0;

		if (s1.charAt(0) == s2.charAt(0))
			return fun(s1.substring(1), s2.substring(1)) + 1;
		else
			return Math.max(fun(s1.substring(1), s2), fun(s1, s2.substring(1)));
	}

}
