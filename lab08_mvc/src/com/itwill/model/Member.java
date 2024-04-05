package com.itwill.model;

// MVC(Medel-view-controller) 아키텍쳐에서 모델 역할을 담당하는 클래스. 데이터 클래스.
//VO(Value Object)데이터만 표현하는 클래스라는 뜻.
//DTO(Data Transfer Object)데이터를 전송하는 오브젝트. 객체들간의 데이터를 주고받을 때 사용하는 객체라는 뜻.
//메서드 호출시 아규먼트를 전달 하거나, 리턴 값으로 돌려주거나

public class Member {
	//필드
	private String id;
	private String password;
	
	//생성자(constructor)
	public Member() {} 
	
	public Member(String  id, String password) { //오버로딩 - 같은 이름이지만 파라미터 선언을 다르게 하면 다르게 인식해서 사용이 가능한 것.
		this.id =id;
		this.password = password;
	}
	//method
	public String getId() {
		return this.id;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() { //오브젝트 클래스의 toString()오버라이드(메서드 재정의)
		return "Member(id=" + id + ", passwoed=" + password + ")"; //이런 형식으로 출력되게 코드 작성.
	}
}
