package com.chain.part1.tool00.utils;

/**
 * 
 * �����Ĳ��ҷ���������<i>˳����ң��۰���ң���ֵ����</i>
 * 
 * @version 20170108
 * @author Chain
 *
 */
public class SearchMethod {

	public static void main(String[] args) {
		int[] a = RandomIntegerArrayMethod.randomSelectArray(0, 9, 10);
		TestMethod.print(a);

		System.out.println(getMax(a));
		System.out.println(getMin(a));

		System.out.println(orderSearch(a, 4));
		System.out.println(orderSearch(a, 12));

		SortIntegerArrayMethod.quickSort(a);
		TestMethod.print(a);
		System.out.println(halfSearch(a, 8));
		System.out.println(halfSearch(a, 10));
		System.out.println(halfSearch(a, 20));

		// other test
		// System.out.println(halfSearch(null, 8));
	}

	/**
	 * �ҳ����������е�<i>��Сֵ</i>
	 * 
	 * @param a
	 *            Ҫ���ҵ�����
	 * @return ������������СԪ�ص�ֵ
	 */
	public static int getMin(int[] a) {
		checkArray(a);
		int p = 0;
		for (int i = 0; i < a.length; i++)
			if (a[p] > a[i])
				p = i;
		return a[p];
	}

	/**
	 * �ҳ����������е�<i>���ֵ</i>
	 * 
	 * @param a
	 *            Ҫ���ҵ�����
	 * @return �������������Ԫ�ص�ֵ
	 */
	public static int getMax(int[] a) {
		checkArray(a);
		int p = 0;
		for (int i = 0; i < a.length; i++)
			if (a[p] < a[i])
				p = i;
		return a[p];
	}

	private static void checkArray(int[] a) {
		if (a == null || a.length < 1)
			throw new RuntimeException("array is null or empty");
	}

	/**
	 * ���Բ���
	 * 
	 * @param a
	 *            ����������
	 * @param k
	 *            ���ҵ�����
	 * @return ���ҵ��򷵻�Ԫ�����������<i>�±�</i>����û���ҵ��򷵻�-1
	 */
	public static int orderSearch(int[] a, int k) {
		checkArray(a);
		int index = -1;
		for (index = 0; index < a.length; index++) {
			if (a[index] == k)
				return index;
		}
		return -1;
	}

	/**
	 * �۰����(���ֲ���)��<b>�����������������֪�̶�����</b>
	 * 
	 * @param a
	 *            ����������
	 * @param k
	 *            ���ҵ�����
	 * @return ���ҵ��򷵻�Ԫ�����������<i>�±�</i>����û���ҵ��򷵻ز��ҵ�Ԫ��������<i>�ɲ����λ�õĸ���</i>
	 */
	public static int halfSearch(int[] a, int k) {
		checkArray(a);
		int min, max, mid;
		min = 0;
		max = a.length - 1;

		do {
			mid = (max + min) >>> 1;

			if (k < a[mid])
				max = mid - 1;
			else if (k > a[mid])
				min = mid + 1;
			else if (k == a[mid])
				return mid;

		} while (min <= max);
		return -1 - min;
	}
}
