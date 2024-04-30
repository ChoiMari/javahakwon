package com.itwill.project01.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

public class FrogPizzaJoinMembership extends JFrame {

	//컨트롤러 - MemberDao클래스 객체 생성.(싱글턴으로 만든) 
	private MemberDao memberdao = MemberDao.getInstance();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelJoinMembership;
	private JPanel panelTermsConditions;
	private JLabel labelJoinId;
	private JTextField textJoinId;
	private JLabel labelJoinMembershipLogo;
	
	private JPasswordField textJoinPassword;
	
	private JLabel labeJoinPassword;
	private JTextField textJoinName;
	private JLabel labelJoinName;
	
	private JFormattedTextField textJoinPhone;
	//private JTextField textJoinPhone;
	//private String getTextPhone = textJoinPhone.getText();
	
	private JLabel labelJoinPhone;
	private JTextField textJoinEmail;
	private JLabel labelJoinEmail;
	private JButton btnJoinCompletion;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	
	

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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //창의 x눌러도 현재 창만 닫게 설정함.
		
		setBounds(100, 100, 300, 413);
		contentPane = new JPanel();	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelTermsConditions = new JPanel();
		panelTermsConditions.setVisible(true);
		panelTermsConditions.setBounds(0, 0, 284, 374);
		contentPane.add(panelTermsConditions);
		panelTermsConditions.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(22, 45, 57, 49);
		panelTermsConditions.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Frog Pizza 이용약관");
		lblNewLabel_1.setBounds(12, 20, 127, 15);
		panelTermsConditions.add(lblNewLabel_1);
		
		btnNewButton = new JButton("다음");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTermsConditions.setVisible(false);
				panelJoinMembership.setVisible(true);
			}
		});
		btnNewButton.setBounds(157, 325, 97, 23);
		panelTermsConditions.add(btnNewButton);
		
		panelJoinMembership = new JPanel();
		
		panelJoinMembership.setVisible(false);
		
		panelJoinMembership.setBounds(0, 0, 284, 374);
		contentPane.add(panelJoinMembership);
		panelJoinMembership.setLayout(null);
		
		labelJoinId = new JLabel("아이디");
		labelJoinId.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		labelJoinId.setBounds(34, 79, 80, 35);
		panelJoinMembership.add(labelJoinId);
		
		textJoinId = new JTextField();
		//id 텍스트 필드 글자 수 제한 12글자로. 12글자 넘어가면 더이상 안 써지게 설정함.
		textJoinId.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
						if(src.getText().length() >= 12) {
							ke.consume();
						}
						
//						switch(memberdao.idFormat(textJoinId.getText())) {
//						case 1 :
//							JOptionPane.showMessageDialog(
//									panelJoinMembership,
//									"아이디는 4 ~ 12자 이내의 아이디만 가능합니다.");
//							break;
//						}
			} 
		});
		
		textJoinId.setColumns(10);
		textJoinId.setBounds(113, 83, 140, 30);
		panelJoinMembership.add(textJoinId);
		
		labelJoinMembershipLogo = new JLabel("회원 가입");
		labelJoinMembershipLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelJoinMembershipLogo.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		labelJoinMembershipLogo.setBounds(54, 24, 173, 33);
		panelJoinMembership.add(labelJoinMembershipLogo);
		
		textJoinPassword = new JPasswordField();
		//가입 할 때 비밀번호 입력하는 텍스트 필드 글자 수 제한 -13글자로
		//오라클 DB에 ID컬럼 데이터 타입 varchar2(15)로 해놓아서 제한을 해두어야 함.
		textJoinPassword.addKeyListener(new KeyAdapter() { 
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
						if(src.getText().length() >= 13) ke.consume();
			} 
		});
		
		textJoinPassword.setColumns(10);
		textJoinPassword.setBounds(113, 132, 140, 30);
		panelJoinMembership.add(textJoinPassword);
		
		labeJoinPassword = new JLabel("비밀번호");
		labeJoinPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		labeJoinPassword.setBounds(25, 129, 80, 35);
		panelJoinMembership.add(labeJoinPassword);
		
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
		textJoinName.setBounds(113, 179, 140, 30);
		panelJoinMembership.add(textJoinName);
		
		labelJoinName = new JLabel("이름");
		labelJoinName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		labelJoinName.setBounds(35, 177, 80, 35);
		panelJoinMembership.add(labelJoinName);
		
		

		
		//숫자가 아닌 값을 입력하면 사라짐.
		textJoinPhone = new JFormattedTextField(new NumberFormatter());
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
					
					boolean result = textJoinPhone.getText().contains("-");
					if(result) {
						JOptionPane.showMessageDialog(panelJoinMembership,
								"-를 뺀 숫자만 입력해 주세요."
								);
						textJoinPhone.setText("");
					}

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
		textJoinPhone.setBounds(113, 229, 140, 30);
		panelJoinMembership.add(textJoinPhone);
		
		labelJoinPhone = new JLabel("전화번호");
		labelJoinPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		labelJoinPhone.setBounds(25, 225, 80, 35);
		panelJoinMembership.add(labelJoinPhone);
		
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
		textJoinEmail.setBounds(113, 277, 140, 30);
		panelJoinMembership.add(textJoinEmail);
		
		labelJoinEmail = new JLabel("이메일");
		labelJoinEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		labelJoinEmail.setBounds(34, 274, 80, 35);
		panelJoinMembership.add(labelJoinEmail);
		
		btnJoinCompletion = new JButton("가입 완료");
		
		//회원 가입 완료 버튼 클릭시 실행 되는 코드
		btnJoinCompletion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		
		
		
		btnJoinCompletion.setBounds(157, 325, 97, 23);
		panelJoinMembership.add(btnJoinCompletion);
	}
		
		
}
