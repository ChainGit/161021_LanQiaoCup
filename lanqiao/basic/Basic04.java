package com.lanqiao.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 基础练习 数列特征
 * 
 * 总结：最值问题，不使用数组，累加
 * 
 * @author Lenovo
 *
 */
public class Basic04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// method1();
		method2();
	}

	// 偷懒法
	public static void method1() {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> lst = new ArrayList<>();
		int n = in.nextInt();
		long sum = 0;
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			lst.add(t);
			sum += t;
		}
		Collections.sort(lst);
		System.out.println(lst.get(lst.size() - 1));
		System.out.println(lst.get(0));
		System.out.println(sum);
		in.close();
	}

	public static void method2() {
		String ls = System.getProperty("line.separator");
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		long sum = 0;
		int max = 0, min = 0;
		for (int i = 0; i < len && in.hasNext(); i++) {
			int t = in.nextInt();
			if (i == 0)
				max = min = t;
			else {
				if (t > max)
					max = t;
				else if (t < min)
					min = t;
			}
			sum += t;
		}
		System.out.println(max + ls + min + ls + sum);
		// System.out.println(max);
		// System.out.println(min);
		// System.out.println(sum);
		in.close();
	}

}
