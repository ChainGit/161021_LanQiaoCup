package com.lanqiao.begin;

import java.util.Scanner;

/**
 * �������� : ����A��B�����A+B��
 * �����ʽ : ����ĵ�һ�а��������������ɿո�ָ����ֱ��ʾA��B�� 
 * �����ʽ : ���һ�У�����һ����������ʾA+B��ֵ��
 * 
 * �������� : 12 45 ������� : 57
 * 
 * ���ݹ�ģ��Լ�� : -10000 <= A, B <= 10000
 * 
 * �ܽ᣺����������������з������ļӷ�
 * 
 * @author Lenovo
 *
 */
public class Begin01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer a = in.nextInt();
		Integer b = in.nextInt();
		System.out.println(a + b);
		in.close();
	}
}
