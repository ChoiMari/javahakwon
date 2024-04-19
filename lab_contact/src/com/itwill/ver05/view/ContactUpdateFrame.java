package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;
import com.itwill.ver05.view.ContactCreateFrame.CreateNotify;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
	
	public interface UpdateNotify{
		void notifyContactUpdate();
	}
	
	private UpdateNotify app;// 메인 쓰레드 주소를 저장하기 위한 객체.
	//private ContactMain05 app;//으로도 할수있지만 사용범위를 넓히려고... 인터페이스를 만들어서 인터페이스 타입의 필드 변수에 담음.
	
	//부모 컴포넌트를 저장하기 위해서 필드 선언 - 업데이트 창의 뜨는 위치 설정하려고 
	//메인에서 아규먼트로 그 정보(메인창의 위치)를 받음. 그걸(넘겨받은 아규먼트) 저장하려고 필드 선언.
	private Component parentComponent;
	
	//메인에서(아규먼트로)넘겨 받은 인덱스 정보 저장하려고 필드 선언. 
	private int index;//업데이트 할 연락처의 (리스트)인덱스를 저장하기 위해서.
	
	
	private ContactDao dao = ContactDaoImpl.getInstance();
	
	//private CreateNotify app;
	
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

	
	
	
	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(Component parentComponent,int index,UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parentComponent,index,app);
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
	public ContactUpdateFrame(Component parentComponent,int index,UpdateNotify app) {
		this.parentComponent = parentComponent;//-> 오는 값이 null인지 아닌지 체크해야 된다고
		this.index = index;
		this.app = app;
		
		//필드 초기화 후 실행
		initialize(); //->끝나야 화면에 보여지는 것들이 생성이 끝남.-> 텍스트 필드가 만들어 진 다음에 거기에 기존에 저장된 연락처 정보 채우려고..
		// 이 밑에다가 채우는 기능 있는 메서드 만들어서 실행. 일단 텍스트 필드가 만들어 져있어야 그 후에 기존의 정보를 채울수 있으니까..
		initializeTextFields();
	}
	
	private void initializeTextFields() {//->해당 인덱스에 있는 기존에 저장된 연락처 정보가 실행시 각각의 텍스트 필드에 띄워져있게 설정하는 메서드
		//3개의 텍스트 필드에 해당 인덱스의 연락처 정보를 채움.
		Contact contact = dao.read(index);//-> 해당 인덱스 위치에 있는 연락처 정보를 리턴받아 Contact타입의 변수contact에 저장.
		//아규먼트 index가 리스트의 인덱스 범위 안에 있으면 Contact 타입 객체를 리턴. 
		//index가 리스트 범위 밖에 있거나, 해당 인덱스의 리스트 원소가 null이면 null을 리턴.
		//contacts.get(index)값을 리턴해 주는데 get(index)메서드는 해당 리스트의 아규먼트로 넣어주는 인덱스 위치에 있는 원소 값을 리턴해줌 
		//read(index)메서드 리턴 타입이 Contact. Contact타입으로 리턴해주니까 이 메서드 리턴값의. 하면 Contact에 있는 getName()이 보이는 것.
		//System.out.println(dao.read(index));//->Contact(id=0, name=1234, phone=dd, email=dd)출력->Contact(파라미터...선언된)생성자(선택된 위치의 연락처 정보가 저장된)리턴해줌
		// dao. 하면 dao를 선언할 때 쓴 타입의 참조타입(클래스,인터페이스)에 있는게 보이는 거고
		//getName메서드는 Contact 클래스에 있는 거니까
		//Contact타입의 객체가 있어야지 그 객체에서. 해야 getName()메서드가 보여서 가져올수 있음.
		// dao.read(index)가 리턴타입이 Contact타입이여서(컨텍트타입의 객체값을 리턴해줌) 그래서
		//dao.read(index). 하면 이제 Contact에 있는 필드,메서드들( 그중에 getName()메서드도 있어서)이 보여서 쓸 수 있는 것.
		//근데 다 보이는 것은 아니고 public으로 선언 된 것(필드,메서드)들만 보임.
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
	}
	
	
	public void initialize() {
		
		setTitle("연락처 업데이트"); //-> 창의 타이틀 문구
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 해당 창만 닫고 메인창은 안 닫히도록 설정.
		
		//업데이트 창 클릭시 뜨는 창의 위치 설정. -> 메인으로 부터 오는 아규먼트 이용해서 그 정보로 기능 만듬
		//(parentComponent ->frame 메인창의 위치를 넘김.)
		int x = 0;
		int y = 0;
		if(parentComponent != null) { //nullpointer예외 발생한다고 
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 451, 251);
		//parentComponent가 null일 때 실행 - 메인에서 부모컴포넌트 아규먼트 자리에 null줄 경우 실행
		if(parentComponent == null) { // 이 코드 안적었으면 setBounds(x, y, 451, 251);이 좌표로 뜸.(0,0,가로크기,세로크기)
			setLocationRelativeTo(null); //-> 화면 중앙에 뜸
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
		
		//이름 채우기
		textName =new JTextField();
		//textName =new JTextField(dao.read(index).getName()); 
		//ContactDaoImpl()객체가 저장된 dao.해서 
		//read(index)메서드 호출해서(그럼 연락처가 저장된 contacts.get(index)리턴 되는데(이름,번호,이메일 뭉텅이로 저장된 배열?)
		// 거기서 . 해서 getName(); 이름 정보만 뽑아옴.
		
		
		textName.setFont(new Font("굴림", Font.PLAIN, 20));
		textName.setBounds(139, 10, 273, 38);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("\uC804\uD654\uBC88\uD638");
		lblPhone.setFont(new Font("굴림", Font.PLAIN, 20));
		lblPhone.setBounds(22, 58, 114, 38);
		contentPanel.add(lblPhone);
		
		//전호번호 채우기
		textPhone = new JTextField();
		//textPhone = new JTextField(dao.read(index).getPhone());
		textPhone.setFont(new Font("굴림", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(139, 58, 273, 38);
		contentPanel.add(textPhone);
		
		lblEmail = new JLabel("\uC774\uBA54\uC77C");
		lblEmail.setFont(new Font("굴림", Font.PLAIN, 20));
		lblEmail.setBounds(22, 105, 114, 38);
		contentPanel.add(lblEmail);
		
		//이메일 채우기
		//textEmail = new JTextField(dao.read(index).getEmail());
		textEmail = new JTextField();
				
		textEmail.setFont(new Font("굴림", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(139, 105, 273, 38);
		contentPanel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("\uC800\uC7A5");
		// 저장 클릭시 실행 -> 람다 표현식
		btnSave.addActionListener((e)-> updateContact());
//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				updateContact();
//			}
//		});
		btnSave.setFont(new Font("굴림", Font.PLAIN, 20));
		buttonPanel.add(btnSave);
		
		btnCancle = new JButton("\uCDE8\uC18C");
		// 취소 버튼 클릭시 실행 :  액션이 일어나는 지 듣고 있다가 이벤트가 발생하면 실행 addActionListener
		btnCancle.addActionListener((e) -> dispose()); // 이벤트가 발생하면 창을 닫는 메서드 dispose();호출.
//		btnCancle.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnCancle.setFont(new Font("굴림", Font.PLAIN, 20));
		buttonPanel.add(btnCancle);
	}
	
	public void updateContact(){
		//업데이트 할 내용을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		Contact contact = new Contact(0, name, phone, email);
		
		int result = dao.update(index, contact);
		if(result == 1) {//저장 성공하면 실행
			//메인 창에(쓰레드)에게 업데이트 성공을 알려줌
			//-> 성공 메세지를 메인 창에서 보여줄지, 업데이트 창에서 보여주고 창이 닫힐지 선택하기.
			//-> 메세지 창이용
			//만일 메인 객체생성 해서 부르면 안됨 현재 띄워준 창의 객체 주소가 필요하기 떄문에. 여기서 객체 생성해서 쓰면
			// 객체가 메모리 힙공간에 새로 만들어지기 때문에 다름. 현재 업데이트 창을 띄워준 메인 객체가 아님.
			// 현재 업데이트 창을 띄워준 메인 객체의 주소가 필요함. 현재 메인창과 상호작용하려면...
			// JOptionPane.showMessageDialog(parentComponent,"연락처 정보가 업데이트 되었습니다.");
			dispose();//-> 현재(업데이트) 창 닫기
			app.notifyContactUpdate();
		} else {
			//업데이트 실패 메세지 보여 주기
		}
		
	}
	

}
