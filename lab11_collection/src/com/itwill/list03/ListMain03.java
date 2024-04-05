package com.itwill.list03;

import java.util.ArrayList;
import java.util.Random;

public class ListMain03 {

	public static void main(String[] args) {
		//1. 정수를 저장할 수 있는 ArrayList를 선언(numbers)하고, 객체 생성(new) - 기본생성자 이용
		ArrayList<Integer> numbers = new ArrayList<>();
		//2. numbers의 범위는 [0,100) //-> 0이상 100 미만 의 난수 20개를 저장
		// [0,100] //-> 0이상 100 이하
		Random random = new Random();
		

		for(int i= 0 ;i < 20;i++) { // 반복 횟수 떄문에 i사용
			
			numbers.add(random.nextInt(100)); 
		}
		//3. numbers를 출력
		System.out.println(numbers);
		//4. 홀수들만 저장할 수 있는 ArrayList를 선언(odds), 객체 생성.
		ArrayList<Integer> odds = new ArrayList<>();
		//5. numbers에 저장된 숫자들 중에서 홀수들을 찾아서 odds에 저장하기. 
		//(반복문으로 하나씩 꺼내서 홀수 인지 검사하고 홀수면 저장)
		for(Integer x : numbers) {
			if(x % 2 == 1) { // integer라는 객체의 나머지를 찾는다는 말이 원래 안되지만 자동으로 언박싱 해서 계산해준다.
				odds.add(x);
			}
		}
		//6. odds를 출력(맞게 저장 되었는지 확인하려고)
		System.out.println(odds);
		//7. 정수를 저장 할 수 있는 ArrayList를 선언하고(evenSquares) 객체 생성
		ArrayList<Integer> evenSquares = new ArrayList<>();
		//8.numbers에 저장된 숫자들 중에서 짝수를 찾아서 제곱을 evenSquares에 저장
		for(Integer x : numbers) {
			if(x % 2 == 0) {
				evenSquares.add(x * x);
			}
		}
		//9. evenSuares 출력
		System.out.println(evenSquares);
	}

}
