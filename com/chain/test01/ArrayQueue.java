package com.chain.javase.algorithm.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用数组实现循环队列
 * 
 * 判断的时候可以使用数学公式，也可以使用count来判断 ；使用数学公式有一个会浪费，使用count则可以不浪费空间
 * 
 * @author Chain
 *
 */
public class ArrayQueue<T> extends AbstractQueue<T> implements ArrayQueueInterface<T> {

	private Object[] data;

	// 不使用count也是可以的
	private int count;

	// 指向队列的头元素所在的位置的下标
	private int head;
	// 指向队列的尾元素所在的位置的后一个下标
	private int tail;

	private static int capacity = 10;

	public ArrayQueue() {
		super();
		this.data = new Object[capacity];
	}

	@Override
	public void push(T value) {
		if (isFull()) {
			extend();
		}

		data[tail] = value;
		tail = (tail + 1) % capacity;
		count++;
	}

	@Override
	public T last() {
		if (isEmpty())
			return null;

		int last = (tail + capacity - 1) % capacity;
		return (T) data[last];
	}

	@Override
	public T pull() {
		if (isEmpty())
			throw new RuntimeException("queue is empty");

		T temp = (T) data[head];
		data[head] = null;
		head = (head + 1) % capacity;
		count--;
		return temp;
	}

	@Override
	public T peek() {
		if (isEmpty())
			return null;

		T temp = (T) data[head];
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// 如果head和tail重叠，则为空
		if (head == tail)
			return true;
		return false;
	}

	@Override
	public void clear() {
		head = tail = count = 0;
		capacity = 10;
		data = new Object[capacity];
	}

	@Override
	public int size() {
		int size = (capacity - (head - tail)) % capacity;
		return size;
	}

	@Override
	public boolean isFull() {
		// 假设head和tail是不重叠的，即tail和head之间空一格
		if ((tail + 1) % capacity == head)
			return true;
		return false;
	}

	@Override
	public List<T> toList() {
		List<T> lst = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			lst.add((T) data[i]);
		}
		return lst;
	}

	@Override
	public synchronized void extend() {
		try {
			// 方法很多，这里使用pull再push的方法
			int newCapacity = capacity << 1;
			Object[] newData = new Object[newCapacity];
			int size = size();
			int index = 0;
			while (size-- > 0) {
				newData[index++] = pull();
			}

			head = 0;
			tail = count = index;
			capacity = newCapacity;
			data = newData;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
