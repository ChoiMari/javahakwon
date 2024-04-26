package com.itwill.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;

public class JdbcMain02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //콘솔 입력
		
		//insert 문장 실행하고 결과 처리
		
		Connection conn = null; //finally에서도 사용하려고 지역변수로 안 만드려고 try문 밖에 선언
		PreparedStatement stmt = null;
		try {
			//1. 오라클 드라이버(오라클 라이브러리)등록
			DriverManager.registerDriver(new OracleDriver());
			//OracleDriver() import 문 패키지이름 짧은거로 선택하라고 import oracle.jdbc.OracleDriver;
			
			//2.오라클 DB접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);//static으로 선언되어있고 import해서 
			//객체 생성 없이 OracleJdbc.할 필요 없이 바로 상수이름으로 사용 가능
			
			//3.Statement 객체 생성
			final String sql = "insert into blogs (title, content, writer) values (?,?,?)";
			// 값들은 실행할 때 마다 바뀜. 그래서 ?,?,?로 
			stmt = conn.prepareStatement(sql);
			
			System.out.print("제목 입력>> ");
			String title = sc.nextLine();
			System.out.print("내용 입력>> ");
			String content = sc.nextLine();
			System.out.print("작성자 입력>> ");
			String writer = sc.nextLine();
			
			//PreparedStatement객체의 sql에서 ?부분을 입력받은 내용으로 채움.
			stmt.setString(1, title); // 1번째 ?에 title변수의 값을 문자열로 채운다
			stmt.setString(2, content);// 2번째 ?에 title변수의 값을 문자열로 채운다
			stmt.setString(3, writer);// 3번째 ?에 title변수의 값을 문자열로 채운다
			//sql관련된 것들만 1부터 시작한다고 생각하기
			
			//4.sql문장을 DB로 보내서 실행하고 결과 처리하기
			int result = stmt.executeUpdate();
			//->executeUpdate()메서드의 리턴타입 int : 1개 행이 삽입되었습니다. 라고 뜸. insert 값이 0이면 만들어진 행 없음
			// 삽입된 행 개수만큼 리턴해줌.
			System.out.println(result + "개의 행이 삽입되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//리소스 해제
			//8. DB 관련 리소스 해제
			//오라클과 접속 끊기 -- close()도 예외발생할 수있다고
			//Connection,Statement,ResultSet
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}

}
