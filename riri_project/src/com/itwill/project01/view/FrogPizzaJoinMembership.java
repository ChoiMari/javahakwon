package com.itwill.project01.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import com.itwill.project01.controller.MemberDao;
import com.itwill.project01.model.Membership;

import oracle.jdbc.OracleDriver;

import static com.itwill.project01.view.OracleJdbc2.*;
import static com.itwill.project01.model.Membership.Member.*;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class FrogPizzaJoinMembership extends JFrame {

	//컨트롤러 - MemberDao클래스 객체 생성.(싱글턴으로 만든) 
	private MemberDao memberdao = MemberDao.getInstance();
	
	//중복 체크 결과 필드선언
	private boolean overlapId;
	private boolean overlapEmail;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelJoinMembership;
	private JPanel panelTermsConditions;
	private JTextField textJoinId;
	
	private JPasswordField textJoinPassword;
	private JTextField textJoinName;
	
	//private JFormattedTextField textJoinPhone;
	private JTextField textJoinPhone;
	private JTextField textJoinEmail;
	private JButton btnJoinCompletion;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNextButton;
	private JButton btnIdCheck;
	private JButton btnPreviousScreen;
	private JCheckBox chckbxDuplicateCheck;
	private JLabel lblNewLabel_2;
	private JCheckBox chckbxConsent;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	

	/**
	 * Launch the application.
	 */
	public static void showFrogPizzaJoinMembership () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrogPizzaJoinMembership frame = new FrogPizzaJoinMembership();
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
	public FrogPizzaJoinMembership() {
		initialize();
	}
	
	
	
	public void initialize () {
		setTitle("Frog Pizza 회원 가입"); //창 타이틀 문구
		//창 아이콘
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/project01/image/아이콘.png"));
				//getImage(".\\image\\아이콘.png");
		setIconImage(img);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //창의 x눌러도 현재 창만 닫게 설정함.
		
		setBounds(100, 100, 320, 413);
		setLocationRelativeTo(null);
		contentPane = new JPanel();	
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelJoinMembership = new JPanel();
		
		panelJoinMembership.setVisible(false);
		
		panelTermsConditions = new JPanel();
		panelTermsConditions.setVisible(true);
		panelTermsConditions.setBounds(0, 0, 306, 374);
		contentPane.add(panelTermsConditions);
		panelTermsConditions.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개인정보 동의서.png")));
		//(new ImageIcon(".\\image\\개인정보 동의서.png"));
		lblNewLabel.setBounds(32, 56, 220, 40);
		panelTermsConditions.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/이용약관문구.png")));
		//(new ImageIcon(".\\image\\이용약관문구.png"));
		lblNewLabel_1.setBounds(32, 21, 220, 40);
		panelTermsConditions.add(lblNewLabel_1);
		
		btnNextButton = new JButton("");
		btnNextButton.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/다음버튼.png")));
		//(new ImageIcon(".\\image\\다음버튼.png"));
		btnNextButton.setVisible(false);
		btnNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTermsConditions.setVisible(false);
				panelJoinMembership.setVisible(true);
			}
		});
		btnNextButton.setBounds(155, 286, 97, 40);
		panelTermsConditions.add(btnNextButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 104, 244, 120);
		panelTermsConditions.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("궁서체", Font.BOLD, 18));
		textArea.setText("\n(주의)\n 개인정보가 \n 굉장히 취약한 \n 프로그램 입니다 \n ...");
		scrollPane.setViewportView(textArea);
		
		chckbxConsent = new JCheckBox("동의 하시겠습니까? ");
		chckbxConsent.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		chckbxConsent.setContentAreaFilled(false);
		chckbxConsent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//체크박스 클릭시 실행 되는 코드
				btnNextButton.setVisible(true);
			}
		});
		
		chckbxConsent.setBounds(36, 237, 193, 23);
		panelTermsConditions.add(chckbxConsent);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/동의체크배경.png")));
		//(new ImageIcon(".\\image\\동의체크배경.png"));
		lblNewLabel_3.setBounds(32, 234, 190, 30);
		panelTermsConditions.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/이용약관배경.png")));
		//(new ImageIcon(".\\image\\이용약관배경.png"));
		lblNewLabel_2.setBounds(0, 0, 306, 374);
		panelTermsConditions.add(lblNewLabel_2);
		
		panelJoinMembership.setBounds(0, 0, 306, 374);
		contentPane.add(panelJoinMembership);
		panelJoinMembership.setLayout(null);
		
		textJoinId = new JTextField();
		//id 텍스트 필드 글자 수 제한 12글자로. 12글자 넘어가면 더이상 안 써지게 설정함.
		textJoinId.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
						if(src.getText().length() >= 12) {
							ke.consume();
						}
						
			} 
		});
		
		textJoinId.setColumns(10);
		textJoinId.setBounds(109, 94, 106, 30);
		panelJoinMembership.add(textJoinId);
		
		textJoinPassword = new JPasswordField();
		//가입 할 때 비밀번호 입력하는 텍스트 필드 글자 수 제한 -13글자로.그 이상은 안써지게 설정함.
		//오라클 DB에 ID컬럼 데이터 타입 varchar2(15)로 해놓아서 제한을 해두어야 함.
		textJoinPassword.addKeyListener(new KeyAdapter() { 
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
						if(src.getText().length() >= 13) ke.consume();
			} 
		});
		
		textJoinPassword.setColumns(10);
		textJoinPassword.setBounds(109, 143, 140, 30);
		panelJoinMembership.add(textJoinPassword);
		
		textJoinName = new JTextField();
		//가입 할 때 이름 입력하는 텍스트 필드 글자 수 제한 - 6글자로. 한글은 한 글자에 3바이트라서..7글자까지만 가능.
		//오라클 DB에 NAME 컬럼 데이터 타입 varchar2(21)로 해놓아서 제한을 해두어야 함.
		textJoinName.addKeyListener(new KeyAdapter() { 
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
						if(src.getText().length() >= 6) ke.consume();
			} 
		});
		
		textJoinName.setColumns(10);
		textJoinName.setBounds(109, 190, 140, 30);
		panelJoinMembership.add(textJoinName);
		
		

		
		//숫자가 아닌 값을 입력하면 사라짐.
		//textJoinPhone = new JFormattedTextField(new NumberFormatter());
		textJoinPhone = new JTextField();
		//JTextField tf = new JTextField();
		
		
		
		//TODO : 전화번호 필드에 숫자만 입력받기

		//textJoinPhone = new JTextField();
		//가입 할 때 전화번호 입력하는 텍스트 필드 글자 수 제한 - 11글자 이상 입력 안되게 설정
		//오라클 DB에 NAME 컬럼 데이터 타입 varchar2(25)로 해놓아서 제한을 해두어야 함.
		
		textJoinPhone.addKeyListener(new KeyAdapter() { 
			public void keyTyped(KeyEvent ke) { //public void keyReleased(KeyEvent ke)
				
				JTextField src = (JTextField) ke.getSource();
					if(src.getText().length() >= 11) {
						ke.consume();
					}
					
//					boolean result = textJoinPhone.getText().contains("-");
//					if(result) {
//						JOptionPane.showMessageDialog(panelJoinMembership,
//								"-를 뺀 숫자만 입력해 주세요."
//								);
//						textJoinPhone.setText("");
//					}

//					if (memberdao.isIntegerNumeric(textJoinPhone.getText()) == false) {
//						textJoinPhone.setText("");
//						JOptionPane.showMessageDialog(									
//								panelJoinMembership,
//								"-를 뺀 숫자만 입력하세요.",
//								"입력 오류",
//								JOptionPane.CANCEL_OPTION);
//					}	
//					if (memberdao.isIntegerNumeric(textJoinPhone.getText()) == false) {
//						  textJoinPhone.setText("");
//							JOptionPane.showMessageDialog(panelJoinMembership,
//							"-를 뺀 숫자만 입력해 주세요.");
//						  }
			} 

			@Override
			public void keyPressed(KeyEvent e) {
				boolean resultHypen = textJoinPhone.getText().contains("-");
				if(resultHypen) {
					JOptionPane.showMessageDialog(panelJoinMembership,
							"-를 뺀 숫자만 입력해 주세요."
							);
					textJoinPhone.setText("");
			}
				boolean resultSting = memberdao.isIntegerNumeric(textJoinPhone.getText());
				
				if (resultSting == false) {
					if(e.getKeyCode() != KeyEvent.VK_ENTER) {
					textJoinPhone.setText("");
					}
					
				}
				
//					  textJoinPhone.setText("");
				}
		});
		

		
		
//			String hypen = "-";
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(textJoinPhone.equals(hypen)) {
//					textJoinPhone.setText("");
//				JOptionPane.showMessageDialog(panelJoinMembership,
//						"-를 뺀 숫자만 입력해 주세요.");
//				}
//			}
		

//		@Override
//		public void keyPressed(KeyEvent e) {
//			if (memberdao.isIntegerNumeric(textJoinPhone.getText()) == false) {
//			  textJoinPhone.setText("");
//				JOptionPane.showMessageDialog(panelJoinMembership,
//				"-를 뺀 숫자만 입력해 주세요.");
//			  }
//			
//		}

		
		
		textJoinPhone.setColumns(10);
		textJoinPhone.setBounds(109, 240, 140, 30);
		panelJoinMembership.add(textJoinPhone);
		
		textJoinEmail = new JTextField();
		//이메일 30글자수로 제한해둠.
		textJoinEmail.addKeyListener(new KeyAdapter() { 
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
					if(src.getText().length() >= 30) {
						ke.consume();
					}
					
//					//boolean result = textJoinEmail.getText().contains("@");
//					if(textJoinEmail.getText().contains("@") == false) {
//						JOptionPane.showMessageDialog(
//								panelJoinMembership,
//								"@를 넣은 형식으로 입력해주세요");
//								textJoinPhone.setText("");
//					}
				}
		});
		
				
				textJoinEmail.setColumns(10);
				textJoinEmail.setBounds(109, 288, 140, 30);
				panelJoinMembership.add(textJoinEmail);
				
				btnJoinCompletion = new JButton("");
				btnJoinCompletion.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/가입완료버튼.png")));
				//(new ImageIcon(".\\image\\가입완료버튼.png"));
				btnJoinCompletion.setContentAreaFilled(false);
				btnJoinCompletion.setBorderPainted(false);
				btnJoinCompletion.setFocusPainted(false);
				
				//회원 가입 완료 버튼 클릭시 실행 되는 코드
				btnJoinCompletion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//				 String gettextJoinPassword = new String(textJoinPassword.getPassword());
//				 System.out.println(gettextJoinPassword);
						
						overlapId = false;
						overlapEmail = false;
						
//						if(chckbxDuplicateCheck.isSelected() == false) {//중복체크 버튼을 안눌렀으면 실행되는 코드.
//							JOptionPane.showMessageDialog(panelJoinMembership,"아이디 중복체크버튼을 클릭하세요");
//							return;
//						}
//						idIdCheck(); if(overlapId) {return;} //아이디 중복 확인
//						emailEmailCheck(); if(overlapEmail) {return;} //이메일 중복 확인
						
						if(joinCheck()) {
//							idIdCheck(); if(overlapId) {return;} //아이디 중복 확인
							
							if(chckbxDuplicateCheck.isSelected() == false) {//중복체크 버튼을 안눌렀으면 실행되는 코드.
							JOptionPane.showMessageDialog(panelJoinMembership,"아이디 중복체크버튼을 클릭하세요");
							return;
						}
							idIdCheck(); if(overlapId) {return;} //아이디 중복 확인
						    emailEmailCheck(); if(overlapEmail) {return;} //이메일 중복 확인
//				            if(textJoinEmail.getText().equals("")) {
//				            	JOptionPane.showMessageDialog(panelJoinMembership, "이메일을 입력하세요.");
//				            	return;
//				            }
							join();//데이터베이스에 저장
							JOptionPane.showMessageDialog(panelJoinMembership, "회원 가입이 되었습니다.");
							dispose();//창닫기
						}
						//joinMembershipCheck();
//						join();
						//dispose();
						
					}
				});
				
				
				
				btnJoinCompletion.setBounds(162, 333, 97, 23);
				panelJoinMembership.add(btnJoinCompletion);
				
				btnIdCheck = new JButton("");
				btnIdCheck.setContentAreaFilled(false);
				btnIdCheck.setBorderPainted(false);
				btnIdCheck.setFocusPainted(false);
				
				btnIdCheck.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/중복체크.png")));
				//(new ImageIcon(".\\image\\중복체크.png"));
				btnIdCheck.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						idCheck();
						
					}
				});
				btnIdCheck.setFont(new Font("굴림", Font.PLAIN, 10));
				btnIdCheck.setBounds(225, 94, 55, 30);
				panelJoinMembership.add(btnIdCheck);
				
				btnPreviousScreen = new JButton("");
				btnPreviousScreen.setContentAreaFilled(false);
				btnPreviousScreen.setBorderPainted(false);
				btnPreviousScreen.setFocusPainted(false);
				
				btnPreviousScreen.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/이전화면버튼.png")));
				//(new ImageIcon(".\\image\\이전화면버튼.png"));
				btnPreviousScreen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelJoinMembership.setVisible(false);
						panelTermsConditions.setVisible(true);
					}
				});
				btnPreviousScreen.setBounds(39, 333, 95, 23);
				panelJoinMembership.add(btnPreviousScreen);
				
				chckbxDuplicateCheck = new JCheckBox("");
				chckbxDuplicateCheck.setContentAreaFilled(false);
				chckbxDuplicateCheck.setVisible(false);
				chckbxDuplicateCheck.setBounds(235, 100, 42, 23);
				panelJoinMembership.add(chckbxDuplicateCheck);
				
				lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/회원가입배경.png")));
				//(new ImageIcon(".\\image\\회원가입배경.png"));
				lblNewLabel_4.setBounds(0, 0, 306, 374);
				panelJoinMembership.add(lblNewLabel_4);
	}
	
	
	
	private void emailEmailCheck() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		overlapEmail = false;
		try {
        DriverManager.registerDriver(new OracleDriver());
       // System.out.println("오라클 드라이버 등록 성공");
        
        // 4. 오라클 데이터베이스에 접속(오라클 세션 생성)
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
       // System.out.println("오라클 접속 성공");
        
        // 5. Statement 타입 객체 생성
        final String sql = "select * from MEMBERSHIP_TB";
        //-> Statement 객체에서 사용하는 SQL 문장은 세미콜론(;)을 사용하지 않음!
        stmt = conn.prepareStatement(sql);
        
        // 6-7. SQL 문장 실행 & 결과 처리
        rs = stmt.executeQuery();
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
            boolean emailCheck = member.getEmail().equals(textJoinEmail.getText());
            //System.out.println(idCheck);
            if(emailCheck == true) {
            	JOptionPane.showMessageDialog(panelJoinMembership, "중복된 이메일이 있습니다.");
            	textJoinEmail.setText("");
            	overlapEmail = true;
            	return;
            }
            


        } 
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
    
//        if(overlapEmail) {
//        	JOptionPane.showMessageDialog(panelJoinMembership, "중복된 이메일이 있습니다.");
//        	textJoinId.setText("");
//        	return;
//        }
		
	}

//	private void joinMembershipCheck() {
//		int checkResult = joinCheck();
//		switch(checkResult){
//		case 0 :
//			join();
//			JOptionPane.showMessageDialog(panelJoinMembership, "가입이 완료되었습니다.");
//			dispose();
//			break;
//			case 1 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요.");
//				break;
//			case 2 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "비빌번호를 입력하세요.");
//				break;
//			case 3 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "이름를 입력하세요.");
//				break;
//			case 4 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "전화번호를 입력하세요.");
//				break;
//			case 5 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "이메일을 입력하세요.");
//				break;
//			case 6 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "@를 포함한 형식으로 email을 작성해주세요.");
//				textJoinEmail.setText("");
//				break;
//				
//		}
//		
//	}

	/**
	 * 빈칸 체크
	 * @return 빈칸이면 false 리턴.이메일 입력 텍스트 필드에 @가 포함안돼있어도 false. 빈칸이 아니면 true리턴. 
	 */
	private boolean joinCheck() {
	
	boolean result = false;	
	boolean idNullCheck = textJoinId.getText().equals("");
	boolean passwordNullCheck = new String(textJoinPassword.getPassword()).equals("");
	boolean nameNullCheck = textJoinName.getText().equals("");
	boolean phoneNullCheck = textJoinPhone.getText().equals("");
	boolean emailNullCheck = textJoinEmail.getText().equals("");
	boolean atCheck = textJoinEmail.getText().contains("@");
	
	if(idNullCheck) {
		JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요.");
		
		return result;
		
	}
	if(passwordNullCheck) {
		JOptionPane.showMessageDialog(panelJoinMembership, "비빌번호를 입력하세요.");
		return result;
		
	}
	if(nameNullCheck) {
		JOptionPane.showMessageDialog(panelJoinMembership, "이름를 입력하세요.");
		return result;
	}
	if(phoneNullCheck) {
		JOptionPane.showMessageDialog(panelJoinMembership, "전화번호를 입력하세요.");
		return result;
	}
	if(emailNullCheck) {
		JOptionPane.showMessageDialog(panelJoinMembership, "이메일을 입력하세요.");
		return result;
	}
	if(atCheck == false) {
		JOptionPane.showMessageDialog(panelJoinMembership, "@를 포함한 형식으로 email을 작성해주세요.");
		textJoinEmail.setText("");
		return result;
	}
	
	result = true;
	return result;
	
}
	
	
	
	
//	private int joinCheck() {
//		
//		boolean idNullCheck = textJoinId.getText().equals("");
//		boolean passwordNullCheck = new String(textJoinPassword.getPassword()).equals("");
//		boolean nameNullCheck = textJoinName.getText().equals("");
//		boolean phoneNullCheck = textJoinPhone.getText().equals("");
//		boolean emailNullCheck = textJoinEmail.getText().equals("");
//		boolean atCheck = textJoinEmail.getText().contains("@");
//		
//		if(idNullCheck) {
//			return 1;
//			//JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요.");
//		}
//		if(passwordNullCheck) {
//			return 2;
//			//JOptionPane.showMessageDialog(panelJoinMembership, "비빌번호를 입력하세요.");
//		}
//		if(nameNullCheck) {
//			return 3;
//		}
//		if(phoneNullCheck) {
//			return 4;
//		}
//		if(emailNullCheck) {
//			return 5;
//		}
//		if(atCheck == false) {
//			//JOptionPane.showMessageDialog(panelJoinMembership, "@를 포함한 형식으로 email을 작성해주세요.");
//			//textJoinEmail.setText("");
//			return 6;
//		}
//		return 0;
//		
//	}

	//중복확인 버튼 클릭시 호출되는 메서드
	/**
	 * 중복확인 버튼 클릭시 호출되는 메서드
	 */
	private void idCheck() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        overlapId = false; 
        chckbxDuplicateCheck.setSelected(false);
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
            if(textJoinId.getText().equals("")) {
            	JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요");
            	return;
            }
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
                boolean idCheck = member.getId().equals(textJoinId.getText());
                //System.out.println(idCheck);
                if(idCheck == true) {
                	JOptionPane.showMessageDialog(panelJoinMembership, "중복된 아이디가 있습니다.");
                	textJoinId.setText("");
                	overlapId = true;
                	return;
                } 
            } 
            //반복문에서 중복 아이디 없으면 실행 되는 코드
            JOptionPane.showMessageDialog(panelJoinMembership, "사용 가능한 아이디 입니다.","사용 가능",JOptionPane.PLAIN_MESSAGE);
            chckbxDuplicateCheck.setSelected(true);
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
	 * 가입완료 버튼 클릭시 아이디 중복확인
	 */
	private void idIdCheck() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        overlapId = false;
        try {
            DriverManager.registerDriver(new OracleDriver());
            //System.out.println("오라클 드라이버 등록 성공");
            
            // 4. 오라클 데이터베이스에 접속(오라클 세션 생성)
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
           // System.out.println("오라클 접속 성공");
            
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
                
                boolean idCheck = member.getId().equals(textJoinId.getText());//중복 검사
                //System.out.println(idCheck);
                if(idCheck == true) {//아이디를 입력하는 텍스트 필드에 데이터베이스에 저장된 id행과 같은 중복데이터가 있으면 실행
                	JOptionPane.showMessageDialog(panelJoinMembership, "중복된 아이디가 있습니다.");
                	textJoinId.setText("");//빈칸으로 지워줌
                	overlapId = true;
                	return;
                }

            } 
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
	
	
	
	
	
	
	// 가입완료 버튼 클릭시 호출되는 메서드 -> 오라클 DB MEMBERSHIP_TB 테이블에 텍스트필드에 저장한 입력값을 읽어서 저장시킴.
	private void join() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 오라클 드라이버(라이브러리) 등록
            DriverManager.registerDriver(new OracleDriver());
            
            // 오라클 DB 접속
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            final String sql = String.format(
                    "insert into %s (%s, %s, %s, %s, %s) values (?, ?, ?, ?, ?)", 
                    TBL_MEMBERSHIP, COL_ID, COL_PASSWORD, COL_NAME, COL_EMAIL, COL_PHONE_NUMBER);
            
          
            stmt = conn.prepareStatement(sql);
            
            //비밀번호 텍스트 필드에 입력한 값 - 문자열로 변환 해서 저장.
           String gettextJoinPassword = new String(textJoinPassword.getPassword());
            
            // PreparedStatement 객체의 SQL에서 ? 부분을 입력받은 내용으로 채움.
            stmt.setString(1,textJoinId.getText()); // 첫번째 ?에 textJoinId.getText() 변수의 값을 문자열로 채움.
            stmt.setString(2, gettextJoinPassword);
            stmt.setString(3, textJoinName.getText());
            stmt.setString(4, textJoinEmail.getText());
            stmt.setString(5, textJoinPhone.getText());
            
            // SQL 문장을 DB로 보내서 실행 & 결과 처리
            int result = stmt.executeUpdate();
           // System.out.println(result + "개 행이 삽입됨.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
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
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//
//import javax.swing.JButton;
//import javax.swing.JFormattedTextField;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.border.EmptyBorder;
//import javax.swing.text.NumberFormatter;
//
//import com.itwill.project01.controller.MemberDao;
//import com.itwill.project01.model.Membership;
//
//import oracle.jdbc.OracleDriver;
//
//import static com.itwill.project01.view.OracleJdbc2.*;
//import static com.itwill.project01.model.Membership.Member.*;
//import javax.swing.JCheckBox;
//
//public class FrogPizzaJoinMembership extends JFrame {
//
//	//컨트롤러 - MemberDao클래스 객체 생성.(싱글턴으로 만든) 
//	private MemberDao memberdao = MemberDao.getInstance();
//	private boolean overlapId;
//	private boolean overlapEmail;
//	
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private JPanel panelJoinMembership;
//	private JPanel panelTermsConditions;
//	private JLabel labelJoinId;
//	private JTextField textJoinId;
//	private JLabel labelJoinMembershipLogo;
//	
//	private JPasswordField textJoinPassword;
//	
//	private JLabel labeJoinPassword;
//	private JTextField textJoinName;
//	private JLabel labelJoinName;
//	
//	private JFormattedTextField textJoinPhone;
//	//private JTextField textJoinPhone;
//	//private String getTextPhone = textJoinPhone.getText();
//	
//	private JLabel labelJoinPhone;
//	private JTextField textJoinEmail;
//	private JLabel labelJoinEmail;
//	private JButton btnJoinCompletion;
//	private JLabel lblNewLabel;
//	private JLabel lblNewLabel_1;
//	private JButton btnNewButton;
//	private JButton btnIdCheck;
//	private JButton btnPreviousScreen;
//	private JCheckBox chckbxDuplicateCheck;
//	
//	
//
//	/**
//	 * Launch the application.
//	 */
//	public static void showFrogPizzaJoinMembership () {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrogPizzaJoinMembership frame = new FrogPizzaJoinMembership();
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
//	public FrogPizzaJoinMembership() {
//		initialize();
//	}
//	
//	
//	
//	public void initialize () {
//		setTitle("Frog Pizza 회원 가입"); //창 타이틀 문구
//		
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //창의 x눌러도 현재 창만 닫게 설정함.
//		
//		setBounds(100, 100, 320, 413);
//		contentPane = new JPanel();	
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		panelTermsConditions = new JPanel();
//		panelTermsConditions.setVisible(true);
//		
//		panelJoinMembership = new JPanel();
//		
//		panelJoinMembership.setVisible(false);
//		
//		panelJoinMembership.setBounds(0, 0, 306, 374);
//		contentPane.add(panelJoinMembership);
//		panelJoinMembership.setLayout(null);
//		
//		labelJoinId = new JLabel("아이디");
//		labelJoinId.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//		labelJoinId.setBounds(34, 79, 80, 35);
//		panelJoinMembership.add(labelJoinId);
//		
//		textJoinId = new JTextField();
//		//id 텍스트 필드 글자 수 제한 12글자로. 12글자 넘어가면 더이상 안 써지게 설정함.
//		textJoinId.addKeyListener(new KeyAdapter() {
//			public void keyTyped(KeyEvent ke) {
//				JTextField src = (JTextField) ke.getSource();
//						if(src.getText().length() >= 12) {
//							ke.consume();
//						}
//						
////						switch(memberdao.idFormat(textJoinId.getText())) {
////						case 1 :
////							JOptionPane.showMessageDialog(
////									panelJoinMembership,
////									"아이디는 4 ~ 12자 이내의 아이디만 가능합니다.");
////							break;
////						}
//			} 
//		});
//		
//		textJoinId.setColumns(10);
//		textJoinId.setBounds(100, 85, 106, 30);
//		panelJoinMembership.add(textJoinId);
//		
//		labelJoinMembershipLogo = new JLabel("회원 가입");
//		labelJoinMembershipLogo.setHorizontalAlignment(SwingConstants.CENTER);
//		labelJoinMembershipLogo.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
//		labelJoinMembershipLogo.setBounds(54, 24, 173, 33);
//		panelJoinMembership.add(labelJoinMembershipLogo);
//		
//		textJoinPassword = new JPasswordField();
//		//가입 할 때 비밀번호 입력하는 텍스트 필드 글자 수 제한 -13글자로
//		//오라클 DB에 ID컬럼 데이터 타입 varchar2(15)로 해놓아서 제한을 해두어야 함.
//		textJoinPassword.addKeyListener(new KeyAdapter() { 
//			public void keyTyped(KeyEvent ke) {
//				JTextField src = (JTextField) ke.getSource();
//						if(src.getText().length() >= 13) ke.consume();
//			} 
//		});
//		
//		textJoinPassword.setColumns(10);
//		textJoinPassword.setBounds(100, 134, 140, 30);
//		panelJoinMembership.add(textJoinPassword);
//		
//		labeJoinPassword = new JLabel("비밀번호");
//		labeJoinPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//		labeJoinPassword.setBounds(25, 129, 80, 35);
//		panelJoinMembership.add(labeJoinPassword);
//		
//		textJoinName = new JTextField();
//		//가입 할 때 이름 입력하는 텍스트 필드 글자 수 제한 - 6글자로. 한글은 한 글자에 3바이트라서..7글자까지만 가능.
//		//오라클 DB에 NAME 컬럼 데이터 타입 varchar2(21)로 해놓아서 제한을 해두어야 함.
//		textJoinName.addKeyListener(new KeyAdapter() { 
//			public void keyTyped(KeyEvent ke) {
//				JTextField src = (JTextField) ke.getSource();
//						if(src.getText().length() >= 6) ke.consume();
//			} 
//		});
//		
//		textJoinName.setColumns(10);
//		textJoinName.setBounds(100, 181, 140, 30);
//		panelJoinMembership.add(textJoinName);
//		
//		labelJoinName = new JLabel("이름");
//		labelJoinName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//		labelJoinName.setBounds(35, 177, 80, 35);
//		panelJoinMembership.add(labelJoinName);
//		
//		
//
//		
//		//숫자가 아닌 값을 입력하면 사라짐.
//		textJoinPhone = new JFormattedTextField(new NumberFormatter());
//		//JTextField tf = new JTextField();
//		
//		
//		
//		//TODO : 전화번호 필드에 숫자만 입력받기
//
//		//textJoinPhone = new JTextField();
//		//가입 할 때 전화번호 입력하는 텍스트 필드 글자 수 제한 - 11글자 이상 입력 안되게 설정
//		//오라클 DB에 NAME 컬럼 데이터 타입 varchar2(25)로 해놓아서 제한을 해두어야 함.
//		
//		textJoinPhone.addKeyListener(new KeyAdapter() { 
//			public void keyTyped(KeyEvent ke) { //public void keyReleased(KeyEvent ke)
//				
//				JTextField src = (JTextField) ke.getSource();
//					if(src.getText().length() >= 11) {
//						ke.consume();
//					}
//					
////					boolean result = textJoinPhone.getText().contains("-");
////					if(result) {
////						JOptionPane.showMessageDialog(panelJoinMembership,
////								"-를 뺀 숫자만 입력해 주세요."
////								);
////						textJoinPhone.setText("");
////					}
//
////					if (memberdao.isIntegerNumeric(textJoinPhone.getText()) == false) {
////						textJoinPhone.setText("");
////						JOptionPane.showMessageDialog(									
////								panelJoinMembership,
////								"-를 뺀 숫자만 입력하세요.",
////								"입력 오류",
////								JOptionPane.CANCEL_OPTION);
////					}	
////					if (memberdao.isIntegerNumeric(textJoinPhone.getText()) == false) {
////						  textJoinPhone.setText("");
////							JOptionPane.showMessageDialog(panelJoinMembership,
////							"-를 뺀 숫자만 입력해 주세요.");
////						  }
//			} 
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				boolean resultHypen = textJoinPhone.getText().contains("-");
//				if(resultHypen) {
//					JOptionPane.showMessageDialog(panelJoinMembership,
//							"-를 뺀 숫자만 입력해 주세요."
//							);
//					textJoinPhone.setText("");
//			}
//				boolean resultSting = memberdao.isIntegerNumeric(textJoinPhone.getText());
//				
//				if (resultSting == false) {
//					if(e.getKeyCode() != KeyEvent.VK_ENTER) {
//					textJoinPhone.setText("");
//					}
//					
//				}
//				
////					  textJoinPhone.setText("");
//				}
//		});
//		
//
//		
//		
////			String hypen = "-";
////			@Override
////			public void keyPressed(KeyEvent e) {
////				if(textJoinPhone.equals(hypen)) {
////					textJoinPhone.setText("");
////				JOptionPane.showMessageDialog(panelJoinMembership,
////						"-를 뺀 숫자만 입력해 주세요.");
////				}
////			}
//		
//
////		@Override
////		public void keyPressed(KeyEvent e) {
////			if (memberdao.isIntegerNumeric(textJoinPhone.getText()) == false) {
////			  textJoinPhone.setText("");
////				JOptionPane.showMessageDialog(panelJoinMembership,
////				"-를 뺀 숫자만 입력해 주세요.");
////			  }
////			
////		}
//
//		
//		
//		textJoinPhone.setColumns(10);
//		textJoinPhone.setBounds(100, 231, 140, 30);
//		panelJoinMembership.add(textJoinPhone);
//		
//		labelJoinPhone = new JLabel("전화번호");
//		labelJoinPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//		labelJoinPhone.setBounds(25, 225, 80, 35);
//		panelJoinMembership.add(labelJoinPhone);
//		
//		textJoinEmail = new JTextField();
//		//이메일 30글자수로 제한해둠.
//		textJoinEmail.addKeyListener(new KeyAdapter() { 
//			public void keyTyped(KeyEvent ke) {
//				JTextField src = (JTextField) ke.getSource();
//					if(src.getText().length() >= 30) {
//						ke.consume();
//					}
//					
////					//boolean result = textJoinEmail.getText().contains("@");
////					if(textJoinEmail.getText().contains("@") == false) {
////						JOptionPane.showMessageDialog(
////								panelJoinMembership,
////								"@를 넣은 형식으로 입력해주세요");
////								textJoinPhone.setText("");
////					}
//				}
//		});
//		
//				
//				textJoinEmail.setColumns(10);
//				textJoinEmail.setBounds(100, 279, 140, 30);
//				panelJoinMembership.add(textJoinEmail);
//				
//				labelJoinEmail = new JLabel("이메일");
//				labelJoinEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//				labelJoinEmail.setBounds(34, 274, 80, 35);
//				panelJoinMembership.add(labelJoinEmail);
//				
//				btnJoinCompletion = new JButton("가입 완료");
//				
//				//회원 가입 완료 버튼 클릭시 실행 되는 코드
//				btnJoinCompletion.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
////				 String gettextJoinPassword = new String(textJoinPassword.getPassword());
////				 System.out.println(gettextJoinPassword);
//						if(chckbxDuplicateCheck.isSelected() == false) {
//							JOptionPane.showMessageDialog(panelJoinMembership,"아이디 중복체크버튼을 클릭하세요");
//						}
//						idIdCheck(); if(overlapId) {return;}
//						emailEmailCheck(); if(overlapEmail) {return;}
//						joinMembershipCheck();
////						join();
//						//dispose();
//						
//					}
//				});
//				
//				
//				
//				btnJoinCompletion.setBounds(157, 325, 97, 23);
//				panelJoinMembership.add(btnJoinCompletion);
//				
//				btnIdCheck = new JButton("중복확인");
//				btnIdCheck.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						idCheck();
//						
//					}
//				});
//				btnIdCheck.setFont(new Font("굴림", Font.PLAIN, 10));
//				btnIdCheck.setBounds(218, 89, 69, 23);
//				panelJoinMembership.add(btnIdCheck);
//				
//				btnPreviousScreen = new JButton("이전 화면");
//				btnPreviousScreen.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						panelJoinMembership.setVisible(false);
//						panelTermsConditions.setVisible(true);
//					}
//				});
//				btnPreviousScreen.setBounds(34, 325, 95, 23);
//				panelJoinMembership.add(btnPreviousScreen);
//				
//				chckbxDuplicateCheck = new JCheckBox("");
//				chckbxDuplicateCheck.setBounds(228, 91, 42, 23);
//				panelJoinMembership.add(chckbxDuplicateCheck);
//		panelTermsConditions.setBounds(0, 0, 306, 374);
//		contentPane.add(panelTermsConditions);
//		panelTermsConditions.setLayout(null);
//		
//		lblNewLabel = new JLabel("New label");
//		lblNewLabel.setBounds(22, 45, 57, 49);
//		panelTermsConditions.add(lblNewLabel);
//		
//		lblNewLabel_1 = new JLabel("Frog Pizza 이용약관");
//		lblNewLabel_1.setBounds(12, 20, 127, 15);
//		panelTermsConditions.add(lblNewLabel_1);
//		
//		btnNewButton = new JButton("다음");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				panelTermsConditions.setVisible(false);
//				panelJoinMembership.setVisible(true);
//			}
//		});
//		btnNewButton.setBounds(157, 325, 97, 23);
//		panelTermsConditions.add(btnNewButton);
//	}
//	
//	
//	
//	private void emailEmailCheck() {Connection conn = null;
//    PreparedStatement stmt = null;
//    ResultSet rs = null;
//    overlapEmail = false;
//    try {
//        DriverManager.registerDriver(new OracleDriver());
//        System.out.println("오라클 드라이버 등록 성공");
//        
//        // 4. 오라클 데이터베이스에 접속(오라클 세션 생성)
//        conn = DriverManager.getConnection(URL, USER, PASSWORD);
//        System.out.println("오라클 접속 성공");
//        
//        // 5. Statement 타입 객체 생성
//        final String sql = "select * from MEMBERSHIP_TB";
//        //-> Statement 객체에서 사용하는 SQL 문장은 세미콜론(;)을 사용하지 않음!
//        stmt = conn.prepareStatement(sql);
//        
//        // 6-7. SQL 문장 실행 & 결과 처리
//        rs = stmt.executeQuery();
//        while (rs.next()) { // ResultSet(테이블)에서 다음 행(row)이 있는 지 검사
//            // 그 행의 컬럼들에 있는 값을 읽음:
//            String id = rs.getString(COL_ID); // 테이블의 ID 컬럼 값을 읽음.
//            String password = rs.getString(COL_PASSWORD); // 테이블의 TITLE 컬럼 값을 읽음.
//            String name = rs.getString(COL_NAME);
//            String email = rs.getString(COL_EMAIL);
//            String phone = rs.getString(COL_PHONE_NUMBER);
//                    
//            LocalDateTime joinDate = rs.getTimestamp(COL_JOIN_DATE)
//                    .toLocalDateTime();
//            
//            Membership member = new Membership(id, password, name, email, phone, joinDate);
//            boolean emailCheck = member.getEmail().equals(textJoinEmail.getText());
//            //System.out.println(idCheck);
//            if(emailCheck == true) {
//            	JOptionPane.showMessageDialog(panelJoinMembership, "중복된 이메일이 있습니다.");
//            	textJoinEmail.setText("");
//            	overlapEmail = true;
//            	return;
//            }
//
//        } 
//        } catch (SQLException e) {
//        e.printStackTrace();
//    } finally {
//        // 리소스 해제
//        try {
//        	rs.close(); // ResultSet 해제.
//            stmt.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
////        if(overlapEmail) {
////        	JOptionPane.showMessageDialog(panelJoinMembership, "중복된 이메일이 있습니다.");
////        	textJoinId.setText("");
////        	return;
////        }
//		
//	}
//
//	private void joinMembershipCheck() {
//		int checkResult = joinCheck();
//		switch(checkResult){
//		case 0 :
//			join();
//			JOptionPane.showMessageDialog(panelJoinMembership, "가입이 완료되었습니다.");
//			dispose();
//			break;
//			case 1 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요.");
//				break;
//			case 2 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "비빌번호를 입력하세요.");
//				break;
//			case 3 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "이름를 입력하세요.");
//				break;
//			case 4 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "전화번호를 입력하세요.");
//				break;
//			case 5 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "이메일을 입력하세요.");
//				break;
//			case 6 :
//				JOptionPane.showMessageDialog(panelJoinMembership, "@를 포함한 형식으로 email을 작성해주세요.");
//				textJoinEmail.setText("");
//				break;
//				
//		}
//		
//	}
//
//	private int joinCheck() {
//		
//		boolean idNullCheck = textJoinId.getText().equals("");
//		boolean passwordNullCheck = new String(textJoinPassword.getPassword()).equals("");
//		boolean nameNullCheck = textJoinName.getText().equals("");
//		boolean phoneNullCheck = textJoinPhone.getText().equals("");
//		boolean emailNullCheck = textJoinEmail.getText().equals("");
//		boolean atCheck = textJoinEmail.getText().contains("@");
//		
//		if(idNullCheck) {
//			return 1;
//			//JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요.");
//		}
//		if(passwordNullCheck) {
//			return 2;
//			//JOptionPane.showMessageDialog(panelJoinMembership, "비빌번호를 입력하세요.");
//		}
//		if(nameNullCheck) {
//			return 3;
//		}
//		if(phoneNullCheck) {
//			return 4;
//		}
//		if(emailNullCheck) {
//			return 5;
//		}
//		if(atCheck == false) {
//			//JOptionPane.showMessageDialog(panelJoinMembership, "@를 포함한 형식으로 email을 작성해주세요.");
//			//textJoinEmail.setText("");
//			return 6;
//		}
//		return 0;
//		
//	}
//
//	//중복확인 버튼 클릭시 호출되는 메서드
//	/**
//	 * 중복확인 버튼 클릭시 호출되는 메서드
//	 */
//	private void idCheck() {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        overlapId = false; 
//        try {
//            DriverManager.registerDriver(new OracleDriver());
//            System.out.println("오라클 드라이버 등록 성공");
//            
//            // 4. 오라클 데이터베이스에 접속(오라클 세션 생성)
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("오라클 접속 성공");
//            
//            // 5. Statement 타입 객체 생성
//            final String sql = "select * from MEMBERSHIP_TB";
//            //-> Statement 객체에서 사용하는 SQL 문장은 세미콜론(;)을 사용하지 않음!
//            stmt = conn.prepareStatement(sql);
//            
//            // 6-7. SQL 문장 실행 & 결과 처리
//            rs = stmt.executeQuery();
//            if(textJoinId.getText().equals("")) {
//            	JOptionPane.showMessageDialog(panelJoinMembership, "아이디를 입력하세요");
//            	return;
//            }
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
//                boolean idCheck = member.getId().equals(textJoinId.getText());
//                //System.out.println(idCheck);
//                if(idCheck == true) {
//                	JOptionPane.showMessageDialog(panelJoinMembership, "중복된 아이디가 있습니다.");
//                	textJoinId.setText("");
//                	overlapId = true;
//                	return;
//                } 
//            } 
//            //반복문에서 중복 아이디 없으면 실행 되는 코드
//            JOptionPane.showMessageDialog(panelJoinMembership, "사용 가능한 아이디 입니다.","사용 가능",JOptionPane.PLAIN_MESSAGE);
//            chckbxDuplicateCheck.setSelected(true);
//        } catch (SQLException e) {
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
//	/**
//	 * 가입완료 버튼 클릭시 아이디 중복확인
//	 */
//	private void idIdCheck() {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        overlapId = false;
//        try {
//            DriverManager.registerDriver(new OracleDriver());
//            System.out.println("오라클 드라이버 등록 성공");
//            
//            // 4. 오라클 데이터베이스에 접속(오라클 세션 생성)
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("오라클 접속 성공");
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
//                boolean idCheck = member.getId().equals(textJoinId.getText());
//                //System.out.println(idCheck);
//                if(idCheck == true) {
//                	JOptionPane.showMessageDialog(panelJoinMembership, "중복된 아이디가 있습니다.");
//                	textJoinId.setText("");
//                	overlapId = true;
//                	return;
//                }
//
//            } 
//            } catch (SQLException e) {
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
//	
//	
//	
//	
//	
//	
//	// 가입완료 버튼 클릭시 호출되는 메서드 -> 오라클 DB MEMBERSHIP_TB 테이블에 텍스트필드에 저장한 입력값을 읽어서 저장시킴.
//	private void join() {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        try {
//            // 오라클 드라이버(라이브러리) 등록
//            DriverManager.registerDriver(new OracleDriver());
//            
//            // 오라클 DB 접속
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//            final String sql = String.format(
//                    "insert into %s (%s, %s, %s, %s, %s) values (?, ?, ?, ?, ?)", 
//                    TBL_MEMBERSHIP, COL_ID, COL_PASSWORD, COL_NAME, COL_EMAIL, COL_PHONE_NUMBER);
//            
//          
//            stmt = conn.prepareStatement(sql);
//            
//            //비밀번호 텍스트 필드에 입력한 값 - 문자열로 변환 해서 저장.
//           String gettextJoinPassword = new String(textJoinPassword.getPassword());
//            
//            // PreparedStatement 객체의 SQL에서 ? 부분을 입력받은 내용으로 채움.
//            stmt.setString(1,textJoinId.getText()); // 첫번째 ?에 textJoinId.getText() 변수의 값을 문자열로 채움.
//            stmt.setString(2, gettextJoinPassword);
//            stmt.setString(3, textJoinName.getText());
//            stmt.setString(4, textJoinEmail.getText());
//            stmt.setString(5, textJoinPhone.getText());
//            
//            // SQL 문장을 DB로 보내서 실행 & 결과 처리
//            int result = stmt.executeUpdate();
//           // System.out.println(result + "개 행이 삽입됨.");
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // 리소스 해제
//            try {
//                stmt.close();
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//		
//	}
//}
