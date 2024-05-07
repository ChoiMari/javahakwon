package com.itwill.project01.controller;

import static com.itwill.project01.view.OracleJdbc2.*;


import static com.itwill.project01.model.Membership.Member.*;
import static com.itwill.project01.model.LoginMember.*;
//->import문장에 static을 붙여야 상수를 가져와서 사용가능 함. 안 붙이면 상수가 안 보임
import static com.itwill.project01.view.OracleJdbc2.PASSWORD;
import static com.itwill.project01.view.OracleJdbc2.URL;
import static com.itwill.project01.view.OracleJdbc2.USER;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.itwill.project01.model.Membership;


import oracle.jdbc.OracleDriver;



public class LoginMemberDao {//클래스 시작
	
	 //-----> singleton
    private static LoginMemberDao instance = null;
    
    private LoginMemberDao() {
    	
        try {
            // Oracle 드라이버(라이브러리)를 등록.
            DriverManager.registerDriver(new OracleDriver());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static LoginMemberDao getInstance() {
        if (instance == null) {
            instance = new  LoginMemberDao();
        }
        
        return instance;
    }
    //<----- singleton
	
	
	

	//로그인 한 아이디와 같은 회원정보를 오라클 DB의 MEMBERSHIP_TB 테이블에서 가져올것임
	//select * from  MEMBERSHIP_TB where ID = 로그인한 아이디 
    private static final String SQL_SELECT_LOGIN_BEMBER = "select * from MEMBERSHIP_TB where ID = ?";
    		
//    		String.format(
//            "select * from %s where %s = ?", //주의 여기 sql문장에서는 ;안 붙여야함
//            TBL_MEMBERSHIP,
//            COL_ID
//    		);
	
	
	
    
    
    
    /**
     * CRUD 메서드들에서 사용했던 리소스들을 해제.
     * @param conn Connection 객체
     * @param stmt Statement 객체
     * @param rs ResultSet 객체
     */
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * CRUD 메서드들에서 사용했던 리소스들을 해제.
     * @param conn Connection 객체
     * @param stmt Statement 객체
     */
    private void closeResources(Connection conn, Statement stmt) {
        closeResources(conn, stmt, null);
    }
    
    
    
    /**
     * 로그인 버튼 클릭시 text에 입력한 ID값을 아규먼트로 받아서 그 로그인한 아이디와 같은
     * DB에 저장된 회원 정보를 찾아서 반환함.
     *  
     * @param String 텍스트 필드에 입력된 로그인 아이디.
     * @return 로그인한 아이디의 회원정보를 이 메서드를 호출한 곳으로 돌려줌.
     * 회원정보는 리스트에 저장함.  Membership클래스 타입으로 해야한다. 회원정보는  Membership타입으로 되어있음.
     */
	public List<Membership> loginMemberProfileList(String loginId) {
		//select한 걸 저장할 리스트를 만듬.
		List<Membership> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 데이터베이스에 접속.
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
			stmt = conn.prepareStatement(SQL_SELECT_LOGIN_BEMBER);

			stmt.setString(1,loginId);// 1번째 ?에 들어갈 것
			// 여기서는 로그인시 텍스트 필드에 적은 id를 넣어야함. 
			//그 정보는 이 메서드 호출시 아규먼트로 받아올것임. 그래서 파라미터 선언함 String loginId

			// SQL 문장을 데이터베이스로 전송해서 실행.
			rs = stmt.executeQuery();

			while (rs.next()) {
//            	FrogPizzaMenu frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
				String id = rs.getString(COL_ID);
				String password = rs.getString(COL_PASSWORD);
				String name = rs.getString(COL_NAME);
				String Email = rs.getString(COL_EMAIL);
				String phone = rs.getString(COL_PHONE_NUMBER);
				LocalDateTime joinDate = rs.getTimestamp(COL_JOIN_DATE).toLocalDateTime();
//				LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();

				//오라클 DB에서 아이디,비밀번호,이름,이메일,전화번호,가입날짜를 가져와서 생성자를 호출하면서 
				//초기화 하고 그 결과를 result 리스트에 add. 추가함.
				Membership getloginMember = new Membership(id, password, name, Email, phone, joinDate);
				result.add(getloginMember); // List<FrogPizzaMenu>타입의 이름이 result인 리스트에 추가함.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		//로그인 한 아이디와 같은 회원정보를 오라클 DB에서 select해서 그 결과를
		//이 메서드를 호출한 곳으로 반환함.
		return result;
	}
	
	
	public Membership loginMemberProfile(String loginId) {
		//select한 걸 저장할 리스트를 만듬.
		//List<Membership> result = new ArrayList<>();
		
		Membership result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 데이터베이스에 접속.
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
			stmt = conn.prepareStatement(SQL_SELECT_LOGIN_BEMBER);

			stmt.setString(1,loginId);// 1번째 ?에 들어갈 것
			// 여기서는 로그인시 텍스트 필드에 적은 id를 넣어야함. 
			//그 정보는 이 메서드 호출시 아규먼트로 받아올것임. 그래서 파라미터 선언함 String loginId

			// SQL 문장을 데이터베이스로 전송해서 실행.
			rs = stmt.executeQuery();

			while (rs.next()) {
//            	FrogPizzaMenu frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
				String id = rs.getString(COL_ID);
				String password = rs.getString(COL_PASSWORD);
				String name = rs.getString(COL_NAME);
				String Email = rs.getString(COL_EMAIL);
				String phone = rs.getString(COL_PHONE_NUMBER);
				LocalDateTime joinDate = rs.getTimestamp(COL_JOIN_DATE).toLocalDateTime();
//				LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();

				//오라클 DB에서 아이디,비밀번호,이름,이메일,전화번호,가입날짜를 가져와서 생성자를 호출하면서 
				//초기화 하고 그 결과를 result 리스트에 add. 추가함.
				Membership getloginMember = new Membership(id, password, name, Email, phone, joinDate);
				//result.add(getloginMember); // List<FrogPizzaMenu>타입의 이름이 result인 리스트에 추가함.
				//result = getloginMember;
				//검색한걸 메서드호출하면서 오라클 DB에 insert함.
				loginInsert(getloginMember);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		//로그인 한 아이디와 같은 회원정보를 오라클 DB에서 select해서 그 결과를
		//이 메서드를 호출한 곳으로 반환함.
		return result;
	}
	
	
	
	
	
	
	
	
	 
    // insert into LOGIN_MEMBER_TB (title, content, writer) values (?, ?, ?)
    private static final String SQL_LOGIN_INSERT = String.format(
            "insert into %s (%s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?)", 
            TBL_LOGIN_MEMBER_TB, COL_LOGIN_ID, COL_LOGIN_PASSWORD, COL_LOGIN_NAME, COL_LOGIN_PHONE,
            COL_LOGIN_EMAIL, COL_LOGIN_JOIN_DATE // 접속날짜는 로그인시 자동으로 기본값으로 들어감 
    		);
    
    /**
     * 데이터베이스의 LOGIN_MEMBER_TB 로그인한 ID의 회원정보 테이블에 행을 삽입.
     * @param LOGIN_MEMBER_TB 테이블에 삽입할 로그인한 아이디,비밀번호,이름,전화번호,이메일,가입날짜
     * @return 테이블에 삽입된 행의 개수.
     */
    public int loginInsert (Membership membership) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속.
            stmt = conn.prepareStatement(SQL_LOGIN_INSERT); // Statement 객체 생성.
            stmt.setString(1, membership.getId()); // Statement의 첫번째 ? 채움.
            stmt.setString(2, membership.getPassword()); // Statement의 두번째 ? 채움.
            stmt.setString(3, membership.getName()); // Statement의 세번째 ? 채움.
            stmt.setString(4, membership.getPhone());
            stmt.setString(5, membership.getEmail());
            stmt.setTimestamp(6, Timestamp.valueOf(membership.getJoinDate()));
            //Timestamp.valueOf()메서드 안에 아규먼트로 LocalDateTime타입을 넣으면 타임스템프타입으로 변환해줌.
            result = stmt.executeUpdate(); // SQL 실행.
            
           // LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
	
	
}//클래스 끝
