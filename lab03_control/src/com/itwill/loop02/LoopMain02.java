package com.itwill.loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		// 5 4 3 2 1 출력
		for(int i = 5; i > 0; i--) { 	// true 일때 실행 false일때 정지
			System.out.print(i+" ");
		}
		
		System.out.println(); // 줄바꿈
		
		// 0 2 4 6 8 10 출력
		
		for(int i = 0; i <= 10; i += 2 ) {		// 증감연산자 위치에 대입식 가능  
			System.out.print(i+" ");		// (i += 2) 2를 더한 후 대입 복합대입연산자 사칙연산 모두 존재
			
		}
		
		System.out.println();
		
		// 3의 배수 출력
		for (int i = 0; i <= 5; i++) {
			System.out.print((i*2)+" ");
		}
		
		System.out.println();
		
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.print(i+" ");
			}
		}
		
		System.out.println();
		
		//10 8 6 4 2 0 출력
		for (int i = 10; i >= 0; i -= 2) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
