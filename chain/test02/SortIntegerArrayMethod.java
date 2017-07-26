package com.chain.part1.tool00.utils;

/**
 * 
 * һЩ�����������㷨������<i>��������ѡ������ð������ϣ�����򣬿������򣬽���Ԫ��</i>
 * 
 * @version 20170108
 * @author Chain
 *
 */
public class SortIntegerArrayMethod {

	public static void main(String[] args) {
		int a[] = RandomIntegerArrayMethod.randomSelectArray(0, 9, 10);
		TestMethod.print(a);

		int b[] = a.clone();
		swap(b, 3, 6);
		TestMethod.print(b);
		swap2(b, 1, 4);
		TestMethod.print(b);
		swap3(b, 5, 2);
		TestMethod.print(b);

		int c1[] = a.clone();
		insertSort(c1);
		TestMethod.print(c1);

		int c2[] = a.clone();
		bubbleSort(c2);
		TestMethod.print(c2);

		int c3[] = a.clone();
		selectSort(c3);
		TestMethod.print(c3);

		int c4[] = a.clone();
		shellSort(c4);
		TestMethod.print(c4);

		int c5[] = a.clone();
		quickSort(c5);
		TestMethod.print(c5);

		// other test
		int d[] = { 2, 4, 5, 6, 2, 0, 2 };
		int d1[] = d.clone();
		insertSort(d1);
		TestMethod.print(d1);

		int d2[] = d.clone();
		bubbleSort(d2);
		TestMethod.print(d2);

		int d3[] = d.clone();
		selectSort(d3);
		TestMethod.print(d3);

		int d4[] = d.clone();
		shellSort(d4);
		TestMethod.print(d4);

		int d5[] = d.clone();
		quickSort(d5);
		TestMethod.print(d5);

		// insertSort(null);
	}

	/**
	 * ���ʽ����Ԫ�أ�û���м����������������ֵ����
	 * 
	 * @param n
	 *            Ҫ����Ԫ�ص�����
	 * @param i
	 *            ��һ������Ԫ�ص������±�
	 * @param j
	 *            �ڶ�������Ԫ�ص�����С��
	 */
	public static void swap(int[] n, int i, int j) {
		checkSwapArgs(n, i, j);
		n[i] ^= n[j];
		n[j] ^= n[i];
		n[i] ^= n[j];
	}

	/**
	 * 
	 * �Ӽ���ʽ����Ԫ�أ�ע����ܴ�������������ͷ���λ����
	 * 
	 * @param n
	 *            Ҫ����Ԫ�ص�����
	 * @param i
	 *            ��һ������Ԫ�ص������±�
	 * @param j
	 *            �ڶ�������Ԫ�ص�����С��
	 */
	private static void swap2(int[] n, int i, int j) {
		checkSwapArgs(n, i, j);
		n[i] = n[i] + n[j];
		n[j] = n[i] - n[j];
		n[i] = n[i] - n[j];
	}

	/**
	 * 
	 * �м�������������򵥣�����������ڴ濪��������������С
	 * 
	 * @param n
	 *            Ҫ����Ԫ�ص�����
	 * @param i
	 *            ��һ������Ԫ�ص������±�
	 * @param j
	 *            �ڶ�������Ԫ�ص�����С��
	 */
	private static void swap3(int[] n, int i, int j) {
		checkSwapArgs(n, i, j);
		int t = n[i];
		n[i] = n[j];
		n[j] = t;
	}

	private static void checkSwapArgs(int[] n, int i, int j) {
		if (i < 0 || j > n.length - 1)
			throw new RuntimeException("index is illegal");
	}

	private static void checkArray(int[] a) {
		if (a == null || a.length < 1)
			throw new RuntimeException("array is null or empty");
	}

	/**
	 * ð���������ڱȽϣ�ÿ�ν���δ���������������Ԫ���ƶ���ĩβ
	 * 
	 * @param a
	 *            Ҫ���������
	 */
	public static void bubbleSort(int[] a) {
		// TODO Auto-generated method stub
		checkArray(a);
		int n = a.length;
		boolean flag = false;// false����û���ź���
		for (int i = 0; i < n - 1 && !flag; i++) {
			flag = true;
			for (int j = 0; j < n - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					flag = false;
					swap(a, j, j + 1);
				}
			}
		}
	}

	/**
	 * ѡ������ÿ�δ�ʣ����δ�����������ѡ��һ����С�Ľ���������Ĳ��ֺ���
	 * 
	 * @param a
	 *            Ҫ���������
	 */
	public static void selectSort(int[] a) {
		// TODO Auto-generated method stub
		checkArray(a);
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++)
				if (a[j] < a[min])
					min = j;
			if (min != i)
				swap(a, i, min);
		}
	}

	/**
	 * ��������ÿ��ȡ��δ��������еĵ�һ��Ԫ�ز��뵽ǰ�����еĺ���λ��
	 * 
	 * @param a
	 *            Ҫ���������
	 */
	public static void insertSort(int[] a) {
		// TODO Auto-generated method stub
		checkArray(a);
		int n = a.length;
		for (int i = 1; i < n; i++) {
			// ����һ�����ƽ����ð������
			// method3a(a, i);

			// ���������м����
			// method3b(a, i);

			// ���������м����2
			method3c(a, i);

		}
	}

	private static void method3c(int[] a, int i) {
		int t = a[i];
		int j = i - 1;
		for (; j > -1 && a[j] > t; j--)
			a[j + 1] = a[j];
		a[j + 1] = t;
	}

	@SuppressWarnings("unused")
	private static void method3b(int[] a, int i) {
		int t = a[i];
		int j = i;
		for (; j > 0 && a[j] > t; j--)
			a[j] = a[j - 1];
		a[j] = t;
	}

	@SuppressWarnings("unused")
	private static void method3a(int[] a, int i) {
		for (int j = i - 1; j > -1; j--)
			if (a[i] < a[j])
				swap(a, i, j);
	}

	/**
	 * ϣ�������趨һ��gap�������п�ͷ��ʼ��ÿ��һ��gapȡһ������Ȼ���ȡ����������(����������)��ÿ�� ѭ����gap��Сһ�룬����ϸ����
	 * 
	 * @param a
	 *            Ҫ���������
	 */
	public static void shellSort(int[] a) {
		// TODO Auto-generated method stub
		checkArray(a);
		int n = a.length;
		for (int gap = n; gap > 0; gap >>= 1) {
			// ð������
			// method4a(n, a, gap);

			// ѡ������
			// method4b(n, a, gap);

			// ��������
			method4c(n, a, gap);

		}
	}

	private static void method4c(int n, int[] a, int gap) {
		for (int i = gap; i < n; i += gap) {
			int t = a[i];
			int j = i - gap;
			for (; j > -gap && a[j] > t; j -= gap)
				a[j + gap] = a[j];
			a[j + gap] = t;
		}
	}

	@SuppressWarnings("unused")
	private static void method4b(int n, int[] a, int gap) {
		for (int i = gap; i < n - gap; i += gap) {
			int min = i;
			for (int j = i + gap; j < n; j += gap)
				if (a[j] < a[min])
					min = j;
			if (min != i)
				swap(a, i, min);
		}
	}

	@SuppressWarnings("unused")
	private static void method4a(int n, int[] a, int gap) {
		boolean flag = false;
		for (int i = 0; i < n - gap && !flag; i += gap) {
			flag = true;
			for (int j = 0; j < n - gap - i; j += gap) {
				if (a[j] > a[j + gap])
					swap(a, j, j + gap);
				flag = false;
			}
		}
	}

	/**
	 * ��������ѡ��һ������Ϊ��׼(һ���ǵ�һ����),Ȼ��֮��������б������׼��С����������ߣ���������������ұߡ����Ž���׼�����ڡ��м䡱��ͨ���ݹ�ֱ��ٴ�����ߺ��ұߡ�
	 * 
	 * @param a
	 *            Ҫ���������
	 */
	public static void quickSort(int[] a) {
		// TODO Auto-generated method stub
		checkArray(a);
		int n = a.length;
		int le = 0;
		int ri = n - 1;
		quickFun(a, le, ri);
	}

	private static void quickFun(int[] a, int le, int ri) {

		if (le < 0 || ri > a.length - 1 || le >= ri)
			return;

		int i = le;
		int j = ri;
		int base = a[le];
		while (i < j) {
			while (a[j] > base && i < j)
				j--;
			if (i < j) {
				a[i] = a[j];
				i++;
			}
			while (a[i] < base && i < j)
				i++;
			if (i < j) {
				a[j] = a[i];
				j--;
			}
		}
		a[i] = base;

		quickFun(a, le, i - 1);
		quickFun(a, i + 1, ri);

	}

}
