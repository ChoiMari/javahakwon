package com.itwill.wrapper;

public class WrapperEx {

	public static void main(String[] args) {
		// Integer 타입 객체를 형성: int 값을 전달 받아서 Integer 객체 형성
		Integer number1 = Integer.valueOf(1); //valueOf 쓸 일 별로 없지만 써야 되는 경우가 있다고...
		System.out.println(number1);
		
		 //String 객체를 전달 받아서 Integer타입 객체를 생성.
		Integer number2 = Integer.valueOf("123");
		System.out.println(number2);
		
		// 문자열을 int 타입 값으로 변환하는 메서드(정적 static 메서드)
		int number3 = Integer.parseInt("100");
		
		//Integer클래스를 거의 int처럼 사용한다고 함
		Integer number4 = 4; // 문법적으로는 말이 안되는데 가능하다고 함
		// 생성자를 호출하거나 static이용해서 ..?
		// 클래스 타입(참조타입)은 변수에 주소값 저장인데 정수 값 4가 저장됨.
		// 이런경우 오토박싱(auto-boxing)이라고 함 : 타입 값을 자동으로 Integer타입 객체로 생성
		// 그래서 int랑 Integer을 혼동해서 쓴다고..
		// 박싱.. 박스안에 넣어주는 거라고 생각
		System.out.println(number4);
		
		// auto-unboxing : Integer 타입 객체가 가지고 있는 int 타입 값을 자동으로 꺼내줌.
		int result = number1 - number4;
		// 이것도 말이 안되는 코드...number1, number4는 숫자가 아니라... Integer이라고 하는 객체...
		// 객체-객체라 말이 안되는 코드인데,, 
		// 안에서는 객체에 저장되어 있는 숫자 1개를 꺼낸다고 함..
		// 그래서 Integer라는 박스 안에 저장된 숫자를 꺼내서 계산하고 int 타입의 result에 저장한 것.
		// 박스안에 저장된 숫자를 꺼내는 걸 자동으로 해주는 것..
		// 결론 Integer을 간단하게 int처럼 생각하자.
		// 언박싱 박스 안에있는 데이터를 꺼내준다고 생각
		System.out.println(result);
		// int와의 차이점 Integer라고 선언한 변수들은 .하면 메서드들이 보여서 사용가능
	
	}

}
