package com.lanqiao.prev;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * 历届试题 幸运数
 * 
 * 总结：堆
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

		// 使用JavaAPI,测试100
		method1(a, b);
	}

	// 使用LinkedList,范围(a,b),0< m < n < 1000*1000
	private static void method1(int a, int b) {
		LinkedList<Integer> lst = new LinkedList<>();
		for (int i = 1; i < b; i++)
			lst.add(i);

		deleteIndex(lst, 2);

		// 获得[1,b)的所有幸运数,i是第i+1个幸运数
		int delete = 0;
		int size = lst.size() - 1;
		// get(1)肯定存在
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

	// 修改多次,最终满足
	private static int deleteIndex(LinkedList<Integer> lst, int idx) {
		// i是序号,不是下标
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
