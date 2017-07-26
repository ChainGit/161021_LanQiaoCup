package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * �������� ��Ӳ��
 * 
 * �ܽ᣺̰��(�����ֲ�������)
 * 
 * @author Chain
 *
 */
public class Prev06 {

	// ������ɨ��,һ��ɨ�赽��һ���ľͷ�ת��λ���ұߵ��Ǹ�Ӳ��,ʹ�ø�λ��������
	// �����ٴ��ҵ���ɨ��,һ��ɨ�赽��һ���ľͷ�ת��λ����ߵ��Ǹ�Ӳ��,ʹ�ø�λ��������
	// ������ߵĽ����Сֵ
	public static void main(String[] args) throws Exception {
		boolean[] a = null;
		boolean[] b = null;
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		a = getInputArr(bufr.readLine());
		b = getInputArr(bufr.readLine());
		bufr.close();

		// ������
		boolean[] p = a.clone();
		int s1 = 0;
		int len = p.length;
		for (int i = 0; i < len - 1; i++)
			if (p[i] != b[i]) {
				p[i] = !p[i];
				p[i + 1] = !p[i + 1];
				s1++;
			}
		if (p[len - 1] != b[len - 1])
			s1 = -1;

		// ���ҵ���
		p = a.clone();
		int s2 = 0;
		for (int i = len - 1; i > 0; i--)
			if (p[i] != b[i]) {
				p[i] = !p[i];
				p[i - 1] = !p[i - 1];
				s2++;
			}
		if (p[0] != b[0])
			s2 = -1;

		// ��Ŀû��˵���Ƿ�һ�����Է�ת,�������һ�����Է�ת�ɹ�
		if (s1 != -1 && s2 != -1)
			System.out.println(s1 > s2 ? s2 : s1);
		else if (s1 == -1 && s2 != -1)
			System.out.println(s2);
		else if (s1 != -1 && s2 == -1)
			System.out.println(s1);
		else
			System.out.println(0);
	}

	// ��������תΪboolean����
	private static boolean[] getInputArr(String sbuf) {
		char[] cbuf = sbuf.toCharArray();
		int len = cbuf.length;
		boolean[] p = new boolean[len];
		for (int i = 0; i < len; i++)
			p[i] = cbuf[i] == '*' ? true : false;
		return p;
	}
}
