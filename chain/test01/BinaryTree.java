package com.chain.algorithm.test.day01;

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

	@Override
	public boolean delete(T value) {
		// 二叉树删除节点总共有四种情况，需要考虑进根节点
		BinaryTreeNode<T> currentNode = rootNode;
		BinaryTreeNode<T> parentNode = rootNode;
		// 如果为空树
		if (currentNode == null || value == null)
			return false;

		BinaryTreeNode<T> findNode = new BinaryTreeNode<>(value);

		// 类似插入节点，从根节点依次往下找，找到这个节点或直到为空
		// 往左为true
		boolean flag = true;
		while (true) {
			// 往左走
			if (currentNode.compareTo(findNode) > 0) {
				parentNode = currentNode;
				currentNode = currentNode.getLeft();
				flag = true;
			}
			// 往右走
			else if (currentNode.compareTo(findNode) < 0) {
				parentNode = currentNode;
				currentNode = currentNode.getRight();
				flag = false;
			}
			// 相等
			else {
				break;
			}
			// 没有找到该节点
			if (currentNode == null) {
				return false;
			}
		}

		// System.out.println(currentNode.value);
		// System.out.println(parentNode.value);

		// 如果找到的节点为叶子节点，即没有左右孩子
		if (currentNode.getLeft() == null && currentNode.getRight() == null) {
			if (currentNode == rootNode) {
				rootNode = null;
			}
			// 是父节点的左孩子
			else if (flag) {
				parentNode.setLeft(null);
			}
			// 是父节点的右孩子
			else if (!flag) {
				parentNode.setRight(null);
			}
		}
		// 如果找到的节点有右孩子
		else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
			BinaryTreeNode<T> right = currentNode.getRight();
			if (currentNode == rootNode) {
				rootNode = right;
			} else if (flag) {
				parentNode.setLeft(right);
			} else if (!flag) {
				parentNode.setRight(right);
			}
		}
		// 如果找到的节点有左孩子
		else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
			BinaryTreeNode<T> left = currentNode.getLeft();
			if (currentNode == rootNode) {
				rootNode = left;
			} else if (flag) {
				parentNode.setLeft(left);
			} else if (!flag) {
				parentNode.setRight(left);
			}
		}
		// 如果找到的节点有两个孩子，找到中序后继节点
		else {
			BinaryTreeNode<T> successorNode = getSuccessor(currentNode);

			// 然后将currentNode替换成successorNode
			if (currentNode == rootNode) {
				rootNode = successorNode;
			} else if (flag) {
				parentNode.setLeft(successorNode);
			} else if (!flag) {
				parentNode.setRight(successorNode);
			}

			// 只可能有这种情况
			successorNode.setLeft(currentNode.getLeft());
		}

		count--;

		return true;
	}

	// 找到中序后继节点：在剩余子树中找出所有比被删除节点的值 大 的所有数，并在这些数中找出一个 最小 的数来
	private BinaryTreeNode<T> getSuccessor(BinaryTreeNode<T> deleteNode) {
		BinaryTreeNode<T> currentNode = deleteNode;
		// 右节点不为空，比要删除节点大的都在右子树
		BinaryTreeNode<T> successorNode = currentNode.getRight();
		BinaryTreeNode<T> successorParentNode = successorNode;
		while (currentNode != null) {
			successorParentNode = successorNode;
			successorNode = currentNode;
			// 最小的节点又都在左子树
			currentNode = currentNode.getLeft();
		}
		// 如果中序后继节点不是要删除的节点的右孩子
		if (successorNode != deleteNode.getRight()) {
			// 中序后继节点只可能有右孩子，将其放到中序后继的位置
			successorParentNode.setLeft(successorNode.getRight());
			// 中继后继的节点的右孩子（肯定存在）连接到要删除的节点的右孩子上（也肯定存在）防止出现游离状态而被回收
			successorNode.setRight(deleteNode.getRight());
		}
		return successorNode;
	}

}
