package com.itwill.file06;

import java.io.Serializable;

public class Score implements Serializable {
	private int java;
	private int web;
	private int spring;
	
	//생성자,getter/setter,toString()
	
	public Score() {}
	public Score(int java, int web, int spring) {
		this.java = java;
		this.web = web;
		this.spring = spring;
	}
	
	public int getJava() {
		return this.java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	
	public int getWeb() {
		return this.web;
	}
	public void setWeb(int web) {
		this.web = web;
	}
	
	public int getSpring() {
		return this.spring;
	}
	public void setSpring() {
		this.spring = spring;
	}
	@Override
	public String toString() {
		return "Score [java=" + java + ", web=" + web + ", spring=" + spring + "]";
	}
	
	

}
