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
	
	private UpdateNotify app;// ���� ������ �ּҸ� �����ϱ� ���� ��ü.
	//private ContactMain05 app;//���ε� �Ҽ������� �������� ��������... �������̽��� ���� �������̽� Ÿ���� �ʵ� ������ ����.
	
	//�θ� ������Ʈ�� �����ϱ� ���ؼ� �ʵ� ���� - ������Ʈ â�� �ߴ� ��ġ �����Ϸ��� 
	//���ο��� �ƱԸ�Ʈ�� �� ����(����â�� ��ġ)�� ����. �װ�(�Ѱܹ��� �ƱԸ�Ʈ) �����Ϸ��� �ʵ� ����.
	private Component parentComponent;
	
	//���ο���(�ƱԸ�Ʈ��)�Ѱ� ���� �ε��� ���� �����Ϸ��� �ʵ� ����. 
	private int index;//������Ʈ �� ����ó�� (����Ʈ)�ε����� �����ϱ� ���ؼ�.
	
	
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
		this.parentComponent = parentComponent;//-> ���� ���� null���� �ƴ��� üũ�ؾ� �ȴٰ�
		this.index = index;
		this.app = app;
		
		//�ʵ� �ʱ�ȭ �� ����
		initialize(); //->������ ȭ�鿡 �������� �͵��� ������ ����.-> �ؽ�Ʈ �ʵ尡 ����� �� ������ �ű⿡ ������ ����� ����ó ���� ä�����..
		// �� �ؿ��ٰ� ä��� ��� �ִ� �޼��� ���� ����. �ϴ� �ؽ�Ʈ �ʵ尡 ����� ���־�� �� �Ŀ� ������ ������ ä��� �����ϱ�..
		initializeTextFields();
	}
	
	private void initializeTextFields() {//->�ش� �ε����� �ִ� ������ ����� ����ó ������ ����� ������ �ؽ�Ʈ �ʵ忡 ������ְ� �����ϴ� �޼���
		//3���� �ؽ�Ʈ �ʵ忡 �ش� �ε����� ����ó ������ ä��.
		Contact contact = dao.read(index);//-> �ش� �ε��� ��ġ�� �ִ� ����ó ������ ���Ϲ޾� ContactŸ���� ����contact�� ����.
		//�ƱԸ�Ʈ index�� ����Ʈ�� �ε��� ���� �ȿ� ������ Contact Ÿ�� ��ü�� ����. 
		//index�� ����Ʈ ���� �ۿ� �ְų�, �ش� �ε����� ����Ʈ ���Ұ� null�̸� null�� ����.
		//contacts.get(index)���� ������ �ִµ� get(index)�޼���� �ش� ����Ʈ�� �ƱԸ�Ʈ�� �־��ִ� �ε��� ��ġ�� �ִ� ���� ���� �������� 
		//read(index)�޼��� ���� Ÿ���� Contact. ContactŸ������ �������ִϱ� �� �޼��� ���ϰ���. �ϸ� Contact�� �ִ� getName()�� ���̴� ��.
		//System.out.println(dao.read(index));//->Contact(id=0, name=1234, phone=dd, email=dd)���->Contact(�Ķ����...�����)������(���õ� ��ġ�� ����ó ������ �����)��������
		// dao. �ϸ� dao�� ������ �� �� Ÿ���� ����Ÿ��(Ŭ����,�������̽�)�� �ִ°� ���̴� �Ű�
		//getName�޼���� Contact Ŭ������ �ִ� �Ŵϱ�
		//ContactŸ���� ��ü�� �־���� �� ��ü����. �ؾ� getName()�޼��尡 ������ �����ü� ����.
		// dao.read(index)�� ����Ÿ���� ContactŸ���̿���(����ƮŸ���� ��ü���� ��������) �׷���
		//dao.read(index). �ϸ� ���� Contact�� �ִ� �ʵ�,�޼����( ���߿� getName()�޼��嵵 �־)�� ������ �� �� �ִ� ��.
		//�ٵ� �� ���̴� ���� �ƴϰ� public���� ���� �� ��(�ʵ�,�޼���)�鸸 ����.
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
	}
	
	
	public void initialize() {
		
		setTitle("����ó ������Ʈ"); //-> â�� Ÿ��Ʋ ����
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �ش� â�� �ݰ� ����â�� �� �������� ����.
		
		//������Ʈ â Ŭ���� �ߴ� â�� ��ġ ����. -> �������� ���� ���� �ƱԸ�Ʈ �̿��ؼ� �� ������ ��� ����
		//(parentComponent ->frame ����â�� ��ġ�� �ѱ�.)
		int x = 0;
		int y = 0;
		if(parentComponent != null) { //nullpointer���� �߻��Ѵٰ� 
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 451, 251);
		//parentComponent�� null�� �� ���� - ���ο��� �θ�������Ʈ �ƱԸ�Ʈ �ڸ��� null�� ��� ����
		if(parentComponent == null) { // �� �ڵ� ���������� setBounds(x, y, 451, 251);�� ��ǥ�� ��.(0,0,����ũ��,����ũ��)
			setLocationRelativeTo(null); //-> ȭ�� �߾ӿ� ��
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
		
		//�̸� ä���
		textName =new JTextField();
		//textName =new JTextField(dao.read(index).getName()); 
		//ContactDaoImpl()��ü�� ����� dao.�ؼ� 
		//read(index)�޼��� ȣ���ؼ�(�׷� ����ó�� ����� contacts.get(index)���� �Ǵµ�(�̸�,��ȣ,�̸��� �����̷� ����� �迭?)
		// �ű⼭ . �ؼ� getName(); �̸� ������ �̾ƿ�.
		
		
		textName.setFont(new Font("����", Font.PLAIN, 20));
		textName.setBounds(139, 10, 273, 38);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("\uC804\uD654\uBC88\uD638");
		lblPhone.setFont(new Font("����", Font.PLAIN, 20));
		lblPhone.setBounds(22, 58, 114, 38);
		contentPanel.add(lblPhone);
		
		//��ȣ��ȣ ä���
		textPhone = new JTextField();
		//textPhone = new JTextField(dao.read(index).getPhone());
		textPhone.setFont(new Font("����", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(139, 58, 273, 38);
		contentPanel.add(textPhone);
		
		lblEmail = new JLabel("\uC774\uBA54\uC77C");
		lblEmail.setFont(new Font("����", Font.PLAIN, 20));
		lblEmail.setBounds(22, 105, 114, 38);
		contentPanel.add(lblEmail);
		
		//�̸��� ä���
		//textEmail = new JTextField(dao.read(index).getEmail());
		textEmail = new JTextField();
				
		textEmail.setFont(new Font("����", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(139, 105, 273, 38);
		contentPanel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("\uC800\uC7A5");
		// ���� Ŭ���� ���� -> ���� ǥ����
		btnSave.addActionListener((e)-> updateContact());
//		btnSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				updateContact();
//			}
//		});
		btnSave.setFont(new Font("����", Font.PLAIN, 20));
		buttonPanel.add(btnSave);
		
		btnCancle = new JButton("\uCDE8\uC18C");
		// ��� ��ư Ŭ���� ���� :  �׼��� �Ͼ�� �� ��� �ִٰ� �̺�Ʈ�� �߻��ϸ� ���� addActionListener
		btnCancle.addActionListener((e) -> dispose()); // �̺�Ʈ�� �߻��ϸ� â�� �ݴ� �޼��� dispose();ȣ��.
//		btnCancle.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnCancle.setFont(new Font("����", Font.PLAIN, 20));
		buttonPanel.add(btnCancle);
	}
	
	public void updateContact(){
		//������Ʈ �� ������ ����.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		Contact contact = new Contact(0, name, phone, email);
		
		int result = dao.update(index, contact);
		if(result == 1) {//���� �����ϸ� ����
			//���� â��(������)���� ������Ʈ ������ �˷���
			//-> ���� �޼����� ���� â���� ��������, ������Ʈ â���� �����ְ� â�� ������ �����ϱ�.
			//-> �޼��� â�̿�
			//���� ���� ��ü���� �ؼ� �θ��� �ȵ� ���� ����� â�� ��ü �ּҰ� �ʿ��ϱ� ������. ���⼭ ��ü �����ؼ� ����
			// ��ü�� �޸� �������� ���� ��������� ������ �ٸ�. ���� ������Ʈ â�� ����� ���� ��ü�� �ƴ�.
			// ���� ������Ʈ â�� ����� ���� ��ü�� �ּҰ� �ʿ���. ���� ����â�� ��ȣ�ۿ��Ϸ���...
			// JOptionPane.showMessageDialog(parentComponent,"����ó ������ ������Ʈ �Ǿ����ϴ�.");
			dispose();//-> ����(������Ʈ) â �ݱ�
			app.notifyContactUpdate();
		} else {
			//������Ʈ ���� �޼��� ���� �ֱ�
		}
		
	}
	

}
