package com.lanqiao.match.province;

import java.util.Scanner;
import java.util.TreeSet;

/*
 7����������

С����������һ����ʷ���ס���Щ��ʷ�����г����˺ܶ����ڡ�С��֪����Щ���ڶ���1960��1��1����2059��12��31�ա�
��С��ͷ�۵��ǣ���Щ���ڲ��õĸ�ʽ�ǳ���ͳһ���в�����/��/�յģ��в�����/��/��ģ����в�����/��/��ġ�
�����鷳���ǣ����Ҳ��ʡ����ǰ��λ��ʹ�������ϵ�һ�����ڣ����ںܶ���ܵ����������Ӧ��  

����02/03/04��������2002��03��04�ա�2004��02��03�ջ�2004��03��02�ա�  

����һ�������ϵ����ڣ����ܰ���С���ж�����Щ���ܵ����ڶ����Ӧ��

����
----
һ�����ڣ���ʽ��"AA/BB/CC"��  (0 <= A, B, C <= 9)  

���
----
������ɸ�����ͬ�����ڣ�ÿ������һ�У���ʽ��"yyyy-MM-dd"��������ڰ����絽�����С�  

��������
----
02/03/04  

�������
----
2002-03-04  
2004-02-03  
2004-03-02  

��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�

������ֻ�����������ö�ټ��ɡ����ж����ꡢ�·����ڡ������60����
 */
public class Main07 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();

		int[][] dat = new int[3][3];
		int[][] pro = new int[3][3];

		String[] sp = s.split("/");

		make(dat, sp);

		boolean[] ck = new boolean[3];
		ck[0] = judge1(dat[0], pro[0]);
		ck[1] = judge2(dat[1], pro[1]);
		ck[2] = judge3(dat[2], pro[2]);

		print(pro, ck);
	}

	// ��/��/��
	private static boolean judge3(int[] is, int[] pro) {
		pro[0] = is[2];
		pro[1] = is[1];
		pro[2] = is[0];

		return judge(pro);
	}

	// ��/��/��
	private static boolean judge2(int[] is, int[] pro) {
		pro[0] = is[2];
		pro[1] = is[0];
		pro[2] = is[1];

		return judge(pro);
	}

	// ��/��/��
	private static boolean judge1(int[] is, int[] pro) {
		pro[0] = is[0];
		pro[1] = is[1];
		pro[2] = is[2];

		return judge(pro);
	}

	private static boolean judge(int[] pro) {
		int year = pro[0];
		int month = pro[1];
		int day = pro[2];
		year = getYear(year);
		pro[0] = year;
		if (checkMonth(month) && checkDay(year, month, day))
			return true;
		return false;
	}

	// �������
	private static boolean checkYear(int y) {
		if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
			return true;
		return false;
	}

	// ȷ���������
	private static int getYear(int y) {
		if (y > 59 && y < 100)
			y = 1900 + y;
		else if (y > -1 && y < 60)
			y = 2000 + y;
		return y;
	}

	// ����·�
	private static boolean checkMonth(int m) {
		if (m > -1 && m < 13)
			return true;
		return false;
	}

	// �������
	private static boolean checkDay(int y, int m, int d) {
		boolean isDay = false;
		if (d < 0 || d > 31)
			return isDay;

		switch (m) {
		// 31��
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (d <= 31)
				isDay = true;
			break;
		// 30��
		case 4:
		case 6:
		case 9:
		case 11:
			if (d <= 30)
				isDay = true;
			break;
		// �����ж�28/29��
		case 2:
			boolean isLeap = checkYear(y);
			if ((isLeap && d <= 29) || (!isLeap && d <= 28))
				isDay = true;
			break;
		}
		return isDay;
	}

	private static void print(int[][] dat, boolean[] ck) {
		int row = dat.length;
		int col = dat[0].length;
		TreeSet<String> set = new TreeSet<>();
		for (int i = 0; i < row; i++) {
			if (!ck[i])
				continue;
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < col; j++) {
				if (dat[i][j] < 10)
					sb.append(0);
				sb.append(dat[i][j]);
				if (j < col - 1)
					sb.append("-");
			}
			set.add(sb.toString());
		}
		for (String s : set)
			System.out.println(s);
	}

	private static void make(int[][] dat, String[] sp) {
		int row = dat.length;

		int y = new Integer(sp[0]);
		int m = new Integer(sp[1]);
		int d = new Integer(sp[2]);

		for (int i = 0; i < row; i++) {
			dat[i][0] = y;
			dat[i][1] = m;
			dat[i][2] = d;
		}
	}

}
