package com.itwill.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;
import static com.itwill.jdbc.model.Blog.Entity.*;

public class JdbcMain04 {

    public static void main(String[] args) {
        // delete 문장 실행 & 결과 처리
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            DriverManager.registerDriver(new OracleDriver()); // 오라클 드라이버 등록
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속
            
            final String sql = String.format(
                    "delete from %s where %s = ?", 
                    TBL_BLOGS, COL_ID);
            System.out.println(sql); // 실행할 SQL 문장
            
            stmt = conn.prepareStatement(sql); // Statement 객체 생성
            stmt.setInt(1, 10); // PreparedStatement의 ?를 정수 10으로 설정
            // "delete from %s where %s = ?" sql 문장에서 ?를 10으로 설정
            
            int result = stmt.executeUpdate(); // SQL 실행
            System.out.println(result + "개 행이 삭제됨."); // 실행 결과 출력
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();// 혹시나 null일까봐.. null이 아니면 stmt.close();메서드 호출해라..
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}

//--------------------------------------------------------------------------------------------------------------
//package com.itwill.jdbc04;
//
//import static com.itwill.jdbc.OracleJdbc.PASSWORD;
//import static com.itwill.jdbc.OracleJdbc.URL;
//import static com.itwill.jdbc.OracleJdbc.USER;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import oracle.jdbc.OracleDriver;
//
//public class JdbcMain04 {
//
//	public static void main(String[] args) throws SQLException {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		// 1.오라클 드라이버 등록하기
//		DriverManager.registerDriver(new OracleDriver());
//		
//		// 2. 오라클 DB에 접속
//		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//		
//		System.out.print("삭제할 ID >> ");
//		int id = sc.nextInt();
//		
//		
//		//Statement 객체 생성
//		final String sql = "delete from blogs where id = ?";
//		PreparedStatement stmt = conn.prepareStatement(sql);
//		
//		stmt.setInt(1,id);
//		
//		int result = stmt.executeUpdate();
//		if(result > 0) {
//			System.out.println(result+ "개의 행이 삭제 되었습니다.");
//		} else {
//			System.out.println("더 이상 삭제할 데이터가 없습니다.");
//		}
//		
//		stmt.close();
//		conn.close();
//		
//	}
//
//}
