package com.itwill.file08;

import java.io.File;

/*
 * 파일,폴더(디렉토리) 관리 - 정보, 생성, 삭제, ...
 * 
 * 현재 작업 폴더(CWD: Current Working Directory) : 
 * 	현재 프로그램(프로세스)가 실행되는 폴더 위치.
 *  이클립스에서 자바 프로그램을 실행(Run as Java application)할 때, 현재작업폴더의 위치는 프로젝트 폴더
 *  현재 프로그램이 어느 폴더 밑에서 실행 되고 있느냐.
 * 
 * 절대 경로(absolute path) : 
 *  - 시스템의 루트(제일 상위 폴더) c:\, D:\ , / 부터 파일 또는 폴더가 있는 위치까지를 찾아가는 방식.
 *  - Window 예 : C:\study\git\javahakwon\lab12_file\data\hello.txt
 *    \로 폴더와 폴더 구분.
 *  
 *  - Linux, MacOS 예) /users/itwill/documents/hello.txt
 *    폴더와 폴더 구분 / 사용
 *  
 * 상대 경로(relative path) :
 *  - 현재작업폴더를 기준으로 파일 또는 폴더 위치를 찾아가는 방식.
 *  - Window 예) : data\hello.txt
 *  - Linux, MacOS 예) : documents/hello.txt
 *  - 현재 폴더(디렉토리) : . (예) .\data\hello.txt
 *  .은 현재 폴더라는 뜻
 *  - 상위 폴더(디렉토리) : .. (예) ..\src\com\itwill\file08\FileMain08.java
 *  상위 폴더를 나타낼 때 .. 이라고 씀
 *  
 *  파일 구분자(file separator) :
 *  - 상위 폴더와 하위 폴더, 폴더와 파일을 구분하기 위한 기호.
 *  - Windows: \ 백슬래쉬
 *  - Linux, MacOS : / 슬래쉬
 *  
 *  - 문자열("") 안에서 백슬래쉬(\)는 특별한 의미(escape 탈출 문자)
 *   o.  "\n" : 줄바꿈, "\t" : 탭, "\s" : 공백, "\\" : 백슬래쉬 
 *   그래서 \\ 백슬래쉬를 2개를 붙여서 씀. 그럼 \로 인식.
 *   이게 귀찮으면 / 쓰기. -> Windows여도 자바 컴파일러에서 허용.
 *   
 *   o. Window 파일 경로  :  "C:\\study\\git\\javahakwon\\lab12_file\\data\\hello.txt"
 *   o. Linux, MacOS 파일 경로 : "/users/itwill/documents/hello.txt"
 *   
 */

public class FileMain08 {

	public static void main(String[] args) {
		// 이클립스에서 자바 프로그램이 실행되는 현재 작업 폴더(디렉토리 CWD) 찾아보기
		String cwd = System.getProperty("user.dir"); 
		System.out.println("CWD: " + cwd); //출력 결과 : CWD: C:\study\git\javahakwon\lab12_file
		
		String path = "C:\\study\\git\\javahakwon\\lab12_file"; // Windows 절대 경로 표현법
		//C:\study\git\javahakwon\lab12_file를 ""안에 복붙 했더니 자동으로 \가 \\씩 들어가서 붙여넣기 됨.
		System.out.println(path); //출력 결과 : C:\study\git\javahakwon\lab12_file
		
		//String path2 = "data\\hello.txt"; // Windows 상대 경로 표현법
		//-> 이건 좋은 방법이 아니라고 함.. 코드의 재활용성 떨어짐/.. 어느 운영체재든 똑같이 적용되게 해야 좋음.
		
		String path2 = "data" + File.separator + "hello.txt"; //system-dependent 시스템에 의존하는(시스템에 따라서 달라지는)
		// Linux, MacOS 경우에는 /가 들어 간다고 함. 
		//-> OS에 무관한 상대 경로
		System.out.println(path2); //출력 결과 : data\hello.txt
		
		//File 클래스 - 문맥에 따라서 구별해서 이해 하기.
		// 폴더도 넓은 의미의 파일이라고 함.
		// 좁은 의미의 파일(txt,jpg,mp4,...)과 폴더(디렉토리)에 관련된 기능들을 가지고 있는 클래스
		// 파일 객체 - 파일을 다루기도 하고 폴더를 다루기도 함.
		//File 타입 객체 생성 - 파일과 폴더를 관리할 수 있는 객체 생성.
		File f = new File(path2);
		System.out.println("경로: " + f.getPath()); //경로: data\hello.txt
		System.out.println("절대 경로: " + f.getAbsolutePath()); 
		//절대 경로: C:\study\git\javahakwon\lab12_file\data\hello.txt
		
		System.out.println("존재 여부: " + f.exists()); //파일이 있으면 true , 없으면 false를 리턴(물리적인 파일 여부)
		//출력 결과 -> 존재 여부: true
		// 파일과 파일 객체는 다름.
		// 변수 f는 파일 타입의 객체
		// 물리적인 파일은 "data" + File.separator + "hello.txt";
		// 물리적인 파일과 파일 객체를 구별하자.
		
		System.out.println("파일 여부: " + f.isFile()); //파일 인가요? -> 파일 여부: true
		System.out.println("폴더 여부: " + f.isDirectory());// 폴더 인가요? -> 폴더 여부: false
		System.out.println("파일 크기: " + f.length() + "바이트"); // 파일의 길이를 리턴한다(바이트 단위)
		//파일 크기: 79바이트
		
		//새 폴더 만들기
		File testFolder = new File("test");// 파일 객체 생성
		//System.out.println(testFolder.getAbsolutePath());
		if(testFolder.exists()) {
			System.out.println("이미 폴더가 존재...");
		}else {
			testFolder.mkdir(); // mkdir(); 폴더 만드는 메서드. 리턴 타입 boolean. 생성 성공 true리턴, 실패 false리턴
			// make directory의 약자
			System.out.println("폴더 생성 성공");
		}
		
		// 폴더 삭제
		if(testFolder.exists()) { // 폴더가 있나요? true시 실행
			testFolder.delete(); //delete() : 폴더 삭제 메서드 boolean 타입 리턴 . 삭제 성공 시 true 실패 시 false
			System.out.println("폴더 삭제 성공");
		} else {
			System.out.println("폴더가 존재하지 않음...");
		}
		// 파일 객체와 하드디스크의 물리적인 파일 문맥에 따라서 구분하기
		// 파일 객체는 폴더가 있는지 없는지 검사하고 , 생성등의 기능. 실제 물리적인 파일 없더라도 파일 객체 생성가능
		
		
		
	}

}
