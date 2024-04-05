package com.itwill.loop07;

import java.util.Scanner;

public class Loopsub02 {

	public static void main(String[] args) {
		
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		for (;;) {
			System.out.println("---------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("---------------------");
			System.out.print("선택> ");
			
			int choice = sc.nextInt();
			
			switch(choice){
				case 1 :
					System.out.print("예금액> ");
					balance += sc.nextInt();
					System.out.println("잔고> "+ balance);
					break;
				case 2 :
					System.out.println("출금액> ");
					balance -= sc.nextInt();
					System.out.println("잔고> "+balance);
					break;
				case 3 :
					System.out.println("잔고> " + balance);
					break;
			}
			 if ( choice==4 ) {
				 System.out.println("프로그램 종료");
				 sc.close();
				 break;
	        	 }
		}
		


	}


}
