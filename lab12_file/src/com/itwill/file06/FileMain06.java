package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class FileMain06 {

	public static void main(String[] args) {
		// Student 1,000,000개를 저장하는 더미 데이터(ArrayList)를 만듬
		ArrayList<Student> studentsList = new ArrayList<>();
		
		// score에 사용 될 난수 
		Random rand = new Random();
		for(int i = 0; i < 1_000_000; i++) {
			Score score = new Score(rand.nextInt(101),
					rand.nextInt(101),
					rand.nextInt(101));
			Student student = new Student(i,"Name_" + i,score);
			studentsList.add(student);
		}
		System.out.println("first: " + studentsList.getFirst());
		System.out.println("first: " + studentsList.getLast());
		System.out.println("dummy size = " + studentsList.size());
		
		final String fileName = "data/student_list.dat";
		
		// 더미 데이터를 파일에 씀(write). 파일에 쓰는 데 걸리는 시간 측정.
		try(
				FileOutputStream fos = new FileOutputStream(fileName);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
		){
			long start = System.currentTimeMillis();//쓰기 시작 시간
			oos.writeObject(studentsList); // 파일 쓰기 - ArrayList는 Serializable를 구현하고 있음.
			//writeObject하려면 Student,Score 클래스가 인터 페이스Serializable를 구현 해야 함
			// implements Serializable - JVM에게 직렬화 해도 좋다는 의미. 직렬화 : 객체를 바이트 배열로 만드는 것.
			// ObjectOutputStream은 객체를 직렬화하는 역할을 함.
			long end = System.currentTimeMillis(); // 쓰기 종료 시간
			System.out.println("파일 쓰기 시간 : " + (end - start) + "ms");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 파일에서 데이터를 읽음. 읽는 데 걸린 시간 측정.
		try(
				FileInputStream fis = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
		){ long start = System.currentTimeMillis();
		  ArrayList<Student> studensData = (ArrayList<Student>) ois.readObject();	
		   long end = System.currentTimeMillis();
		   System.out.println("파일 읽기 시간 : " + (end - start) + "ms");
		   System.out.println("size = " + studensData.size());
		   System.out.println("fist: " + studensData.getFirst());
		   System.out.println("last: " + studensData.getLast());
		} catch(Exception e) {
			e.printStackTrace(); //-> 에러의 발생근원지를 찾아서 단계별로 에러를 출력합니다.
		}
		//e.getMessage() : 에러의 원인을 간단하게 출력합니다.
		//e.toString() : 에러의 Exception 내용과 원인을 출력합니다.
		
	}//main()끝

}//class끝
