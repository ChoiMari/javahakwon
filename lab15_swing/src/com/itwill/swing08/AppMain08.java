package com.itwill.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {
	//상수 정의 - 컬럼이름으로 사용하려고 만듬.
	private static final String[] COLUMN_NAMES = {"국어","영어","수학","총점","평균"};

	private JFrame frame;
	private JLabel lblKorean;
	private JTextField textKorean;
	private JTextField textEnlish;
	private JTextField textMath;
	private JLabel lblMath;
	private JLabel lblEnglish;
	private JScrollPane scrollPane;
	private JTable table;
	
	//필드 선언 - 테이블 모델..? 이니셜라이즈 테이블 만들어진 부분으로 가서 이용한다함
	private DefaultTableModel model; //->
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain08 window = new AppMain08();//AppMain08 생성자 호출하면서 AppMain08 객체 생성
					window.frame.setVisible(true);//프레임 화면에 보여지게 하는 코드.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국어");
		lblKorean.setFont(new Font("굴림", Font.PLAIN, 30));
		lblKorean.setBounds(12, 10, 111, 55);
		frame.getContentPane().add(lblKorean);
		
		textKorean = new JTextField();
		textKorean.setFont(new Font("굴림", Font.PLAIN, 23));
		textKorean.setBounds(135, 10, 287, 55);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		textEnlish = new JTextField();
		textEnlish.setFont(new Font("굴림", Font.PLAIN, 23));
		textEnlish.setColumns(10);
		textEnlish.setBounds(135, 75, 287, 55);
		frame.getContentPane().add(textEnlish);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setFont(new Font("굴림", Font.PLAIN, 30));
		lblEnglish.setBounds(12, 75, 111, 55);
		frame.getContentPane().add(lblEnglish);
		
		textMath = new JTextField();
		textMath.setFont(new Font("굴림", Font.PLAIN, 23));
		textMath.setColumns(10);
		textMath.setBounds(135, 140, 287, 55);
		frame.getContentPane().add(textMath);
		
		lblMath = new JLabel("수학");
		lblMath.setFont(new Font("굴림", Font.PLAIN, 30));
		lblMath.setBounds(12, 140, 111, 55);
		frame.getContentPane().add(lblMath);
		
		JButton btnEnter = new JButton("입력");
		btnEnter.addActionListener(new ActionListener() { //입력 버튼 클릭시 실행 - 자바가상머신이 알아서 호출해서 실행시킴.
			public void actionPerformed(ActionEvent e) {
				inputScoreToTable();
			}
		});
		btnEnter.setBounds(12, 205, 173, 37);
		frame.getContentPane().add(btnEnter);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 252, 408, 225);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(); //테이블 생성
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		
		table.setModel(model);
		
		//맘에 안드신다고 위에 상수,필드 선언하고 바꿈. table.setModel(model);으로
		//상수 정의 - 컬럼이름으로 사용하려고 만듬.
//		private static final String[] COLUMN_NAMES = {"국어","영어","수학","총점","평균"};
		//필드 선언 - 테이블 모델..? 이니셜라이즈 테이블 만들어진 부분으로 가서 이용한다함
//		private DefaultTableModel model;
		
		//이 아래 코드가 원래 스윙에서 만들어 준 것.
//		table.setModel(new DefaultTableModel( // DefaultTableModel의 생성자 호출하면서  DefaultTableModel의 객체 생성.
//				//DefaultTableModel(Object[][] data, Object[] columnNames) - 2개의 배열이 아규먼트로 들어 간 것.
//			new Object[][] {  //DefaultTableModel생성자의 아규먼트 2개. Object[][] - 테이블이 들어갈 데이터 행,열 필요해서 2차원 배열로 되어있음.
//				
//			},
//			new String[] { // String[] - 컬럼(열) 이름. 5개만 주면 되서 1차원 배열
//				"New column", "New column", "New column", "New column", "New column"
//			}
//		));
		
		scrollPane.setViewportView(table); //테이블을 스크롤의 뷰포트 부분에 집어넣음 그래서 화면에 보임
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteScoreFromTable();
				
			}
		});
		btnDelete.setBounds(247, 205, 173, 37);
		frame.getContentPane().add(btnDelete);
	}

	private void deleteScoreFromTable() {
		//삭제 기능 시나리오
		// JTable에서 선택된 행의 인덱스를 찾음.
		int index = table.getSelectedRow();//->getSelectedRow()메서드 테이블에서 선택된 행의 인덱스 값(int)을 리턴해줌. 그 리턴값을 int타입의 index에 저장
		//-> getSelectedRow()메서드는 테이블에서 행에 아무것도 선택 하지 않은 경우는 -1을 리턴.
		
		if(index == -1) { //테이블에서 선택된 행이 없을 때 true 실행됨.
			JOptionPane.showMessageDialog(frame, "삭제할 행을 선택하세요", "경고", JOptionPane.WARNING_MESSAGE);
			return;// 삭제할 행이 선택되지 않은 상태니까 메서드 종료시킴.
		}
		//바로 지워버리게 하지 않고 삭제 하기 전에 물어보기
		// 삭제 하시겠습니까? 이런 창 뜨게.
		//컨펌다이얼로그 추가
		//삭제 여부를 사용자에게 확인
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제 하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		//showConfirmDialog메서드 리턴타입 int여서 int타입으로 변수 선언해서 초기화함.
		
		if(confirm == JOptionPane.YES_OPTION) {//JOptionPane.YES_OPTION -> yes 버튼 클릭시 0을 리턴해 줌
			System.out.println(JOptionPane.YES_OPTION);
			model.removeRow(index);//해당 테이블(모델)에서 인덱스의 행(row)을 삭제
		}
		
		
	}

	private void inputScoreToTable() {
		//1. JTextField에서 3과목의 점수를 읽음(try-chatch필요하다고 함)
		int korean = 0;
		int englisg = 0;
		int math = 0;
		try {
			korean = Integer.parseInt(textKorean.getText());
			englisg = Integer.parseInt(textEnlish.getText());
			math = Integer.parseInt(textMath.getText());
			
		} catch(NumberFormatException e) { 
			//메시지 다이얼 로그 띄우기 - 그리고 리턴하면 된다고..??
			//정수로 입력하세요 이런 메세지창 띄우게 만들라고.. 경고창.
			JOptionPane.showConfirmDialog(
					frame,  //-> showConfirmDialog을 창을 어떤 창 위치에 띄울 건지 Component parentComponent 설정.
					"국어, 영어, 수학 점수는 정수로 입력하세요.", //보여지는 메세지 문구
					"입력 오류", //-> 메세지 창 윗쪽 바에 들어갈 타이틀 문구
					JOptionPane.CLOSED_OPTION, //-> 메세지 버튼 개수
					JOptionPane.ERROR_MESSAGE);//-> 메세지에 보여지는 아이콘
			return; //->try{}코드 실행 중 예외 발생시 return만나게 해서 해당 메서드 종료시킴 (inputScoreToTable()메서드 종료)
			//->아래있는 코드 실행 안 시키기 위해서
		}
		//2. Score타입 객체를 생성
		Score score = new Score(korean,englisg,math);
		
		//3. JTable에 행(row)를 추가 - 행 추가하는 메서드를 추가해서 여기서 호출하게 만든다고.
		Object[] row = { //addRow(Object[] rowData)자리에 아규먼트로 줄 행의 1차원 배열 만듬.
				score.getKorean(),
				score.getEnglish(),
				score.getMath(),
				score.getTotal(),
				score.getMean()
		};
		model.addRow(row);
		//-> void javax.swing.table.DefaultTableModel.addRow(Object[] rowData)
		
		//4. JTextField의 내용을 모두 지운다.
		 clearAllTextFields();
		
	}
	
	private void clearAllTextFields() { ////4. JTextField의 내용을 모두 지운다.는 메서드
		textKorean.setText(""); //문자열을 ""로 만들어서 지워지게 보여지도록 만드는 것. null로 만들면 null이 보여진다고 해서 ""로 바꿔야 함.
		textEnlish.setText("");
		textMath.setText("");
	}
	
	
}
