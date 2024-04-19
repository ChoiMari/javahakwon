package com.itwill.swing07;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itwill.swing07.MyFrame.Notifiable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 implements Notifiable {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnMyFrame;
	
	//마이 프레임에서 Notifiable이라는 인터페이스 만들고 public class AppMain07 implements Notifiable 하도록 만들었기 때문에
	// 이제 이게 Notifiable에 있는  notifyMessage 메서드를 오버라이드 하게 된 것.
	public void notifyMessage(String message) { // MyFrame에서 호출 되도록 만듬.
		//-> 근데 MyFrame에서 호출하려면 객체 생성 필요함. AppMain07 app = new AppMain07(); 해서 app.이렇게
		// 근데 이거 안된다고 함... 왜냐면 new할 때마다 새로 객체 생성하기 때문에...
		// AppMain07실행 중에 객체생성하면 새로 만들어지는 AppMain07객체한테 정보 넘겨준다고..??
		// 새로운 객체 AppMain07가 아니라 자기를 띄워준 AppMain07객체를 이용해야 된다고..
		//자기를 띄워준 AppMain07객체의 주소를 알아야 한다고...
		//해결 방법 : MyFrame.showMyFrame(frame,AppMain07.this); 호출할 때 띄워준 AppMain07.this객체의 주소를 아규먼트로 넘겨줌.
		
		//마이프레임에서 notifyMessagea메서드를 호출 할 때 넘겨받은 아규먼트 값으로 버튼에 메세지가 보여지게 함.
		btnMyFrame.setText(message); // 누군가notifyMessage(String message)메서드를 호출 할 때 btnMyFrame에.setText(message);하겠다
	}

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
		frame.setBounds(100, 100, 450, 357);
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
				//MyDialog.ShowMyDialog(); //->창이 뜨는 지정된 위치(부모컨포넌트) 설정 안해서 다이얼로그 좌표 위치 에서 창이 뜸.
				//MyDialog.java파일 코드에 setBounds(100, 100, 450, 300); 여기 x,y좌표 위치에 창이 뜸.
				//setBounds(100, 100, 450, 300)의 위치 무시 하고 항상 스크린 가운데 뜨게 할 수도 있음.
				//setBounds(100, 100, 450, 300);좌표 무시하고 항상 스크린의 가운데에 위치하도록 하는 코드
				//setLocationRelativeTo(null);를 추가(setBounds(100, 100, 450, 300);는 삭제하면 안됨)
				MyDialog.ShowMyDialog(frame);//->frame을 아규먼트로 넘겨서 호출. -> 부모컨포넌트 주는 것
				//커스텀 다이얼로그 버튼 눌렀을 때 창을 frame창 따라가면서 뜨게 설정하기 위해서.
				//-> 마이다이얼로그로 ShowMyDialog(){...}로 가서 파라미터 선언 넣기
				//public static void ShowMyDialog(Component parentComponent)
				
			}
		});
		btnCustomDlg.setBounds(12, 187, 410, 44);
		frame.getContentPane().add(btnCustomDlg);
		
		btnMyFrame = new JButton("Custom Frame");
		
		btnMyFrame.addActionListener(new ActionListener() { //Custom Frame버튼 클릭시 자바가상머신이 자동으로 호출해서 실행시켜줌
			public void actionPerformed(ActionEvent e) {
				//과제 : JFrame을 상속받는 객체 보여주기
				MyFrame.showMyFrame(frame,AppMain07.this);
				//->아규먼트 frame : MYFrame 
				//->아규먼트 AppMain07.this : AppMain07 타입으로 생성된 객체(의 주소) 현재 객체 AppMain07의 주소.
				//생성자를 호출하면 그 객체는 항상 this라고 하는 주소값을 가지고 있다고 함.
				// 주소값을 준 이유: 그 주소값을 알고 있으면 그 주소값에 .하면 그 클래스(타입)에 있는 public으로 공개된 필드,메서드 호출 가능하기 때문.
				// AppMain07번의 메서드,필드를 마이프레임 클래스에서 사용할 수 있게 하려고.
				// 마이프레임 클레스에서 "현재 뜬 창의" AppMain07객체의 public 메서드를 호출할 수 있도록.
				// 마이프레임 클래스에서 AppMain07을 new로 객체 생성해서 쓰면 객체의 주소가 달라져서 안됨(별개의 새로운 객체를 만든는 거라서)
				// 현재 뜬 창의 AppMain07객체의 주소가 필요함.
			}
		});
		btnMyFrame.setBounds(12, 241, 410, 44);
		frame.getContentPane().add(btnMyFrame);
	}
}
