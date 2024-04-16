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
				//System.out.println(this); ->Runnable()타입의 객체 주소라고 함
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
			public void actionPerformed(ActionEvent e) { // 사용자가 +버튼 클릭시 자바 가상머신이 감지하고 이 메서드를 호출함.
				handleButtonClick(e); //메서드 호출
				//TODO : gettext() Number1의 입력값 읽고 Number2의 값 읽어서 +연산
//				System.out.println(e.getSource() == btnPlus); // 버튼 클릭시 자바가상머신이 ActionEvent객체를 아규먼트로 넘김
//				// 그 아규먼트로 넘긴 getSource()값이(= 이벤트가 발생한 위치)가 btnPlus버튼과 같은지 비교
//				//+버튼 누르면 콘솔 창에 true가 출력됨.
//				
////				sumButtonClick(); : 내가 한 것
//				double x = 0; //읽은 값 +계산은 try{}밖에 해서 변수를 위로 올림
//				double y = 0;
//				try {
//					x = Double.parseDouble(textNumber1.getText()); 
//					//Number1에서 입력한 읽은 값gettext()을 double타입으로 변환해서 변수x에 담음
//					y = Double.parseDouble(textNumber2.getText()); 
//					//Number2에서 입력한 읽은 값gettext()을 double타입으로 변환해서 변수y에 담음
//				} catch(NumberFormatException ex) { //변수이름 e라고 해서 변수이름 겹칩 -에러(ActionEvent e)
//					textResult.setText("Number1 또는 Number2에는 숫자를 입력하세요.");
//					return; //예외 발생시 위의 코드 출력 하고 return;만나게 해서 actionPerformed() 메서드 종료 
//				}
//				double result = x + y; // 더함 (다른 버튼은 이 연산 부분 코드만 바꾸면 된다고 함)
//				String msg = String.format("%f + %f = %f",x,y,result);//String클래스의 format메서드는 printf랑 사용법 비슷.
//				textResult.setText(msg); //+ 연산 결과를 textResult에 setText(msg)보여줌
			}
		});
//		//--- +버튼 기능 만듬 끝 ------
		
		btnPlus.setFont(new Font("굴림", Font.PLAIN, 20));
		btnPlus.setBounds(12, 110, 50, 39);
		frame.getContentPane().add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {// "-"버튼 클릭시 실행 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
				
			}
		});
		
		btnMinus.setFont(new Font("굴림", Font.PLAIN, 20));
		btnMinus.setBounds(104, 109, 50, 39);
		frame.getContentPane().add(btnMinus);
		
		btnMultiply = new JButton("X");
		
		//"X"버튼 클릭시 실행 -> 람다표현식 사용.
		btnMultiply.addActionListener((e) -> handleButtonClick(e));
		
		btnMultiply.setFont(new Font("굴림", Font.PLAIN, 20));
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMultiply.setBounds(187, 109, 50, 39);
		frame.getContentPane().add(btnMultiply);
		
		// "/" 버튼 클릭시 실행 -> 람다 표현식 사용
		btnDivide = new JButton("/"); 
		//btnDivide.addActionListener(AppMain04:: handleButtonClick); //AppMain04의 main()가 static 어쩌고 해서 메소드 참조 람다 안된다고..
		btnDivide.addActionListener(this:: handleButtonClick); //->this로 하면 된다고 함.
		//System.out.println(this); //출력시 com.itwill.swing04.AppMain04@33a3b252
		//여기서 this는 AppMain04.this라고 함. 
		//AppMain04가 생성한 객체라고..(생성자를 불렀을 때 만들어진 객체의 주소라고 함)
		
		//btnDivide.addActionListener((e) -> handleButtonClick(e));
		
		
		btnDivide.setFont(new Font("굴림", Font.PLAIN, 20));
		btnDivide.setBounds(273, 109, 50, 39);
		frame.getContentPane().add(btnDivide);
		
		textResult = new JTextArea();
		textResult.setBounds(12, 159, 314, 92);
		frame.getContentPane().add(textResult);
	}

	private void handleButtonClick(ActionEvent e) { //버튼 클릭시 아규먼트로 오는 값의 변수 이름 e
		// JtextField에 입력된 문자열을 숫자(double)로 변환
		double x = 0;//->0 int값을 double타입에 담음. 암묵적 casting이라고 선생님이..
		double y = 0;
		try {
			x = Double.parseDouble(textNumber1.getText());
			y = Double.parseDouble(textNumber2.getText());
		} catch(NumberFormatException ex) {//변수이름 겹쳐서 ex로
			textResult.setText("Number1 또는 Number2에는 숫자로 입력해주세요.."); 
			//예외 발생시 textResult에 .setText("Number1 또는 Number2에는 숫자로 입력해주세요.."); 보여짐.
			
			return;//-> 예외 발생시 해당 메서드 종료되게 해놓음. 
		}
		
		double result = 0;
		String operator =""; //사칙연산 기호(+,-,x,/)를 저장할 변수. String.format에서 %s 에 들어갈 변수.
		
		Object source = e.getSource(); //이벤트가 발생한 소스(UI 컴포넌트 주소)를 찾아 그 리턴값을 변수 source에 저장.
		//ActionEvent클래스의 getSource()메서드가 오브젝트 타입으로 값을 리턴하기 때문에 오브젝트 타입 변수 선언하고 초기화
		// 그 하위 타입의 모든 객체들을 다 리턴할 수 있으니까(다형성) 리턴 타입이 오브젝트라고 함.
		// 우리는 오브젝트 타입에 변수를 담아서 나중에 쓸 때는 타입을 캐스팅해서 쓰면 된다고 함
		// 단지 주소값만(heap메모리의 주소값,참조값 비교) 비교한다고 하면 캐스팅도 필요 없다고 함.
		if(source == btnPlus) {
			result = x + y;
			operator = "+";
		} else if(source == btnMinus) {
			result = x - y;
			operator = "-";
		} else if(source == btnMultiply) {
			result = x * y;
			operator = "x";
		} else if(source == btnDivide) {
			result = x / y;
			operator = "/";
		}
		String msg = String.format("%f %s %f = %f", x, operator, y, result);
		textResult.setText(msg);
	}
	
	
	
	
	
//	private void sumButtonClick() { //내가 한 것 +버튼만 만듬
////		String msg1 = Label.getText(); //입력 문자를 String 타입으로 변수에 담으면 계산이 안됨
////		String msg2 = Label2.getText();
//		int msg1 = Integer.parseInt(Label.getText().toString());
//		int msg2 = Integer.parseInt(Label2.getText().toString());
//		String sumResult = "합계= "+ (msg1 + msg2);
//		textResult.setText(sumResult);
//	}
}
