package com.chain.part1.tool00.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * 
 * 产生随机<b>不重复</b>的整型数组
 * 
 * @version 20170108
 * @author Chain
 *
 */
public class RandomIntegerArrayMethod {

	public static void main(String[] args) {
		int a[] = randomDoubleCirculation(0, 9, 10);
		TestMethod.print(a);

		int b[] = randomSelectArray(0, 9, 10);
		TestMethod.print(b);

		int c[] = randomHashSet(0, 9, 10);
		TestMethod.print(c);

		int d[] = randomByList(0, 9, 10);
		TestMethod.print(d);

		int e[] = randomSelectArray(-6, 9, 5);
		TestMethod.print(e);

		int f[] = randomDoubleCirculation(-6, 9, 7);
		TestMethod.print(f);

		// other test
		// int g[] = randomDoubleCirculation(-6, 9, 20);
		// TestMethod.print(g);
	}

	/**
	 * 随机指定范围内N个不重复的数 利用List中contains方法
	 * 
	 * @param min
	 *            指定范围最小值
	 * @param max
	 *            指定范围最大值
	 * @param n
	 *            随机数个数
	 * @return int[] 随机数结果数组
	 */
	private static int[] randomByList(int min, int max, int n) {
		checkArgs(min, max, n);
		int[] result = new int[n];
		List<Integer> lst = new ArrayList<>();
		Random rand = new Random();
		while (lst.size() < n) {
			int num = rand.nextInt(max + 1) + min;
			if (!lst.contains(num))
				lst.add(num);
		}
		for (int i = 0; i < n; i++)
			result[i] = lst.get(i);
		return result;
	}

	private static void checkArgs(int min, int max, int n) {
		if (n > (max - min + 1) || max < min || n < 1)
			throw new RuntimeException("n should smaller than (max - min + 1) and (max >= min) and (n>0)");
	}

	/**
	 * 随机指定范围内N个不重复的数 最简单最基本的方法(双重循环)
	 * 
	 * @param min
	 *            指定范围最小值
	 * @param max
	 *            指定范围最大值
	 * @param n
	 *            随机数个数
	 * @return int[] 随机数结果数组
	 */
	public static int[] randomDoubleCirculation(int min, int max, int n) {
		checkArgs(min, max, n);
		int[] result = new int[n];
		int count = 0;
		boolean flag = true;
		while (count < n) {
			// Math.random()返回[0.0 1.0)
			int num = (int) (Math.random() * (max - min + 1)) + min;
			flag = true;
			for (int j = 0; j < count; j++) {
				if (num == result[j]) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				result[count] = num;
				count++;
			}
		}
		return result;
	}

	/**
	 * 随机指定范围内N个不重复的数 利用HashSet的特征，只能存放不同的值
	 * 
	 * 更新：该方法不能产生正确的随机数数组，因为HashSet底层是HashMap,如果随机数个数和范围区间值一样，比如生成0-9的10个随机数，结果会自动排序。
	 * 无论使用递归还是循环，都不能正确的得到结果。
	 * 
	 * @param min
	 *            指定范围最小值
	 * @param max
	 *            指定范围最大值
	 * @param n
	 *            随机数个数
	 * @return int[] 随机数结果数组
	 */
	@Deprecated
	private static int[] randomHashSet(int min, int max, int n) {
		checkArgs(min, max, n);
		HashSet<Integer> set = new HashSet<>(0);
		Random rand = new Random();
		while (set.size() < n) {
			int num = rand.nextInt(max + 1) + min;
			/*
			 * while (set.contains(num)) num = rand.nextInt(max) + min;
			 */
			set.add(num);
		}
		int a[] = new int[n];
		Integer ia[] = new Integer[n];
		set.toArray(ia);
		for (int i = 0; i < n; i++)
			a[i] = ia[i];
		return a;
	}

	/**
	 * 随机指定范围内N个不重复的数 在初始化的无重复待选数组中随机产生一个数放入结果中，
	 * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换 然后从len-2里随机产生下一个随机数，如此类推
	 * 
	 * @param max
	 *            指定范围最大值
	 * @param min
	 *            指定范围最小值
	 * @param n
	 *            随机数个数
	 * @return int[] 随机数结果数组
	 */
	public static int[] randomSelectArray(int min, int max, int n) {
		checkArgs(min, max, n);
		int len = max - min + 1;
		// 初始化给定范围的待选增序数组
		int[] source = new int[len];
		for (int i = min; i < min + len; i++) {
			source[i - min] = i;
		}

		int[] result = new int[n];
		Random rd = new Random();
		int index = 0;
		for (int i = 0; i < result.length; i++) {
			// 待选数组0到(len-2)随机一个下标
			index = Math.abs(rd.nextInt() % len--);
			// 将随机到的数放入结果集
			result[i] = source[index];
			// 将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
			source[index] = source[len];
		}
		return result;
	}

}
