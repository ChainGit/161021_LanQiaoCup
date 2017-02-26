package com.lanqiao.prev;

import java.util.*;

/**
 * 历届试题 城市建设
 * 
 * @author Chain
 *
 */

public class Prev25 {

	// 摘自官方答案
	public static void main(String[] arge) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		City city = new City(n, m);
		for (int i = 1; i <= m; i++)
			city.edge[i] = new MEdge(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()),
					Integer.parseInt(sc.next()));
		int wharf = 0;
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(sc.next());
			if (num != -1) {
				wharf++;
				city.edge[m + wharf] = new MEdge(0, i, num);
			}
		}
		sc.close();
		city.wharf = wharf;
		city.tree();
	}
}

class MEdge {
	public int start, destination, value;

	MEdge(int start, int destination, int value) {
		this.start = start;
		this.destination = destination;
		this.value = value;
	}
}

class City {
	MEdge[] edge;
	int n, m, wharf;
	int[] father;

	City(int n, int m) {
		this.n = n;
		this.m = m;
		wharf = 0;
		edge = new MEdge[m + n + 1];
		father = new int[n + 1];
	}

	void tree() {
		init();
		for (int i = 1; i <= m; i++) {
			int a = unionsearch(edge[i].start);
			int b = unionsearch(edge[i].destination);
			if (a != b) {
				father[a] = b;
			}
		}
		int i;
		for (i = 2; i <= n; i++) {
			if (unionsearch(1) != unionsearch(i)) {
				break;
			}
		}
		init();
		QuickSort(1, m + wharf + 1);
		if (i == n + 1) {
			int sum1 = kruskal(false);
			init();
			int sum2 = kruskal(true);
			System.out.println(sum1 < sum2 ? sum1 : sum2);
		} else {
			System.out.println(kruskal(true));
		}
	}

	// 加权连通图的最小生成树算法
	int kruskal(boolean flag) {
		int sum = 0;
		int num = m + wharf;
		for (int i = 1; i <= num; i++) {
			if (edge[i].start == 0 && flag == false)
				continue;
			int a = unionsearch(edge[i].start);
			int b = unionsearch(edge[i].destination);
			if (a != b || edge[i].value < 0) {
				sum += edge[i].value;
				father[a] = b;
			}
		}
		return sum;
	}

	void init() {
		for (int i = 0; i <= n; i++) {
			father[i] = i;
		}
	}

	int unionsearch(int x) {
		if (x == father[x])
			return x;
		father[x] = unionsearch(father[x]);
		return father[x];
	}

	// 快速排序
	void QuickSort(int left, int right) {
		if (left < right) {
			int middle = Partition(left, right);
			QuickSort(left, middle);
			QuickSort(middle + 1, right);
		}
	}

	// 快速排序的分区
	int Partition(int left, int right) {
		MEdge key = edge[left];
		int i = left;
		for (int j = left + 1; j < right; j++) {
			if (edge[j].value < key.value) {
				i++;
				MEdge news = edge[j];
				edge[j] = edge[i];
				edge[i] = news;
			}
		}
		MEdge news = edge[i];
		edge[i] = edge[left];
		edge[left] = news;
		return i;
	}
}
