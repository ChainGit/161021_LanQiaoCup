package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 高精度加法
 * 
 * 问题描述<br>
 * 输入两个整数a和b，输出这两个整数的和。a和b都不超过100位。<br>
 * 算法描述<br>
 * 由于a和b都比较大，所以不能直接使用语言中的标准数据类型来存储。对于这种问题，一般使用数组来处理。<br>
 * 定义一个数组A，A[0]用于存储a的个位，A[1]用于存储a的十位，依此类推。同样可以用一个数组B来存储b。<br>
 * 计算c = a +
 * b的时候，首先将A[0]与B[0]相加，如果有进位产生，则把进位（即和的十位数）存入r，把和的个位数存入C[0]，即C[0]等于(A[0]+B[0])%10。<br>
 * 然后计算A[1]与B[1]相加，这时还应将低位进上来的值r也加起来，即C[1]应该是A[1]、B[1]和r三个数的和．如果又有进位产生，<br>
 * 则仍可将新的进位存入到r中，和的个位存到C[1]中。依此类推，即可求出C的所有位。<br>
 * 最后将C输出即可。<br>
 * 输入格式<br>
 * 输入包括两行，第一行为一个非负整数a，第二行为一个非负整数b。两个整数都不超过100位，两数的最高位都不是0。<br>
 * 输出格式<br>
 * 输出一行，表示a + b的值。<br>
 * 样例输入<br>
 * 20100122201001221234567890<br>
 * 2010012220100122<br>
 * 样例输出<br>
 * 20100122203011233454668012<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：数组 高精度
 * 
 * @author Chain
 *
 */
public class Basic29 {

	// 其实就是计算机内部加法的实现
	// 十进制
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String sa = in.nextLine();
		String sb = in.nextLine();
		in.close();

		char[] ca = sa.toCharArray();
		char[] cb = sb.toCharArray();

		int lena = ca.length;
		int lenb = cb.length;

		int[] a = new int[lena];
		int[] b = new int[lenb];
		for (int i = 0; i < lena; i++)
			a[i] = ca[i] - 48;
		for (int i = 0; i < lenb; i++)
			b[i] = cb[i] - 48;

		int[] max = lena > lenb ? a : b;
		int[] min = lena > lenb ? b : a;

		int lemax = max.length;
		int lemin = min.length;
		int delta = lemax - lemin;

		System.out.print(' ');
		for (int i = 0; i < lemax; i++)
			System.out.print(max[i]);
		System.out.println();

		System.out.print('+');
		for (int i = 0; i < delta; i++)
			System.out.print(' ');
		for (int i = 0; i < lemin; i++)
			System.out.print(min[i]);
		System.out.println();

		int r = 0;
		int t = -1;
		int[] c = new int[lemax];
		for (int i = lemax - 1; i > -1; i--) {
			if (i >= delta)
				t = min[i - delta] + max[i] + r;
			else
				t = max[i] + r;
			c[i] = t % 10;
			r = t / 10;
		}

		for (int i = 0; i < lemax + 1; i++)
			System.out.print('-');
		System.out.println();

		if (r != 0)
			System.out.print(r);
		else
			System.out.print(' ');
		for (int i = 0; i < c.length; i++)
			System.out.print(c[i]);
		System.out.println();

	}

}
