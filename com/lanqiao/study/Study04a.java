package com.lanqiao.study;

public class Study04a {

	private static long cut = 0l;

	// 整数、整除、余数
	// 最大公约数、最小公倍数
	public static void main(String[] args) {
		start();
		System.out.println(zdgys1(1123123124, 21123324));
		end();

		start();
		System.out.println(zdgys1(7, 4));
		end();

		start();
		System.out.println(zdgys2(1123123124, 21123324));
		end();

		start();
		System.out.println(zdgys2(7, 4));
		end();

		start();
		System.out.println(zdgys3(15, 40));
		end();

		start();
		System.out.println(zxgbs1(5, 8));
		end();

		start();
		System.out.println(qmqm(5, 8, 17));
		end();

	}

	// 求幂并取模(再大的数可以使用分治法 )
	public static int qmqm(int i, int j, int p) {
		int x = 1;
		for (int k = 0; k < j; k++)
			x = (x * j) % p;
		return x % p;
	}

	// 最小公倍数(i*j/gcd(i,j))
	public static long zxgbs1(int i, int j) {
		return i * j / zdgys2(i, j);// i / t * j / t * t,其中t=gcd(i,j)
	}

	// 辗转相除法(欧几里得算法)求解最大公约数(循环)
	public static int zdgys2(int i, int j) {
		int m = min(i, j);
		int n = max(i, j);
		while (true) {
			if (m == 0)
				return n;
			int t = m;
			m = n % m;
			n = t;
		}
	}

	// 辗转相除法(欧几里得算法)求解最大公约数(递归)
	public static int zdgys3(int i, int j) {
		int m = min(i, j);
		int n = max(i, j);
		return gcd(m, n);
	}

	private static int gcd(int m, int n) {
		if (m == 0)
			return n;
		return gcd(n % m, m);
	}

	// 暴力求解最大公约数
	public static int zdgys1(int i, int j) {
		for (int p = min(i, j); p > -1; p--)
			if (i % p == 0 && j % p == 0)
				return p;
		return 1;
	}

	public static int min(int i, int j) {
		return i > j ? j : i;
	}

	public static int max(int i, int j) {
		return i > j ? i : j;
	}

	public static void start() {
		cut = System.currentTimeMillis();
	}

	public static void end() {
		System.out.println("spend: " + (System.currentTimeMillis() - cut));
	}
}
