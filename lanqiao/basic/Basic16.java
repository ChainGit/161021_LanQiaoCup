package com.lanqiao.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ������ϰ �ֽ�������
 * 
 * ������prime number���ֳ������������޸���<br>
 * ��������Ϊ�ڴ���1����Ȼ���У�����1�����������ⲻ������������������Ϊ������<br>
 * 
 * �������[a,b]�������������������ֽ⡣<br>
 * �����ʽ<br>
 * ������������a��b��<br>
 * �����ʽ<br>
 * ÿ�����һ�����ķֽ⣬����k=a1*a2*a3...(a1<=a2<=a3...��kҲ�Ǵ�С�����)(����ɿ�����)<br>
 * ��������<br>
 * 3 10<br>
 * �������<br>
 * 3=3<br>
 * 4=2*2<br>
 * 5=5<br>
 * 6=2*3<br>
 * 7=7<br>
 * 8=2*2*2<br>
 * 9=3*3<br>
 * 10=2*5<br>
 * ��ʾ<br>
 * ��ɸ������������Ȼ���ٷֽ⡣<br>
 * ���ݹ�ģ��Լ��<br>
 * 2<=a<=b<=10000<br>
 * <br>
 * 
 * ������<br>
 * 1.���b��ǰ����������Ϊ���е�����������������ɵġ�<br>
 * 2.��������һ��������ô�Ͳ��ӡ�*����<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺�����ֽ� ѭ��<br>
 * 
 * @author Chain
 *
 */
public class Basic16 {

	// �ֽ�������ֻ��Ժ���
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		in.close();

		final int data[] = getAllPrimeNums(b);
		printPrimeNums(data);

		test1(a, b);
		System.out.println();
		test2(data, a, b);
	}

	private static void test2(int[] data, int a, int b) {
		for (int i = a; i <= b; i++) {
			// ���д���1�������ܱ������ֽ�
			System.out.print(i + "=");
			int tmp = i;
			int p = 0;
			// �����������˻��ֽ���Ψһ��?
			while (tmp > 0) {
				if (tmp % data[p] == 0) {
					System.out.print(data[p]);
					tmp /= data[p];
					if (tmp > 1) {
						System.out.print("*");
						continue;
					} else if (tmp == 1) {
						System.out.println();
						break;
					}
				}
				p++;
			}
		}
	}

	// ժ�ԣ�http://www.cnblogs.com/sun-/p/5252225.html
	private static void test1(int m, int n) {
		for (int i = m; i <= n; i++) {
			System.out.print(i + "=");
			int b = i;
			int k = 2;
			while (k <= Math.sqrt(i)) {
				if (b % k == 0) {
					b = b / k;
					if (b > 1) {
						System.out.print(k + "*");
						continue;
					}
					if (b == 1)
						System.out.println(k);
				}
				k++;
			}
			if (b > 1 && b < i)
				System.out.println(b);
			if (b == i)
				System.out.println(i);
		}
	}

	private static void printPrimeNums(int[] data) {
		System.out.println("total: " + data.length);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
			if (i != 0 && i % 8 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	// ������еĲ�����b����������
	private static int[] getAllPrimeNums(int b) {
		int[] data0 = new int[b];
		int datanum0 = 0;
		for (int i = 2; i <= b; i++) {
			// ȥ��1�ͱ���i
			int j = 2;
			for (; j < i; j++)
				if (i % j == 0)
					break;
			if (i == j)
				data0[datanum0++] = i;
		}
		return Arrays.copyOfRange(data0, 0, datanum0);
	}
}
