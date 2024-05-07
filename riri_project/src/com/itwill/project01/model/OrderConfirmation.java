package com.itwill.project01.model;

import java.time.LocalDateTime;

//주문 완료 될때 DB테이블에 저장될 데이터들. ->주문 내역 & 내정보 메뉴에서 사용할 것임.
public class OrderConfirmation {
	//테이블 & 컬럼이름 상수 선언
	public static final String TBL_ORDER_CONFIRMATION_TB = "ORDER_CONFIRMATION_TB";
	public static final String COL_ORDER_ID = "ORDER_ID"; 
	public static final String COL_ORDER_NAME = "ORDER_NAME";
	public static final String COL_ORDER_PHONE = "ORDER_PHONE";
	public static final String COL_ORDER_EMAIL = "ORDER_EMAIL";
	public static final String COL_ORDER_JOIN_DATE = "ORDER_JOIN_DATE";
	public static final String COL_ORDER_TIME = "ORDER_TIME";
	
	public static final String COL_ORDER_PIZZA_NAME = "ORDER_PIZZA_NAME";
	public static final String COL_ORDER_PIZZA_PRICE = "ORDER_PIZZA_PRICE";
	public static final String COL_ORDER_PIZZA_KCAL = "ORDER_PIZZA_COOK";
	public static final String COL_ORDER_PIZZA_POPULARITY = "ORDER_PIZZA_POPULARITY";
	
	public static final String COL_ORDER_SIDE_NAME = "ORDER_SIDE_NAME";
	public static final String COL_ORDER_SIDE_PRICE = "ORDER_SIDE_PRICE";
	public static final String COL_ORDER_SIDE_KCAL = "ORDER_SIDE_KCAL";
	public static final String COL_ORDER_SIDE_COOK = "ORDER_SIDE_COOK";
	public static final String COL_ORDER_SIDE_POPULARITY = "ORDER_SIDE_POPULARITY";
	
	public static final String COL_ORDER_DRINK_NAME = "ORDER_DRINK_NAME";
	public static final String COL_ORDER_DRINK_PRICE = "ORDER_DRINK_PRICE";
	public static final String COL_ORDER_DRINK_KCAL = "ORDER_DRINK_KCAL";
	public static final String COL_ORDER_DRINK_POPULARITY = "ORDER_DRINK_POPULARITY";
	
	
	//필드 선언
	private String orderId;
	private String orderName;
	private String orderPhone;
	private String orderEmail;
	private LocalDateTime orderJoinDate;//->기본값 안들어감 회원가입정보 가져올거라서
	
	private LocalDateTime orderTime;//주문시간 - 기본값 자동으로 시스템시간 들어감.
	
	private String orderPizzaName;
	private int orderPizzaPrice;
	private double orderPizzaKcal;
	private String orderPizzaCook;
	private int orderPizzaPopularity;
	
	private String orderSideName;
	private int orderSidePrice;
	private double orderSideKcal;
	private String orderSideCook;
	private int orderSidePopularity;
	
	private String orderDrinkName;
	private int orderDrinkPrice;
	private double orderDrinkKcal;
	private int orderDrinkPopularity;
	
	//생성자
	public OrderConfirmation() {}

	public OrderConfirmation(String orderId, String orderName, String orderPhone, String orderEmail,
			LocalDateTime orderJoinDate, LocalDateTime orderTime, String orderPizzaName, int orderPizzaPrice,
			double orderPizzaKcal, String orderPizzaCook, int orderPizzaPopularity, String orderSideName,
			int orderSidePrice, double orderSideKcal, String orderSideCook, int orderSidePopularity,
			String orderDrinkName, int orderDrinkPrice, double orderDrinkKcal, int orderDrinkPopularity) {
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.orderEmail = orderEmail;
		this.orderJoinDate = orderJoinDate;
		this.orderTime = orderTime;
		this.orderPizzaName = orderPizzaName;
		this.orderPizzaPrice = orderPizzaPrice;
		this.orderPizzaKcal = orderPizzaKcal;
		this.orderPizzaCook = orderPizzaCook;
		this.orderPizzaPopularity = orderPizzaPopularity;
		this.orderSideName = orderSideName;
		this.orderSidePrice = orderSidePrice;
		this.orderSideKcal = orderSideKcal;
		this.orderSideCook = orderSideCook;
		this.orderSidePopularity = orderSidePopularity;
		this.orderDrinkName = orderDrinkName;
		this.orderDrinkPrice = orderDrinkPrice;
		this.orderDrinkKcal = orderDrinkKcal;
		this.orderDrinkPopularity = orderDrinkPopularity;
	}

	
	//getter & setter
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getOrderEmail() {
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	public LocalDateTime getOrderJoinDate() {
		return orderJoinDate;
	}

	public void setOrderJoinDate(LocalDateTime orderJoinDate) {
		this.orderJoinDate = orderJoinDate;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderPizzaName() {
		return orderPizzaName;
	}

	public void setOrderPizzaName(String orderPizzaName) {
		this.orderPizzaName = orderPizzaName;
	}

	public int getOrderPizzaPrice() {
		return orderPizzaPrice;
	}

	public void setOrderPizzaPrice(int orderPizzaPrice) {
		this.orderPizzaPrice = orderPizzaPrice;
	}

	public double getOrderPizzaKcal() {
		return orderPizzaKcal;
	}

	public void setOrderPizzaKcal(double orderPizzaKcal) {
		this.orderPizzaKcal = orderPizzaKcal;
	}

	public String getOrderPizzaCook() {
		return orderPizzaCook;
	}

	public void setOrderPizzaCook(String orderPizzaCook) {
		this.orderPizzaCook = orderPizzaCook;
	}

	public int getOrderPizzaPopularity() {
		return orderPizzaPopularity;
	}

	public void setOrderPizzaPopularity(int orderPizzaPopularity) {
		this.orderPizzaPopularity = orderPizzaPopularity;
	}

	public String getOrderSideName() {
		return orderSideName;
	}

	public void setOrderSideName(String orderSideName) {
		this.orderSideName = orderSideName;
	}

	public int getOrderSidePrice() {
		return orderSidePrice;
	}

	public void setOrderSidePrice(int orderSidePrice) {
		this.orderSidePrice = orderSidePrice;
	}

	public double getOrderSideKcal() {
		return orderSideKcal;
	}

	public void setOrderSideKcal(double orderSideKcal) {
		this.orderSideKcal = orderSideKcal;
	}

	public String getOrderSideCook() {
		return orderSideCook;
	}

	public void setOrderSideCook(String orderSideCook) {
		this.orderSideCook = orderSideCook;
	}

	public int getOrderSidePopularity() {
		return orderSidePopularity;
	}

	public void setOrderSidePopularity(int orderSidePopularity) {
		this.orderSidePopularity = orderSidePopularity;
	}

	public String getOrderDrinkName() {
		return orderDrinkName;
	}

	public void setOrderDrinkName(String orderDrinkName) {
		this.orderDrinkName = orderDrinkName;
	}

	public int getOrderDrinkPrice() {
		return orderDrinkPrice;
	}

	public void setOrderDrinkPrice(int orderDrinkPrice) {
		this.orderDrinkPrice = orderDrinkPrice;
	}

	public double getOrderDrinkKcal() {
		return orderDrinkKcal;
	}

	public void setOrderDrinkKcal(double orderDrinkKcal) {
		this.orderDrinkKcal = orderDrinkKcal;
	}

	public int getOrderDrinkPopularity() {
		return orderDrinkPopularity;
	}

	public void setOrderDrinkPopularity(int orderDrinkPopularity) {
		this.orderDrinkPopularity = orderDrinkPopularity;
	}

	
	
	
	
	@Override
	public String toString() {
		return "OrderConfirmation [orderId=" + orderId + ", orderName=" + orderName + ", orderPhone=" + orderPhone
				+ ", orderEmail=" + orderEmail + ", orderJoinDate=" + orderJoinDate + ", orderTime=" + orderTime
				+ ", orderPizzaName=" + orderPizzaName + ", orderPizzaPrice=" + orderPizzaPrice + ", orderPizzaKcal="
				+ orderPizzaKcal + ", orderPizzaCook=" + orderPizzaCook + ", orderPizzaPopularity="
				+ orderPizzaPopularity + ", orderSideName=" + orderSideName + ", orderSidePrice=" + orderSidePrice
				+ ", orderSideKcal=" + orderSideKcal + ", orderSideCook=" + orderSideCook + ", orderSidePopularity="
				+ orderSidePopularity + ", orderDrinkName=" + orderDrinkName + ", orderDrinkPrice=" + orderDrinkPrice
				+ ", orderDrinkKcal=" + orderDrinkKcal + ", orderDrinkPopularity=" + orderDrinkPopularity + "]";
	}

	
	
	
	
	
	

}
