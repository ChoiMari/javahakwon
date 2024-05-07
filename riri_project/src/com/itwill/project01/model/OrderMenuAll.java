package com.itwill.project01.model;

public class OrderMenuAll {

	public static final String TBL_FROG_ALLDER_MENU_TB = "FROG_ALLDER_MENU_TB";
	
//public static final String TBL_PIZZA_MENU= "FROG_PIZZA_MENU_TB";//DB 테이블 이름

	public static final String COL_PIZZA_NAME = "PIZZA_NAME"; //- primary key
	public static final String COL_PIZZA_PRICE= "PIZZA_PRICE"; //음수안됨	
	public static final String COL_PIZZA_KCAL = "PIZZA_KCAL"; //음수 안되고 소수점 2자리만 가능
	public static final String COL_PIZZA_COOK = "PIZZA_COOK"; 
	public static final String COL_PIZZA_POPULARITY = "PIZZA_POPULARITY"; 
	
	
//public static final String TBL_DRINK_MENU= "FROG_DRINK_MENU_TB";//DB테이블 이름
	
	//데이터베이스 테이블의 컬럼 이름들을 상수로 선언
	public static final String COL_DRINK_NAME = "DRINK_NAME"; //- primary key
	public static final String COL_DRINK_PRICE= "DRINK_PRICE"; //음수안됨
	public static final String COL_DRINK_KCAL = "DRINK_KCAL"; //음수 안되고 소수점 2자리만 가능
	public static final String COL_DRINK_POPULARITY = "DRINK_POPULARITY"; 
	
	
//public static final String TBL_SIDE_MENU= "FROG_SIDE_MENU_TB";//DB 테이블 이름
	
	//데이터베이스 테이블의 컬럼 이름들을 상수로 선언
	public static final String COL_SIDE_NAME = "SIDE_NAME"; //- primary key
	public static final String COL_SIDE_PRICE= "SIDE_PRICE"; //음수안됨
	public static final String COL_SIDE_KCAL = "SIDE_KCAL"; //음수 안되고 소수점 2자리만 가능
	public static final String COL_SIDE_COOK = "SIDE_COOK";
	public static final String COL_SIDE_POPULARITY = "SIDE_POPULARITY"; 
	
	//필드 선언
	private String pizzaName; // 고유키, null,중복 안됨.
	private int pizzaPrice; //음수 안됨
	private double pizzaKcal; //음수 안됨, 소수점 2번째까지만 가능
	private String pizzaCook;
	private int pizzaPopularity;

	//필드
	private String drinkName; //고유키
	private int drinkPrice; //음수 안됨
	private double drinkKcal; //음수 안됨, 소수점 2번째까지만 가능
	private int drinkPopularity;
	
	//필드
	private String sideName; //고유키
	private int sidePrice; //음수 안됨
	private double sideKcal; //음수 안됨, 소수점 2번째까지만 가능
	private String sideCook;
	private int sidePopularity;
	
	//생성자
	public OrderMenuAll() {}

	public OrderMenuAll(String pizzaName, int pizzaPrice, double pizzaKcal, String pizzaCook, int pizzaPopularity) {
		this.pizzaName = pizzaName;
		this.pizzaPrice = pizzaPrice;
		this.pizzaKcal = pizzaKcal;
		this.pizzaCook = pizzaCook;
		this.pizzaPopularity = pizzaPopularity;
	}

	public OrderMenuAll(String drinkName, int drinkPrice, double drinkKcal, int drinkPopularity) {
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkKcal = drinkKcal;
		this.drinkPopularity = drinkPopularity;
	}

	public OrderMenuAll(int sidePrice, String sideName,double sideKcal, String sideCook, int sidePopularity) {
		this.sideName = sideName;
		this.sidePrice = sidePrice;
		this.sideKcal = sideKcal;
		this.sideCook = sideCook;
		this.sidePopularity = sidePopularity;
	}

	public OrderMenuAll(String pizzaName, int pizzaPrice,String drinkName,
			int drinkPrice, String sideName, int sidePrice, String pizzaCook, int pizzaPopularity) {
		
		this.pizzaName = pizzaName;
		this.pizzaPrice = pizzaPrice;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.sideName = sideName;
		this.sidePrice = sidePrice;
		this.pizzaCook = pizzaCook;
		this.pizzaPopularity = pizzaPopularity;
	}

	public OrderMenuAll(String pizzaName, int pizzaPrice, double pizzaKcal, String pizzaCook, int pizzaPopularity,
			String drinkName, int drinkPrice, double drinkKcal, int drinkPopularity, String sideName, int sidePrice,
			double sideKcal, String sideCook, int sidePopularity) {
		super();
		this.pizzaName = pizzaName;
		this.pizzaPrice = pizzaPrice;
		this.pizzaKcal = pizzaKcal;
		this.pizzaCook = pizzaCook;
		this.pizzaPopularity = pizzaPopularity;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkKcal = drinkKcal;
		this.drinkPopularity = drinkPopularity;
		this.sideName = sideName;
		this.sidePrice = sidePrice;
		this.sideKcal = sideKcal;
		this.sideCook = sideCook;
		this.sidePopularity = sidePopularity;
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

	public int getDrinkPopularity() {
		return drinkPopularity;
	}

	public void setDrinkPopularity(int drinkPopularity) {
		this.drinkPopularity = drinkPopularity;
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

	public String getSideCook() {
		return sideCook;
	}

	public void setSideCook(String sideCook) {
		this.sideCook = sideCook;
	}

	public int getSidePopularity() {
		return sidePopularity;
	}

	public void setSidePopularity(int sidePopularity) {
		this.sidePopularity = sidePopularity;
	}

	@Override
	public String toString() {
		return "OrderMenuAll [pizzaName=" + pizzaName + ", pizzaPrice=" + pizzaPrice + ", pizzaKcal=" + pizzaKcal
				+ ", pizzaCook=" + pizzaCook + ", pizzaPopularity=" + pizzaPopularity + ", drinkName=" + drinkName
				+ ", drinkPrice=" + drinkPrice + ", drinkKcal=" + drinkKcal + ", drinkPopularity=" + drinkPopularity
				+ ", sideName=" + sideName + ", sidePrice=" + sidePrice + ", sideKcal=" + sideKcal + ", sideCook="
				+ sideCook + ", sidePopularity=" + sidePopularity + "]";
	}
	
	
}
