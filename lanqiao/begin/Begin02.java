package com.lanqiao.begin;

import java.util.Scanner;

/**
 * �������� : ��1+2+3+...+n��ֵ��
 * �����ʽ : �������һ������n�� 
 * �����ʽ : ���һ�У�����һ����������ʾ1+2+3+...+n��ֵ�� 
 * �������� : 4
 * ������� : 10 
 * �������� : 100
 * ������� : 5050 
 * ���ݹ�ģ��Լ�� : 1 <= n <= 1,000,000,000��
 * 
 * �ܽ᣺�����Ĵ�����͹�ʽ
 * 
 * @author Lenovo
 *
 */
public class Begin02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long i = in.nextInt();
		long s = 0;
		s = (i * (i + 1)) >> 1;
		System.out.println(s);
		in.close();
	}

}
