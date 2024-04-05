package com.itwill.exception02;

import java.util.Scanner;

public class ExceptionMain02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("x = "); 
			int x = Integer.parseInt(sc.nextLine());
			// 소수점 값 입력 시 문제 - NumberFormatException
			
			System.out.println("y = ");
			int y = Integer.parseInt(sc.nextLine());
			// 소수점 값 입력 시 문제 - NumberFormatException
			
			System.out.println("x / y = " + (x / y)); //0으로 나누는 게 문제 - ArithmeticException
		} catch(ArithmeticException e) {
			System.out.println("y는 0이 될 수 없음.");
			System.out.println(e.getMessage());
		} catch(NumberFormatException e) { //변수 e는 지역변수라서 }문장끝나면 사라져서 사용가능하다.
			// NumberFormatException : 입력한 문자열이 넘버 포맷이 아니다.
			System.out.println("x, y는 정수로 입력하세요.");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("--- end ---");
		}

	}

}
