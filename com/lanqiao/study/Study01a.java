package com.lanqiao.study;

// 递归和循环
// 打印0-9
public class Study01a {

	// 循环和递归的相似性
	// 递归需要有出口,不能无限制执行下去
	// 递归类似递推,技巧添参数
	public static void main(String[] args) {
		fun1();
		System.out.println();
		fun2(9, 0);
		System.out.println();
		fun3(0, 9);
	}

	// 递归
	private static void fun3(int begin, final int end) {
		System.out.println(begin);
		if (begin < end)
			fun3(begin + 1, end);
	}

	// 递归
	private static void fun2(int begin, final int end) {
		if (begin > end)
			fun2(begin - 1, end);
		System.out.println(begin);
	}

	// 循环
	private static void fun1() {
		for (int i = 0; i < 10; i++)
			System.out.println(i);
	}
}
