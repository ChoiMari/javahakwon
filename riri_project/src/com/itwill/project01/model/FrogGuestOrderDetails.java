package com.itwill.project01.model;

import java.time.LocalDateTime;

public class FrogGuestOrderDetails {
	 // 데이터베이스 테이블 이름을 상수로 선언. 
    public static final String TBL_FROG_GUEST_TB= "FROG_GUEST_TB";//DB 회원가입테이블 이름
	

	public static final String COL_GUEST_ID = "GUEST_ID";
	public static final String COL_GUEST_NAME= "GUEST_NAME"; 
	public static final String COL_GUEST_PHONE = "GUEST_PHONE"; 
	public static final String COL_GUEST_TASTE = "GUEST_TASTE";
	public static final String COL_PIZZA_NAME = "PIZZA_NAME"; 
	public static final String COL_PIZZA_KCAL = "PIZZA_KCAL"; //음수 안되고 소수점 2자리만 가능
	public static final String COL_DRINK_NAME = "DRINK_NAME"; 
	public static final String COL_DRINK_PRICE= "DRINK_PRICE"; //음수안됨
	public static final String COL_DRINK_KCAL = "DRINK_KCAL"; //음수 안되고 소수점 2자리만 가능

	public static final String COL_SIDE_NAME = "SIDE_NAME";
	public static final String COL_SIDE_PRICE= "SIDE_PRICE"; //음수안됨
	public static final String COL_SIDE_KCAL = "SIDE_KCAL"; //음수 안되고 소수점 2자리만 가능

	public static final String COL_ORDER_TIME = "ORDER_TIME"; //주문시간 기본값 시스템 현재 시간
	public static final String COL_PAYMENT_TIME = "PAYMENT_TIME";//주문시간 기본값 시스템 현재 시간
	
	public static final String COL_PIZZA_COOK = "PIZZA_COOK"; 
	public static final String COL_SIDE_COOK = "SIDE_COOK";
	public static final String COL_PIZZA_POPULARITY = "PIZZA_POPULARITY"; 
	public static final String COL_DRINK_POPULARITY = "DRINK_POPULARITY"; 
	public static final String COL_SIDE_POPULARITY = "SIDE_POPULARITY"; 
	public static final String COL_PAYMENT_METHOD = "PAYMENT_METHOD"; //결제 방식
	
	
	//필드
	private String guestId;
	private String guestName;
	private String guestPhone;
	private String guestTaste;
	private String pizzaName;
	private int pizzaPrice;
	private double pizzaKcal;
	private String drinkName;
	private int drinkPrice;
	private double drinkKcal;
	private String sideName;
	private int sidePrice;
	private double sideKcal;
	private LocalDateTime orderTime;
	private LocalDateTime paymentTime;
	private String pizzaCook;
	private String sideCook;
	private int pizzaPopularity;
	private int drinkopularity;
	private int sidePopularity;
	private String paymentMethod;
	
	//생성자
	public FrogGuestOrderDetails(){}

	public FrogGuestOrderDetails(String guestId, String guestName, String guestPhone, String guestTaste,
			String pizzaName, int pizzaPrice, double pizzaKcal, String drinkName, int drinkPrice, double drinkKcal,
			String sideName, int sidePrice, double sideKcal, LocalDateTime orderTime, LocalDateTime paymentTime,
			String pizzaCook, String sideCook, int pizzaPopularity, int drinkopularity, int sidePopularity,
			String paymentMethod) {
		this.guestId = guestId;
		this.guestName = guestName;
		this.guestPhone = guestPhone;
		this.guestTaste = guestTaste;
		this.pizzaName = pizzaName;
		this.pizzaPrice = pizzaPrice;
		this.pizzaKcal = pizzaKcal;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkKcal = drinkKcal;
		this.sideName = sideName;
		this.sidePrice = sidePrice;
		this.sideKcal = sideKcal;
		this.orderTime = orderTime;
		this.paymentTime = paymentTime;
		this.pizzaCook = pizzaCook;
		this.sideCook = sideCook;
		this.pizzaPopularity = pizzaPopularity;
		this.drinkopularity = drinkopularity;
		this.sidePopularity = sidePopularity;
		this.paymentMethod = paymentMethod;
	}

	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestPhone() {
		return guestPhone;
	}

	public void setGuestPhone(String guestPhone) {
		this.guestPhone = guestPhone;
	}

	public String getGuestTaste() {
		return guestTaste;
	}

	public void setGuestTaste(String guestTaste) {
		this.guestTaste = guestTaste;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public int getPizzaPrice() {
		return pizzaPrice;
	}

	public void setPizzaPrice(int pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}

	public double getPizzaKcal() {
		return pizzaKcal;
	}

	public void setPizzaKcal(double pizzaKcal) {
		this.pizzaKcal = pizzaKcal;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getDrinkPrice() {
		return drinkPrice;
	}

	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}

	public double getDrinkKcal() {
		return drinkKcal;
	}

	public void setDrinkKcal(double drinkKcal) {
		this.drinkKcal = drinkKcal;
	}

	public String getSideName() {
		return sideName;
	}

	public void setSideName(String sideName) {
		this.sideName = sideName;
	}

	public int getSidePrice() {
		return sidePrice;
	}

	public void setSidePrice(int sidePrice) {
		this.sidePrice = sidePrice;
	}

	public double getSideKcal() {
		return sideKcal;
	}

	public void setSideKcal(double sideKcal) {
		this.sideKcal = sideKcal;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getPizzaCook() {
		return pizzaCook;
	}

	public void setPizzaCook(String pizzaCook) {
		this.pizzaCook = pizzaCook;
	}

	public String getSideCook() {
		return sideCook;
	}

	public void setSideCook(String sideCook) {
		this.sideCook = sideCook;
	}

	public int getPizzaPopularity() {
		return pizzaPopularity;
	}

	public void setPizzaPopularity(int pizzaPopularity) {
		this.pizzaPopularity = pizzaPopularity;
	}

	public int getDrinkopularity() {
		return drinkopularity;
	}

	public void setDrinkopularity(int drinkopularity) {
		this.drinkopularity = drinkopularity;
	}

	public int getSidePopularity() {
		return sidePopularity;
	}

	public void setSidePopularity(int sidePopularity) {
		this.sidePopularity = sidePopularity;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "FrogGuestOrderDetails [guestId=" + guestId + ", guestName=" + guestName + ", guestPhone=" + guestPhone
				+ ", guestTaste=" + guestTaste + ", pizzaName=" + pizzaName + ", pizzaPrice=" + pizzaPrice
				+ ", pizzaKcal=" + pizzaKcal + ", drinkName=" + drinkName + ", drinkPrice=" + drinkPrice
				+ ", drinkKcal=" + drinkKcal + ", sideName=" + sideName + ", sidePrice=" + sidePrice + ", sideKcal="
				+ sideKcal + ", orderTime=" + orderTime + ", paymentTime=" + paymentTime + ", pizzaCook=" + pizzaCook
				+ ", sideCook=" + sideCook + ", pizzaPopularity=" + pizzaPopularity + ", drinkopularity="
				+ drinkopularity + ", sidePopularity=" + sidePopularity + ", paymentMethod=" + paymentMethod + "]";
	}
	
	
	
	
}
