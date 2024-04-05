package com.itwill.loop07;

import java.util.Random;

public class Loopsub01 {

	public static void main(String[] args) {

		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
			}

		}
		System.out.println(sum);

		System.out.println("----------------------------");

		Random rd = new Random();

		for (int i = 1;; i++) {
			int x = rd.nextInt(1, 7);
			int y = rd.nextInt(1, 7);
			System.out.println("눈 1 = " + x + " 눈 2 = " + y);
			System.out.println(i + " 회차");

			if ((x + y) == 5) {
				break;
			}
		}
		System.out.println("----------------------------");

		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if ((4 * x + 5 * y) == 60) {
					System.out.println("x= " + x + " y = " + y);
					System.out.printf("(%d, %d)\n", x, y);
				}
			}

		}

		System.out.println("----------------------------");

		for (int x = 0; x <= 4; x++) {

			for (int y = 4; y >= 0; y--) {
				if (x > y) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		System.out.println("----------------------------");

		for (int x = 0; x <= 3; x++) {
			for (int y = 3; y >= 0; y--) {
				if (x < y) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}

			}
			System.out.println();
		}

		System.out.println("----------------------------");

	}

}
