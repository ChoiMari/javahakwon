package com.itwill.swing05;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AppMain05 {

	private JFrame frame;
	private JTextField textName;
	private JTextField textPhoneNum;
	private JTextField textEmail;
	private JLabel lblLabel1;
	private JButton btnInputButton;
	private JLabel lblLabel2;
	private JLabel lblLabel3;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize(); //기본생성자에서 메서드 호출 - 이 호출되는 메서드에서 필드 초기화
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //메서드가 필드 초기화
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblLabel1 = new JLabel("이름");
		lblLabel1.setBounds(12, 20, 102, 30);
		frame.getContentPane().add(lblLabel1);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(126, 21, 182, 30);
		frame.getContentPane().add(textName);
		
		btnInputButton = new JButton("입력");
		btnInputButton.addActionListener(new ActionListener() { //입력 버튼 클릭시 실행
			public void actionPerformed(ActionEvent e) {
				handleInputButtonClick();
			}
		});
		btnInputButton.setBounds(325, 103, 97, 27);
		frame.getContentPane().add(btnInputButton);
		
		lblLabel2 = new JLabel("전화번호");
		lblLabel2.setBounds(12, 60, 102, 30);
		frame.getContentPane().add(lblLabel2);
		
		lblLabel3 = new JLabel("이메일");
		lblLabel3.setBounds(12, 103, 102, 30);
		frame.getContentPane().add(lblLabel3);
		
		textPhoneNum = new JTextField();
		textPhoneNum.setColumns(10);
		textPhoneNum.setBounds(126, 61, 182, 30);
		frame.getContentPane().add(textPhoneNum);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(126, 103, 182, 30);
		frame.getContentPane().add(textEmail);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 140, 410, 111);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	private void handleInputButtonClick() {
		//JTextField(이름,전화번호,이메일)에 입력된 문자열을 읽음
		String name = textName.getText();
		String phoneNum = textPhoneNum.getText();
		String email = textEmail.getText();
		
		String msg = String.format(" [이름] %s , [전화번호] %s , [이메일] %s \n",name,phoneNum,email);
		// 이름,전화번호 ,이메일을 JtextArea에 씀.
//		textArea.setText(msg);
		
		//입력버튼 누를 때 마다 밑에 쌓이게 만듬
		textArea.append(msg); //기존의 작성된 내용 끝에 추가
		
		//모든 JTextField의 입력된 내용을 지움.
		textName.setText(""); //"" 비어있는 문자열로 만들어서 내용을 지움
		textPhoneNum.setText(""); //"" 비어있는 문자열로 만들어서 내용을 지움
		textEmail.setText(""); //"" 비어있는 문자열로 만들어서 내용을 지움
		
		//만약 gettext()가 null을 리턴 했다면 출력될 때 null이 나온다고 함.
		//그래서 ""비어있는 문자열로 만들어서 내용을 지운것
		// gettext()가 "" 비어있는 문자열인지 비교해서 입력이 안됐다 하면
		// 입력 버튼 눌렀을 때 내용을 입력하세요라고 할 수도 있음.
		

	}
}
