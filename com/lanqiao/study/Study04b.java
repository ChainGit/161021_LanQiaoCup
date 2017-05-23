package com.lanqiao.study;

public class Study04b {

	private static long cut = 0l;

	// ËØÊıÁ·Ï°
	public static void main(String[] args) {
		start();
		// É¸·¨Á·Ï°
		sf(100001);
		end();
	}

	private static void sf(int x) {
		final int N = 1000 * 1000 * 10;
		boolean dat[] = new boolean[N];
		for (int i = 2; i < N / 2; i++) {
			if (dat[i])
				continue;

			for (int j = 2; j < N / i; j++)
				if (i * j < N)
					dat[i] = true;
		}

		int num = 0;
		for (int i = 2; i < N; i++)
			if (!dat[i])
				if (++num == x)
					System.out.println(num + ":" + i);

	}

	public static void start() {
		cut = System.currentTimeMillis();
	}

	public static void end() {
		System.out.println("spend: " + (System.currentTimeMillis() - cut));
	}
}
