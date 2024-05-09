package com.itwill.project01.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import static com.itwill.project01.model.Membership.Member.COL_EMAIL;
import static com.itwill.project01.model.Membership.Member.COL_ID;
import static com.itwill.project01.model.Membership.Member.COL_JOIN_DATE;
import static com.itwill.project01.model.Membership.Member.COL_NAME;
import static com.itwill.project01.model.Membership.Member.COL_PASSWORD;
import static com.itwill.project01.model.Membership.Member.COL_PHONE_NUMBER;
import static com.itwill.project01.view.OracleJdbc2.PASSWORD;
import static com.itwill.project01.view.OracleJdbc2.URL;
import static com.itwill.project01.view.OracleJdbc2.USER;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import com.itwill.project01.controller.LoginMemberDao;
import com.itwill.project01.controller.OrderMenuDao;
import com.itwill.project01.model.LoginMember;
import com.itwill.project01.model.Membership;

import oracle.jdbc.OracleDriver;
import oracle.sql.OPAQUE;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrogPizzaLoginFrame {

	private LoginMemberDao loginMemberDao =LoginMemberDao.getInstance();
	
	private JFrame frame;
	private JTextField textId;
	private JLabel labelTitleLogo;
	private JPasswordField textPassword;
	private JLabel labelPassword;
	private JButton btnLogin;
	private JLabel labelId;
	private JPanel panelLogin;
	private JButton btnIdPasswordFind;
	
	
	private boolean loginIdResult;
	private boolean loginPasswordResult;
	private JLabel lblNewLabel_1;
	private JButton btnJoinMembership;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { //showFrogPizzaLoginFrame()
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrogPizzaLoginFrame window = new FrogPizzaLoginFrame();
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
	public FrogPizzaLoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);//사용자가 화면 크기 조절 못하게 함.
		frame.setTitle("개구리 피자 로그인"); //창 타이틀 문구
		//창 아이콘
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/project01/image/아이콘.png"));
		frame.setIconImage(img);
		
		frame.setBounds(100, 100, 350, 350);
		
		frame.setLocationRelativeTo(null);//창을화면 중앙에 띄움
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 334, 311);
		frame.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
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
		textId.setBounds(155, 101, 150, 40);
		panelLogin.add(textId);
		textId.setColumns(10);
		
		labelId = new JLabel("");
		labelId.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/아이디.png")));
				//(".\\image\\아이디.png"));
		labelId.setHorizontalAlignment(SwingConstants.LEFT);
		labelId.setFont(new Font("돋움", Font.PLAIN, 20));
		labelId.setBounds(15, 101, 110, 40);
		panelLogin.add(labelId);
		
		labelTitleLogo = new JLabel("");
		labelTitleLogo.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/피자로그인문구.png")));
		//(new ImageIcon(".\\image\\피자로그인문구.png"));
		labelTitleLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitleLogo.setFont(new Font("굴림", Font.BOLD, 40));
		labelTitleLogo.setBounds(47, 10, 275, 81);
		panelLogin.add(labelTitleLogo);
		
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
		textPassword.setBounds(155, 157, 150, 40);
		panelLogin.add(textPassword);
		
		labelPassword = new JLabel("");
		labelPassword.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/비밀번호.png")));
		//(new ImageIcon(".\\image\\비밀번호.png"));
		labelPassword.setHorizontalAlignment(SwingConstants.LEFT);
		labelPassword.setFont(new Font("돋움", Font.PLAIN, 20));
		labelPassword.setBounds(0, 157, 160, 40);
		panelLogin.add(labelPassword);
		
		btnLogin = new JButton("");
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/로그인버튼.png")));
		//(new ImageIcon(".\\image\\로그인버튼.png"));
		
		//로그인 버튼 클릭시 실행
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textId.getText().equals("")) {JOptionPane.showMessageDialog(panelLogin, "아이디를 입력하세요."); return;}
				if(new String(textPassword.getPassword()).equals("")) {JOptionPane.showMessageDialog(panelLogin, "비밀번호를 입력하세요"); return;}
				logIdCheck(); if(loginIdResult == false) {JOptionPane.showMessageDialog(panelLogin, "아이디가 틀렸습니다.","입력 오류",JOptionPane.ERROR_MESSAGE); textId.setText(""); return;}
				logPassword(); if(loginPasswordResult == false) {JOptionPane.showMessageDialog(panelLogin, "비밀번호가 틀렸습니다.","입력 오류",JOptionPane.ERROR_MESSAGE);textPassword.setText(""); return;}
				//TODO : 로그인 성공 시 -> 현재 접속시간 뜨게 할건지, 아니면 그냥 바로 주문 프로그램창 호출해서 부를건지,
				//JOptionPane.showMessageDialog(panelLogin, "로그인 성공");
				//주문 프로그램창 메서드 호출 하고 로그인화면은 안보이게 설정하기.
			
				
	
				//TODO : 로그인한 아이디로 DB에 저장된 회원정보 찾아서 아규먼트로 넘겨주기.
				String loginId = textId.getText();
				//아규먼트 넘겨받은 클래스에서 정보 필드로 선언해서 저장해놓기.
				//아이디를 아규먼트로 받아서 회원정보 돌려주는 건 LoginMemberDao테이블에 있는 
				//loginMemberProfile(String loginId)메서드
				//회원정보를 담을 리스트 만듬
				//List<Membership> loginIdMemberProfileList  = new ArrayList<>();
				//loginIdMemberProfile의 loginMemberProfile(loginId)메서드가 리턴해준 회원정보를 저장.
				//loginIdMemberProfileList = loginMemberDao.loginMemberProfileList(loginId);
				//이 회원정보를 다시 또 오라클의 새로운 로그인한 회원정보 테이블에 저장함.
				//LOGIN_MEMBER_TB이 테이블로 저장하기
				Membership loginMembership = loginMemberDao.loginMemberProfile(loginId);
				//loginMemberDao.loginInsert(loginMembership);
				
				frame.setVisible(false);
				FrogPizzaFrame.showFrogPizzaFrame(loginId, FrogPizzaLoginFrame.this,loginMembership );
			}
		});
		btnLogin.setFont(new Font("돋움", Font.PLAIN, 15));
		btnLogin.setBounds(179, 218, 124, 30);
		panelLogin.add(btnLogin);
		
		btnJoinMembership = new JButton("");
		btnJoinMembership.setContentAreaFilled(false);
		btnJoinMembership.setBorderPainted(false);
		btnJoinMembership.setFocusPainted(false);
		btnJoinMembership.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/회원가입버튼.png")));
		//(new ImageIcon(".\\image\\회원가입버튼.png"));
		//회원가입 버튼 클릭시 실행 코드
		btnJoinMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrogPizzaJoinMembership.showFrogPizzaJoinMembership();
			}
		});
		btnJoinMembership.setFont(new Font("돋움", Font.PLAIN, 15));
		btnJoinMembership.setBounds(179, 255, 124, 30);
		panelLogin.add(btnJoinMembership);
		
		btnIdPasswordFind = new JButton("");
		btnIdPasswordFind.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/아이디비밀번호찾기.png")));
		//(new ImageIcon(".\\image\\아이디비밀번호찾기.png"));
		btnIdPasswordFind.setContentAreaFilled(false);
		btnIdPasswordFind.setBorderPainted(false);
		btnIdPasswordFind.setFocusPainted(false);
		btnIdPasswordFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrogPizzaIdPasswordFind.showFrogPizzaIdPasswordFind();
			}
		});
		btnIdPasswordFind.setFont(new Font("돋움체", Font.PLAIN, 11));
		btnIdPasswordFind.setBounds(28, 218, 124, 65);
		panelLogin.add(btnIdPasswordFind);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/핑크개구리.png")));
		//(new ImageIcon(".\\image\\핑크개구리.png"));
		lblNewLabel.setBounds(10, 5, 100, 86);
		panelLogin.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/로그인메인.png")));
		//(new ImageIcon(".\\image\\로그인메인.png"));
		lblNewLabel_1.setBounds(0, 0, 334, 311);
		panelLogin.add(lblNewLabel_1);
	}

	
	/**
	 * 로그인시 비밀번호 확인
	 */
	private void logPassword() {
//		 if(new String(textPassword.getPassword()).equals("")) {JOptionPane.showMessageDialog(panelLogin, "비밀번호를 입력하세요"); return;}
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	       
	        try {
	            DriverManager.registerDriver(new OracleDriver());
	           // System.out.println("오라클 드라이버 등록 성공");
	            
	            // 4. 오라클 데이터베이스에 접속(오라클 세션 생성)
	            conn = DriverManager.getConnection(URL, USER, PASSWORD);
	            //System.out.println("오라클 접속 성공");
	            
	            // 5. Statement 타입 객체 생성
	            final String sql = "select * from MEMBERSHIP_TB";
	            //-> Statement 객체에서 사용하는 SQL 문장은 세미콜론(;)을 사용하지 않음!
	            stmt = conn.prepareStatement(sql);
	            
	            // 6-7. SQL 문장 실행 & 결과 처리
	            rs = stmt.executeQuery();
//	            if(textJoinId.getText().equals("")) {
//	            	JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요");
//	            	return;
//	            }
	            while (rs.next()) { // ResultSet(테이블)에서 다음 행(row)이 있는 지 검사
	                // 그 행의 컬럼들에 있는 값을 읽음:
	                String id = rs.getString(COL_ID); // 테이블의 ID 컬럼 값을 읽음.
	                String password = rs.getString(COL_PASSWORD); // 테이블의 TITLE 컬럼 값을 읽음.
	                String name = rs.getString(COL_NAME);
	                String email = rs.getString(COL_EMAIL);
	                String phone = rs.getString(COL_PHONE_NUMBER);
	                        
	                LocalDateTime joinDate = rs.getTimestamp(COL_JOIN_DATE)
	                        .toLocalDateTime();
	                
	                Membership member = new Membership(id, password, name, email, phone, joinDate);
	                
	                boolean loginPasswordCheck = member.getPassword().equals(new String(textPassword.getPassword()));//중복 검사
	                //System.out.println(idCheck);
//	                if(logPasswordCheck == false) {
//	                	JOptionPane.showMessageDialog(panelLogin, "비밀번호가 틀렸습니다.","입력 오류",JOptionPane.ERROR_MESSAGE);
//	                	textPassword.setText("");
//	                	return;
//	                } 
	                if(loginPasswordCheck) {//같은 비밀번호가 확인 되면 메서드 종료
	                	loginPasswordResult = true;
	                	return;
	                }
	               

	            } 
	            
	            loginPasswordResult = false;
	            } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // 리소스 해제
	            try {
	            	rs.close(); // ResultSet 해제.
	                stmt.close();
	                conn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
			
		}
		
		
	

	/**
	 * 로그인시 아이디 확인
	 */
	private void logIdCheck() {
		
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
//        if(textId.getText().equals("")) {JOptionPane.showMessageDialog(panelLogin, "아이디를 입력하세요"); return;}
        
        try {
            DriverManager.registerDriver(new OracleDriver());
           // System.out.println("오라클 드라이버 등록 성공");
            
            // 4. 오라클 데이터베이스에 접속(오라클 세션 생성)
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("오라클 접속 성공");
            
            // 5. Statement 타입 객체 생성
            final String sql = "select * from MEMBERSHIP_TB";
            //-> Statement 객체에서 사용하는 SQL 문장은 세미콜론(;)을 사용하지 않음!
            stmt = conn.prepareStatement(sql);
            
            // 6-7. SQL 문장 실행 & 결과 처리
            rs = stmt.executeQuery();
//            if(textJoinId.getText().equals("")) {
//            	JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요");
//            	return;
//            }
            while (rs.next()) { // ResultSet(테이블)에서 다음 행(row)이 있는 지 검사
                // 그 행의 컬럼들에 있는 값을 읽음:
                String id = rs.getString(COL_ID); // 테이블의 ID 컬럼 값을 읽음.
                String password = rs.getString(COL_PASSWORD); // 테이블의 TITLE 컬럼 값을 읽음.
                String name = rs.getString(COL_NAME);
                String email = rs.getString(COL_EMAIL);
                String phone = rs.getString(COL_PHONE_NUMBER);
                        
                LocalDateTime joinDate = rs.getTimestamp(COL_JOIN_DATE)
                        .toLocalDateTime();
                
                Membership member = new Membership(id, password, name, email, phone, joinDate);
                
                boolean loginIdCheck = member.getId().equals(textId.getText());//중복 검사
                //System.out.println(idCheck);
                if(loginIdCheck) { //같은 아이디가 확인 되면 메서드 종료
                	loginIdResult = true;
                	return;
                } 
               

            }
            loginIdResult = false;
            } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
            	rs.close(); // ResultSet 해제.
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
	}
	
	 public void showLogin() {
		 frame.setVisible(true);
		 textId.setText("");
		 textPassword.setText("");
	 }
	 
	
	
}


//package com.itwill.project01.view;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//
//import java.awt.BorderLayout;
//import javax.swing.JTextField;
//import javax.swing.JLabel;
//import java.awt.Font;
//import javax.swing.SwingConstants;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.ActionEvent;
//
//public class FrogPizzaMain {
//
//	private JFrame frame;
//	private JTextField textId;
//	private JLabel labelTitleLogo;
//	private JPasswordField textPassword;
//	private JLabel labelPassword;
//	private JButton btnLogin;
//	private JLabel labelId;
//	private JPanel login;
//	private JButton btnIdPasswordFind;
//	private JCheckBox chckbxAutoLogin;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrogPizzaMain window = new FrogPizzaMain();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public FrogPizzaMain() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		
//		frame = new JFrame();
//		
//		frame.setTitle("개구리 피자집"); //창 타이틀 문구
//		
//		frame.setBounds(100, 100, 350, 350);
//		
//		frame.setLocationRelativeTo(null);//창을화면 중앙에 띄움
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		login = new JPanel();
//		login.setBounds(0, 0, 350, 350);
//		frame.getContentPane().add(login);
//		login.setLayout(null);
//		
//		textId = new JTextField();
//		textId.setFont(new Font("굴림", Font.PLAIN, 20));
//		//id 입력하는 텍스트 필드 글자 수 제한 -12글자로
//		//오라클 DB에 ID컬럼 데이터 타입 varchar2(15)로 해놓아서 제한을 해두어야 함.
//		textId.addKeyListener(new KeyAdapter() { 
//			public void keyTyped(KeyEvent ke) {
//				JTextField src = (JTextField) ke.getSource();
//						if(src.getText().length() >= 12) ke.consume();
//			} 
//		});
//		
//		textId.setHorizontalAlignment(SwingConstants.LEFT);
//		textId.setBounds(150, 96, 150, 40);
//		login.add(textId);
//		textId.setColumns(10);
//		
//		labelId = new JLabel("아이디");
//		labelId.setHorizontalAlignment(SwingConstants.LEFT);
//		labelId.setFont(new Font("돋움", Font.PLAIN, 20));
//		labelId.setBounds(28, 96, 110, 40);
//		login.add(labelId);
//		
//		labelTitleLogo = new JLabel("Frog Pizza");
//		labelTitleLogo.setHorizontalAlignment(SwingConstants.CENTER);
//		labelTitleLogo.setFont(new Font("굴림", Font.BOLD, 40));
//		labelTitleLogo.setBounds(28, 10, 275, 81);
//		login.add(labelTitleLogo);
//		
//		textPassword = new JPasswordField();
//		textPassword.setFont(new Font("굴림", Font.PLAIN, 20));
//		//비밀번호 입력하는 텍스트 필드 글자 수 제한 -13글자로
//		//오라클 DB에 ID컬럼 데이터 타입 varchar2(15)로 해놓아서 제한을 해두어야 함.
//		textPassword.addKeyListener(new KeyAdapter() { 
//			public void keyTyped(KeyEvent ke) {
//				JTextField src = (JTextField) ke.getSource();
//						if(src.getText().length() >= 13) ke.consume();
//			} 
//		});
//		
//		textPassword.setHorizontalAlignment(SwingConstants.LEFT);
//		textPassword.setColumns(10);
//		textPassword.setBounds(150, 152, 150, 40);
//		login.add(textPassword);
//		
//		labelPassword = new JLabel("비밀번호");
//		labelPassword.setHorizontalAlignment(SwingConstants.LEFT);
//		labelPassword.setFont(new Font("돋움", Font.PLAIN, 20));
//		labelPassword.setBounds(28, 152, 110, 40);
//		login.add(labelPassword);
//		
//		btnLogin = new JButton("로그인");
//		btnLogin.setFont(new Font("돋움", Font.PLAIN, 15));
//		btnLogin.setBounds(203, 218, 100, 30);
//		login.add(btnLogin);
//		
//		JButton btnJoinMembership = new JButton("회원가입");
//		//회원가입 버튼 클릭시 실행 코드
//		btnJoinMembership.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				FrogPizzaJoinMembership.showFrogPizzaJoinMembership();
//			}
//		});
//		btnJoinMembership.setFont(new Font("돋움", Font.PLAIN, 15));
//		btnJoinMembership.setBounds(203, 255, 100, 30);
//		login.add(btnJoinMembership);
//		
//		btnIdPasswordFind = new JButton("아이디, \r\n비밀번호 찾기");
//		btnIdPasswordFind.setFont(new Font("돋움체", Font.PLAIN, 11));
//		btnIdPasswordFind.setBounds(28, 260, 156, 23);
//		login.add(btnIdPasswordFind);
//		
//		chckbxAutoLogin = new JCheckBox(" 자동 로그인");
//		chckbxAutoLogin.setFont(new Font("돋움", Font.PLAIN, 15));
//		chckbxAutoLogin.setHorizontalAlignment(SwingConstants.LEFT);
//		chckbxAutoLogin.setBounds(28, 222, 115, 23);
//		login.add(chckbxAutoLogin);
//	}
//}