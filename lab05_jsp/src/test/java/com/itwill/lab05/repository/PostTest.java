package com.itwill.lab05.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostTest {
	private static final Logger log = LoggerFactory.getLogger(PostTest.class);

	//JUnit 모듈에서 단위 테스트를 하기 위해서 호출하는 메서드.
	//(1) public void (2) 아규먼트를 갖지 않음.  이거 2개를 지켜주면서 애너테이션을 써주면 됨. 
	//메서드 이름은 상관없음
	@Test
	public void test() {
		//Post 타입 객체 생성 - Builder 디자인 패턴.
		Post p = Post.builder()
				.title("테스트")
				.author("관리자")
				.content("builder design pattern")
				.id(1)
				.build();
		
		// assertNotNull(arg): arg가 null이 아니면 JUnit 테스트 성공, null이면 테스트 실패
		Assertions.assertNotNull(p); // 전부 static메서드로 되어있어서 객체생성 필요없이 클래스이름.으로 메서드 호출해서 사용가능.
		
		//Assertions.assertNull(arg) : arg가 null이면 단위 테스트 성공, null이 아니면 테스트 실패.
		//Assertions.assertNull(p); // p가 null이어야 성공.
		log.debug("p = {}" , p);
	}
}
