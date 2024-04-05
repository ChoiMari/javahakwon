package com.itwill.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		// Captain 타입의 객체 생성
		Captain captain = Captain.getInstance();//stack에 생성 되어있는 지역 수 captain : heap에 생성된 객체의 주소 값 저장
		System.out.println(captain);  //heap에 저장된 Captain()객체의 주소 값 출력
		System.out.println(captain.getName());
		
		Captain captain2 = Captain.getInstance();
		System.out.println(captain2);
		
		captain2.setName("아이언맨");
		System.out.println(captain.getName());
		System.out.println(captain.getName());
		
		// enum을 이용한 싱글턴 패턴 사용 방법
		Singleton s1 = Singleton.INSTANCE;
		System.out.println(s1); // enum은 toString()을 오버라이드(메서드재정의)를 했기 때문에
		// 주소값을 볼 수가 없다. 그냥 열거상수 이름이 나옴.
		
		System.out.println(s1.getName());
		s1.setName("블랙위도우");
		System.out.println(s1.getName()); //출력 결과 : 블랙위도우

		Singleton s2 = Singleton.INSTANCE; //s1과 s2는 같은 거겠지라고 생각할 수 있음
		System.out.println(s2.getName()); //출력 결과 : 블랙위도우
		
	
	}

}
