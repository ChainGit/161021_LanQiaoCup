package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 历届试题 横向打印二叉树
 * 
 * 总结：排序二叉树
 * 
 * @author Chain
 *
 */
@SuppressWarnings("unused")
public class Prev11 {

	// 首先需要建立排序二叉树,再将信息转为二维数组,最后根据二维数组打印树
	public static void main(String[] args) throws Exception {
		// new Prev11().method1();
		new Prev11().method2();
	}

	private int flag[] = new int[1000];
	private int tree[] = new int[1000];
	// 前缀
	private String prefix[] = new String[10000];
	// 右中左遍历
	private final int MAX = 100000000;

	// 直接上一个超级大的一维数组,考虑到 N<100,且每个数字不超过10000
	private void method2() throws IOException {
		for (int i = 0; i < prefix.length; i++)
			prefix[i] = "";

		for (int i = 1; i < 1000; i++) {
			tree[i] = MAX;
			flag[i] = 0;
		}

		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String instr = bufr.readLine();
		bufr.close();

		// 输入数据[0,100),且不存在重复数据
		String[] sbuf = instr.split(" ");
		for (int i = 0; i < sbuf.length; i++)
			insert(new Integer(sbuf[i]));

		create();

		StringBuilder sb = new StringBuilder();
		print(1, sb);

		System.out.println(sb.toString());
	}

	private void create() {
		for (int now = 2; now < 1000; now++) {
			if (tree[now] != MAX) {
				prefix[now] = prefix[now / 2];
				// 若为右子数左子树或左子树的右子树
				if ((now / 2 != 1) && ((now == now / 2 * 2 && now / 2 == now / 4 * 2 + 1)
						|| (now == now / 2 * 2 + 1 && now / 2 == now / 4 * 2))) {
					prefix[now] += "|";
				} else {
					prefix[now] += ".";
				}
				int width = width(tree[now / 2]) + 2;
				for (int i = 0; i < width; i++)
					prefix[now] += ".";
				// 父节点为负数
				if (tree[now / 2] < 0)
					prefix[now] += ".";
			}
		}
	}

	private void print(int now, StringBuilder sb) {
		String newLine = "\n";
		// 叶子
		if (flag[now] == 0) {
			if (tree[now] != MAX) {
				sb.append(prefix[now]);
				sb.append("|-");
				// 不为空
				sb.append(tree[now]);
				sb.append(newLine);
			}
			return;
		} else {
			// 右子树
			print(2 * now + 1, sb);

			sb.append(prefix[now]);
			if (now != 1)
				sb.append("|-");
			// 不为空
			sb.append(tree[now]);
			sb.append("-|");
			sb.append(newLine);

			// 左子树
			print(2 * now, sb);
		}
	}

	// 深度log2(n)+1
	private int width(int n) {
		int res = 0;
		for (; n != 0; res++, n /= 10)
			;
		return res;
	}

	private void insert(int n) {
		int i = 1;
		while (tree[i] != MAX) {
			flag[i] = 1;
			if (tree[i] > n) {
				i = 2 * i;
			} else
				i = i * 2 + 1;
		}
		tree[i] = n;
	}

	// 一个笨方法,且对题意理解有偏差,中间打印的宽度应该和父节点宽度有关,并不是最大的父节点宽度,最终50分,也懒得改了,但觉得自己的更加美观,特别是数据为多位时
	private void method1() throws IOException {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String instr = bufr.readLine();
		bufr.close();

		// 输入数据[0,100),且不存在重复数据,但本代码支持多位,即[0,MAX_UNSIGNED_INT]
		String[] sbuf = instr.split(" ");
		// 类似TreeSet
		MyTreeSet tree = new MyTreeSet();
		for (int i = 0; i < sbuf.length; i++)
			tree.add(new MyNode(new Integer(sbuf[i])));

		System.out.println(tree.toString());
	}
}

// 为了操作方便,没有设计setters/getters,直接public
class MyTreeSet {
	// 存储根节点
	private MyNode rootNode = null;
	// 存储节点数量
	private int num = 0;
	// 用于存储树的高度
	private int treeDegree = 0;
	// 用于将树转为二维数组
	private int index = 0;
	// 用于打印树
	private boolean[] info = null;
	// 用于构建info
	private int parentNodeNum = 0;
	// 每一层的宽度,用于打印
	private int[] width = null;

	// 从rootNode节点出发,找到addNode的插入位置,并插入
	public void add(MyNode addNode) {
		if (rootNode == null) {
			rootNode = addNode;
			num++;
			return;
		}

		MyNode currentNode = rootNode;
		int nodeDegree = 0;
		// 不存在重复数据且一定能插入
		while (true) {
			MyNode nextNode = null;
			if (addNode.data < currentNode.data) {
				nextNode = currentNode.lchild;
				nodeDegree++;
				if (nextNode == null) {
					addNode.parent = currentNode;
					addNode.degree = nodeDegree;
					currentNode.lchild = addNode;
					num++;
					if (treeDegree < nodeDegree)
						treeDegree = nodeDegree;
					return;
				} else
					currentNode = nextNode;
			} else if (addNode.data > currentNode.data) {
				nextNode = currentNode.rchild;
				nodeDegree++;
				if (nextNode == null) {
					addNode.parent = currentNode;
					addNode.degree = nodeDegree;
					currentNode.rchild = addNode;
					num++;
					if (treeDegree < nodeDegree)
						treeDegree = nodeDegree;
					return;
				} else
					currentNode = nextNode;
			} else {
				// 还是考虑下重复的情况
				return;
			}
		}
	}

	// 将树按后序遍历转为二维数组,每行数组信息依次为节点数据,节点所在的高度,节点的类型(孤立,父,子,均有)
	private int[][] toArray() {
		int[][] dat = new int[num][3];
		width = new int[treeDegree + 1];
		postOrder(dat, rootNode);
		return dat;
	}

	// 后序遍历
	private void postOrder(int[][] dat, MyNode currentNode) {
		if (currentNode == null)
			return;
		postOrder(dat, currentNode.rchild);
		int data = currentNode.data;
		dat[index][0] = data;
		int currentDegree = currentNode.degree;
		dat[index][1] = currentDegree;
		int dataWidth = getDataWidth(data);
		int oldWidth = width[currentDegree];
		int kind = currentNode.getNodeKind();
		dat[index++][2] = kind;
		if (kind == 1 || kind == 3)
			parentNodeNum++;
		if (oldWidth < dataWidth)
			width[currentDegree] = dataWidth;
		postOrder(dat, currentNode.lchild);
	}

	// 获得整数的宽度
	private int getDataWidth(int data) {
		return String.valueOf(data).length();
	}

	@Override
	public String toString() {
		String newline = System.getProperty("line.sperator");
		String leftStr = "|-";
		String rightStr = "-|";
		if (newline == null)// default Windows
			newline = "\n";
		// System.out.println("degree: " + treeDegree + " node: " + num);
		int[][] dat = toArray();
		// 初始化info,需要在toArray之后
		if (info == null)
			info = new boolean[parentNodeNum];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			int tmpData = dat[i][0];
			int tmpDegree = dat[i][1];
			int tmpKind = dat[i][2];
			if (tmpKind < 2) {
				sb.append(tmpData);
				sb.append(rightStr);
				sb.append(newline);
				continue;
			} else {
				int rootWidth = width[0];
				for (int j = 0; j <= rootWidth; j++)
					sb.append('.');
			}
			for (int j = 1; j < tmpDegree; j++) {
				if (info[j - 1])
					sb.append('|');
				else
					sb.append('.');

				int tmpWidth = width[j] + 2;
				for (int k = 0; k < tmpWidth; k++)
					sb.append('.');
			}
			if (tmpKind > 1) {
				sb.append(leftStr);
				sb.append(tmpData);
				int blank = width[tmpDegree] - getDataWidth(tmpData);
				for (int j = 0; j < blank; j++)
					sb.append(' ');
			}
			if (tmpKind == 3)
				sb.append(rightStr);
			if (tmpKind == 1 || tmpKind == 3)
				info[tmpDegree] = true;
			if (tmpKind > 1)
				info[tmpDegree - 1] = !info[tmpDegree - 1];
			sb.append(newline);
		}
		return sb.toString();
	}

}

class MyNode {
	public int data = -1;
	public int degree = 0;
	public MyNode parent = null;
	public MyNode lchild = null;
	public MyNode rchild = null;

	public MyNode(int data) {
		this.data = data;
	}

	// 0:孤立的点
	// 1:父节点
	// 2:子节点
	// 3:1+2
	public int getNodeKind() {
		int kind = 0;
		if (parent != null)
			kind = 2;
		if (lchild != null || rchild != null)
			kind += 1;
		return kind;
	}
}
