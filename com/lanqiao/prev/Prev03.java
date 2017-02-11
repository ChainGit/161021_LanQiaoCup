package com.lanqiao.prev;

import java.util.Scanner;

/**
 * 历届试题 带分数
 * 
 * 总结：搜索
 * 
 * @author Chain
 *
 */
public class Prev03 {

	// 有多少种满足n = a + b/c
	private int res = 0;
	// 存储每一种排列
	private int dat[] = new int[9];
	// 数值是否已经被选择,排除重复
	private boolean flag[] = new boolean[9];
	// 存储n
	private int n = 0;

	public static void main(String[] args) {
		new Prev03().method();
	}

	private void method() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();

		makeArr(0);

		System.out.println(res);
	}

	// 递归列出所有排列DFS,共362880种
	private void makeArr(int start) {
		if (start == 9)
			check();
		else
			for (int i = 0; i < 9; i++) {
				if (flag[i])
					continue;
				dat[start] = i + 1;
				flag[i] = true;
				makeArr(start + 1);
				flag[i] = false;
			}

	}

	// 检查是否符合带分数
	private void check() {
		// n = a + b / c
		// a长度最短为1位，最长为7位
		// b长度最短为1位,最长为7位,且必须比c大
		// c长度最短为1位,最长为4位
		for (int i = 0; i < 8; i++) {
			int a = sum(0, i);
			if (a >= n)
				return;
			for (int j = 8; j > 4; j--) {
				int b = sum(i + 1, j - 1);
				int c = sum(j, 8);
				if (b > c && b % c == 0 && a + b / c == n) {
					// System.out.println(n + "=" + a + "+" + b + "/" + c);
					res++;
				}
			}
		}
	}

	// 获得某一段的和,即从dat中分解出a,b,c,包含头也包含尾
	private int sum(int from, int to) {
		int sum = 0;
		for (int i = from; i <= to; i++)
			sum = sum * 10 + dat[i];
		return sum;
	}
}
