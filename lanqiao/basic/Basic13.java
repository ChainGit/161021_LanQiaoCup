package com.lanqiao.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * ������ϰ ��������
 * 
 * �ܽ᣺���� ����
 * 
 * @author Lenovo
 *
 */
public class Basic13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test1();
		// test2();
		test3();
	}

	public static void test3() {
		int len = (int) (Math.random() * (0 + 10) + 0);
		int[] a = new int[len];
		for (int i = 0; i < len; i++) {
			a[i] = (int) (Math.random() * (0 + 9) + 0);
		}
		print(a);

		method1(len, a);
		method2(len, a);
		method3(len, a);
		method4(len, a);
		method5(len, a);

	}

	public static void test2() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> lst = new ArrayList<>();
		int i = 0;
		while (i++ < n)
			lst.add(in.nextInt());
		in.close();

		Collections.sort(lst);
		for (int m = 0; m < n - 1; m++)
			System.out.print(lst.get(m) + " ");
		System.out.println(lst.get(n - 1));
	}

	public static void test1() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while (i < n)
			arr[i++] = in.nextInt();
		in.close();

		print(arr);

		method1(n, arr);
		method2(n, arr);
		method3(n, arr);
		method4(n, arr);
		method5(n, arr);
	}

	public static void swap(int[] n, int i, int j) {
		n[i] ^= n[j];
		n[j] ^= n[i];
		n[i] ^= n[j];
	}

	public static void print(int[] a) {
		for (int i : a)
			System.out.print(i);
		System.out.println();
	}

	// ð���������ڱȽϣ�ÿ�ν���δ���������������Ԫ���ƶ���ĩβ
	public static void method1(int n, int[] a) {
		// TODO Auto-generated method stub
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
		print(a);
	}

	// ѡ������ÿ�δ�ʣ����δ�����������ѡ��һ����С�Ľ���������Ĳ��ֺ���
	public static void method2(int n, int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++)
				if (a[j] < a[min])
					min = j;
			if (min != i)
				swap(a, i, min);
		}
		print(a);
	}

	// ��������ÿ��ȡ��δ��������еĵ�һ��Ԫ�ز��뵽ǰ�����еĺ���λ��
	public static void method3(int n, int[] a) {
		// TODO Auto-generated method stub
		for (int i = 1; i < n; i++) {
			// ����һ�����ƽ����ð������
			// method3a(a, i);

			// ���������м����
			// method3b(a, i);

			// ���������м����2
			method3c(a, i);

		}
		print(a);
	}

	public static void method3c(int[] a, int i) {
		int t = a[i];
		int j = i - 1;
		for (; j > -1 && a[j] > t; j--)
			a[j + 1] = a[j];
		a[j + 1] = t;
	}

	public static void method3b(int[] a, int i) {
		int t = a[i];
		int j = i;
		for (; j > 0 && a[j] > t; j--)
			a[j] = a[j - 1];
		a[j] = t;
	}

	public static void method3a(int[] a, int i) {
		for (int j = i - 1; j > -1; j--)
			if (a[i] < a[j])
				swap(a, i, j);
	}

	// ϣ�������趨һ��gap�������п�ͷ��ʼ��ÿ��һ��gapȡһ������Ȼ���ȡ����������(����������)��ÿ�� ѭ����gap��Сһ�룬����ϸ����
	public static void method4(int n, int[] a) {
		// TODO Auto-generated method stub
		for (int gap = n; gap > 0; gap >>= 1) {
			// ð������
			// method4a(n, a, gap);

			// ѡ������
			// method4b(n, a, gap);

			// ��������
			method4c(n, a, gap);

		}
		print(a);
	}

	public static void method4c(int n, int[] a, int gap) {
		for (int i = gap; i < n; i += gap) {
			int t = a[i];
			int j = i - gap;
			for (; j > -gap && a[j] > t; j -= gap)
				a[j + gap] = a[j];
			a[j + gap] = t;
		}
	}

	public static void method4b(int n, int[] a, int gap) {
		for (int i = gap; i < n - gap; i += gap) {
			int min = i;
			for (int j = i + gap; j < n; j += gap)
				if (a[j] < a[min])
					min = j;
			if (min != i)
				swap(a, i, min);
		}
	}

	public static void method4a(int n, int[] a, int gap) {
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

	// ��������ѡ��һ������Ϊ��׼(һ���ǵ�һ����),Ȼ��֮��������б������׼��С����������ߣ���������������ұߡ����Ž���׼�����ڡ��м䡱��ͨ���ݹ�ֱ��ٴ�����ߺ��ұߡ�
	public static void method5(int n, int[] a) {
		// TODO Auto-generated method stub
		int le = 0;
		int ri = n - 1;
		quickSort(a, le, ri);
		print(a);
	}

	public static void quickSort(int[] a, int le, int ri) {

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

		quickSort(a, le, i - 1);
		quickSort(a, i + 1, ri);

	}

}
