package com.lanqiao.basic;

import java.util.Scanner;

/**
 * 基础练习 Sine之舞
 * 
 * 问题描述<br>
 * 最近FJ为他的奶牛们开设了数学分析课，FJ知道若要学好这门课，必须有一个好的三角函数基本功。<br>
 * 所以他准备和奶牛们做一个“Sine之舞”的游戏，寓教于乐，提高奶牛们的计算能力。<br>
 * 不妨设<br>
 * An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)<br>
 * Sn=(...(A1+n)A2+n-1)A3+...+2)An+1<br>
 * FJ想让奶牛们计算Sn的值，请你帮助FJ打印出Sn的完整表达式，以方便奶牛们做题。<br>
 * 输入格式<br>
 * 仅有一个数：N<201。<br>
 * 输出格式<br>
 * 请输出相应的表达式Sn，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。<br>
 * 样例输入<br>
 * 3<br>
 * 样例输出<br>
 * ((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1<br>
 * 
 * A1 = sin(1)<br>
 * A2 = sin(1-sin(2))<br>
 * A3 = sin(1-sin(2+sin(3)))<br>
 * 
 * Sn=(...(A1+n)A2+n-1)A3+...+2)An+1<br>
 * S1=(null)A1+1<br>
 * S2=(A1+2)A2+1<br>
 * S3=((A1+3)A2+2)A3+1<br>
 * S4=(((A1+4)A2+3)A3+2)A4+1<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：字符串 递归 递推
 * 
 * @author Chain
 *
 */
public class Basic21 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		String sAn = null;
		StringBuilder sbAn = new StringBuilder();
		StringBuilder sbSn = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sAn = String.valueOf(i + 1);
			for (int j = 0; j < i + 1; j++) {
				int t = i - j;
				if (t > 0) {
					sbAn.append(t);
					sbAn.append(t % 2 == 0 ? "+" : "-");
				}
				sbAn.append("sin(");
				sbAn.append(sAn);
				sbAn.append(")");
				sAn = sbAn.toString();
				sbAn.delete(0, sbAn.length());
			}
			System.out.println("A" + (i + 1) + "=" + sAn);
			addToSn(sbSn, sAn);
			printSn(sbSn);
		}

	}

	private static void printSn(StringBuilder sbSn) {
		// 确定有几个括号
		int n = 0;
		for (int i = 0; i < sbSn.length(); i++)
			if (sbSn.charAt(i) == '(')
				n++;
			else
				break;

		System.out.print("S" + (++n) + "=");
		for (int i = 0; i < sbSn.length(); i++) {
			char t = sbSn.charAt(i);
			System.out.print(t);
			if (t == '+' && n != 1)
				System.out.print(n--);
		}
		System.out.println(1);
	}

	private static void addToSn(StringBuilder sbSn, String sAn) {
		if (sbSn.length() != 0) {
			sbSn.insert(0, "(");
			sbSn.insert(sbSn.length(), ")");
		}
		sbSn.append(sAn);
		sbSn.append("+");
	}

}
