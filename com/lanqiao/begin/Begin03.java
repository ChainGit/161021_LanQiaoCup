package com.lanqiao.begin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * �������� : ����Բ�İ뾶r����Բ�������
 * �����ʽ : �������һ������r����ʾԲ�İ뾶��
 * �����ʽ : ���һ�У�����һ��ʵ�����������뱣��С�����7λ����ʾԲ�������
 * �������� : 4
 * ������� : 50.2654825
 * ���ݹ�ģ��Լ�� : 1 <= r <= 10000��
 * 
 * �ܽ᣺�������Ĵ�������С����ķ��������������ע�����ʵ�����
 * 
 * @author Lenovo
 *
 */
public class Begin03 {

	private static final int SCALE = 7;

	public static void main(String[] args) {
		double area = 4 * Math.atan(1);// PI=3.14159265358979323
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		r *= r;
		area *= r;
		System.out.println(new BigDecimal(area).setScale(SCALE, RoundingMode.HALF_UP).doubleValue());
		System.out.println(new DecimalFormat("#.0000000").format(area));
		System.out.println(String.format("%.7f", area));// �������100��
		in.close();
	}
}
