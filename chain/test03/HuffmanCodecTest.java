package com.chain.test.day03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.chain.test.day03.HuffmanCodec.HuffmanData;

/**
 * Huffman编码压缩/解压缩的测试
 * 
 * Java中的char是占两个字节，和utf-16e对应
 * 
 * @author chain
 *
 */
public class HuffmanCodecTest {

	@Test
	public void test() throws IOException {
		test1();
		System.out.println();

		test2();
		System.out.println();

		// 纯ASCII字符的TXT文件
		String file = null;

		file = "C:\\Temps\\test.txt";

		test3(file, true);
		System.out.println();

		test4(file, true);
		System.out.println();

		file = "C:\\Temps\\圣经.txt";

		test3(file, false);
		System.out.println();

		test4(file, false);
		System.out.println();
	}

	public void test1() {
		String str = "1223abc21abccba112333aabcbba221bba11122333aabbccbcbcbcbaaaa1233321";// 6种字符
		System.out.print("orgin string: ");
		System.out.println(str);
		HuffmanData data = HuffmanCodec.encode(str.toCharArray());
		char[] decode = HuffmanCodec.decode(data);
		System.out.print("decode string: ");
		System.out.println(new String(decode));

		System.out.println(data);
	}

	public void test2() {
		String str = "1223abc21abccba112333aabcbba221bba11122333aabbccbcbcbcbaaaa1233321";// 6种字符
		long orginLength = str.length() << 4;
		System.out.print("orgin string: ");
		System.out.println(str);
		byte[] data = HuffmanCodec.encodeToBytes(str.toCharArray());
		long encodeLength = data.length;
		char[] decode = HuffmanCodec.decodeFromBytes(data);
		System.out.print("decode string: ");
		System.out.println(new String(decode));

		double encodeTimes = new BigDecimal(orginLength).divide(new BigDecimal(encodeLength), 2, RoundingMode.HALF_UP)
				.doubleValue();
		System.out.println("orgin-data-length: " + orginLength + ", encode-data-length: " + encodeLength
				+ ", encode times: " + encodeTimes + ", encode percent: "
				+ new BigDecimal(1).divide(new BigDecimal(encodeTimes), 2, RoundingMode.HALF_UP).doubleValue());
	}

	public void test3(String file, boolean show) throws IOException {
		// ANSI编码的TXT文件，纯ASCII字符
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte[] buf = new byte[1024 * 8];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = -1;
		while ((len = bis.read(buf)) != -1)
			baos.write(buf, 0, len);
		bis.close();

		byte[] bytes = baos.toByteArray();
		String str = new String(bytes);

		if (show) {
			System.out.print("orgin string: ");
			System.out.println(str);
		}

		char[] src = str.toCharArray();
		long orginLength = src.length << 4;
		byte[] data = HuffmanCodec.encodeToBytes(src);
		long encodeLength = data.length;

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("C:\\Temps\\huffman.data")));
		bos.write(data);
		bos.flush();
		bos.close();

		///////////////////////////////////////

		bis = new BufferedInputStream(new FileInputStream("C:\\Temps\\huffman.data"));
		buf = new byte[1024 * 8];
		baos = new ByteArrayOutputStream();
		len = -1;
		while ((len = bis.read(buf)) != -1)
			baos.write(buf, 0, len);
		bis.close();

		bytes = baos.toByteArray();
		long encodeSaveLength = bytes.length;
		if (encodeLength != encodeSaveLength)
			throw new RuntimeException("error huffman data file");

		char[] decode = HuffmanCodec.decodeFromBytes(bytes);

		if (show) {
			System.out.print("decode string: ");
			System.out.println(new String(decode));
		}

		double encodeTimes = new BigDecimal(orginLength).divide(new BigDecimal(encodeLength), 2, RoundingMode.HALF_UP)
				.doubleValue();
		System.out.println("orgin-data-length: " + orginLength + ", encode-data-length: " + encodeLength
				+ ", encode times: " + encodeTimes + ", encode percent: "
				+ new BigDecimal(1).divide(new BigDecimal(encodeTimes), 2, RoundingMode.HALF_UP).doubleValue());
	}

	public void test4(String file, boolean show) throws IOException {
		// ANSI编码的TXT文件，纯ASCII字符
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte[] buf = new byte[1024 * 8];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = -1;
		while ((len = bis.read(buf)) != -1)
			baos.write(buf, 0, len);
		bis.close();

		String str = new String(baos.toByteArray());

		if (show) {
			System.out.print("orgin string: ");
			System.out.println(str);
		}

		HuffmanData data = HuffmanCodec.encode(str.toCharArray());
		char[] decode = HuffmanCodec.decode(data);

		if (show) {
			System.out.print("decode string: ");
			System.out.println(new String(decode));
		}

		System.out.println(data);
	}
}
