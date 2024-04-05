package com.itwill.method05;

import java.util.Random;

public class MethodMain05 {

	public static void main(String[] args) {
		// 메서드 선언, 호출, 그 결과를 출력:

		Random random = new Random();
		int[] array = new int[4];

		System.out.print("array = ");
 
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(11);
			System.out.print(array[i] + " ");
		}
		System.out.println();

		// sum 메서드 호출, 결과 출력.

		int total = sum(array);

		System.out.println("sum = " + total);

		// mean 메서드 호출, 결과 출력.
		
		System.out.println("mean = " + mean(array));

		// max 메서드 호출, 결과 출력.
		
		System.out.println("max = " + max(array));

		// min 메서드 호출, 결과 출력.
		
		System.out.println("min = " + min(array));

	}

	/**
	 * sum. 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합을 리턴.
	 * 
	 * @param array 정수들의 1차원 배열(int[]).
	 * @return array의 모든 원소들의 합.
	 */

	public static int sum(int[] array) {
		int result = 0;
		for (int i : array) {
			result += i;
		}
		return result;
	}

	/**
	 * mean. 아규먼트로 전달받은 정수들의 1차원 배열 원소들의 평균을 리턴.
	 * 
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들의 평균을 double 타입으로 리턴.
	 */

	public static double mean(int[] array) {

		return (double) sum(array) / array.length;

	}

	/**
	 * max. 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최댓값을 리턴.
	 * 
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들 중 최댓값을 리턴.
	 */

	public static int max(int[] array) {
		int result = array[0];
		for (int i : array) {
			if (i > result) {
				result = i;
			}
		}

		return result;
	}

	/**
	 * min. 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최솟값을 리턴.
	 * 
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들 중 최솟값을 리턴.
	 */

	public static int min(int[] array) {
		int result = array[0];
		for (int i : array) {
			if (i < result) {
				result = i;
			}
		}

		return result;
	}

}
