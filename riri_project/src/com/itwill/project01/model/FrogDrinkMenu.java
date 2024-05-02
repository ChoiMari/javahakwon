package com.itwill.project01.model;

public class FrogDrinkMenu {
	
	
    // 데이터베이스 테이블 이름을 상수로 선언. 
    public static final String TBL_DRINK_MENU= "FROG_DRINK_MENU_TB";//DB 회원가입테이블 이름
	
	//데이터베이스 MEMBERSHIP_TB 테이블의 컬럼 이름들을 상수로 선언
	public static final String COL_DRINK_NAME = "DRINK_NAME"; //- primary key
	public static final String COL_DRINK_PRICE= "DRINK_PRICE"; //음수안됨
	
	//public static final생략하면 가시성(보여지는 범위) 어디까지일까? 
	//->답 : 패키지범위(수식어 없으면 패키지범위가 디폴트) 같은 패키지 안에서만 보임
	//그래서 여기서 public static final생략하면 안됨. 패키지범위면 import도 안됨.
	//인터페이스에서는 public static final인 필드만(상수만) 선언 가능함. 그래서 인터페이스안에서는 생략 가능한 것.
	//인터페이스에서 선언한 상수는(public범위) 그래서 import가능
	//public으로 공개하지 않으면 안보임.
	// 여기서는 public static final생략하면 안된다고 함. 
	
	public static final String COL_DRINK_KCAL = "DRINK_KCAL"; //음수 안되고 소수점 2자리만 가능
	public static final String COL_DRINK_POPULARITY = "DRINK_POPULARITY"; 
	
	//필드
	private String drinkName; //고유키
	private int drinkPrice; //음수 안됨
	private double drinkKcal; //음수 안됨, 소수점 2번째까지만 가능
	private int drinkPopularity;
	
	//생성자
	public FrogDrinkMenu() {}

	public FrogDrinkMenu(String drinkName, int drinkPrice) {
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
	}

	public FrogDrinkMenu(String drinkName, int drinkPrice, double drinkKcal, int drinkPopularity) {
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkKcal = drinkKcal;
		this.drinkPopularity = drinkPopularity;
	}

	//getter & setter
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

	@Override
	public String toString() {
		return "FrogDrinkMenu [drinkName=" + drinkName + ", drinkPrice=" + drinkPrice + ", drinkKcal=" + drinkKcal
				+ ", drinkPopularity=" + drinkPopularity + "]";
	}
	
	
	
	
	
	

}
