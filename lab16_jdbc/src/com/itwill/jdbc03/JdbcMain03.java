package com.itwill.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;
import static com.itwill.jdbc.OracleJdbc.*; //OracleJdbc에 있는거 전부다 import할거면 *;

public class JdbcMain03 {

	public static void main(String[] args) throws SQLException {
		// DriverManager가 커넥션을 맺음 그럼 커넥션 객체가 메서드를 호출 그럼 스테이트먼트를 실행하면 됨 stmt.메서드 호출해서 실행
		// update문장 실행 & 결과 처리
		
		// 1.오라클 드라이버 등록하기
		DriverManager.registerDriver(new OracleDriver());
		//-> 필요한 이유 드라이브매니져 : 데이터 베이스에 접속하는데
		//데이터 베이스 접속 방법이 프로그램마다 달라서 드라이브매니져한테 해당 데이터베이스(new OracleDriver())를 등록하는것
		//오라클이라고 등록함
		//그 다음에 연결을 맺어주세요(Connection) 해서 접속을 하는 것
		
		// 2. 오라클 DB에 접속
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		//Statement 객체 생성
		final String sql = "update blogs " 
				+ "set title = ?, content =?, modified_time = systimestamp "
				+ " where id = ?";
		//modified_time = systimestamp 의미 
		//-> modified_time(수정한 시간 컬럼)에 시스템의 현재시간 systimestamp 이 자동으로 들어감.
		//바뀔 수 있는 값들은 ?로 작성.
		//"update blogs "에 공백 주어야지 잘 들어감 안그러면 바로 붙음
		//systimestamp "에도 공백 줌.
		//이런 것들 대신에 상수 만든 것 써봐도 좋을 것 같다고 함..
		//?가 있는 형태의 문자열을 만든 다음에 PreparedStatement 준비를 하는 것.
		// 공백주어야 에러없이 실행 됨.
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//PreparedStatement에서 ?부분을 실제 값으로 대체하는 코드
		stmt.setString(1, "update 테스트"); //->ser title = ?자리에 들어가는 문장 
		stmt.setString(2, "업데이트 테스트.. 잘 되어야 할텐데..."); //->content =?자리에 들어가는 문장
		stmt.setInt(3, 1);//where id = ?에 들어가는 문장
		//stmt.setInt(3, 1); 의미 : 3번째 ?부분을 정수 1로 채운다.
		//실제 데이터 베이스에서 만든 컬럼 데이터 타입이 문자면 setString메서드 정수면 setInt메서드 사용
		
		//SQL 문장을 실행 & 결과 처리
		int result = stmt.executeUpdate();
		System.out.println(result + "개 행이 업데이트 됨.");
		
		//사용했던 DB 리소스 해제
		stmt.close();
		conn.close();
	}

}
