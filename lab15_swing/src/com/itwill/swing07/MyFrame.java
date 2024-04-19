package com.itwill.swing07;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {
	//인터페이스 만듬 - 앱메인07파라미터 선언 사용범위 넓게 바꾸려고
	public interface Notifiable{// 인터페이스는 static만있는데 생략 되었다고 함. 누군가 구현하려고 하면 노티파이메세지메서드를 반드시 구현하게 만듬
		public void notifyMessage(String msg);
	}
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btn;
	
	private Component parentComponent;// 부모 컴포넌트를 저장하기 위한 필드
	//private AppMain07 app; //메인 쓰레드 객체 주소를 저장할 필드, 생성자 호출시 초기화 됨.
	private Notifiable app; //인터페이스 타입으로 필드 타입 변경
	//->notifyMessage(String msg)메서드를 갖는 객체의 주소를 저장

	/**
	 * Launch the application.
	 */
	public static void showMyFrame(Component parentComponent,Notifiable app) { //(Component parentComponent, AppMain07 app)이었는데 변경함.
		//main이름 변경하고 아규먼트 지워버림 -> 창의 뜨는 위치 변경하려고 파라미터 선언해서 아규먼트로 정보 넘겨받음
		//-> 메인에서 호출 할때 넘겨준 이 정보로 창이 뜨는 위치 변경. 
		//JFrame parentComponent라고 파라미터 선언함. 메인의 제이프레임 정보를 아규먼트로 넘겨 받기 위해서 JFrame 타입으로 파라미터 선언.
		// 다형성때문에 Component타입으로 파라미터 선언 변경함.
		// Component를 상속 받는 클래스가 있는데 JFrame,JDialog 둘 다 사용 가능하게 하려고 Component타입으로 변경.
		// showMyFrame메서드를 JFrame,JDialog 둘 다에서 사용 가능(호출 가능)하게 하려고 이 메서드의 사용 범위를 넓게 하려고 Component타입으로 변경함.
		/* 상속 관계
		 * Component
		 * 	|__JFrame,JDialog
		 */
		//AppMain07 app로 선언한 사용범위 넓게 하려면 파라미터 변수타입을 오
		// 브젝트 타입..?으로 바꾸는 건 이건 또 안된다고.. 오브젝트에 있는 메서드,필드밖에 안보인다고..??
		// 쓰려면 캐스팅.해야 된다고..어쩌고..인데 못 알아 들음.
		//해결 방법 : 인터페이스를 만든다고...Notifiable인터페이스를 만듬
		//만든 인터페이스 타입으로 변수선언 다 바꿈 AppMain07 app에서 Notifiable app로
		// AppMain07타입으로 만들 었던 걸 다 인터페이스  Notifiable 타입으로 다 변경함.
		// 이유 : 사용범위 넓게 하려고.  AppMain07에서만 사용 가능했는데 AppMain07뿐만 아니라 showMyFrame메서드를 
		// 다른 클래스에서도 호출해도 되도록 변경 한 것.
		// 단 호출 할때 정상적으로 호출 되려면 그 호출한 클래스가 Notifiable인터페이스를 구현(implements)하고 있어야 하고 
		// Notifiable 인터페이스 내부에서 선언한 notifyMessage(String msg)메서드를
		// 오버라이드 해야 함.
		
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try { //showMyFrame(Component parentComponent)아규먼트를 전달 받음.
					MyFrame frame = new MyFrame(parentComponent, app); //마이프레임 객체 생성
					frame.setVisible(true); //마이프레임 객체를 화면에 보여주겠다 true
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public MyFrame(Component parentComponent, Notifiable app) { //생성자{}내부코드 간단하게 하기위해서 
		//public MyFrame(Component parentComponent, AppMain07 app)
		this.parentComponent = parentComponent; 
		this.app = app; //initialize(); 호출 전에 값이 초기화 되어야 한다. 그래서 initialize();위에 초기화 코드 작성해야!.
		
		//initialize();메서드 호출 코드로 바꾸고 initialize()메서드 만들어서 그 안에 생성자에 있던 코드 옮기기.
		initialize();
	}
	private void initialize() {
		//setDefaultCloseOperation는 JFrame의 닫기 버튼의 기본 동작을 설정.
		//JFrame.EXIT_ON_CLOSE 창의 닫기버튼(X)클릭시 메인 쓰레드와 함께 모두 종료(프로그램 종료)
		//JFrame.DISPOSE_ON_CLOSE :닫기버튼 클릭시 현재 JFrame만 닫는다(메인 쓰레드는 종료 되지 않고 계속 실행)
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//(JFrame.EXIT_ON_CLOSE)을 DISPOSE_ON_CLOSE로 변경
		
		int x = 0;
		int y = 0;
		if(parentComponent != null) { //parentComponent는 메인에서 아규먼트로 넘겨주는 값이 저장되는 파라미터변수.
			// 메인에서 호출시 아규먼트로 null을 넣어주면 if{}내부 실행 안됨. 메인에서 호출시 아규먼트로 넘겨주는 값이 null이 아닐때만 실행됨.
			x = parentComponent.getX();// 부모 컴포넌트의 x좌표
			y = parentComponent.getY();// 부모 컴포넌트의 y좌표
		}
		setBounds(x, y, 450, 300); //->따로 설정 안할 시 여기에 설정 되어있는 x좌표 y좌표로 열림
		//->parentComponent가 null이면 0,0자리에 뜸. 
		//-> 화면 가운데 뜨게 하려고 밑의 코드 if로 parentComponent == null인 경우 실행되는 코드를 추가함
		
		if(parentComponent == null) { // 부모컴포넌트 정보가 없을 때(메인에서 호출할 때 넘겨주는 아규먼트 값이 null일 때 실행)
			setLocationRelativeTo(null);// 화면 중앙에 위치 시킴
		}
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);//-> 앱솔루트 레이아웃으로 변경. contentPane클래스의 setLayout 메서드의 아규먼트가 null로 됨.
		
		textField = new JTextField();
		textField.setBounds(12, 10, 410, 69);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btn = new JButton("확인");
		btn.addActionListener(new ActionListener() { //확인 버튼 클릭 시 실행되는 기능.
			public void actionPerformed(ActionEvent e) {
				
				//JTextField 내용을 읽음
				String msg = textField.getText();
				app.notifyMessage(msg);//AppMain07에 있는 메서드 호출.
				//AppMain07에서 아규먼트로 넘겨받은 AppMain07의 객체 주소(AppMain07.this)로 메서드 호출함(new객체생성 없이 호출)
				
			}
		});
		btn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn.setBounds(12, 89, 410, 58);
		contentPane.add(btn);
		
	}
}
