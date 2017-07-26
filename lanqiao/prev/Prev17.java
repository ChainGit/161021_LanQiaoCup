package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prev17 {

	// ժ�Թٷ���,����ֵ�ظ��Ŀ�Ƭ,�ٷ���ʹ�ÿռ任ʱ��
	private static int[] card;
	private static int[] chos;
	private static int[][] data;
	private static int[] dlen;

	public static void main(String[] args) throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String[] pbufa = bufr.readLine().split(" ");
		String[] pbufb = bufr.readLine().split(" ");
		bufr.close();

		int cardnum = pbufa.length;
		int chosnum = pbufb.length;
		card = new int[101];
		chos = new int[chosnum];
		data = new int[101][101];
		dlen = new int[101];

		for (int i = 0; i < cardnum; i++) {
			int x = new Integer(pbufa[i]);
			card[x]++;
		}

		// �����������ĳ�ſ����������������ͱ���
		for (int i = 1; i < 101; i++)
			if (card[i] > 0) {
				int k = 0;
				for (int j = 1; j < 101; j++) {
					if (card[j] > 0 && (i % j == 0 || j % i == 0))
						data[i][k++] = j;
				}
				dlen[i] = k;
			}

		for (int i = 0; i < chosnum; i++)
			chos[i] = new Integer(pbufb[i]);

		// ʹ��Arrays�Դ�������Ŀ�������,�ȽϿ��
		Arrays.sort(chos);

		for (int i = 0; i < chosnum; i++) {
			int co = chos[i];
			card[co]--;
			if (dfs(co)) {
				System.out.println(co);
				return;
			}
			card[co]++;
		}
		System.out.println(-1);
	}

	private static boolean dfs(int chos) {
		for (int i = dlen[chos] - 1; i > -1; i--) {
			int t = data[chos][i];
			if (card[t] > 0) {
				card[t]--;
				if (dfs(t)) {
					card[t]++;
					return false;
				}
				card[t]++;
			}
		}
		return true;
	}
}