package com.itwill.project01.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class FrogPizzaMain {

	private JFrame frame;
	private JTextField textId;
	private JLabel labelTitleLogo;
	private JPasswordField textPassword;
	private JLabel labelPassword;
	private JButton btnLogin;
	private JLabel labelId;
	private JPanel login;
	private JButton btnIdPasswordFind;
	private JCheckBox chckbxAutoLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrogPizzaMain window = new FrogPizzaMain();
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
	public FrogPizzaMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		
		frame.setTitle("개구리 피자집"); //창 타이틀 문구
		
		frame.setBounds(100, 100, 350, 350);
		
		frame.setLocationRelativeTo(null);//창을화면 중앙에 띄움
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		login = new JPanel();
		login.setBounds(0, 0, 350, 350);
		frame.getContentPane().add(login);
		login.setLayout(null);
		
		textId = new JTextField();
		textId.setFont(new Font("굴림", Font.PLAIN, 20));
		//id 입력하는 텍스트 필드 글자 수 제한 -12글자로
		//오라클 DB에 ID컬럼 데이터 타입 varchar2(15)로 해놓아서 제한을 해두어야 함.
		textId.addKeyListener(new KeyAdapter() { 
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
						if(src.getText().length() >= 12) ke.consume();
			} 
		});
		
		textId.setHorizontalAlignment(SwingConstants.LEFT);
		textId.setBounds(150, 96, 150, 40);
		login.add(textId);
		textId.setColumns(10);
		
		labelId = new JLabel("아이디");
		labelId.setHorizontalAlignment(SwingConstants.LEFT);
		labelId.setFont(new Font("돋움", Font.PLAIN, 20));
		labelId.setBounds(28, 96, 110, 40);
		login.add(labelId);
		
		labelTitleLogo = new JLabel("Frog Pizza");
		labelTitleLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitleLogo.setFont(new Font("굴림", Font.BOLD, 40));
		labelTitleLogo.setBounds(28, 10, 275, 81);
		login.add(labelTitleLogo);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("굴림", Font.PLAIN, 20));
		//비밀번호 입력하는 텍스트 필드 글자 수 제한 -13글자로
		//오라클 DB에 ID컬럼 데이터 타입 varchar2(15)로 해놓아서 제한을 해두어야 함.
		textPassword.addKeyListener(new KeyAdapter() { 
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
						if(src.getText().length() >= 13) ke.consume();
			} 
		});
		
		textPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textPassword.setColumns(10);
		textPassword.setBounds(150, 152, 150, 40);
		login.add(textPassword);
		
		labelPassword = new JLabel("비밀번호");
		labelPassword.setHorizontalAlignment(SwingConstants.LEFT);
		labelPassword.setFont(new Font("돋움", Font.PLAIN, 20));
		labelPassword.setBounds(28, 152, 110, 40);
		login.add(labelPassword);
		
		btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("돋움", Font.PLAIN, 15));
		btnLogin.setBounds(203, 218, 100, 30);
		login.add(btnLogin);
		
		JButton btnJoinMembership = new JButton("회원가입");
		//회원가입 버튼 클릭시 실행 코드
		btnJoinMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrogPizzaJoinMembership.showFrogPizzaJoinMembership();
			}
		});
		btnJoinMembership.setFont(new Font("돋움", Font.PLAIN, 15));
		btnJoinMembership.setBounds(203, 255, 100, 30);
		login.add(btnJoinMembership);
		
		btnIdPasswordFind = new JButton("아이디, \r\n비밀번호 찾기");
		btnIdPasswordFind.setFont(new Font("돋움체", Font.PLAIN, 11));
		btnIdPasswordFind.setBounds(28, 260, 156, 23);
		login.add(btnIdPasswordFind);
		
		chckbxAutoLogin = new JCheckBox(" 자동 로그인");
		chckbxAutoLogin.setFont(new Font("돋움", Font.PLAIN, 15));
		chckbxAutoLogin.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxAutoLogin.setBounds(28, 222, 115, 23);
		login.add(chckbxAutoLogin);
	}
}
