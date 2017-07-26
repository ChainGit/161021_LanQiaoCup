package com.lanqiao.prev;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * �������� ������
 * 
 * �ܽ᣺��
 * 
 * @author Chain
 *
 */
public class Prev10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		in.close();

		// ʹ��JavaAPI,����100
		method1(a, b);
	}

	// ʹ��LinkedList,��Χ(a,b),0< m < n < 1000*1000
	private static void method1(int a, int b) {
		LinkedList<Integer> lst = new LinkedList<>();
		for (int i = 1; i < b; i++)
			lst.add(i);

		deleteIndex(lst, 2);

		// ���[1,b)������������,i�ǵ�i+1��������
		int delete = 0;
		int size = lst.size() - 1;
		// get(1)�϶�����
		int index = lst.get(1);
		for (int i = 1; i < b && index < lst.get(size);) {
			delete = deleteIndex(lst, index);
			index = lst.get(++i);
			size -= delete + 1;
		}

		int pos = 0;
		while (lst.get(pos) <= a)
			pos++;

		// System.out.println(lst.toString());
		System.out.println(lst.size() - pos);

	}

	// �޸Ķ��,��������
	private static int deleteIndex(LinkedList<Integer> lst, int idx) {
		// i�����,�����±�
		int size = lst.size();
		int delete = 0;
		for (int i = idx; i <= size;) {
			lst.remove(i - 1);
			i += idx - 1;
			size--;
			delete++;
		}

		return delete;
	}
}
