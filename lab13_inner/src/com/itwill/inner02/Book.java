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
	
	//--- Builder(Factoty) 디자인 패턴
	public static BookBuilder builder() {//외부 클래스에서 내부 클래스의 private 생성자를 호출 할 수 있음.
		return new BookBuilder(); // builder()메서드 호출 시 BookBuilder 객체 만들어짐
	} 
	
	public static class BookBuilder{
		private String title;
		private String author;
		private String publisher;
		
		private BookBuilder() {}
		
		public BookBuilder title(String title) { //리턴 값이 있는 setter메서드 느낌이라 함
			this.title = title;
			return this;
		}
		public BookBuilder author(String author) { 
			this.author = author;
			return this;
		}
		
		public BookBuilder publisher(String publisher) { 
			this.publisher = publisher;
			return this;
		}
		
		public Book build() {
			return new Book(title, author, publisher);
		}
		
	}
	
	//--- Builder(Factoty) 디자인 패턴
	
}
