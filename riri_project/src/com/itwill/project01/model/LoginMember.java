package com.itwill.project01.model;

import java.time.LocalDateTime;

//로그인 버튼 클릭시 로그인한 회원정보 DB에 저장시킬 데이터들
public class LoginMember {

	//테이블 이름 & 컬럼이름 상수 선언.
	public static final String TBL_LOGIN_MEMBER_TB = "LOGIN_MEMBER_TB";
	public static final String COL_LOGIN_ID = "LOGIN_ID";
	public static final String COL_LOGIN_PASSWORD = "LOGIN_PASSWORD";
	public static final String COL_LOGIN_NAME = "LOGIN_NAME";
	public static final String COL_LOGIN_PHONE = "LOGIN_PHONE";
	public static final String COL_LOGIN_EMAIL = "LOGIN_EMAIL";
	public static final String COL_LOGIN_JOIN_DATE = "LOGIN_JOIN_DATE";
	public static final String COL_LOGIN_CONNECTED_TIME = "LOGIN_CONNECTED_TIME";
	
	
	//필드
	private String loginId;
	private String loginPassword;
	private String loginName;
	private String loginPhone;
	private String loginEmail;
	
	private LocalDateTime loginJoinDate;
	private LocalDateTime loginConnectedTime;
	
	//생성자
	public LoginMember() {}

	public LoginMember(String loginId, String loginPassword, String loginName, String loginPhone, String loginEmail,
			LocalDateTime loginJoinDate, LocalDateTime loginConnectedTime) {
		this.loginId = loginId;
		this.loginPassword = loginPassword;
		this.loginName = loginName;
		this.loginPhone = loginPhone;
		this.loginEmail = loginEmail;
		this.loginJoinDate = loginJoinDate;
		this.loginConnectedTime = loginConnectedTime;
	}

	
	//getter & sertter
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPhone() {
		return loginPhone;
	}

	public void setLoginPhone(String loginPhone) {
		this.loginPhone = loginPhone;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public LocalDateTime getLoginJoinDate() {
		return loginJoinDate;
	}

	public void setLoginJoinDate(LocalDateTime loginJoinDate) {
		this.loginJoinDate = loginJoinDate;
	}

	public LocalDateTime getLoginConnectedTime() {
		return loginConnectedTime;
	}

	public void setLoginConnectedTime(LocalDateTime loginConnectedTime) {
		this.loginConnectedTime = loginConnectedTime;
	}

	@Override
	public String toString() {
		return "LoginMember [loginId=" + loginId + ", loginPassword=" + loginPassword + ", loginName=" + loginName
				+ ", loginPhone=" + loginPhone + ", loginEmail=" + loginEmail + ", loginJoinDate=" + loginJoinDate
				+ ", loginConnectedTime=" + loginConnectedTime + "]";
	}
	
	
	
	
	
	
	
}
