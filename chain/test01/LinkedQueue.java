package com.chain.javase.algorithm.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于链表的队列
 * 
 * @author Chain
 *
 */
public class LinkedQueue<T> extends AbstractQueue<T> {

	private QueueNode<T> headNode;

	private int count;

	public LinkedQueue() {
		super();
		headNode = new QueueNode<>(null);
	}

	/**
	 * 将新节点加到队列末尾
	 * 
	 * @param value
	 */
	@Override
	public void push(T value) {
		QueueNode<T> node = new QueueNode<>(value);

		QueueNode<T> currentNode = headNode;
		QueueNode<T> lastNode = currentNode;
		while (currentNode != null) {
			lastNode = currentNode;
			currentNode = currentNode.getNextNode();
		}

		lastNode.setNextNode(node);
		count++;
	}

	/**
	 * 查看队列最后一个节点的值
	 * 
	 * @return
	 */
	@Override
	public T last() {
		QueueNode<T> currentNode = headNode;
		QueueNode<T> lastNode = currentNode;
		while (currentNode != null) {
			lastNode = currentNode;
			currentNode = currentNode.getNextNode();
		}

		return lastNode.getValue();
	}

	/**
	 * 获得队列的第一个节点的值，并移除第一个节点
	 * 
	 * @return
	 */
	@Override
	public T pull() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		}

		QueueNode<T> nextNode = headNode.getNextNode();
		T val = nextNode.getValue();
		QueueNode<T> nextNextNode = nextNode.getNextNode();
		if (nextNextNode == null)
			headNode.setNextNode(null);
		else
			headNode.setNextNode(nextNextNode);

		count--;

		return val;
	}

	/**
	 * 查看队列的第一个节点的值
	 * 
	 */
	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		}

		QueueNode<T> nextNode = headNode.getNextNode();
		T val = nextNode.getValue();
		return val;
	}

	/**
	 * 队列是否为空
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		QueueNode<T> nextNode = headNode.getNextNode();
		return nextNode == null;
		// return count == 0;
	}

	/**
	 * 
	 * 清空队列
	 * 
	 */
	@Override
	public void clear() {
		headNode.setNextNode(null);
		count = 0;
	}

	/**
	 * 队列的现有节点数
	 * 
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * 转变为List
	 * 
	 */
	@Override
	public List<T> toList() {
		List<T> lst = new ArrayList<>();
		if (isEmpty())
			return lst;

		QueueNode<T> currrentNode = headNode.getNextNode();
		while (currrentNode != null) {
			lst.add(currrentNode.getValue());
			currrentNode = currrentNode.getNextNode();
		}
		return lst;
	}

}
