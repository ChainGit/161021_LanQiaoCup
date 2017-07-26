package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 矩形面积交
 * 
 * 问题描述 <br>
 * 平面上有两个矩形，它们的边平行于直角坐标系的X轴或Y轴。对于每个矩形，我们 <br>
 * 给出它的一对相对顶点的坐标，请你编程算出两个矩形的交的面积。 <br>
 * 输入格式 <br>
 * 输入仅包含两行，每行描述一个矩形。 <br>
 * 在每行中，给出矩形的一对相对顶点的坐标，每个点的坐标都用两个绝对值不超过 <br>
 * 10^7的实数表示。 <br>
 * 输出格式 <br>
 * 输出仅包含一个实数，为交的面积，保留到小数后两位。 <br>
 * 样例输入 <br>
 * 1 1 3 3 <br>
 * 2 2 4 4 <br>
 * 样例输出 <br>
 * 1.00 <br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：判断 线段交
 * 
 * @author Chain
 *
 */
public class Basic18 {

	// 参考：http://blog.csdn.net/liukx940818/article/details/44197183
	public static void main(String[] args) {
		double x[] = new double[4];
		double y[] = new double[4];
		// 相对顶点的两个矩形坐标
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		in.close();

		// 先转成主对角线坐标
		sort(x, 1, 0);
		sort(x, 3, 2);
		sort(y, 0, 1);
		sort(y, 2, 3);

		System.out.println("Ax1=" + x[0] + " Ay1=" + y[0] + " Ax2=" + x[1] + " Ay2=" + y[1]);
		System.out.println("Bx1=" + x[2] + " By1=" + y[2] + " Bx2=" + x[3] + " By2=" + y[3]);

		// 判断是否相离
		if (checkIsCross(x, y))
			System.out.println(String.format("%.2f", sort2(x.clone()) * sort2(y.clone())));
		else
			System.out.println("0.00");

	}

	// 将两个矩形的横坐标或纵坐标升序排序
	private static double sort2(double[] d) {
		// 选择排序
		for (int i = 0; i < d.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < d.length; j++)
				if (d[j] < d[min])
					min = j;
			if (min != i)
				swap(d, min, i);
		}
		return d[2] - d[1];
	}

	// 保持使得d[i]>d[j]
	private static void sort(double[] d, int i, int j) {
		if (d[i] < d[j]) {
			swap(d, i, j);
		}
	}

	// 交换实数只能用中间变量法,因为实数的存储方式不同于整数
	private static void swap(double[] d, int i, int j) {
		double tmp = d[i];
		d[i] = d[j];
		d[j] = tmp;
	}

	// 判断是否相离,边比较,不用勾股定理,因为存在误差
	private static boolean checkIsCross(double[] x, double[] y) {
		if (x[1] <= x[2] || x[0] >= x[3] || y[0] <= y[3] || y[1] >= y[2])
			return false;
		return true;
	}

}