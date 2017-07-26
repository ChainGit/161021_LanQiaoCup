package com.chain.javase.algorithm.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * 
 * @author Chain
 *
 * @param <T>
 */
public class BinaryTree<T> extends AbstractBinaryTree<T> {

	private BinaryTreeNode<T> rootNode;

	private int count;

	/**
	 * 构建排序二叉树
	 * 
	 */
	@Override
	public void add(T value) {
		if (rootNode == null) {
			rootNode = new BinaryTreeNode<>(value);
			count++;
			return;
		}

		BinaryTreeNode<T> node = new BinaryTreeNode<>(value);

		BinaryTreeNode<T> currentNode = rootNode;
		BinaryTreeNode<T> lastNode = currentNode;
		boolean flag = true;
		while (currentNode != null) {
			lastNode = currentNode;
			if (currentNode.compareTo(node) >= 0) {
				currentNode = currentNode.getLeft();
				flag = true;
			} else {
				currentNode = currentNode.getRight();
				flag = false;
			}
		}

		if (currentNode == null) {
			if (flag) {
				lastNode.setLeft(node);
			} else {
				lastNode.setRight(node);
			}
		}

		count++;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		if (rootNode == null)
			return true;
		return false;
		// return count == 0;
	}

	@Override
	public void clear() {
		rootNode = null;
		count = 0;
	}

	/**
	 * 广度优先遍历
	 * 
	 */
	@Override
	public List<T> bfsToList() {
		List<T> lst = new ArrayList<>();
		if (isEmpty())
			return lst;

		AbstractQueue<BinaryTreeNode<T>> queue = new LinkedQueue<>();
		// AbstractQueue<BinaryTreeNode<T>> queue = new ArrayQueue<>();
		queue.push(rootNode);

		getLeftAndRightThenPushToQueue(lst, queue);

		return lst;
	}

	private void getLeftAndRightThenPushToQueue(List<T> lst, AbstractQueue<BinaryTreeNode<T>> queue) {
		int size = size();
		for (int i = 0; i < size; i++) {
			BinaryTreeNode<T> parentNode = queue.pull();
			lst.add(parentNode.getValue());
			BinaryTreeNode<T> leftNode = parentNode.getLeft();
			BinaryTreeNode<T> rightNode = parentNode.getRight();
			if (leftNode != null)
				queue.push(leftNode);
			if (rightNode != null)
				queue.push(rightNode);
		}
		if (!queue.isEmpty())
			getLeftAndRightThenPushToQueue(lst, queue);
	}

	protected static class BinaryTreeNode<T> implements Comparable<BinaryTreeNode<T>> {

		private T value;
		private BinaryTreeNode<T> left;
		private BinaryTreeNode<T> right;

		public BinaryTreeNode(T value) {
			super();
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public BinaryTreeNode<T> getLeft() {
			return left;
		}

		public void setLeft(BinaryTreeNode<T> left) {
			this.left = left;
		}

		public BinaryTreeNode<T> getRight() {
			return right;
		}

		public void setRight(BinaryTreeNode<T> right) {
			this.right = right;
		}

		@Override
		public int compareTo(BinaryTreeNode<T> other) {
			if (other == null)
				throw new RuntimeException("node is null");

			T otherValue = other.getValue();

			if (otherValue instanceof Integer && value instanceof Integer)
				return ((Integer) value).compareTo((Integer) otherValue);

			return 0;
		}

	}

	@Override
	public List<T> inOrderToList() {
		List<T> lst = new ArrayList<>();
		inOrder(rootNode, lst);
		return lst;
	}

	private void inOrder(BinaryTreeNode<T> node, List<T> lst) {
		if (node == null)
			return;

		inOrder(node.getLeft(), lst);
		lst.add(node.getValue());
		inOrder(node.getRight(), lst);
	}

	@Override
	public List<T> preOrderToList() {
		List<T> lst = new ArrayList<>();
		preOrder(rootNode, lst);
		return lst;
	}

	private void preOrder(BinaryTreeNode<T> node, List<T> lst) {
		if (node == null)
			return;

		lst.add(node.getValue());
		preOrder(node.getLeft(), lst);
		preOrder(node.getRight(), lst);
	}

	@Override
	public List<T> postOrderToList() {
		List<T> lst = new ArrayList<>();
		postOrder(rootNode, lst);
		return lst;
	}

	private void postOrder(BinaryTreeNode<T> node, List<T> lst) {
		if (node == null)
			return;

		postOrder(node.getLeft(), lst);
		postOrder(node.getRight(), lst);
		lst.add(node.getValue());
	}

}
