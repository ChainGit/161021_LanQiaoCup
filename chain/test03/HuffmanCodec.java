package com.chain.test.day03;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 哈夫曼编码实现压缩/解压缩（主要用于ASCII文本，也可以压缩/解压缩其他文件，但效果不一定好）
 * 
 * @author chain qian
 * @version 1.1
 *
 */
public class HuffmanCodec {

	/**
	 * 哈夫曼数据信息：<br>
	 * "encodeData"：加密后的数据<br>
	 * "encodeLength"：加密后的数据的长度(bit为单位)<br>
	 * "originData"：加密前的数据（原数据的引用）<br>
	 * "orginLength"：加密前的数据的长度(bit为单位)<br>
	 * "encodeRate"：压缩比<br>
	 * "table"：构建的哈夫曼表，用于压缩(包含字符数值，出现次数，哈夫曼码)<br>
	 * "tree"：构建的哈夫曼树<br>
	 * "height"：哈夫曼树的高度<br>
	 */
	public static class HuffmanData {

		private HuffmanData() {
		}

		private byte[] encodeData;
		private long encodeLength;
		private byte[] originData;
		private long originLength;
		private double encodeTimes;
		private Map<Integer, TreeNode> table;
		private TreeNode tree;
		private int height;

		public String detail() {
			return detail(true);
		}

		public String detail(boolean detail) {
			if (table == null || tree == null)
				return "empty huffman data";
			String nl = System.getProperty("line.separator");
			StringBuffer sb = new StringBuffer();
			if (detail) {
				sb.append("huffman-tree-height: " + height + nl);
				sb.append("huffman-statistics-table: " + nl);
				int i = 0;
				for (TreeNode n : table.values())
					sb.append((i++) + ", key: " + n.name + ", times: " + n.val + nl);
			}
			sb.append("origin-data-length: " + originLength + nl);
			sb.append("encode-data-length: " + encodeLength + nl);
			sb.append("encode-times: " + encodeTimes + nl);
			sb.append("encode-percent: "
					+ new BigDecimal(1).divide(new BigDecimal(encodeTimes), 2, RoundingMode.HALF_UP).doubleValue());
			return sb.toString();
		}

		@Override
		public String toString() {
			return detail(false);
		}
	}

	// 位数据输入缓存
	private static class BitArrayInputBuffer {
		// 存储bit数据的byte数组
		private byte[] data;
		// 当前读取的数据的下标
		private long cursor;
		// 真实数据的上限
		private long limit;

		private BitArrayInputBuffer(byte[] data, long limit) {
			if (data == null || data.length < 1)
				throw new RuntimeException("error bit array data");
			int blen = (int) (limit >>> 3);
			blen = ((limit & 7) == 0) ? blen : blen + 1;
			if (blen > Integer.MAX_VALUE - 1 || blen != data.length)
				throw new RuntimeException("error bit array data length");
			this.data = data;
			this.limit = limit;
		}

		private static final byte END = -1;

		// 按bit位读取，如果读到了末尾则返回-1
		public byte get() {
			if (cursor > limit - 1)
				return END;

			int current = (int) (cursor >>> 3);
			int offset = 7 - (int) (cursor & 7);
			cursor++;
			return (byte) ((data[current] >>> offset) & 0x01);
		}
	}

	// 位数据输出缓存（bit buffer）
	private static class BitArrayOutputBuffer {

		private static final int DEFAULT_CAPACITY = 32;

		// 存储bit数据的byte数组
		private byte[] data;
		// 真正的位数据长度（也是指向下一个add操作的空位置）
		private long cursor;

		private BitArrayOutputBuffer() {
			this.data = new byte[DEFAULT_CAPACITY];
		}

		private BitArrayOutputBuffer(long capacity) {
			int blen = (int) ((capacity >>> 3) + 1);
			if (blen > Integer.MAX_VALUE - 1)
				throw new RuntimeException("cannot support so long length");
			this.data = new byte[blen];
		}

		// 只将byte的最后一位接在data的cursor处
		public void add(byte i) {
			if (i > 1)
				throw new RuntimeException("byte can only be 0 (0x00) or 1 (0x01)");

			ensureCapacity();

			int current = (int) (cursor >>> 3);
			int offset = 7 - (int) (cursor & 7);

			data[current] |= i << offset;

			cursor++;
		}

		public byte[] getData() {
			int clen = (int) (cursor >>> 3);
			clen = ((cursor & 7) == 0) ? clen : clen + 1;
			return Arrays.copyOf(data, clen);
		}

		public long getBitDataLength() {
			return cursor;
		}

		private void ensureCapacity() {
			int clen = (int) ((cursor >>> 3) + 1);
			// 数组下标最多支持32位的int
			if (clen > Integer.MAX_VALUE - 1)
				throw new RuntimeException("cannot add one bit data any more, it is already full");
			// 两倍扩展
			else if (clen == data.length)
				data = Arrays.copyOf(data, data.length << 1);
		}
	}

	// 哈夫曼的算法，计算机存储以字节（8bit）为单位
	private static class Huffman {

		private HuffmanData data;

		public Huffman(byte[] src) {
			if (src == null || src.length < 1)
				throw new RuntimeException("src is null or empty");
			else if (src.length > Integer.MAX_VALUE - 1)
				throw new RuntimeException("src is too long");
			data = new HuffmanData();
			data.originData = src;
			data.originLength = src.length << 3;
		}

		public Huffman(HuffmanData data) {
			this.data = data;
		}

		private Huffman() {

		}

		// 统计各个字符出现的次数
		private void count() {
			Map<Integer, TreeNode> table = new HashMap<>();
			byte[] src = data.originData;
			int srcLen = src.length;
			for (int i = 0; i < srcLen; i++) {
				int t = src[i] & 0xff;
				if (table.get(t) == null)
					table.put(t, new TreeNode(t, 1));
				else
					table.get(t).val++;
			}
			if (table.size() == 1)
				throw new RuntimeException("there is only one type of ascii characters, huffman is not required");
			data.table = table;
		}

		private static final int DEFAULT = -1;

		// 构建Huffman树
		private void build() {
			Map<Integer, TreeNode> table = data.table;
			LinkedList<TreeNode> tlst = new LinkedList<>();
			for (TreeNode n : table.values())
				tlst.add(n);
			sort(tlst);
			// 最终的huffman树的结点数为2*n-1
			// 霍夫曼树的结点的孩子只有0和2这两种情况
			while (tlst.size() > 1) {
				// 每次取前两个
				TreeNode n1 = tlst.pop();
				TreeNode n2 = tlst.pop();
				TreeNode tn = new TreeNode(DEFAULT, n1.val + n2.val);
				tn.left = n1;
				tn.right = n2;
				// 这里有两种方式，采用图中(a)的方式，编成的霍夫曼码更加均匀
				boolean isSet = false;
				for (int i = 0; i < tlst.size(); i++)
					if (tlst.get(i).val > tn.val) {
						tlst.add(i, tn);
						isSet = true;
						break;
					}
				if (!isSet)
					tlst.add(tn);
			}
			data.tree = tlst.poll();
		}

		private void sort(List<TreeNode> lst) {
			Collections.sort(lst, (n1, n2) -> {
				return n1.val - n2.val;
			});
		}

		// 根据huffman树获得对应的编码
		private void road() {
			// 前序遍历，左0右1
			// 树的结点，层数，上一层的码，方向
			fun(data.tree, 0, null, 0);
			data.height++;
		}

		// 霍夫曼码的任意一个后置的码都不是前面任意码的前缀
		private void fun(TreeNode node, int level, byte[] last, int type) {
			if (data.height < level)
				data.height = level;
			byte[] code = node.code;
			if (code == null)
				code = node.code = new byte[level];
			if (last != null)
				for (int i = 0; i < code.length - 1; i++)
					code[i] = last[i];
			if (code.length > 0)
				code[code.length - 1] = (byte) type;
			// 要么两个孩子结点要么没有孩子结点
			if (node.left == null && node.right == null)
				return;
			fun(node.left, level + 1, code, 0);
			fun(node.right, level + 1, code, 1);
		}

		private HuffmanData encode() {
			count();
			build();
			road();
			doEncode();
			return data;
		}

		private void doEncode() {
			BitArrayOutputBuffer baobuf = new BitArrayOutputBuffer();
			byte[] originData = data.originData;
			Map<Integer, TreeNode> table = data.table;
			for (byte c : originData) {
				byte[] code = table.get(c & 0xff).code;
				for (byte i : code)
					baobuf.add(i);
			}
			data.encodeData = baobuf.getData();
			data.encodeLength = baobuf.getBitDataLength();
			// Java的数组下标最多只能支持32位的int
			if (data.encodeData.length > Integer.MAX_VALUE - 1)
				throw new RuntimeException("data length is out of range");
			data.encodeTimes = new BigDecimal(data.originLength)
					.divide(new BigDecimal(data.encodeLength), 2, RoundingMode.HALF_UP).doubleValue();
		}

		private byte[] decode() {
			// 哈夫曼树
			TreeNode root = data.tree;
			// 依次读取，遇到0则读取树的左孩子，1则读取树的右孩子，读到叶子结点则记录下数值，并重复过程。
			BitArrayInputBuffer baibuf = new BitArrayInputBuffer(data.encodeData, data.encodeLength);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// 这里只能使用int型作为数组的下标，不考虑分块处理
			TreeNode node = root;
			TreeNode pnode = null;
			byte b = -1;
			while ((b = baibuf.get()) != -1) {
				pnode = node;
				if (b == 0)
					node = node.left;
				else
					node = node.right;
				// 到了叶子结点
				if (node == null) {
					baos.write((byte) (pnode.name & 0xff));
					baibuf.cursor--;
					node = root;
					pnode = null;
				}
			}
			// 最后一个码字
			baos.write((byte) (node.name & 0xff));
			return baos.toByteArray();
		}

		/**
		 * 数据的结构：
		 * 
		 * 1、哈夫曼表的字符总数（2个字节）（也是表的长度）<br>
		 * 2、哈夫曼表（每行：2个字节（字符）+4个字节（出现的次数））<br>
		 * 3、压缩的数据最后一个字节多余的bit位的数量<br>
		 * 4、压缩的数据<br>
		 * 
		 */

		// 保存哈夫曼表的部分数据和编码后的压缩数据
		public byte[] encodeToBytes() {
			encode();
			Map<Integer, TreeNode> table = data.table;
			byte[] total = intToTwoBytes(table.size());
			byte[] ntable = new byte[6 * table.size()];
			int num = 0;
			for (TreeNode n : table.values()) {
				byte[] name = intToTwoBytes(n.name);
				for (int i = 0; i < 2; i++)
					ntable[6 * num + i] = name[i];
				byte[] times = intToFourBytes(n.val);
				for (int i = 0; i < 4; i++)
					ntable[6 * num + 2 + i] = times[i];
				num++;
			}
			byte[] encodeData = data.encodeData;
			// 数据后面多余的0的个数
			byte uselessZero = (byte) (((encodeData.length << 3) - data.encodeLength) & 0xff);
			// 连接成整体
			long outLen = total.length + ntable.length + encodeData.length + 1;
			if (outLen > Integer.MAX_VALUE - 1)
				throw new RuntimeException("data is out of range");
			byte[] out = new byte[(int) outLen];
			int cursor = 0;
			int i;
			for (i = 0; i < total.length; i++)
				out[cursor++] = total[i];
			for (i = 0; i < ntable.length; i++)
				out[cursor++] = ntable[i];
			out[cursor++] = uselessZero;
			for (i = 0; i < encodeData.length; i++)
				out[cursor++] = encodeData[i];
			return out;
		}

		private byte[] intToTwoBytes(int i) {
			byte[] c = new byte[2];
			c[1] = (byte) (i & 0xff);
			c[0] = (byte) ((i >>> 8) & 0xff);
			return c;
		}

		private byte[] intToFourBytes(int i) {
			return intToBytes(i);
		}

		private byte[] intToBytes(int i) {
			byte[] c = new byte[4];
			c[3] = (byte) (i & 0xff);
			c[2] = (byte) ((i >>> 8) & 0xff);
			c[1] = (byte) ((i >>> 16) & 0xff);
			c[0] = (byte) ((i >>> 24) & 0xff);
			return c;
		}

		public byte[] decodeFromBytes(byte[] src) {
			if (src.length < 2)
				throw new RuntimeException("error input data");
			else if (src.length > Integer.MIN_VALUE - 1)
				throw new RuntimeException("data is too long");
			int cursor = 0;
			int tableLen = ((src[cursor++] & 0xff) << 8) | (src[cursor++] & 0xff);
			int headLen = tableLen * 6 + 3;
			if (src.length < headLen)
				throw new RuntimeException("error input data");
			Map<Integer, TreeNode> table = new HashMap<>();
			// 解析数据头部
			while (cursor < headLen - 1) {
				int name = ((src[cursor++] << 8) & 0xff) | (src[cursor++] & 0xff);
				int times = ((src[cursor++] & 0xff) << 24) | ((src[cursor++] & 0xff) << 16)
						| ((src[cursor++] & 0xff) << 8) | (src[cursor++] & 0xff);
				table.put(name, new TreeNode(name, times));
			}
			data = new HuffmanData();
			data.table = table;
			// 重构Huffman树
			build();
			int uselessZero = src[cursor] & 0xff;
			data.encodeData = Arrays.copyOfRange(src, headLen, src.length);
			data.encodeLength = ((src.length - headLen) << 3) - uselessZero;
			// 解码
			return decode();
		}

	}

	private static class TreeNode {
		// 字符的数值
		private int name;
		// 字符出现次数
		private int val;
		// 字符的huffman码
		private byte[] code;

		private TreeNode left;
		private TreeNode right;

		public TreeNode(int name, int val) {
			this.name = name;
			this.val = val;
		}
	}

	/**
	 * 压缩
	 * 
	 * @param src
	 *            原始数据
	 * @return 压缩后的数据和信息
	 */
	public static HuffmanData encode(byte[] src) {
		return new HuffmanCodec.Huffman(src).encode();
	}

	/**
	 * 压缩
	 * 
	 * @param src
	 *            原始数据
	 * @return 压缩后的数据
	 */
	public static byte[] encodeToBytes(byte[] src) {
		return new HuffmanCodec.Huffman(src).encodeToBytes();
	}

	/**
	 * 解压缩
	 * 
	 * @param src
	 *            压缩后的数据和信息
	 * @return 解压缩后的数据
	 */
	public static byte[] decode(HuffmanData src) {
		return new HuffmanCodec.Huffman(src).decode();
	}

	/**
	 * 解压缩
	 * 
	 * @param src
	 *            压缩后的数据和信息
	 * @return 解压缩后的数据
	 */
	public static byte[] decodeFromBytes(byte[] src) {
		return new HuffmanCodec.Huffman().decodeFromBytes(src);
	}
}
