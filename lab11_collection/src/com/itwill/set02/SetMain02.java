package com.itwill.set02;

import java.util.HashSet;
import java.util.Random;

public class SetMain02 {

	public static void main(String[] args) {
		// 정수를 저장하는 HashSet을 선언, 초기화
		HashSet<Integer> set = new HashSet<>();
		
		// [0,10) 0이상 10미만 범위의 서로 다른 난수 5개를 집합(Set)에 저장.
		// 최소 5번 add()해야 함. 그 이상 필요 할 수도..(왜냐면 중복값 허용 안하니깐..)
		
		//방법 1
		Random rand = new Random();
		while(set.size() < 5) {
			int x = rand.nextInt(10);
			System.out.println("x = " + x);
			set.add(x);
			System.out.println(set);
		}
		
		//방법 2
		while(true) {
			int x = rand.nextInt(10);
			System.out.println("x = " + x);
			set.add(x);
			System.out.println(set);
			if(set.size() == 5) {
				break;
			}
		}
		
		
		// 향상된 for 문장을 사용해서 집합의 내용을 출력.
		
		for(Integer s:set) {
			System.out.print(s + ",");
		}
		System.out.println();
	}

}
