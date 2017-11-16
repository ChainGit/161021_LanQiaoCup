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
 * @author chain
 *
 */
public class HuffmanCodecTest {

	@Test
	public void test() throws IOException {

		String str = null;

		// 1种字符
		// str = "aaaaaaaaaaa";

		// 2种字符
		str = "11a11aa1aa1a111aaa";

		test1(str, true);
		System.out.println();

		test2(str, true);
		System.out.println();

		str = "我和他说你很好，他和我说你很好，他和你说我很好，我和你说他很好，你和我说他很好，你和他说我很好，"
				+ "你很好，我很好，她很好，他和我很好，你和我很好，你和他很好，他和我很好，他和你很好，我和你很好，我和他很好，"
				+ "你和他和他很好，我和他和他很好，他和你和你很好，他和我和他很好，很好很好很好很好很好很好很好很好很好很好很好，"
				+ "好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好好";

		test1(str, true);
		System.out.println();

		test2(str, true);
		System.out.println();

		// 文件测试
		String file = null;

		// 123abc
		file = "C:\\Temps\\huffman_test\\test.txt";
		System.out.println(file);

		test3(file, true);
		System.out.println();

		test4(file, true);
		System.out.println();

		// 纯数字字符和'-'
		file = "C:\\Temps\\huffman_test\\数字.txt";
		System.out.println(file);

		test3(file, false);
		System.out.println();

		test4(file, false);
		System.out.println();

		// 英文书籍
		file = "C:\\Temps\\huffman_test\\圣经.txt";
		System.out.println(file);

		test3(file, false);
		System.out.println();

		test4(file, false);
		System.out.println();

		// 英文书籍
		file = "C:\\Temps\\huffman_test\\简爱.txt";
		System.out.println(file);

		test3(file, false);
		System.out.println();

		test4(file, false);
		System.out.println();

		// 图片（jpg）
		file = "C:\\Temps\\huffman_test\\test.jpg";
		System.out.println(file);

		test3(file, false);
		System.out.println();

		test4(file, false);
		System.out.println();

		// 图片（bmp）
		file = "C:\\Temps\\huffman_test\\test.bmp";
		System.out.println(file);

		test3(file, false);
		System.out.println();

		test4(file, false);
		System.out.println();

		// 视频(mp4)
		file = "C:\\Temps\\huffman_test\\test.mp4";
		System.out.println(file);

		test3(file, false);
		System.out.println();

		test4(file, false);
		System.out.println();

		// 程序(exe)
		file = "C:\\Temps\\huffman_test\\test.exe";
		System.out.println(file);

		test3(file, false);
		System.out.println();

		test4(file, false);
		System.out.println();

		// 压缩文件(zip)
		file = "C:\\Temps\\huffman_test\\test.zip";
		System.out.println(file);

		test3(file, false);
		System.out.println();

		test4(file, false);
		System.out.println();

		// pdf
		file = "C:\\Temps\\huffman_test\\test.pdf";
		System.out.println(file);

		test3(file, false);
		System.out.println();

		test4(file, false);
		System.out.println();

		// 最糟糕的情况
		System.out.println("worst test");
		test5();
	}

	private void test5() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for (int i = 0; i < 256; i++)
			baos.write((byte) (i & 0xff));
		byte[] src = baos.toByteArray();

		HuffmanData data = HuffmanCodec.encode(src);
		byte[] decode = HuffmanCodec.decode(data);

		System.out.println(data);

		System.out.println("decode-data-length: " + (decode.length << 3));
	}

	public void test1(String str, boolean show) {
		if (show) {
			System.out.print("orgin string: ");
			System.out.println(str);
		}

		HuffmanData data = HuffmanCodec.encode(str.getBytes());
		byte[] decode = HuffmanCodec.decode(data);

		if (show) {
			System.out.print("decode string: ");
			System.out.println(new String(decode));
		}

		System.out.println(data);

		System.out.println("decode-data-length: " + (decode.length << 3));
	}

	public void test2(String str, boolean show) {
		byte[] src = str.getBytes();
		long orginLength = src.length << 3;

		if (show) {
			System.out.print("orgin string: ");
			System.out.println(str);
		}

		byte[] data = HuffmanCodec.encodeToBytes(src);
		long encodeLength = data.length << 3;
		byte[] decode = HuffmanCodec.decodeFromBytes(data);

		if (show) {
			System.out.print("decode string: ");
			System.out.println(new String(decode));
		}

		double encodeTimes = new BigDecimal(orginLength).divide(new BigDecimal(encodeLength), 2, RoundingMode.HALF_UP)
				.doubleValue();
		String nl = System.getProperty("line.separator");
		System.out.println("origin-data-length: " + orginLength + nl + "encode-data-length: " + encodeLength + nl
				+ "encode times: " + encodeTimes + nl + "encode percent: "
				+ new BigDecimal(1).divide(new BigDecimal(encodeTimes), 2, RoundingMode.HALF_UP).doubleValue());

		System.out.println("decode-data-length: " + (decode.length << 3));
	}

	public void test3(String file, boolean show) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte[] buf = new byte[1024 * 8];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = -1;
		while ((len = bis.read(buf)) != -1)
			baos.write(buf, 0, len);
		bis.close();

		byte[] src = baos.toByteArray();

		if (show) {
			System.out.print("orgin string: ");
			System.out.println(new String(src));
		}

		HuffmanData data = HuffmanCodec.encode(src);
		byte[] decode = HuffmanCodec.decode(data);

		if (show) {
			System.out.print("decode string: ");
			System.out.println(new String(decode));
		}

		int dot = file.lastIndexOf('.');

		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(new File(file + "_huffman_test4_" + (dot == -1 ? "" : file.substring(dot)))));
		bos.write(decode);
		bos.flush();
		bos.close();

		System.out.println(data);

		System.out.println("decode-data-length: " + (decode.length << 3));
	}

	public void test4(String file, boolean show) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte[] buf = new byte[1024 * 8];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = -1;
		while ((len = bis.read(buf)) != -1)
			baos.write(buf, 0, len);
		bis.close();

		byte[] src = baos.toByteArray();
		long orginLength = src.length << 3;

		if (show) {
			System.out.print("orgin string: ");
			System.out.println(new String(src));
		}

		byte[] data = HuffmanCodec.encodeToBytes(src);
		long encodeLength = data.length << 3;

		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(new File(file + "_huffman_test3.huffman")));
		bos.write(data);
		bos.flush();
		bos.close();

		///////////////////////////////////////

		bis = new BufferedInputStream(new FileInputStream(file + "_huffman_test3.huffman"));
		buf = new byte[1024 * 8];
		baos = new ByteArrayOutputStream();
		len = -1;
		while ((len = bis.read(buf)) != -1)
			baos.write(buf, 0, len);
		bis.close();

		src = baos.toByteArray();
		long encodeSaveLength = src.length << 3;
		if (encodeLength != encodeSaveLength)
			throw new RuntimeException("error huffman data file");

		byte[] decode = HuffmanCodec.decodeFromBytes(src);

		if (show) {
			System.out.print("decode string: ");
			System.out.println(new String(decode));
		}

		int dot = file.lastIndexOf('.');

		bos = new BufferedOutputStream(
				new FileOutputStream(new File(file + "_huffman_test3_" + (dot == -1 ? "" : file.substring(dot)))));
		bos.write(decode);
		bos.flush();
		bos.close();

		double encodeTimes = new BigDecimal(orginLength).divide(new BigDecimal(encodeLength), 2, RoundingMode.HALF_UP)
				.doubleValue();
		String nl = System.getProperty("line.separator");
		System.out.println("origin-data-length: " + orginLength + nl + "encode-data-length: " + encodeLength + nl
				+ "encode times: " + encodeTimes + nl + "encode percent: "
				+ new BigDecimal(1).divide(new BigDecimal(encodeTimes), 2, RoundingMode.HALF_UP).doubleValue());

		System.out.println("decode-data-length: " + (decode.length << 3));
	}

}
