package com.lanqiao.match.province;

/*
5��ȡ��λ

��1�������ĵ�kλ�����кܶ��ַ�����
���µķ�������һ�֡�


// ��x��10���Ʊ�ʾʱ����λ���� 
int len(int x){
    if(x<10) return 1;
    return len(x/10)+1;
}

// ȡx�ĵ�kλ����
int f(int x, int k){
    if(len(x)-k==0) return x%10;
    return _____________________;  //���
}

int main()
{
    int x = 23574;
    printf("%d\n", f(x,3));
    return 0;
}

������Ŀ�еĲ������ݣ�Ӧ�ô�ӡ5��

����ϸ����Դ�룬�����仮�߲�����ȱ�ٵĴ��롣

ע�⣺ֻ�ύȱʧ�Ĵ��룬��Ҫ��д�κ��������ݻ�˵���Ե����֡�
�������ݹ������
 */
public class Main05 {

	// ��x��10���Ʊ�ʾʱ����λ����
	private static int len(int x) {
		if (x < 10)
			return 1;
		return len(x / 10) + 1;
	}

	// ȡx�ĵ�kλ����
	private static int f(int x, int k) {
		if (len(x) - k == 0)
			return x % 10;
		return f(x / 10, k); // ���
	}

	public static void main(String[] args) {
		System.out.println(f(1234, 2));
	}
}
