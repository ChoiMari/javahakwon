package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {
	
	//인터페이스 선언
	public interface CreateNotify { //ContactMain05뿐만 아니라 다른 클래스에서도 
		//showContactCreateFrame메서드가 호출 될 때 사용되라고(사용범위를 넓히려고)
		// 인터페이스를 선언해서 이 인터페이스 타입으로 파라미터를 선언함.
		//showContactCreateFrame(Component parentComponent, CreateNotify app)
		// 이 인터페이스 타입으로 아규먼트로 넘겨주려면 그 클래스는 이 인터페이스를 구현해야하고 인터페이스에 선언된
		// 추상 메서드를 구현해야함(오버라이딩)
		
		
		//인터페이스 CreateNotify를 구현하는 클래스는 반드시 notifyContactCreared()메서드를 구현해야함(오버라이드)
		public void notifyContactCreared();
	
	}
	
	//필드 선언 
	private CreateNotify app;//->연락처 저장을 성공을 컨텍트 메인에 알려줄 객체
	// = new ContactMain05() 이렇게 이 자리에서 생성 해버리면 안됨. 생성자는 호출 할 때 마다 힙 메모리에 새로운 객체(주소)가 만들어져서 안됨.
	// 원래의 메인창이 띄웠으니까 상호작용하려면 자기를 띄워준 메인창에 정보(아규먼트로)를 넘겨주어야 하기 때문에
	// 자기를 띄워준 메인의 객체 주소를 가지고 있어야 함.
	// ContactMain05.this을 ContactMain05에서 값을 받아서(아규먼트로 넘김받은걸로) app에 저장해야
	//showContactCreateFrame(Component parentComponent, CreateNotify app)에 파라미터 선언 추가 함
	// 서로 창끼리 상호 작용을 해야되기 때문에 객체의 주소(참조)값이 바뀌면 안됨.그래서(new로 객체생성 해서 쓰면 안되는 것)
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPanel;
	private JPanel buttonPanel;
	private JButton btnSave;
	private JLabel lblName;
	private JButton btnCancle;
	private JTextField textName;
	private JLabel lblPhone;
	private JTextField textPhone;
	private JLabel lblEmail;
	private JTextField textEmail;

	private Component parentComponent; // CreateFrame의 부모 컴포넌트
	
	//dao를 필드로 선언,  ContactDaoImpl.getInstance()호출 하면서 ContactDaoImpl객체를 dao에 담음
	//-> 싱글턴으로 만들어서 같은 객체. 몇번을 호출해도 같은 객체의 주소가 dao에 저장됨.
	//dao.하면 ContactDao에 있는 메서드,필드 사용가능.
	private ContactDao dao = ContactDaoImpl.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void showContactCreateFrame(Component parentComponent, CreateNotify app) {//CreateNotify 인터페이스 타입으로 파라미터 변수 app선언
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parentComponent,app);
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
	public ContactCreateFrame(Component  parentComponent, CreateNotify app) {
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();;
	}
	
	public void initialize() {
		
		setTitle("새 연락처 저장");// 창에 타이틀 새 연락처 저장으로 뜨도록 설정.
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//->ContactCreateFrame 창을 닫아도 ContactMain05메인 창은 안 닫히게 설정
		
		
		int x = 0;
		int y = 0;
		//부모 컴포넌트가 있으면 부모 컴포넌트와 같은 좌표(x,y)에 위치 시킴
		if(parentComponent != null) {
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 451, 251);
		
		if(parentComponent == null) { // 부모 컴포넌트가 없으면 아규먼트로 null이 오면 화면 중앙에 위치 시키겠다.
			setLocationRelativeTo(null);
		}
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblName = new JLabel("\uC774\uB984");
		lblName.setFont(new Font("굴림", Font.PLAIN, 20));
		lblName.setBounds(22, 10, 114, 38);
		contentPanel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.PLAIN, 20));
		textName.setBounds(139, 10, 273, 38);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("\uC804\uD654\uBC88\uD638");
		lblPhone.setFont(new Font("굴림", Font.PLAIN, 20));
		lblPhone.setBounds(22, 58, 114, 38);
		contentPanel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("굴림", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(139, 58, 273, 38);
		contentPanel.add(textPhone);
		
		lblEmail = new JLabel("\uC774\uBA54\uC77C");
		lblEmail.setFont(new Font("굴림", Font.PLAIN, 20));
		lblEmail.setBounds(22, 105, 114, 38);
		contentPanel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("굴림", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(139, 105, 273, 38);
		contentPanel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("\uC800\uC7A5"); 
		//저장 버튼 클릭시 실행
		btnSave.addActionListener((e)-> saveContact());//->입력한 내용을 저장하는 saveContact()메서드를 만들어서 여기서 호출
		
		btnSave.setFont(new Font("굴림", Font.PLAIN, 20));
		buttonPanel.add(btnSave);
		
		btnCancle = new JButton("\uCDE8\uC18C");
		btnCancle.addActionListener((e)-> dispose()); //이벤트가 발생하면(취소버튼을 누르면) 현재 창만 닫음.
//		btnCancle.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {//취소버튼 클릭시 실행
//				
//			}
//		});->람다 표현식으로 만듬
		btnCancle.setFont(new Font("굴림", Font.PLAIN, 20));
		buttonPanel.add(btnCancle);
	}

	private void saveContact() {
		//텍스트 값을 읽는다 그걸 파일에 저장한다 그걸 dao가 함. dao를 멤버변수(필드)로 가지고 있던가
		//지역변수로 가지고 있던가 선택. 멤버변수(필드로 가지고 있는걸 선택.)
		// dao메서드 호출해야 되서
		
		// 1. JTextField에서 저장할 이름, 전화번호, 이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();//@포함 되었는지 추가
		
		// 2. Contact 타입 객체 생성
		Contact contact = new Contact(0, name, phone, email);
		
		//3.dao를 사용해서 파일에 저장
		int result = dao.create(contact);//create메서드 리스트에 연락처 정보를 저장했으면 1, 저장 실패하면 0을 리턴해줌
		if(result == 1) {//연락처 저장 성공
			//ContactMain에게 연락처 저장이 성공됐음을 알려줌.->메인에서는 테이블 새로 그림
			
			dispose();//현재 창 닫기
			app.notifyContactCreared();//얘(app)가 컨텍트메인의 주소값이면 된다고..???
			//app이라는 변수가 메인의 주소를 가지고 있었으면 좋겠고,
			//메인에게 정보가가고 메인에서 그 정보로 알아서 한다고..??
			//app에는 ContactMain05객체의 주소값이 저장되었는데, 인터페이스 타입으로 app에 저장했기 때문에
			//app.하면 인터페이스에 있는 메서드,필드만 보여서 사용가능한데
			//호출시 구현한 클래스의 메서드(오버라이드 한 메서드)가 호출 되기 때문에
			//ContactMain05에 재정의한 메서드가 호출되서 실행됨.
			
		} else {//연락처 저장 실패
			// 사용자에게 저장 실패 메세지 보여주기
		}
	}
}
