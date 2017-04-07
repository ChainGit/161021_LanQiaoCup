package com.lanqiao.study;

//两个字符串的最大公共子序列的长度
//算法：可解，可行（优化）
public class Study01f {

	// 递归不断降低问题的规模，递归传递的参数至少一个是变化的
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fun("aasopc", "davfs"));
	}

	// 平地起风雷
	private static int fun(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0)
			return 0;

		if (s1.charAt(0) == s2.charAt(0))
			return fun(s1.substring(1), s2.substring(1)) + 1;
		else
			return Math.max(fun(s1.substring(1), s2), fun(s1, s2.substring(1)));
	}

}
