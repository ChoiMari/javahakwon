package com.itwill.project01.controller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;

import static com.itwill.project01.view.OracleJdbc2.*;
import static com.itwill.project01.model.Membership.Member.*;


import oracle.jdbc.OracleDriver;

public class MemberDao {
	
	//---> 싱글턴
	private static MemberDao instance = null;
	
	private MemberDao() {
		 try { // Oracle 드라이버(라이브러리)를 등록.
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
    //<--- 싱글턴
	
	
	//필드 선언

	
//메서드
	
	//텍스트 필드에서 숫자만 입력했는지 확인해주는 메서드 -> 전화번호 입력에 사용.
	public static boolean isIntegerNumeric(String s) {  
		try {
			Integer.parseInt(s);    
			return true;  
			} 
		catch(Exception e) {
			return false;  
			}
		}
	
//	 //이메일 확인
//	
//			public void emailCheck(String email) throws Exception {
//	
//				boolean check = Pattern.matches(
//	
//						"@", email);
//	
//				if (!check) {
//					
//					throw new Exception("@ 포함한 이메일 형식으로 작성해 주세요");
//					}
//	
//			}

//	
//	public static boolean isDoubleNumeric(String s) {
//		try { 
//			Double.parseDouble(s);   
//			return true;  
//			} 
//		catch(NumberFormatException e) {
//			return false; 
//			}
//		}
//	public static boolean isFloatNumeric(String s) {
//		try {
//			Float.parseFloat(s);
//			return true; 
//			} 
//		
//		catch(NumberFormatException e) {
//			return false;  
//			}
//		}
//	//출처: https://1c1p.tistory.com/67 [원코어원프로세스:티스토리]
	
	  //아이디 확인

//		public void idFormat(String str) throws AuthenException{
//			if(str.length()<5 || str.length()>15){
//
//				throw new AuthenException("5~15자 이내의 아이디만 가능합니다");
//
//			}
//
//			
//
//			int cnt1=0;
//
//			int cnt2=0;
//
//			
//
//			for(int i=0;i<str.length();i++){
//
//				char ch = str.charAt(i);
//
//				if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
//
//					cnt1++;
//
//				else if(ch>='0' && ch<='9')
//
//					cnt2++;
//
//			}
//
//			
//
//			if(cnt1==0 || cnt2==0)
//
//				throw new AuthenException("아이디는 영문자와 숫자를 혼용해서 만들어주세요");	
//
//		}
//
//		
//
//	      //비밀번호 확인
//
//		public void pwCheck(String pw1, String pw2) throws AuthenException{
//
//			
//
//			int cnt1=0;
//
//			int cnt2=0;
//
//			
//
//			for(int i=0;i<pw1.length();i++){
//
//				char ch = pw1.charAt(i);
//
//				if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
//
//					cnt1++;
//
//				else if(ch>='0' && ch<='9')
//
//					cnt2++;
//
//			}
//
//			
//
//			if(cnt1==0 || cnt2==0)
//
//				throw new AuthenException("비밀번호는 영문자와 숫자를 혼용해서 만들어주세요");	
//
//			
//
//			if(!pw1.equals(pw2))
//
//				throw new AuthenException("비밀번호가 다릅니다");	
//
//		}
//
//
//
//	        //성별확인
//
//		public void genCheck(String gender) throws AuthenException{
//
//			
//
//			if(!gender.equals("남") && !gender.equals("여")){
//
//				throw new AuthenException("※성별이 모호하군요!\n성별은 여/남으로 적어주세요;)");
//
//			}
//
//		}
//
//
//
//	       //이름 확인
//
//		public void nameCheck(String name) throws AuthenException {
//
//			boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
//
//			if (!check)
//
//				throw new AuthenException("※이름은 한글로 입력해주세요");
//
//		}
//
//
//
//		// 전화번호 확인
//
//		public void phoneCheck(String phone) throws AuthenException {
//
//			boolean check = Pattern.matches(
//
//					"(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);
//
//			if (!check)
//
//				throw new AuthenException("※전화번호 입력 형식은 [XXX-XXXX-XXXX]입니다");
//
//		}
//
//
//
//	}
//	
	
	
//	//아이디 확인 메서드 
//	public int idFormat(String texId) {
//		
//		
//		if(texId.length() <= 4 || texId.length() >= 12){ //아이디 글자수 확인 
//			return 1; //id문자 길이가 4이하거나 12이상이면 호출한 곳으로 1을 리턴. 
//		}
//
//		
//		//"아이디는 영문자와 숫자를 혼용해서 만들어주세요"
//		int cnt1=0;
//		int cnt2=0;
//		for(int i=0;i < texId.length();i++){
//			char ch = texId.charAt(i);
//			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
//				cnt1++;
//			else if(ch>='0' && ch<='9')
//				cnt2++;
//		}
//		
//		if(cnt1==0 || cnt2==0) {
//			return 2;
//		}
//		
//		//아이디 입력 안했을 시 3을 리턴
//		if(texId == null) {
//			return 3;
//		}
//		
//			return 0;
			//throw new AuthenException("아이디는 영문자와 숫자를 혼용해서 만들어주세요");	

//	}

	
//
//      //비밀번호 확인
//
//	public void pwCheck(String pw1, String pw2) throws AuthenException{
//
//		
//
//		int cnt1=0;
//
//		int cnt2=0;
//
//		
//
//		for(int i=0;i<pw1.length();i++){
//
//			char ch = pw1.charAt(i);
//
//			if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
//
//				cnt1++;
//
//			else if(ch>='0' && ch<='9')
//
//				cnt2++;
//
//		}
//
//		
//
//		if(cnt1==0 || cnt2==0)
//
//			throw new AuthenException("비밀번호는 영문자와 숫자를 혼용해서 만들어주세요");	
//
//		
//
//		if(!pw1.equals(pw2))
//
//			throw new AuthenException("비밀번호가 다릅니다");	
//
//	}
//
//
//
//        //성별확인
//
//	public void genCheck(String gender) throws AuthenException{
//
//		
//
//		if(!gender.equals("남") && !gender.equals("여")){
//
//			throw new AuthenException("※성별이 모호하군요!\n성별은 여/남으로 적어주세요;)");
//
//		}
//
//	}
//
//
//
//       //이름 확인
//
//	public void nameCheck(String name) throws AuthenException {
//
//		boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
//
//		if (!check)
//
//			throw new AuthenException("※이름은 한글로 입력해주세요");
//
//	}
//
//
//
//	// 전화번호 확인
//
//	public void phoneCheck(String phone) throws AuthenException {
//
//		boolean check = Pattern.matches(
//
//				"(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);
//
//		if (!check)
//
//			throw new AuthenException("※전화번호 입력 형식은 [XXX-XXXX-XXXX]입니다");
//
//	}
//

	
	
	
	
}//클래스 끝