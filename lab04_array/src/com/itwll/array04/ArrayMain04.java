package com.itwll.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
		// 숫자 배열에 대응하는 문자열 배열 만들기:

		// 정수 10개를 저장할 수 있는 배열(codes)을 만들고 기본값으로 초기화.
		int[] codes = new int[10];

		// 배열 codes 에 1이상 4이하 범위 정수를 임의로 저장. (난수)
		Random ran = new Random();

		for (int i = 0; i < codes.length; i++) {
			codes[i] = ran.nextInt(1, 5);
		}
		// codes 내용을 출력.
		for (int i : codes) {
			System.out.printf(i + "\t");
		}
		System.out.println();
		// 문자열(String) 10개를 저장할 수 있는 배열(genders)를 만들고 기본값으로 초기화.
		String[] genders = new String[10];
		
		// codes의 원소가 1 또는 3이면 "남성"을, 원소가 2 또는 4 이면 "여성"을 genders에 저장.
		for (int i = 0; i < codes.length; i++) {
			if (codes[i] % 2 == 1) {
				genders[i] = "남성";
			} else {
				genders[i] = "여성";
			}
		}
		// genders 내용을 출력.
		for (String s : genders) {
			System.out.print(s + "\t");
		}
		System.out.println();

	}

}
