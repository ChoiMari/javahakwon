package com.itwill.inner02;

public class InnerMain02 {

	public static void main(String[] args) {
		//Book 타입 객체 생성
		Book book1 = new Book("철도원 삼대","황석영","창비");
		System.out.println(book1);
		
		//생성자만 있을 때의 1번째 문제 
		Book book2 = new Book("얼론 머스크","월터 아이작슨", "21세기북스");
		System.out.println(book2);
		
		Book book3 = new Book("월터 아이작슨","얼론 머스크", "21세기북스");
		System.out.println(book3);
		
		//해결 - 빌더 패턴(빌더 디자인 패턴)
		
		Book book4 = Book.builder()
				.author("신용권")
				.publisher("한빛")
				.title("혼공자")
				.build(); //-> 북 객체 생성해서 리턴받음
		//메서드 연쇄 호출 
		
		System.out.println(book4);
		
	Book book5 = Book.builder().title("혼공자").build();
	System.out.println(book5);
	Book book6 = Book.builder().author("신용권").build();
	System.out.println(book6);
	Book book7 = Book.builder().publisher("한빛") .build();
	System.out.println(book7);
	}

}
