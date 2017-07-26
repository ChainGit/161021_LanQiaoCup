package com.lanqiao.match.province;

import java.util.Scanner;
import java.util.TreeSet;

/*
 7，日期问题

小明正在整理一批历史文献。这些历史文献中出现了很多日期。小明知道这些日期都在1960年1月1日至2059年12月31日。
令小明头疼的是，这些日期采用的格式非常不统一，有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的。
更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应。  

比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。  

给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗？

输入
----
一个日期，格式是"AA/BB/CC"。  (0 <= A, B, C <= 9)  

输出
----
输出若干个不相同的日期，每个日期一行，格式是"yyyy-MM-dd"。多个日期按从早到晚排列。  

样例输入
----
02/03/04  

样例输出
----
2002-03-04  
2004-02-03  
2004-03-02  

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

分析：只有三种情况，枚举即可。再判断闰年、月份日期、年份以60区分
 */
public class Main07 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();

		int[][] dat = new int[3][3];
		int[][] pro = new int[3][3];

		String[] sp = s.split("/");

		make(dat, sp);

		boolean[] ck = new boolean[3];
		ck[0] = judge1(dat[0], pro[0]);
		ck[1] = judge2(dat[1], pro[1]);
		ck[2] = judge3(dat[2], pro[2]);

		print(pro, ck);
	}

	// 日/月/年
	private static boolean judge3(int[] is, int[] pro) {
		pro[0] = is[2];
		pro[1] = is[1];
		pro[2] = is[0];

		return judge(pro);
	}

	// 月/日/年
	private static boolean judge2(int[] is, int[] pro) {
		pro[0] = is[2];
		pro[1] = is[0];
		pro[2] = is[1];

		return judge(pro);
	}

	// 年/月/日
	private static boolean judge1(int[] is, int[] pro) {
		pro[0] = is[0];
		pro[1] = is[1];
		pro[2] = is[2];

		return judge(pro);
	}

	private static boolean judge(int[] pro) {
		int year = pro[0];
		int month = pro[1];
		int day = pro[2];
		year = getYear(year);
		pro[0] = year;
		if (checkMonth(month) && checkDay(year, month, day))
			return true;
		return false;
	}

	// 检查闰年
	private static boolean checkYear(int y) {
		if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
			return true;
		return false;
	}

	// 确定年份区间
	private static int getYear(int y) {
		if (y > 59 && y < 100)
			y = 1900 + y;
		else if (y > -1 && y < 60)
			y = 2000 + y;
		return y;
	}

	// 检查月份
	private static boolean checkMonth(int m) {
		if (m > -1 && m < 13)
			return true;
		return false;
	}

	// 检查天数
	private static boolean checkDay(int y, int m, int d) {
		boolean isDay = false;
		if (d < 0 || d > 31)
			return isDay;

		switch (m) {
		// 31天
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (d <= 31)
				isDay = true;
			break;
		// 30天
		case 4:
		case 6:
		case 9:
		case 11:
			if (d <= 30)
				isDay = true;
			break;
		// 闰年判断28/29天
		case 2:
			boolean isLeap = checkYear(y);
			if ((isLeap && d <= 29) || (!isLeap && d <= 28))
				isDay = true;
			break;
		}
		return isDay;
	}

	private static void print(int[][] dat, boolean[] ck) {
		int row = dat.length;
		int col = dat[0].length;
		TreeSet<String> set = new TreeSet<>();
		for (int i = 0; i < row; i++) {
			if (!ck[i])
				continue;
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < col; j++) {
				if (dat[i][j] < 10)
					sb.append(0);
				sb.append(dat[i][j]);
				if (j < col - 1)
					sb.append("-");
			}
			set.add(sb.toString());
		}
		for (String s : set)
			System.out.println(s);
	}

	private static void make(int[][] dat, String[] sp) {
		int row = dat.length;

		int y = new Integer(sp[0]);
		int m = new Integer(sp[1]);
		int d = new Integer(sp[2]);

		for (int i = 0; i < row; i++) {
			dat[i][0] = y;
			dat[i][1] = m;
			dat[i][2] = d;
		}
	}

}
