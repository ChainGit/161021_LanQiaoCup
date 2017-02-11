package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 
 * 基础练习 杨辉三角形
 * 
 * 总结：二维数组
 * 
 * @author Lenovo
 *
 */
public class Basic06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// method1();
		method2();
	}

	public static void method1() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int[][] data = new int[n][n];
		data[0][0] = 1;
		System.out.println(data[0][0]);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				data[i][j] = (j - 1 < 0 ? 0 : data[i - 1][j - 1]) + data[i - 1][j];
				// System.out.print(data[i][j] == 0 ? "" : data[i][j] + " ");
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void method2() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int[][] data = new int[n][n];
		data[0][0] = 1;
		for (int i = 1; i < n; i++) {
			data[i][0] = 1;
			for (int j = 1; j <= i; j++)
				data[i][j] = data[i - 1][j - 1] + data[i - 1][j];
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(data[i][j] == 0 ? "" : data[i][j] + " ");
			System.out.println();
		}
	}

}
