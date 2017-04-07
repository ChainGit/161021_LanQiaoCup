package com.lanqiao.study;

//Çó×Ö·û´®µÄ·´´®
public class Study02a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fun("abcd"));
	}

	private static String fun(String s) {
		if (s.length() <= 1)
			return s;
		return fun(s.substring(1)) + s.charAt(0);
	}

}
