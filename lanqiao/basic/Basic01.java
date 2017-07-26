package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 闰年判断
 * 
 * 总结：逻辑判断简单应用
 * 
 * @author Lenovo
 *
 */
public class Basic01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if (n % 400 == 0 || (n % 4 == 0 && n % 100 != 0)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		in.close();
	}

}
