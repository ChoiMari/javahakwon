package com.itwill.thread02;
/*
 * ### *쓰레드 사용법 2:

나온 이유 : 자바는 다중 상속을 허용하지 않음

class A extends b,c {} →문법 오류

다른 클래스를 이미 상속하는 클래스는 Thread 클래스를 상속할 수 없어서.

다중상속을 우회하는 방법.

자바는 인터페이스 구현 개수는 제한이 없어서 그걸 이용.

class A extends B implements C, D, E {}

1. Runnable 인터페이스를 구현하는 클래스를 선언.
2. 1번에서 선언한 클래스에서 run 메서드를 재정의(오버라이드) - run메서드는 쓰레드가 할일
3. Thread 생성자 중에서 생성자의 아규먼트로 2에서 작성한 클래스의 객체를 아규먼트 값으로 넘겨주면 됨 (Runnable을 아규먼트로 갖는 생성자를 호출)
    
     → 그럼 쓰레드 객체가 만들어짐
    
4. 3에서 생성된 쓰레드 객체의 start() 메서드를 호출
    
    → 쓰레드 실행
 */

public class ThreadMain02 {

	public static void main(String[] args) {
		//1. Runnable 구현 클래스
		class MyRunnable implements Runnable{ //Runnable은 펑셔널 인터페이스(함수형 인터페이스)
			
			private String name;
			
			
			public MyRunnable(String name) {
				this.name = name;
			}


			//2. Runnable 인터페이스의 run 메서드 구현(매서드 재정의)
			@Override
			public void run() {
				for(int i = 0;i < 100; i++) {
					System.out.println(i + " - " + name);
					//sleep(10);
					//->쓰레드 클래스가 아님. 쓰레드를 상속하는게 아니라... 얘는 쓰레드클래스에만 있음
					try {
						Thread.sleep(10); //0.01초 잠자다가 실행 또 잠자다가 실행 이렇게 i가 0부터 i <100까지 반복
						// 쓰레드 클래스는 java.lang패키지에 있어서 import문 필요 없음
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				
			}
			
		}
		// 익명 클래스 객체를 사용한 쓰레드 생성
		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0;i < 100; i++) {
					System.out.println(i + " - 익명(Anonymous) 클래스");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		});
		
		//람다 표현식을 사용한 쓰레드 객체 생성
		Thread th3 = new Thread(() -> {
			for(int i = 0;i < 100; i++) {
				System.out.println(i + "- 람다(Lambda)");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		//3. Thread 객체 생성 - Runnable 인터페이스 구현 객체를 아규먼트로 전달.
		Thread th1 = new Thread(new MyRunnable("지역 클래스"));
		
		//4. Thread 실행
		th1.start();
		th2.start();
		th3.start();
		
		try {
			th1.join();
			th2.join();
			th3.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("***** main 프로세스 종료 *****");
	}

}
