package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * �������� ����Ʊ��
 * 
 * �ܽ᣺����
 * 
 * @author Chain
 *
 */
@SuppressWarnings("unused")
public class Prev05 {

	private static int same = -1;
	private static int miss = -1;

	// һ������һ���ж�,�ʺϲ��롢ѡ��ð������
	public static void main(String[] args) {
		// ʹ��ArrayList��Collections.sort����
		method1();

		// ������Զ�������
		// method2();
	}

	private static void method2() {
		BufferedReader bufr = null;
		try {
			bufr = new BufferedReader(new InputStreamReader(System.in));
			int[] arrn = new int[1];
			myParseIntArr(bufr, arrn, 0);
			int n = arrn[0];
			int[] dat = new int[n * 100];
			int row = 0;
			int num = 0;
			while (row++ < n)
				num = myParseIntArr(bufr, dat, num);
			bufr.close();

			for (int i = 0; i < dat.length; i++)
				if (dat[i] != 0)
					System.out.print(dat[i] + " ");
			System.out.println();

			// ѡ������
			mySort1(dat);
			// ��������
			// mySort2(dat);
			// ð������
			// mySort3(dat);

			for (int i = 0; i < dat.length; i++)
				if (dat[i] != 0)
					System.out.print(dat[i] + " ");
			System.out.println();

			// ������ͷβ,��������һ���жϺź��غ�,�ҶϺ�������ֻ���1
			for (int i = getZeroPos(dat) + 1; i < dat.length - 1; i++) {
				int before = dat[i - 1];
				int now = dat[i];
				if (before + 1 != now)
					if (before == now)
						same = now;
					else
						miss = now - 1;
			}

			if (miss != -1)
				System.out.print(miss + " ");
			if (same != -1)
				System.out.print(same);
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufr != null)
					bufr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Ʊ��ID��������,������ֵΪ0�����
	private static int getZeroPos(int[] dat) {
		for (int i = 0; i < dat.length; i++)
			if (dat[i] != 0)
				return i;
		return 0;
	}

	// ð������
	private static void mySort3(int[] dat) {
		boolean isSort = false;
		for (int i = 0; i < dat.length - 1 && !isSort; i++) {
			isSort = true;
			for (int j = 1; j < dat.length; j++)
				if (dat[j - 1] > dat[j]) {
					swap(dat, j - 1, j);
					isSort = false;
				}
		}
	}

	// ��������
	private static void mySort2(int[] dat) {
		for (int i = 1; i < dat.length; i++) {
			int tmp = dat[i];
			int j = 0;
			for (; j < i; j++)
				if (dat[j] > tmp)
					break;
			for (int k = i; k > j; k--)
				dat[k] = dat[k - 1];
			dat[j] = tmp;
		}
	}

	// ѡ������
	private static void mySort1(int[] dat) {
		for (int i = 0; i < dat.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < dat.length; j++)
				if (dat[min] > dat[j])
					min = j;
			if (min != i)
				swap(dat, min, i);
		}
	}

	// ת���ַ���Ϊ����
	private static int myParseIntArr(BufferedReader bufr, int a[], int pos) throws Exception {
		int ch = -1;
		int tmp = 0;
		boolean onlyOneBlankSpace = true;
		while ((ch = bufr.read()) != -1) {
			if (ch == '\r')
				continue;
			else if (ch == '\n') {
				a[pos] = tmp;
				pos++;
				break;
			} else if (ch == ' ' && onlyOneBlankSpace) {
				a[pos] = tmp;
				tmp = 0;
				pos++;
				onlyOneBlankSpace = false;
			} else {
				tmp = tmp * 10 + ch - 48;
				onlyOneBlankSpace = true;
			}
		}
		return pos;
	}

	// ��Ϊ������,����ʹ����򷨡���ʱ���������Ӽ���
	private static void swap(int a[], int i, int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}

	// ����JavaAPI���÷�100,<200ms
	private static void method1() {
		BufferedReader bufr = null;
		try {
			bufr = new BufferedReader(new InputStreamReader(System.in));
			String buf = bufr.readLine();
			int n = Integer.parseInt(buf);
			ArrayList<Integer> lst = new ArrayList<>(n * 100);
			int tm = 0;
			while (tm++ < n && (buf = bufr.readLine()) != null) {
				String[] tmp = buf.split(" ");
				for (String s : tmp)
					if (!s.equals(" "))
						lst.add(Integer.parseInt(s));
			}
			// ʹ�� bufrΪ null
			bufr.close();

			// JavaAPI����
			Collections.sort(lst);

			// ������ͷβ,��������һ���жϺź��غ�,�ҶϺ�������ֻ���1
			for (int i = 1; i < lst.size() - 1; i++) {
				int before = lst.get(i - 1);
				int now = lst.get(i);
				if (before + 1 != now)
					if (before == now)
						same = now;
					else
						miss = now - 1;
			}

			if (miss != -1)
				System.out.print(miss + " ");
			if (same != -1)
				System.out.print(same);
			System.out.println();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufr != null)
					bufr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
