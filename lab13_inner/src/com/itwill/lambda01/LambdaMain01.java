package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

public class LambdaMain01 {

	public static void main(String[] args) {
		//Calculator 타입 객체 생성
		Calculator calc = new Calculator(1, 2);
		
		//----- 별도 파일에 작성된 클래스 Adder를 사용:
		//Calculable을 구현하는 객체를 생성
		Calculable adder = new Adder(); // 다형성 안 쓰면 Adder adder = new Adder();
		
		// Calculator 객체의 메서드 호출
		double result = calc.calculate(adder);
		System.out.println("result = " + result);
		
		//----- 지역 클래스 사용:
		class Subtracter implements Calculable {
			@Override
			public double calculate(double x, double y) {
				
				return x - y;
			}
		}
		result = calc.calculate(new Subtracter());
		System.out.println("result = "+ result);
		
		//----- 익명 클래스 사용:
		result = calc.calculate(new Calculable() { // 인터 페이스 이름으로 생성자 호출 new Calculable()
			
			@Override
			public double calculate(double x, double y) { // 클래스 이름 없음 . 익명 클래스. 선언 위치에서 객체 생성.
				
				return x * y;
			} //new Subtracter()와 다를 게 없다고 함.
		});
		System.out.println("result = " + result);
		
		//----- 람다 표현식 사용:
	//	calc.calculate((double x, double y) -> {return x / y;});
	
		result = calc.calculate((x,y) -> x / y);
		System.out.println("result = " + result);
		
		result = calc.calculate((x,y)-> x * x + y * y);
		System.out.println("result = " + result);
		
		
	}

}
