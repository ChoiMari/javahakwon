package com.itwill.inner01;

import com.itwill.inner01.EnclosingCls.NestedCls;
import com.itwill.inner01.OuterCls.InnerCls;

public class InnerMain01 {
	
	public static void main(String[] args) {
		//OuterCls 타입의 객체를 생성
		OuterCls outer1 = new OuterCls(1,1,"Java");
		System.out.println(outer1);
		
		//InnerCls 타입이 객체를 생성(static이 아닌 내부 클래스 객체 생성)
		OuterCls.InnerCls inner1 = outer1.new InnerCls(100);
		// 외부클래스의 객체가 있어야 하고 그 외부클래스의 참조 변수로 객체를 생성.
		//outer1 - 외부 클래스의 인스턴스
		// 이 만들어 진거(outer1)에서 .하고 생성자를 호출하겠다 정도로 이해하면 됨.
		inner1.info();
		
		// 내부 클래스 이름을 import 한 경우 - import 하더라도 외부클래스. 해서 써야..!! 
		// 내부클래스가 static으로 선언됐으면 그 내부 클래스를 import하면 외부클래스. 이렇게 안써두 됨,(외부클래스.은 생략 가능해짐)
		InnerCls inner2 = outer1.new InnerCls(200);
		inner2.info();
		
		//OuterCls.InnerCls inner3 인데 import문장 써서 생략 가능해서 InnerCls inner3이라고 씀
		InnerCls inner3 = new OuterCls(10, 20, "점심시간").new InnerCls(1234);
		//외부 클래스 객체가 있어야 .new 이렇게 내부 클래스 객체 생성도 가능해짐
		// 외부 클래스 객체 생성 new OuterCls(10, 20, "점심시간")하고 .으로 붙여서 내부 클래스 객체 생성함 .new InnerCls(1234);
		
		//inner2.getX(); -> 상속과 다른 점. 외부 클래스의 메서드 사용 못함.
		//선언한 class 안에서는 사용 가능하지만 이렇게 main()과 같은 다른 클래스에서 호출 못함 
		
		// EnclosingCls의 static field
		System.out.println("EnclosingCls.var = " + EnclosingCls.var);
		
		//EnclosingCls의 static method
		EnclosingCls.test();
		
		// EnclosingCls 타입 객체 생성
		EnclosingCls encl = new EnclosingCls(123);
		System.out.println(encl); //toString()
		
		// NestedCls 타입 객체 생성 - 변수 타입 이름 EnclosingCls.NestedCls 
		// static 내부 클래스는 클래스 이름으로 접근만 하면 된다
		EnclosingCls.NestedCls nested1 = new EnclosingCls.NestedCls(1); // import하면 더 간단하게 쓸 수 있음
		nested1.info();
		
		// 중첩 클래스 NestedCls 이름을 import한 경우
		//import com.itwill.inner01.EnclosingCls.NestedCls;
		NestedCls nested2 = new NestedCls(100);
		nested2.info();
		
	}

}
