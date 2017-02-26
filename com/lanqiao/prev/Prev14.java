package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 历届试题 高僧斗法
 * 
 * 总结：博弈论
 * 
 * @author Chain
 *
 */
public class Prev14 {

	// 百度可知,这是一个类Nim游戏,先走的一方想胜利的话,只需要调整当前状况异或为0即可
	public static void main(String[] args) throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String sbuf = bufr.readLine();
		bufr.close();

		String[] pbuf = sbuf.split(" ");
		int len = pbuf.length;
		ArrayList<Integer> lst = new ArrayList<>();
		for (int i = 0; i < len; i++)
			lst.add(new Integer(pbuf[i]) - 1);

		// 转化为Nim游戏,获得多少堆石子,石子总数和堆数不变,变的是每堆石子的个数(即相邻小和尚之间的台阶数)
		int num = lst.size();
		// 每堆石子个数是指：相邻小和尚之间的台阶数
		int[] heap = new int[num];
		for (int i = 0; i < num - 1; i++)
			heap[i] = lst.get(i + 1) - lst.get(i) - 1;

		// 实际起效果的是每对小和尚之间的台阶
		int xor = 0;
		for (int i = 0; i < num - 1; i += 2)
			xor ^= heap[i];

		// 如果一开始就是0,则情况对后走的有利,即先走的一方不是一定赢
		if (xor == 0) {
			System.out.println(-1);
			return;
		}

		// 依次从0号小和尚尝试走台阶,直到最后一个小和尚
		for (int i = 0; i < num; i++) {
			// 可以走的台阶数
			int many = heap[i];
			for (int j = 1; j <= many; j++) {

				// 由于台阶是连续整体,所以其中一个变化,相邻的也要变化
				heap[i] -= j;
				if (i > 0)
					heap[i - 1] += j;

				xor = 0;
				for (int k = 0; k < num - 1; k += 2)
					xor ^= heap[k];

				// 已经满足异或为0
				if (xor == 0) {
					int which = lst.get(i) + 1;
					System.out.println(which + " " + (which + j));
					return;
				}

				heap[i] += j;
				if (i > 0)
					heap[i - 1] -= j;
			}
		}

	}
}
