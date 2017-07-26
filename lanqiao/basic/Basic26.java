package com.lanqiao.basic;

import java.util.Scanner;

/**
 * ������ϰ ��ʱ����
 * 
 * ��������<br>
 * ������ǰ��ʱ�䣬����Ӣ�ĵĶ���������������<br>
 * ʱ����ʱh�ͷ�m��ʾ����Ӣ�ĵĶ����У���һ��ʱ��ķ����ǣ�<br>
 * ���mΪ0����ʱ��������Ȼ����ϡ�o'clock������3:00������three o'clock����<br>
 * ���m��Ϊ0����ʱ��������Ȼ�󽫷ֶ���������5:30������five thirty����<br>
 * ʱ�ͷֵĶ���ʹ�õ���Ӣ�����ֵĶ���������0~20������<br>
 * 0:zero, 1: one, 2:two, 3:three, 4:four, 5:five, 6:six, 7:seven, 8:eight,
 * 9:nine, 10:ten, 11:eleven, 12:twelve,<br>
 * 13:thirteen, 14:fourteen, 15:fifteen, 16:sixteen, 17:seventeen, 18:eighteen,
 * 19:nineteen, 20:twenty��<br>
 * 30����thirty��40����forty��50����fifty��<br>
 * ���ڴ���20С��60�����֣����ȶ���ʮ������Ȼ���ټ��ϸ�λ������31���ȶ�30�ټ�1�Ķ�����������thirty one����<br>
 * ������Ĺ���21:54������twenty one fifty four����9:07������nine seven����0:15������zero
 * fifteen����<br>
 * �����ʽ<br>
 * ������������Ǹ�����h��m����ʾʱ���ʱ�ͷ֡����������ǰû��ǰ��0��hС��24��mС��60��<br>
 * �����ʽ<br>
 * ���ʱ��ʱ�̵�Ӣ�ġ�<br>
 * ��������<br>
 * 0 15<br>
 * �������<br>
 * zero fifteen<br>
 * 
 * <b>ע��VIP����,δ������,����֤��ȷ�� (��</b><br>
 * 
 * �ܽ᣺�ַ��� �����ж�
 * 
 * @author Chain
 *
 */
public class Basic26 {

	private static final String[] ts = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen", "twenty", "thirty", "forty", "fifty" };// 21 22 23

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		in.close();

		System.out.println(h + ":" + m);

		System.out.print(ts[h] + " ");
		if (m < 20)
			System.out.println(ts[m]);
		else {
			System.out.print(ts[20 + (m - 20) / 10] + " ");
			System.out.println(ts[m % 10]);
		}
	}

}
