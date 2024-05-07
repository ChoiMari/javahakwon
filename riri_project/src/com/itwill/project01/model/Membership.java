package com.itwill.project01.model;

import java.time.LocalDateTime;

public class Membership {
	
	public static final class Member{ // Member.하면 상수 사용 가능. static이여서 객체생성필요 없음
        // 데이터베이스 테이블 이름을 상수로 선언. 
        public static final String TBL_MEMBERSHIP = "MEMBERSHIP_TB";//DB 회원가입테이블 이름
		
		//데이터베이스 MEMBERSHIP_TB 테이블의 컬럼 이름들을 상수로 선언
		public static final String COL_ID = "ID"; //ID - primary key
		public static final String COL_PASSWORD = "PASSWORD"; //not null
		
		//public static final생략하면 가시성(보여지는 범위) 어디까지일까? 
		//->답 : 패키지범위(수식어 없으면 패키지범위가 디폴트) 같은 패키지 안에서만 보임
		//그래서 여기서 public static final생략하면 안됨. 패키지범위면 import도 안됨.
		//인터페이스에서는 public static final인 필드만(상수만) 선언 가능함. 그래서 인터페이스안에서는 생략 가능한 것.
		//인터페이스에서 선언한 상수는(public범위) 그래서 import가능
		//public으로 공개하지 않으면 안보임.
		// 여기서는 public static final생략하면 안된다고 함. 
		
		public static final String COL_NAME = "NAME"; // not null
		public static final String COL_EMAIL = "EMAIL"; // not null + unique
		public static final String COL_PHONE_NUMBER = "PHONE_NUMBER"; // not null
		public static final String COL_JOIN_DATE = "JOIN_DATE"; 
		//가입 날짜. 제약 조건 없음  default systimestamp 기본값으로 시스템의 현재 날짜,시간 들어가게 설정.
		//여기에 선언한 상수들 데이터베이스에서 만든 실제 테이블의 컬럼이름과 같아야 함. 오타 X. ""으로 쓴 데이터(값)를 말하는 것 
		
	}
	
	
	
	//필드
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone;
	private LocalDateTime joinDate;
	
	//생성자
	public Membership() {}
	
	public Membership(String id) {
		this.id = id;
	}
	
	public Membership(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Membership(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}

	
	public Membership(String id, String password, String name, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public Membership(String id, String password, String name, String email, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public Membership(String id, String password, String name, String email, String phone, LocalDateTime joinDate) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.joinDate = joinDate;
	}

	
	// getter & setter
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Membership [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", phone="
				+ phone + ", joinDate=" + joinDate + "]";
	}
	
	
	
	
	

}