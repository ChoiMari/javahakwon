package com.itwill.loop14;

import java.util.Scanner;

public class LoofMain14_1 {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("---------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.자금 | 4.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택> ");

			int choice = scanner.nextInt();

			if (choice == 1) {
				System.out.print("예금액> ");
				balance += scanner.nextInt();
			} else if (choice == 2) {
				System.out.print("출금액> ");
				balance -= scanner.nextInt();
			} else if (choice == 3) {
				System.out.println("잔고> " + balance);
			} else if (choice == 4) {
				run = false;
			} else {
				System.out.println("---error---");
			}

		}

		System.out.println("프로그램 종료");
		scanner.close();

	}
}
