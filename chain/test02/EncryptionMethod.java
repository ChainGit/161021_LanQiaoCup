package com.chain.part1.tool00.utils;

import com.chain.part1.tool01.encrypts.DES;
import com.chain.part1.tool01.encrypts.MD5;

/**
 * 一些常见加密解密算法，包括<i>DES</i>
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
	 * DES加密
	 * 
	 * @param data
	 *            需要加密的字符串
	 * @param firstKey
	 *            第一个密钥(不能为null)
	 * @param secondKey
	 *            第二个密钥(可以为null)
	 * @param thirdKey
	 *            第三个密钥(可以为null)
	 * @return 加密后的字符串
	 */
	public static String desEnc(String data, String firstKey, String secondKey, String thirdKey) {
		return new DES().strEnc(data, firstKey, secondKey, thirdKey);
	}

	/**
	 * DES解密
	 * 
	 * @param data
	 *            需要解密的字符串
	 * @param firstKey
	 *            第一个密钥(不能为null)
	 * @param secondKey
	 *            第二个密钥(可以为null)
	 * @param thirdKey
	 *            第三个密钥(可以为null)
	 * @return 解密后的字符串
	 */
	public static String desDec(String data, String firstKey, String secondKey, String thirdKey) {
		return new DES().strDec(data, firstKey, secondKey, thirdKey);
	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 *            需要加密的字符串
	 * @return 加密后的字符串
	 */
	public static String md5Enc(String data) {
		return new MD5().md5Enc(data);
	}

}
