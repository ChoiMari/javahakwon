package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class LambdaMain03 {

	public static void main(String[] args) {
		// Stream 클래스 & 메서드(지난 시간에 공부한 입출력 Steam이 아님)
		// Stream 데이터가 지나가는 통로(파이프, 관)로 생각.
		//그게 리스트에서 지나가는 통로 다 라고 생각(입출력은 아님)
		
		Random rand = new Random();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 0 ; i < 10; i++) {
			numbers.add(rand.nextInt(100));
		}
		System.out.println(numbers);
		
		// numbers의 원소들 중에서 짝수들만 선택(필터링)한 새로운 리스트를 만들고 출력.
		ArrayList<Integer> evens = new ArrayList<>(); // 짝수들만 저장할 리스트 만듬
		for(Integer x : numbers) { // 원본 데이터 리스트 numbers 에서 숫자들(원소들)을 하나씩 꺼내서
			if(x % 2 == 0) { // 짝수인지 검사
				evens.add(x); // 짝수이면 evens 리스트에 추가.
			}
		}
		System.out.println(evens);
		
//		List<Integer> evens2 = numbers.stream().filter(new Predicate<Integer>() {
//			//모든 리스트는 다 가지고 있는 메서드 stream() - 리턴 타입 Stream -default메서드라고 함.
//		 
//			@Override
//			public boolean test(Integer t) { //numbers가 Integer면 여기도? Integer 쓰라함
//				return t % 2 == 0 ; //인터페이스를 구현한 익명 객체를 넘긴거라고함
//			}
//		}).toList(); 
//		System.out.println(evens2);
//	} // 람다 표현식으로 바꿀 때는 파라미터 -> 리턴값만 있음 됨
	
	//람다 표현식
		List<Integer> evens2 = numbers.stream().filter((x) -> x % 2 == 0).toList();
	//.toList(); 마지막으로 그 결과를 리스트로 만들어 준다.
		System.out.println(evens2);
		// 리스트를 numbers 만들고 . 통로를 만들고 .stream() 원소들을 순서대로 보내주는 게 stream
		// 그 통로에 .필터를 꽂음 .filter
		// 짝수 인 데이터들만 스트림을 통과해서 나갈 수 있음 ((x) -> x % 2 == 0)
		// 필터도 여전히 stram인 것
		// stream 안에서 보낼지 말지를 결정하는 게 필터.
		// 마지막 결과 리스트로 묶어라 .toList()
		
		
		//Stream을 사용해서, numbers의 원소들 중에서 홀수들만 선택한 리스트를
		//만들고 출력
		List<Integer> odds = numbers.stream().filter((x) -> x % 2 == 1).toList();
		//리스트의 원소들을 stream으로 보낸다. 거기에 필터(값을 걸러주는)를 꽂는다 필터메서드()안에
		//값을 걸러낼 조건을 적고 .toList()로 결과를 리스트를 묶는다.
		System.out.println(odds); // 필터는 아규먼트가 1개일 때 그 값을 이용해서 원하는 조건식을 만들어서
		// true나 false를 리턴하는 걸 아규먼트로 전달하면 된다.
		
		//Stream을 사용해서, numbers의 원소들의 제곱을 저장하는 리스트를 만들고 출력
		List<Integer> squares = numbers.stream().map((x) -> x * x).toList();
		System.out.println(squares);
		//필터 대신에 데이터들이 지나가는 통로 stream에 mapping해주는 무언가를 꽂아 줬다.
		//map은 무조건 통과를 시켜주는데 x가 들어가면 x * x을 만들어서 통과시킴
		// 그래서 그 결과를 .toList() 리스트로 만들어 줌
		
		//Stream을 사용해서, numbers의 원소들 중 홀수들의 제곱을 저장하는 리스트를 만들고 출력
		List<Integer> oddSquares = numbers.stream().filter((x) -> x % 2 == 1).map((x)-> x * x).toList();
		System.out.println(oddSquares);
		// 리스트의 원소들을 stream로 보내서 스트림을 통해 데이터 원소들이 순서대로 들어가는데 
		// 그 원소들 중 홀수들만 찾으면 됨 - 필터를 끼움 .filter(그 데이터x가 홀수인지 검사 식)
		// 그 다음에 그 홀수들을 제곱을 함 - .map (필터에 걸러진 데이터를 x 변환 할 식)
		// 다 통과 하고 나면 그 결과들을 리스트로 묶어 주자. toList()
		
		List<Integer> result = new ArrayList<>();
		for(Integer x :numbers) {
			if(x % 2 == 1) {
				result.add(x * x);
			}
		}
		System.out.println(result);
		
		List<String> languages = Arrays.asList("java", "javascript", "python","c","kotlin","swift");
		
		// languages의 원소들 중 문자열 길이가 5글자 이상인 원소들의 리스트
		List<String> longWords = languages.stream().filter((x) -> x.length() >= 5).toList();
		System.out.println(longWords);
		
		// languages의 문자열을 전부 대문자로 변환한 리스트
		List<String> upperCases = languages.stream().map((x) -> x.toUpperCase()).toList();
		System.out.println(upperCases);
		// languages의 원소들 중 길이가 5글자 이상인 문자열을 대문자로 변환한 리스트
		List<String> result2 = languages.stream().filter((x) -> x.length() >= 5).map((x) -> x.toUpperCase()).toList();
		System.out.println(result2);
		
		// languages의 list에 하나씩 통과 할 때 필터를 꽂아서 x. 하면 String이 가진 메서드 langth로 5글자 이상인지 검사
		// 그 원소들을 map을 통해 대문자로 변환
		// 그리고 리스트로 묶어줌 .toList()
		
		languages.forEach((x) -> System.out.println(x));
		//languages에 forEach 있는 원소들을 하나씩((x) -> {System.out.println(x);});
		// 아규먼트가 1개 x 짜리 메서드인데 사용 되는 문장이 1개뿐인 것
		//{}는 생략 가능
		// 메서드 호출 println 1개 뿐 
		
		//메서드를 참조한 람다 표현식
		languages.forEach(System.out::println);
	} 
}

