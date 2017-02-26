package com.lanqiao.prev;

import java.util.Scanner;

/**
 * �������� ũ������
 * 
 * �ܽ᣺���㼸��
 * 
 * @author Chain
 *
 */
public class Prev16 {

	private static final int G = 100;

	// ������Ư������λӳ�䵽����x-y��,ת��Ϊһ��Բ����ε����ཻ�������
	// ������,ũ�������������Ѿ������Ѷ�
	public static void main(String[] args) {
		// ������ʱδ���,���Ŀ�֪Ϊ2013����ѹ����
		// ���ֻ������͵Ľ���⣺�ٷ�������ʾ�����

		// �Լ�ʹ�ý��Ʒ�����,10��
		Scanner in = new Scanner(System.in);
		int a = in.nextInt() * G;
		int b = in.nextInt() * G;
		double g = in.nextDouble();
		int n = in.nextInt();
		int[][] pos = new int[n][3];
		for (int i = 0; i < n; i++) {
			int[] tmp = new int[4];
			for (int j = 0; j < 4; j++)
				tmp[j] = in.nextInt();
			pos[i][0] = (tmp[0] + tmp[2] * (int) (1 / Math.tan(g))) * G;
			pos[i][1] = tmp[1] * G;
			pos[i][2] = tmp[3] * G;
		}
		in.close();

		long area = a * b;

		for (int i = 0; i <= b; i++)
			for (int j = 0; j <= a; j++)
				// �����Ƿ���ĳ��Բ��
				if (checkPart(pos, i, j))
					area--;

		printAns(area);

	}

	private static boolean checkPart(int[][] pos, int px, int py) {
		for (int i = 0; i < pos.length; i++) {
			int ix = pos[i][0];
			int iy = pos[i][1];
			int ir = pos[i][2];

			int dx = Math.abs(px - ix);
			int dy = Math.abs(py - iy);
			if (dx * dx + dy * dy <= ir * ir)
				return true;
		}
		return false;
	}

	private static void printAns(long area) {
		int gg = G * G;
		long a = area / gg;
		long b = area % gg;
		String s = a + "." + b;
		double d = new Double(s);
		System.out.printf("%.2f", d);
		System.out.println();
	}
}
