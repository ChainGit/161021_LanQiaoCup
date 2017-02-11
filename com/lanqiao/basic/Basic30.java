package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 高精度加法
 * 
 * 问题描述<br>
 * 输入一个正整数n，输出n!的值。<br>
 * 其中n!=1*2*3*…*n。<br>
 * 算法描述<br>
 * n!可能很大，而计算机能表示的整数范围有限，需要使用高精度计算的方法。使用一个数组A来表示一个大整数a，A[0]表示a的个位，A[1]表示a的十位，依次类推。<br>
 * 将a乘以一个整数k变为将数组A的每一个元素都乘以k，请注意处理相应的进位。<br>
 * 首先将a设为1，然后乘2，乘3，当乘到n时，即得到了n!的值。<br>
 * 输入格式<br>
 * 输入包含一个正整数n，n<=1000。<br>
 * 输出格式<br>
 * 输出n!的准确值。<br>
 * 样例输入<br>
 * 10<br>
 * 样例输出<br>
 * 3628800<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：高精度
 * 
 * @author Chain
 *
 */
public class Basic30 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		// 初始数据长度值为4000,初始数据值相当于1
		// 动态内存再开辟比较耗时,故直接设置4000,只有4M内存占用
		byte[] d = new byte[4000];
		d[d.length - 1] = 1;

		for (int i = 1; i <= n; i++) {
			int r = 0;
			int zelen = getZeroLength(d);
			int j = d.length - 1;
			for (; j > zelen - 1; j--) {
				int t = d[j] * i + r;
				d[j] = (byte) (t % 10);
				r = t / 10;
			}
			while (r != 0) {
				d[j--] = (byte) (r % 10);
				r /= 10;
			}
			print(i, d);
		}
	}

	private static void print(int n, byte[] d) {
		int zelen = getZeroLength(d);
		System.out.print(n + "!=");
		for (int i = zelen; i < d.length; i++)
			System.out.print(d[i]);
		System.out.println();
	}

	private static int getZeroLength(byte[] data) {
		for (int i = 0; i < data.length; i++)
			if (data[i] != 0)
				return i;
		return 0;
	}

}
