package com.lanqiao.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 基础练习 分解质因数
 * 
 * 质数（prime number）又称素数，有无限个。<br>
 * 质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数的数称为质数。<br>
 * 
 * 求出区间[a,b]中所有整数的质因数分解。<br>
 * 输入格式<br>
 * 输入两个整数a，b。<br>
 * 输出格式<br>
 * 每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)<br>
 * 样例输入<br>
 * 3 10<br>
 * 样例输出<br>
 * 3=3<br>
 * 4=2*2<br>
 * 5=5<br>
 * 6=2*3<br>
 * 7=7<br>
 * 8=2*2*2<br>
 * 9=3*3<br>
 * 10=2*5<br>
 * 提示<br>
 * 先筛出所有素数，然后再分解。<br>
 * 数据规模和约定<br>
 * 2<=a<=b<=10000<br>
 * <br>
 * 
 * 分析：<br>
 * 1.求出b以前的素数。因为所有的因数都是由素数组成的。<br>
 * 2.如果是最后一个因数那么就不加“*”。<br>
 * 
 * <b>注：VIP试题,未做测试,不保证正确性 (哭</b><br>
 * 
 * 总结：质数分解 循环<br>
 * 
 * @author Chain
 *
 */
public class Basic16 {

	// 分解质因数只针对合数
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		in.close();

		final int data[] = getAllPrimeNums(b);
		printPrimeNums(data);

		test1(a, b);
		System.out.println();
		test2(data, a, b);
	}

	private static void test2(int[] data, int a, int b) {
		for (int i = a; i <= b; i++) {
			// 所有大于1的数都能被质数分解
			System.out.print(i + "=");
			int tmp = i;
			int p = 0;
			// 合数的质数乘积分解是唯一的?
			while (tmp > 0) {
				if (tmp % data[p] == 0) {
					System.out.print(data[p]);
					tmp /= data[p];
					if (tmp > 1) {
						System.out.print("*");
						continue;
					} else if (tmp == 1) {
						System.out.println();
						break;
					}
				}
				p++;
			}
		}
	}

	// 摘自：http://www.cnblogs.com/sun-/p/5252225.html
	private static void test1(int m, int n) {
		for (int i = m; i <= n; i++) {
			System.out.print(i + "=");
			int b = i;
			int k = 2;
			while (k <= Math.sqrt(i)) {
				if (b % k == 0) {
					b = b / k;
					if (b > 1) {
						System.out.print(k + "*");
						continue;
					}
					if (b == 1)
						System.out.println(k);
				}
				k++;
			}
			if (b > 1 && b < i)
				System.out.println(b);
			if (b == i)
				System.out.println(i);
		}
	}

	private static void printPrimeNums(int[] data) {
		System.out.println("total: " + data.length);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
			if (i != 0 && i % 8 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	// 获得所有的不大于b的素数数组
	private static int[] getAllPrimeNums(int b) {
		int[] data0 = new int[b];
		int datanum0 = 0;
		for (int i = 2; i <= b; i++) {
			// 去除1和本身i
			int j = 2;
			for (; j < i; j++)
				if (i % j == 0)
					break;
			if (i == j)
				data0[datanum0++] = i;
		}
		return Arrays.copyOfRange(data0, 0, datanum0);
	}
}
