package com.lanqiao.basic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 基础练习 Huffuman树
 * 
 * 问题描述<br>
 * Huffman树在编码中有着广泛的应用。在这里，我们只关心Huffman树的构造过程。<br>
 * 给出一列数{pi}={p0, p1, …, pn-1}，用这列数构造Huffman树的过程如下：<br>
 * 1. 找到{pi}中最小的两个数，设为pa和pb，将pa和pb从{pi}中删除掉，然后将它们的和加入到{pi}中。这个过程的费用记为pa +pb。<br>
 * 2. 重复步骤1，直到{pi}中只剩下一个数。<br>
 * 在上面的操作过程中，把所有的费用相加，就得到了构造Huffman树的总费用。<br>
 * 本题任务：对于给定的一个数列，现在请你求出用该数列构造Huffman树的总费用。<br>
 * 
 * 例如，对于数列{pi}={5, 3, 8, 2, 9}，Huffman树的构造过程如下：<br>
 * 1. 找到{5, 3, 8, 2, 9}中最小的两个数，分别是2和3，从{pi}中删除它们并将和5加入，得到{5, 8, 9, 5}，费用为5。<br>
 * 2. 找到{5, 8, 9, 5}中最小的两个数，分别是5和5，从{pi}中删除它们并将和10加入，得到{8, 9, 10}，费用为10。<br>
 * 3. 找到{8, 9, 10}中最小的两个数，分别是8和9，从{pi}中删除它们并将和17加入，得到{10, 17}，费用为17。<br>
 * 4. 找到{10, 17}中最小的两个数，分别是10和17，从{pi}中删除它们并将和27加入，得到{27}，费用为27。<br>
 * 5. 现在，数列中只剩下一个数27，构造过程结束，总费用为5+10+17+27=59。<br>
 * 输入格式<br>
 * 输入的第一行包含一个正整数n（n<=100）。<br>
 * 接下来是n个正整数，表示p0, p1, …, pn-1，每个数不超过1000。<br>
 * 输出格式<br>
 * 输出用这些数构造Huffman树的总费用。<br>
 * 样例输入<br>
 * 5<br>
 * 5 3 8 2 9<br>
 * 样例输出<br>
 * 59<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结： 贪心 Huffuman
 * 
 * @author Chain
 *
 */
public class Basic28 {

	// 贪心算法
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] d = new int[n];
		for (int i = 0; i < n; i++)
			d[i] = in.nextInt();
		in.close();

		method1(d);
		method2(d);
	}

	// 使用数组
	private static void method2(int[] d) {
		int z = 0;
		int count = 0;
		while (z < d.length - 1) {
			mySort(d);
			int t = d[z] + d[z + 1];
			d[z] = -1;
			d[z + 1] = t;
			count += t;
			z++;
		}
		System.out.println(count);
	}

	private static void mySort(int[] d) {
		for (int i = 0; i < d.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < d.length; j++)
				if (d[min] > d[j])
					min = j;
			if (min != i)
				swap(d, i, min);
		}
	}

	public static void swap(int[] n, int i, int j) {
		n[i] ^= n[j];
		n[j] ^= n[i];
		n[i] ^= n[j];
	}

	// 使用java api
	private static void method1(int[] d) {
		LinkedList<Integer> set = new LinkedList<>();
		for (int i = 0; i < d.length; i++)
			set.add(d[i]);

		int cost = 0;
		while (set.size() > 1) {
			Collections.sort(set);
			int t = set.get(0) + set.get(1);
			set.set(0, t);
			set.remove(1);
			cost += t;
		}
		System.out.println(cost);
	}

}
