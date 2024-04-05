package com.itwill.condition07;

import java.util.Random;

public class ConditionMain07 {

	public static void main(String[] args) {
		// 조건문, 비교/논리 연산자 연습
		
		// 난수(random number)를 생성할 수 있는 타입의 변수를 선언, 초기화.
		
		Random roll = new Random();
		
		// rand.nextInt(x): 0 이상 x보다 작은 정수 난수를 반환.
		// rand.nextInt(x,y): x 이상 y 미만의 정수 난수를 반환.
		
		int java = roll.nextInt(101); // 0 이상 101 미만의 정수 난수를 반환
		
		System.out.println("Java = " + java);
		
		int sql = roll.nextInt(101);
		System.out.println("SQL = " + sql);
		
		int javascript = roll.nextInt(101);
		System.out.println("JavaScript = " + javascript);
		
		// 세 과목이 모두 40점 이상이고 평균이 60점 이상이면 "합격"
		// 그렇지 않으면 "불합격"을 출력.
		
		// 총점 계산:
		int total = java + sql + javascript;
		System.out.println("합계 = "+total);
		
		// 평균 계산:
		double avr = (java+sql+javascript)/3.0;
		System.out.printf("평균 = %.2f\n",avr);
		
		if(java >= 40 && sql >= 40 && javascript >= 40 && avr >= 60) {
						System.out.println("합격");			
		} else {
			System.out.println("불합격");
		}
		
		//String tf = (java >= 40 && sql >= 40 && javascript >= 40 && avr >= 60) ? "불합격" : "합격" ;

		//System.out.println(tf);
	}

}
