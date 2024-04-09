package com.itwill.file01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMain01 {

	public static void main(String[] args) {
		String origin = "data/hello.txt"; // 원본 파일(읽을 파일) 경로, 이름.
		// 파일 이름 줄 때 프로젝트 이름 생략하고 경로.
		
		String destination = "data/hello_copy.txt"; // 복사할 파일 경로,이름
		
		//읽기 위해서 FileInputStream 필요함
		FileInputStream in = null; 
		FileOutputStream out = null;
		try {
			in = new FileInputStream(origin); //FileInputStream 객체 생성
			//FileInputStream in = new FileInputStream(origin);
			//문자열의 경로나 예외 발생시 파일도 없는데 들어오는 통로 만들면 안되니까 예외 던지는 걸로 해버림??
			out = new FileOutputStream(destination); //파일 쓰기 위한 파일 아웃풋객체 생성 // FileOutputStream객체 생성
			
			while(true) {
				int read = in.read(); //파일에서 1바이트 읽음
			// 통로에서 read메서드 호출
			//input stream으로 부터 1바이트만 읽고 int타입에 저장.
			//읽은 바이트나 파일의 끝에 도달했을 때에는 -1을 리턴
			// 왜 음수로 리턴해 주냐면 -1이란 유니코드 값이 없으니까 -1이 파일에 끝이다라는 의미라고 함.
			//만일 여기서 예외 발생시 catch로 가기 때문에 밑의 close를 쓰면 안될 수 있음 그래서 close를 finally로
			
			// in.close(); //close하는 위치가 문제가 될 수 있음. 
			
			if(read == -1) {// 파일 끝(EOF : End-Of-File)에 도달 했을 때 // 파일 끝에서 -1이 리턴 되면 break 반복문 빠져나옴.
				break;
			}
			out.write(read);//파일에 읽은 1바이트를 씀 // 읽어드린 값을 그대로 write함
			//System.out.println((char) read); //-> 의미 : 영문자의 유니코드는 1바이트면 충분. 
			//0~255사이에서 충분해서 1바이트만 읽어도 영문자 표현에 문제가 없음
			// 출력된 문자 보면 char로 변환 했을 때 영문자는 깨지지 않고 보임
			// 그런데 한글은 최소 2바이트가 있어야 표현 가능한데 read는 1바이트만 읽으니까 글자가 깨짐.
			// 복사하는 입장에서는 1바이트 읽고 내보내고 또 읽고 쓰고 
			// 파일 복사하는 용도에서는 굳이 2바이트로 조합해서 콘솔창에 뿌리는건 필요 없다고함.
			// 
			}
			System.out.println("파일 복사 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// in.close(); -> 이것도 안됨 in이 지역 변수라서 선언된 블록 안에서만 사용가능. try끝나면 in변수가 사라짐
			//다른 블럭에서 사용 불가능. 해결방법 : 변수 in 선언 부분을 위로 올리기.
			// 그리고 try에서 생성자 호출해서 객체 생성(new) 저장.
			try { //finally안에서 또 try catch로 감쌈.
				in.close(); //FIS 객체를 닫음 (close = 리소스 해제 한다)
				out.close(); //FOS 객체를 닫음 (close = 리소스 해제 한다)
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
