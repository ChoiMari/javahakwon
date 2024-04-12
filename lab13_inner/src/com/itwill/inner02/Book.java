package com.itwill.inner02;

public class Book {

	private String title; // 제목
	private String author; // 저자
	private String publisher; // 출판사
	
	// 생성자 - 오버로딩 : 파라미터 선언을 다르게 해서 같은 이름의 생성자를 여러개 만듬.
	public Book() {}
	
	public Book(String title, String author, String publisger) {
		this.title = title;
		this.author = author;
		this.publisher = publisger;
	}
	
	public Book(String title) {
		this(title, null ,null); //오버로딩 된 자신의 다른 생성자 호출해서 초기화 - 생성자 블록{}의 맨 첫 줄에 써야함.
		// this.title = title;
	}
	
//	public Book(String author) { //생성자 오버로딩 불가. 
//		//-> 위의 생성자 코드와 파라미터 타입의 선언과 개수가 같음. : 이렇게 만들면 다른 생성자라고 프로그램에서 구분을 못함.
//		this.author = author;
//	} //->해결하기 위한 디자인 패턴 :  빌더? 디자인 패턴
	
	public Book(String title, String author) {
		this(title, author ,null); //오버로딩 된 다른 생성자 호출
		// this.title = title;
		// this.author = author;
	}
	
	@Override
	public String toString() {
		return String.format("Book(제목:%s, 저자:%s, 출판사:%s)", 
				title,author,publisher);
	}
	
}
