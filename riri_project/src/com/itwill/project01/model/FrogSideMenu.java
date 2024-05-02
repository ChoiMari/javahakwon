package com.itwill.project01.model;

public class FrogSideMenu {
	 // 데이터베이스 테이블 이름을 상수로 선언. 
    public static final String TBL_SIDE_MENU= "FROG_SIDE_MENU_TB";//DB 회원가입테이블 이름
	
	//데이터베이스 MEMBERSHIP_TB 테이블의 컬럼 이름들을 상수로 선언
	public static final String COL_SIDE_NAME = "SIDE_NAME"; //- primary key
	public static final String COL_SIDE_PRICE= "SIDE_PRICE"; //음수안됨
	
	//public static final생략하면 가시성(보여지는 범위) 어디까지일까? 
	//->답 : 패키지범위(수식어 없으면 패키지범위가 디폴트) 같은 패키지 안에서만 보임
	//그래서 여기서 public static final생략하면 안됨. 패키지범위면 import도 안됨.
	//인터페이스에서는 public static final인 필드만(상수만) 선언 가능함. 그래서 인터페이스안에서는 생략 가능한 것.
	//인터페이스에서 선언한 상수는(public범위) 그래서 import가능
	//public으로 공개하지 않으면 안보임.
	// 여기서는 public static final생략하면 안된다고 함. 
	
	public static final String COL_SIDE_KCAL = "SIDE_KCAL"; //음수 안되고 소수점 2자리만 가능
	public static final String COL_SIDE_COOK = "SIDE_COOK";
	public static final String COL_SIDE_POPULARITY = "SIDE_POPULARITY"; 
	
	//필드
	private String sideName; //고유키
	private int sidePrice; //음수 안됨
	private double sideKcal; //음수 안됨, 소수점 2번째까지만 가능
	private String sideCook;
	private int sidePopularity;
	
	//생성자
	public FrogSideMenu() {}

	public FrogSideMenu(String sideName, int sidePrice) {
		this.sideName = sideName;
		this.sidePrice = sidePrice;
	}

	public FrogSideMenu(String sideName, int sidePrice, double sideKcal, String sideCook, int sidePopularity) {
		this.sideName = sideName;
		this.sidePrice = sidePrice;
		this.sideKcal = sideKcal;
		this.sideCook = sideCook;
		this.sidePopularity = sidePopularity;
	}

	//getter & setter 
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
		return "FrogSideMenu [sideName=" + sideName + ", sidePrice=" + sidePrice + ", sideKcal=" + sideKcal
				+ ", sideCook=" + sideCook + ", sidePopularity=" + sidePopularity + "]";
	}
	
	
	

}
