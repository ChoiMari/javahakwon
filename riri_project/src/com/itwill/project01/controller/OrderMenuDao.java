package com.itwill.project01.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.itwill.project01.model.FrogPizzaMenu;
import com.itwill.project01.view.FrogPizzaFrame;

import static com.itwill.project01.model.FrogPizzaMenu.*;

import static com.itwill.project01.model.FrogDrinkMenu.*;
import static com.itwill.project01.model.FrogSideMenu.*;
import static com.itwill.project01.model.FrogGuestOrderDetails.*;

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
    
    
    
    
    
    // ResultSet에서 각 컬럼의 값들을 읽어서 FrogPizzaMenu 타입 객체를 생성하고 리턴.
    private FrogPizzaMenu makeFrogPizzaMenuFromResultSet(ResultSet rs) throws SQLException {

    	String pizzaName = rs.getString(FrogPizzaMenu.COL_PIZZA_NAME);
        int pizzaPrice = rs.getInt(FrogPizzaMenu.COL_PIZZA_PRICE);
        double pizzaKacl = rs.getDouble(FrogPizzaMenu.COL_PIZZA_KCAL);
        String pizzacook = rs.getString(FrogPizzaMenu.COL_PIZZA_COOK);
        int pizzaPopularity = rs.getInt(FrogPizzaMenu.COL_PIZZA_POPULARITY);
        
        //FrogPizzaMenu의 객체를 생성하면서 파라미터가 5개 있는 생성자 호출 -> 필드값 초기화.
        FrogPizzaMenu frogPizzaMenu = new FrogPizzaMenu(
        		pizzaName, 
        		pizzaPrice,
        		pizzaKacl,
        		pizzacook,
        		pizzaPopularity);
        
        return frogPizzaMenu; //frog객체를 리턴함.
    }
    
	
    /*
     * select pizza_name, pizza_price
    		from frog_pizza_menu_tb
    		where pizza_name = '♡개구리피자♡';
     */
    //오라클DB FROG_PIZZA_MENU_TB 테이블에서 피자 이름, 피자 가격,요리사,인기도를 select
    private static final String SQL_SELECT_BY_PIZZA_NAME_AND_PRICE = String.format(
            "select %s from %s where %s = ?", 
            FrogPizzaMenu.COL_PIZZA_NAME,
//            FrogPizzaMenu.COL_PIZZA_PRICE,
//            FrogPizzaMenu.COL_PIZZA_COOK,
//            FrogPizzaMenu.COL_PIZZA_POPULARITY,
            TBL_PIZZA_MENU,
            FrogPizzaMenu.COL_PIZZA_NAME);
   
    
    /**
     * 
     * @param pizzaName
     * @return sql문 조건에 맞는 피자 이름을 리턴.
     */
    public FrogPizzaMenu readPizzaName(String ckPizzaName) {
    	FrogPizzaMenu dbGetfrogPizzaMenu = null;
    	Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_SELECT_BY_PIZZA_NAME_AND_PRICE);
            
            stmt.setString(1, ckPizzaName); // sql문 1번째 ?에 들어갈 값. 해당 메서드 호출시 아규먼트로 전달 받은 값으로
            rs = stmt.executeQuery();
            
            if (rs.next()) {
            	String pizzaName = rs.getString(FrogPizzaMenu.COL_PIZZA_NAME);
//                int pizzaPrice = rs.getInt(FrogPizzaMenu.COL_PIZZA_PRICE);
//                double pizzaKacl = rs.getDouble(FrogPizzaMenu.COL_PIZZA_KCAL);
//                String pizzacook = rs.getString(FrogPizzaMenu.COL_PIZZA_COOK);
//                int pizzaPopularity = rs.getInt(FrogPizzaMenu.COL_PIZZA_POPULARITY);
                //아규먼트로 전달받은 피자이름의 모든 컬럼의 행들의 정보로 필드 초기화.
                FrogPizzaMenu resultFrogPizzaMenu = new FrogPizzaMenu(pizzaName);//, pizzaPrice, pizzaKacl, pizzacook, pizzaPopularity);
                //거기서 이름만 뽑아서 저장하고 호출한 곳으로 리턴해줌.
                //dbGetfrogPizzaMenu = resultFrogPizzaMenu.getPizzaName();
                
            }
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
    	
    	
    	return dbGetfrogPizzaMenu;
    	
    }
    
    
    
    
    
    
    
	
    /**
     * 오라클DB FROG_PIZZA_MENU_TB 테이블의 고유키 PIZZA_NAME를 전달받아서, 해당 FrogPizzaMenu 객체를 리턴.
     * @param 피자이름 검색하기 위한 고유키 피자이름.
     * @return 테이블에서 검색한 FrogPizzaMenu 객체. 고유키에 해당하는 행이 없는 경우 null을 리턴.
     */
    public FrogPizzaMenu readPizzaNameAndPrice (String pizzaName) {
    	FrogPizzaMenu frogPizzaMenu = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_SELECT_BY_PIZZA_NAME_AND_PRICE);
            
            stmt.setString(1, pizzaName); // sql문 1번째 ?에 들어갈 값. 해당 메서드 호출시 아규먼트로 전달 받은 값으로
            rs = stmt.executeQuery();
            
            if (rs.next()) {
            	frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
//            	String getPizzaName = rs.getString(FrogPizzaMenu.COL_PIZZA_NAME);
//                int pizzaPrice = rs.getInt(FrogPizzaMenu.COL_PIZZA_PRICE);
//                String pizzacook = rs.getString(FrogPizzaMenu.COL_PIZZA_COOK);
//                int pizzaPopularity = rs.getInt(FrogPizzaMenu.COL_PIZZA_POPULARITY);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return frogPizzaMenu;
    }
    
    
 // read() 메서드에서 사용할 SQL 문장: select * from FROG_PIZZA_MENU_TB;
    private static final String SQL_SELECT_PIZZA_MENU_ALL = String.format(
            "select * from %s", //주의 여기 sql문장에서는 ;안 붙여야함
            TBL_PIZZA_MENU);
    
    /**
     * 데이터베이스 테이블 FROG_PIZZA_MENU_TB 테이블에서 모든 레코드(행)를 검색해서 
     * 반환함.
     * 테이블에 행이 없는 경우 빈 리스트를 리턴.
     * @return FrogPizzaMenu를 원소로 갖는 ArrayList.
     */
    
    public List<FrogPizzaMenu> frogPizzaMenuReadAll() {
        List<FrogPizzaMenu> result = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // 데이터베이스에 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
            stmt = conn.prepareStatement(SQL_SELECT_PIZZA_MENU_ALL);
            // SQL 문장을 데이터베이스로 전송해서 실행.
            rs = stmt.executeQuery();
            // 결과 처리.
            while (rs.next()) {
            	FrogPizzaMenu frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
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
    

}//클래스 끝.
