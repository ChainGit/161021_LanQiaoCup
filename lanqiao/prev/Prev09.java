package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * �������� �󳼵��÷�
 * 
 * �ܽ᣺������ȱ���
 * 
 * @author Chain
 *
 */
@SuppressWarnings("unused")
public class Prev09 {

	// ����߹��ĳ���
	private boolean[] flag = null;
	// ��Զ����
	private int far = 0;
	// ��Զ�ĳ���A
	private int farestcitya = 0;
	// ��Զ�ĳ���B
	private int farestcityb = 0;

	public static void main(String[] args) throws Exception {
		// 50��,��ʱ
		// new Prev09().method1();
		// 75��,��ʱ
		// new Prev09().method2();
		// 75��,��ʱ
		new Prev09().method3();
	}

	// ��method2�Ļ�����,�洢�ṹ�ɶ�ά����תΪArrayList,����hasWay�ı���ʱ��,���⽫Scanner����BufferedReader,�������Ч��
	// �����������ݽ϶�,�鿴API�ĵ���֪,ʹ��PrintWriter����������Ч��.������ʱ���ǳ�ʱ,��ͬ�ķ���C��ͨ��.(��
	private void method3() throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		int n = new Integer(bufr.readLine());
		int way = n - 1;
		ArrayList<MyRoad> lst = new ArrayList<>();
		for (int i = 0; i < way; i++) {
			// ��������ڳ����д�0��ʼ
			String sbuf = bufr.readLine();
			String[] pbuf = sbuf.split(" ");
			lst.add(new MyRoad(Integer.parseInt(pbuf[0]) - 1, Integer.parseInt(pbuf[1]) - 1,
					Integer.parseInt(pbuf[2])));
		}
		bufr.close();

		flag = new boolean[n];

		// ����ӳ���0����
		begin(lst, 0, true, 0);
		reset(flag);
		begin(lst, farestcitya, false, 0);

		// System.out.println(farestcitya);
		// System.out.println(farestcityb);

		int cost = 10 * far + (((1 + far) * far) >> 1);
		System.out.println(cost);
	}

	private void begin(ArrayList<MyRoad> lst, int nowcity, boolean which, int farnow) {
		if (flag[nowcity])
			return;

		ArrayList<MyNextCity> res = hasWay2(lst, nowcity);
		// hasWay���صĽ���ǿ��Ե����δ�߹�����,������·����
		int i = 0;
		for (; i < res.size(); i++) {
			MyNextCity next = res.get(i);
			int nextcity = next.nextcity;
			int lenway = next.data;
			farnow += lenway;
			flag[nowcity] = true;
			begin(lst, nextcity, which, farnow);
			farnow -= lenway;
			flag[nowcity] = false;
		}

		// ��·����,���ߵ���ǰ·���ϵ���Զ����
		if (i == 0)
			if (far < farnow) {
				far = farnow;
				if (which)
					farestcitya = nowcity;
				else
					farestcityb = nowcity;
			}

	}

	private ArrayList<MyNextCity> hasWay2(ArrayList<MyRoad> lst, int nowcity) {
		int roadlen = lst.size();
		ArrayList<MyNextCity> res = new ArrayList<>();
		for (int i = 0; i < roadlen; i++) {
			MyRoad r = lst.get(i);
			int citya = r.from;
			int cityb = r.to;
			// �����ܳ���citya����cityb,��nowcity�Ȳ���cityaҲ����cityb�����
			int nextcity = -1;
			if (nowcity == citya)
				nextcity = cityb;
			else if (nowcity == cityb)
				nextcity = citya;
			// ��һ�������Ƿ��Ѿ��߹�
			if (nextcity != -1 && !flag[nextcity])
				res.add(new MyNextCity(nextcity, r.data));
		}

		return res;
	}

	// ����ֱ�����������ⶥ��X����,�ҳ�����X���Ľڵ�A,����A����,�ҳ�����A���Ľڵ�B,���տɵ�AB֮���������
	// ��Ƚ���method1,method2�����ÿһ���������
	private void method2() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int way = n - 1;
		int[][] road = new int[way][3];
		for (int i = 0; i < way; i++) {
			// ��������ڳ����д�0��ʼ
			road[i][0] = in.nextInt() - 1;
			road[i][1] = in.nextInt() - 1;
			road[i][2] = in.nextInt();
		}
		in.close();

		flag = new boolean[n];

		// ����ӳ���0����
		go(road, 0, true, 0);
		reset(flag);
		go(road, farestcitya, false, 0);

		// System.out.println(farestcitya);
		// System.out.println(farestcityb);

		int cost = 10 * far + (((1 + far) * far) >> 1);
		System.out.println(cost);
	}

	// �ҳ���nowcity������ÿһ��·���ľ���,���ó���Զ�ľ���ͳ���
	private void go(int[][] road, int nowcity, boolean which, int farnow) {
		if (flag[nowcity])
			return;

		int res[][] = hasWay(road, nowcity);
		// hasWay���صĽ���ǿ��Ե����δ�߹�����,������·����
		int i = 0;
		for (; i < res.length; i++) {
			int nextcity = res[i][0];
			int lenway = res[i][1];
			farnow += lenway;
			flag[nowcity] = true;
			go(road, nextcity, which, farnow);
			farnow -= lenway;
			flag[nowcity] = false;
		}

		// ��·����,���ߵ���ǰ·���ϵ���Զ����
		if (i == 0)
			if (far < farnow) {
				far = farnow;
				if (which)
					farestcitya = nowcity;
				else
					farestcityb = nowcity;
			}

	}

	// ������ȱ���,������ÿһ�γ��г���,������һ�����еķ���,������ֵ
	private void method1() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int way = n - 1;
		int[][] road = new int[way][3];
		for (int i = 0; i < way; i++) {
			// ��������ڳ����д�0��ʼ
			road[i][0] = in.nextInt() - 1;
			road[i][1] = in.nextInt() - 1;
			road[i][2] = in.nextInt();
		}
		in.close();

		flag = new boolean[n];

		// ��ĳ����i����
		for (int i = 0; i < n; i++)
			// ���ﲻ�ظ�����һ������j
			for (int j = 0; j < n; j++)
				if (i != j) {
					start(road, i, j, 0);
					reset(flag);
				}

		int cost = 10 * far + (((1 + far) * far) >> 1);
		System.out.println(cost);
	}

	// �����߹��ĳ��б��
	private void reset(boolean[] p) {
		for (int i = 0; i < p.length; i++)
			p[i] = false;
	}

	// ��������,�����߹��ĳ��в��ظ�,����֪·��һ��Ψһ
	private void start(int[][] road, int nowcity, int endcity, int farnow) {
		// ��ǰ�����Ѿ��߹�
		if (flag[nowcity])
			return;

		// ����Ŀ�ĳ���
		if (nowcity == endcity) {
			if (far < farnow)
				far = farnow;
			return;
		}

		// hasWay���صĽ���ǿ��Ե����δ�߹�����,������·����
		int res[][] = hasWay(road, nowcity);
		for (int i = 0; i < res.length; i++) {
			int nextcity = res[i][0];
			int lenway = res[i][1];
			farnow += lenway;
			flag[nowcity] = true;
			start(road, nextcity, endcity, farnow);
			farnow -= lenway;
			flag[nowcity] = false;
		}

	}

	// �õ���ǰ���п��Ե������һ����������
	private int[][] hasWay(int[][] road, int nowcity) {
		int roadlen = road.length;
		int[][] rawres = new int[roadlen][2];
		for (int i = 0; i < roadlen; i++)
			rawres[i][0] = -1;
		int j = 0;
		for (int i = 0; i < roadlen; i++) {
			int citya = road[i][0];
			int cityb = road[i][1];
			rawres[j][1] = road[i][2];
			// �����ܳ���citya����cityb,��nowcity�Ȳ���cityaҲ����cityb�����
			if (nowcity == citya)
				rawres[j][0] = cityb;
			else if (nowcity == cityb)
				rawres[j][0] = citya;
			// ��һ�������Ƿ��Ѿ��߹�
			int nextcity = rawres[j][0];
			if (nextcity != -1 && flag[nextcity])
				rawres[j][0] = -1;
			if (rawres[j][0] != -1)
				j++;
		}

		int[][] res = new int[j][2];
		for (int i = 0; i < j; i++)
			res[i] = rawres[i];

		return res;
	}
}

// Ϊ�˷������,û������getters/setters,ֱ������public
class MyRoad {
	public int from = -1;
	public int to = -1;
	public int data = -1;

	public MyRoad(int from, int to, int data) {
		this.from = from;
		this.to = to;
		this.data = data;
	}
}

class MyNextCity {
	public int nextcity = -1;
	public int data = 0;

	public MyNextCity(int nextcity, int data) {
		this.nextcity = nextcity;
		this.data = data;
	}
}