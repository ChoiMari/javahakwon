package com.itwll.array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {

		// 과제:
		// 정수(int) 5개를 저장할 수 있는 배열을 선언하고, 기본값으로 초기화.
		int[] number = new int[5];
		
		// 배열에 0이상 10이하 난수 5개를 저장.
		Random random = new Random();

		for (int i = 0; i < number.length; i++) {
			number[i] = random.nextInt(11);
			System.out.print(number[i] + " ");
		}
		System.out.println();
		
		// 배열 원소들 중 최댓값을 찾아서 출력.                                                                                                
		int big = number[0];
		
		for (int i = 0; i < number.length; i++) {
			if(number[i] > big ) {
				big = number[i];
			}
		}
		System.out.println("최댓값 = "+big);

		// 배열 원소들 중 최솟값을 찾아서 출력.
		int small = number[0];
		
		for (int i = 0; i < number.length; i++) {
			if(number[i] < small ) {
				small = number[i];
			}
		}
		System.out.println("최솟값 = "+small);
		
		for(int i : number) {
			if(i > big) {
				big = number[i];
			}
			if(i < small) {
				small = number[i];
			}
		}
		
		System.out.printf("최대값 = %d\n최소값 = %d", big, small);
		
		
	}

}