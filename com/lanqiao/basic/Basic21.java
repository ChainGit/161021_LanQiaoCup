package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ Sine֮��
 * 
 * ��������<br>
 * ���FJΪ������ţ�ǿ�������ѧ�����Σ�FJ֪����Ҫѧ�����ſΣ�������һ���õ����Ǻ�����������<br>
 * ������׼������ţ����һ����Sine֮�衱����Ϸ��Ԣ�����֣������ţ�ǵļ���������<br>
 * ������<br>
 * An=sin(1�Csin(2+sin(3�Csin(4+...sin(n))...)<br>
 * Sn=(...(A1+n)A2+n-1)A3+...+2)An+1<br>
 * FJ������ţ�Ǽ���Sn��ֵ���������FJ��ӡ��Sn���������ʽ���Է�����ţ�����⡣<br>
 * �����ʽ<br>
 * ����һ������N<201��<br>
 * �����ʽ<br>
 * �������Ӧ�ı��ʽSn����һ�����з�����������в��ú��ж���Ŀո���С��س�����<br>
 * ��������<br>
 * 3<br>
 * �������<br>
 * ((sin(1)+3)sin(1�Csin(2))+2)sin(1�Csin(2+sin(3)))+1<br>
 * 
 * A1 = sin(1)<br>
 * A2 = sin(1-sin(2))<br>
 * A3 = sin(1-sin(2+sin(3)))<br>
 * 
 * Sn=(...(A1+n)A2+n-1)A3+...+2)An+1<br>
 * S1=(null)A1+1<br>
 * S2=(A1+2)A2+1<br>
 * S3=((A1+3)A2+2)A3+1<br>
 * S4=(((A1+4)A2+3)A3+2)A4+1<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺�ַ��� �ݹ� ����
 * 
 * @author Chain
 *
 */
public class Basic21 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		String sAn = null;
		StringBuilder sbAn = new StringBuilder();
		StringBuilder sbSn = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sAn = String.valueOf(i + 1);
			for (int j = 0; j < i + 1; j++) {
				int t = i - j;
				if (t > 0) {
					sbAn.append(t);
					sbAn.append(t % 2 == 0 ? "+" : "-");
				}
				sbAn.append("sin(");
				sbAn.append(sAn);
				sbAn.append(")");
				sAn = sbAn.toString();
				sbAn.delete(0, sbAn.length());
			}
			System.out.println("A" + (i + 1) + "=" + sAn);
			addToSn(sbSn, sAn);
			printSn(sbSn);
		}

	}

	private static void printSn(StringBuilder sbSn) {
		// ȷ���м�������
		int n = 0;
		for (int i = 0; i < sbSn.length(); i++)
			if (sbSn.charAt(i) == '(')
				n++;
			else
				break;

		System.out.print("S" + (++n) + "=");
		for (int i = 0; i < sbSn.length(); i++) {
			char t = sbSn.charAt(i);
			System.out.print(t);
			if (t == '+' && n != 1)
				System.out.print(n--);
		}
		System.out.println(1);
	}

	private static void addToSn(StringBuilder sbSn, String sAn) {
		if (sbSn.length() != 0) {
			sbSn.insert(0, "(");
			sbSn.insert(sbSn.length(), ")");
		}
		sbSn.append(sAn);
		sbSn.append("+");
	}

}
