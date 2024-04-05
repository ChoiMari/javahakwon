package com.itwill.list01;

import java.util.ArrayList;

public class ListMain01 {

	public static void main(String[] args) {
		
		// 정수들을 저장하는 ArrayList(이라고 하는 클래스 이름이 있음)를 생성. 
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> numbers2 = new ArrayList<>();
		//-> 생성자 호출에서는 ArrayList의 원소 타입을 생략할 수 있음.
		
        // ArrayList에 저장된 원소 개수
        System.out.println("size = " + numbers.size());
        System.out.println(numbers);
		
		// ArrayList에 정수들을 저장.
		numbers2.add(1); // 아규먼트 자리에 Integer라는 객체를 넣으라고 했는데 
		// 정수 값을 넣어도 괜찮(오토 박싱) - 자동으로 값을 객체로 포장해서 넣어줌
		System.out.println("size = " + numbers.size()); // size() 원소 개수 
		
		// ArrayList에 정수들을 저장.
		numbers.add(1); //첫번째 저장된 원소 1의 인덱스 0
		numbers.add(100);
		numbers.add(-100);
		System.out.println("size = " + numbers.size()); //add()메서드 호출 할때 마다 사이즈가 늘어남
		
		//ArrayList에 저장된 원소(값) 가져오기 - add를 하는 순서대로 저장.
		System.out.println("[1]" + numbers.get(1));//get메서드의 아규먼트값으로는 index -> 원소의 위치 넣어주면 됨
		System.out.println("[1]" + numbers.get(2));
		
		//반복문
		for(int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i) + ",");
		}
		System.out.println();
	
		// 향상된 for문도 가능
		for(Integer x : numbers) { // 조건에 int라고 써도 됨(자동 언박싱 됨)
			// 고민 하기 싫으면 numbers 마우스에 대보면 타입나옴 그 타입으로 변수 선언하면 됨
			System.out.print(x + ",");
		}
		System.out.println();
		
		System.out.println(numbers); // ArrayList가 toString()메서드 오버라이드 하고 있음. 
		// 그래서 출력시 오브젝트의 toString()이 출력하는 형식인 주소값 형식으로 출력 안되고
		// 저장된 원소의 값이 출력됨
		

		
		// ArrayList의 원소 삭제
		numbers.remove(1); // remove(int index) ArrayList에 저장 된 해당 인덱스의 원소를 삭제하고 삭제한 값을 리턴해준다.
		System.out.println(numbers);
		
		//int가 아니라 integer을 사용해야 되는 경우 - valueOf()
		//문제 -100이라는 값을 지우고 싶은데 
		// numbers.remove(-100); // 이건 안됨. 아규먼트로 int값을 주면 이건 -100인덱스의 원소를 지우고 싶다는 것.
		//인덱스에는 -100이 없음
		// 여기서는 언박싱 사용 못한다.
		// Integer 객체를 넣어주어야.. 
		numbers.remove(Integer.valueOf(-100)); // remove(Object x) : 같은 값의 원소를 지움.
		// 삭제 시 주의 아규먼트로 int값 넣으면 인덱스의 원소 삭제
		// 아규먼트로 객체를 넣으면 그 값과 같은 원소를 삭제해줌.
		// equals로 값 비교하게 되어 있는 것.??
		
		
		
	}
}
