package com.itwill.singleton;

// 싱글턴 디자인 패턴(singleton dedign pattern)
// : heap에 오직 객체 1개만 생성
// 클래스를 설계할 때 객체를 오직 하나만 생성할 수 있도록 작성하는 디자인 패턴.
// 생성자를 public으로 공개를 하게 되면 어디에서나 new할 때마다 만들어지기 때문에
// -> 객체를 1개로 강제할 수 가 없음
// enum의 생성자 수식어 없더라도 항상 private
// 그래서 다른 곳에서 new할 수가 없음
// 싱글턴 디자인 패턴으로 만드는 방법
// 1. private static field
// 2. private constructor(생성자)
// 3. public static method를 제공. 

public class Captain {
	// 1. private static field
	private static Captain instance = null; 
	
	private String name;

	// 2. private constructor
	private Captain() { //main()에서는 호출 불가능 - private로 감추어져 있어서.
		this.name = "캡틴 아메리카";
		} 
	
	
	// 3. public static method //Captain타입으로 만든 메서드
	public static Captain getInstance() { 
		// static으로 만든 이유 : 객체생성(new)없이 호출해야 되기 때문에.
		// new없이(객체생성없이) Captain.으로 호출하면 되는 메서드.
		if(instance == null) { //instance가 null이면
			instance = new Captain(); // Captain();생성자 호출해서 객체 생성 -> instance변수에 저장.
			//instance에 heap에 있는 객체의 주소가 저장. => 이제 instance는 null이 아니게 됨. 
		}
		return instance; // => 이제 몇번을 호출하든 heap에 Captain객체는 딱 1번만 생성됨.
		// instance가 null일 때 new로 생성되고 더이상 생성 안됨.(instance가 null이 아니니까) 
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
