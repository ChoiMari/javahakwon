package com.itwill.exception03;

import java.util.Scanner;

public class ExceptionMain03 {
	
	private final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// sc. ->안 됨. : 객체 생성 뒤에야 사용 가능(ExceptionMain03를 메모리에 올려야 sc사용 가능)
		
		ExceptionMain03 app = new ExceptionMain03();
//		app.sc.nextLine() ->이제 가능해짐
		int x = app.inputInteger2(); //app.inputInteger();
		System.out.println("x = " + x);
	
	}// main()끝

	// * 문제
	//inputInteger() 메서드 만들기 -> 무조건 int리턴. try-catch이용해서 예외 처리하기
	// 사용자가 소수점 값 입력하면 Number포맷예외 발생. 예외 발생 없으면 parseInt가 리턴해주면 됨.
	
	public int inputInteger2() {
		try {
			System.out.println("정수 입력> ");
			return Integer.parseInt(sc.nextLine()); // 만약 예외 발생시 catch로 가버리기 때문에
			// 리턴을 못하는 경우가 있어서 빨간펜 나옴. // 그래서 예외 발생시에도 return 값을 설정 해주기.
			// catch(){}안에도 리턴값 설정하기.
		} catch(NumberFormatException e) {
			System.out.println("정수로 입력하세요...");
			return inputInteger2(); // 메서드가 자기를 호출함 ->재기 호출
			// 예외 발생 시 자기 호출해서 또 실행 되게 함. 
			// 재기 호출 - 잘못 사용시 무한 루프에 빠져버림. 
			// 그래서 적절한 리턴값이 없으면 무한 루프에 빠지지만 잘만 사용하면 반복문 사용할 필요없이
			// 간단하게 코드 쓸 수 있다.
		}
	}
	
	
	public int inputInteger() {
		
		

		int result =0; // 반환해 줄 리턴값으로 사용하려고 변수 선언 & 초기화
		
		while(true) {
		try {
			System.out.print("정수 입력>  ");
			result = Integer.parseInt(sc.nextLine());
			break;
				
		} catch(NumberFormatException e) {
			System.out.println("입력한 내용은 정수가 아닙니다.");
			
			}
		}
		return result;
	}
	
}//ExceptionMain03 class 끝
