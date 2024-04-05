package com.itwill.exception06;

public class ExceptionMain06 {

	public static void main(String[] args) throws Exception {
		//throws 선언문이 있는 메서드들 중에서 ,
		//RuntimeException을 상속하는 예외 타입들은 try - catch를 사용하지 않아도 컴파일 에러가 없음
		//RuntimeException의 하위 타입이 아닌 예외 타입들은 반드시
		//(1) try -catch 문장을 사용하거나
		//(2) throws 선언문을 추가 해야 한다 그래야 컴파일 오류가 해결 됨.
		
		//Integer.paseInt("");//->  try - catch를 사용하지 않아도 컴파일 에러가 없음
		//이유 NumberFormat~~예외는 RuntimeException을 상속받는 하위 타입이여서
		
		//Calculator 타입 객체 생성
		Calculator calc = new Calculator();
//		try {
			int result = calc.divide(100, 0);
			System.out.println(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("main 정상 종료");
	}

}
