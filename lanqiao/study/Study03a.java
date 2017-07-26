package com.lanqiao.study;

import java.math.BigDecimal;

public class Study03a {

	public static void main(String[] args) {
		System.out.println(0.1 + 0.2 == 03);
		System.out.println(Math.abs(0.1 + 0.2 - 0.3) < 1e-10);
		System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)));

		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++)
				if (i * 2.3 + j * 1.9 == 82.3)
					System.out.println(i + "," + j);

		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++)
				if (i * 23 + j * 19 == 823)
					System.out.println(i + "," + j);

		for (int a = 20; a > 0; a--)
			for (int b = a - 1; b > 0; b--)
				for (int c = b - 1; c > 0; c--)
					for (int d = c - 1; d > 0; d--)
						// if(1/a+1/b+1/c+1/d==1)
						// if(1.0/a+1.0/b+1.0/c+1.0/d==1.0)
						// if(1.0/a+1.0/b+1.0/c+1.0/d-1.0<1e-10)
						// if(1.0/a+1.0/b+1.0/c+1.0/d-1.0<1e-10)
						if (b * c * d + a * c * d + a * b * d + a * b * c == a * b * c * d)
							System.out.println(a + "," + b + "," + c + "," + d);

	}
}
