package com.lanqiao.prev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 历届试题 回文数字
 * 
 * @author Chain
 *
 */
public class Prev21 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		ArrayList<Integer> lsta = new ArrayList<>();
		ArrayList<Integer> lstb = new ArrayList<>();

		for (int i = 1; i < 10; i++)
			for (int j = 0; j < 10; j++)
				for (int k = 0; k < 10; k++) {
					int part1 = j * 10 + i;
					int part2 = i * 100 + j * 10 + k;
					int tmp = part2 * 100 + part1;
					int sum = (i << 1) + (j << 1) + k;
					if (sum == n)
						lsta.add(tmp);
					sum += k;
					if (sum == n) {
						tmp = part2 * 1000 + k * 100 + part1;
						lstb.add(tmp);
					}
				}

		Collections.sort(lsta);
		Collections.sort(lstb);

		int lena = lsta.size();
		int lenb = lstb.size();

		for (int i = 0; i < lena; i++)
			System.out.println(lsta.get(i));

		for (int i = 0; i < lenb; i++)
			System.out.println(lstb.get(i));

		if (lena == 0 && lenb == 0)
			System.out.println(-1);
	}
}
