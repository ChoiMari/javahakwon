package com.itwill.jdbc.controller;

import static com.itwill.jdbc.OracleJdbc.PASSWORD;
import static com.itwill.jdbc.OracleJdbc.URL;
import static com.itwill.jdbc.OracleJdbc.USER;
import static com.itwill.jdbc.model.Blog.Entity.COL_CREATED_TIME;
import static com.itwill.jdbc.model.Blog.Entity.COL_ID;
import static com.itwill.jdbc.model.Blog.Entity.COL_MODIFIED_TIME;
import static com.itwill.jdbc.model.Blog.Entity.COL_TITLE;
import static com.itwill.jdbc.model.Blog.Entity.COL_WRITER;
import static com.itwill.jdbc.model.Blog.Entity.TBL_BLOGS;
import static com.itwill.jdbc.model.Blog.Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.OracleDriver;

// MVC 아키텍쳐에서 Controller를 담당하는 클래스. DAO(Data Access Object)
// CRUD(Create, Read, Update, Delete)기능 담당: insert,select,update,delete SQL
public class BlogDao {

	// ---> singleton
	private static BlogDao instance = null;

	private BlogDao() {
		try {
			// Oracle 드라이버(라이브러리)를 등록. ->1번만 실행 되면 됨. 그래서 싱글턴 안에 넣음. 객체생성 처음 1번 생성자 호출 될 때
			// 1번만 실행.
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static BlogDao getInstance() {
		if (instance == null) {
			instance = new BlogDao();
		}

		return instance;
	} // <--- singleton

	/**
	 * CRUD 메서드들에서 사용했던 리소스들을 해제
	 * 
	 * @param conn Connection 객체
	 * @param stmt Statement 객체
	 * @param rs   ResultSet 객체
	 */

	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null);
	}

	// read() 메서드에서 사용할 SQL문장
	private static final String SQL_SELECT_ALL = String.format("select * from %s order by %s desc", TBL_BLOGS, COL_ID);

	/**
     * 데이터베이스 테이블 BLOGS 테이블에서 모든 레코드(행)를 검색해서 
     * ID(고유키)의 내림차순으로 정렬된 리스트를 반환.
     * 테이블에 행이 없는 경우 빈 리스트를 리턴.
     * @return Blog를 원소로 갖는 ArrayList.
	 */
	public List<Blog> read() { 
		List<Blog> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try { // 데이터베이스에 접속.
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 실행할 SQL 문장을 갖고 있는 prepareStatement 객체를 생성
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			// 결과 처리
			while (rs.next()) {// 오라클 데이터베이스 테이블에 rs.next() 그 다음 행이 있는지 없는 지 알려주는 메서드
				//행이 있으면 true ->while문 반복, 없으면 false -> while문 나감
				
				//컬럼에 있는 값들 읽음.
				int id = rs.getInt(COL_ID);
				String title = rs.getString(COL_TITLE);
				String content = rs.getString(COL_WRITER);
				LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
				LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME).toLocalDateTime();

				Blog blog = new Blog(id, title, content, content, createdTime, modifiedTime);
				result.add(blog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		return result;
	}
	
	//create(Blog blog)메서드에서 사용할 SQL
	//insert into blogs(title, content,writer) values(?,?,?);
	private static final String SQL_INSERT = String.format(
			"insert into %s(%s,%s,%s) values (?, ?, ?)", 
			TBL_BLOGS, COL_TITLE, COL_CONTENT ,COL_WRITER);
	/**
	 * 데이터 베이스의 Blogs 테이블에 행 삽입.
	 * @param blog 테이블에 삽입할 제목, 내용, 작성자 정보를 가지고 있는 객체
	 * @return 테이블에 삽입된 행의 개수.
	 */
	
	public int create(Blog blog) {//테이블의 실제 내용, 작성자 행으로 추가
		int result = 0; 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_INSERT);//Statement 객체 생성
			stmt.setString(1, blog.getTitle()); //Statement의 1번째 ? blog.getTitle()로 채움
			stmt.setString(2, blog.getContent());//Statement의 2번째 ? blog.getContent()로 채움
			stmt.setString(3, blog.getWriter());////Statement의 3번째 ? blog.getWriter()로 채움
			result = stmt.executeUpdate();//SQL 실행
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		
		return result;
	}
	
	//delete(int id)메서드에서 사용할 SQL: 
	//id를 아규먼트로 전달받으면 테이블에서 삭제.
	//SQL : delete from blogs where id = ?
	private static final String SQL_DELTE = String.format(
			"delete from %s where %s = ?",
			TBL_BLOGS, COL_ID);
	/**
	 * 테이블 BLOGS에서 고유키(PK) id에 해당하는 레코드(행)를 삭제.
	 * @param id 삭제하려는 레코드의 고유키.
	 * @return 테이블에서 삭제된 행의 개수
	 */
	public int delete(int id) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		//Statement 상속 받는 PreparedStatement
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_DELTE);
			stmt.setInt(1, id);//-> SQL 문장에서 1번째 물음표에 들어갈 값을 id로 채움
			//id는 int타입이니까 setInt메서드로.
			//만약 문자열 타입이면 setString메서드로 호출해야..!!
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);//PreparedStatement 타입의 stmt를 아규먼트로 넘김. 다형성. 
		}
		
		return result;
	}
	
	//콤보박스 1번째 선택 검색 : 제목에 검색 키워드가 포함된 검색 결과 :
	// select * from blogs where lower(title) like ? order by id desc
	//title 대소문자 구분. 전부 소문자로 바꾸어서 검색되도록
	private static final String SQL_SELECT_BY_TITLE = String.format(
			"select * from %s where lower(%s) like ? order by %s desc",
			TBL_BLOGS,
			COL_TITLE,
			COL_ID);
	
	//콤보박스 2번째 선택 검색 : 내용에 검색 키워드가 포함된 검색 결과 :
	// select * from 테이블 이름 where 조건 lower(content) like ? oder by id desc;
	private static final String SQL_SELECT_BY_CONTENT = String.format(
			"select * from %s where lower(%s) like ? order by %s desc",
			TBL_BLOGS,
			COL_CONTENT,
			COL_ID);
	
	//콤보박스 3번째 선택 검색 : 제목lower(title) 또는 내용lower(content)에 검색 키워드가 포함된 검색 결과.
	//select * from 테이블 이름(blogs) where lower(title) like ? or lower(content) like ? order by id desc;
	private static final String SQL_SELECT_BY_TITLE_OR_CONTENT = String.format(
			"select * from %s where lower(%s) like ? or lower(%s) like ? order by %S desc;",
			TBL_BLOGS,
			COL_TITLE,
			COL_CONTENT,
			COL_ID);
	
	
}

//-------------------------------------------
//package com.itwill.jdbc.controller;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.itwill.jdbc.model.Blog;
//
//import oracle.jdbc.OracleDriver;
//
//import static com.itwill.jdbc.OracleJdbc.*;
//import static com.itwill.jdbc.model.Blog.Entity.*;
//
//// MVC 아키텍쳐에서 Controller를 담당하는 클래스. DAO(Data Access Object)
//// CRUD(Create, Read, Update, Delete) 기능 담당: insert, select, update, delete SQL
//public class BlogDao {
//    
//    //-----> singleton
//    private static BlogDao instance = null;
//    
//    private BlogDao() {
//        try {
//            // Oracle 드라이버(라이브러리)를 등록.
//            DriverManager.registerDriver(new OracleDriver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static BlogDao getInstance() {
//        if (instance == null) {
//            instance = new BlogDao();
//        }
//        
//        return instance;
//    }
//    //<----- singleton
//    
//    /**
//     * CRUD 메서드들에서 사용했던 리소스들을 해제.
//     * @param conn Connection 객체
//     * @param stmt Statement 객체
//     * @param rs ResultSet 객체
//     */
//    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
//        try {
//            if (rs != null) rs.close();
//            if (stmt != null) stmt.close();
//            if (conn != null) conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    /**
//     * CRUD 메서드들에서 사용했던 리소스들을 해제.
//     * @param conn Connection 객체
//     * @param stmt Statement 객체
//     */
//    private void closeResources(Connection conn, Statement stmt) {
//        closeResources(conn, stmt, null);
//    }
//    
//    // read() 메서드에서 사용할 SQL 문장: select * from blogs order by id desc
//    private static final String SQL_SELECT_ALL = String.format(
//            "select * from %s order by %s desc", 
//            TBL_BLOGS, COL_ID);
//    
//    /**
//     * 데이터베이스 테이블 BLOGS 테이블에서 모든 레코드(행)를 검색해서 
//     * ID(고유키)의 내림차순으로 정렬된 리스트를 반환.
//     * 테이블에 행이 없는 경우 빈 리스트를 리턴.
//     * @return Blog를 원소로 갖는 ArrayList.
//     */
//    public List<Blog> read() {
//        List<Blog> result = new ArrayList<>();
//        
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            // 데이터베이스에 접속.
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            // 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
//            stmt = conn.prepareStatement(SQL_SELECT_ALL);
//            // SQL 문장을 데이터베이스로 전송해서 실행.
//            rs = stmt.executeQuery();
//            // 결과 처리.
//            while (rs.next()) {
//                int id = rs.getInt(COL_ID);
//                String title = rs.getString(COL_TITLE);
//                String content = rs.getString(COL_CONTENT);
//                String writer = rs.getString(COL_WRITER);
//                LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME)
//                        .toLocalDateTime();
//                LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME)
//                        .toLocalDateTime();
//                
//                Blog blog = new Blog(id, title, content, writer, createdTime, modifiedTime);
//                result.add(blog);
//            }
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            closeResources(conn, stmt, rs);
//        }
//        
//        return result;
//    }
//
//}