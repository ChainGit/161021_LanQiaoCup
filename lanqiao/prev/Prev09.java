package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 历届试题 大臣的旅费
 * 
 * 总结：深度优先遍历
 * 
 * @author Chain
 *
 */
@SuppressWarnings("unused")
public class Prev09 {

	// 标记走过的城市
	private boolean[] flag = null;
	// 最远距离
	private int far = 0;
	// 最远的城市A
	private int farestcitya = 0;
	// 最远的城市B
	private int farestcityb = 0;

	public static void main(String[] args) throws Exception {
		// 50分,超时
		// new Prev09().method1();
		// 75分,超时
		// new Prev09().method2();
		// 75分,超时
		new Prev09().method3();
	}

	// 在method2的基础上,存储结构由二维数组转为ArrayList,减少hasWay的遍历时间,另外将Scanner换成BufferedReader,提高输入效率
	// 如果输出的数据较多,查看API文档可知,使用PrintWriter可以提高输出效率.但是有时还是超时,相同的方法C能通过.(哭
	private void method3() throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		int n = new Integer(bufr.readLine());
		int way = n - 1;
		ArrayList<MyRoad> lst = new ArrayList<>();
		for (int i = 0; i < way; i++) {
			// 城市序号在程序中从0开始
			String sbuf = bufr.readLine();
			String[] pbuf = sbuf.split(" ");
			lst.add(new MyRoad(Integer.parseInt(pbuf[0]) - 1, Integer.parseInt(pbuf[1]) - 1,
					Integer.parseInt(pbuf[2])));
		}
		bufr.close();

		flag = new boolean[n];

		// 假设从城市0出发
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
		// hasWay返回的结果是可以到达的未走过城市,或者无路可走
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

		// 无路可走,即走到当前路线上的最远城市
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
			// 不可能出现citya等于cityb,或nowcity既不是citya也不是cityb的情况
			int nextcity = -1;
			if (nowcity == citya)
				nextcity = cityb;
			else if (nowcity == cityb)
				nextcity = citya;
			// 下一个城市是否已经走过
			if (nextcity != -1 && !flag[nextcity])
				res.add(new MyNextCity(nextcity, r.data));
		}

		return res;
	}

	// 树的直径：先由任意顶点X出发,找出距离X最大的节点A,再由A出发,找出距离A最大的节点B,最终可得AB之间的最大距离
	// 相比较于method1,method2无需从每一个顶点出发
	private void method2() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int way = n - 1;
		int[][] road = new int[way][3];
		for (int i = 0; i < way; i++) {
			// 城市序号在程序中从0开始
			road[i][0] = in.nextInt() - 1;
			road[i][1] = in.nextInt() - 1;
			road[i][2] = in.nextInt();
		}
		in.close();

		flag = new boolean[n];

		// 假设从城市0出发
		go(road, 0, true, 0);
		reset(flag);
		go(road, farestcitya, false, 0);

		// System.out.println(farestcitya);
		// System.out.println(farestcityb);

		int cost = 10 * far + (((1 + far) * far) >> 1);
		System.out.println(cost);
	}

	// 找出从nowcity出发的每一条路径的距离,并得出最远的距离和城市
	private void go(int[][] road, int nowcity, boolean which, int farnow) {
		if (flag[nowcity])
			return;

		int res[][] = hasWay(road, nowcity);
		// hasWay返回的结果是可以到达的未走过城市,或者无路可走
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

		// 无路可走,即走到当前路线上的最远城市
		if (i == 0)
			if (far < farnow) {
				far = farnow;
				if (which)
					farestcitya = nowcity;
				else
					farestcityb = nowcity;
			}

	}

	// 深度优先遍历,遍历从每一次城市出发,到达另一个城市的费用,输出最大值
	private void method1() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int way = n - 1;
		int[][] road = new int[way][3];
		for (int i = 0; i < way; i++) {
			// 城市序号在程序中从0开始
			road[i][0] = in.nextInt() - 1;
			road[i][1] = in.nextInt() - 1;
			road[i][2] = in.nextInt();
		}
		in.close();

		flag = new boolean[n];

		// 从某城市i出发
		for (int i = 0; i < n; i++)
			// 到达不重复的另一个城市j
			for (int j = 0; j < n; j++)
				if (i != j) {
					start(road, i, j, 0);
					reset(flag);
				}

		int cost = 10 * far + (((1 + far) * far) >> 1);
		System.out.println(cost);
	}

	// 重置走过的城市标记
	private void reset(boolean[] p) {
		for (int i = 0; i < p.length; i++)
			p[i] = false;
	}

	// 依据题意,满足走过的城市不重复,且已知路径一定唯一
	private void start(int[][] road, int nowcity, int endcity, int farnow) {
		// 当前城市已经走过
		if (flag[nowcity])
			return;

		// 到达目的城市
		if (nowcity == endcity) {
			if (far < farnow)
				far = farnow;
			return;
		}

		// hasWay返回的结果是可以到达的未走过城市,或者无路可走
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

	// 得到当前城市可以到达的下一个城市数组
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
			// 不可能出现citya等于cityb,或nowcity既不是citya也不是cityb的情况
			if (nowcity == citya)
				rawres[j][0] = cityb;
			else if (nowcity == cityb)
				rawres[j][0] = citya;
			// 下一个城市是否已经走过
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

// 为了方便操作,没有设置getters/setters,直接设置public
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