package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JRadioButton rbPackage;
	private JRadioButton rbPrivate;
	private JRadioButton rbProtected;
	private final ButtonGroup buttonGroup = new ButtonGroup(); //버튼 그룹 final로 만들어짐 변동되지 않도록.
	private JRadioButton rdPublic;
	private JCheckBox cbFinal;
	private JCheckBox cbAbstract;
	private JCheckBox cbStatic;
	//private JComboBox comboBox;
	private JComboBox<String> comboBox;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton btnInfo;
	
	private JRadioButton selectedRadioButton;
	private ArrayList<JCheckBox> selectedCheckBoxes = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 419, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rbPrivate = new JRadioButton("private"); //라디오 버튼을 만든다
		rbPrivate.addActionListener(new ActionListener() { //사용자가 Private 라디오 버튼을 클릭할 때 자바가상머신이 자동으로 호출해서 실행됨.
			public void actionPerformed(ActionEvent e) {
				//오버라이드 - ActionListener()인터페이스를 내부 익명클래스로 구현하면서 
				//ActionListener()인터페이스에 있는 메서드를 오버라이드
				handleRadioButtonClick(e); 
				//->체크된 버튼 마다 하나의 메서드안에서 처리 할거라서 ActionEvent e를 알아야 처리 가능해서 메서드의 아규먼트로 e 넘겨줌
			}
		});
		rbPrivate.setSelected(true);
		buttonGroup.add(rbPrivate); // 만든 버튼을 라디오 버튼 그룹에 추가한다.
		rbPrivate.setFont(new Font("굴림", Font.PLAIN, 12));
		rbPrivate.setBounds(8, 6, 86, 46);
		frame.getContentPane().add(rbPrivate);
		
		rbPackage = new JRadioButton("package");
		rbPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e); 
		}
	});
		
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("굴림", Font.PLAIN, 12));
		rbPackage.setBounds(98, 6, 86, 46);
		frame.getContentPane().add(rbPackage);
		
		rbProtected = new JRadioButton("protected");
		rbProtected.addActionListener((e)-> handleRadioButtonClick(e));
		
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("굴림", Font.PLAIN, 12));
		rbProtected.setBounds(188, 6, 86, 46);
		frame.getContentPane().add(rbProtected);
		
		rdPublic = new JRadioButton("public");
		rdPublic.addActionListener(this::handleRadioButtonClick);
		//rdPublic.addActionListener(AppMain06.this::handleRadioButtonClick);
		//this는 AppMain06객체 주소(힙공간에 생성된 객체의 참조값)
		buttonGroup.add(rdPublic);
		rdPublic.setFont(new Font("굴림", Font.PLAIN, 12));
		rdPublic.setBounds(278, 6, 86, 46);
		frame.getContentPane().add(rdPublic);
		
		cbAbstract = new JCheckBox("abstract");
		
		cbAbstract.addActionListener(new ActionListener() { //cbAbstract 체크박스 클릭시 자바가상머신이 호출해서 실행
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e); 
		}
	});
		
		
		cbAbstract.setBounds(8, 51, 127, 35);
		frame.getContentPane().add(cbAbstract);
		
		cbFinal = new JCheckBox("final");
		//람다 표현식 
		cbFinal.addActionListener((e) -> handleCheckBoxClick(e));
		
		cbFinal.setBounds(139, 54, 127, 35);
		frame.getContentPane().add(cbFinal);
		
		cbStatic = new JCheckBox("static");
		//메서드 참조 람다
		cbStatic.addActionListener(this::handleCheckBoxClick);
		
		cbStatic.setBounds(270, 54, 127, 35);
		frame.getContentPane().add(cbStatic);
		
		
		//comboBox = new JComboBox(); //콤보박스 생성
		comboBox = new JComboBox<>(); // new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			//오버라이드
			public void actionPerformed(ActionEvent e) {
				handleComboBoxChange(e);
			}
		});
		//setModel의 아규먼트로 new DefaultComboBoxModel 모델 객체 만들고 
		// 그 객체의 아규먼트로 new String[]문자열 배열을 만들고 
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "kakao.com", "yahoo.com"}));
		//->이거 대신에 코드를 밑에 코드로 바꿈.
		final String[] emails = {"naver.com", "gmail.com", "kakao.com", "yahoo.com"};//문자열들을 저장하는 배열 = {}; 만들고 초기화
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(emails);
		//comboBox.setModel(new DefaultComboBoxModel<>(emails));
		comboBox.setModel(model);
		
		comboBox.setBounds(8, 92, 262, 35);
		frame.getContentPane().add(comboBox);
		
		btnInfo = new JButton("확인");
//		btnInfo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		}); //->람다 표현식으로 만들기
		//확인버튼 클릭 시 기능
		btnInfo.addActionListener((e) -> handleButtonClick());
		
		
		btnInfo.setFont(new Font("굴림", Font.PLAIN, 20));
		btnInfo.setBounds(280, 92, 106, 35);
		frame.getContentPane().add(btnInfo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 137, 378, 145);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(textArea);
	}

	private void handleButtonClick() {
		// 문자열 붙여 나갈 때 편리한 클래스 -> StringBuffer클래스.java.lang에 있어서 import필요 없다.
		//제이텍스트에리어에 출력할 문자열듫을 붙여 나갈(append) 문자열 버퍼 .append()메서드로 계속 붙여나가면 된다고..
		StringBuffer buffer = new StringBuffer();

		//어떤 라디오 버튼이 선택 되었는지 보여지게.
		if(rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText());//선택된 라디오버튼을 버퍼에 append하겠다.
		} else if(rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		} else if(rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		}  else {
			buffer.append(rdPublic.getText());
		}
		buffer.append(" 라디오 버튼 선택됨.\n");
		
		//문자열 버퍼의 내용을 JtextArea에 씀
		//textArea.setText(buffer); //문법 에러-> setText는 아규먼트 String만 됨. buffer는 String이 아님.
		//해결
		textArea.setText(buffer.toString());

		//어떤 체크박스들이 선택 됐는 지 -> 중복 선택 할 수 가 있음 그래서 else if안됨 다 별개의 if로 해야..!!
		// 체크박스 선택 개수만큼 if문 실행 된다. 예)Abstract,Final 체크박스 클릭시 if문 2개 실행.
		if(cbAbstract.isSelected()) { //Abstract체크박스 클릭시 true되면서 실행됨.
			buffer.append(cbAbstract.getText()).append(" ");//선택된 라디오버튼을 버퍼에 append하겠다.
			
		} 
		if(cbFinal.isSelected()) {//Fina체크박스 클릭시 true되면서 실행됨.
			buffer.append(cbFinal.getText()).append(" ");
			
		} 
		if(cbStatic.isSelected()) {//StaticFina체크박스 클릭시 true되면서 실행됨.
			buffer.append(cbStatic.getText()).append(" ");//중복체크하면 이름 따닥따닥 붙으니까 방지용으로 .append(" ")추가함.
		} 
		buffer.append(" 체크박스 선택됨.\n"); //->아무것도 체크박스에서 선택 안하면 이 코드만 실행됨.
	
		
		//콤보 박스에서 선택된 아이템이 무엇인 지 
		Object selectedItem = comboBox.getSelectedItem(); //buffer.append가 오브젝트타입으로 리턴해주는게있어서(오버로딩)
		buffer.append(selectedItem).append(" 콤보박스 아이템 선택됨.\n");
		//문자열 버퍼의 내용을 텍스트에리어에 씀
		textArea.append(buffer.toString());
	}

	private void handleComboBoxChange(ActionEvent e) {
		//이벤트가 발생한 컴포넌트(JComboBox) 찾기
		JComboBox<String> combo = (JComboBox<String>) e.getSource();
		
		//콤보박스에서 선택된 아이템 찾기(콤보박스에서 무엇을 선택했는지)
		int index = combo.getSelectedIndex(); //콤보 박스에서 선택된 아이템의 인덱스 - 0부터 시작
		String item = (String) combo.getSelectedItem();//getSelectedItem()메서드의 리턴 타입이 오브젝트라서 강제변환 가능.
		//-> 콤보박스에서 선택된 아이템
		
		//JtextArea에 정보 출력
		textArea.setText(index + ": " + item);
	}

	private void handleCheckBoxClick(ActionEvent e) {
		//3개의 체크 박스들 중에서 누가 클릭 되었는 지 텍스트 에리어에 보여지게 만드는 코드
		 JCheckBox cb = (JCheckBox) e.getSource(); //getSource()는 사용자가 창에서 클릭한 곳의 정보를 오브젝트값으로 리턴 받아서
		 // (JCheckBox)타입으로 강제변환-> 다형성. 해서 변수 cb에 저장함
		 String text = cb.getText(); // 사용자가 창에서 클릭한 곳의 정보를 getText()를 이용해서 text로 바꿈. 그걸 밑의 코드에서 textArea에 보여지게 함.
		 boolean selected = cb.isSelected();
		 textArea.setText(text + ": " + selected + "\n"); //선택 내용이 쌓이면서 보여지게 만듬.
		 
	}

	private void handleRadioButtonClick(ActionEvent e) {
		//4개의 라디오 버튼 중에서 어떤 버튼이 클릭 됐는 지 텍스트에리어에 보여지는 코드.
		JRadioButton rb = (JRadioButton) e.getSource(); //강제 변환(casting)함
		//getSource()메소드는 오브젝트를 리턴해서.. 강제변환 한 것
		//좀 위험한 코드라고 함.근데 라디오 버튼에서 호출 될 것이라서 별 문제 안된다고..
		
		String text = rb.getText();
		boolean selected = rb.isSelected();//보통 메서드가 is로 시작하면 리턴 타입이 boolean인 경우라고 함.
		//-> 이벤트가 발생한 라디오 버튼의 선택 여부.
		// 실행시 클릭 할 때 마다 어떤 버튼이 선택 되었는지 textArea에 보여짐.
		//private라디오 박스 클릭하면 textArea에 private: true 이렇게 뜸.
		textArea.setText(text + ": " + selected);
		
	}
}
