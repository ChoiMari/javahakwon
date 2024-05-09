package com.itwill.project01.view;

import static com.itwill.project01.model.Membership.Member.COL_EMAIL;
import static com.itwill.project01.model.Membership.Member.COL_ID;
import static com.itwill.project01.model.Membership.Member.COL_JOIN_DATE;
import static com.itwill.project01.model.Membership.Member.COL_NAME;
import static com.itwill.project01.model.Membership.Member.COL_PASSWORD;
import static com.itwill.project01.model.Membership.Member.COL_PHONE_NUMBER;
import static com.itwill.project01.view.OracleJdbc2.PASSWORD;
import static com.itwill.project01.view.OracleJdbc2.URL;
import static com.itwill.project01.view.OracleJdbc2.USER;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.project01.model.Membership;

import oracle.jdbc.OracleDriver;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrogPizzaIdPasswordFind extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNameFind;
	private JTextField textFindEmail;
	private JButton btnFindId;
	private JButton btnFindPassword;
	private JTextField textFindPhone;
	private JPanel panelFindId;
	private JPanel panelFindPassword;
	private JTextField textFindId2;
	private JTextField textFindName2;
	private JTextField textFindPhone2;
	private JTextField textFindEmail2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnFindPassword2;
	private JButton btnFindId2;

	/**
	 * Launch the application.
	 */
	public static void showFrogPizzaIdPasswordFind() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrogPizzaIdPasswordFind frame = new FrogPizzaIdPasswordFind();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public FrogPizzaIdPasswordFind() {
		initialize();
	}
	
	private void initialize() {
		
		setTitle("찾기 찾기");
		//창 아이콘
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/project01/image/아이콘.png"));
		//Image img = kit.getImage(".\\image\\아이콘.png");ㄴ
		setIconImage(img);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 294, 333);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelFindPassword = new JPanel();
		panelFindPassword.setVisible(false);
		
		panelFindId = new JPanel();
		panelFindId.setBounds(0, 0, 278, 294);
		contentPane.add(panelFindId);
		panelFindId.setLayout(null);
		
		btnFindPassword = new JButton("");
		btnFindPassword.setContentAreaFilled(false);
		btnFindPassword.setBorderPainted(false);
		btnFindPassword.setFocusPainted(false);
		btnFindPassword.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/비밀번호찾기버튼.png")));
		//(new ImageIcon(".\\image\\비밀번호찾기버튼.png"));
		btnFindPassword.setBounds(23, 243, 109, 23);
		panelFindId.add(btnFindPassword);
		
		btnFindId = new JButton("");
		btnFindId.setBorderPainted(false);
		btnFindId.setFocusPainted(false);
		btnFindId.setContentAreaFilled(false);
		btnFindId.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/아이디찾기버튼.png")));
		//(new ImageIcon(".\\image\\아이디찾기버튼.png"));
		btnFindId.setBounds(153, 243, 97, 23);
		panelFindId.add(btnFindId);
		
		textFindEmail = new JTextField();
		textFindEmail.setFont(new Font("굴림", Font.PLAIN, 15));
		textFindEmail.setBounds(113, 176, 141, 34);
		panelFindId.add(textFindEmail);
		textFindEmail.setColumns(10);
		
		textFindPhone = new JTextField();
		textFindPhone.setFont(new Font("굴림", Font.PLAIN, 15));
		textFindPhone.setBounds(113, 129, 141, 34);
		panelFindId.add(textFindPhone);
		textFindPhone.setColumns(10);
		
		textNameFind = new JTextField();
		textNameFind.setFont(new Font("굴림", Font.PLAIN, 15));
		textNameFind.setBounds(113, 83, 141, 34);
		panelFindId.add(textNameFind);
		textNameFind.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/아이디찾기배경.png")));
		//(new ImageIcon(".\\image\\아이디찾기배경.png"));
		lblNewLabel.setBounds(0, 0, 278, 294);
		panelFindId.add(lblNewLabel);
		btnFindId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findId();
				
				
			}
		});
		btnFindPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelFindId.setVisible(false);
				panelFindPassword.setVisible(true);
				
			}
		});
		panelFindPassword.setBounds(0, 0, 278, 294);
		contentPane.add(panelFindPassword);
		panelFindPassword.setLayout(null);
		
		textFindId2 = new JTextField();
		textFindId2.setFont(new Font("굴림", Font.PLAIN, 15));
		textFindId2.setBounds(108, 82, 135, 27);
		panelFindPassword.add(textFindId2);
		textFindId2.setColumns(10);
		
		textFindName2 = new JTextField();
		textFindName2.setFont(new Font("굴림", Font.PLAIN, 15));
		textFindName2.setColumns(10);
		textFindName2.setBounds(108, 125, 135, 27);
		panelFindPassword.add(textFindName2);
		
		textFindPhone2 = new JTextField();
		textFindPhone2.setFont(new Font("굴림", Font.PLAIN, 15));
		textFindPhone2.setColumns(10);
		textFindPhone2.setBounds(108, 169, 135, 27);
		panelFindPassword.add(textFindPhone2);
		
		textFindEmail2 = new JTextField();
		textFindEmail2.setFont(new Font("굴림", Font.PLAIN, 15));
		textFindEmail2.setColumns(10);
		textFindEmail2.setBounds(108, 210, 135, 27);
		panelFindPassword.add(textFindEmail2);
		
		btnFindPassword2 = new JButton("");
		btnFindPassword2.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/비밀번호찾기버튼.png")));
		//(new ImageIcon(".\\image\\비밀번호찾기버튼.png"));
		btnFindPassword2.setContentAreaFilled(false);
		btnFindPassword2.setBorderPainted(false);
		btnFindPassword2.setFocusPainted(false);
		
		btnFindPassword2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findPassword();
			}
		});
		btnFindPassword2.setBounds(142, 257, 109, 23);
		panelFindPassword.add(btnFindPassword2);
		
		btnFindId2 = new JButton("");
		btnFindId2.setContentAreaFilled(false);
		btnFindId2.setBorderPainted(false);
		btnFindId2.setFocusPainted(false);
		btnFindId2.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/아이디찾기버튼.png")));
		//(new ImageIcon(".\\image\\아이디찾기버튼.png"));
		btnFindId2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFindPassword.setVisible(false);
				panelFindId.setVisible(true);
			}
		});
		btnFindId2.setBounds(22, 257, 97, 23);
		panelFindPassword.add(btnFindId2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/비밀번호찾기배경.png")));
		//(new ImageIcon(".\\image\\비밀번호찾기배경.png"));
		lblNewLabel_1.setBounds(0, 0, 278, 294);
		panelFindPassword.add(lblNewLabel_1);
	}

	private void findPassword() {
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
                Boolean findResult = textFindId2.getText().equals(member.getId()) &&
                		textFindName2.getText().equals(member.getName()) &&
                		textFindPhone2.getText().equals(member.getPhone()) &&
                		textFindEmail2.getText().equals(member.getEmail());
                if(findResult) {
                	JOptionPane.showMessageDialog(contentPane, "비밀번호는 " + member.getPassword() + "입니다.");
                	dispose();
                	return;
                }
                
      
                }//반복문 끝
               JOptionPane.showMessageDialog(contentPane, "입력 정보한 정보가 없습니다.","입력정보 오류",JOptionPane.ERROR_MESSAGE);

            } 
            
            
             catch (SQLException e) {
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

	private void findId() {
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
                Boolean findResult = textNameFind.getText().equals(member.getName()) &&
                		textFindPhone.getText().equals(member.getPhone()) &&
                		textFindEmail.getText().equals(member.getEmail());
                if(findResult) {
                	JOptionPane.showMessageDialog(contentPane, "아이디는 " + member.getId() + "입니다.");
                	dispose();
                	return;
                }
                
      
                }//반복문 끝
               JOptionPane.showMessageDialog(contentPane, "입력 정보한 정보가 없습니다.","입력정보 오류",JOptionPane.ERROR_MESSAGE);

            } 
            
            
             catch (SQLException e) {
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
}



//package com.itwill.project01.view;
//
//import static com.itwill.project01.model.Membership.Member.COL_EMAIL;
//import static com.itwill.project01.model.Membership.Member.COL_ID;
//import static com.itwill.project01.model.Membership.Member.COL_JOIN_DATE;
//import static com.itwill.project01.model.Membership.Member.COL_NAME;
//import static com.itwill.project01.model.Membership.Member.COL_PASSWORD;
//import static com.itwill.project01.model.Membership.Member.COL_PHONE_NUMBER;
//import static com.itwill.project01.view.OracleJdbc2.PASSWORD;
//import static com.itwill.project01.view.OracleJdbc2.URL;
//import static com.itwill.project01.view.OracleJdbc2.USER;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import com.itwill.project01.model.Membership;
//
//import oracle.jdbc.OracleDriver;
//
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import java.awt.Font;
//import javax.swing.SwingConstants;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.awt.event.ActionEvent;
//
//public class FrogPizzaIdPasswordFind extends JFrame {
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private JTextField textNameFind;
//	private JTextField textFindEmail;
//	private JButton btnFindId;
//	private JButton btnFindPassword;
//	private JLabel lblNameFind;
//	private JTextField textFindPhone;
//	private JLabel lblPhoneFind;
//	private JLabel lblEmailFind;
//	private JPanel panelFindId;
//	private JPanel panelFindPassword;
//	private JTextField textFindId2;
//	private JTextField textFindName2;
//	private JTextField textFindPhone2;
//	private JTextField textFindEmail2;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void showFrogPizzaIdPasswordFind() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrogPizzaIdPasswordFind frame = new FrogPizzaIdPasswordFind();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	
//	public FrogPizzaIdPasswordFind() {
//		initialize();
//	}
//	
//	private void initialize() {
//		
//		setTitle("찾기 찾기");
//		setResizable(false);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 294, 333);
//		contentPane = new JPanel();
//		
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		panelFindId = new JPanel();
//		panelFindId.setBounds(0, 0, 278, 294);
//		contentPane.add(panelFindId);
//		panelFindId.setLayout(null);
//		
//		btnFindPassword = new JButton("비밀번호 찾기");
//		btnFindPassword.setBounds(27, 245, 109, 23);
//		panelFindId.add(btnFindPassword);
//		
//		btnFindId = new JButton("아이디 찾기");
//		btnFindId.setBounds(153, 245, 97, 23);
//		panelFindId.add(btnFindId);
//		
//		lblEmailFind = new JLabel("이메일");
//		lblEmailFind.setBounds(11, 159, 57, 15);
//		panelFindId.add(lblEmailFind);
//		
//		textFindEmail = new JTextField();
//		textFindEmail.setBounds(80, 150, 170, 34);
//		panelFindId.add(textFindEmail);
//		textFindEmail.setColumns(10);
//		
//		textFindPhone = new JTextField();
//		textFindPhone.setBounds(80, 101, 170, 34);
//		panelFindId.add(textFindPhone);
//		textFindPhone.setColumns(10);
//		
//		lblPhoneFind = new JLabel("전화번호");
//		lblPhoneFind.setBounds(11, 110, 57, 15);
//		panelFindId.add(lblPhoneFind);
//		
//		lblNameFind = new JLabel("이름");
//		lblNameFind.setBounds(11, 66, 57, 15);
//		panelFindId.add(lblNameFind);
//		
//		textNameFind = new JTextField();
//		textNameFind.setBounds(80, 57, 170, 34);
//		panelFindId.add(textNameFind);
//		textNameFind.setColumns(10);
//		btnFindId.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				findId();
//				
//				
//			}
//		});
//		btnFindPassword.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				panelFindId.setVisible(false);
//				panelFindPassword.setVisible(true);
//				
//			}
//		});
//		
//		panelFindPassword = new JPanel();
//		panelFindPassword.setVisible(false);
//		panelFindPassword.setBounds(0, 0, 278, 294);
//		contentPane.add(panelFindPassword);
//		panelFindPassword.setLayout(null);
//		
//		JLabel lblFindId2 = new JLabel("아이디");
//		lblFindId2.setBounds(12, 48, 57, 15);
//		panelFindPassword.add(lblFindId2);
//		
//		textFindId2 = new JTextField();
//		textFindId2.setBounds(98, 45, 152, 21);
//		panelFindPassword.add(textFindId2);
//		textFindId2.setColumns(10);
//		
//		textFindName2 = new JTextField();
//		textFindName2.setColumns(10);
//		textFindName2.setBounds(98, 84, 152, 21);
//		panelFindPassword.add(textFindName2);
//		
//		JLabel lblFindName2 = new JLabel("이름");
//		lblFindName2.setBounds(12, 87, 57, 15);
//		panelFindPassword.add(lblFindName2);
//		
//		textFindPhone2 = new JTextField();
//		textFindPhone2.setColumns(10);
//		textFindPhone2.setBounds(98, 126, 152, 21);
//		panelFindPassword.add(textFindPhone2);
//		
//		JLabel lblFindPhone2 = new JLabel("전화번호");
//		lblFindPhone2.setBounds(12, 129, 57, 15);
//		panelFindPassword.add(lblFindPhone2);
//		
//		textFindEmail2 = new JTextField();
//		textFindEmail2.setColumns(10);
//		textFindEmail2.setBounds(98, 166, 152, 21);
//		panelFindPassword.add(textFindEmail2);
//		
//		JLabel lblFindEmail2 = new JLabel("이메일");
//		lblFindEmail2.setBounds(12, 169, 57, 15);
//		panelFindPassword.add(lblFindEmail2);
//		
//		JButton btnFindPassword2 = new JButton("비밀번호 찾기");
//		btnFindPassword2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				findPassword();
//			}
//		});
//		btnFindPassword2.setBounds(141, 241, 109, 23);
//		panelFindPassword.add(btnFindPassword2);
//		
//		JButton btnFindId2 = new JButton("아이디 찾기");
//		btnFindId2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				panelFindPassword.setVisible(false);
//				panelFindId.setVisible(true);
//			}
//		});
//		btnFindId2.setBounds(24, 241, 97, 23);
//		panelFindPassword.add(btnFindId2);
//	}
//
//	private void findPassword() {
//		Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//       
//        try {
//            DriverManager.registerDriver(new OracleDriver());
//           // System.out.println("오라클 드라이버 등록 성공");
//            
//            // 4. 오라클 데이터베이스에 접속(오라클 세션 생성)
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            //System.out.println("오라클 접속 성공");
//            
//            // 5. Statement 타입 객체 생성
//            final String sql = "select * from MEMBERSHIP_TB";
//            //-> Statement 객체에서 사용하는 SQL 문장은 세미콜론(;)을 사용하지 않음!
//            stmt = conn.prepareStatement(sql);
//            
//            // 6-7. SQL 문장 실행 & 결과 처리
//            rs = stmt.executeQuery();
////            if(textJoinId.getText().equals("")) {
////            	JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요");
////            	return;
////            }
//            while (rs.next()) { // ResultSet(테이블)에서 다음 행(row)이 있는 지 검사
//                // 그 행의 컬럼들에 있는 값을 읽음:
//                String id = rs.getString(COL_ID); // 테이블의 ID 컬럼 값을 읽음.
//                String password = rs.getString(COL_PASSWORD); // 테이블의 TITLE 컬럼 값을 읽음.
//                String name = rs.getString(COL_NAME);
//                String email = rs.getString(COL_EMAIL);
//                String phone = rs.getString(COL_PHONE_NUMBER);
//                        
//                LocalDateTime joinDate = rs.getTimestamp(COL_JOIN_DATE)
//                        .toLocalDateTime();
//                
//                Membership member = new Membership(id, password, name, email, phone, joinDate);
//                Boolean findResult = textFindId2.getText().equals(member.getId()) &&
//                		textFindName2.getText().equals(member.getName()) &&
//                		textFindPhone2.getText().equals(member.getPhone()) &&
//                		textFindEmail2.getText().equals(member.getEmail());
//                if(findResult) {
//                	JOptionPane.showMessageDialog(contentPane, "비밀번호는 " + member.getPassword() + "입니다.");
//                	dispose();
//                	return;
//                }
//                
//      
//                }//반복문 끝
//               JOptionPane.showMessageDialog(contentPane, "입력 정보한 정보가 없습니다.","입력정보 오류",JOptionPane.ERROR_MESSAGE);
//
//            } 
//            
//            
//             catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // 리소스 해제
//            try {
//            	rs.close(); // ResultSet 해제.
//                stmt.close();
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//		
//	
//		
//	}
//
//	private void findId() {
//		Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//       
//        try {
//            DriverManager.registerDriver(new OracleDriver());
//           // System.out.println("오라클 드라이버 등록 성공");
//            
//            // 4. 오라클 데이터베이스에 접속(오라클 세션 생성)
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            //System.out.println("오라클 접속 성공");
//            
//            // 5. Statement 타입 객체 생성
//            final String sql = "select * from MEMBERSHIP_TB";
//            //-> Statement 객체에서 사용하는 SQL 문장은 세미콜론(;)을 사용하지 않음!
//            stmt = conn.prepareStatement(sql);
//            
//            // 6-7. SQL 문장 실행 & 결과 처리
//            rs = stmt.executeQuery();
////            if(textJoinId.getText().equals("")) {
////            	JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요");
////            	return;
////            }
//            while (rs.next()) { // ResultSet(테이블)에서 다음 행(row)이 있는 지 검사
//                // 그 행의 컬럼들에 있는 값을 읽음:
//                String id = rs.getString(COL_ID); // 테이블의 ID 컬럼 값을 읽음.
//                String password = rs.getString(COL_PASSWORD); // 테이블의 TITLE 컬럼 값을 읽음.
//                String name = rs.getString(COL_NAME);
//                String email = rs.getString(COL_EMAIL);
//                String phone = rs.getString(COL_PHONE_NUMBER);
//                        
//                LocalDateTime joinDate = rs.getTimestamp(COL_JOIN_DATE)
//                        .toLocalDateTime();
//                
//                Membership member = new Membership(id, password, name, email, phone, joinDate);
//                Boolean findResult = textNameFind.getText().equals(member.getName()) &&
//                		textFindPhone.getText().equals(member.getPhone()) &&
//                		textFindEmail.getText().equals(member.getEmail());
//                if(findResult) {
//                	JOptionPane.showMessageDialog(contentPane, "아이디는 " + member.getId() + "입니다.");
//                	dispose();
//                	return;
//                }
//                
//      
//                }//반복문 끝
//               JOptionPane.showMessageDialog(contentPane, "입력 정보한 정보가 없습니다.","입력정보 오류",JOptionPane.ERROR_MESSAGE);
//
//            } 
//            
//            
//             catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // 리소스 해제
//            try {
//            	rs.close(); // ResultSet 해제.
//                stmt.close();
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//		
//	}
//}