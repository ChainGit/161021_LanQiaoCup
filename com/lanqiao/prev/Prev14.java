package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * �������� ��ɮ����
 * 
 * �ܽ᣺������
 * 
 * @author Chain
 *
 */
public class Prev14 {

	// �ٶȿ�֪,����һ����Nim��Ϸ,���ߵ�һ����ʤ���Ļ�,ֻ��Ҫ������ǰ״�����Ϊ0����
	public static void main(String[] args) throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String sbuf = bufr.readLine();
		bufr.close();

		String[] pbuf = sbuf.split(" ");
		int len = pbuf.length;
		ArrayList<Integer> lst = new ArrayList<>();
		for (int i = 0; i < len; i++)
			lst.add(new Integer(pbuf[i]) - 1);

		// ת��ΪNim��Ϸ,��ö��ٶ�ʯ��,ʯ�������Ͷ�������,�����ÿ��ʯ�ӵĸ���(������С����֮���̨����)
		int num = lst.size();
		// ÿ��ʯ�Ӹ�����ָ������С����֮���̨����
		int[] heap = new int[num];
		for (int i = 0; i < num - 1; i++)
			heap[i] = lst.get(i + 1) - lst.get(i) - 1;

		// ʵ����Ч������ÿ��С����֮���̨��
		int xor = 0;
		for (int i = 0; i < num - 1; i += 2)
			xor ^= heap[i];

		// ���һ��ʼ����0,������Ժ��ߵ�����,�����ߵ�һ������һ��Ӯ
		if (xor == 0) {
			System.out.println(-1);
			return;
		}

		// ���δ�0��С���г�����̨��,ֱ�����һ��С����
		for (int i = 0; i < num; i++) {
			// �����ߵ�̨����
			int many = heap[i];
			for (int j = 1; j <= many; j++) {

				// ����̨������������,��������һ���仯,���ڵ�ҲҪ�仯
				heap[i] -= j;
				if (i > 0)
					heap[i - 1] += j;

				xor = 0;
				for (int k = 0; k < num - 1; k += 2)
					xor ^= heap[k];

				// �Ѿ��������Ϊ0
				if (xor == 0) {
					int which = lst.get(i) + 1;
					System.out.println(which + " " + (which + j));
					return;
				}

				heap[i] += j;
				if (i > 0)
					heap[i - 1] -= j;
			}
		}

	}
}
