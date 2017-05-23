package com.lanqiao.study;

public class Study04a {

	private static long cut = 0l;

	// ����������������
	// ���Լ������С������
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

	// ���ݲ�ȡģ(�ٴ��������ʹ�÷��η� )
	public static int qmqm(int i, int j, int p) {
		int x = 1;
		for (int k = 0; k < j; k++)
			x = (x * j) % p;
		return x % p;
	}

	// ��С������(i*j/gcd(i,j))
	public static long zxgbs1(int i, int j) {
		return i * j / zdgys2(i, j);// i / t * j / t * t,����t=gcd(i,j)
	}

	// շת�����(ŷ������㷨)������Լ��(ѭ��)
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

	// շת�����(ŷ������㷨)������Լ��(�ݹ�)
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

	// ����������Լ��
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
