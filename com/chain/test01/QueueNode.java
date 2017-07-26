package com.chain.javase.algorithm.day01;

/**
 * 队列的节点
 * 
 * @author Chain
 *
 * @param <T>
 */
public class QueueNode<T> {

	private T value;
	private QueueNode<T> nextNode;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public QueueNode<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(QueueNode<T> nextNode) {
		this.nextNode = nextNode;
	}

	public QueueNode(T value) {
		super();
		this.value = value;
	}

}
