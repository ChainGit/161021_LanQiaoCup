package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 历届试题 蚂蚁感冒
 * 
 * @author Chain
 *
 */
public class Prev27 {

	public static void main(String[] args) throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String[] pbuf = bufr.readLine().split(" ");
		int n = new Integer(pbuf[0]);
		int[] ants = new int[n];
		boolean[] direction = new boolean[n];
		pbuf = bufr.readLine().split(" ");
		bufr.close();

		for (int i = 0; i < n; i++) {
			ants[i] = new Integer(pbuf[i]);
			if (ants[i] > 0)
				direction[i] = true;
		}

		int first = fabs(ants[0]);
		boolean firstd = direction[0];
		// 从第2个蚂蚁依次判断,跳过中间过程,直接考虑最终
		int a = 0, b = 0, c = 0, d = 0;
		for (int i = 1; i < n; i++)
			// 列举能碰到感冒的蚂蚁情况
			if (firstd) {
				if (first > fabs(ants[i]) && direction[i])
					a++;
				if (first < fabs(ants[i]) && !direction[i])
					b++;
			} else {
				if (first > fabs(ants[i]) && direction[i])
					c++;
				if (first < fabs(ants[i]) && !direction[i])
					d++;
			}

		if (firstd) {
			if (b != 0)
				System.out.println(a + b + 1);
			else
				System.out.println(1);
		} else {
			if (c != 0)
				System.out.println(c + d + 1);
			else
				System.out.println(1);
		}
	}

	// 绝对值
	public static int fabs(int i) {
		return Math.abs(i);
	}
}
