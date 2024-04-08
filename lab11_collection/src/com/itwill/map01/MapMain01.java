package com.itwill.map01;

import java.util.HashMap;
import java.util.Set;

/*
 * 
 */

public class MapMain01 {

	public static void main(String[] args) {
		//정수를 Key로 하고, 문자열을 value로 하는 HashMap을 선언, 초기화
		HashMap<Integer, String> map = new HashMap<>(); //new 생성자<>안에 타입은 생략 가능
		System.out.println(map); //출력결과 {}
		System.out.println("size = " + map.size());
		
		//map에 key-value 데이터를 저장
		map.put(1, "홍길동");
		map.put(10, "오쌤");
		map.put(101, "홍길동");
		
		System.out.println(map); //저장한 순서대로 출력 되지 않음
		//{1=홍길동, 101=홍길동, 10=오쌤}
		//->Integer의 HashCode 
		
		//map에 저장된 값(value)를 찾는 메서드 : get(key)
		// 키가 존제하면 value를 리턴
		String value = map.get(1);
		System.out.println(value); //key를 아규먼트로 전달하면 value를 읽어 준다.
		
		value = map.get(100);//-> key가 없으면 null를 리턴
		System.out.println(value); //출력 결과 : null
		
		//getOrDefault : key가 존재하면 key에 매핑된 value 값을 리턴
		// key가 없으면 아규먼트 defaultValue 리턴.
		value = map.getOrDefault(10, "무명씨");
		System.out.println(value); //출력 결과 : 오쌤
		
		value = map.getOrDefault(11, "무명씨");
		System.out.println(value); //출력 결과 : 무명씨 //key가 없어서 DefaultValue값으로 넘긴 아규먼트를 리턴해 줌
		
		// keySet():Map의 키(key)들로 이루어진 집합(set)을 리턴.
		Set<Integer> keySet = map.keySet();//key들의 집합을 리턴
		// key값은 중복되면 안되니까 리턴 타입은 Set
		System.out.println(keySet);
		
		for(Integer k : keySet) {
			System.out.println(k + ":" + map.get(k));
		}
		
		//Map에 저장된 데이터를 삭제:
		map.remove(101);//101번을 지우겠다 하면 리턴 값은 "홍길동" //키에 매핑된 value도 같이 삭제됨
		//key를 지우겠다 하면 value값이 리턴됨. 쌍으로 이루어진 데이터를 지워줌 
		System.out.println(map);
		
		//put(key, value) :
		//1. 키가 존재하지 않으면. 새로운 key - value 쌍의 데이터를 저장
		//2. key가 존재하면 해당 키의 값을 변경
		map.put(10, "No Name"); //키 10과 한쌍인 value값 오쌤을 No Name으로 변경
		System.out.println(map);
	}

}
