package com.lanqiao.study;

// 数组的求和
public class Study01b {

	// 递归类似踢皮球,一级一级做,其他的交给别人
	public static void main(String[] args) {
		int[] a = new int[] { 1, 4, 2, 5, 1 };

		System.out.println(fun1(a));
		System.out.println(fun2(a, 0));
		System.out.println(fun3(a, a.length - 1));
		System.out.println(fun4(a));
	}

	private static int fun4(int[] a) {
		int mid = a.length >>> 1;
		return fun4x(a, 0, mid) + fun4x(a, mid, a.length);
	}

	// [from,to)
	private static int fun4x(int[] a, final int from, final int to) {
		if (from >= to)
			return 0;
		return a[from] + fun4x(a, from + 1, to);
	}

	private static int fun3(int[] a, final int index) {
		if (index < 0)
			return 0;
		return a[index] + fun3(a, index - 1);
	}

	private static int fun2(int[] a, final int index) {
		if (index >= a.length)
			return 0;
		return a[index] + fun2(a, index + 1);
	}

	private static int fun1(int[] a) {
		int sum = 0;
		for (int i : a)
			sum += i;
		return sum;
	}

}
