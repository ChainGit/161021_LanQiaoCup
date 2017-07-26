package com.lanqiao.algo;

import java.util.Scanner;

/**
 * 算法训练 K好数
 * 
 * 问题描述<br>
 * 如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这个数是K好数。求L位K进制数中K好数的数目。<br>
 * 例如K = 4，L = 2的时候，所有K好数为11、13、20、22、30、31、33 共7个。<br>
 * 由于这个数目很大，请你输出它对1000000007取模后的值。
 * 
 * 输入格式<br>
 * 输入包含两个正整数，K和L。<br>
 * 
 * 输出格式<br>
 * 输出一个整数，表示答案对1000000007取模后的值。<br>
 * 样例输入<br>
 * 4 2<br>
 * 样例输出<br>
 * 7<br>
 * 数据规模与约定<br>
 * 对于30%的数据，KL <= 106；<br>
 * 
 * 对于50%的数据，K <= 16， L <= 10；<br>
 * 
 * 对于100%的数据，1 <= K,L <= 100。<br>
 * 
 * 总结： 动态规划
 * 
 * @author Chain
 *
 */
public class Algo003 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();// k进制
		int l = in.nextInt();// l位
		in.close();

		int mod = 1000000007;

		// 动态规划：表示长度为l,结尾数字为k
		int[][] dat = new int[l][k];
		// 当长度为1时,k进制的所有数都是k好数
		for (int j = 1; j < k; j++)
			dat[0][j] = 1;

		// 从长度为2开始,逐步解决每一个长度i时共有多少情况
		for (int i = 1; i < l; i++)
			// 第i-1行
			for (int m = 0; m < k; m++)
				// 第i行
				for (int n = 0; n < k; n++)
					if (n != m - 1 && n != m + 1)
						// 长度为i时的可能为上一个可能的和,状态转移
						dat[i][m] = (dat[i][m] + dat[i - 1][n]) % mod;

		int x = 0;
		for (int i = 0; i < k; i++)
			x = (x + dat[l - 1][i]) % mod;

		System.out.println(x % mod);
	}
}
