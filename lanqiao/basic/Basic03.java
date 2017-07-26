package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 字母图形
 * 
 * 总结：嵌套循环，注意观察分析，化简问题，字符串
 * 
 * @author Lenovo
 *
 */
public class Basic03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		// i既是行，也是A的位置
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				System.out.print((char) (Math.abs(j - i) + 'A'));
			System.out.println();
		}
		in.close();
	}

}
