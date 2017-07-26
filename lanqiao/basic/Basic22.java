package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 FJ的字符串
 * 
 * 问题描述<br>
 * 
 * FJ在沙盘上写了这样一些字符串：<br>
 * A1 = “A”<br>
 * A2 = “ABA”<br>
 * A3 = “ABACABA”<br>
 * A4 = “ABACABADABACABA”<br>
 * … … <br>
 * 你能找出其中的规律并写所有的数列AN吗？<br>
 * 
 * 输入格式<br>
 * 
 * 仅有一个数：N ≤ 26。<br>
 * 
 * 输出格式<br>
 * 
 * 请输出相应的字符串AN，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。<br>
 * 
 * 样例输入<br>
 * 
 * 3<br>
 * 样例输出<br>
 * 
 * ABACABA<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：字符串 递归
 * 
 * @author Chain
 *
 */
public class Basic22 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		StringBuilder sbAn = new StringBuilder("");
		for (int i = 0; i < n; i++) {
			String tmp = sbAn.toString();
			sbAn.append((char) ('A' + i));
			sbAn.append(tmp);
			System.out.println("A" + (i + 1) + "=" + sbAn.toString());
		}
	}

}
