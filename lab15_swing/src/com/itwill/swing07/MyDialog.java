package com.itwill.swing07;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyDialog extends JDialog {

	private static final long serialVersionUID = 1L; // 있어도 되고 없어도 되는 코드라고...
	// ->없애면 경고 뜸. 시리얼라이저블 인터페이스 구현 어쩌고..모름.
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPanel;
	private JButton cancelButton;
	private JButton okButton;
	private JTextField textField;
	
	// 부모 컨포넌트를 저장하기 위한 필드 선언 - 메인에서 불러오면 그 창을 메인따라가서 뜨게 설정하려고.
	private Component parentComponent;
	
	/**
	 * Launch the application.
	 */
	public static void ShowMyDialog(Component parentComponent) { // main이 있어서 작동 됨 - 그래서 선생님 맘에 안드신다고..
		// AppMain07에 있는 main() 쓸 거 라서.. // 그래서 이름 바꾼다고..ShowMyDialog라고 변경
		//public static void ShowMyDialog(Component parentComponent) 창이 부모컨포넌트 따라가게 하려고 파라미터 선언 Component parentComponent로 함
		// 근데 이게 지역변수라서... 필드로 선언. private Component parentComponent;
		try {
			MyDialog dialog = new MyDialog(parentComponent);// 호출 되었을 때 private final JPanel contentPanel = new JPanel();의 기본값으로 초기화
			// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);-> 굳이 여기서 할 필요 없고
			// 밑에 initialize()메서드 안{}에서 한다고..
			// 실행 창의 x클릭하면 DISPOSE 이 다이얼로그만 끝나게. main프로그램 남겨두겠다라는 뜻..?
			//dialog.parentComponent = parentComponent;->안되는 이유  MyDialog()기본 생성자가 다 초기화 된 다음 값이 들어가 버림.
			//->initialize();끝나야 값이 들어가버려서 안됨. 그래서 MyDialog()기본 생성자 코드 맨 위에다가 작성.
			dialog.setLocationRelativeTo(parentComponent);//->이거 코드 한개면 제일 간단하다고(멤버변수(필드) 필요없고 생성자도 기본생성자로 해도 된다고)
			//->근데 굳이 어렵게 한 이유는 값을 저장하려고..? private Component parentComponent; 필드에 값 저장하기 위해서 저장하면 필요가 있나..?
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MyDialog(Component parentComponent) {
		this.parentComponent = parentComponent; //이 코드가 맨 위에다가 위치해야함!initialize();실행전에 초기화 되어야!
		//initialize();밑에 넣으면
		//initialize();가 호출되서 실행이 끝나고 나서야 값이 초기화됨. initialize();실행 중에는 계속 null이 되서.맨 위에 놓아야한다.
		//initialize();위에 놓아야!
		initialize(); // 생성자는 메서드로 초기화 작업(코드가 길어서 메서드를 호출해서 메서드 안에 초기화 코드넣음)
	}

	private void initialize() { // 다른 곳에서 호출 못하게 private으로 막아버림
		// public class MyDialog extends JDialog 상속 받아서 클래스.으로 호출해서 안 쓰고 그냥 사용.
		setBounds(100, 100, 450, 300);// ->다이얼로그의 창의 뜨는 좌표x,y 와 크기 width,height
		//->창이 뜨는 지정된 위치(부모컨포넌트) 설정 안해서 다이얼로그 좌표 위치 에서 창이 뜸.
		//setBounds(100, 100, 450, 300);에있는 좌표 무시하고 항상 스크린의 가운데에 위치하도록 하는 코드
		//setLocationRelativeTo(null); -> 아규먼트가 null인 경우에는 스크린의 가운데에 위치함.
		
		//setBounds의 (x,y)좌표 무시하고 부모 컴포넌트에 상대적으로(부모컴포넌트의 가운데 위치하게)배치
		setLocationRelativeTo(parentComponent);//parentComponent를 기준으로 창이 뜨게 설정.
		//parentComponent는 메인에서 호출할 때 넣어주는 아규먼트 값.
		//-> 아규먼트로 주는 값의 가운데에 창이 위치해서 뜨게 함.
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// ->다이얼로그의 창의 닫기버튼X의 기본동작을 설정 DISPOSE_ON_CLOSE는
		// -> 현재 다이얼로그만 닫고 메인 프로세스는 계속 실행 하겠다는 뜻.
		// ->EXIT_ON_CLOSE : 현재 다이얼로그와 함께 메인 프로세스까지 종료 하겠다는 뜻.
		// 여기서는 EXIT_ON_CLOSE 이거 못쓴다고.. 예외 발생함. 

		// getContentPane()은 컨텐트 영역과 버튼영역을 합친 것.
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));// ->테두리 선?
		// getContentPane()에 add추가.
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);//contentPanel의->레이아웃 앱솔루트
		
		JLabel lblNewLabel = new JLabel("New label"); // 새 레이블 생성
		lblNewLabel.setBounds(32, 10, 57, 15);
		contentPanel.add(lblNewLabel); // contentPanel에 .add(lblNewLabel) 새 레이블 추가
		
		textField = new JTextField();
		textField.setBounds(32, 35, 116, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button"); // 새 버튼 생성
		btnNewButton.setBounds(32, 76, 97, 23);
		contentPanel.add(btnNewButton); //contentPanel에.add(btnNewButton) 새 버튼 추가
		
		

		// 감싸고 있는 {}를 쓸모 없다고 지운다고 함..딱 중괄호만 지움 지우고 컨트롤 +시프트 +f

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("굴림", Font.PLAIN, 20));
		cancelButton.setActionCommand("Cancel");
		buttonPanel.add(cancelButton);

		okButton = new JButton("OK");
		okButton.setFont(new Font("굴림", Font.PLAIN, 20));
		okButton.setActionCommand("OK");
		buttonPanel.add(okButton);
		getRootPane().setDefaultButton(okButton);

	} // end initialize()
}
