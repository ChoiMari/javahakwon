package com.itwill.project01.model;


import java.time.LocalDateTime;

public class OrderTb { // 오라클에서 insert시 기본값으로 매장에서 식사하기 들어가는 클래스
	//필드 선언
	private String orderId;

	
	private String orderPizza;
	private String orderDrink;
	private String orderSide;
	
	private String orderTotal;
	//필요시에 식사방법,주문시간만들기
	private String orderMealMethod;
	private LocalDateTime orderTime;
	
	//상수 선언
	public static final String TBL_ORDER_TB = "FROG_ORDER_TB";//매장에서 먹기
	
	public static final String TBL_PACKAING_ORDER_TB = "PACKAING_ORDER_TB";//포장
	
	public static final String COL_ORDER_ID = "ORDER_ID";

	
	
	public static final String COL_ORDER_PIZZA = "ORDER_PIZZA";
	public static final String COL_ORDER_DRINK = "ORDER_DRINK";
	public static final String COL_ORDER_SIDE = "ORDER_SIDE";
	
	public static final String COL_ORDER_TOTAL = "ORDER_TOTAL";
	
	//필요시에 식사방법,주문시간만들기 --기본값으로 들어감.
	public static final String COL_ORDER_MEAL_METHOD = "ORDER_MEAL_METHOD";
	public static final String COL_ORDER_TIME = "ORDER_TIME";
	
	
	//생성자
	public OrderTb() {}


	public OrderTb(String orderId, String orderPizza, String orderDrink, String orderSide, String orderTotal,
			String orderMealMethod, LocalDateTime orderTime) {
		this.orderId = orderId;
		this.orderPizza = orderPizza;
		this.orderDrink = orderDrink;
		this.orderSide = orderSide;
		this.orderTotal = orderTotal;
		this.orderMealMethod = orderMealMethod;
		this.orderTime = orderTime;
	}

	

	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getOrderPizza() {
		return orderPizza;
	}


	public void setOrderPizza(String orderPizza) {
		this.orderPizza = orderPizza;
	}


	public String getOrderDrink() {
		return orderDrink;
	}


	public void setOrderDrink(String orderDrink) {
		this.orderDrink = orderDrink;
	}


	public String getOrderSide() {
		return orderSide;
	}


	public void setOrderSide(String orderSide) {
		this.orderSide = orderSide;
	}


	public String getOrderTotal() {
		return orderTotal;
	}


	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}


	public String getOrderMealMethod() {
		return orderMealMethod;
	}


	public void setOrderMealMethod(String orderMealMethod) {
		this.orderMealMethod = orderMealMethod;
	}


	public LocalDateTime getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}


	@Override
	public String toString() {
		return "OrderTb [orderId=" + orderId + ", orderPizza=" + orderPizza + ", orderDrink=" + orderDrink
				+ ", orderSide=" + orderSide + ", orderTotal=" + orderTotal + ", orderMealMethod=" + orderMealMethod
				+ ", orderTime=" + orderTime + "]";
	}
	
	
	
	
	
//	private String orderId;
//	private String orderName;
//	private String orderPhone;
//	private String orderEmail;
//	private LocalDate orderJoinDate;
//	
//	private String orderPizza;
//	private String orderDrink;
//	private String orderSide;
//	
//	private String orderTotal;
//	//필요시에 식사방법,주문시간만들기
//	
//	//상수 선언
//	public static final String TBL_ORDER_TB = "ORDER_TB";
//	
//	public static final String COL_ORDER_ID = "ORDER_ID";
//	public static final String COL_ORDER_NAME = "ORDER_NAME";
//	public static final String COL_ORDER_PHONE = "ORDER_PHONE ";
//	public static final String COL_ORDER_EMAIL = "ORDER_EMAIL";
//	public static final String COL_ORDER_JOIN_DATE = "ORDER_JOIN_DATE";
//	
//	
//	public static final String COL_ORDER_PIZZA = "ORDER_PIZZA";
//	public static final String COL_ORDER_DRINK = "ORDER_DRINK";
//	public static final String COL_ORDER_SIDE = "ORDER_SIDE";
//	
//	public static final String COL_ORDER_TOTAL = "ORDER_TOTAL";
//	//필요시에 식사방법,주문시간만들기
//	
//	//생성자
//	public OrderTb() {}
//
//	public OrderTb(String orderId, String orderName, String orderPhone, String orderEmail, LocalDate orderJoinDate,
//			String orderPizza, String orderDrink, String orderSide, String orderTotal) {
//		this.orderId = orderId;
//		this.orderName = orderName;
//		this.orderPhone = orderPhone;
//		this.orderEmail = orderEmail;
//		this.orderJoinDate = orderJoinDate;
//		this.orderPizza = orderPizza;
//		this.orderDrink = orderDrink;
//		this.orderSide = orderSide;
//		this.orderTotal = orderTotal;
//	}
//
//	
//	//getter & setter
//	public String getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(String orderId) {
//		this.orderId = orderId;
//	}
//
//	public String getOrderName() {
//		return orderName;
//	}
//
//	public void setOrderName(String orderName) {
//		this.orderName = orderName;
//	}
//
//	public String getOrderPhone() {
//		return orderPhone;
//	}
//
//	public void setOrderPhone(String orderPhone) {
//		this.orderPhone = orderPhone;
//	}
//
//	public String getOrderEmail() {
//		return orderEmail;
//	}
//
//	public void setOrderEmail(String orderEmail) {
//		this.orderEmail = orderEmail;
//	}
//
//	public LocalDate getOrderJoinDate() {
//		return orderJoinDate;
//	}
//
//	public void setOrderJoinDate(LocalDate orderJoinDate) {
//		this.orderJoinDate = orderJoinDate;
//	}
//
//	public String getOrderPizza() {
//		return orderPizza;
//	}
//
//	public void setOrderPizza(String orderPizza) {
//		this.orderPizza = orderPizza;
//	}
//
//	public String getOrderDrink() {
//		return orderDrink;
//	}
//
//	public void setOrderDrink(String orderDrink) {
//		this.orderDrink = orderDrink;
//	}
//
//	public String getOrderSide() {
//		return orderSide;
//	}
//
//	public void setOrderSide(String orderSide) {
//		this.orderSide = orderSide;
//	}
//
//	public String getOrderTotal() {
//		return orderTotal;
//	}
//
//	public void setOrderTotal(String orderTotal) {
//		this.orderTotal = orderTotal;
//	}
//
//	@Override
//	public String toString() {
//		return "OrderTb [orderId=" + orderId + ", orderName=" + orderName + ", orderPhone=" + orderPhone
//				+ ", orderEmail=" + orderEmail + ", orderJoinDate=" + orderJoinDate + ", orderPizza=" + orderPizza
//				+ ", orderDrink=" + orderDrink + ", orderSide=" + orderSide + ", orderTotal=" + orderTotal + "]";
//	}
	
	
	

}
