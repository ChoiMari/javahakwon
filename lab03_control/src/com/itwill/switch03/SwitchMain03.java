package com.itwill.switch03;

public class SwitchMain03 {

	public static void main(String[] args) {
		// switch-case 구문에서 enum 사용 방법 
		Rsp choice = Rsp.SCISSORS; // 값을 저장할 때는 enum이름.상수
		
		switch(choice) { 
		case PAPER :		// switch문으로 쓸때는 Rsp. 생략가능
			System.out.println("보");
			break;
		case ROCK:
			System.out.println("바위");
			break;
		case SCISSORS:
			System.out.println("가위");
			break;
		
		}
		

	}

}
