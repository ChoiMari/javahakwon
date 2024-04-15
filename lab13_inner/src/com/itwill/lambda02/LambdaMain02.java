package com.itwill.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface 
interface MyFilter{ //public interface MyFilter는 안됨 하나의 클래스 안에 public class나 interface나 딱 1개만 존재해야!(내부 클래스 제외)
	boolean test(Object x); // 추상 메서드 1개
}

public class LambdaMain02 {

	public List<Object> filter (List<Object> list, MyFilter filter){ //filter변수로 .하면
		//MyFilter타입이 가지고 있는 메서드 보임. - test메서드 : true아니면 false리턴
		List<Object> result = new ArrayList<>();
		
		for(Object x : list) { //list의 원소를 하나씩 꺼내서 test의 아규먼트로 전달 하겠다 그럼 test가 true나 false를 리턴.(if{}실행여부 결정)
			if(filter.test(x)) { // 조건을 만족하는 애들만
				result.add(x); // result에 넣겠다.
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		LambdaMain02 app = new LambdaMain02(); //filter 메서드를 호출하기 위해서
		
		List<Object> numbers = Arrays.asList(1,2,3,4,5,6,7);
		System.out.println(numbers);
		
		//numbers에서 홀수들만 선택(필터링)
		List<Object> odds = app.filter(numbers, new MyFilter() { //numbers는 1,2,3,4,5,6,7이라 생각
			
			@Override
			public boolean test(Object x) {
				return (Integer) x % 2 == 1; // 홀수 이면 true리턴
			}
		});
		System.out.println(odds);
		
		// numbers에서 짝수들만 선택(필터링)
		List<Object> evens = app.filter(numbers, (x) -> (Integer) x % 2 == 0);
		System.out.println(evens);
		
		List<Object> languages = Arrays.asList("Java","SQL","HTML","JavaScript","Python");
		// languages의 원소들 중 문자열의 길이가 5자 이상인 원소들만 선택(필터링)
		List<Object> longWords = app.filter(languages, (x) -> ((String)x).length() >= 5);
		System.out.println(longWords);
		
	}

}
