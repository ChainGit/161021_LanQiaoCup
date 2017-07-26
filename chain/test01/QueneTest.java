package com.chain.javase.algorithm.day01;

import org.junit.Test;

public class QueneTest {

	@Test
	public void testLinkedQueue() {
		AbstractQueue<Integer> queue = new LinkedQueue<>();

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());

		queue.push(1);
		queue.push(2);
		queue.push(3);

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.toList());

		System.out.println(queue.last());
		System.out.println(queue.peek());
		System.out.println(queue.pull());
		System.out.println(queue.peek());

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.toList());

		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		// 已经pull完了，会抛出异常
		System.out.println(queue.pull());

	}

	@Test
	public void testArrayQueue() {
		AbstractQueue<Integer> queue = new ArrayQueue<>();

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());

		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.push(7);
		queue.push(8);
		queue.push(9);
		queue.push(10);
		queue.push(11);
		queue.push(12);
		queue.push(13);
		queue.push(14);
		queue.push(15);
		queue.push(16);
		queue.push(17);
		queue.push(18);
		queue.pull();
		queue.push(19);
		queue.pull();
		queue.push(20);
		queue.push(21);
		queue.pull();
		queue.push(22);
		queue.push(23);
		queue.pull();
		queue.push(24);
		queue.push(25);
		queue.push(26);
		queue.pull();
		queue.push(27);
		queue.push(28);
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.push(29);
		queue.push(30);
		queue.push(31);
		queue.pull();
		queue.push(32);
		queue.push(33);

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.toList());

		System.out.println(queue.last());
		System.out.println(queue.peek());
		System.out.println(queue.pull());
		System.out.println(queue.peek());

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.toList());

		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());

	}

	@Test
	public void testArrayQueue2() {
		AbstractQueue<Integer> queue = new ArrayQueue2<>();

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());

		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.push(7);
		queue.push(8);
		queue.push(9);
		queue.push(10);
		queue.push(11);
		queue.push(12);
		queue.push(13);
		queue.push(14);
		queue.push(15);
		queue.push(16);
		queue.push(17);
		queue.push(18);
		queue.pull();
		queue.push(19);
		queue.pull();
		queue.push(20);
		queue.push(21);
		queue.pull();
		queue.push(22);
		queue.push(23);
		queue.pull();
		queue.push(24);
		queue.push(25);
		queue.push(26);
		queue.pull();
		queue.push(27);
		queue.push(28);
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.pull();
		queue.push(29);
		queue.push(30);
		queue.push(31);
		queue.pull();
		queue.push(32);
		queue.push(33);

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.toList());

		System.out.println(queue.last());
		System.out.println(queue.peek());
		System.out.println(queue.pull());
		System.out.println(queue.peek());

		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.toList());

		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());
		System.out.println(queue.pull());

	}

}
