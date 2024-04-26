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

	//클래스 ContactSearchFrame에 있는
	// showContactUpdateFrame()메서드가 호출 될 때 불러주는 곳에서 부모컴포넌트를 아규먼트로 넘겨받아 창띄우는데 쓰려고
	// 그 아규먼트 저장해서 쓰려고 필드 선언
	private Component parentComponent;
	
	private static final String[] COLUMN_NAMES = {"이름","전화번호","이메일"};
	
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
		setTitle("연락처 검색");//-> 창에 뜨는 타이틀 메세지 
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//창뜨는 위치 설정
		int x = 0;
		int y = 0;
		if(parentComponent !=null) {
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 450, 300);
		
		if(parentComponent == null) {
			setLocationRelativeTo(null);// 화면 중앙에 배치 하겠다.
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		contentPane.add(headerPanel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("굴림", Font.PLAIN, 20));
		headerPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.addActionListener((e)->searchByKeyeord());
		
//		btnSearch.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		
		
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 20));
		headerPanel.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		
		// 테이블 컬럼 목록 이름의 폰트 설정
		table.getTableHeader().setFont(new Font("굴림", Font.PLAIN, 17));
		
		// 테이블 데이터 행의 폰트 설정
		table.setFont(new Font("굴림", Font.PLAIN, 17));
		
		//테이블 행 높이(세로 크기) 설정
		table.setRowHeight(30);
		
		model = new DefaultTableModel(null,COLUMN_NAMES);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
	}
	
	private void searchByKeyeord(){ // 검색 버튼 클릭시 호출 됨.
		//검색어 읽음
		String keyword = textField.getText();
		
		//dao을 사용해서 검색어로 검색 결과를 가져옴
		List<Contact> list = dao.search(keyword);
				
		//검색 결과를 테이블에 씀.
		
		//데이터 지움
		model = new DefaultTableModel(null,COLUMN_NAMES);
		
		
		// 비워진 테이블 모델에 검색 결과만 행으로 추가
		for(Contact c : list) {
			Object[] row = {c.getName(),c.getPhone(),c.getEmail()}; //addRow메서드의 파라미터 선언이 오브젝트 배열 타입.
			model.addRow(row);
		}
		
		//테이블에 테이블 모델을 다시 세팅
		table.setModel(model);
				
				
				
	}

}
