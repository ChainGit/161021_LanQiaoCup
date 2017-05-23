package com.lanqiao.match.province;

import java.util.Scanner;

/*
10，k倍区间
给定一个长度为N的数列，A1, A2, … AN，如果其中一段连续的子序列Ai, Ai+1, … Aj(i <= j)之和是K的倍数，我们就称这个区间[i, j]是K倍区间。 
你能求出数列中总共有多少个K倍区间吗？ 
输入
第一行包含两个整数N和K。(1 <= N, K <= 100000) 
以下N行每行包含一个整数Ai。(1 <= Ai <= 100000) 
输出
输出一个整数，代表K倍区间的数目。 
例如， 
输入： 
5 2 
1 
2 
3 
4 
5 
程序应该输出： 
6
资源约定： 
峰值内存消耗（含虚拟机） < 256M 
CPU消耗 < 3000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入…” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。 
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。 
注意：主类的名字必须是：Main，否则按无效代码处理。

分析：基本的动态规划，加一个缓存，（第i个到第j个的和）等价于（从第1个到第j个-第1个到第i个）
 */
public class Main10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] dat = new int[n];
		int[] buf = new int[n];
		dat[0] = in.nextInt();
		for (int i = 1; i < n; i++) {
			dat[i] = in.nextInt();
			// 构建从第一个到第i的和的buf
			buf[i] = buf[i - 1] + dat[i];
		}
		in.close();

		int sum = 0;
		for (int i = 0; i < n; i++) {
			// 本身可能满足k倍区间
			if (dat[i] % k == 0)
				sum++;
			// 连续区间满足k倍区间
			for (int j = i + 1; j < n; j++)
				if ((buf[j] - buf[i]) % k == 0)
					sum++;
		}

		System.out.println(sum);
	}

}
