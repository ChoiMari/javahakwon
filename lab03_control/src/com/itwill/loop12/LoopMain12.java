package com.itwill.loop12;

import java.util.Random;

public class LoopMain12 {

	public static void main(String[] args) {
		// 교재 연습문제 3번
		Random r = new Random();

		int x = 0;
		int y = 0;
		int n = 1;

		/*
		 * while (true) { // 무한 루프
		 * 
		 * int a = r.nextInt(1,7); int b = r.nextInt(1,7);
		 * 
		 * 
		 * if (a+b == 5) { System.out.printf("(%d, %d)\n", a, b); break; // 무한 루프를 멈춤. }
		 * }
		 */

		do {

			x = r.nextInt(1, 7);

			y = r.nextInt(1, 7);

			System.out.println(n + "회차");
			System.out.printf("(%d, %d) \n", x, y);
			n++;

		} while (x + y != 5);

		// 교재 연습문제 4번

		System.out.println("================");
		
		
		

		n = 1;
		for (x = 1; x <= 10; x++) {
			for (y = 1; y <= 10; y++) {
				if ((4 * x) + (5 * y) == 60) {
					System.out.printf("(%d) ", n);
					System.out.printf("x = %2d y = %2d\n", x, y);
					n++;
				}
			}
		}

	}

}
