package com.lanqiao.match.province;

import java.util.Arrays;

/*
2�����⣺ֽ��������

        A,2,3,4,5,6,7,8,9 ��9��ֽ���ų�һ���������Σ�A��1���㣩��Ҫ��ÿ���ߵĺ���ȡ�
        ��ͼ����һ���ŷ������ж������⣬�ο�p1.png����

              A
             9 6
            4   8
           3 7 5 2

        �������ŷ����ܻ��кܶࡣ

        ���������ת���������ͬ����ͬһ�֣�һ���ж����ֲ�ͬ���ŷ��أ�

        ������㲢�ύ�����֡�

        ע�⣺��Ҫ�ύ����һ����������Ҫ�ύ�κζ������ݡ�

����������⣬�ʱ���ö�٣��ܹ�9����;Ҳ����ʹ�õݹ�������������
�𰸣�144
 */
public class Main02 {

	public static void main(String[] args) {
		int sum = 0;
		// 10��10�η���ѭ��
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

		// ��ȥ����2����ת3�������ظ����,2*3
		System.out.println(sum / 6);
	}

	private static boolean sort(int[] arr) {
		int len = arr.length;

		// ���򣬲��ظ�����Ͽ϶��Ǵ�1��9��
		Arrays.sort(arr);
		for (int i = 0; i < len; i++)
			if (arr[i] != i + 1)
				return false;

		return true;
	}
}
