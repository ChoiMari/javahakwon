package com.itwill.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface 
interface MyFilter{ //public interface MyFilter는 안됨 하나의 클래스 안에 public class나 interface나 딱 1개만 존재해야!(내부 클래스 제외)
	boolean test(Object x); // 추상 메서드 1개
}

@FunctionalInterface //자바 펑셔널 인터페이스
interface MyMapper{
	Object transform(Object x); // 오브젝트를 전달을 받아서 새로운 오브젝트를 전달해주는.
}

public class LambdaMain02 {

	public List<Object> filter (List<Object> list, MyFilter filter){ //filter변수로 .하면
		//MyFilter타입이 가지고 있는 메서드 보임. - test메서드 : true아니면 false리턴
		List<Object> result = new ArrayList<>();
		
		for(Object x : list) { //list의 원소를 하나씩 꺼내서 test의 아규먼트로 전달 하겠다 그럼 test가 true나 false를 리턴.(if{}실행여부 결정)
			if(filter.test(x)) { // 조건을 만족하는 애들만
				result.add(x); // result라는 리스트에 add 추가
			} // 원하는 값만 저장하는 필터링
		}
		
		return result;
	}
	
	public List<Object> map(List<Object> list, MyMapper mapper){
		List<Object> result = new ArrayList<>();
		 
		for(Object x: list) { //list에서 하나씩 꺼내서 x에 담고 transform메서드의 아규먼트로 넘김
			//transform이 return한 값을 result 리스트에 add추가
			result.add(mapper.transform(x));  // result 리스트에 저장. Mapper는 transform()메서드를 가지고 있음
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
		}); //-> 익명 클래스 MyFilter()인터페이스 구현.
		System.out.println(odds);
		
		//람다 표현식
		// numbers에서 짝수들만 선택(필터링)
		List<Object> evens = app.filter(numbers, (x) -> (Integer) x % 2 == 0); // numbers 리스트에서 값x를 전달 받아서 -> 짝수인지 검사
		// true면 add 추가해서 evens 리스트에 저장
		System.out.println(evens);
		
		List<Object> languages = Arrays.asList("Java","SQL","HTML","JavaScript","Python");
		// languages의 원소들 중 문자열의 길이가 5자 이상인 원소들만 선택(필터링)
		List<Object> longWords = app.filter(languages, (x) -> ((String)x).length() >= 5);
		System.out.println(longWords);
		
		//numbers의 원소들의 제곱을 저장하는 리스트:
//		List<Object> squares = app.map(numbers, new MyMapper() { //map메서드 - 아규먼트에 있는 리스트에서 원소들을 하나씩
//			// mapper의 transform메서드의 아규먼트로 넘김. 그럼 그 값의 제곱을 리턴해줌. 그럼 squares에 add됨.
//			
//			@Override
//			public Object transform(Object x) {
//				Integer i = (Integer) x;
//				return i * i;
//			}
//		}); // 익명 클래스
		
		//람다 표현식
		List<Object> squares = app.map(numbers, (x) -> (Integer) x * (Integer) x);
		System.out.println(squares);
		
		// languages의 문자열을 대문자로 변환한 리스트 : 
		List<Object> upperCases = app.map(languages, x -> ((String)x).toUpperCase()); //x는 languages리스트의 원소로 생각.
		System.out.println(upperCases);
		
	} //main()끝

}
