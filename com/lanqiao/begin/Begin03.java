package com.lanqiao.begin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 问题描述 : 给定圆的半径r，求圆的面积。
 * 输入格式 : 输入包含一个整数r，表示圆的半径。
 * 输出格式 : 输出一行，包含一个实数，四舍五入保留小数点后7位，表示圆的面积。
 * 样例输入 : 4
 * 样例输出 : 50.2654825
 * 数据规模与约定 : 1 <= r <= 10000。
 * 
 * 总结：浮点数的处理，保留小数点的方法，四舍五入的注意事项，实数输出
 * 
 * @author Lenovo
 *
 */
public class Begin03 {

	private static final int SCALE = 7;

	public static void main(String[] args) {
		double area = 4 * Math.atan(1);// PI=3.14159265358979323
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		r *= r;
		area *= r;
		System.out.println(new BigDecimal(area).setScale(SCALE, RoundingMode.HALF_UP).doubleValue());
		System.out.println(new DecimalFormat("#.0000000").format(area));
		System.out.println(String.format("%.7f", area));// 这个测试100分
		in.close();
	}
}
