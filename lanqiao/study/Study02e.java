package com.lanqiao.study;

//©�����˵���
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

		// ��ǰ©ѡ
		flag[p] = false;
		fun(p + 1, sum);

		// ��ǰδ©ѡ
		sum += dat[p];
		flag[p] = true;
		fun(p + 1, sum);

		// ����ѡ����ûѡ������Ϊûѡ������
		flag[p] = false;
	}

}
