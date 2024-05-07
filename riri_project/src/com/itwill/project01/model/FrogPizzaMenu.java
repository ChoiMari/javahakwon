package com.itwill.project01.model;

import java.time.LocalDateTime;

public class FrogPizzaMenu {
	
    // 데이터베이스 테이블 이름을 상수로 선언. 
    public static final String TBL_PIZZA_MENU= "FROG_PIZZA_MENU_TB";//DB 회원가입테이블 이름
	
	//데이터베이스 MEMBERSHIP_TB 테이블의 컬럼 이름들을 상수로 선언
	public static final String COL_PIZZA_NAME = "PIZZA_NAME"; //- primary key
	
	//public static final생략하면 가시성(보여지는 범위) 어디까지일까? 
	//->답 : 패키지범위(수식어 없으면 패키지범위가 디폴트) 같은 패키지 안에서만 보임
	//그래서 여기서 public static final생략하면 안됨. 패키지범위면 import도 안됨.
	//인터페이스에서는 public static final인 필드만(상수만) 선언 가능함. 그래서 인터페이스안에서는 생략 가능한 것.
	//인터페이스에서 선언한 상수는(public범위) 그래서 import가능
	//public으로 공개하지 않으면 안보임.
	// 여기서는 public static final생략하면 안된다고 함. 
	public static final String COL_PIZZA_PRICE = "PIZZA_PRICE";
	public static final String COL_PIZZA_KCAL = "PIZZA_KCAL"; //음수 안되고 소수점 2자리만 가능
	public static final String COL_PIZZA_COOK = "PIZZA_COOK"; 
	public static final String COL_PIZZA_POPULARITY = "PIZZA_POPULARITY"; 
	
	
	
	
	
	//필드 선언
	private String pizzaName; // 고유키, null,중복 안됨.
	private int pizzaPrice; //음수 안됨
	private double pizzaKcal; //음수 안됨, 소수점 2번째까지만 가능
	private String pizzaCook;
	private int pizzaPopularity;
	
	
//	private String pizzaCook;
//	private int pizzaPopularity;
	
//	private String drinkName; //고유키
//	private int drinkPrice; //음수 안됨
//	private double drinkKcal; //음수 안됨, 소수점 2번째까지만 가능
//	private int drinkPopularity;
//	
//	private String sideName;//고유키
//	private int sidePrice;//음수 안됨.
//	private double sideKcal;//음수 안됨, 소수점 2번째까지만 가능
//	private String sideCook;
//	private int sidePopularity;
	

	
	
	
//	private String guestId;
//	private String guestName;
//	private String guestPhone;
//	private String guestTaste;
//	private LocalDateTime orderTime;//주문 시간 -- 기본값 시스템의 현재시간으로 설정.
//	private LocalDateTime paymentTime;//결제 시간 -- 기본값 시스템의 현재시간으로 설정.
//	
	
	
	
	//생성자
	public FrogPizzaMenu() {}

	public FrogPizzaMenu(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public FrogPizzaMenu(String pizzaName, int pizzaPrice) {
		this.pizzaName = pizzaName;
		this.pizzaPrice = pizzaPrice;
	}

	public FrogPizzaMenu(String pizzaName, int pizzaPrice, double pizzaKcal) {
		this.pizzaName = pizzaName;
		this.pizzaPrice = pizzaPrice;
		this.pizzaKcal = pizzaKcal;
	}

	public FrogPizzaMenu(String pizzaName, int pizzaPrice, String pizzaCook, int pizzaPopularity) {
		this.pizzaName = pizzaName;
		this.pizzaPrice = pizzaPrice;
		this.pizzaCook = pizzaCook;
		this.pizzaPopularity = pizzaPopularity;
	}

	public FrogPizzaMenu(String pizzaName, int pizzaPrice, double pizzaKcal, String pizzaCook, int pizzaPopularity) {
		this.pizzaName = pizzaName;
		this.pizzaPrice = pizzaPrice;
		this.pizzaKcal = pizzaKcal;
		this.pizzaCook = pizzaCook;
		this.pizzaPopularity = pizzaPopularity;
	}
	

	//getter & setter
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

	public String getPizzaCook() {
		return pizzaCook;
	}

	public void setPizzaCook(String pizzaCook) {
		this.pizzaCook = pizzaCook;
	}

	public int getPizzaPopularity() {
		return pizzaPopularity;
	}

	public void setPizzaPopularity(int pizzaPopularity) {
		this.pizzaPopularity = pizzaPopularity;
	}

	@Override
	public String toString() {
		return "FrogPizzaMenu [pizzaName=" + pizzaName + ", pizzaPrice=" + pizzaPrice + ", pizzaKcal=" + pizzaKcal
				+ ", pizzaCook=" + pizzaCook + ", pizzaPopularity=" + pizzaPopularity + "]";
	}
	
	
	
	

	
	
}
