package com.itwill.list05;

import java.util.Objects;

public class Member {
	
	private String id;
	private String password;
	
	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) //생성된 객체와 아규먼트의 주소 값이 같을 때
			return true;
		if (obj == null) // 주소가 다를 때 아규먼트가 일단 null이면 false
			return false;
		if (getClass() != obj.getClass())  // 같은 클래스 타입이 아니라면
			return false; // false
		Member other = (Member) obj; // 클래스 타입이 같다면 Member타입으로 변환
		return Objects.equals(id, other.id); // 서로 같으면 true리턴
	}
		
}
