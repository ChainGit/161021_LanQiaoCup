package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 历届试题 网络寻路
 * 
 * 总结： 构图
 * 
 * @author Chain
 *
 */
public class Prev13 {

	// 共有多少种情况
	private int num;
	// 标记站点是否可达(或走过的站点)
	private boolean[] flag;
	// 存储站点无向图(邻接表)
	private Node[] road;
	// 总共有多少站点
	private int n;
	// 总共有多少条通道
	private int m;

	// 图的表示方法：邻接矩阵、邻接表
	// 图的分类：有向图、无向图
	// 图的遍历：DFS、BFS
	public static void main(String[] args) throws Exception {
		// 有一个数据超时,80分,同样方法是用C++编写运行最长需要400ms
		// 但图的邻接表存储比之前的笨二维数组(不是邻接矩阵)存储要快了不少
		new Prev13().method();
	}

	// 题意是指：输出从某站点x到站点y的所有可达路径,其中首尾可以相同,中间有且仅有两个站点,中间站点只能走一次
	private void method() throws IOException {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String sbuf = bufr.readLine();
		String[] pbuf = sbuf.split(" ");
		n = new Integer(pbuf[0]);
		m = new Integer(pbuf[1]);
		road = new Node[n];
		for (int i = 0; i < n; i++)
			road[i] = new Node(i);
		for (int i = 0; i < m; i++) {
			sbuf = bufr.readLine();
			pbuf = sbuf.split(" ");
			int from = new Integer(pbuf[0]) - 1;
			int to = new Integer(pbuf[1]) - 1;
			add(from, to);
			add(to, from);
		}
		bufr.close();

		flag = new boolean[n];

		// 从站点i开始按照邻接表依次走
		for (int i = 0; i < n; i++) {
			go(i, i, 0);
			reset();
		}

		System.out.println(num);
	}

	// 深度为3
	private void go(int start, int now, int citys) {
		// 从now出发,由该节点的邻接链表,依次访问
		// 判断是否走过要在判断城市之后
		if (citys == 3) {
			num++;
			return;
		}

		if (flag[now])
			return;

		flag[now] = true;
		for (Node next = road[now].next; next != null; next = next.next) {
			int nextcity = next.data;
			if (flag[nextcity] && nextcity != start)
				continue;
			go(start, nextcity, citys + 1);
		}
		flag[now] = false;
	}

	// 重置
	private void reset() {
		for (int i = 0; i < n; i++)
			flag[i] = false;
	}

	// 添加数据到链接表
	private void add(int from, int to) {
		Node current = road[from];
		if (current == null) {
			road[from] = new Node(from);
			current = road[from];
		}
		while (true) {
			Node next = current.next;
			if (next == null) {
				current.next = new Node(to);
				return;
			}
			current = current.next;
		}
	}
}

// 为了操作方便,直接public
class Node {
	public int data = -1;
	public Node next = null;

	public Node(int data) {
		this.data = data;
	}

}
