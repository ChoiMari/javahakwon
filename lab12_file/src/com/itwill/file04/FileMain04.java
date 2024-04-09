package com.itwill.file04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 프로그램 ==> ObjectOutputStream ==> FileOutputStream ==> 파일
 * OOS.writeObject(): 자바 객체를 파일에 쓸 수 있는 형태로 변환(직렬화, serialize).
 * 
 * 프로그램 <== ObjectInputStream <== FileInputStream <== 파일
 * OIS.readObject(): 파일에서 읽은 데이터를 자바 객체로 변환(역직렬화, de-serialize).
 * 
 * (주의) OIS, OOS에서 읽고 쓰려는 자바 클래스는 반드시 Serializable 인터페이스를 구현해야 함!
 */

public class FileMain04 { 

    public static void main(String[] args) {
        String fileName = "data/product.dat"; // 파일<-FOS<-COS<-writeObject();프로그램
        
        //product 타입 객체를 파일에 쓰기(write):
        try( 
        		//리소스 생성 :
        	FileOutputStream out = new FileOutputStream(fileName);// 파일과 연결하는 통로 만들기
        		ObjectOutputStream oos = new ObjectOutputStream(out);
        		//try()안의 지역변수 선언 try의 {}내부까지 사용.
        		
        ) {
        	// 파일에 쓸 prodect 타입의 객체를 생성
        	Product p= new Product(1000, "스마트폰", 100_000);
            //자바 캑체를 파일에 씀.
        	oos.writeObject(p); //NotSerializableException -> Product 클래스가 직렬화가 되지 않았다
        	// Product 클래스로 이동. (주의) OIS, OOS에서 읽고 쓰려는 자바 클래스는 반드시 Serializable 인터페이스를 구현해야 함!
        	// 해결 방법 Serializable 인터페이스를 구현, public class Product implements Serializable 이렇게 선언만 해주면 됨.
        	System.out.println("파일 작성 성공");
        	
        } catch(Exception e) {
        	e.printStackTrace(); //예외 로그 출력
        }
        
        //파일에서 데이터를 읽고 자바 객체로 변환:
        try (
        		FileInputStream in = new FileInputStream(fileName);
        		ObjectInputStream ois  = new ObjectInputStream(in);
        ) {
        	Product p = (Product) ois.readObject(); //부모를 자식에게 넣는다 안되니까 강제 변환
        	System.out.println(p);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

}