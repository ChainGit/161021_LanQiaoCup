package com.lanqiao.study;

//n个元素的全排列
public class Study01e {

	// 回溯
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a = "ABC".toCharArray();
		fun1(a, 0);
	}

	private static void fun1(char[] a, int index) {
		if (index == a.length)
			System.out.println(a);

		for (int i = index; i < a.length; i++) {
			swap(a, i, index);
			fun1(a, index + 1);
			swap(a, i, index);
		}
	}

	private static void swap(char[] a, int i, int j) {
		if (i == j)
			return;

		char t = 0;
		t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
