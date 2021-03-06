package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基本练习 报时助手
 * 
 * 问题描述<br>
 * 给定当前的时间，请用英文的读法将它读出来。<br>
 * 时间用时h和分m表示，在英文的读法中，读一个时间的方法是：<br>
 * 如果m为0，则将时读出来，然后加上“o'clock”，如3:00读作“three o'clock”。<br>
 * 如果m不为0，则将时读出来，然后将分读出来，如5:30读作“five thirty”。<br>
 * 时和分的读法使用的是英文数字的读法，其中0~20读作：<br>
 * 0:zero, 1: one, 2:two, 3:three, 4:four, 5:five, 6:six, 7:seven, 8:eight,
 * 9:nine, 10:ten, 11:eleven, 12:twelve,<br>
 * 13:thirteen, 14:fourteen, 15:fifteen, 16:sixteen, 17:seventeen, 18:eighteen,
 * 19:nineteen, 20:twenty。<br>
 * 30读作thirty，40读作forty，50读作fifty。<br>
 * 对于大于20小于60的数字，首先读整十的数，然后再加上个位数。如31首先读30再加1的读法，读作“thirty one”。<br>
 * 按上面的规则21:54读作“twenty one fifty four”，9:07读作“nine seven”，0:15读作“zero
 * fifteen”。<br>
 * 输入格式<br>
 * 输入包含两个非负整数h和m，表示时间的时和分。非零的数字前没有前导0。h小于24，m小于60。<br>
 * 输出格式<br>
 * 输出时间时刻的英文。<br>
 * 样例输入<br>
 * 0 15<br>
 * 样例输出<br>
 * zero fifteen<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：字符串 条件判断
 * 
 * @author Chain
 *
 */
public class Basic26 {

	private static final String[] ts = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen", "twenty", "thirty", "forty", "fifty" };// 21 22 23

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		in.close();

		System.out.println(h + ":" + m);

		System.out.print(ts[h] + " ");
		if (m < 20)
			System.out.println(ts[m]);
		else {
			System.out.print(ts[20 + (m - 20) / 10] + " ");
			System.out.println(ts[m % 10]);
		}
	}

}
