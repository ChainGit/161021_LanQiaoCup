package com.chain.part1.tool00.utils;

import com.chain.part1.tool01.encrypts.DES;
import com.chain.part1.tool01.encrypts.MD5;

/**
 * һЩ�������ܽ����㷨������<i>DES</i>
 * 
 * @author Chain
 *
 */
public class EncryptionMethod {

	public static void main(String[] args) {
		// des test
		String s1 = null;
		s1 = desEnc("test", "k1", "k2", "k3");
		System.out.println(s1);
		System.out.println(desDec(s1, "k1", "k2", "k3"));

		// md5 test
		System.out.println(md5Enc("test"));

	}

	/**
	 * DES����
	 * 
	 * @param data
	 *            ��Ҫ���ܵ��ַ���
	 * @param firstKey
	 *            ��һ����Կ(����Ϊnull)
	 * @param secondKey
	 *            �ڶ�����Կ(����Ϊnull)
	 * @param thirdKey
	 *            ��������Կ(����Ϊnull)
	 * @return ���ܺ���ַ���
	 */
	public static String desEnc(String data, String firstKey, String secondKey, String thirdKey) {
		return new DES().strEnc(data, firstKey, secondKey, thirdKey);
	}

	/**
	 * DES����
	 * 
	 * @param data
	 *            ��Ҫ���ܵ��ַ���
	 * @param firstKey
	 *            ��һ����Կ(����Ϊnull)
	 * @param secondKey
	 *            �ڶ�����Կ(����Ϊnull)
	 * @param thirdKey
	 *            ��������Կ(����Ϊnull)
	 * @return ���ܺ���ַ���
	 */
	public static String desDec(String data, String firstKey, String secondKey, String thirdKey) {
		return new DES().strDec(data, firstKey, secondKey, thirdKey);
	}

	/**
	 * MD5����
	 * 
	 * @param data
	 *            ��Ҫ���ܵ��ַ���
	 * @return ���ܺ���ַ���
	 */
	public static String md5Enc(String data) {
		return new MD5().md5Enc(data);
	}

}
