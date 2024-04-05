package com.itwill.exception05;

import java.util.Scanner;

public class ExceptionMain05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("x = ");
			int x = Integer.parseInt(sc.nextLine());
			
			System.out.print("y = ");
			int y = Integer.parseInt(sc.nextLine());
			System.out.println("x / y = " + (x / y));
			
			int[] array = new int[0]; // 쓸때없는 배열 저장할 수 있는게 없음. 배열의 개수 int타입이면 다 들어감.
			array[0] = 100; // 컴파일러가 검사하는 문법적인 오류는 없지만 실행 시 오류가 생김.
			
		} catch(NumberFormatException | ArithmeticException e){
			System.out.println(e.getMessage());
		}

	}

}
