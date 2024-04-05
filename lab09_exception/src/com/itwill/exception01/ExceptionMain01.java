package com.itwill.exception01;

import java.util.Scanner;

/*
 * 
 */

public class ExceptionMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //heap에 Scanner 객체 생성.
		
		System.out.print("정수 x 입력> ");
		int x = Integer.parseInt(sc.nextLine());
				//인티저 클래스에서 . 찾아라 parseInt는 static으로 선언되서 객체생성(new)없이 사용가능
				//nextLine()은 static 선언이 아님.
		System.out.println("정수 y 입력> ");
		int y = Integer.parseInt(sc.nextLine());
		
		if(y != 0) {
			System.out.println("나눈 몫 = " + (x / y));
		} else {
			System.out.println("0으로는 나눌 수 없습니다.");
		}
	}

}
