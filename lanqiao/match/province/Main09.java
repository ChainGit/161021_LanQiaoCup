package com.lanqiao.match.province;

import java.util.Scanner;

/*
9，分巧克力
儿童节那天有K位小朋友到小明家做客。小明拿出了珍藏的巧克力招待小朋友们。 
小明一共有N块巧克力，其中第i块是Hi x Wi的方格组成的长方形。

为了公平起见，小明需要从这 N 块巧克力中切出K块巧克力分给小朋友们。切出的巧克力需要满足：
1. 形状是正方形，边长是整数  
2. 大小相同  

例如一块6x5的巧克力可以切出6块2x2的巧克力或者2块3x3的巧克力。
当然小朋友们都希望得到的巧克力尽可能大，你能帮小Hi计算出最大的边长是多少么？

输入 
第一行包含两个整数N和K。(1 <= N, K <= 100000) 
以下N行每行包含两个整数Hi和Wi。(1 <= Hi, Wi <= 100000) 
输入保证每位小朋友至少能获得一块1x1的巧克力。 

输出 
输出切出的正方形巧克力最大可能的边长。

样例输入： 
2 10 
6 5 
5 6 
样例输出： 
2

资源约定： 
峰值内存消耗（含虚拟机） < 256M 
CPU消耗 < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入…” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。 
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。 
注意：主类的名字必须是：Main，否则按无效代码处理。

分析：从最大的边可能去递减查找，最大二分查找，快速收敛缩小范围
 */
public class Main09 {

	private static int n;
	private static int k;
	private static int[][] dat;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		dat = new int[n][2];

		int min = 0;
		// 边长最长的巧克力的边长长度
		int max = 0;

		for (int i = 0; i < n; i++) {
			dat[i][0] = in.nextInt();
			dat[i][1] = in.nextInt();
			int a = dat[i][0];
			int b = dat[i][1];
			int tmax = a > b ? a : b;
			if (tmax > max)
				max = tmax;
		}
		in.close();

		// 二分查找
		while (min < max - 1) {
			// 如果min+max为奇数，则mid相当于mid-1，不影响结果
			int mid = (min + max) >> 1;
			if (!check(mid))
				max = mid - 1;
			else
				min = mid + 1;
		}

		System.out.println(min);

	}

	private static boolean check(int base) {
		int res = 0;
		for (int i = 0; i < n; i++) {
			int a = dat[i][0] / base;
			int b = dat[i][1] / base;
			res += a * b;
		}
		if (res >= k)
			return true;
		return false;
	}

}
