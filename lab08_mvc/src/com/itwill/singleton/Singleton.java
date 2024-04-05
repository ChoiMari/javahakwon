package com.itwill.singleton;

public enum Singleton {
	INSTANCE; //-> public static final SIngleton INSTANCE = new Singleton(); 을 간단하게 쓴 것.
	
	private String name;
	
	Singleton(){
		this.name = "헐크";
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}

