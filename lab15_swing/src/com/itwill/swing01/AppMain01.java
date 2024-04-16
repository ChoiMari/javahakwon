package com.itwill.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppMain01 {

	private JFrame frame; // 생성자 호출 될 때 초기화 된다고 함.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { //.invokeLater 이벤트큐에 프로세스를 등록해놓고 자바가상머신이 어쩌고..
		//자바가상머신(JRE)에 의해서 실행될 쓰레드를 등록
		EventQueue.invokeLater(new Runnable() { //EventQueue클래스 이름으로 .invokeLater메서드 호출 - static메서드(객체생성new없이 호출가능)
			//new Runnable() - 인터페이스. 익명클래스{}구현
			//run메서드를 @오버라이드 
			public void run() { //run()메서드 : 쓰레드가 할 일
				try { //우리가 메인 메서드를 실행 시키면 자바가상머신에 의해서 run()메서드가 실행 된다.
					AppMain01 window = new AppMain01(); //여기서 AppMain01()생성자 호출. 변수이름 window
					// AppMain01()생성자가 호출 되면서 -> initialize();호출됨  initialize();메서드가 실행되면서 값 초기화  
					
					window.frame.setVisible(true); //setVisible(true)보여줄까? 그걸 세팅 하겠다 true
					//->JFrame 객체를 화면에 보여주세요라는 코드 - true
					//false로 바꾸면 창 안뜸. true여야 실행 했을 때 창이 보여짐
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); //필드 초기화 - 화면에 보여질 수 있는 객체를 생성했다고 이해하면 됨 JFrame()객체 생성
		frame.setBounds(200, 200, 429, 331);//setBounds의미 : 아까 창 뜰 때 위치와 크기. 
		//왼쪽 상단이 0을 기준으로 좌표 x(가로)100,y(세로)100, 창의 크기 450x300로 뜨는 설정.
		//setBounds(x,y,w,h) : JFrame의 시작 좌표(x,y)와 크기(w:가로, h:세로)를 설정
		// 디자인 창에서 크기 조절시 자동으로 소스코드도 바뀜
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//기본 닫기 동작 세팅 JFrame(클래스 이름) .EXIT_ON_CLOSE(public static final변수)
		//모든 창에는  X버튼 있음
		// 이 x버튼을 클릭했을 때의 무슨일을 할지 설정.
		//ON_CLOSE x버튼 눌렀을 때 EXIT 프로그램을 나가겠다는 뜻.
		// JFrame의 오른쪽 상단에 있는 닫기 버튼(x)의 기능을 설정 - x버튼 누르면 프로그램 종료되게 설정되어있음.
		JLabel lblMessage = new JLabel("안녕하세요. Swing!");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER); // 가로방향 정렬 - 중앙
		lblMessage.setFont(new Font("D2Coding ligature", Font.BOLD, 22)); // 폰트 변경
		frame.getContentPane().add(lblMessage, BorderLayout.CENTER);
		//레이블이라는 객체가 frame.getContentPane() 안에.add(lblNewLabel, BorderLayout.CENTER); 추가가 된 것.

	}

}
