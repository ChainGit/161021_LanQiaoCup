package com.lanqiao.prev;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 历届试题 斐波那契
 * 
 * @author Chain
 *
 */
public class Prev29 {

	// 摘自官方答案：使用Java自带的BigInteger来处理，封装了很多基本大数运算
	// 同样的如：BigDecimal
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n, m;
		n = sc.nextLong();
		m = sc.nextLong();
		BigInteger p = sc.nextBigInteger(), fn, fm;
		sc.close();
		if (n + 2 > m) {
			fm = think(m, null);
			fn = think(n + 2, fm).subtract(new BigInteger("1"));
			System.out.println(fn.remainder(fm).remainder(p));
		} else {
			fn = think(n + 2, p).subtract(new BigInteger("1"));
			System.out.println(fn.remainder(p));
		}
	}

	// 获得斐波那契数f(n)
	private static BigInteger think(long n, BigInteger mod) {
		BigInteger a1 = new BigInteger("1"), a2 = new BigInteger("1"), x[][];
		if (n == 1)
			return a1;
		else if (n == 2)
			return a2;
		else {
			x = new BigInteger[2][2];
			x[0][0] = new BigInteger("1");
			x[0][1] = new BigInteger("1");
			x[1][0] = new BigInteger("1");
			x[1][1] = new BigInteger("0");
			x = doublex(x, n - 2, mod);
			return x[0][0].add(x[0][1]);
		}
	}

	private static BigInteger[][] doublex(BigInteger[][] x, long n, BigInteger mod) {
		if (n == 1)
			return x;
		else {
			if (n % 2 == 1)
				return cheng(doublex(cheng(x, x, mod), n / 2, mod), x, mod);
			else
				return doublex(cheng(x, x, mod), n / 2, mod);
		}
	}

	private static BigInteger[][] cheng(BigInteger[][] x, BigInteger[][] y, BigInteger mod) {
		BigInteger z[][];
		z = new BigInteger[2][2];
		if (mod != null) {
			z[0][0] = x[0][0].multiply(y[0][0]).add(x[1][0].multiply(y[0][1])).remainder(mod);
			z[0][1] = x[0][0].multiply(y[0][1]).add(x[0][1].multiply(y[1][1])).remainder(mod);
			z[1][0] = x[1][0].multiply(y[0][0]).add(x[1][1].multiply(y[1][0])).remainder(mod);
			z[1][1] = x[1][0].multiply(y[0][1]).add(x[1][1].multiply(y[1][1])).remainder(mod);
			return z;
		}
		z[0][0] = x[0][0].multiply(y[0][0]).add(x[1][0].multiply(y[0][1]));
		z[0][1] = x[0][0].multiply(y[0][1]).add(x[0][1].multiply(y[1][1]));
		z[1][0] = x[1][0].multiply(y[0][0]).add(x[1][1].multiply(y[1][0]));
		z[1][1] = x[1][0].multiply(y[0][1]).add(x[1][1].multiply(y[1][1]));
		return z;
	}
}
