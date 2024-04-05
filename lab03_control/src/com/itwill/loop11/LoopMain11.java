package com.itwill.loop11;

public class LoopMain11 {

	public static void main(String[] args) {
		// Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력 = 55
		// 1 + 2 + 3 + ... + 9 + 10 = 55
		int sum = 0;	// 자연수 들의 합을 저장할 변수
		int x = 0;		// 
		for (x= 1; x<=10; x++) {
			sum += x;
		}
		System.out.println("Ex.1 = "+sum);
		// Ex.2 1부터 100까지 자연수들 중에서 짝수들의 합을 계산하고 출력.
		// 2 + 4 + 6 ... + 98 + 100 = ?
		sum = 0;
		x = 0;
		do {
			if(x % 2 == 0) {
				sum += x;
			}
			x++;
		} while(x <= 100);
		/*
		for(int i = 1; i <=100; i++) {
			if(i % 2 == 1) {
				sum = sum + i;
			}
		}
		*/
		System.out.println("Ex.2 = "+sum);
		
		// Ex.2 1부터 100까지 자연수들 중에서 홀수들의 합을 계산하고 출력.
		// 1 + 3 + 5 ... + 97 + 99 = ?
		sum = 0;
		x = 0;
		while(x <= 100) {
			if(x % 2 == 1) {
				sum += x;
			}
			x++;
		}
		/* 
		 for(int i = 1; i <=100; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		*/
		System.out.println("Ex.3 = "+sum);
		
	}

}
