package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * �������� ����Ѱ·
 * 
 * �ܽ᣺ ��ͼ
 * 
 * @author Chain
 *
 */
public class Prev13 {

	// ���ж��������
	private int num;
	// ���վ���Ƿ�ɴ�(���߹���վ��)
	private boolean[] flag;
	// �洢վ������ͼ(�ڽӱ�)
	private Node[] road;
	// �ܹ��ж���վ��
	private int n;
	// �ܹ��ж�����ͨ��
	private int m;

	// ͼ�ı�ʾ�������ڽӾ����ڽӱ�
	// ͼ�ķ��ࣺ����ͼ������ͼ
	// ͼ�ı�����DFS��BFS
	public static void main(String[] args) throws Exception {
		// ��һ�����ݳ�ʱ,80��,ͬ����������C++��д�������Ҫ400ms
		// ��ͼ���ڽӱ�洢��֮ǰ�ı���ά����(�����ڽӾ���)�洢Ҫ���˲���
		new Prev13().method();
	}

	// ������ָ�������ĳվ��x��վ��y�����пɴ�·��,������β������ͬ,�м����ҽ�������վ��,�м�վ��ֻ����һ��
	private void method() throws IOException {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String sbuf = bufr.readLine();
		String[] pbuf = sbuf.split(" ");
		n = new Integer(pbuf[0]);
		m = new Integer(pbuf[1]);
		road = new Node[n];
		for (int i = 0; i < n; i++)
			road[i] = new Node(i);
		for (int i = 0; i < m; i++) {
			sbuf = bufr.readLine();
			pbuf = sbuf.split(" ");
			int from = new Integer(pbuf[0]) - 1;
			int to = new Integer(pbuf[1]) - 1;
			add(from, to);
			add(to, from);
		}
		bufr.close();

		flag = new boolean[n];

		// ��վ��i��ʼ�����ڽӱ�������
		for (int i = 0; i < n; i++) {
			go(i, i, 0);
			reset();
		}

		System.out.println(num);
	}

	// ���Ϊ3
	private void go(int start, int now, int citys) {
		// ��now����,�ɸýڵ���ڽ�����,���η���
		// �ж��Ƿ��߹�Ҫ���жϳ���֮��
		if (citys == 3) {
			num++;
			return;
		}

		if (flag[now])
			return;

		flag[now] = true;
		for (Node next = road[now].next; next != null; next = next.next) {
			int nextcity = next.data;
			if (flag[nextcity] && nextcity != start)
				continue;
			go(start, nextcity, citys + 1);
		}
		flag[now] = false;
	}

	// ����
	private void reset() {
		for (int i = 0; i < n; i++)
			flag[i] = false;
	}

	// ������ݵ����ӱ�
	private void add(int from, int to) {
		Node current = road[from];
		if (current == null) {
			road[from] = new Node(from);
			current = road[from];
		}
		while (true) {
			Node next = current.next;
			if (next == null) {
				current.next = new Node(to);
				return;
			}
			current = current.next;
		}
	}
}

// Ϊ�˲�������,ֱ��public
class Node {
	public int data = -1;
	public Node next = null;

	public Node(int data) {
		this.data = data;
	}

}
