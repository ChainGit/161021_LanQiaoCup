package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ �߾��ȼӷ�
 * 
 * ��������<br>
 * ������������a��b����������������ĺ͡�a��b��������100λ��<br>
 * �㷨����<br>
 * ����a��b���Ƚϴ����Բ���ֱ��ʹ�������еı�׼�����������洢�������������⣬һ��ʹ������������<br>
 * ����һ������A��A[0]���ڴ洢a�ĸ�λ��A[1]���ڴ洢a��ʮλ���������ơ�ͬ��������һ������B���洢b��<br>
 * ����c = a +
 * b��ʱ�����Ƚ�A[0]��B[0]��ӣ�����н�λ��������ѽ�λ�����͵�ʮλ��������r���Ѻ͵ĸ�λ������C[0]����C[0]����(A[0]+B[0])%10��<br>
 * Ȼ�����A[1]��B[1]��ӣ���ʱ��Ӧ����λ��������ֵrҲ����������C[1]Ӧ����A[1]��B[1]��r�������ĺͣ�������н�λ������<br>
 * ���Կɽ��µĽ�λ���뵽r�У��͵ĸ�λ�浽C[1]�С��������ƣ��������C������λ��<br>
 * ���C������ɡ�<br>
 * �����ʽ<br>
 * ����������У���һ��Ϊһ���Ǹ�����a���ڶ���Ϊһ���Ǹ�����b������������������100λ�����������λ������0��<br>
 * �����ʽ<br>
 * ���һ�У���ʾa + b��ֵ��<br>
 * ��������<br>
 * 20100122201001221234567890<br>
 * 2010012220100122<br>
 * �������<br>
 * 20100122203011233454668012<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺���� �߾���
 * 
 * @author Chain
 *
 */
public class Basic29 {

	// ��ʵ���Ǽ�����ڲ��ӷ���ʵ��
	// ʮ����
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String sa = in.nextLine();
		String sb = in.nextLine();
		in.close();

		char[] ca = sa.toCharArray();
		char[] cb = sb.toCharArray();

		int lena = ca.length;
		int lenb = cb.length;

		int[] a = new int[lena];
		int[] b = new int[lenb];
		for (int i = 0; i < lena; i++)
			a[i] = ca[i] - 48;
		for (int i = 0; i < lenb; i++)
			b[i] = cb[i] - 48;

		int[] max = lena > lenb ? a : b;
		int[] min = lena > lenb ? b : a;

		int lemax = max.length;
		int lemin = min.length;
		int delta = lemax - lemin;

		System.out.print(' ');
		for (int i = 0; i < lemax; i++)
			System.out.print(max[i]);
		System.out.println();

		System.out.print('+');
		for (int i = 0; i < delta; i++)
			System.out.print(' ');
		for (int i = 0; i < lemin; i++)
			System.out.print(min[i]);
		System.out.println();

		int r = 0;
		int t = -1;
		int[] c = new int[lemax];
		for (int i = lemax - 1; i > -1; i--) {
			if (i >= delta)
				t = min[i - delta] + max[i] + r;
			else
				t = max[i] + r;
			c[i] = t % 10;
			r = t / 10;
		}

		for (int i = 0; i < lemax + 1; i++)
			System.out.print('-');
		System.out.println();

		if (r != 0)
			System.out.print(r);
		else
			System.out.print(' ');
		for (int i = 0; i < c.length; i++)
			System.out.print(c[i]);
		System.out.println();

	}

}
