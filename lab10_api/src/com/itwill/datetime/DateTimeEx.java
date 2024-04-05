package com.itwill.datetime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeEx {

	public static void main(String[] args) {
		// Java 8 버전부터 새로 생긴 java.time 패키지의 날짜/시간 클래스
		//import문장 없이 쓸 수 있는 클래스는 -> java.leng 패키지 밑에 있는 클래스들만 가능.
		
		//오늘 날짜 출력 -LocalDate클래스의 now()메서드 호출 
		// staic으로 선언 된 메서드라 그냥 클래스.으로 호출가능
		LocalDate today = LocalDate.now(); //now() 오늘 날짜(컴퓨터의 오늘 날짜) 
		System.out.println(today); // 오늘 날짜(컴퓨터의 오늘 날짜) 출력 :  년-월-일 형식
		System.out.println(today.getYear());
		System.out.println(today.getMonth()); // swich-case에서 이용하면 좋다고 함. 달을 영문자로 출력(enum - 열거상수 리턴해줌)
		System.out.println(today.getMonthValue());// 달을 숫자로 출력
		System.out.println(today.getDayOfMonth());// 정보를 가져오고 싶다 그러면 get치고 찾아보기
		// 정보를 수정하고 싶다 하면 set치고 찾아보면 된다고 함.
		System.out.println(today.getDayOfWeek());
		System.out.println(today.plusDays(1)); // 오늘 날짜에서 하루 늘리기 
		System.out.println(today.minusWeeks(1)); // 오늘 날짜에서 1주일 빼기(1주일 전의 날짜 나옴)
		
		LocalDate birthday = LocalDate.of(2000, 12, 31); // 아규먼트로 숫자 사용
		LocalDate.of(2000, Month.DECEMBER, 31);// 아규먼트로 enum사용
		System.out.println(birthday);
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now); // 현재 날짜 시간 분 초.소수점 출력됨
		
		LocalDateTime time = LocalDateTime.of(2024,3,14,9,30);
		System.out.println(time);
		
		//Timestamp : 1970-01-01 00:00:00를 기준으로 해서 1/1000초(milli-second)마다
		// 1씩 증가하는 정수(long 타입)를 기반으로 날짜와 시간 정보를 저장하는 클래스(타입)
		//DB에서 저장할 때 이걸 이용한다고 함.
		
		// LocalDateTime -->  Timestamp 변환
		Timestamp ts = Timestamp.valueOf(now);
		System.out.println(ts); //toString 오버라이드가 달라서 형식이 다르게 출력됨
		System.out.println(ts.getTime());
		
		// DB에서 사용한 Timestamp 값을 읽어 왔으면
		// 자바에서 사용하기 위해서는 LocalDateTime으로 변환 할 수 있어야 함.
		// Timestamp --> LocalDateTime 변환
		LocalDateTime dt = ts.toLocalDateTime();
		System.out.println(dt);
		
		
		
		
	}

}
