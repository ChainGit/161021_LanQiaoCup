package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ ��ĸͼ��
 * 
 * �ܽ᣺Ƕ��ѭ����ע��۲�������������⣬�ַ���
 * 
 * @author Lenovo
 *
 */
public class Basic03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		// i�����У�Ҳ��A��λ��
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				System.out.print((char) (Math.abs(j - i) + 'A'));
			System.out.println();
		}
		in.close();
	}

}
