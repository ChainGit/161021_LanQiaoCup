package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prev22 {
	// Õª×Ô¹Ù·½´ð°¸

	private static int n;
	private static int m;
	private static int sum;
	private static int island[];
	private static Edge bridge[];

	public static void main(String[] args) throws Exception {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String read[] = buf.readLine().split("\\s+");
		n = Integer.parseInt(read[0]);
		m = Integer.parseInt(read[1]);
		bridge = new Edge[m];
		island = new int[n];
		int from, to, day;
		for (int i = 0; i < m; i++) {
			read = buf.readLine().split("\\s+");
			from = Integer.parseInt(read[0]) - 1;
			to = Integer.parseInt(read[1]) - 1;
			day = Integer.parseInt(read[2]);
			bridge[i] = new Edge(from, to, day);
		}

		Arrays.sort(bridge);
		init();

		boolean flag = false;
		for (int i = 0; i < m; i++) {
			flag = false;
			from = bridge[i].from;
			to = bridge[i].to;
			if (!isConnect(from, to)) {
				flag = true;
				union(from, to);
			}
			while (i < m - 1 && bridge[i].day == bridge[i + 1].day) {
				from = bridge[i + 1].from;
				to = bridge[i + 1].to;
				if (!isConnect(from, to)) {
					flag = true;
					union(from, to);
				}
				i++;
			}
			if (flag)
				sum++;
		}
		System.out.println(sum);
	}

	private static boolean isConnect(int i, int j) {
		if (find(i) == find(j))
			return true;
		return false;
	}

	private static void init() {
		for (int i = 0; i < n; i++)
			island[i] = i;
	}

	private static void union(int x, int y) {
		island[find(x)] = find(y);
	}

	private static int find(int x) {
		if (island[x] == x)
			return x;
		island[x] = find(island[x]);
		return island[x];
	}
}

class Edge implements Comparable<Edge> {
	int from;
	int to;
	int day;

	public Edge(int from, int to, int day) {
		super();
		this.from = from;
		this.to = to;
		this.day = day;
	}

	@Override
	public int compareTo(Edge p) {
		if (this.day < p.day)
			return 1;
		else if (this.day > p.day)
			return -1;
		return 0;
	}
}