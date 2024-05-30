package com.itwill.lab05.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.datasource.DataSourceUtil;
import com.zaxxer.hikari.HikariDataSource;

//DAO(Data Access Object) 데이터 베이스 CRUD.
public enum UserDao {
	INSTANCE;

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);

	//여기서 커넥션 맺음 된다고.. get커넥션..
	private final HikariDataSource ds = DataSourceUtil.getInstance().getDataSource();
	
	//TODO: users 테이블에 insert SQL 문장 & 메서드
	private static final String SQL_INSERT = 
			"insert into users (id,userid,password,email,points) values (?,?,?,?,?)";
	
	//insert 시키는 메서드
	//insert의 결과 값 int (?행이 삽입되었습니다.) 에서 ?자리.
	public int insert(User user) { //오라클 DB posts테이블에 저장(insert)시키고 몇개의 행을 삽입했는지 결과값을 리턴하는 메서드.
		//TODO : 해보기
		log.debug("insert({})", user);
		log.debug(SQL_INSERT);
		
	
		Connection conn = null;
		PreparedStatement stmt = null;
		//ResultSet rs = null; 이건 필요 없음..
		int result = 0;
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
		//	rs = stmt.executeQuery(); 이건 필요 없음
			
			//sql문장의 ?자리에 들어갈 값(오라클 DB테이블에 insert할 값)
			stmt.setInt(1,user.getId());
			stmt.setString(2,user.getUserid());
			stmt.setString(3,user.getPassword());
			stmt.setString(4,user.getEmail());
			stmt.setInt(5,user.getPoints());
            result = stmt.executeUpdate(); //성공시 1, 실패하면 0리턴
            
         //   System.out.println(result + "개 행이 삽입되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt); //아래에 리소스 닫는 문장. 메서드로 대체 . rs는 필요없음
		}
		
		return result; //insert가 된 행의 개수 리턴. -> PostTest.java파일에서 testInsert()메서드로 테스트해보기
	}
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////
	private User fromResultSetToPost(ResultSet rs) throws SQLException {
		//throws SQLException이유. while문안에 쓴 코드 대체하려고. while문은 어차피 try에 묶여질 코드들이여서.
		int id = rs.getInt("id");
		String userid = rs.getString("userid");
		String password = rs.getString("password");
		String email = rs.getString("email");
		int points = rs.getInt("points");
		
		return User.builder()
				.id(id)
				.userId(userid)
				.password(password)
				.emain(email)
				.points(points)
				.builder();
		
		//return null;
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	//리소스 해제하는 메서드
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		try {
			//DB 지원들을 해제하는 순서는 생성된 순서의 반대로 해제한다.
			//ResultSet -> Statement -> Connection
			//ResultSet이 null일수도 있어서 null인데 메서드 호출하면 널포인트예외발생
			//그래서 검사한다고..
//			rs.close();
//			stmt.close();
//			conn.close();
			//null이면 실행하지 않음
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//오버로딩 
	private void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null); //-> 2개의 리소스를 닫는 매서드. 위의 메서드 호출해서 2개만 닫음
	}
}
