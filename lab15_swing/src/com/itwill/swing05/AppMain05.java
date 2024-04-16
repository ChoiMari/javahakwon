package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

	private JFrame frame;
	private JTextField textName;
	private JTextField textPhoneNum;
	private JTextField textEmail;
	private JLabel lblLabel1;
	private JButton btnInputButton;
	private JLabel lblLabel2;
	private JLabel lblLabel3;
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
				handleButtonClick();
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
		
		textArea = new JTextArea();
		textArea.setBounds(12, 143, 410, 86);
		frame.getContentPane().add(textArea);
	}

	private void handleButtonClick() {
		String name = textName.getText();
		String phoneNum = textPhoneNum.getText();
		String email = textEmail.getText();
		
		textArea.setText(String.format(" [이름] %s \n [전화번호] %s \n [이메일] %s",name,phoneNum,email));
		
	}

}
