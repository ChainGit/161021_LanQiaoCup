package com.lanqiao.study;

//整数划分
public class Study02d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[6];
		fun(6, a, 0);
	}

	// 借用缓存数组
	private static void fun(int m, int[] a, int p) {
		if (m < 1) {
			for (int i = 0; i < p; i++) {
				System.out.print(a[i]);
				if (i != p - 1)
					System.out.print('+');
			}
			System.out.println();
			return;
		}

		for (int i = m; i > 0; i--) {
			if (p > 0 && i > a[p - 1])
				continue;
			a[p] = i;
			fun(m - i, a, p + 1);
		}
	}

}
