package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 历届试题 危险系数
 * 
 * 总结：割点
 * 
 * @author Chain
 *
 */
public class Prev12 {

	// 从站点x出发到站点y共有几条路
	private int num;
	// 标记站点是否可达(或走过的站点)
	private boolean[] flag;
	// 存储站点无向图,用的是笨数组存储,需要改为邻接表
	private int[][] road;
	// 总共有多少站点
	private int n;
	// 总共有多少条通道
	private int m;
	// 关键站点的个数
	private int key;

	public static void main(String[] args) throws Exception {
		// 有一个数据超时,最终80
		new Prev12().method();
	}

	private void method() throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String sbuf = bufr.readLine();
		String[] pbuf = sbuf.split(" ");
		n = new Integer(pbuf[0]);
		m = new Integer(pbuf[1]);
		road = new int[m][2];
		for (int i = 0; i < m; i++) {
			sbuf = bufr.readLine();
			pbuf = sbuf.split(" ");
			road[i][0] = new Integer(pbuf[0]) - 1;
			road[i][1] = new Integer(pbuf[1]) - 1;
		}
		sbuf = bufr.readLine();
		pbuf = sbuf.split(" ");
		int x = new Integer(pbuf[0]) - 1;
		int y = new Integer(pbuf[1]) - 1;
		bufr.close();

		flag = new boolean[n];

		// 首先判断两点是否联通
		go(x, y, x);
		if (num == 0) {
			System.out.println(-1);
			return;
		}

		// 除了第x和y个站点,其余站点依次设置flag[i]为true,相当于去除这个站点
		for (int i = 0; i < n; i++)
			if (i != x && i != y) {
				flag[i] = true;
				num = 0;
				go(x, y, x);
				if (num == 0) {
					// 输出这个关键站点
					// System.out.println(i + 1);
					key++;
				}
				flag[i] = false;
			}

		System.out.println(key);
	}

	// 每次都进行DFS遍历,也可用栈实现,计算机自身有栈结构
	private void go(int x, int y, int now) {
		if (flag[now])
			return;

		if (now == y) {
			num++;
			return;
		}

		int[] res = getNextStations(now);
		for (int i = 0; i < res.length; i++) {
			flag[now] = true;
			go(x, y, res[i]);
			flag[now] = false;
		}
	}

	// 返回可到达的下一个站点数组
	private int[] getNextStations(int now) {
		ArrayList<Integer> lst = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int a = road[i][0];
			int b = road[i][1];
			int next = -1;
			if (a == now)
				next = b;
			else if (b == now)
				next = a;
			if (next != -1)
				lst.add(next);
		}

		int size = lst.size();
		int[] res = new int[size];
		for (int i = 0; i < size; i++)
			res[i] = lst.get(i);
		return res;
	}
}
