package com.lanqiao.basic;

/**
 * 基础练习 回文数
 * 
 * 总结：循环 判断 回文数 由整体化分到局部，由局部组成整体
 * 
 * @author Lenovo
 *
 */
public class Basic08 {

	public static void main(String[] args) {
		method1();
		System.out.println();
		method2();
	}

	// 从左向右看
	public static void method1() {
		// TODO Auto-generated method stub
		for (int i = 1000; i < 10000; i++)
			if (i / 1000 == i % 10 && i % 1000 / 100 == i % 100 / 10)
				System.out.println(i);
	}

	// 完成一半即可
	public static void method2() {
		for (int d = 1; d < 10; d++)
			for (int c = 0; c < 10; c++)
				System.out.printf("%d%d%d%d\n", d, c, c, d);

	}
}
