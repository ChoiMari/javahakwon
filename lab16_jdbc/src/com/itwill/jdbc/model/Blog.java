package com.itwill.jdbc.model;

import java.time.LocalDateTime;

public class Blog {
	public static final class Entity{ //Entity.하면 상수 사용 가능. static이여서 객체생성필요 없음
		//데이터베이스 BLOGS테이블의 컬럼 이름들을 상수로 선언
		public static final String COL_ID = "ID";
		public static final String COL_TITLE = "TITLE"; 
		//public static final생략하면 가시성(보여지는 범위) 어디까지일까? 
		//->답 : 패키지범위(수식어 없으면 패키지범위가 디폴트) 같은 패키지 안에서만 보임
		//그래서 여기서 public static final생략하면 안됨. 패키지범위면 import도 안됨.
		//인터페이스에서는 public static final인 필드만(상수만) 선언 가능함. 그래서 인터페이스안에서는 생략 가능한 것.
		//인터페이스에서 선언한 상수는(public범위) 그래서 import가능
		//public으로 공개하지 않으면 안보임.
		// 여기서는 public static final생략하면 안된다고 함. 
		public static final String COL_CONTENT = "CONTENT";
		public static final String COL_WRITER = "WRITER";
		public static final String COL_CREATED_TIME = "CREATED_TIME";
		public static final String COL_MODIFIED_TIME = "MODIFIED_TIME";
		//여기에 선언한 상수들 데이터베이스에서 만든 실제 테이블의 컬럼이름과 같아야 함. 오타 X. ""으로 쓴 데이터(값)를 말하는 것 
		
	}
	
	
	private int id;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;
	
	public Blog() {}

	public Blog(int id, String title, String content, String writer, LocalDateTime createdTime,
			LocalDateTime modifiedTime) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer + ", createdTime="
				+ createdTime + ", modifiedTime=" + modifiedTime + "]";
	}
	
	
}
