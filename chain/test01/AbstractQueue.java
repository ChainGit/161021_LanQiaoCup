package com.chain.algorithm.test.day01;

import java.util.List;

public abstract class AbstractQueue<T> {

	/**
	 * 将新节点加到队列末尾
	 * 
	 * @param value
	 */
	public abstract void push(T value);

	/**
	 * 查看队列最后一个节点的值
	 * 
	 * @return
	 */
	public abstract T last();

	/**
	 * 获得队列的第一个节点的值，并移除第一个节点
	 * 
	 * @return
	 */
	public abstract T pull();

	/**
	 * 查看队列的第一个节点的值
	 * 
	 */
	public abstract T peek();

	/**
	 * 队列是否为空
	 * 
	 * @return
	 */
	public abstract boolean isEmpty();

	/**
	 * 
	 * 清空队列
	 * 
	 */
	public abstract void clear();

	/**
	 * 
	 * 队列的现有节点数
	 * 
	 */
	public abstract int size();

	/**
	 * 
	 * 转换为List
	 * 
	 * @return
	 */
	public abstract List<T> toList();

}
