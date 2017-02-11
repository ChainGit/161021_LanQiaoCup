package com.lanqiao.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ������ϰ ���Ķ���
 * 
 * �������� <br>
 * Tom�������ڸ��о�������һ�Ź��ڻ���Ŀγ̣���һ������������Ϊͷ�ۣ�һ��Ⱦ <br>
 * ɫ�����г�ǧ���������ԣ����Ǵ�0��ʼ��ţ��������򣬼�ǧ���������ڡ� <br>
 * ����˵���ڶ�ѧ�������1234567009��λ���ϵļ��ʱ���⿴�������Ǻ���׼ȷ���� <br>
 * �����ġ� <br>
 * ���ԣ������е���Ҫһ��ϵͳ��Ȼ��������12 3456 7009ʱ���������Ӧ����� <br>
 * ʮ������ǧ�İ���ʮ������ǧ��� <br>
 * �ú���ƴ����ʾΪ <br>
 * shi er yi san qian si bai wu shi liu wan qi qian ling jiu <br>
 * ������ֻ��Ҫ������Ϳ����ˡ� <br>
 * ��������ǰ����������һ��ϵͳ������һ�����������ִ���������������Ķ�д�� <br>
 * �淶תΪ����ƴ���ִ������ڵ�����������һ���ո���񿪡� <br>
 * ע������ϸ��չ淶������˵��10010��������yi wan ling yi shi�������ǡ�yi wan <br>
 * ling shi������100000��������shi wan�������ǡ�yi shi wan������2000��������er qian���� <br>
 * ���ǡ�liang qian���� <br>
 * �����ʽ <br>
 * ��һ�����ִ�����ֵ��С������2,0 00,00 0,000�� <br>
 * �����ʽ <br>
 * ��һ����СдӢ����ĸ�����źͿո���ɵ��ַ�������ʾ������Ӣ�Ķ����� <br>
 * �������� <br>
 * 1234567009 <br>
 * ������� <br>
 * shi er yi san qian si bai wu shi liu wan qi qian ling jiu <br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ�: �ж� ����
 * 
 * @author Chain
 *
 */
public class Basic20 {

	private static final String[] xxpy = new String[] { "ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba",
			"jiu" };

	private static final String[] xxhz = new String[] { "��", "һ", "��", "��", "��", "��", "��", "��", "��", "��" };

	private static final String[] dxsz = new String[] { "��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��" };

	private static final String[] xxpydw = { "", "shi", "bai", "qian", "", "wan", "yi" };// ge��""

	private static final String[] xxhzdw = { "", "ʮ", "��", "ǧ", "", "��", "��" };// ��λ��""

	private static final String[] dxhzdw = { "", "ʰ", "��", "Ǫ", "", "��", "��" };// 10,11,12,13,14,15,16

	private static String[] nums = null;
	private static String[] units = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();

		char[] arr = s.toCharArray();

		arr = preProcess(arr);
		if (arr == null)
			return;

		LinkedList<Byte> dlst = change(arr);

		nums = xxpy;
		units = xxpydw;
		print(dlst);

		nums = xxhz;
		units = xxhzdw;
		print(dlst);

		nums = dxsz;
		units = dxhzdw;
		print(dlst);
	}

	private static char[] preProcess(char[] arr) {
		// �жϳ���
		int len = arr.length;
		if (len > 12) {
			System.out.println("�������,���֧��12λ!");
			return null;
		}

		// �ж��Ƿ�������
		for (int i = 0; i < len; i++)
			if (arr[i] < 48 || arr[i] > 57) {
				System.out.println("�������������!");
				return null;
			}

		// ȥ����ͷ����
		boolean isZeroStart = arr[0] == 48 ? true : false;
		int m = 0;
		for (; isZeroStart && m < len; m++) {
			if (arr[m] == 48)
				continue;
			else
				break;
		}

		// ��������������
		arr = Arrays.copyOfRange(arr, m, len);
		len -= m;

		// ��ӡ����Ԥ����������ֵ
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
			if (i < len - 1 && (len - i - 1) % 4 == 0)
				System.out.print(",");
		}
		System.out.println();
		return arr;
	}

	private static LinkedList<Byte> change(char[] arr) {
		// ��������ֵת��Ϊ�м�����
		LinkedList<Byte> dlst = new LinkedList<>();
		int last = arr.length - 1;
		for (int i = last; i > -1; i--) {
			int p = last - i;
			if (p % 4 == 0)
				dlst.add((byte) (14 + p / 4));
			int tmp = arr[i] - 48;
			if (tmp != 0)
				dlst.add((byte) (10 + p % 4));
			// �������������
			dlst.add((byte) tmp);
		}

		Collections.reverse(dlst);

		// ȥ��"10"����ʮ����һʮ
		if (dlst.get(0) == 1 && dlst.get(1) == 11)
			dlst.remove(0);

		// �������0�ȱ��-1
		for (int i = 0; i < dlst.size(); i++)
			if (dlst.get(i) == 0) {
				int j = i + 1;
				for (; j < dlst.size() && dlst.get(j) == 0; j++)
					dlst.set(j, (byte) -1);
				if (dlst.get(j) > 13)
					dlst.set(i, (byte) -1);
				i = j;
			}

		// ɾ�����е�-1
		int len = dlst.size();
		boolean isClear = false;
		while (!isClear) {
			isClear = true;
			for (int i = 0; i < len; i++)
				if (dlst.get(i) == -1) {
					dlst.remove(i);
					isClear = false;
					len--;
				}
		}

		// ɾ��û�������""
		len = dlst.size();
		isClear = false;
		while (!isClear) {
			isClear = true;
			for (int i = 0; i < len; i++) {
				int b = dlst.get(i);
				if (b == 10 || b == 14) {
					isClear = false;
					dlst.remove(i);
					len--;
				}
			}
		}

		// ɾ����������һ��
		len = dlst.size();
		for (int i = 0; i < len; i++)
			if (dlst.get(i) == 16 && dlst.get(i + 1) == 15) {
				dlst.remove(i + 1);
				break;
			}

		// ɾ������ͷ
		if (dlst.get(0) == 16 || dlst.get(0) == 15)
			dlst.remove(0);

		// System.out.println(dlst);

		return dlst;
	}

	private static void print(LinkedList<Byte> arr) {
		int last = arr.size() - 1;
		for (int i = 0; i < last; i++) {
			int da = arr.get(i);
			if (da == 10 || da == 14 || da == -1)
				continue;
			else if (da < 10)
				System.out.print(nums[da]);
			else
				System.out.print(units[da - 10]);
			if (da != 10 || da != 14)
				System.out.print(" ");
		}

		int tmp = arr.get(last);
		if (tmp == 10 || tmp == 14 || tmp == -1)
			System.out.println();
		else if (tmp < 10)
			System.out.println(nums[tmp]);
		else
			System.out.println(units[tmp - 10]);
	}
}
