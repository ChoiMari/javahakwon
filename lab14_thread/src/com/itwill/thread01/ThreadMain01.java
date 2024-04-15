package com.itwill.thread01;
/*
 * - Thread(쓰레드) 사용법
1. Thread를 상속하는 클래스 선언
2. 1에서 선언한 클래스에서 run()메서드를 재정의(오버라이드)
    
    → 쓰레드가 할 일을 코드로 작성.
    
3. 2에서 작성한 클래스의 객체를 생성(new)
4. 3에서 생성된 객체의 start()메서드를 호출.
    
    → 쓰레드 실행 된다. start()메서드는 쓰레드를 시작한다
    
    (주의) 쓰레드 객체의 run 메서드를 직접 호출하면 안된다!
    
    이유 : start() 호출 시 JRE(자바가상머신)에서 쓰레드를 초기화(메모리 할당,스케줄링,…)
    
    해주고 run메서드가 호출 됨. 개발자가 호출하는 것이 아니라 자바가상머신이 호출해 줌.
    
    자바가상머신이 알아서 처리를 해야 해서. 
    
    개발자가 run메서드를 직접 실행하는 것이 아니라고 함.
 */
public class ThreadMain01 {

	public static void main(String[] args) {
		//1. Tread를 상속하는 클래스를 선언
		class MyTread extends Thread{
			private String name; //필드
			
			 //생성자
			public MyTread(String name) {
				this.name = name;
			}
			
			//2. run 메서드 재정의 -> 쓰레드가 할 일
			@Override
			public void run() {
				for(int i = 0;i < 100;i++) {
					System.out.println(i + ":" + name);
					try {
						sleep(100); //Thread.sleep(100);인데 extends Thread 상속 받고 있으니까 
						// 그냥 sleep으로 사용
						//Thread 클래스의 static으로 선언된 sleep 메서드 호출 
						// ->0.1초(100ms/1000초)를 쉰다.
						// 출력하고 0.1초 잠잤다가 또 출력하고.. 뭐 그런 기능하는 메서드라고 함
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		//3. 2에서 작성한 클래스MyTread 객체를 생성
		MyTread th1 = new MyTread("쓰레드");
		MyTread th2 = new MyTread("Hello");
		MyTread th3 = new MyTread("안녕하세요");
		
		long start = System.currentTimeMillis(); //쓰레드 시작 시간.
		
		//4. MyTread 객체의 start()메서드 호출
		th1.start();
		th2.start();
		th3.start();
		//main실행 중에 쓰레드1번, 2번,3번 같이 실행. - 출력결과 순차적 실행 아님
		//콘솔창에서 쓰레드 2가 2번 실행 되기도 함 서로 경쟁하며 같이 실행됨.
		// 쓰레드 1,2,3 중 뭐가 끝날 지는 개발자가 하는 게 아니라
		// 개발자는 start()만 하고 자바가상머신이 처리.
		
		//실행시킨 다른 프로세스(쓰레드)들이 모두 종료될 때까지 main 프로세스가 기다리게 할 수도 있다.
		try {
			th1.join(); //쓰레드 1이 끝날 때 까지 기다리겠다는 뜻.
			th2.join(); //쓰레드 2가 끝날 때 까지 기다리겠다는 뜻.
			th3.join(); //쓰레드 3가 끝날 때 까지 기다리겠다는 뜻
			// th1,2,3번이 끝날 때 까지 main(){}가 기다리겠다. 쓰레드1,2,3들이 끝나고 main(){}실행
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		//쓰레드 th1,th2,th3 모두 종료된 후 시간
		long end = System.currentTimeMillis(); 
		
		System.out.println("경과 시간: " + (end - start) + "ms");
		
		System.out.println("***** main 메서드 종료 *****");
	}

}
