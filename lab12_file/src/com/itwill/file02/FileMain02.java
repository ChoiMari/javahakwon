package com.itwill.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileMain02 {

	public static void main(String[] args) throws Exception {
		// 대용량 파일 복사 : 
		// data/ratings.dat 파일을 읽고, data/ratings_copy.dat 파일에 복사
		// 1. read(), write(int b) 메서드를 사용할 때 시간 측정.
		// 2. 다른 read(), write 메서드를 사용할 때 시간 측정.
		
		String origin = "data/ratings.dat"; //원본 파일
		String dest = "data/ratings_copy.dat"; // 복사할 파일
		
		FileInputStream in = new FileInputStream(origin);
		// throws FileNotFoundException 발생 할 수 있는데 main에 던짐
		
		FileOutputStream out = new FileOutputStream(dest);
		
		long start = System.currentTimeMillis(); // 파일 복사 시작 시간 측정
		
		while(true) {
			//1. read()메서드 사용
			//int b = in.read(); //파일에서 1바이트 읽음. , 실제 파일 데이터를 리턴.
			//int타입 4바이트 실제로 파일에서 읽은 것 1바이트 나머지는 0으로 채우고 리턴
			// 4바이트를 주더라도 앞에 0으로 채워진 건 주지 않고 1바이트 읽은 것만 파일에 다 write
			
			//2. read(byte[] b)메서드 사용:
			
			byte[] buffer = new byte[4*1024]; //4,096바이트(4KB) 크기의 빈 배열 생성.
			// 바이트 크기가 크면 클 수록 반복횟수 줄어듬 대신, 메모리를 더 많이 사용.
			// 바이트 크기가 적으면 반복횟수 많아지지만 메모리를 적게 사용.
			
			int b = in.read(buffer); // 한번에 읽어 들이는 양 많다 반복문 횟수 줄어 듬.
			//read메서드가 리턴하는 값은 int - 실제 읽은 데이터가 아니라 몇 바이트 읽었는지 리턴.
			//->buffer : 파일에서 읽은 내용을 저장하기 위한 바이트 배열.
			//->리턴 값의 의미 : 4096바이트씩 주다보면 끝에 남아있는 부분 4096보다 작은 경우가 있어서,
			// 파일에서 실제로 읽은 바이트 수를 리턴해준다.
			
			
			
			if(b == -1) { //파일 끝에 도달 //EOF 
				break;//무한루프 종료
			}
			//1. write(int b)메서드 사용
			//out.write(b);//파일에 1바이트 씀.
			
			//2.write(byte[] b) 메서드 사용
			//out.write(buffer); //바이트 배열을 아규먼트로 주면 됨. 리턴타입 void
			//->바이트 배열의 내용을 그대로 파일에 씀. 4KB 씩 파일에 씀.
			// 제일 마지막에 읽은 것은 4KB가 아닐 수가 있는데..? 마지막에도 그래도 그냥 4KB씩 씀
			// 그래서 복사된 파일 크기 4KB차이가 남.
			
			//3.write(byte[] buf,int off, int len)
			out.write(buffer, 0, b);
			//(byte[] b,int off, int len)에서 byte[] buf 의 의미 : 파일에 쓸 데이터를 가지고 있는 바이트 배열.
			//int off : 건널 뛸 위치. 배열 b에서 읽기 시작할 인덱스. offset
			//0으로 주었다면 건너뛰는 부분없이 다 읽겠다.
			//4라고 주면 인덱스 1,2,3건너뛰고 4부터 읽겠다
			//int len :길이 length. 배열에서 실제로 파일에 쓸 바이트 길이
			//4KB가 비워져 있는 상태 read를 하게 되면 채워지는데, 다 채워져 있을 수도 일부분은 비워져 있을 수도 있다
			//write는 실제로 읽은 바이트 길이 만큼만 write를 하면 파일 크기 똑같..?
			// 반드시 read의 리턴값을 기록하고 있다가 그걸 write할 때 이용하면 된다고 함.
			// 마지막 인덱스로 length로 주면 된다고.
			
		}
		long end =System.currentTimeMillis(); // 파일 복사 종료 시간 측정
		//1000분의 1초 단위
		
		System.out.println("복사 경과 시간: " + (end - start) + "ms");
		
		in.close(); //FIS 리소스 해제
		out.close();//FOS 리소스 해제
	}

}
