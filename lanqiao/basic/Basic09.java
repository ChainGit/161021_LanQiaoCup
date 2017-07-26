package com.lanqiao.basic;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * ������ϰ ���������
 * 
 * �ܽ᣺������ ѭ�� ������� ����ѭ������ѧ���ʽʱҪע������
 * �Ż�ע������ȶ��ԣ����缰ʱ�ر���Դ�����Ͻ��ԣ��������Ϊfinal������������ͱ�����������������������ӡ�����뿪����
 * 
 * @author Lenovo
 *
 */
public class Basic09 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		method1(n);
		System.out.println();
		method2(n);
		System.out.println();
		method3(n);
		System.out.println();
		method4(n);
		System.out.println();
		method5(n);

		// test();

	}

	public static void test() {
		for (int n = 1; n < 55; n++) {
			method1(n);
			System.out.println();
			method2(n);
			System.out.println();
			method3(n);
			System.out.println();
			method4(n);
			System.out.println();
			method5(n);
		}
	}

	// ѭ����1000�Σ�ʹ����һ�����ϣ��ֲ��������塣
	public static void method1(final int n) {
		Set<Integer> set = new TreeSet<>();
		for (int a = 1; a < 10; a++) {// �����ǻ���������a!=0
			for (int b = 0; b < 10; b++)
				for (int c = 0; c < 10; c++) {
					int p = (a << 1) + (b << 1) + c;
					if (n != p && n != p + c)
						continue;
					int base = a * 10000 + b * 1000 + c * 100;
					int t1 = base + b * 10 + a;
					if (n == p)
						set.add(t1);
					// else if (n == p + c)//���10001��100001�����Ǵ����ظ���Ӻ��ظ��ж�����
					if (n == p + c)
						set.add(t1 + base * 9 + c * 100);
				}
		}
		for (int i : set)
			System.out.println(i);
	}

	// ѭ��2000��,�ֲ���������
	public static void method2(final int n) {
		// ��ӡ5λ��
		for (int a = 1; a < 10; a++) {
			for (int b = 0; b < 10; b++)
				for (int c = 0; c < 10; c++) {
					if (n != (a << 1) + (b << 1) + c)
						continue;
					System.out.println(a * 10001 + b * 1010 + c * 100);
				}
		}
		// ��ӡ6λ��
		for (int a = 1; a < 10; a++) {
			for (int b = 0; b < 10; b++)
				for (int c = 0; c < 10; c++) {
					if (n != (a << 1) + (b << 1) + (c << 1))
						continue;
					System.out.println(a * 100001 + b * 10010 + c * 1100);
				}
		}

	}

	// ������С����ѭ����990000��ͬʱ��������
	public static void method3(final int n) {
		for (int i = 10000; i < 1000000; i++)
			if (i < 100000) {
				int a = i / 10000;
				int b = i / 1000 % 10;
				int c = i / 100 % 10;
				int d = i / 10 % 10;
				int e = i % 10;
				// System.out.printf("%d %d %d %d %d\n", a, b, c, d, e);
				if (a == e && b == d && n == a + b + c + d + e)
					System.out.println(i);
			} else {
				int a = i / 100000;
				int b = i / 10000 % 10;
				int c = i / 1000 % 10;
				int d = i / 100 % 10;
				int e = i / 10 % 10;
				int f = i % 10;
				// System.out.printf("%d %d %d %d %d %d\n", a, b, c, d, e, f);
				if (a == f && b == e && c == d && n == a + b + c + d + e + f)
					System.out.println(i);
			}
	}

	// ��Ȼ����Java��API������ѭ�������࣬����ת��Ƶ�����Ƚϻ�������ֵ��
	public static void method4(final int n) {
		for (int i = 10000; i < 1000000; i++) {
			String s = new String(i + "");
			StringBuilder sb = new StringBuilder(s);
			int[] a = changeCharToIntArray(s.toCharArray());
			int sum = 0;
			for (int x : a)
				sum += x;
			if (s.equals(sb.reverse().toString()) && sum == n)
				System.out.println(i);
		}

	}

	public static int[] changeCharToIntArray(char[] c) {
		int[] a = new int[c.length];
		for (int i = 0; i < c.length; i++)
			a[i] = (int) (c[i] - 48);
		return a;
	}

	// ʹ��JavaAPI�ĸĽ��汾����ȻЧ�ʵ�
	public static void method5(final int n) {
		for (int i = 10000; i < 1000000; i++) {
			String s = new String(i + "");
			int[] a = new int[s.length()];
			int[] b = new int[s.length()];
			int sum = 0;
			for (int x = 0; x < a.length; x++) {
				a[x] = s.charAt(x) - 48;
				b[a.length - 1 - x] = a[x];
				sum += a[x];
			}
			boolean isOk = true;
			for (int x = 0; x < a.length; x++)
				if (a[x] != b[x]) {
					isOk = false;
					break;
				}
			if (isOk && sum == n)
				System.out.println(i);
		}
	}
}
