package com.itwill.file03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMain03 {

	public static void main(String[] args) {
		// 연습 하려고 try - catch 이용
		// BufferdInputStream 과 BufferdOutputStream 을 사용한 파일 읽기,쓰기
		
		String origin = "data/ratings.dat";
		String dest = "data/ratings_copy2.dat";
		
		FileInputStream in = null; //finally에서 colse해야 되서.
		BufferedInputStream bin = null;
		FileOutputStream out= null;
		BufferedOutputStream bout= null;
		try {
			in = new FileInputStream(origin); //파일(origin)이 있고 연결하는 통로(FileInputStream)를 만들고(메모리까지만 읽어 올 수 있는)
			bin = new BufferedInputStream(in);// 그 통로(FileInputStream)를 붙여서 프로그램까지 연결하는 통로(BufferedInputStream)를 
			// 또 만들었음.얘(BufferedInputStream)가 가지고 있는 read를 호출 할거임
//			bin = new BufferedInputStream(new FileInputStream(origin)); 
			//->이렇게 한번에 쓸 수도 있지만 선생님은 단계적으로 하는 것을 선호 하신다고 함
			
			out =new FileOutputStream(dest); //dest파일과 연결하는 통로 FileOutputStream를 만들고 
			// 이(FileOutputStream) 통로와 연결하려고 이(FileOutputStream) 통로를 아규먼트로 주어서
			bout = new BufferedOutputStream(out);// BufferedOutputStrea통로를 만듬.
			// 만드는 순서 중요! -> 닫을 때는 나중에 만든 것을 먼저 닫기.
			
			long start = System.currentTimeMillis(); //복사 시작 시간
			while(true) {
				byte[] buffer = new byte[4 * 1024]; // 파일에서 읽을 내용을 저장할 배열
				int b = bin.read(buffer);//BufferedInputStream에서 읽어오는 read메서드 - 바이트 배열을 아규먼트로 호출함 
				// 하드디스크보다 메모리에서 읽어오는 것이 더 빠름.
				if(b == -1) { // 파일 끝에 도달하면 실행 EOF
					break;
				}
				bout.write(buffer, 0, b);
			}
			long end = System.currentTimeMillis(); // 복사 종료 시간 측정
			System.out.println("복사 경과 시간: " + (end - start) + "ms");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제 : 나중에 만들어진 스트림 객체를 먼저 close하고,
			// 먼저 만들어진 스트림 객체를 나중에 close해야 함.
			// 스트림 객체들은 생성된 순서의 반대로 colse 메서드를 호출해야 함.
			// 가장 마지막에 생성된 스트림 객체만 colse하면 나머지는 자동으로 close가 됨.
			// 그래서 아래 코드에 가장 마지막에 만들어진 것만 닫았음. 이렇게 만해도 됨. //-> bout.close(); bin.close();
			// in과 out만 닫아 버리면 bin과 bout는 각각 안 닫힌다고 함.
			try {
				bout.close();
				bin.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
