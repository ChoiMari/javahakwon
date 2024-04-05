package com.itwll.array09;

import java.util.Random;

public class ArrayMain09 {

	public static void main(String[] args) {
		Random random = new Random();
		// 1차원 정수(int) 배열 3개를 갖는 2차원 배열(array)을 선언 & 초기화.
		int[][] array = new int[3][];
		// 2차원 배열 array의 첫번째 배열에는 난수 2개, 두번째 배열에는 난수3개
		// 3번째 배열에는 난수 4개를 저장. 난수의 범위는 0이상 10미만.
		array[0] = new int[2];
		array[1] = new int[3];
		array[2] = new int[4];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = random.nextInt(10);
			}
		}
		// 2차원 배열 array의 내용을 출력.
		for (int[] x : array) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}

		// 2차원 배열의 모든 원소들(정수9개)의 합을 계산하고 출력
		int sum = 0;	// 배열의 원소들의 합을 저장할 변수
		int count = 0;  // 배열에서 읽은 원소 개수를 증가
		for (int[] x : array) {
			for (int y : x) {
				sum += y;	// 배열에서 읽은 원소의 합을 구함
				count++;	// 배열에서 읽은 원소 개수를 증가
			}
		}
		System.out.println("sum = " + sum);

		// 2차원 배열의 모든 원소들(정수9개)의 평균을 계산하고 출력

		
		double mean = sum / (double) count;

		System.out.println("mean = " + mean);

	}

}
