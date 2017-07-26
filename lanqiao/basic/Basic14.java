package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 时间转换
 * 
 * 给定一个以秒为单位的时间t，要求用H:M:S的格式来表示这个时间。<br>
 * H表示时间，M表示分钟，而S表示秒，它们都是整数且没有前导的“0”。<br>
 * 例如，若t=0，则应输出是“0:0:0”；若t=3661，则输出“1:1:1”。
 * 
 * 输入格式 输入只有一行，是一个整数t（0<=t<=86399）。 <br>
 * 输出格式 输出只有一行，是以“H:M:S”的格式所表示的时间，不包括引号。<br>
 * 样例输入 0 样例输出 0:0:0 <br>
 * 样例输入 5436 样例输出 1:30:36<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：取余 数字字符混合输出
 * 
 * @author Chain
 *
 */
public class Basic14 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		test1(n);
		test2(n);
		test3(n);
	}

	// 水仙花数做法
	private static void test1(int n) {
		int hour = n / 3600;
		int min = n % 3600 / 60;
		int sec = n % 60;
		System.out.println(hour + ":" + min + ":" + sec);
	}

	// 加减法做法
	private static void test2(int n) {
		int hour = n / 3600;
		int tmp = n - hour * 3600;
		int min = tmp / 60;
		int sec = tmp - min * 60;
		System.out.println(hour + ":" + min + ":" + sec);
	}

	// 正向循环,因为输入t不大,t最大为一天的秒数24*60*60-1
	private static void test3(int n) {
		for (int h = 0; h < 24; h++)
			for (int m = 0; m < 59; m++)
				for (int s = 0; s < 59; s++)
					if (s + m * 60 + h * 3600 == n)
						System.out.println(h + ":" + m + ":" + s);
	}
}
