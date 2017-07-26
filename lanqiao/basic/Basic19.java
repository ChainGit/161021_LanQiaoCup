package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 完美的代价
 * 
 * 回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。<br>
 * 交换的定义是：交换两个相邻的字符<br>
 * 例如mamad<br>
 * 第一次交换 ad : mamda<br>
 * 第二次交换 md : madma<br>
 * 第三次交换 ma : madam (回文！完美！)<br>
 * 输入格式<br>
 * 第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)<br>
 * 第二行是一个字符串，长度为N.只包含小写字母<br>
 * 输出格式<br>
 * 如果可能，输出最少的交换次数。<br>
 * 否则输出Impossible<br>
 * 样例输入<br>
 * 5<br>
 * mamad<br>
 * 样例输出<br>
 * 3<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：贪心算法
 * 
 * @author Chain
 *
 */
public class Basic19 {

	/**
	 * 思路： 贪心法,在对问题求解时，总是做出在当前看来最好的选择。也就是说，不从整体最优解出发来考虑，它所做出的仅是在某种意义上的局部最优解。
	 * 
	 * 可以使得第i位可以与第last-i位一致,则整体完成
	 * 
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int n = in.nextInt();
		String s = in.next();
		in.close();
		char[] str = s.toCharArray();
		int step = 0;
		for (int i = 0; i < n; i++) {
			int p = n - 1 - i;
			int j = i + 1;
			boolean isAlone = true;
			for (; j < n; j++)
				if (str[i] == str[j]) {
					isAlone = false;
					break;
				}
			if (!isAlone && j != i && j != p && j < n) {
				// 步数就是要相邻交换的次数
				step += n - j;
				// 此处直接交换
				swap(str, p, j);
				print(str);
			}
		}
		System.out.println(step);
	}

	private static void swap(char[] str, int i, int j) {
		char tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}

	private static void print(char[] str) {
		for (int i = 0; i < str.length; i++)
			System.out.print(str[i]);
		System.out.println();
	}

}
