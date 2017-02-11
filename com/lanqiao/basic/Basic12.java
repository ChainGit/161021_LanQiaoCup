package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ ʮ������ת�˽���
 * 
 * �ܽ᣺����ת�� �ַ� ѭ��
 * 
 * @author Lenovo
 *
 */
public class Basic12 {

	private static final String[] hex = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000",
			"1001", "1010", "1011", "1100", "1101", "1110", "1111", };

	// private static final String[] oct = { "000", "001", "010", "011", "100",
	// "101", "110", "111", };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// getHexAndOct();

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i = 0;
		String[] strs = new String[n];
		while (i < n && in.hasNext())
			strs[i++] = in.next();
		in.close();

		// method1(n, strs);
		// method2(n, strs);
		method3(n, strs);
	}

	// ��ת��Ϊ�����ƣ���ת��������StringBuilder
	public static void method3(final int n, final String[] strs) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < n) {
			char chs[] = strs[i].toCharArray();

			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < chs.length; j++) {
				if (chs[j] > 47 && chs[j] < 58)
					sb.append(hex[chs[j] - 48]);
				else if (chs[j] > 64 && chs[j] < 71)
					sb.append(hex[chs[j] - 55]);
			}

			while (sb.length() % 3 != 0)
				sb.insert(0, '0');

			char[] nchs = new char[3];
			sb.getChars(0, 3, nchs, 0);
			if (nchs[0] == 48 && nchs[1] == 48 && nchs[2] == 48)
				sb.delete(0, 3);

			for (int j = 0; j < sb.length(); j += 3) {
				// ����һ��ֱ��ת��
				sb.getChars(j, j + 3, nchs, 0);
				int a = nchs[0] - 48;
				int b = nchs[1] - 48;
				int c = nchs[2] - 48;
				System.out.print((a == 0 ? 0 : 4) + (b == 0 ? 0 : 2) + (c == 0 ? 0 : 1));

				// ��������ʹ������ת��
				// sb.getChars(j, j + 3, nchs, 0);
				// String st = new String(nchs);
				// for (int k = 0; k < oct.length; k++)
				// if (oct[k].equals(st)) {
				// System.out.print(k);
				// break;
				// }

				// ��������ʹ��APIת��
				// System.out.print(Integer.toOctalString(Integer.parseInt(new
				// String(nchs), 8)));
			}
			System.out.println();

			i++;
		}
	}

	public static void getHexAndOct() {
		for (int i = 0; i < 16; i++) {
			String s = Integer.toBinaryString(i);
			while (s.length() < 4)
				s = "0" + s;
			System.out.print("\"" + s + "\",");
		}
		System.out.println();

		for (int i = 0; i < 8; i++) {
			String s = Integer.toBinaryString(i);
			while (s.length() < 3)
				s = "0" + s;
			System.out.print("\"" + s + "\",");
		}
		System.out.println();
	}

	// ����������Ϊ16����תΪ8���ƣ�ֱ�ӵ���ת4->2*3�Ǵ����
	public static void method2(final int n, final String[] strs) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < n) {
			char[] chs = strs[i].toCharArray();
			for (int j = 0; j < chs.length; j++)
				System.out.print(Integer.toOctalString(Integer.parseInt(chs[j] + "", 16)));// ������̫���String����
			i++;
			System.out.println();
		}
	}

	// ������������ݳ��ȴﵽ100000��ԶԶ����long�ĳ��ȣ����д���
	public static void method1(final int n, final String[] strs) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < n)
			System.out.println(Long.toOctalString(Long.parseLong(strs[i++], 16)));
	}

}
