package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ ���������
 * 
 * �������� <br>
 * ƽ�������������Σ����ǵı�ƽ����ֱ������ϵ��X���Y�ᡣ����ÿ�����Σ����� <br>
 * ��������һ����Զ�������꣬����������������εĽ�������� <br>
 * �����ʽ <br>
 * ������������У�ÿ������һ�����Ρ� <br>
 * ��ÿ���У��������ε�һ����Զ�������꣬ÿ��������궼����������ֵ������ <br>
 * 10^7��ʵ����ʾ�� <br>
 * �����ʽ <br>
 * ���������һ��ʵ����Ϊ���������������С������λ�� <br>
 * �������� <br>
 * 1 1 3 3 <br>
 * 2 2 4 4 <br>
 * ������� <br>
 * 1.00 <br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺�ж� �߶ν�
 * 
 * @author Chain
 *
 */
public class Basic18 {

	// �ο���http://blog.csdn.net/liukx940818/article/details/44197183
	public static void main(String[] args) {
		double x[] = new double[4];
		double y[] = new double[4];
		// ��Զ����������������
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		in.close();

		// ��ת�����Խ�������
		sort(x, 1, 0);
		sort(x, 3, 2);
		sort(y, 0, 1);
		sort(y, 2, 3);

		System.out.println("Ax1=" + x[0] + " Ay1=" + y[0] + " Ax2=" + x[1] + " Ay2=" + y[1]);
		System.out.println("Bx1=" + x[2] + " By1=" + y[2] + " Bx2=" + x[3] + " By2=" + y[3]);

		// �ж��Ƿ�����
		if (checkIsCross(x, y))
			System.out.println(String.format("%.2f", sort2(x.clone()) * sort2(y.clone())));
		else
			System.out.println("0.00");

	}

	// ���������εĺ��������������������
	private static double sort2(double[] d) {
		// ѡ������
		for (int i = 0; i < d.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < d.length; j++)
				if (d[j] < d[min])
					min = j;
			if (min != i)
				swap(d, min, i);
		}
		return d[2] - d[1];
	}

	// ����ʹ��d[i]>d[j]
	private static void sort(double[] d, int i, int j) {
		if (d[i] < d[j]) {
			swap(d, i, j);
		}
	}

	// ����ʵ��ֻ�����м������,��Ϊʵ���Ĵ洢��ʽ��ͬ������
	private static void swap(double[] d, int i, int j) {
		double tmp = d[i];
		d[i] = d[j];
		d[j] = tmp;
	}

	// �ж��Ƿ�����,�߱Ƚ�,���ù��ɶ���,��Ϊ�������
	private static boolean checkIsCross(double[] x, double[] y) {
		if (x[1] <= x[2] || x[0] >= x[3] || y[0] <= y[3] || y[1] >= y[2])
			return false;
		return true;
	}

}