package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;
import com.itwill.ver05.view.ContactCreateFrame.CreateNotify;
import com.itwill.ver05.view.ContactUpdateFrame.UpdateNotify;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactMain05 implements CreateNotify, UpdateNotify {

	//��� ���� - DefaultTableModel������ �� ����� �Ŷ�� ��
	private static final String[] COLUMN_NAMES = {"�̸�", "��ȭ��ȣ"};
	
	//�ʵ� ���� - ������ ������ �̹� �ֽ��ϴ�... ���� �� �ܼ�â�� �� ������ ��.
	private ContactDao dao = ContactDaoImpl.getInstance();
	//-> �ܼ� â�� �� ������ �� ���� :
	//ContactMain05�� ���� �� ��  initialize();���� ���� ContactDao dao�� ���� ����. �� �� ContactMain05() �������� initialize();�����.
	//ContactDaoImplŬ�������� data ������ ���� �־
	// �̱��� ��ü�� �������� �������� ������ ������ �ִ��� ������ �˻��ؼ�..
	// ContactMain05() �������� initialize();���� ������ window.frame.setVisible(true);�� ���� �ȴٰ�...
	
	private JFrame frame;
	private JButton btnCreate;
	
	private JTable table;// = new JTable();
	
	private DefaultTableModel model; //->? �̰� ����?
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JPanel buttonPanel;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain05 window = new ContactMain05();
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
	public ContactMain05() {
		initialize();//-> UI ������Ʈ��(��ư,���̺�,...)�� �����ϰ� �ʱ�ȭ.
		
		//�޼��� �߰� - ����Ʈ �����´ٰ�
		loadContactData(); // ContactDao�� ����ؼ� ���Ͽ� ����� ����ó �����͸� ���̺� �ε�.
		//ContactDao�� ������ ���̺� row�־��شٰ�..
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���� â Ÿ��Ʋ ����.
		frame.setTitle("����ó v0.5");
		
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		
		btnCreate = new JButton("\uC0C8 \uC5F0\uB77D\uCC98");
//		btnCreate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				ContactCreateFrame.showContactCreateFrame();
//			}
//		});
		
		//���� ǥ�������� �ٲٱ� : �� ����ó Ŭ���� ����. 
		btnCreate.addActionListener((e) ->
		ContactCreateFrame.showContactCreateFrame(frame, ContactMain05.this));//������ J�������� ũ������Ʈ�� �ְڴ� �׷� ũ������Ʈ���� �� ������ â�� 
		//������ J������ ���󰡼� �߰� �ٲٵ��� ���� �� �� ����.
		//ContactMain05.this�� ContactMain05�� �ּҰ� ���� ContactMain05�� ContactCreateFrame�� ����� �������̽� �����ؾ�..
		//ContactMain05.this�� �ǹ� �ڽ�(ContactMain05 ��ü)�� �ּҰ�. �ּҰ� ������ �� �ּҰ��� �ʵ忡 �����ϸ� �� �ʵ��̸�. �ϸ� 
		//ContactMain05�� �ִ� �޼���,�ʵ带 ȣ���� Ŭ�������� ��� ����
		btnCreate.setFont(new Font("����", Font.BOLD, 15));
		buttonPanel.add(btnCreate);
		
		btnUpdate = new JButton("\uC5C5\uB370\uC774\uD2B8");
//		btnUpdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int index = table.getSelectedRow(); //������ ���� ������ -1�� ����
//				if(index == -1) {
//					JOptionPane.showMessageDialog(frame, "������Ʈ �� ���� �������ּ���.", "Update ERROR", JOptionPane.ERROR_MESSAGE);
//				} else {
//					ContactUpdateFrame.showContactUpdateFrame(frame,index,ContactMain05.this);
//				}
//			}
//		});
		
		// ������Ʈ ��ư Ŭ���� ����
		btnUpdate.addActionListener((e) -> updateContact());
		//btnUpdate.addActionListener((e) -> ContactUpdateFrame.showContactUpdateFrame(index)); //->������Ʈ â Ŭ������ �ִ� �޼��� ����
		
	
		
		btnUpdate.setFont(new Font("����", Font.BOLD, 15));
		buttonPanel.add(btnUpdate);
		
		btnDelete = new JButton("\uC0AD\uC81C");
		//���� Ŭ���� ���� - ���Ͽ��� ������ ���� ����ǰ� ȭ�鿡�� �ݿ��� �Ǿ��!
		btnDelete.addActionListener((e) -> deleteContact()); //�̺�Ʈ e�� ���� deleteContact();�޼��带 ȣ�� �ϰڴ�
		
		
		btnDelete.setFont(new Font("����", Font.BOLD, 15));
		buttonPanel.add(btnDelete);
		
		btnSearch = new JButton("\uAC80\uC0C9"); 
		// �˻� ��ư Ŭ���� �����.
		btnSearch.addActionListener((e)->
			ContactSearchFrame.showContactSearchFrame(frame)
				);
//		btnSearch.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnSearch.setFont(new Font("����", Font.BOLD, 15));
		buttonPanel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		
		// ���̺� �÷� ��� �̸��� ��Ʈ ����
		table.getTableHeader().setFont(new Font("����", Font.PLAIN, 17));
		
		// ���̺� ������ ���� ��Ʈ ����
		table.setFont(new Font("����", Font.PLAIN, 17));
		
		//���̺� �� ����(���� ũ��) ����
		table.setRowHeight(30);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
	
	
	private void updateContact() {
		
		 // ���̺��� ������Ʈ�ϱ� ���ؼ� ������ ���� �ε����� ã��. -> getSelectedRow()
		//�� �޼��尡 ����ڰ� ������ ���� ã�� int�� �������ش�
		int index = table.getSelectedRow(); //������ ���� ������ -1�� ����
		if(index == -1) {
			JOptionPane.showMessageDialog(frame, "������Ʈ �� ���� �������ּ���.", "Update ERROR", JOptionPane.ERROR_MESSAGE);
			return;//->������ ���� ���� �� �ش� �޼��� ����.(���̻� �ڵ� ���� ���� �ʵ��� �����Ŵ)
		} 
//		else {
			// ������Ʈ ������(JFrame)�� ����
			//������Ʈ ������(JFrame)�� ���� - ����â���� ������Ʈ â�� û�� �ѱ�.
			ContactUpdateFrame.showContactUpdateFrame(frame,index,ContactMain05.this);
			// �ƱԸ�Ʈ 3��° �ڸ��� �Ķ���� ������ UpdateNotify app�Ǿ��־ UpdateNotify�������̽� Ÿ������ �־� �־�� �ϱ� ������
			// ContactMain05���� UpdateNotify�������̽��� �����ϰ� ������ ContactMain05.this��� ContactMain05��ü�� �ּҸ� �ѱ� �� ����.
			//UpdateNotify�������̽��� �����ϸ� UpdateNotify�������̽����� ����� �߻� �޼��带 �����ؾ� ��(�޼��� ������. �������̵�)
			// �׳���ContactMain05.this��� �� �ѱ�.ContactMain05���� UpdateNotify�� �����ؾ��� ContactMain05.this�� �ƱԸ�Ʈ�� ���� �� ����
//		}
		
		
	}
	
	
	
	private void deleteContact() {
		//���õ� ��(row)�� ã�� 
		int index = table.getSelectedRow();
		
		int confirm = JOptionPane.showConfirmDialog(frame, "���� �����Ͻðڽ��ϱ�?", "���� Ȯ��", JOptionPane.YES_NO_OPTION);
		//YES_NO_OPTION�� ����ڰ� �޼������� yes��ư Ŭ�� �� 0�� ����
		if(confirm == JOptionPane.YES_OPTION) { //yes�� �� ����
			if(index == -1) {//getSelectedRow() ���õ� ���� ���� ��� -1���� �������� 
				JOptionPane.showMessageDialog(frame, "���� ���̺��� ������ ���� �����ϼ���..", "���", JOptionPane.WARNING_MESSAGE);
				return;//���õ� ���� ���� ��� ����Ǹ� �ȵǴϱ� �޼��带 �����Ŵ
			}
			//���� - dao�� ����ؼ� ���õ� ����ó�� �����ϰ�, ���Ͽ� ����
			int result = dao.delete(index);
			//dao������ �����ϰ� �ִ� Ŭ���� ��ü�� ������ �ִ� delete�޼���� ���� �����ϸ� 1, �����ϸ� 0�� ��������. �� ���� ���� result�� ����.
		
			if(result == 1) {// ���� ������ �����
				JOptionPane.showMessageDialog(frame,"���� ����"); //�̰ͺ��� ���� �����Ͻðڽ��ϱ�?? �� �޼��� �߰��ؼ� ��� ����°� �� ���� �Ͱ�����...
			//���� �� �� �ݿ��ؼ� ���̺� ���� �׸���(ȭ�鿡 ���̺� ������ �� �Ⱥ��̰� �ݿ�)
			//���� �ڵ� �ݺ��Ǹ� �޼���� �������� �� �޼��� ȣ��� �ڵ带 �ٲٱ�
				resetTable();//->//���� �� �� �ݿ��ؼ� ���̺� ���� �׸��� ��� �ִ� �޼��� ȣ��.
			
			} else {
			// ���� ���� �˸� �޼���
			}
		}
	}
	
	private void loadContactData() {
		// DAO�� ����ؼ� ���Ͽ� ����� �����͸� �о��.
		// Ÿ���� ����Ʈ�� �о������ �س����� �Ŷ��..
		List<Contact> list = dao.read(); //dao.read()���� ����Ʈ�� ��������
		
		//����Ʈ�� ����ó���� ���̺� ������ �߰�.
		for(Contact c : list) {//dao.read()�� �������� ����Ʈ���� ����ó�� �ϳ��� ������� ������
			Object[] row = {c.getName(), c.getPhone()}; //�࿡ �� �����͸� ����
			model.addRow(row);//�𵨿� �� �߰�
		}
	}
	
	private void resetTable() {
		model = new DefaultTableModel(null,COLUMN_NAMES);
		// ���Ͽ� ����� ����ó(�� ����ó�� �߰��� ������)�� �ε�
		loadContactData();
		// �� ���̺� ���� ���̺� �ٽ� ����
		table.setModel(model);
		
	}
	
	
	@Override//-> ContactCreateFrame.CreateNotify�������̽��� �޼��带 ������(����)
	public void notifyContactCreared() {
		resetTable();
//		//�����͸� ��� ���� ���ο� ���̺� �� ��ü�� ����
//		model = new DefaultTableModel(null,COLUMN_NAMES);
//		// ���Ͽ� ����� ����ó(�� ����ó�� �߰��� ������)�� �ε�
//		loadContactData();
//		// �� ���̺� ���� ���̺� �ٽ� ����
//		table.setModel(model);
//		
		//����ڿ��� �˸�.
		JOptionPane.showMessageDialog(frame, "�� ����ó ���� ����");
	}
	
	@Override //-> ContactUpdateFrame���� ����ó ������ ���������� ������Ʈ �ϸ� ȣ���ϴ� �޼���
	public void notifyContactUpdate() {
		//���ο��� ���̴� ���(���̺�)�� ������Ʈ �Ȱɷ� ����������
		// ���̺긦 ���� �׸�(����)
		resetTable();
		JOptionPane.showMessageDialog(frame, "����ó ������Ʈ ����");
		
		
		
	}


}
