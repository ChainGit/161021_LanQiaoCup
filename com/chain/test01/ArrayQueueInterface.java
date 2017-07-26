package com.chain.javase.algorithm.day01;

public interface ArrayQueueInterface<T> {

	/**
	 * 扩大数组容量
	 * 
	 * @param old
	 * @return
	 */
	public void extend();

	/**
	 * 判断数组是否已满
	 * 
	 * @return
	 */
	public boolean isFull();
}
