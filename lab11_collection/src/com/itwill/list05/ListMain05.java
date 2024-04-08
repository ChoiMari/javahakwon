package com.itwill.list05;

import java.util.ArrayList;

public class ListMain05 {

	public static void main(String[] args) {
		//Member 타입 객체들을 저장하는 ArrayList를 선언하고 초기화
		ArrayList<Member> members = new ArrayList<>();
		
		//members에 원소들을 저장
		//Member 지역변수 = new Member("","");
		members.add(new Member("admin","1111")); // 생성된 객체를 add메서드에게 아규먼트로 주는 것
		members.add(new Member("guest","guest"));
		members.add(new Member("itwill","0410"));
		members.add(new Member("TEST","test"));
		members.add(new Member("guest","0000"));
		
		//System.out.println(members); // 출력결과 [Member [id=, password=]
		// ArrayList가 toString()오버라이드 , Member가 toString() 오버라이드
		
		// 문제1
		// 향상된 for 문장을 사용해서 members의 원소들을 출력.(회원 1명의 내용을 한 줄 씩 출력하기) 
		
		for(Member m : members) {
			System.out.println(m);
		}
		
		// 문제2
		// 회원 아이디에 "est"가 포함된 회원 정보를 별도의(다른) 리스트에 저장하고 출력하기
		// 영문자의 대/소문자는 구분하지 않음(대문자나 소문자로 est가 되어도 됨)
		ArrayList<Member> list = new ArrayList<>(); //결과를 저장할 리스트
		for(Member m : members) { //하나씩 꺼내서 회원의 id찾기
			if(m.getId().toLowerCase().contains("est")) {
				list.add(m);
			} //id를 전부 다 대문자 toUpperCase() 로 바꾸거나 소문자 toLowerCase()로 바꿔서
			// 대문자 변환 시 contains("EST") , 소문자 변환 시 contains("est")가 들어 갔는지 검사하기
		}
		System.out.println(list);
		
		// 문제3
		//members에서 첫번째로 등장하는 아이디가 "guest"인 회원 삭제
		
		//Member클래스에 hashCode(),equals() 오버라이드 해서 가능.
		members.remove(new Member("guest", null));
		System.out.println(members);
		
		for(int i=0;i<members.size();i++) {
			if(members.get(i).getId().equals("guest")) {
				members.remove(i);
				break; //-> 기억하기. 리스트에서 get인덱스로 멤버 1개 찾고 id만 비교 "guest"와 같은지
				// 첫번째만 등장하는 "guest"만 삭제 해야되기 때문에 첫번째 찾아서 삭제 후 반복문 멈추기 break;
			}
		}
		
		
	}//main()끝

}
