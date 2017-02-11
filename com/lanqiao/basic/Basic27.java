package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 2n皇后问题
 * 
 * 问题描述<br>
 * 给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，<br>
 * 使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、<br>
 * 同一列或同一条对角线上。问总共有多少种放法？n小于等于8。 输入格式<br>
 * 输入的第一行为一个整数n，表示棋盘的大小。<br>
 * 接下来n行，每行n个0或1的整数，如果一个整数为1，表示对应的位置可以放皇后，如果一个整数为0，表示对应的位置不可以放皇后。<br>
 * 输出格式<br>
 * 输出一个整数，表示总共有多少种放法。<br>
 * 样例输入<br>
 * 4<br>
 * 1 1 1 1<br>
 * 1 1 1 1<br>
 * 1 1 1 1<br>
 * 1 1 1 1<br>
 * 样例输出<br>
 * 2<br>
 * 样例输入<br>
 * 4<br>
 * 1 0 1 1<br>
 * 1 1 1 1<br>
 * 1 1 1 1<br>
 * 1 1 1 1<br>
 * 样例输出<br>
 * 0<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：字符串 条件判断
 * 
 * @author Chain
 *
 */
public class Basic27 {

	private static int bqueen[];// 黑皇后
	private static int wqueen[];// 白皇后
	private static boolean chessboard[][];// 1:能放 0:不能放
	private static int count = 0;
	private static int n;

	// 第k个皇后，即第k行皇后，存储的是每一个皇后在该行的位置j
	private static void putWhiteQueen(int k) {
		int i;
		int j;
		for (i = 0; i < k - 1; i++) {
			// 判断列和对角线
			int judge = wqueen[i] - wqueen[k - 1];
			if (judge == 0 || Math.abs(k - 1 - i) == Math.abs(judge))
				// 如果放置不成功则返回上一个(行)调用
				return;
		}
		// 每次成功放置完白皇后,回到继续第一行放置黑皇后
		if (k == n) {
			// 将白皇后的放置位置暂时置为false
			for (int p = 0; p < n; p++)
				chessboard[p][wqueen[p]] = false;
			// 放置 blackQueue
			putBlackQueen(0);
			// 将白皇后的放置位置恢复为true
			for (int p = 0; p < n; p++)
				chessboard[p][wqueen[p]] = true;
			return;
		}
		// 皇后不会放在同一行
		for (j = 0; j < n; j++) {
			if (chessboard[k][j]) {
				wqueen[k] = j;
				// 放置皇后后进入下一行继续验证
				putWhiteQueen(k + 1);
			}
		}
	}

	private static void putBlackQueen(int k) {
		int i;
		int j;
		for (i = 0; i < k - 1; i++) {
			int judge = bqueen[i] - bqueen[k - 1];
			if (judge == 0 || Math.abs(k - 1 - i) == Math.abs(judge))
				return;
		}
		// 只有当黑皇后也成功放置到最后一行后,才算放置成功,count+1
		if (k == n) {
			count++;
			return;
		}
		for (j = 0; j < n; j++) {
			if (chessboard[k][j]) {
				bqueen[k] = j;
				putBlackQueen(k + 1);
			}
		}
	}

	// 递归法
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		chessboard = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				chessboard[i][j] = in.nextInt() == 1 ? true : false;
		in.close();

		wqueen = new int[n];
		bqueen = new int[n];

		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(chessboard[i][j] + " ");
			System.out.println();
		}
		System.out.println();

		putWhiteQueen(0);// whiteQueue

		System.out.println(count);
	}
}
