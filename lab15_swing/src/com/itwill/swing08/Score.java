package com.itwill.swing08;

public class Score { //MVC중 모델 클래스
	private int korean;
	private int english;
	private int math;
	
	public Score() {}

	public Score(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	//메서드 - 총점, 평균
	
	public int getTotal() {
		return korean + english + math;
	}
	
	public double getMean() { //평균 소수점계산 - 실수 double 타입으로 리턴 타입 선언.
		return (double) getTotal() / 3;
	}
	
	@Override
	public String toString() {
		return "Score [korean=" + korean + ", english=" + english + ", math=" + math + "]";
	}
	
	
	

}
