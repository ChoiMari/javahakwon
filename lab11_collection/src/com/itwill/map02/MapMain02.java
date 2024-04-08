package com.itwill.map02;

import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

	public static void main(String[] args) {
		// 문자열을 key로 하고, 정수를 value로 하는 TreeMap 선언, 초기화
		TreeMap<String, Integer> menu = new TreeMap<>();
		
		// 데이터 저장 - 중국집 메뉴판
		menu.put("짜장면", 7000);
		menu.put("짬뽕", 8000);
		menu.put("볶음밥", 8000);
	
		
		System.out.println(menu);
		//출력 결과 {볶음밥=8000, 짜장면=7000, 짬뽕=8000}
		//TreeMap 정렬 한글 가나다라 순서 정렬
		
		Set<String> keySet = menu.keySet(); //키들의 집합 - [볶음밥, 짜장면, 짬뽕] String. keySet() 리턴값 String
		
		//keySet() : TreeMap에서는 오름차순 정렬된 키들의 집합.
		for(String k : keySet) { //ketSet의 원소타입 써주면 됨. 
			System.out.println(k + ":" + menu.get(k));
			}
			
		
		//descendingKeySet(): TreeMap에서 내림 차순 정렬된 키들의 집합
		Set<String> keySet2 = menu.descendingKeySet();
		
		for(String k : keySet2) {
		System.out.println(k + "=" + menu.get(k));
				}
				
	}

}
