package com.lanqiao.prev;

import java.util.Scanner;

/**
 * 历届试题 打印十字图
 * 
 * 总结：文字图形
 * 
 * @author Chain
 *
 */
public class Prev02 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		// 初始化数据为false,即代表点'.'
		int len = (n << 2) + 5;
		boolean dat[][] = new boolean[len][len];

		// 从外往内画
		for (int i = 0; i < n + 1; i++) {
			// 依次画外框

			// 边
			int line = i << 1;
			// 角
			int angle = 2;

			// 画四个顶点拐角
			for (int j = 0; j < angle; j++) {
				// 横线
				dat[line + angle][j + line + 1] = true;
				// dat[line + angle][len - 1 - j -line - 1] = true;
				dat[line + angle][len - 2 - j - line] = true;
				dat[len - 1 - line - angle][j + line + 1] = true;
				dat[len - 1 - line - angle][len - 2 - j - line] = true;

				// 竖线
				dat[j + line + 1][line + angle] = true;
				dat[j + line + 1][len - 1 - line - angle] = true;
				dat[len - 1 - line - j - 1][line + angle] = true;
				dat[len - 1 - line - j - 1][len - 1 - line - angle] = true;
			}

			// 画四条边
			for (int j = line + angle; j < len - line - angle; j++) {
				// 横线
				dat[line][j] = true;
				dat[len - 1 - line][j] = true;

				// 竖线
				dat[j][line] = true;
				dat[j][len - 1 - line] = true;
			}

		}

		// 打印出图形
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++)
				if (dat[i][j])
					System.out.print('$');
				else
					System.out.print('.');
			System.out.println();
		}

	}
}
