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
	
	//�������̽� ����
	public interface CreateNotify { //ContactMain05�Ӹ� �ƴ϶� �ٸ� Ŭ���������� 
		//showContactCreateFrame�޼��尡 ȣ�� �� �� ���Ƕ��(�������� ��������)
		// �������̽��� �����ؼ� �� �������̽� Ÿ������ �Ķ���͸� ������.
		//showContactCreateFrame(Component parentComponent, CreateNotify app)
		// �� �������̽� Ÿ������ �ƱԸ�Ʈ�� �Ѱ��ַ��� �� Ŭ������ �� �������̽��� �����ؾ��ϰ� �������̽��� �����
		// �߻� �޼��带 �����ؾ���(�������̵�)
		
		
		//�������̽� CreateNotify�� �����ϴ� Ŭ������ �ݵ�� notifyContactCreared()�޼��带 �����ؾ���(�������̵�)
		public void notifyContactCreared();
	
	}
	
	//�ʵ� ���� 
	private CreateNotify app;//->����ó ������ ������ ����Ʈ ���ο� �˷��� ��ü
	// = new ContactMain05() �̷��� �� �ڸ����� ���� �ع����� �ȵ�. �����ڴ� ȣ�� �� �� ���� �� �޸𸮿� ���ο� ��ü(�ּ�)�� ��������� �ȵ�.
	// ������ ����â�� ������ϱ� ��ȣ�ۿ��Ϸ��� �ڱ⸦ ����� ����â�� ����(�ƱԸ�Ʈ��)�� �Ѱ��־�� �ϱ� ������
	// �ڱ⸦ ����� ������ ��ü �ּҸ� ������ �־�� ��.
	// ContactMain05.this�� ContactMain05���� ���� �޾Ƽ�(�ƱԸ�Ʈ�� �ѱ�����ɷ�) app�� �����ؾ�
	//showContactCreateFrame(Component parentComponent, CreateNotify app)�� �Ķ���� ���� �߰� ��
	// ���� â���� ��ȣ �ۿ��� �ؾߵǱ� ������ ��ü�� �ּ�(����)���� �ٲ�� �ȵ�.�׷���(new�� ��ü���� �ؼ� ���� �ȵǴ� ��)
	
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

	private Component parentComponent; // CreateFrame�� �θ� ������Ʈ
	
	//dao�� �ʵ�� ����,  ContactDaoImpl.getInstance()ȣ�� �ϸ鼭 ContactDaoImpl��ü�� dao�� ����
	//-> �̱������� ���� ���� ��ü. ����� ȣ���ص� ���� ��ü�� �ּҰ� dao�� �����.
	//dao.�ϸ� ContactDao�� �ִ� �޼���,�ʵ� ��밡��.
	private ContactDao dao = ContactDaoImpl.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void showContactCreateFrame(Component parentComponent, CreateNotify app) {//CreateNotify �������̽� Ÿ������ �Ķ���� ���� app����
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
		
		setTitle("�� ����ó ����");// â�� Ÿ��Ʋ �� ����ó �������� �ߵ��� ����.
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//->ContactCreateFrame â�� �ݾƵ� ContactMain05���� â�� �� ������ ����
		
		
		int x = 0;
		int y = 0;
		//�θ� ������Ʈ�� ������ �θ� ������Ʈ�� ���� ��ǥ(x,y)�� ��ġ ��Ŵ
		if(parentComponent != null) {
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 451, 251);
		
		if(parentComponent == null) { // �θ� ������Ʈ�� ������ �ƱԸ�Ʈ�� null�� ���� ȭ�� �߾ӿ� ��ġ ��Ű�ڴ�.
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
		lblName.setFont(new Font("����", Font.PLAIN, 20));
		lblName.setBounds(22, 10, 114, 38);
		contentPanel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("����", Font.PLAIN, 20));
		textName.setBounds(139, 10, 273, 38);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("\uC804\uD654\uBC88\uD638");
		lblPhone.setFont(new Font("����", Font.PLAIN, 20));
		lblPhone.setBounds(22, 58, 114, 38);
		contentPanel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("����", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(139, 58, 273, 38);
		contentPanel.add(textPhone);
		
		lblEmail = new JLabel("\uC774\uBA54\uC77C");
		lblEmail.setFont(new Font("����", Font.PLAIN, 20));
		lblEmail.setBounds(22, 105, 114, 38);
		contentPanel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("����", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(139, 105, 273, 38);
		contentPanel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("\uC800\uC7A5"); 
		//���� ��ư Ŭ���� ����
		btnSave.addActionListener((e)-> saveContact());//->�Է��� ������ �����ϴ� saveContact()�޼��带 ���� ���⼭ ȣ��
		
		btnSave.setFont(new Font("����", Font.PLAIN, 20));
		buttonPanel.add(btnSave);
		
		btnCancle = new JButton("\uCDE8\uC18C");
		btnCancle.addActionListener((e)-> dispose()); //�̺�Ʈ�� �߻��ϸ�(��ҹ�ư�� ������) ���� â�� ����.
//		btnCancle.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {//��ҹ�ư Ŭ���� ����
//				
//			}
//		});->���� ǥ�������� ����
		btnCancle.setFont(new Font("����", Font.PLAIN, 20));
		buttonPanel.add(btnCancle);
	}

	private void saveContact() {
		//�ؽ�Ʈ ���� �д´� �װ� ���Ͽ� �����Ѵ� �װ� dao�� ��. dao�� �������(�ʵ�)�� ������ �ִ���
		//���������� ������ �ִ��� ����. �������(�ʵ�� ������ �ִ°� ����.)
		// dao�޼��� ȣ���ؾ� �Ǽ�
		
		// 1. JTextField���� ������ �̸�, ��ȭ��ȣ, �̸����� ����.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();//@���� �Ǿ����� �߰�
		
		// 2. Contact Ÿ�� ��ü ����
		Contact contact = new Contact(0, name, phone, email);
		
		//3.dao�� ����ؼ� ���Ͽ� ����
		int result = dao.create(contact);//create�޼��� ����Ʈ�� ����ó ������ ���������� 1, ���� �����ϸ� 0�� ��������
		if(result == 1) {//����ó ���� ����
			//ContactMain���� ����ó ������ ���������� �˷���.->���ο����� ���̺� ���� �׸�
			
			dispose();//���� â �ݱ�
			app.notifyContactCreared();//��(app)�� ����Ʈ������ �ּҰ��̸� �ȴٰ�..???
			//app�̶�� ������ ������ �ּҸ� ������ �־����� ���ڰ�,
			//���ο��� ���������� ���ο��� �� ������ �˾Ƽ� �Ѵٰ�..??
			//app���� ContactMain05��ü�� �ּҰ��� ����Ǿ��µ�, �������̽� Ÿ������ app�� �����߱� ������
			//app.�ϸ� �������̽��� �ִ� �޼���,�ʵ常 ������ ��밡���ѵ�
			//ȣ��� ������ Ŭ������ �޼���(�������̵� �� �޼���)�� ȣ�� �Ǳ� ������
			//ContactMain05�� �������� �޼��尡 ȣ��Ǽ� �����.
			
		} else {//����ó ���� ����
			// ����ڿ��� ���� ���� �޼��� �����ֱ�
		}
	}
}
