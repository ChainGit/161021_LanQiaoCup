package com.lanqiao.prev;

import java.util.Scanner;

/**
 * �������� ��ӡʮ��ͼ
 * 
 * �ܽ᣺����ͼ��
 * 
 * @author Chain
 *
 */
public class Prev02 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		// ��ʼ������Ϊfalse,�������'.'
		int len = (n << 2) + 5;
		boolean dat[][] = new boolean[len][len];

		// �������ڻ�
		for (int i = 0; i < n + 1; i++) {
			// ���λ����

			// ��
			int line = i << 1;
			// ��
			int angle = 2;

			// ���ĸ�����ս�
			for (int j = 0; j < angle; j++) {
				// ����
				dat[line + angle][j + line + 1] = true;
				// dat[line + angle][len - 1 - j -line - 1] = true;
				dat[line + angle][len - 2 - j - line] = true;
				dat[len - 1 - line - angle][j + line + 1] = true;
				dat[len - 1 - line - angle][len - 2 - j - line] = true;

				// ����
				dat[j + line + 1][line + angle] = true;
				dat[j + line + 1][len - 1 - line - angle] = true;
				dat[len - 1 - line - j - 1][line + angle] = true;
				dat[len - 1 - line - j - 1][len - 1 - line - angle] = true;
			}

			// ��������
			for (int j = line + angle; j < len - line - angle; j++) {
				// ����
				dat[line][j] = true;
				dat[len - 1 - line][j] = true;

				// ����
				dat[j][line] = true;
				dat[j][len - 1 - line] = true;
			}

		}

		// ��ӡ��ͼ��
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++)
				if (dat[i][j])
					System.out.print('$');
				else
					System.out.print('.');
			System.out.println();
		}

	}
}
