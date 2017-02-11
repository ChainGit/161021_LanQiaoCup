package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 历届试题 错误票据
 * 
 * 总结：排序
 * 
 * @author Chain
 *
 */
@SuppressWarnings("unused")
public class Prev05 {

	private static int same = -1;
	private static int miss = -1;

	// 一边排序一边判断,适合插入、选择、冒泡排序法
	public static void main(String[] args) {
		// 使用ArrayList和Collections.sort操作
		method1();

		// 数组和自定义排序
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

			// 选择排序
			mySort1(dat);
			// 插入排序
			// mySort2(dat);
			// 冒泡排序
			// mySort3(dat);

			for (int i = 0; i < dat.length; i++)
				if (dat[i] != 0)
					System.out.print(dat[i] + " ");
			System.out.println();

			// 不包含头尾,依据题意一定有断号和重号,且断号与相邻只相差1
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

	// 票据ID是正整数,故数组值为0代表空
	private static int getZeroPos(int[] dat) {
		for (int i = 0; i < dat.length; i++)
			if (dat[i] != 0)
				return i;
		return 0;
	}

	// 冒泡排序
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

	// 插入排序
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

	// 选择排序
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

	// 转化字符串为整数
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

	// 因为是整数,可以使用异或法、临时变量法、加减法
	private static void swap(int a[], int i, int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}

	// 利用JavaAPI，得分100,<200ms
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
			// 使得 bufr为 null
			bufr.close();

			// JavaAPI排序
			Collections.sort(lst);

			// 不包含头尾,依据题意一定有断号和重号,且断号与相邻只相差1
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
