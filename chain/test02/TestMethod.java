package com.chain.part1.tool00.utils;

/**
 * һЩ���ڲ��Եĳ��÷���
 * 
 * @version 20170101
 * @author Chain
 *
 */
public class TestMethod {

	public static void main(String[] args) {
		print(new int[] { 1, 5, 2, 5, 3 });

		// other test
		// print(null);
		// print(new int[0]);
	}

	/**
	 * ��ӡ���������飬����main�Ĳ���
	 * 
	 * @param a
	 *            Ҫ��ӡ����������
	 */
	protected static void print(int[] a) {
		if (a == null || a.length < 1)
			throw new RuntimeException("array is null or empty");
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
	}
}
