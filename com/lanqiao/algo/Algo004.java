package com.lanqiao.algo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * �㷨ѵ�� ���ѡ��
 * 
 * �������� ��һ�� n ���ڵ����������ÿ���ڵ㶼��һ��������Ȩֵ�����һ���㱻ѡ���ˣ���ô�����Ϻ������ڵĵ㶼���ܱ�ѡ����ѡ���ĵ��Ȩֵ������Ƕ��٣�
 * 
 * �����ʽ ��һ�а���һ������ n ��
 * 
 * ��������һ�а��� n ������������ i ������������� i ��Ȩֵ��
 * 
 * ������һ�� n-1 �У�ÿ���������ϵ�һ���ߡ�
 * 
 * �����ʽ ���һ������������ѡ���ĵ��Ȩֵ�͵����ֵ�� �������� 5 1 2 3 4 5 1 2 1 3 2 4 2 5 ������� 12 ����˵��
 * ѡ��3��4��5�ŵ㣬Ȩֵ��Ϊ 3+4+5 = 12 �� ���ݹ�ģ��Լ�� ����20%�����ݣ� n <= 20��
 * 
 * ����50%�����ݣ� n <= 1000��
 * 
 * ����100%�����ݣ� n <= 100000��
 * 
 * Ȩֵ��Ϊ������1000����������
 * 
 * �ܽ᣺���ζ�̬�滮
 * 
 * @author Chain
 *
 */
public class Algo004 {

	// ժ�ԣ�http://www.cnblogs.com/zhouxiaosong/p/5271068.html
	private final int MAXN = 100001;
	private int M = 0; // ��ʾ�ߵ������ţ���ʼΪ0
	private int head[] = new int[MAXN]; // ��ʾĳ����������ӵı�
	private int dp[][] = new int[MAXN][2]; // dp[x][0]��ʾ��x����㲻ѡ��ʱ���Ȩֵ��dp[x][1]��ʾ��x�����ѡ��ʱ���Ȩֵ
	private ArrayList<Edge> e = new ArrayList<>();// һ����n����㣬��n-1���ߣ����ǲ�ͬ�ĳ������������ͬ�ıߣ�������2n-2����

	public Algo004() {
		for (int i = 0; i < MAXN; i++)
			head[i] = -1;
	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}

	// ���±߼���߼�,������
	private void add(int from, int to) {
		e.add(new Edge(to, head[from]));
		head[from] = M++; // head[x]��ֵ���ܻᱻ���θ�ֵ
	}

	// ����dfs����
	private void dfs(int node, int preNode) {
		for (int i = head[node]; i != -1; i = e.get(i).nextEdge) {
			Edge g = e.get(i);
			if (g.toNode == preNode) // ˵���������Ѿ�������
				continue;
			int toNode = g.toNode; // ��ʾ��i����Ľ��
			dfs(toNode, node);
			dp[node][0] += max(dp[toNode][0], dp[toNode][1]); // �ý�㲻�㣬��ñ��ϵ���һ����ѡҲ�ɲ�ѡ
			dp[node][1] += dp[toNode][0]; // �Ľ��ѡ�ˣ��ñ�����һ���Ͳ���ѡ��
		}
	}

	public static void main(String[] args) {
		new Algo004().method();
	}

	private void method() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 1; i <= n; i++)
			dp[i][1] = in.nextInt(); // ÿһ������Ȩֵ

		for (int j = 1; j <= n - 1; j++) {
			int from = in.nextInt();
			int to = in.nextInt();
			add(from, to);
			add(to, from);
		}
		in.close();

		dfs(1, -1); // ��1�Ž�㿪ʼ���̬�滮
		int result = max(dp[1][0], dp[1][1]); // ��Ϊ��ȷ������㣬���ԴӼ��ſ�ʼ��̬�滮���Ҽ��ŵ�״̬
												// ͬ������Ҳ����д�� dfs(2, 0); int
												// result = max(dp[2][0],
												// dp[2][1]);������ֻ��һ������ʱ��Ͳ�����
		System.out.println(result);
	}

}

class Edge {
	public int toNode; // ��ʾ�����ߵ���Ľ��
	public int nextEdge; // ��ʾ�����ߵĳ���������ӵ���һ����

	public Edge() {

	}

	public Edge(int toNode, int nextEdge) {
		this.toNode = toNode;
		this.nextEdge = nextEdge;
	}
}