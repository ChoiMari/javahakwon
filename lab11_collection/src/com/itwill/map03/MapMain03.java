package com.itwill.map03;

import java.util.HashMap;
import java.util.TreeMap;

public class MapMain03 {

	public static void main(String[] args) {
		//단어 개수 세기(word counting):
		//문자열에 등장하는 단어를 key로 하고
		//단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고, 출력
		
		String sentence = "짜장면 짬뽕 짜장면 볶음밥 김치찌개 부대찌개 김치찌개 된장찌개";
		//->결과 : {짜장면 = 2, 짬뽕 = 1, 볶음밥 = 1, 김치찌개 = 2, 부대찌개 = 1, 된장찌개 =1}
		// 순서 중요 X, 등장 횟수를 출력할 수 있어야!
		// 일단 단어별로 자르기 - split?? 공백으로 자르기 리턴타입 배열.
		// 배열에서 단어를 하나씩 꺼내면서 처음 등장하면 count = 1
		
		// String[]
		// Map<String, Integer>
		
		// 문자열 sentence를 공백으로 구분해서 단어들로만 이루어진 배열
		String[] words = sentence.split(" ");
		System.out.println(words); //출력 결과 - [Ljava.lang.String;@2ff4acd0
		
		for(String w : words) {
			System.out.print(w + ", ");
		}
		System.out.println();
		
		//단어(key), - 빈도수(value) 저장하기 위한 Map선언, 초기화
		//Hash 또는 Tree둘 다 가능
		HashMap<String, Integer> wordCounts = new HashMap<>();
		System.out.println(wordCounts);
		
		//배열에 저장된 단어들을 순서대로 하나씩 반복
		for(String w : words) { //배열에서 첫번째 단어 꺼냄 - 짜장면
			Integer count = wordCounts.getOrDefault(w, 0); //키값이 짜장면 , 키값이 없으면 0을 리턴해라.
					// getOrDefault()가 왜 Interger 타입을 리턴? 이해가 되어야!
					// Map 선언 시 키가 string, value string
					// getOrDefault() 키가 있으면 그 값을 리턴, 키가 없으면 아규먼트로 준 기본값이 리턴.
			wordCounts.put(w, count+1);
			System.out.println(wordCounts);
		}
		
		System.out.println("---------------");
		
		HashMap<String, Integer> wordCount2 = new HashMap<>();
		for(String w : words) {
			Integer count = wordCount2.get(w);
			if(count != null) { //몇번 등장 했는지 숫자가 있는 경우
				wordCount2.put(w, count+1);
			} else { 
				wordCount2.put(w,1);
			}
			System.out.println(wordCount2);//->중간 단계 보려고 출력해 봄
		}
//getOrDefault() :			
//찾는 key가 존재한다면 찾는 key의 value를 반환하고 없거나 null이면 default 값을 반환한다.
		//getOrDefault(Object key, V DefaultValue)
		//defaultValue -> 지정된 키로 매핑된 값이 없거나 null이면 반환하는 기본 값이다.
		
	}

}
