package com.itwill.jdbc01;

import static com.itwill.jdbc.OracleJdbc.*; //보통 상수들 가져올 때 이렇게 import한다고 함
import static com.itwill.jdbc.model.Blog.Entity.*; //Entity클래스 안에 있는 거(상수들) 다 쓸거면 *
import java.sql.Connection;
import java.sql.DriverManager; //java.은 자바 프로그램에서만 만들수있는 패키지라고..
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.driver.OracleDriver;


/*
 * JDBC(Java Database Connectivity):
 * 자바 프로그램에서 데이터베이스를 연결하고, SQL 문장들을 실행해서 그 결과를 처리. 
 * 
 * 
 * 1. Oracle JDBC 라이브러리 다운로드하고 이클립스 프로젝트의 빌드패스에 추가
 * 	(1) https://central.sonatype.com(메이븐 중앙 저장소)에서 ojdbc11을 검색
 * 		-->com.oracle.database.jdbc:ojdbc11:23.3.x.x.x 라이브러리를 다운로드
 * 		-->ojdbc11-23.3.0.x.x.jar
 * 	(2) 이클립스 프로젝트에 lib 폴더를 만들고, jar 파일을 복사.
 * 	(3) jar 파일 오른쪽 클릭 -> Build path --> Add to build path
 * 	Build path : 프로그램에 라이브러리들이 있어야 import해서 사용가능. 일단 라이브러리 다운 받고
 * 	폴더에 갖다넣고 필드패스에 추가를 하면 된다고.. 
 *  같은 프로젝트의 클래스 이름들 import해서 사용하는데 관련 라이브러리가 있어야 import가능.
 *  2. 데이터 베이스에 접속하기 위한 정보들(URL, USER, PASSWORD,...)을 상수로 정의
 *  3. 프로그램에서 오라클 JDBC 라이브러리를 메모리에 로딩.(등록)
 *  4. 오라클 데이터베이스에 접속
 *  5. Statement 타입의 객체 생성 - DB에서 실행할 SQL 문장을 작성하고 실행할 수 있는 객체
 *  6. Statement 타입 인스턴스에서 메서드를 호출해서 SQL 문장을 실행.
 *  	(1) executeQuery() : DQL(select 문장) : SQL이 select 문장일 때 호출하는 메서드
 *  	(2) executeUpdate() : DML(insert, update, delete 문장)SQL이 insert, update, delete 문장일 때 호출하는 메서드
 *  7. 메서드 실행 결과(리턴값)을 처리
 *  8. 사용했었던 모든 리소스들을 해제(close() 메서드 호출) 
 */

public class JdbcMain01 {

	public static void main(String[] args) throws SQLException {
		//sql에서 테이블 만든 후
		//1. 끝남, 2.인터페이스로 만들어 놓음 - import하기: import static com.itwill.jdbc.OracleJdbc.*;
		
		//3. 오라클 JDBC 라이브러리를 사용할 수 있도록 등록 - 기억해 두라고 함.DriverManager클래스
		DriverManager.registerDriver(new OracleDriver()); //import oracle.jdbc.driver.OracleDriver;로 import하라고 함
		System.out.println("오라클 드라이버 등록 성공");
		
		// 4. 오라클 데이터베이스에 접속 - 오라클 세션을 생성한다.
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		//URL, USER, PASSWORD는 com.itwill.jdbc패키지의 OracleJdbc 인터페이스에서 만든 상수들
		//getConnection메서드도 예외 발생할 수 있다고 뜸. try-catch로 묶어야 한다고..
		System.out.println("오라클 접속 성공");
		
		 //  5. Statement 타입- (부모타입) 의 객체 생성 - DB에서 실행할 SQL 문장을 작성하고 실행할 수 있는 객체
		// 실제로 우리가 사용할 객체는 PreparedStatement (인터페이스) 라고 함. -import해야함
		
		//sql문장 만듬
		final String sql = "select * from blogs order by id desc"; //id의 내림차순 정렬 - 가장 최신 블로그가 검색되게 설정.
		//**주의 : Statement 객체에서 사용하는 SQL문장은 세미콜론(;)을 사용하지 않음!
		
		//- prepareStatement(sql) DB에서 실행할 SQL 문장을 작성하고 실행할 수 있는 객체를 만들고 PreparedStatement타입으로 객체값을 리턴받아서
		//PreparedStatement타입의 stmt에 저장.
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		 //  6. Statement 타입 인스턴스에서 메서드를 호출해서 SQL 문장을 실행.
		 //  	(1) executeQuery() : DQL(select 문장) : SQL이 select 문장일 때 호출하는 메서드
		 //  	(2) executeUpdate() : DML(insert, update, delete 문장)SQL이 insert, update, delete 문장일 때 호출하는 메서드
		
		ResultSet rs = stmt.executeQuery(); // select 문장일 경우 호출하는 PreparedStatement에 있는 메서드
		 //ResultSet테이블을 담고 있는 객체.
		//  7. 메서드 실행 결과(리턴값)을 처리
		//자바프로그램 오라클에 접속함. Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		//stmt.executeQuery(); ->sql문장 db서버에 보냄 DB서버가 select문장 실행 -> 테이블 보내줌
		// 그 테이블을 ResultSet 이라고 생각하면 된다고. ResultSet -> DB에서 리턴해주는 테이블
		// 테이블에서 각각의 행에서 각각의 컬럼들을 읽는다 이런 동작들을 반복을 해야함
		//그게 언제 끝날지 모르니까 알려주는 메서드가 있다고 rs.next()
		while (rs.next()) { //->rs.next() : 테이블에 행이 있으면 true를 리턴, 행이 없으면 false //true면 밑으로 내려간다고..
			//ResultSet(테이블을 담고 있는 객체)에서 다음 행이 있는 지를 검사
			// 그 행의 컬럼들에 있는 값을 읽음.
			int id = rs.getInt(COL_ID); //테이블의 ID 컬럼값을 읽은 것
			String title = rs.getString(COL_TITLE); // 자리수가 크면 long타입으로 받거나 소수점이면 double타입으로 받기
			//.getDouble, getInt 다 있다고 타입들마다..
			String content = rs.getString(COL_CONTENT);
			String writer = rs.getString(COL_WRITER);
			LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();//생성시간 
			//.toLocalDateTime();붙인 이유 : getTimestamp("CREATED_TIME")이 리턴 타입이 타임스템프타입이여서..
			//LocalDateTime타입으로 받아야 편의 메서드들을 더 많이 가지고 있어서 LocalDateTime 타입으로 리턴값을 받으려고 
			//LocalDateTime 자바에서는 시간 쓸거면 이 클래스 쓰는게 더 낫다고
			
			//수정시간
			LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME).toLocalDateTime();
			//클래스 새로 하나 만듬 - model패키지 - Blog클래스
			
			Blog blog = new Blog(id, title, content, writer, createdTime, modifiedTime);
			System.out.println(blog);
		} //끝나면 올라가서 또 rs.next()호출 행이 또 테이블에 있으면 true 반복문 실행
		//다시 또 올라가서 rs.next()호출 테이블에 행이 없으면 false를 리턴 받아 반복문 종료
		//데이터베이스에서 리턴해준 모든 행을 다 읽을 수 있다고.
		//행이 있는지 검사 rs.next()로. 1행부터 다음행이 없을 때까지 읽고 실행.
		
		
		//8. DB 관련 리소스 해제
		//오라클과 접속 끊기 -- close()도 예외발생할 수있다고
		
		//DB관련 리소스에는 Connection,Statement,ResultSet가 있는데 전부 해제해야 한다고
		// 가장 나중에(마지막에) 생성한 리소스먼저 해제해야한다고..
		//리소스를 해제할 때는 리소스가 생성된 순서의 반대로. 리소스들 끼리 아규먼트로 연결된 상태 아니라서 
		// 전부 다 각각 해제해야 함.
		rs.close(); //ResultSet 해제
		stmt.close();//Statement 해제
		conn.close();//오라클 접속 끊기
		System.out.println("오라클 접속 해제");
		
		
		
//포트는 컴퓨터로 들어 올 때의 문
		// 오라클 db서버(컴퓨터) 렌선으로 들어오는 문에 따라서 갈 수 있는 곳이 달라진다고..
		// 외부에서 접속이 들어올 때 어느쪽으로만 가라라는 일종의 그런 문들이 있다고.. 그런걸 포트라고 함
		// 그리고 포트마다 번호가 붙어 있다고.. 컴퓨터의 여러개의 포트들 중 오라클은 1521번 포트를 쓴다고 함.
		// 1521번이 오라클로 접속 할 수 있는 문이라고..
		// 웹서버는 일반적으로 80번이라는 포트를 쓴다고..
		// 모든 인터넷 연결은 80번이 기본 포트라고 80번이 들어올 떄의 문이라고..
		// 인터넷 연결에 :80이 생략 되었다고 함.
		// 외부에서 들어오는 포트를 통해서 프로그램이나 서버에 접속 할 수있음
		// 방화벽으로 import를 막아버리면 외부접속 안된다고 함.
		
	}

}
