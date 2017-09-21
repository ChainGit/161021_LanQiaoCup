package com.chain.algorithm.test.day01;

import java.util.List;

import org.junit.Test;

public class TreeTest {

	@Test
	public void testBinaryTree() {
		AbstractBinaryTree<Integer> tree = new BinaryTree<>();

		System.out.println(tree.size());
		System.out.println(tree.isEmpty());

		tree.add(32);
		tree.add(28);
		tree.add(56);
		tree.add(14);
		tree.add(25);
		tree.add(51);
		tree.add(68);
		tree.add(78);
		tree.add(44);
		tree.add(41);
		tree.add(40);
		tree.add(42);
		tree.add(72);
		tree.add(79);

		System.out.println(tree.size());
		System.out.println(tree.isEmpty());

		System.out.println(tree.bfsToList());
		System.out.println(tree.preOrderToList());
		System.out.println(tree.inOrderToList());
		System.out.println(tree.postOrderToList());

		// 二叉树的中序遍历输出的即是已经排序好的数组
		// 要求：查找二叉排序树的最接近k的节点

		int k = 100;
		List<Integer> list = tree.inOrderToList();

		int value = getClosest(list, k);
		System.out.println(value);
	}

	// 查找二叉排序树的最接近k的节点
	private int getClosest(List<Integer> list, int k) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			int current = list.get(i);
			if (current == k) {
				return current;
			} else if (current > k) {
				if (i > 0) {
					int before = list.get(i - 1);
					int d1 = current - k;
					int d2 = k - before;
					// 如果相等的话就返回排在前面的值
					return d2 > d1 ? current : before;
				} else {
					return current;
				}
			}
		}
		return list.get(size - 1);
	}

}
