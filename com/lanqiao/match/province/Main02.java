package com.lanqiao.match.province;

import java.util.Arrays;

/*
2，标题：纸牌三角形

        A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
        下图就是一种排法（如有对齐问题，参看p1.png）。

              A
             9 6
            4   8
           3 7 5 2

        这样的排法可能会有很多。

        如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？

        请你计算并提交该数字。

        注意：需要提交的是一个整数，不要提交任何多余内容。

分析：填空题，故暴力枚举，总共9个空;也可以使用递归做法，少排序
答案：144
 */
public class Main02 {

	public static void main(String[] args) {
		int sum = 0;
		// 10的10次方次循环
		for (int a = 1; a <= 9; a++)
			for (int b = 1; b <= 9; b++)
				for (int c = 1; c <= 9; c++)
					for (int d = 1; d <= 9; d++)
						for (int e = 1; e <= 9; e++)
							for (int f = 1; f <= 9; f++)
								for (int g = 1; g <= 9; g++)
									for (int h = 1; h <= 9; h++)
										for (int i = 1; i <= 9; i++)
											if (!sort(new int[] { a, b, c, d, e, f, g, h, i }))
												continue;
											else {
												int s1 = a + b + c + d;
												int s2 = a + i + h + g;
												int s3 = d + e + f + g;
												if (s1 == s2 && s2 == s3)
													sum++;
											}

		// 除去镜像2和旋转3这两种重复情况,2*3
		System.out.println(sum / 6);
	}

	private static boolean sort(int[] arr) {
		int len = arr.length;

		// 排序，不重复的组合肯定是从1到9的
		Arrays.sort(arr);
		for (int i = 0; i < len; i++)
			if (arr[i] != i + 1)
				return false;

		return true;
	}
}
