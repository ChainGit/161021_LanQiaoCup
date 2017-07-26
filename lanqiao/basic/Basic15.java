package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 字符串对比
 * 
 * 给定两个仅由大写字母或小写字母组成的字符串(长度介于1到10之间)，它们之间的关系是以下4中情况之一：<br>
 * 1：两个字符串长度不等。比如 Beijing 和 Hebei<br>
 * 2：两个字符串不仅长度相等，而且相应位置上的字符完全一致(区分大小写)，比如 Beijing 和 Beijing<br>
 * 3：两个字符串长度相等，相应位置上的字符仅在不区分大小写的前提下才能达到完全一致（也就是说，它并不满足情况2）。比如 beijing 和
 * BEIjing<br>
 * 4：两个字符串长度相等，但是即使是不区分大小写也不能使这两个字符串一致。比如 Beijing 和 Nanjing<br>
 * 编程判断输入的两个字符串之间的关系属于这四类中的哪一类，给出所属的类的编号。<br>
 * 输入格式<br>
 * 包括两行，每行都是一个字符串<br>
 * 输出格式<br>
 * 仅有一个数字，表明这两个字符串的关系编号<br>
 * 样例输入<br>
 * BEIjing<br>
 * beiJing<br>
 * 样例输出<br>
 * 3<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：字符串 大小写
 * 
 * @author Chain
 *
 */
public class Basic15 {

	// 分析：长度、大小写、逐位比较
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		in.close();

		System.out.println(test1(s1, s2));
		System.out.println(test2(s1, s2));
	}

	// 使用JavaAPI
	private static int test1(String s1, String s2) {
		if (s1.length() != s2.length())
			return 1;
		else {
			if (s1.equals(s2))
				return 2;
			else if (s1.toLowerCase().equals(s2.toLowerCase()))
				return 3;
			else
				return 4;
		}
		// return -1;
	}

	// 自定义equals方法
	private static int test2(String s1, String s2) {
		if (s1.length() != s2.length())
			return 1;
		else {
			if (myEquals(s1, s2))
				return 2;
			else if (myEquals(myToLowerCase(s1), myToLowerCase(s2)))
				return 3;
			else
				return 4;
		}
		// return -1;
	}

	// 转字母为小写
	private static String myToLowerCase(String s) {
		char[] a = s.toCharArray();
		for (int i = 0; i < a.length; i++)
			if (a[i] > 64 && a[i] < 91)
				a[i] += 32;
		return new String(a);
	}

	// 等长字符串,逐个比较
	private static boolean myEquals(String s1, String s2) {
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		int len1 = a1.length;
		int len2 = a2.length;
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; i++)
			if (a1[i] != a2[i])
				return false;
		return true;
	}

}
