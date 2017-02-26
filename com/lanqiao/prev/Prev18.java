package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * �������� �����ἣ
 * 
 * �ܽ᣺���㼸��
 * 
 * @author Chain
 *
 */
@SuppressWarnings("unused")
public class Prev18 {

	// ����ÿ���㻭һ��Բ��ÿһ���߻�һ��ƽ���ߣ�Ȼ�����������ĳ���
	// ƽ���߱ض���˵�Բ����,������ǰ뾶
	// �������ƽ�����ཻ���Բ��ƽ�����ཻ��,ȡ����ʼ�������
	// ��Ҫ���Ǹ߶Ȳ��С�����

	// ���ְ뾶
	private static double r;
	// ����ֱ��
	private static double d;
	// �����߹���·������
	private static double blen;
	// ·���ؼ���
	private static double[][] road;
	// ·���ؼ������
	private static int n;
	// Բ����
	private static double PI;

	public static void main(String[] args) throws Exception {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String[] pbuf = bufr.readLine().split(" ");
		n = new Integer(pbuf[0]);
		r = new Double(pbuf[1]);
		road = new double[n][2];
		for (int i = 0; i < n; i++) {
			pbuf = bufr.readLine().split(" ");
			road[i][0] = new Double(pbuf[0]);
			road[i][1] = new Double(pbuf[1]);
		}
		bufr.close();

		// double����ʹ��'<<'����'>>'
		PI = 4 * Math.atan(1);
		d = r * 2;

		process();

		System.out.printf("%.2f", blen);
		System.out.println();
	}

	// ƽ���߱�Ȼ��Բ����,����е��Լ��е㵽��ʼ��ľ���,�ٵõ�ֱ�߷���,��ֱ�߷��̽���,������ʼ�����,��������ȡ���
	private static void process() {
		// �տ�ʼ��·������·����ƽ��X���,�����ڴ�ֱX���·
		// Բ��ƽ���߱ض�����
		double k1, b1, k2, b2;
		double x1, x2, x3, x4, y1, y2, y3, y4;
		x1 = road[0][0];
		y1 = road[0][1] + r;
		k1 = 0;
		b1 = y1;
		for (int i = 1; i < road.length - 1; i++) {
			double[] poi = null;

			if (!new BigDecimal(k1).equals(new BigDecimal(0))) {
				poi = getTangentPoint(k1, b1, road[i][0], road[i][1]);
				x2 = poi[0];
				y2 = poi[1];
			} else {
				x2 = road[i][0];
				y2 = road[i][1] + r;
			}

			k2 = new BigDecimal((road[i][1] - road[i + 1][1]))
					.divide(new BigDecimal(road[i][0] - road[i + 1][0]), 10, RoundingMode.HALF_UP).doubleValue();
			if (!new BigDecimal(k2).equals(new BigDecimal(0))) {
				poi = getLineByCircle(k2, road[i][0], road[i][1]);
				x4 = poi[0];
				y4 = poi[1];
				b2 = poi[2];
			} else {
				x4 = road[i][0];
				y4 = road[i][1] + r;
				b2 = y4;
			}

			if (!new BigDecimal(Math.abs(k1 - k2)).equals(new BigDecimal(0))) {
				poi = getLineCross(k1, b1, k2, b2);
				x3 = poi[0];
				y3 = poi[1];
			} else {
				return;
			}

			// Ӧ�����Ǹ߶ȹ�С�����,����û�п��ǵ�

			double lena = getPointLength(x1, y1, x2, y2);
			double lenb = getPointLength(x1, y1, x3, y3);
			if (lena < lenb) {
				blen += lena;
				blen += getCircleArcLength(x2, y2, x4, y4);
				x1 = x4;
				y1 = y4;
			} else {
				blen += lenb;
				x1 = x3;
				y1 = y3;
			}
			k1 = k2;
			b1 = b2;
		}
		blen += getPointLength(x1, y1, road[n - 1][0], road[n - 1][1] + r);
	}

	// ��ȡԲ������
	private static double getCircleArcLength(double x1, double y1, double x2, double y2) {
		double side = getPointLength(x1, y1, x2, y2);
		double angle = Math
				.asin(new BigDecimal(side).divide(new BigDecimal(d), 10, RoundingMode.HALF_UP).doubleValue());
		double len = 2 * angle * r;
		return len;
	}

	// �������֮��ľ���
	private static double getPointLength(double x1, double y1, double x2, double y2) {
		double dx = Math.abs(x1 - x2);
		double dy = Math.abs(y1 - y2);
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}

	// �����ֱ���ཻ������
	private static double[] getLineCross(double k1, double b1, double k2, double b2) {
		double x = new BigDecimal(b2 - b1).divide(new BigDecimal(k1 - k2), 10, RoundingMode.HALF_UP).doubleValue();
		double y = x * k1 + b1;
		return new double[] { x, y };
	}

	// �����Բ���е������������ֱ�߷���
	private static double[] getLineByCircle(double k, double hx, double hy) {
		double angle = new BigDecimal(
				Math.atan(new BigDecimal(1).divide(new BigDecimal(Math.abs(k)), 2, RoundingMode.HALF_UP).doubleValue()))
						.doubleValue();
		double dx = Math.cos(angle) * r;
		double dy = Math.sin(angle) * r;
		double x = hx + dx;
		double y = hy + dy;
		if (k > 0)
			x = hx - dx;
		double b2 = y - k * x;
		return new double[] { x, y, b2 };
	}

	// ���ֱ����Բ���е�����
	private static double[] getTangentPoint(double k1, double b1, double hx, double hy) {
		double k2 = -new BigDecimal(1).divide(new BigDecimal(k1), 10, RoundingMode.HALF_UP).doubleValue();
		double b2 = hy - k2 * hx;
		return getLineCross(k1, b1, k2, b2);
	}

}
