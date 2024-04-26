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

	//상수 선언 - DefaultTableModel생성할 때 사용할 거라고 함
	private static final String[] COLUMN_NAMES = {"이름", "전화번호"};
	
	//필드 선언 - 데이터 폴더가 이미 있습니다... 실행 시 콘솔창에 이 문구가 뜸.
	private ContactDao dao = ContactDaoImpl.getInstance();
	//-> 콘솔 창에 이 문구가 뜬 이유 :
	//ContactMain05가 생성 될 때  initialize();실행 전에 ContactDao dao에 값이 저장. 그 후 ContactMain05() 생성자의 initialize();실행됨.
	//ContactDaoImpl클래스에서 data 폴더가 남아 있어서
	// 싱글턴 객체를 가져오는 과정에서 데이터 폴더가 있는지 없는지 검사해서..
	// ContactMain05() 생성자의 initialize();실행 끝나면 window.frame.setVisible(true);이 실행 된다고...
	
	private JFrame frame;
	private JButton btnCreate;
	
	private JTable table;// = new JTable();
	
	private DefaultTableModel model; //->? 이게 뭐지?
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
		initialize();//-> UI 컴포넌트들(버튼,테이블,...)을 생성하고 초기화.
		
		//메서드 추가 - 컨텍트 가져온다고
		loadContactData(); // ContactDao를 사용해서 파일에 저장된 연락처 데이터를 테이블에 로딩.
		//ContactDao만 있으면 테이블에 row넣어준다고..
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//메인 창 타이틀 설정.
		frame.setTitle("연락처 v0.5");
		
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		
		btnCreate = new JButton("\uC0C8 \uC5F0\uB77D\uCC98");
//		btnCreate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				ContactCreateFrame.showContactCreateFrame();
//			}
//		});
		
		//람다 표현식으로 바꾸기 : 새 연락처 클릭시 실행. 
		btnCreate.addActionListener((e) ->
		ContactCreateFrame.showContactCreateFrame(frame, ContactMain05.this));//메인의 J프레임을 크리에이트를 주겠다 그럼 크리에이트에서 그 정보로 창을 
		//메인의 J프레임 따라가서 뜨게 바꾸도록 설정 할 수 있음.
		//ContactMain05.this은 ContactMain05의 주소값 보냄 ContactMain05이 ContactCreateFrame에 선언된 인터페이스 구현해야..
		//ContactMain05.this의 의미 자신(ContactMain05 객체)의 주소값. 주소값 보내면 이 주소값을 필드에 저장하면 그 필드이름. 하면 
		//ContactMain05에 있는 메서드,필드를 호출한 클래스에서 사용 가능
		btnCreate.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(btnCreate);
		
		btnUpdate = new JButton("\uC5C5\uB370\uC774\uD2B8");
//		btnUpdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int index = table.getSelectedRow(); //선택한 행이 없으면 -1을 리턴
//				if(index == -1) {
//					JOptionPane.showMessageDialog(frame, "업데이트 할 행을 선택해주세요.", "Update ERROR", JOptionPane.ERROR_MESSAGE);
//				} else {
//					ContactUpdateFrame.showContactUpdateFrame(frame,index,ContactMain05.this);
//				}
//			}
//		});
		
		// 업데이트 버튼 클릭시 실행
		btnUpdate.addActionListener((e) -> updateContact());
		//btnUpdate.addActionListener((e) -> ContactUpdateFrame.showContactUpdateFrame(index)); //->업데이트 창 클래스에 있는 메서드 띄우기
		
	
		
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(btnUpdate);
		
		btnDelete = new JButton("\uC0AD\uC81C");
		//삭제 클릭시 실행 - 파일에도 삭제된 내용 저장되고 화면에도 반영이 되어야!
		btnDelete.addActionListener((e) -> deleteContact()); //이벤트 e가 오면 deleteContact();메서드를 호출 하겠다
		
		
		btnDelete.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(btnDelete);
		
		btnSearch = new JButton("\uAC80\uC0C9"); 
		// 검색 버튼 클릭시 실행됨.
		btnSearch.addActionListener((e)->
			ContactSearchFrame.showContactSearchFrame(frame)
				);
//		btnSearch.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnSearch.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		
		// 테이블 컬럼 목록 이름의 폰트 설정
		table.getTableHeader().setFont(new Font("굴림", Font.PLAIN, 17));
		
		// 테이블 데이터 행의 폰트 설정
		table.setFont(new Font("굴림", Font.PLAIN, 17));
		
		//테이블 행 높이(세로 크기) 설정
		table.setRowHeight(30);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
	
	
	private void updateContact() {
		
		 // 테이블에서 업데이트하기 위해서 선택한 행의 인덱스를 찾음. -> getSelectedRow()
		//이 메서드가 사용자가 선택한 행을 찾아 int로 리턴해준다
		int index = table.getSelectedRow(); //선택한 행이 없으면 -1을 리턴
		if(index == -1) {
			JOptionPane.showMessageDialog(frame, "업데이트 할 행을 선택해주세요.", "Update ERROR", JOptionPane.ERROR_MESSAGE);
			return;//->선택한 행이 없을 시 해당 메서드 종료.(더이상 코드 진행 되지 않도록 종료시킴)
		} 
//		else {
			// 업데이트 프레임(JFrame)을 실행
			//업데이트 프레임(JFrame)을 실행 - 메인창에서 업데이트 창의 청보 넘김.
			ContactUpdateFrame.showContactUpdateFrame(frame,index,ContactMain05.this);
			// 아규먼트 3번째 자리에 파라미터 선언이 UpdateNotify app되어있어서 UpdateNotify인터페이스 타입으로 넣어 주어야 하기 때문에
			// ContactMain05번이 UpdateNotify인터페이스를 구현하고 있으면 ContactMain05.this라고 ContactMain05객체의 주소를 넘길 수 있음.
			//UpdateNotify인터페이스를 구현하면 UpdateNotify인터페이스에서 선언된 추상 메서드를 구현해야 함(메서드 재정의. 오버라이드)
			// 그냥은ContactMain05.this라고 못 넘김.ContactMain05에서 UpdateNotify를 구현해야지 ContactMain05.this를 아규먼트로 넣을 수 있음
//		}
		
		
	}
	
	
	
	private void deleteContact() {
		//선택된 행(row)를 찾고 
		int index = table.getSelectedRow();
		
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		//YES_NO_OPTION는 사용자게 메세지에서 yes버튼 클릭 시 0을 리턴
		if(confirm == JOptionPane.YES_OPTION) { //yes일 때 실행
			if(index == -1) {//getSelectedRow() 선택된 행이 없는 경우 -1값을 리턴해줌 
				JOptionPane.showMessageDialog(frame, "먼저 테이블에서 삭제할 행을 선택하세요..", "경고", JOptionPane.WARNING_MESSAGE);
				return;//선택된 행이 없는 경우 실행되면 안되니까 메서드를 종료시킴
			}
			//삭제 - dao를 사용해서 선택된 연락처를 삭제하고, 파일에 저장
			int result = dao.delete(index);
			//dao변수가 저장하고 있는 클래스 객체가 가지고 있는 delete메서드는 삭제 성공하면 1, 실패하면 0를 리턴해줌. 그 리턴 값을 result에 저장.
		
			if(result == 1) {// 삭제 성공시 실행됨
				JOptionPane.showMessageDialog(frame,"삭제 성공"); //이것보다 정말 삭제하시겠습니까?? 이 메세지 뜨게해서 기능 만드는게 더 좋을 것같은데...
			//삭제 된 것 반영해서 테이블 새로 그리기(화면에 테이블 삭제된 거 안보이게 반영)
			//같은 코드 반복되면 메서드로 뺴버리고 다 메서드 호출로 코드를 바꾸기
				resetTable();//->//삭제 된 것 반영해서 테이블 새로 그리기 기능 있는 메서드 호출.
			
			} else {
			// 삭제 실패 알림 메세지
			}
		}
	}
	
	private void loadContactData() {
		// DAO를 사용해서 파일에 저장된 데이터를 읽어옴.
		// 타입은 리스트로 읽어오도록 해놓았을 거라고..
		List<Contact> list = dao.read(); //dao.read()에서 리스트를 리턴해줌
		
		//리스트의 연락처들을 테이블에 행으로 추가.
		for(Contact c : list) {//dao.read()이 리턴해준 리스트에서 연락처를 하나씩 순서대로 꺼내서
			Object[] row = {c.getName(), c.getPhone()}; //행에 들어갈 데이터를 만듬
			model.addRow(row);//모델에 행 추가
		}
	}
	
	private void resetTable() {
		model = new DefaultTableModel(null,COLUMN_NAMES);
		// 파일에 저장된 연락처(새 연락처가 추가된 데이터)를 로딩
		loadContactData();
		// 새 테이블 모델을 테이블에 다시 세팅
		table.setModel(model);
		
	}
	
	
	@Override//-> ContactCreateFrame.CreateNotify인터페이스의 메서드를 재정의(구현)
	public void notifyContactCreared() {
		resetTable();
//		//데이터를 모두 지운 새로운 테이블 모델 객체를 생성
//		model = new DefaultTableModel(null,COLUMN_NAMES);
//		// 파일에 저장된 연락처(새 연락처가 추가된 데이터)를 로딩
//		loadContactData();
//		// 새 테이블 모델을 테이블에 다시 세팅
//		table.setModel(model);
//		
		//사용자에게 알림.
		JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공");
	}
	
	@Override //-> ContactUpdateFrame에서 연락처 정보를 성공적으로 업데이트 하면 호출하는 메서드
	public void notifyContactUpdate() {
		//메인에서 보이는 목록(테이블)이 업데이트 된걸로 보여지도록
		// 테이브를 새로 그림(리셋)
		resetTable();
		JOptionPane.showMessageDialog(frame, "연락처 업데이트 성공");
		
		
		
	}


}
