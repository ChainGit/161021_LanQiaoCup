package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 历届试题 小朋友排队
 * 
 * @author Chain
 *
 */
public class Prev31 {
	// 摘自官方答案

	static int N = 100010;
	static int MAX = 1000100;
	static int[] C = new int[MAX];
	static int[] S = new int[MAX];
	static int[] b = new int[N];
	static long[] total = new long[N];
	static long ans;
	static int[] num = new int[N];
	static int T, s, t, i, j;

	static int Lowbit(int x) {
		return x & (-x);
	}

	static void add(int pos, int num, int[] P) {
		while (pos <= MAX) {
			P[pos] += num;
			pos += Lowbit(pos);
		}
	}

	static int Sum(int end, int[] P) {
		int cnt = 0;
		while (end > 0) {
			cnt += P[end];
			end -= Lowbit(end);
		}
		return cnt;
	}

	static void init() {
		total[0] = 0;
		for (int i = 1; i < N; ++i) {
			total[i] = total[i - 1] + i;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(buf.readLine());
		String[] str = buf.readLine().split(" ");
		for (int j = 0; j < T; j++) {
			num[j] = Integer.parseInt(str[j]);
			add(num[j] + 1, 1, C);
			b[j] = j - Sum(num[j], C);
			b[j] -= Sum(num[j] + 1, C) - Sum(num[j], C) - 1;
		}
		ans = 0;
		for (int j = T - 1; j > -1; --j) {
			add(num[j] + 1, 1, S);
			b[j] += Sum(num[j], S);
			ans += total[b[j]];
		}
		System.out.println(ans);
	}
}
