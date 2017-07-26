package com.lanqiao.study;

//漏掉的账单项
public class Study02e {

	private static int[] dat = { 3, 2, 4, 3, 1 };
	private static int actualSum = 6;
	private static boolean[] flag = new boolean[6];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun(0, 0);
	}

	private static void fun(int p, int sum) {
		if (sum > actualSum)
			return;

		if (sum == actualSum) {
			for (int i = 0; i < dat.length; i++)
				if (!flag[i])
					System.out.print(i + ":" + dat[i] + " ");
			System.out.println();
			return;
		}

		if (p >= dat.length)
			return;

		// 当前漏选
		flag[p] = false;
		fun(p + 1, sum);

		// 当前未漏选
		sum += dat[p];
		flag[p] = true;
		fun(p + 1, sum);

		// 无论选还是没选都重置为没选，回溯
		flag[p] = false;
	}

}
