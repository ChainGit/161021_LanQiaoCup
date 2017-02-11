package com.lanqiao.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 基础练习 数的读法
 * 
 * 问题描述 <br>
 * Tom教授正在给研究生讲授一门关于基因的课程，有一件事情让他颇为头疼：一条染 <br>
 * 色体上有成千上万个碱基对，它们从0开始编号，到几百万，几千万，甚至上亿。 <br>
 * 比如说，在对学生讲解第1234567009号位置上的碱基时，光看着数字是很难准确的念 <br>
 * 出来的。 <br>
 * 所以，他迫切地需要一个系统，然后当他输入12 3456 7009时，会给出相应的念法： <br>
 * 十二亿三千四百五十六万七千零九 <br>
 * 用汉语拼音表示为 <br>
 * shi er yi san qian si bai wu shi liu wan qi qian ling jiu <br>
 * 这样他只需要照着念就可以了。 <br>
 * 你的任务是帮他设计这样一个系统：给定一个阿拉伯数字串，你帮他按照中文读写的 <br>
 * 规范转为汉语拼音字串，相邻的两个音节用一个空格符格开。 <br>
 * 注意必须严格按照规范，比如说“10010”读作“yi wan ling yi shi”而不是“yi wan <br>
 * ling shi”，“100000”读作“shi wan”而不是“yi shi wan”，“2000”读作“er qian”而 <br>
 * 不是“liang qian”。 <br>
 * 输入格式 <br>
 * 有一个数字串，数值大小不超过2,0 00,00 0,000。 <br>
 * 输出格式 <br>
 * 是一个由小写英文字母，逗号和空格组成的字符串，表示该数的英文读法。 <br>
 * 样例输入 <br>
 * 1234567009 <br>
 * 样例输出 <br>
 * shi er yi san qian si bai wu shi liu wan qi qian ling jiu <br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结: 判断 函数
 * 
 * @author Chain
 *
 */
public class Basic20 {

	private static final String[] xxpy = new String[] { "ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba",
			"jiu" };

	private static final String[] xxhz = new String[] { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };

	private static final String[] dxsz = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

	private static final String[] xxpydw = { "", "shi", "bai", "qian", "", "wan", "yi" };// ge是""

	private static final String[] xxhzdw = { "", "十", "百", "千", "", "万", "亿" };// 个位是""

	private static final String[] dxhzdw = { "", "拾", "佰", "仟", "", "万", "亿" };// 10,11,12,13,14,15,16

	private static String[] nums = null;
	private static String[] units = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();

		char[] arr = s.toCharArray();

		arr = preProcess(arr);
		if (arr == null)
			return;

		LinkedList<Byte> dlst = change(arr);

		nums = xxpy;
		units = xxpydw;
		print(dlst);

		nums = xxhz;
		units = xxhzdw;
		print(dlst);

		nums = dxsz;
		units = dxhzdw;
		print(dlst);
	}

	private static char[] preProcess(char[] arr) {
		// 判断长度
		int len = arr.length;
		if (len > 12) {
			System.out.println("输入过长,最多支持12位!");
			return null;
		}

		// 判断是否都是数字
		for (int i = 0; i < len; i++)
			if (arr[i] < 48 || arr[i] > 57) {
				System.out.println("输入包含非数字!");
				return null;
			}

		// 去除开头的零
		boolean isZeroStart = arr[0] == 48 ? true : false;
		int m = 0;
		for (; isZeroStart && m < len; m++) {
			if (arr[m] == 48)
				continue;
			else
				break;
		}

		// 将数组重新整合
		arr = Arrays.copyOfRange(arr, m, len);
		len -= m;

		// 打印最终预处理后的数组值
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
			if (i < len - 1 && (len - i - 1) % 4 == 0)
				System.out.print(",");
		}
		System.out.println();
		return arr;
	}

	private static LinkedList<Byte> change(char[] arr) {
		// 根据数组值转化为中间链表
		LinkedList<Byte> dlst = new LinkedList<>();
		int last = arr.length - 1;
		for (int i = last; i > -1; i--) {
			int p = last - i;
			if (p % 4 == 0)
				dlst.add((byte) (14 + p / 4));
			int tmp = arr[i] - 48;
			if (tmp != 0)
				dlst.add((byte) (10 + p % 4));
			// 不考虑特殊情况
			dlst.add((byte) tmp);
		}

		Collections.reverse(dlst);

		// 去除"10"读作十而非一十
		if (dlst.get(0) == 1 && dlst.get(1) == 11)
			dlst.remove(0);

		// 将多余的0先变成-1
		for (int i = 0; i < dlst.size(); i++)
			if (dlst.get(i) == 0) {
				int j = i + 1;
				for (; j < dlst.size() && dlst.get(j) == 0; j++)
					dlst.set(j, (byte) -1);
				if (dlst.get(j) > 13)
					dlst.set(i, (byte) -1);
				i = j;
			}

		// 删除所有的-1
		int len = dlst.size();
		boolean isClear = false;
		while (!isClear) {
			isClear = true;
			for (int i = 0; i < len; i++)
				if (dlst.get(i) == -1) {
					dlst.remove(i);
					isClear = false;
					len--;
				}
		}

		// 删除没有意义的""
		len = dlst.size();
		isClear = false;
		while (!isClear) {
			isClear = true;
			for (int i = 0; i < len; i++) {
				int b = dlst.get(i);
				if (b == 10 || b == 14) {
					isClear = false;
					dlst.remove(i);
					len--;
				}
			}
		}

		// 删除亿万连在一起
		len = dlst.size();
		for (int i = 0; i < len; i++)
			if (dlst.get(i) == 16 && dlst.get(i + 1) == 15) {
				dlst.remove(i + 1);
				break;
			}

		// 删除亿万开头
		if (dlst.get(0) == 16 || dlst.get(0) == 15)
			dlst.remove(0);

		// System.out.println(dlst);

		return dlst;
	}

	private static void print(LinkedList<Byte> arr) {
		int last = arr.size() - 1;
		for (int i = 0; i < last; i++) {
			int da = arr.get(i);
			if (da == 10 || da == 14 || da == -1)
				continue;
			else if (da < 10)
				System.out.print(nums[da]);
			else
				System.out.print(units[da - 10]);
			if (da != 10 || da != 14)
				System.out.print(" ");
		}

		int tmp = arr.get(last);
		if (tmp == 10 || tmp == 14 || tmp == -1)
			System.out.println();
		else if (tmp < 10)
			System.out.println(nums[tmp]);
		else
			System.out.println(units[tmp - 10]);
	}
}
