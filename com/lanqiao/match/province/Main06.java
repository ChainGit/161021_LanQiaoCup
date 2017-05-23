package com.lanqiao.match.province;

/*
6����󹫹��Ӵ�

��󹫹��Ӵ�����������ǣ�
���������������Ӵ����ܹ�ƥ���ϵ���󳤶��Ƕ��١�

���磺"abcdkkk" �� "baabcdadabc"��
�����ҵ�����Ĺ����Ӵ���"abcd",������󹫹��Ӵ�����Ϊ4��

����ĳ����ǲ��þ��󷨽������ģ���Դ��Ĺ�ģ�����������ǱȽ���Ч�Ľⷨ��

������ýⷨ��˼·������ȫ���߲���ȱʧ�Ĵ��롣

#include <stdio.h>
#include <string.h>

#define N 256
int f(const char* s1, const char* s2)
{
    int a[N][N];
    int len1 = strlen(s1);
    int len2 = strlen(s2);
    int i,j;

    memset(a,0,sizeof(int)*N*N);
    int max = 0;
    for(i=1; i<=len1; i++){
        for(j=1; j<=len2; j++){
            if(s1[i-1]==s2[j-1]) {
                a[i][j] = __________________________;  //���
                if(a[i][j] > max) max = a[i][j];
            }
        }
    }

    return max;
}

int main()
{
    printf("%d\n", f("abcdkkk", "baabcdadabc"));
    return 0;
}

ע�⣺ֻ�ύȱ�ٵĴ��룬��Ҫ�ύ���еĴ���ͷ��š�Ҳ��Ҫ�ύ˵�������֡�

������������̬�滮DP
 */
public class Main06 {

	private static int f(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		int[][] a = new int[c1.length + 1][c2.length + 1];

		int max = 0;
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < a[i].length; j++) {
				if (c1[i - 1] == c2[j - 1]) {
					a[i][j] = a[i - 1][j - 1] + 1; // ���
					if (a[i][j] > max)
						max = a[i][j];
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int n = f("abcdkkk", "baabcdadabc");// abcd
		System.out.println(n);
	}
}
