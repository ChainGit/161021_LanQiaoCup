package com.lanqiao.prev;

import java.util.Scanner;

/**
 * 历届试题 剪格子
 * 
 * 总结：搜索
 * 
 * @author Chain
 *
 */
public class Prev04 {

	// 这个方法检测未超时,平均用时200ms
	// 如果使用DFS求出每一个走的路径再对路径进行判断会超时

	private int m;
	private int n;
	private int len;
	private int[][] dat;
	// 标记路是否被走过,即被选择
	private boolean[][] flag;
	// 最短路径
	private int min;
	// 格子的和的一半
	private int half;
	// 用于检测结果是否是两部分
	private int res;
	// 用于检测结果的标记
	private boolean chk[][] = null;

	public static void main(String[] args) {
		new Prev04().method();
	}

	private void method() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		dat = new int[m][n];
		int sum = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				dat[i][j] = in.nextInt();
				sum += dat[i][j];
			}
		in.close();

		// 格子和为奇数肯定不能被分成两个和相同的部分
		if (sum % 2 == 0)
			half = sum >> 1;
		else {
			System.out.println(0);
			return;
		}

		flag = new boolean[m][n];
		chk = new boolean[m][n];

		len = m * n;// len!=dat.length,dat.length是指行数Row;
		min = len;

		// 始终从左上角开始走
		check(0, 0, 0, 0);

		// 如果最短路径为len,代表没有找到可以将格子分成两个和相同的部分
		if (min != len)
			System.out.println(min);
		else
			System.out.println(0);
	}

	// 利用DFS和判断已走过格子的和sump是否等于half,其中每次在当前走的格子依次上下左右尝试走格子
	private void check(int a, int b, int sump, int foot) {
		// 这个格子已经走过
		if (flag[a][b])
			return;

		if (sump > half)
			return;
		if (sump == half && foot < min)
			if (isTwo())
				min = foot;

		for (int i = 0; i < 4; i++) {
			flag[a][b] = true;
			sump += dat[a][b];
			foot++;
			switch (i) {
			// 右
			case 0:
				if (b < n - 1)
					check(a, b + 1, sump, foot);
				break;
			// 下
			case 1:
				if (a < m - 1)
					check(a + 1, b, sump, foot);
				break;
			// 左
			case 2:
				if (b > 0)
					check(a, b - 1, sump, foot);
				break;
			// 上
			case 3:
				if (a > 0)
					check(a - 1, b, sump, foot);
				break;
			}
			flag[a][b] = false;
			sump -= dat[a][b];
			foot--;
		}
	}

	// 检测是否是两部分,方法是一检测到true,就统计与他相邻(上下左右)的true块
	// 接着再检测false,再统计与他相邻(上下左右)的false块.最后看这两次统计之和是否等于总数
	// 比如
	// true true false
	// false true false
	private boolean isTwo() {
		res = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				chk[i][j] = false;

		loop1: for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (flag[i][j]) {
					judge(true, i, j);
					break loop1;
				}

		loop2: for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (!flag[i][j]) {
					judge(false, i, j);
					break loop2;
				}

		if (res == len)
			return true;
		else
			return false;
	}

	private void judge(boolean kind, int a, int b) {
		if (!chk[a][b] && flag[a][b] == kind) {
			res++;
			chk[a][b] = true;

			for (int k = 0; k < 4; k++) {
				switch (k) {
				// 右
				case 0:
					if (b < n - 1)
						judge(kind, a, b + 1);
					break;
				// 下
				case 1:
					if (a < m - 1)
						judge(kind, a + 1, b);
					break;
				// 左
				case 2:
					if (b > 0)
						judge(kind, a, b - 1);
					break;
				// 上
				case 3:
					if (a > 0)
						judge(kind, a - 1, b);
					break;
				}
			}
		}
	}

}
