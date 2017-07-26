package com.lanqiao.basic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ������ϰ Huffuman��
 * 
 * ��������<br>
 * Huffman���ڱ��������Ź㷺��Ӧ�á����������ֻ����Huffman���Ĺ�����̡�<br>
 * ����һ����{pi}={p0, p1, ��, pn-1}��������������Huffman���Ĺ������£�<br>
 * 1. �ҵ�{pi}����С������������Ϊpa��pb����pa��pb��{pi}��ɾ������Ȼ�����ǵĺͼ��뵽{pi}�С�������̵ķ��ü�Ϊpa +pb��<br>
 * 2. �ظ�����1��ֱ��{pi}��ֻʣ��һ������<br>
 * ������Ĳ��������У������еķ�����ӣ��͵õ��˹���Huffman�����ܷ��á�<br>
 * �������񣺶��ڸ�����һ�����У�������������ø����й���Huffman�����ܷ��á�<br>
 * 
 * ���磬��������{pi}={5, 3, 8, 2, 9}��Huffman���Ĺ���������£�<br>
 * 1. �ҵ�{5, 3, 8, 2, 9}����С�����������ֱ���2��3����{pi}��ɾ�����ǲ�����5���룬�õ�{5, 8, 9, 5}������Ϊ5��<br>
 * 2. �ҵ�{5, 8, 9, 5}����С�����������ֱ���5��5����{pi}��ɾ�����ǲ�����10���룬�õ�{8, 9, 10}������Ϊ10��<br>
 * 3. �ҵ�{8, 9, 10}����С�����������ֱ���8��9����{pi}��ɾ�����ǲ�����17���룬�õ�{10, 17}������Ϊ17��<br>
 * 4. �ҵ�{10, 17}����С�����������ֱ���10��17����{pi}��ɾ�����ǲ�����27���룬�õ�{27}������Ϊ27��<br>
 * 5. ���ڣ�������ֻʣ��һ����27��������̽������ܷ���Ϊ5+10+17+27=59��<br>
 * �����ʽ<br>
 * ����ĵ�һ�а���һ��������n��n<=100����<br>
 * ��������n������������ʾp0, p1, ��, pn-1��ÿ����������1000��<br>
 * �����ʽ<br>
 * �������Щ������Huffman�����ܷ��á�<br>
 * ��������<br>
 * 5<br>
 * 5 3 8 2 9<br>
 * �������<br>
 * 59<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺ ̰�� Huffuman
 * 
 * @author Chain
 *
 */
public class Basic28 {

	// ̰���㷨
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] d = new int[n];
		for (int i = 0; i < n; i++)
			d[i] = in.nextInt();
		in.close();

		method1(d);
		method2(d);
	}

	// ʹ������
	private static void method2(int[] d) {
		int z = 0;
		int count = 0;
		while (z < d.length - 1) {
			mySort(d);
			int t = d[z] + d[z + 1];
			d[z] = -1;
			d[z + 1] = t;
			count += t;
			z++;
		}
		System.out.println(count);
	}

	private static void mySort(int[] d) {
		for (int i = 0; i < d.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < d.length; j++)
				if (d[min] > d[j])
					min = j;
			if (min != i)
				swap(d, i, min);
		}
	}

	public static void swap(int[] n, int i, int j) {
		n[i] ^= n[j];
		n[j] ^= n[i];
		n[i] ^= n[j];
	}

	// ʹ��java api
	private static void method1(int[] d) {
		LinkedList<Integer> set = new LinkedList<>();
		for (int i = 0; i < d.length; i++)
			set.add(d[i]);

		int cost = 0;
		while (set.size() > 1) {
			Collections.sort(set);
			int t = set.get(0) + set.get(1);
			set.set(0, t);
			set.remove(1);
			cost += t;
		}
		System.out.println(cost);
	}

}
