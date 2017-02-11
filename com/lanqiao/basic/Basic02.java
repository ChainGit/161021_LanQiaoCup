package com.lanqiao.basic;

/**
 * 基础练习 01字串
 * 
 * 总结：嵌套循环
 * 
 * @author Lenovo
 *
 */
public class Basic02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
	}

	// 五层循环
	public static void method1() {
		for (int a = 0; a < 2; a++) {
			for (int b = 0; b < 2; b++) {
				for (int c = 0; c < 2; c++) {
					for (int d = 0; d < 2; d++) {
						for (int e = 0; e < 2; e++)
							// System.out.println(a+""+b+""+c+""+d+""+e);
							System.out.println(new String(new char[] { (char) (a + 48), (char) (b + 48),
									(char) (c + 48), (char) (d + 48), (char) (e + 48) }));
					}
				}
			}
		}
	}

	// 偷懒法
	public static void method2() {
		String s = null;
		for (int i = 0; i < 32; i++) {
			s = Integer.toBinaryString(i);
			while (s.length() < 5)
				s = "0" + s;
			System.out.println(s);
		}
	}

}
