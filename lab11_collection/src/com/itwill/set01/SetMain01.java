package com.itwill.set01;

import java.util.HashSet;
import java.util.TreeSet;

public class SetMain01 {

	
	public static void main(String[] args) {
		
		//정수를 저장할 수 있는 TreeSet을 선언, 초기화
		TreeSet<Integer> numbers = new TreeSet<>(); //new 생성자에서 E타입 생략 가능.
		System.out.println(numbers); //출력 결과 [] 
		System.out.println("size = " + numbers.size()); //size() 원소들의 개수 리턴
		
		// Set에 원소들을 저장
		numbers.add(1);
		numbers.add(100);
		numbers.add(50); // 출력 결과 : [1, 50, 100] 
		// -> 저장한 순서대로 나오는 것이 아니라 크기 순으로 정렬되어 출력됨.
		numbers.add(30);
		numbers.add(50); // 출력 결과 : [1, 30, 50, 100] - 중복값 허용(저장) 안 함.
		
		System.out.println(numbers);
		System.out.println("size = " + numbers.size()); // 출력 결과  : size = 4 
		// -> 중복 값(50)은 허용 안해서 저장 개수는 4
		
		//set<E>.get(int index)메서드 제공하지 않음
		// 향상된 for문 가능(하나씩 꺼내기) 하지만 일반 for문 반복문은 사용할 수 없다.(인덱스를 제공하지 않기 때문에)
		for(Integer x : numbers) {
			System.out.print(x + ","); //출력 결과 : 1,30,50,100,
		}
		System.out.println();
		
		// Set<E>.set(int index, E value) 메서드 제공하지 않음.
		// Set<E>.remove(int index) 메서드를 제공하지 않음
		// Set<E>.remove(Object x) 메서드만 제공 
		//-> 값을 비교해서 같은 값을 객체를 삭제함
		// equals()로 비교. ==는 X
		numbers.remove(50);
		System.out.println(numbers); // 출력 결과 : [1, 30, 100]
		
		//문자열을 저장하는 HashSet을 선언하고 초기화
		HashSet<String> set = new HashSet<>();
		System.out.println(set); // 출력 결과 : []
		System.out.println("size = " + set.size());
		
		set.add("hello");
		set.add("안녕하세요");
		set.add("hello");
		System.out.println(set); // [안녕하세요, hello]
		System.out.println("size = " + set.size()); //size = 2
		// hello는 1번만 저장됨(중복값 허용 X)
				
		
	}

}
