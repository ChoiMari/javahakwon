package com.itwill.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//메시지 다이얼로그 보여주기
				//JOptionPane.showMessageDialog(frame, "안녕하세요"); //->창에 뜨는 메세지를 보여주는 다이얼로그 메서드 showMessageDialog();
				//showMessageDialog(Component parentComponent, Object message)
				//frame-창 전체Jframe타입의 필드이름 frame 이걸 부모컴포넌트로 하겠다. (다형성이라고) - 상속관계 보면 넣을 수 있음
				//Jframe이 Component를 상속받음.
				//frame은 Jframe타입인데 Component타입 파라미터 선언자리에 아규먼트로 넣을 수 있으니까.
				//Object message - 아규먼트로 "안녕하세요"를 넣음
				
				JOptionPane.showConfirmDialog(frame, //버튼 클릭 시 부모 컴포넌트 위에 창이 뜸
						"안녕하세요, Swing" ,//->뜨는 창에 보여줄 메세지 문구 //다이얼로그 메세지
						"메세지",// ->창 타이틀에 뜰 문구 //다이얼로그 타이틀(제목)
						JOptionPane.INFORMATION_MESSAGE);//->화면에 보여지는 메세지가 무슨 타입인지 int로 주라고.  //메세지 타입
						//이런 경우 대부분 public final 상수 찾아서 넣으라고 메서드 설명 박스에 써있음
						//그런 상수 JOptionPane클래스가 가지고 있다고 함.
						// 그래서 JOptionPane. 하고 찾아서 쓰면 됨.
						//메세지 타입은 메시지 아이콘이 달라짐.
						//메세지 타입에 따라서 스윙에서 기본으로 창에 보여지는 아이콘이 제공 되는데
						//맘에 안들면 아이콘 이미지를 만들어서 5번째 아규먼트로 넣으면 된다고..
						//응용-> 계산기프로그램 숫자가 입력안되었습니다. 이렇게 창이 뜨게 해서 보여지게
			}
		});
		btnMsgDlg.setBounds(12, 25, 410, 44);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("Confirm Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Confirm(확인) 다이얼로그 보여주기
				//int result = JOptionPane.showConfirmDialog(frame, "정말 삭제 할까요?"); //리턴값int 이 있는 메서드
				int result = JOptionPane.showConfirmDialog(
						frame, //부모 컴포넌트
						"정말 삭제할까요?", // 메세지
						"삭제 확인",// 타이틀
						JOptionPane.YES_NO_OPTION, //창의 버튼 종류와 개수 - 옵션 타입 
						JOptionPane.QUESTION_MESSAGE);// 메세지 타입(창에 뜨는 아이콘 고르는 것)
				
				
				btnConfirmDlg.setText("confirm = " + result); //버튼클릭했을 때 뜨는 창 yes,no,cancle 클릭했을 때 따라서 버튼 text가 변함.
				//실제로는 리턴 값에 따라서 그 리턴 값보고 사용자가 누른 버튼 알아내서 기능 만든다고..
			}
		});
		btnConfirmDlg.setBounds(12, 79, 410, 44);
		frame.getContentPane().add(btnConfirmDlg);
		
		
		btnInputDlg = new JButton("Input Dialog");
		//3번째 버튼 Input Dialog 클릭시 기능 추가
		btnInputDlg.addActionListener(new ActionListener() {
			//오버라이드
			public void actionPerformed(ActionEvent e) {
				//입력 다이어로그 보여주기
				final String[] selections = {"인*","얼굴장부","X","너튜브"}; //final로 안 바뀌도록 고정.
				Object result = JOptionPane.showInputDialog(
						frame, //부모 컴포넌트
						"검색어 입력", //창에 뜨는 메세지
						"검색어",// 창 위에 뜨는 타이틀 메세지
						JOptionPane.PLAIN_MESSAGE,//메세지 타입(창에 메시지랑 같이 뜨는 아이콘 설정) //PLAIN_MESSAGE 아이콘 없음
						null,// 아이콘이 없으면 null
						selections,// 선택할 값들 - Object[] selectionValues
						selections[1]);//초기 선택값..?->  Object[] selectionValues 중에서 선택해야 된다고..
				// Object[] selectionValues 자리가 null이 아닐 때.
			}
		});
		
		btnInputDlg.setBounds(12, 133, 410, 44);
		frame.getContentPane().add(btnInputDlg);
		
		btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			//오버라이드 -ActionListener() 인터페이스 구현
			public void actionPerformed(ActionEvent e) {
				//내가 만든 다이얼로그 보여주기
				MyDialog.ShowMyDialog(); //->창이 뜨는 지정된 위치(부모컨포넌트) 설정 안해서 다이얼로그 좌표 위치 에서 창이 뜸.
				//MyDialog.java파일 코드에 setBounds(100, 100, 450, 300); 여기 x,y좌표 위치에 창이 뜸.
				//setBounds(100, 100, 450, 300)의 위치 무시 하고 항상 스크린 가운데 뜨게 할 수도 있음.
				//setBounds(100, 100, 450, 300);좌표 무시하고 항상 스크린의 가운데에 위치하도록 하는 코드
				//setLocationRelativeTo(null);를 추가(setBounds(100, 100, 450, 300);는 삭제하면 안됨)
			}
		});
		btnCustomDlg.setBounds(12, 187, 410, 44);
		frame.getContentPane().add(btnCustomDlg);
	}
}
