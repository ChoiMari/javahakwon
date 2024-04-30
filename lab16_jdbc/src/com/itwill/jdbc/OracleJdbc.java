package com.itwill.jdbc;

public interface OracleJdbc { //상수, 추상 메서드
	//상수 public static final 생략 가능 - 안써져 있어도 자동으로 붙여져 있는 것 
	
	//오라클 데이터베이스에 접속하기 위한 라이브러리 정보와 서버주소/포트/SID 정보
	
	//String URL = "jdbc:oracle:thin:@192.168.20.31:1521:xe"; //선생님 컴퓨터에 접속???
	// 대부분은 컴퓨터 재부팅 할 때마다 유동 ip라고 함.
	//->외부에서 접속하려면 윈도우즈 방화벽 풀어야 한다고..
	
	//String URL = "jdbc:oracle:thin:@192.168.20.11:1521:xe";// --> 학원친구..다영 귀염
	//String URL = "jdbc:oracle:thin:@192.168.20.8:1521:xe";//-- 윤정 하트
	//String URL = "jdbc:oracle:thin:@192.168.20.1:1521:xe";//->영웅선생님
	//String URL = "jdbc:oracle:thin:@192.168.20.12:1521:xe";//->민선님 >_<
	//String URL = "jdbc:oracle:thin:@192.168.20.24:1521:xe";
	
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";//--local호스트 . 내꺼
	//->데이터베이스에 접속하기 위한 라이브러리 정보와 서버주소/포트/SID 정보
	
	//->형식에 맞춰서 써주어야 함! 오라클 문서보면 써야한다고 알려져 있다고..
	//1521은 포트 번호 . 컴퓨터 들어오는 문
	//오라클 설치시 포트번호가 설정되어있었다고.. 다른 번호 쓰면 안됨.
	//컴파일 -> 빌드 ->실행 run
	
	//오라클 데이터베이스에 접속할 수 있는 계정 이름
	String USER = "scott";
	
	//오라클 데이터 베이스에 접속할 때 사용할 비밀번호
	String PASSWORD = "tiger";
	
}

