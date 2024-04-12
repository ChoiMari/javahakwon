package com.itwill.inner01;

import com.itwill.inner01.OuterCls.InnerCls;

public class OuterCls {
	//filed
	private int x;
	private int y;
	private String s;
	
	// constructor
	public OuterCls(int x,int y, String s) {
		this.x = x;
		this.y = y;
		this.s = s;
	}
	
	//method
	public int getX() {
		return x;
	}
	
	@Override
	public String toString() {
		return String.format("OuterCls(x = %d, y = %d, s = %s)", x, y, s);
	}
	
	// static이 아닌 멤버 내부 클래스(위치 중요하지 않음. 클래스 {}내부에서만 선언하면 됨)
	public class InnerCls{ // public으로 선언된 외부 클래스 이름과 파일 이름이 같으면 됨 (내부는 상관 없음)
	
		//field
		private int y;
	
		//constructor
		public InnerCls(int y) {
			this.y = y;
		}
		//method
		public void info() { //변수는 가까운 곳에서 부터 찾는다.
			System.out.println("--- InnerCls ---");
			System.out.println("y = " + y); //InnerCls 인스턴스의 필드
			System.out.println("x = " + x); //OuterCls 인스턴스의 필드
			System.out.println("OuterCls y = " + OuterCls.this.y); //OuterCls.this.y -> 이름이 겹칠 경우 사용법. OuterCls 인스턴스의 필드의 y
			//-> 내부 클래스의 필드 이름과 외부 클래스의 필드 이름이 같은 경우
			//-> 외부 클래스 인스턴스 필드를 사용하는 방법 : 외부클래스이름.this.변수이름
			
			System.out.println("s = " + s); //OuterCls 인스턴스의 필드
			//-> (외부클래스에서 선언한 멤버(필드,생성자,메서드들을 자기 것처럼 쓸 수 있음)
		}
	}// end class InnerCls
	
}// end class OuterCls
