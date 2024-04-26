package com.itwill.ver05.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ContactSearchFrame extends JFrame {

	//Ŭ���� ContactSearchFrame�� �ִ�
	// showContactUpdateFrame()�޼��尡 ȣ�� �� �� �ҷ��ִ� ������ �θ�������Ʈ�� �ƱԸ�Ʈ�� �Ѱܹ޾� â���µ� ������
	// �� �ƱԸ�Ʈ �����ؼ� ������ �ʵ� ����
	private Component parentComponent;
	
	private static final String[] COLUMN_NAMES = {"�̸�","��ȭ��ȣ","�̸���"};
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	
	private DefaultTableModel model;
	
	private ContactDao dao = ContactDaoImpl.getInstance();

	/**
	 * Launch the application.
	 */
	public static void showContactSearchFrame(Component parentComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactSearchFrame frame = new ContactSearchFrame(parentComponent);
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
	public ContactSearchFrame(Component parentComponent) {
		this.parentComponent = parentComponent;
		initialize();
	}
	
	
	public void initialize() {
		setTitle("����ó �˻�");//-> â�� �ߴ� Ÿ��Ʋ �޼��� 
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//â�ߴ� ��ġ ����
		int x = 0;
		int y = 0;
		if(parentComponent !=null) {
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 450, 300);
		
		if(parentComponent == null) {
			setLocationRelativeTo(null);// ȭ�� �߾ӿ� ��ġ �ϰڴ�.
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		contentPane.add(headerPanel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("����", Font.PLAIN, 20));
		headerPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener((e)->searchByKeyeord());
		
//		btnSearch.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		
		
		btnSearch.setFont(new Font("����", Font.PLAIN, 20));
		headerPanel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		
		// ���̺� �÷� ��� �̸��� ��Ʈ ����
		table.getTableHeader().setFont(new Font("����", Font.PLAIN, 17));
		
		// ���̺� ������ ���� ��Ʈ ����
		table.setFont(new Font("����", Font.PLAIN, 17));
		
		//���̺� �� ����(���� ũ��) ����
		table.setRowHeight(30);
		
		model = new DefaultTableModel(null,COLUMN_NAMES);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
	}
	
	private void searchByKeyeord(){ // �˻� ��ư Ŭ���� ȣ�� ��.
		//�˻��� ����
		String keyword = textField.getText();
		
		//dao�� ����ؼ� �˻���� �˻� ����� ������
		List<Contact> list = dao.search(keyword);
				
		//�˻� ����� ���̺� ��.
		
		//������ ����
		model = new DefaultTableModel(null,COLUMN_NAMES);
		
		
		// ����� ���̺� �𵨿� �˻� ����� ������ �߰�
		for(Contact c : list) {
			Object[] row = {c.getName(),c.getPhone(),c.getEmail()}; //addRow�޼����� �Ķ���� ������ ������Ʈ �迭 Ÿ��.
			model.addRow(row);
		}
		
		//���̺� ���̺� ���� �ٽ� ����
		table.setModel(model);
				
				
				
	}

}
