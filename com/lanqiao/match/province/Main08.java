package com.lanqiao.match.province;

import java.util.Scanner;

/*
8，包子凑数

小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有N种蒸笼，其中第i种蒸笼恰好能放Ai个包子。每种蒸笼都有非常多笼，可以认为是无限笼。

每当有顾客想买X个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有X个包子。比如一共有3种蒸笼，分别能放3、4和5个包子。当顾客想买11个包子时，大叔就会选2笼3个的再加1笼5个的（也可能选出1笼3个的再加2笼4个的）。

当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有3种蒸笼，分别能放4、5和6个包子。而顾客想买7个包子时，大叔就凑不出来了。

小明想知道一共有多少种数目是包子大叔凑不出来的。

输入
----
第一行包含一个整数N。(1 <= N <= 100)
以下N行每行包含一个整数Ai。(1 <= Ai <= 100)  

输出
----
一个整数代表答案。如果凑不出的数目有无限多个，输出INF。

例如，
输入：
2  
4  
5   

程序应该输出：
6  

再例如，
输入：
2  
4  
6    

程序应该输出：
INF

样例解释：
对于样例1，凑不出的数目包括：1, 2, 3, 6, 7, 11。  
对于样例2，所有奇数都凑不出来，所以有无限多个。  

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

分析：完全背包,根据题设条件范围暴力循环判断,拓展欧几里得（最大公约数）
 */
public class Main08 {

	private static boolean[] dat = new boolean[10001];

	// 获得最大公约数
	private static int getGcd(int a, int b) {
		while (b > 0) {
			int t = a % b;
			a = b;
			b = t;
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] bs = new int[n];
		for (int i = 0; i < n; i++)
			bs[i] = in.nextInt();
		in.close();

		boolean can = false;
		o: for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
				// 最大公约数为1则为互质
				if (getGcd(bs[i], bs[j]) == 1) {
					can = true;
					break o;
				}
		if (!can) {
			System.out.println("INF");
			return;
		}

		// 0肯定能凑出来
		dat[0] = true;
		for (int i = 0; i < n; i++)
			// 暴力即可，因为Ai最大为100，其实有数学理论可以证明
			for (int j = bs[i]; j <= 10000; j++)
				if (dat[j - bs[i]])
					dat[j] = true;

		int num = 0;
		// 统计不能凑出来的数
		for (int i = 0; i < 10000; i++)
			if (!dat[i]) {
				// System.out.print(i + " ");
				num++;
			}

		// System.out.println();
		System.out.println(num);
	}

}
