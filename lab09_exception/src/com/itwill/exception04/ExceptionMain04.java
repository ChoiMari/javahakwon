package com.itwill.exception04;

public class ExceptionMain04 {

	public static void main(String[] args) {
		//finally : 예외 상황 발생 여부와 상관 없이 항상 실행되는 블록.
		// 중요한 점 : 
		// 만약 try 또는 catch 블록에 return 문장이 있어도,
		// finally 블록이 실행된 후에 return 문장 실행 됨.
		
		
		
		
		try {
			int x = 100;
			int y = 0;
			System.out.println("몫 = " + (x / y));
			System.out.println("end try");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("end catch");
			return; //main() 메서드 종료시키겠다고 넣은 것.(메서드 리턴 타입 - void)
		} finally {
			System.out.println("언제 출력될까요?");
		}
		
		System.out.println("end main");
	}

}
