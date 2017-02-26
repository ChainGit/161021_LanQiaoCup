package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * �������� Σ��ϵ��
 * 
 * �ܽ᣺���
 * 
 * @author Chain
 *
 */
public class Prev12 {

	// ��վ��x������վ��y���м���·
	private int num;
	// ���վ���Ƿ�ɴ�(���߹���վ��)
	private boolean[] flag;
	// �洢վ������ͼ,�õ��Ǳ�����洢,��Ҫ��Ϊ�ڽӱ�
	private int[][] road;
	// �ܹ��ж���վ��
	private int n;
	// �ܹ��ж�����ͨ��
	private int m;
	// �ؼ�վ��ĸ���
	private int key;

	public static void main(String[] args) throws Exception {
		// ��һ�����ݳ�ʱ,����80
		new Prev12().method();
	}

	private void method() throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String sbuf = bufr.readLine();
		String[] pbuf = sbuf.split(" ");
		n = new Integer(pbuf[0]);
		m = new Integer(pbuf[1]);
		road = new int[m][2];
		for (int i = 0; i < m; i++) {
			sbuf = bufr.readLine();
			pbuf = sbuf.split(" ");
			road[i][0] = new Integer(pbuf[0]) - 1;
			road[i][1] = new Integer(pbuf[1]) - 1;
		}
		sbuf = bufr.readLine();
		pbuf = sbuf.split(" ");
		int x = new Integer(pbuf[0]) - 1;
		int y = new Integer(pbuf[1]) - 1;
		bufr.close();

		flag = new boolean[n];

		// �����ж������Ƿ���ͨ
		go(x, y, x);
		if (num == 0) {
			System.out.println(-1);
			return;
		}

		// ���˵�x��y��վ��,����վ����������flag[i]Ϊtrue,�൱��ȥ�����վ��
		for (int i = 0; i < n; i++)
			if (i != x && i != y) {
				flag[i] = true;
				num = 0;
				go(x, y, x);
				if (num == 0) {
					// �������ؼ�վ��
					// System.out.println(i + 1);
					key++;
				}
				flag[i] = false;
			}

		System.out.println(key);
	}

	// ÿ�ζ�����DFS����,Ҳ����ջʵ��,�����������ջ�ṹ
	private void go(int x, int y, int now) {
		if (flag[now])
			return;

		if (now == y) {
			num++;
			return;
		}

		int[] res = getNextStations(now);
		for (int i = 0; i < res.length; i++) {
			flag[now] = true;
			go(x, y, res[i]);
			flag[now] = false;
		}
	}

	// ���ؿɵ������һ��վ������
	private int[] getNextStations(int now) {
		ArrayList<Integer> lst = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int a = road[i][0];
			int b = road[i][1];
			int next = -1;
			if (a == now)
				next = b;
			else if (b == now)
				next = a;
			if (next != -1)
				lst.add(next);
		}

		int size = lst.size();
		int[] res = new int[size];
		for (int i = 0; i < size; i++)
			res[i] = lst.get(i);
		return res;
	}
}
