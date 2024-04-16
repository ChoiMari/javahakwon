package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 { //1번째 바깥 클래스

	private JFrame frame;
	private JLabel lblMessage; //지역 변수에서 필드로 바꿈
	private JTextField textinput;
	private JButton btnInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //2번째 익명 클래스(지역 클래스) 메인 바깥에선 안보임
			public void run() {
				try {
					AppMain02 window = new AppMain02();
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
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); //Absolute(절대) 레이아웃
		
		
		//JLabel lblMessage = new JLabel("메세지를 입력하세요..."); //이 변수가 지역 변수가 아니라 필드라면 사용 범위가 커져서
		// 더 좋다고 함.
		
		lblMessage = new JLabel("메세지를 입력하세요..."); // private JLabel lblMessage; 위에서 필드로 선언함
		lblMessage.setFont(new Font("Dialog", Font.BOLD, 25));
		lblMessage.setBounds(12, 10, 489, 123);
		frame.getContentPane().add(lblMessage);//frame.getContentPane()안에 .add(lblMessage) 추가
		
		textinput = new JTextField();
		textinput.setFont(new Font("돋움", Font.PLAIN, 20));
		textinput.setBounds(12, 97, 502, 63);
		frame.getContentPane().add(textinput);
		textinput.setColumns(10);
		
		btnInput = new JButton("입력");
		// 버튼에 ActionListener라고 하는 이벤트 핸들러(이벤트를 다루다)를 설정(등록해라) 
		// 이벤트를 처리해 주는 객체(이벤트 핸들러). 이벤트 리스너(이벤트가 발생 됐는지 안됐는지 기다리면서 듣고 있는 객체)
		// 이벤트 핸들러와 이벤트 리스너 같은 개념이라고. 둘 다 혼용해서 쓴다고 함.
		// 클릭을 기다렸다가 클릭되면 실행됨. 그게 이벤트 리스너.
		btnInput.addActionListener(new ActionListener() { //J버튼 객체 생성 //3번째 내부 클래스
			//ActionListener()는 인터페이스. 그래서 옆에 {} 익명 클래스를 만들어 줌.
			// @오버라이드 1개 메서드 => 펑셔널인터페이스(함수형 인터페이스) -> 람다 표현식으로 변경 가능.
			
			public void actionPerformed(ActionEvent e) {//->버튼이 클릭 되었을 때 할 일을 작성해주면 자바 가상머신이 알아서 호출해준다고 함.
				//(지역) 내부 클래스에서는 외부 클래스의 메서드를 사용할 수 있음.
				handInputButtonClick();//메서드 이름 : 인풋버튼이 클릭이 됐을 때 메서드 호출된다는 뜻.
				//->이 메서드는 main에는 못 만든다고 함.
			}
		});
		btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		btnInput.setBounds(213, 170, 97, 51);
		frame.getContentPane().add(btnInput);
		
	}

	private void handInputButtonClick() { //접근제한 수식어 원래 protected인데 private로 바꿔도 상관 없다함
		
		//1.JtextField에 입력된 문자열을 읽음.(사용자가 입력한 내용을 읽고)
		String msg = textinput.getText();
		
		//2. 1에서 읽은 내용을 J레이블에 씀.(J레이블에 뜨게하고)
		lblMessage.setText(msg); //-> 사용자가.JtextField에 텍스트를 입력하고 버튼 클릭하면 lblMessage J레이블에 뜨게 함.
		
		//3. 1에 JtextField에 입력된 내용을 지운다.(사용자가 입력한 내용은 사라지게 한다)
		textinput.setText(""); //lblMessage에 입력한 내용 사라짐
		
	}
}
