package com.itwill.loop06;

public class LoopMain06 {

	public static void main(String[] args) {
		// 중첩 반복문: 반복문 안에서 반복문을 사용.
		// 구구단 2단 ~ 9단 출력
		
		for(int x = 2; 10 > x; x++) {
			System.out.println("-----" + x + "단");
			
			for(int i = 1; i < 10; i++) {
				System.out.println(x + " x " + i + " = " +(x*i));
			}
			
			System.out.println("-----------------------------");
		}

	}

}

