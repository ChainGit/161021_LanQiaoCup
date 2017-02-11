package com.lanqiao.basic;

/**
 * 
 * 基础练习 特殊的数字
 * 
 * 总结：循环 判断 数位 由整体化分到局部，由局部组成整体
 * 
 * @author Lenovo
 *
 */
public class Basic07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
		System.out.println();
		method2();
	}

	// 输出为升序
	public static void method1() {
		for (int n = 100; n < 1000; n++) {
			int a = n / 100;
			int b = n / 10 % 10;
			int c = n % 10;
			if (n == a * a * a + b * b * b + c * c * c)
				System.out.println(n);// System.out.printf("%d%d%d\n", a, b, c);
		}
	}

	public static void method2() {
		for (int a = 1; a < 9; a++)
			for (int b = 0; b < 9; b++)
				for (int c = 0; c < 9; c++) {
					int t = a * 100 + b * 10 + c;
					if (t == (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)))
						System.out.println(t);
				}
	}

}
