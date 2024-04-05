package com.itwill.loop09;

public class LoopMain09 {

	public static void main(String[] args) {
		// 중첩 while 문장을 사용해서 구구단 1단부터 12단 까지 출력.
		
		int a = 1;
		
		
		while (a <= 12) {
			System.out.println(a+"단 ========");
			int b = 1; // b 를 다시 1로 초기화 해줘야 1부터 나옴
			
			while (b <= 12) {
				System.out.printf("%d x %d = %d\n", a, b, a*b);
				b++;
			}
			System.out.println("---------");
			a++;
		}

	}

}
