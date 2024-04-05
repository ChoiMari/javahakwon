package com.itwll.array05;

import java.util.Random;

public class ArrayMain5 {

	public static void main(String[] args) {
		// 정수(int) 5개를 저장할 수 있는 배열을 선언하고, 기본값으로 초기화.
		int[] numbers = new int[5];

		Random random = new Random();

		// 배열에 0이상 10이하 난수 5개를 저장.
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(11);
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		// 배열 원소들 중 최대값을 찾아서 출력.
		int max = numbers[0]; // 배열의 첫번째 원소를 최댓값이라고 가정.
		for (int x : numbers) { // 배열의 모든 원소를 순서대로 하나씩 꺼내면서 반복.
			if (x > max) { // 배열에서 꺼낸 값이 (현재까지의) 최대값보다 크다면
				max = x; // 최대값을 배열에서 꺼낸값으로 변경.
			}
		}

		// 배열 원소들 중 최소값을 찾아서 출력.
		int min = numbers[0]; // 배열의 첫번째 원소를 최소값이라고 가정.
		for (int x : numbers) { // 배열의 모든 원소를 순서대로 하나씩 꺼내면서 반복.
			if (x < min) { // 배열에서 꺼낸 값이 (현재까지의) 최소값보다 작다면
				min = x; // 최소값을 배열에서 꺼낸값으로 변경.
			}
		}

		System.out.printf("최대값 = %d\n최소값 = %d", max, min);

	}

}