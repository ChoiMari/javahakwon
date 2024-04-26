package com.itwill.jdbc;

public interface OracleJdbc { //상수, 추상 메서드
	//상수 public static final 생략 가능 - 안써져 있어도 자동으로 붙여져 있는 것 
	
	//오라클 데이터베이스에 접속하기 위한 라이브러리 정보와 서버주소/포트/SID 정보
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	//->형식에 맞춰서 써주어야 함! 오라클 문서보면 써야한다고 알려져 있다고..
	//1521은 포트 번호 . 컴퓨터 들어오는 문
	//오라클 설치시 포트번호가 설정되어있었다고.. 다른 번호 쓰면 안됨.
	
	
	//오라클 데이터베이스에 접속할 수 있는 계정 이름
	String USER = "scott";
	
	//오라클 데이터 베이스에 접속할 때 사용할 비밀번호
	String PASSWORD = "tiger";
	
}

