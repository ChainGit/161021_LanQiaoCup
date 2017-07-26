package com.chain.javase.algorithm.day01;

import java.util.List;

public abstract class AbstractBinaryTree<T> {

	/**
	 * 构建排序二叉树
	 * 
	 */
	public abstract void add(T node);

	public abstract int size();

	public abstract boolean isEmpty();

	public abstract void clear();

	/**
	 * 广度优先遍历
	 * 
	 */
	public abstract List<T> bfsToList();

	/**
	 * 中序遍历
	 * 
	 * @return
	 */
	public abstract List<T> inOrderToList();

	/**
	 * 前序遍历
	 * 
	 * @return
	 */
	public abstract List<T> preOrderToList();

	/**
	 * 后序遍历
	 * 
	 * @return
	 */
	public abstract List<T> postOrderToList();

}
