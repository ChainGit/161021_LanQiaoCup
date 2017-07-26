package com.chain.javase.algorithm.day01;

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
	}

}
