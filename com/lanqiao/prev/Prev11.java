package com.lanqiao.prev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �������� �����ӡ������
 * 
 * �ܽ᣺���������
 * 
 * @author Chain
 *
 */
@SuppressWarnings("unused")
public class Prev11 {

	// ������Ҫ�������������,�ٽ���ϢתΪ��ά����,�����ݶ�ά�����ӡ��
	public static void main(String[] args) throws Exception {
		// new Prev11().method1();
		new Prev11().method2();
	}

	private int flag[] = new int[1000];
	private int tree[] = new int[1000];
	// ǰ׺
	private String prefix[] = new String[10000];
	// ���������
	private final int MAX = 100000000;

	// ֱ����һ���������һά����,���ǵ� N<100,��ÿ�����ֲ�����10000
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

		// ��������[0,100),�Ҳ������ظ�����
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
				// ��Ϊ����������������������������
				if ((now / 2 != 1) && ((now == now / 2 * 2 && now / 2 == now / 4 * 2 + 1)
						|| (now == now / 2 * 2 + 1 && now / 2 == now / 4 * 2))) {
					prefix[now] += "|";
				} else {
					prefix[now] += ".";
				}
				int width = width(tree[now / 2]) + 2;
				for (int i = 0; i < width; i++)
					prefix[now] += ".";
				// ���ڵ�Ϊ����
				if (tree[now / 2] < 0)
					prefix[now] += ".";
			}
		}
	}

	private void print(int now, StringBuilder sb) {
		String newLine = "\n";
		// Ҷ��
		if (flag[now] == 0) {
			if (tree[now] != MAX) {
				sb.append(prefix[now]);
				sb.append("|-");
				// ��Ϊ��
				sb.append(tree[now]);
				sb.append(newLine);
			}
			return;
		} else {
			// ������
			print(2 * now + 1, sb);

			sb.append(prefix[now]);
			if (now != 1)
				sb.append("|-");
			// ��Ϊ��
			sb.append(tree[now]);
			sb.append("-|");
			sb.append(newLine);

			// ������
			print(2 * now, sb);
		}
	}

	// ���log2(n)+1
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

	// һ��������,�Ҷ����������ƫ��,�м��ӡ�Ŀ��Ӧ�ú͸��ڵ����й�,���������ĸ��ڵ���,����50��,Ҳ���ø���,�������Լ��ĸ�������,�ر�������Ϊ��λʱ
	private void method1() throws IOException {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String instr = bufr.readLine();
		bufr.close();

		// ��������[0,100),�Ҳ������ظ�����,��������֧�ֶ�λ,��[0,MAX_UNSIGNED_INT]
		String[] sbuf = instr.split(" ");
		// ����TreeSet
		MyTreeSet tree = new MyTreeSet();
		for (int i = 0; i < sbuf.length; i++)
			tree.add(new MyNode(new Integer(sbuf[i])));

		System.out.println(tree.toString());
	}
}

// Ϊ�˲�������,û�����setters/getters,ֱ��public
class MyTreeSet {
	// �洢���ڵ�
	private MyNode rootNode = null;
	// �洢�ڵ�����
	private int num = 0;
	// ���ڴ洢���ĸ߶�
	private int treeDegree = 0;
	// ���ڽ���תΪ��ά����
	private int index = 0;
	// ���ڴ�ӡ��
	private boolean[] info = null;
	// ���ڹ���info
	private int parentNodeNum = 0;
	// ÿһ��Ŀ��,���ڴ�ӡ
	private int[] width = null;

	// ��rootNode�ڵ����,�ҵ�addNode�Ĳ���λ��,������
	public void add(MyNode addNode) {
		if (rootNode == null) {
			rootNode = addNode;
			num++;
			return;
		}

		MyNode currentNode = rootNode;
		int nodeDegree = 0;
		// �������ظ�������һ���ܲ���
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
				// ���ǿ������ظ������
				return;
			}
		}
	}

	// �������������תΪ��ά����,ÿ��������Ϣ����Ϊ�ڵ�����,�ڵ����ڵĸ߶�,�ڵ������(����,��,��,����)
	private int[][] toArray() {
		int[][] dat = new int[num][3];
		width = new int[treeDegree + 1];
		postOrder(dat, rootNode);
		return dat;
	}

	// �������
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

	// ��������Ŀ��
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
		// ��ʼ��info,��Ҫ��toArray֮��
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

	// 0:�����ĵ�
	// 1:���ڵ�
	// 2:�ӽڵ�
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
