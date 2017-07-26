package com.lanqiao.study;

public class Study03b {

	// IEEE754
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		double a = 0d;
		double b = 0d;
		double c = 0d;
		double d = 0d;

		try {
			a = 0 / 0;
		} catch (Exception e) {
			// e.printStackTrace();
		}

		b = 0.0 / 0;
		System.out.println(b);
		System.out.println(-b);
		System.out.println(b + 1);
		System.out.println(b - 1);
		System.out.println(b * 8);
		System.out.println(b / 8);

		System.out.println();

		c = 1 / 0.0;
		System.out.println(c);
		System.out.println(-c);
		System.out.println(c + 1);
		System.out.println(c - 1);
		System.out.println(c * 8);
		System.out.println(c / 8);

		System.out.println();

		System.out.println(c + c);
		System.out.println(c - c);
		System.out.println(c * c);
		System.out.println(c / c);

		System.out.println();

		d = 1 / c;
		System.out.println(d);
		System.out.println(-d);
		System.out.println(d + d);
		System.out.println(d - d);
		System.out.println(d * d);
		System.out.println(d / d);

	}
}
