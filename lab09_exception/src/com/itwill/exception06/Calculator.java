package com.itwill.exception06;

public class Calculator {

	
	public int divide(int x, int y) throws Exception { //메서드 호출하면서 값 넘겨줌 // 문제 y에 0을 줄 경우
		//메서드 리턴타입 int , y에 0을 줬을 때 뭘 리턴 해야하지..??? 고민.....
		// 그럴 떄 이용
		if(y != 0) { //y가 0이 아닐 때만 실행
			return x / y;
		} //throws 선언 안할 시 y값이 0 일 때도 리턴 코드 쓰라고 에러
		
		//해결
		throw new Exception("y는 0이 될 수 없음.");
	}
}
