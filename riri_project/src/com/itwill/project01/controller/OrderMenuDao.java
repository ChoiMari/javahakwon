package com.itwill.project01.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itwill.project01.model.OrderMenuAll;
import com.itwill.project01.model.OrderTb;

import static com.itwill.project01.model.OrderMenuAll.*;
import static com.itwill.project01.view.OracleJdbc2.*;

import oracle.jdbc.OracleDriver;

public class OrderMenuDao {
    //-----> singleton
    private static OrderMenuDao instance = null;
    
    private OrderMenuDao() {
    	
        try {
            // Oracle 드라이버(라이브러리)를 등록.
            DriverManager.registerDriver(new OracleDriver());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static OrderMenuDao getInstance() {
        if (instance == null) {
            instance = new  OrderMenuDao();
        }
        
        return instance;
    }
    //<----- singleton
    
    
    
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
    
    
    private static final String SQL_SELECT_SIDE_MENU_CK = String.format(
            "select * from %s where %s = ?", //주의 여기 sql문장에서는 ;안 붙여야함
            TBL_FROG_ALLDER_MENU_TB, OrderMenuAll.COL_SIDE_NAME);
//    		"select * from FROG_ALLDER_MENU_TB where SIDE_NAME = 사이드이름";
    /**
     * 
     * @param sideName
     * @return
     */
	public List<OrderMenuAll> ckFrogSideMenuRead(String sideName) {

		List<OrderMenuAll> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 데이터베이스에 접속.
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
			stmt = conn.prepareStatement(SQL_SELECT_SIDE_MENU_CK);

			stmt.setString(1, sideName);// 1번째 ?에 들어갈 것

			// SQL 문장을 데이터베이스로 전송해서 실행.
			rs = stmt.executeQuery();

			while (rs.next()) {
//            	FrogPizzaMenu frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
				String cksideName = rs.getString(OrderMenuAll.COL_SIDE_NAME);
				int sidePrice = rs.getInt(OrderMenuAll.COL_SIDE_PRICE);
				double sideKacl = rs.getDouble(OrderMenuAll.COL_SIDE_KCAL);

//    			String drinkName = rs.getString(OrderMenuAll.COL_DRINK_NAME);
//    	        int drinkPrice = rs.getInt(OrderMenuAll.COL_DRINK_PRICE);
//    	        
//    			String sideName = rs.getString(OrderMenuAll.COL_SIDE_NAME);
//    	        int sidePrice = rs.getInt(OrderMenuAll.COL_SIDE_PRICE);

				String sideCook = rs.getString(OrderMenuAll.COL_SIDE_COOK);
				int sidePopularity = rs.getInt(OrderMenuAll.COL_SIDE_POPULARITY);

				// OrderMenuAll frogPizzaMenu = new OrderMenuAll(pizzaName, pizzaPrice,
				// pizzaKacl, pizzacook, pizzaPopularity);
				OrderMenuAll frogSideMenu = new OrderMenuAll(sidePrice, cksideName, sideKacl, sideCook, sidePopularity);
				result.add(frogSideMenu); // List<FrogPizzaMenu>타입의 이름이 result인 리스트에 추가함.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return result;
	}
    
    


    
//    public List<OrderMenuAll> ckFrogPizzaMenuRead(String CkPizzaName) {
//        List<OrderMenuAll> result = new ArrayList<>();
//        
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        
//        try {
//            // 데이터베이스에 접속.
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            // 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
//            stmt = conn.prepareStatement(SQL_SELECT_PIZZA_MENU_CK);
//            stmt.setString(1,CkPizzaName);
//            // SQL 문장을 데이터베이스로 전송해서 실행.
//            rs = stmt.executeQuery();
//            // 결과 처리.
//            while (rs.next()) {
////            	FrogPizzaMenu frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
//    			String pizzaName = rs.getString(OrderMenuAll.COL_PIZZA_NAME);
//    	        int pizzaPrice = rs.getInt(OrderMenuAll.COL_PIZZA_PRICE);
//    	        double pizzaKacl = rs.getDouble(OrderMenuAll.COL_PIZZA_KCAL);
//    	        
////    			String drinkName = rs.getString(OrderMenuAll.COL_DRINK_NAME);
////    	        int drinkPrice = rs.getInt(OrderMenuAll.COL_DRINK_PRICE);
////    	        
////    			String sideName = rs.getString(OrderMenuAll.COL_SIDE_NAME);
////    	        int sidePrice = rs.getInt(OrderMenuAll.COL_SIDE_PRICE);
//    	        
//    	        String pizzacook = rs.getString(OrderMenuAll.COL_PIZZA_COOK);
//    	        int pizzaPopularity = rs.getInt(OrderMenuAll.COL_PIZZA_POPULARITY);
//    	        
//    	        
//    	        
//    	       // OrderMenuAll frogPizzaMenu = new OrderMenuAll(pizzaName, pizzaPrice, pizzaKacl, pizzacook, pizzaPopularity);
//    	        OrderMenuAll frogPizzaMenu = new OrderMenuAll(pizzaName, pizzaPrice, pizzaKacl, pizzacook, pizzaPopularity);
//                result.add(frogPizzaMenu); //List<FrogPizzaMenu>타입의 이름이 result인 리스트에 추가함.
//            }
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            closeResources(conn, stmt, rs);
//        }
//        
//        return result; //List<FrogPizzaMenu>타입의 이름이 result인 리스트에 
//        //FROG_PIZZA_MENU_TB 테이블이 가진 모든 컬럼의 행들을 select하고 저장시켜서 그 결과를 리턴함.
//    }
//    
    
//    // ResultSet에서 각 컬럼의 값들을 읽어서 FrogPizzaMenu 타입 객체를 생성하고 리턴.
//    private FrogPizzaMenu makeFrogPizzaMenuFromResultSet(ResultSet rs) {
//
//    	String pizzaName;
//		try {
//			pizzaName = rs.getString(FrogPizzaMenu.COL_PIZZA_NAME);
//	        int pizzaPrice = rs.getInt(FrogPizzaMenu.COL_PIZZA_PRICE);
//	        double pizzaKacl = rs.getDouble(FrogPizzaMenu.COL_PIZZA_KCAL);
//	        String pizzacook = rs.getString(FrogPizzaMenu.COL_PIZZA_COOK);
//	        int pizzaPopularity = rs.getInt(FrogPizzaMenu.COL_PIZZA_POPULARITY);
//	        
//	        
//	        FrogPizzaMenu frogPizzaMenu = new FrogPizzaMenu(
//	        		pizzaName, 
//	        		pizzaPrice,
//	        		pizzaKacl,
//	        		pizzacook,
//	        		pizzaPopularity);
//	        
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        
        //FrogPizzaMenu의 객체를 생성하면서 파라미터가 5개 있는 생성자 호출 -> 필드값 초기화.

        
//        return frogPizzaMenu; //frog객체를 리턴함.
//    }
//    
	
    /*
     * select pizza_name, pizza_price
    		from frog_pizza_menu_tb
    		where pizza_name = '♡개구리피자♡';
//     */
//    //오라클DB FROG_PIZZA_MENU_TB 테이블에서 피자 이름, 피자 가격,요리사,인기도를 select
//    private static final String SQL_SELECT_BY_PIZZA_NAME_AND_PRICE = String.format(
//            "select %s from %s where %s = ?", 
//            FrogPizzaMenu.COL_PIZZA_NAME,
////            FrogPizzaMenu.COL_PIZZA_PRICE,
////            FrogPizzaMenu.COL_PIZZA_COOK,
////            FrogPizzaMenu.COL_PIZZA_POPULARITY,
//            TBL_PIZZA_MENU,
//            FrogPizzaMenu.COL_PIZZA_NAME);
   
    
//    /**
//     * 
//     * @param pizzaName
//     * @return sql문 조건에 맞는 피자 이름을 리턴.
//     */
//    public FrogPizzaMenu readPizzaName(String ckPizzaName) {
//    	FrogPizzaMenu dbGetfrogPizzaMenu = null;
//    	Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        
//        try {
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            stmt = conn.prepareStatement(SQL_SELECT_BY_PIZZA_NAME_AND_PRICE);
//            
//            stmt.setString(1, ckPizzaName); // sql문 1번째 ?에 들어갈 값. 해당 메서드 호출시 아규먼트로 전달 받은 값으로
//            rs = stmt.executeQuery();
//            
//            if (rs.next()) {//1개면 if, 여러개면 while문 
//            	dbGetfrogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
////            	String pizzaName = rs.getString(FrogPizzaMenu.COL_PIZZA_NAME);
////                int pizzaPrice = rs.getInt(FrogPizzaMenu.COL_PIZZA_PRICE);
////                double pizzaKacl = rs.getDouble(FrogPizzaMenu.COL_PIZZA_KCAL);
////                String pizzacook = rs.getString(FrogPizzaMenu.COL_PIZZA_COOK);
////                int pizzaPopularity = rs.getInt(FrogPizzaMenu.COL_PIZZA_POPULARITY);
////                //아규먼트로 전달받은 피자이름의 모든 컬럼의 행들의 정보로 필드 초기화.
////                FrogPizzaMenu resultFrogPizzaMenu = new FrogPizzaMenu(pizzaName, pizzaPrice, pizzaKacl, pizzacook, pizzaPopularity);
////                //거기서 이름만 뽑아서 저장하고 호출한 곳으로 리턴해줌.
//                //dbGetfrogPizzaMenu = resultFrogPizzaMenu.getPizzaName();
//                //TODO
//            }
//           
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            closeResources(conn, stmt, rs);
//        }
//    	
//    	
//    	return dbGetfrogPizzaMenu;
//    	
//    }
//    
    
    
    
    
    
    
	
//    /**
//     * 오라클DB FROG_PIZZA_MENU_TB 테이블의 고유키 PIZZA_NAME를 전달받아서, 해당 FrogPizzaMenu 객체를 리턴.
//     * @param 피자이름 검색하기 위한 고유키 피자이름.
//     * @return 테이블에서 검색한 FrogPizzaMenu 객체. 고유키에 해당하는 행이 없는 경우 null을 리턴.
//     */
//    public FrogPizzaMenu readPizzaNameAndPrice (String pizzaName) {
//    	FrogPizzaMenu frogPizzaMenu = null;
//        
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        
//        try {
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            stmt = conn.prepareStatement(SQL_SELECT_BY_PIZZA_NAME_AND_PRICE);
//            
//            stmt.setString(1, pizzaName); // sql문 1번째 ?에 들어갈 값. 해당 메서드 호출시 아규먼트로 전달 받은 값으로
//            rs = stmt.executeQuery();
//            
//            if (rs.next()) {
//            	frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
////            	String getPizzaName = rs.getString(FrogPizzaMenu.COL_PIZZA_NAME);
////                int pizzaPrice = rs.getInt(FrogPizzaMenu.COL_PIZZA_PRICE);
////                String pizzacook = rs.getString(FrogPizzaMenu.COL_PIZZA_COOK);
////                int pizzaPopularity = rs.getInt(FrogPizzaMenu.COL_PIZZA_POPULARITY);
//            }
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            closeResources(conn, stmt, rs);
//        }
//        
//        return frogPizzaMenu;
//    }
    private static final String SQL_SELECT_PIZZA_MENU_CK = String.format(
            "select * from %s where %s = ?", //주의 여기 sql문장에서는 ;안 붙여야함
            TBL_FROG_ALLDER_MENU_TB, OrderMenuAll.COL_PIZZA_NAME);
//    		"select * from FROG_PIZZA_MENU_TB where PIZZA_COOK = '개구리'";
    /**
     * 데이터베이스 테이블 FROG_PIZZA_MENU_TB 테이블에서 모든 레코드(행)를 검색해서 
     * 반환함.
     * 테이블에 행이 없는 경우 빈 리스트를 리턴.
     * @return FrogPizzaMenu를 원소로 갖는 ArrayList.
     */
    
    public List<OrderMenuAll> ckFrogPizzaMenuRead(String CkPizzaName) {
        List<OrderMenuAll> result = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // 데이터베이스에 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
            stmt = conn.prepareStatement(SQL_SELECT_PIZZA_MENU_CK);
            stmt.setString(1,CkPizzaName);
            // SQL 문장을 데이터베이스로 전송해서 실행.
            rs = stmt.executeQuery();
            // 결과 처리.
            while (rs.next()) {
//            	FrogPizzaMenu frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
    			String pizzaName = rs.getString(OrderMenuAll.COL_PIZZA_NAME);
    	        int pizzaPrice = rs.getInt(OrderMenuAll.COL_PIZZA_PRICE);
    	        double pizzaKacl = rs.getDouble(OrderMenuAll.COL_PIZZA_KCAL);
    	        
//    			String drinkName = rs.getString(OrderMenuAll.COL_DRINK_NAME);
//    	        int drinkPrice = rs.getInt(OrderMenuAll.COL_DRINK_PRICE);
//    	        
//    			String sideName = rs.getString(OrderMenuAll.COL_SIDE_NAME);
//    	        int sidePrice = rs.getInt(OrderMenuAll.COL_SIDE_PRICE);
    	        
    	        String pizzacook = rs.getString(OrderMenuAll.COL_PIZZA_COOK);
    	        int pizzaPopularity = rs.getInt(OrderMenuAll.COL_PIZZA_POPULARITY);
    	        
    	        
    	        
    	       // OrderMenuAll frogPizzaMenu = new OrderMenuAll(pizzaName, pizzaPrice, pizzaKacl, pizzacook, pizzaPopularity);
    	        OrderMenuAll frogPizzaMenu = new OrderMenuAll(pizzaName, pizzaPrice, pizzaKacl, pizzacook, pizzaPopularity);
                result.add(frogPizzaMenu); //List<FrogPizzaMenu>타입의 이름이 result인 리스트에 추가함.
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return result; //List<FrogPizzaMenu>타입의 이름이 result인 리스트에 
        //FROG_PIZZA_MENU_TB 테이블이 가진 모든 컬럼의 행들을 select하고 저장시켜서 그 결과를 리턴함.
    }
    
	private static final String SQL_SELECT_DRINK_MENU_CK = String.format(
			"select * from %s where %s = ?", // 주의 여기 sql문장에서는 ;안 붙여야함
			OrderMenuAll.TBL_FROG_ALLDER_MENU_TB, OrderMenuAll.COL_DRINK_NAME);
		// "select * from FROG_DRINK_MENU_TB where DRINK_NAME = ?";
	
	public List<OrderMenuAll> ckFrogDrinkMenuRead(String cKDinkName) {
		List<OrderMenuAll> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 데이터베이스에 접속.
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
			stmt = conn.prepareStatement(SQL_SELECT_DRINK_MENU_CK);
			stmt.setString(1, cKDinkName);
			// SQL 문장을 데이터베이스로 전송해서 실행.
			rs = stmt.executeQuery();
			// 결과 처리.
			while (rs.next()) {
//            	FrogPizzaMenu frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
				String drinkName = rs.getString(OrderMenuAll.COL_DRINK_NAME);
				int drinkPrice = rs.getInt(OrderMenuAll.COL_DRINK_PRICE);
				double drinkKacl = rs.getDouble(OrderMenuAll.COL_DRINK_KCAL);
				int drinkPopularity = rs.getInt(OrderMenuAll.COL_DRINK_POPULARITY);

				OrderMenuAll frogDrinkMenu = new OrderMenuAll(drinkName, drinkPrice, drinkKacl, drinkPopularity);
				result.add(frogDrinkMenu); // List<FrogPizzaMenu>타입의 이름이 result인 리스트에 추가함.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}

		return result; // List<FrogPizzaMenu>타입의 이름이 result인 리스트에
		// FROG_PIZZA_MENU_TB 테이블이 가진 모든 컬럼의 행들을 select하고 저장시켜서 그 결과를 리턴함.
	}
    
    
//    
// // read() 메서드에서 사용할 SQL 문장: select * from FROG_PIZZA_MENU_TB;
//    private static final String SQL_SELECT_PIZZA_MENU_ALL = String.format(
//            "select * from %s", //주의 여기 sql문장에서는 ;안 붙여야함
//            TBL_PIZZA_MENU);
//    
//    /**
//     * 데이터베이스 테이블 FROG_PIZZA_MENU_TB 테이블에서 모든 레코드(행)를 검색해서 
//     * 반환함.
//     * 테이블에 행이 없는 경우 빈 리스트를 리턴.
//     * @return FrogPizzaMenu를 원소로 갖는 ArrayList.
//     */
//    
//    public List<FrogPizzaMenu> frogPizzaMenuReadAll() {
//        List<FrogPizzaMenu> result = new ArrayList<>();
//        
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        
//        try {
//            // 데이터베이스에 접속.
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            // 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
//            stmt = conn.prepareStatement(SQL_SELECT_PIZZA_MENU_ALL);
//            // SQL 문장을 데이터베이스로 전송해서 실행.
//            rs = stmt.executeQuery();
//            // 결과 처리.
//            while (rs.next()) {
////            	FrogPizzaMenu frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
//                result.add(frogPizzaMenu); //List<FrogPizzaMenu>타입의 이름이 result인 리스트에 추가함.
//            }
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            closeResources(conn, stmt, rs);
//        }
//        
//        return result; //List<FrogPizzaMenu>타입의 이름이 result인 리스트에 
//        //FROG_PIZZA_MENU_TB 테이블이 가진 모든 컬럼의 행들을 select하고 저장시켜서 그 결과를 리턴함.
//    }
//    
	
	 // delete(int id) 메서드에서 사용할 SQL: delete from blogs where id = ?
    private static final String SQL_DELETE = "dlelte from ORDER_CONFIRMATION_TB where ORDER_PIZZA_NAME = ?";
//    		String.format(
//            "delete from %s where %s = ?", 
//            TBL_BLOGS, COL_ID);
//    
    /**
     * 테이블에서 ORDER_PIZZA_NAME에 해당하는 레코드(행)를 삭제.
     * @param ORDER_PIZZA_NAME 삭제하려는 레코드 조건
     * @return 테이블에서 삭제된 행의 개수.
     */
    public int delete(String pizzaName) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, pizzaName);
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
	
	//오라클 DB에 저장된 주문내역 테이블 정보를 가져오는 메서드.
	
	
	
	

}//클래스 끝.