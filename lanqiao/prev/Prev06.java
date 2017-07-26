package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 历届试题 翻硬币
 * 
 * 总结：贪心(做出局部的最优)
 * 
 * @author Chain
 *
 */
public class Prev06 {

	// 从左到右扫描,一旦扫描到不一样的就翻转该位和右边的那个硬币,使得该位成立即可
	// 接着再从右到左扫描,一旦扫描到不一样的就翻转该位和左边的那个硬币,使得该位成立即可
	// 输出两者的结果最小值
	public static void main(String[] args) throws Exception {
		boolean[] a = null;
		boolean[] b = null;
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		a = getInputArr(bufr.readLine());
		b = getInputArr(bufr.readLine());
		bufr.close();

		// 从左到右
		boolean[] p = a.clone();
		int s1 = 0;
		int len = p.length;
		for (int i = 0; i < len - 1; i++)
			if (p[i] != b[i]) {
				p[i] = !p[i];
				p[i + 1] = !p[i + 1];
				s1++;
			}
		if (p[len - 1] != b[len - 1])
			s1 = -1;

		// 从右到左
		p = a.clone();
		int s2 = 0;
		for (int i = len - 1; i > 0; i--)
			if (p[i] != b[i]) {
				p[i] = !p[i];
				p[i - 1] = !p[i - 1];
				s2++;
			}
		if (p[0] != b[0])
			s2 = -1;

		// 题目没有说明是否一定可以翻转,这里假设一定可以翻转成功
		if (s1 != -1 && s2 != -1)
			System.out.println(s1 > s2 ? s2 : s1);
		else if (s1 == -1 && s2 != -1)
			System.out.println(s2);
		else if (s1 != -1 && s2 == -1)
			System.out.println(s1);
		else
			System.out.println(0);
	}

	// 根据输入转为boolean数组
	private static boolean[] getInputArr(String sbuf) {
		char[] cbuf = sbuf.toCharArray();
		int len = cbuf.length;
		boolean[] p = new boolean[len];
		for (int i = 0; i < len; i++)
			p[i] = cbuf[i] == '*' ? true : false;
		return p;
	}
}
