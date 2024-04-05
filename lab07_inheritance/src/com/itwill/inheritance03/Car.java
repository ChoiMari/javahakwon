package com.itwill.inheritance03;

// 하이브리드 자동차는 자동차이다.
// 자동차 - 상위 타입, 하이브리드 자동차 - 하위 타입
// class HybridCar extends Car
public class Car {
	// field
	private int fuel;  // 연료
	private int speed; // 속력
	
	// 생성자
	public Car(int fuel, int speed) {
		this.fuel = fuel;
		this.speed = speed;
	}
	
	public int getfuel() {
		return fuel;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	
	// 메서드
	public void drive() {
		System.out.println("자동차 운전중(speed: " + speed + ", 연료: " + fuel + " )");
	}
	
	
}
