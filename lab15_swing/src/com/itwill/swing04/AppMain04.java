package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AppMain04 {
	//전부 필드로 변경(디자인 보기에서 버튼눌러서 바꿈)
	// 변수 이름도 아래 처럼 변경.
	private JFrame frame;
	private JTextField textNumber1;
	private JTextField textNumber2;
	private JLabel Label;
	private JLabel Label2;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMultiply;
	private JButton btnDivide;
	private JTextArea textResult;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 349, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label = new JLabel("Number1");
		Label.setBounds(12, 10, 115, 39);
		frame.getContentPane().add(Label);
		
		Label2 = new JLabel("Number2");
		Label2.setBounds(12, 60, 115, 39);
		frame.getContentPane().add(Label2);
		
		textNumber1 = new JTextField();
		textNumber1.setBounds(139, 10, 184, 39);
		frame.getContentPane().add(textNumber1);
		textNumber1.setColumns(10);
		
		textNumber2 = new JTextField();
		textNumber2.setColumns(10);
		textNumber2.setBounds(139, 60, 184, 39);
		frame.getContentPane().add(textNumber2);
		
		btnPlus = new JButton("+"); //+버튼
		
		//--- +버튼 기능 만듬 ------
		btnPlus.addActionListener(new ActionListener() { //+버튼 클릭시 실행 //ActionListene는 인터페이스. {}익명클래스로 구현
			//오버라이드
			public void actionPerformed(ActionEvent e) {
				//TODO : gettext() Number1의 입력값 읽고 Number2의 값 읽어서 +연산
				
//				sumButtonClick(); : 내가 한 것
				double x = 0; //읽은 값 +계산은 try{}밖에 해서 변수를 위로 올림
				double y = 0;
				try {
					x = Double.parseDouble(textNumber1.getText()); 
					//Number1에서 입력한 읽은 값gettext()을 double타입으로 변환해서 변수x에 담음
					y = Double.parseDouble(textNumber2.getText()); 
					//Number2에서 입력한 읽은 값gettext()을 double타입으로 변환해서 변수y에 담음
				} catch(NumberFormatException ex) { //변수이름 e라고 해서 변수이름 겹칩 -에러(ActionEvent e)
					textResult.setText("Number1 또는 Number2에는 숫자를 입력하세요.");
					return; //예외 발생시 위의 코드 출력 하고 return;만나게 해서 actionPerformed() 메서드 종료 
				}
				double result = x + y; // 더함 (다른 버튼은 이 연산 부분 코드만 바꾸면 된다고 함)
				String msg = String.format("%f + %f = %f",x,y,result);//String클래스의 format메서드는 printf랑 사용법 비슷.
				textResult.setText(msg); //+ 연산 결과를 textResult에 setText(msg)보여줌
			}
		});
		//--- +버튼 기능 만듬 끝 ------
		
		btnPlus.setFont(new Font("굴림", Font.PLAIN, 20));
		btnPlus.setBounds(12, 110, 50, 39);
		frame.getContentPane().add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.setFont(new Font("굴림", Font.PLAIN, 20));
		btnMinus.setBounds(104, 109, 50, 39);
		frame.getContentPane().add(btnMinus);
		
		btnMultiply = new JButton("X");
		btnMultiply.setFont(new Font("굴림", Font.PLAIN, 20));
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMultiply.setBounds(187, 109, 50, 39);
		frame.getContentPane().add(btnMultiply);
		
		btnDivide = new JButton("/");
		btnDivide.setFont(new Font("굴림", Font.PLAIN, 20));
		btnDivide.setBounds(273, 109, 50, 39);
		frame.getContentPane().add(btnDivide);
		
		textResult = new JTextArea();
		textResult.setBounds(12, 159, 314, 92);
		frame.getContentPane().add(textResult);
	}

//	private void sumButtonClick() { //내가 한 것
////		String msg1 = Label.getText(); //입력 문자를 String 타입으로 변수에 담으면 계산이 안됨
////		String msg2 = Label2.getText();
//		int msg1 = Integer.parseInt(Label.getText().toString());
//		int msg2 = Integer.parseInt(Label2.getText().toString());
//		String sumResult = "합계= "+ (msg1 + msg2);
//		textResult.setText(sumResult);
//	}
}
