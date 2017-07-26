package com.lanqiao.study;

// 在n个球中取m个球(n>=m,不放回)有多少种取法
// Cnm
public class Study01d {

	// 注意理解递归的层次和返回的次序
	public static void main(String[] args) {
		System.out.println(fun1(10, 3));
		System.out.println(fun1(3, 2));
	}

	private static int fun1(int n, int m) {
		if (n < m)
			return 0;

		if (n == m || m == 0)
			return 1;

		// 分成两部分，平地起风雷
		return fun1(n - 1, m - 1) + fun1(n - 1, m);
	}

}
