package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 芯片测试
 * 
 * 
 * 问题描述<br>
 * 
 * 有n（2≤n≤20）块芯片，有好有坏，已知好芯片比坏芯片多。<br>
 * 每个芯片都能用来测试其他芯片。用好芯片测试其他芯片时，能正确给出被测试芯片是好还是坏。<br>
 * 而用坏芯片测试其他芯片时，会随机给出好或是坏的测试结果（即此结果与被测试芯片实际的好坏无关）。<br>
 * 给出所有芯片的测试结果，问哪些芯片是好芯片。<br>
 * 
 * 输入格式<br>
 * 
 * 输入数据第一行为一个整数n，表示芯片个数。<br>
 * 第二行到第n+1行为n*n的一张表，每行n个数据。<br>
 * 表中的每个数据为0或1，在这n行中的第i行第j列（1≤i, j≤n）的数据表示用第i块芯片测试第j块芯片时得到的测试结果，<br>
 * 1表示好，0表示坏，i=j时一律为1（并不表示该芯片对本身的测试结果。芯片不能对本身进行测试）。
 * 
 * 输出格式<br>
 * 
 * 按从小到大的顺序输出所有好芯片的编号<br>
 * 
 * 样例输入<br>
 * 
 * 3<br>
 * 1 0 1<br>
 * 0 1 0<br>
 * 1 0 1<br>
 * 
 * 样例输出<br>
 * 
 * 1 3<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：算法基础 统计 二维数组
 * 
 * @author Chain
 *
 */
public class Basic23 {

	/*
	 * 抽屉原理:桌上有十个苹果,要把这十个苹果放到九个抽屉里,无论怎样放,我们会发现至少会有一个抽屉里面至少放两个苹果。
	 * 如果每个抽屉代表一个集合，每一个苹果就可以代表一个元素，假如有n+1个元素放到n个集合中去，其中必定有一个集合里至少有两个元素。
	 * 假如有一半以上的芯片同意了本芯片为好芯片的话，则本芯片为一个好的芯片。
	 * 摘自：http://blog.csdn.net/qq_32866009/article/details/50786874
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		// 大量的in.nextInt()比较耗时
		boolean[][] data = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				data[i][j] = in.nextInt() == 0 ? false : true;

		in.close();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(data[i][j] + " ");
			System.out.println();
		}
		System.out.println();

		// 对于每一列,假如有一半以上的芯片同意了本芯片为好芯片的话，则本芯片为一个好的芯片。
		for (int j = 0; j < n; j++) {
			int p = 0;
			for (int i = 0; i < n; i++)
				if (data[i][j])
					p++;
			if (p > (n >>> 1))
				System.out.print((j + 1) + " ");
		}
		System.out.println();

	}
}
