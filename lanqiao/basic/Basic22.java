package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ FJ���ַ���
 * 
 * ��������<br>
 * 
 * FJ��ɳ����д������һЩ�ַ�����<br>
 * A1 = ��A��<br>
 * A2 = ��ABA��<br>
 * A3 = ��ABACABA��<br>
 * A4 = ��ABACABADABACABA��<br>
 * �� �� <br>
 * �����ҳ����еĹ��ɲ�д���е�����AN��<br>
 * 
 * �����ʽ<br>
 * 
 * ����һ������N �� 26��<br>
 * 
 * �����ʽ<br>
 * 
 * �������Ӧ���ַ���AN����һ�����з�����������в��ú��ж���Ŀո���С��س�����<br>
 * 
 * ��������<br>
 * 
 * 3<br>
 * �������<br>
 * 
 * ABACABA<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺�ַ��� �ݹ�
 * 
 * @author Chain
 *
 */
public class Basic22 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		StringBuilder sbAn = new StringBuilder("");
		for (int i = 0; i < n; i++) {
			String tmp = sbAn.toString();
			sbAn.append((char) ('A' + i));
			sbAn.append(tmp);
			System.out.println("A" + (i + 1) + "=" + sbAn.toString());
		}
	}

}
