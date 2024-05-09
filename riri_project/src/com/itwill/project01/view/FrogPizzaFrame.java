package com.itwill.project01.view;

import static com.itwill.project01.model.LoginMember.COL_LOGIN_EMAIL;
import static com.itwill.project01.model.LoginMember.COL_LOGIN_ID;
import static com.itwill.project01.model.LoginMember.COL_LOGIN_JOIN_DATE;
import static com.itwill.project01.model.LoginMember.COL_LOGIN_NAME;
import static com.itwill.project01.model.LoginMember.COL_LOGIN_PASSWORD;
import static com.itwill.project01.model.LoginMember.COL_LOGIN_PHONE;
import static com.itwill.project01.model.LoginMember.TBL_LOGIN_MEMBER_TB;
import static com.itwill.project01.view.OracleJdbc2.PASSWORD;
import static com.itwill.project01.view.OracleJdbc2.URL;
import static com.itwill.project01.view.OracleJdbc2.USER;

import static com.itwill.project01.model.OrderTb.*;

import java.awt.*;
import javax.swing.*;


import com.itwill.project01.controller.OrderMenuDao;
import com.itwill.project01.model.Membership;
import com.itwill.project01.model.OrderMenuAll;
import com.itwill.project01.model.OrderTb;

import oracle.jdbc.OracleDriver;

import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FrogPizzaFrame {
	
	//메뉴 테이블에 넣을 컬럼 상수 선언.
	private static final String[] COLUMN_PIZZA = {"피자","피자$가격","요리사"};
	private static final String[] COLUMN_DRINK = {"음료","음료$가격"};
	private static final String[] COLUMN_SIDE = {"사이드","사이드$가격"};
	
	//주문내역 테이블에 넣을 컬럼 상수 선언.
	private static final String[] COLUMN_ORDER_HISTORY = {"아이디","피자주문내역","음료주문내역","사이드주문내역","주문금액","주문시간"};
	//주문내역 테이블에 쓸 테이블 모델 필드선언
	private DefaultTableModel orderModel;
	//주문 확인 메뉴에 넣을 테이블 컬럼 상수 선언
	//private static final String[] COLUNM_ORDER_CHECK = {"주문일자","아이디","이름","PIZZA_KCAL","DRINK_KCAL","PIZZA_KCAL"};
	
	private DefaultTableModel pizzaModel;
	private DefaultTableModel drinkModel;
	private DefaultTableModel sideModel;
	
	
	
	//행 정렬 하려고 필드 설정
	private DefaultTableCellRenderer celAlignCenter;
	
	//OrderMenuDao의 getInstance()메서드를 호출해서 싱글턴으로 만든(객체생성 1번만 되게)객체를 생성함.
	//몇번을 호출하든 같은 주소의 OrderMenuDao의 객체가 호출됨.
	private OrderMenuDao orderMenuDao = OrderMenuDao.getInstance();
	
	//private OrderingFrame dao = OrderingFrame.getInstance();
	
	//아규먼트로 넘겨받은 메뉴이름정보 저장해서 사용하려고 필드선언
	private String ckPizzaName;
	private String cKDinkName;
	private String cKSideName;
	
//	//TODO 판넬 배경채우려고 선언
//	class ImagePanel extends JPanel {
//		private Image imgFrogPizzaMain; //new ImageIcon(".\\image\\피자메인판넬.png").getImage();
//		public ImagePanel(Image imgFrogPizzaMain) {
//			this.imgFrogPizzaMain = imgFrogPizzaMain;
//			setLayout(null);
//		}
//		// 다시 그리는 paintComponent를 오버라이드
//		@Override
//		public void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.drawImage(imgFrogPizzaMain,0,0,null);
//		}
//	}
	//////////
    //-----> singleton
//    private static FrogPizzaFrame instance = null;
//    
//
//    
//    public static FrogPizzaFrame getInstance() {
//        if (instance == null) {
//            instance = new FrogPizzaFrame();
//        }
//        
//        return instance;
//    }
    //<----- singleton
	
	
	
	
	////////////
	
	
	private JFrame frame;
	private JButton btnPrFrogPizza;
	private JButton btnBulgogiPizza;
	private JButton btnMushroom;
	private JButton btnTomatoPizza;
	private JButton btnShrimpPizza;
	private JButton btnPepperoniPizza;
	private JButton btnPotatoPizza;
	private JButton btnCheesePizza;
	private JButton btnVegetablePizza;
	private JButton btnSweetPotatoPizza;
	private JButton btnPineapplePizza;
	private JButton btnWesternSpinachPizza;
	private JButton btnMintChocolatePizza;
	private JPanel panelDrinkMenu;
	private JButton btnDrinkFrogAde;
	private JButton btnDrinkCoke;
	private JButton btnDrinkSprite;
	private JButton btnDrinkZeroCoke;
	private JPanel panelSelectBtn;
	private JButton btnOrderMenuButton;
	private JButton btnOrderDetailsButton;
	private JButton btnLogOut;
	private JPanel panelMain;
	private JPanel panelMainMenuBackground;
	private JButton btnSideMenu;
	private JButton btnShoppinBasket;
	private JButton btnPizzaMenu;
	private JButton btnDrinkMenu;
	private JPanel panelOrderMenuBackground;
	private JPanel panelPizzaMenu;
	
	private JTable tableOrderPizzaMenu;
	
	
	private JTextField textTotalsum;
	private JPanel panelSideMenu;
	private JButton btnSideSpaghettiFullOfPepperoni;
	private JPanel panelShoppinBasket;
	
	private JTable tableOrderSide;
	
	
	private JTable tableOrderDrink;
	
	
	private JButton btnBananaPizza;
	private JButton btnMalaFlavorPizza;
	private JScrollPane scrollPane;
	private JButton btnPaymentButton;
	private JLabel lblPaymentAmount;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JLabel lblOrderTableBackgroundImage;
	private JLabel lblOrderPizzaBackgroundImage;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnSidePastaFullOfBacon;
	private JButton btnSideGreenSalad;
	private JButton btnSideConsommeSeasonedPotatoes;
	private JButton btnSideSweetRiceCheeseBalls;
	private JLabel lblNewLabel_4;
	private JPanel panelOrderConfirmation;
	private JLabel lblNewLabel_6;
	private JLabel lblOrderConfirmationB;
	private JTable tableOrderConfirmation;
	private JScrollPane scrollPane_3;
	private JButton btnDrinkOrderCancle;
	private JButton btnSideOrderCancle;

	//아규먼트로 받은 로그인한 아이디 저장하려고 선언한 필드
	public String lloginId;
	//로그인한 아이디의 회원정보 아규먼트로 받아서 저장하려고 선언한 필드
	private Membership loginMembership;
	private static FrogPizzaLoginFrame frogPizzaLoginFrame;
	
	private JLabel lblIdName;
	private JLabel lblToday;
	
	/**
	 * Launch the application.
	 */
	public static void showFrogPizzaFrame(String loginId, FrogPizzaLoginFrame frogPizzaLoginFrame,Membership loginMembership) {//로그인한 아이디 아규먼트로 넘겨받음.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrogPizzaFrame window = new FrogPizzaFrame(loginId, frogPizzaLoginFrame, loginMembership); 
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
	//생성자
	public FrogPizzaFrame(String loginId, FrogPizzaLoginFrame frogPizzaLoginFrame, Membership loginMembership) {
		lloginId = loginId;
		this.frogPizzaLoginFrame = frogPizzaLoginFrame;
		this.loginMembership = loginMembership;
		initialize();
	
	}


	//메서드

//	public void paintComponent(Graphics g) {
//		g.drawImage(imgFrogPizzaMain, 0, 0, null);
//	}
	
	
	
	/** 
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);//화면크기조절 못하게 설정
		frame.setBounds(100, 100, 1260, 1000);
		frame.setTitle("개굴 개굴");//창 타이틀
		//창 아이콘
		Toolkit kit = Toolkit.getDefaultToolkit();
		//Image img = kit.getImage(".\\image\\아이콘.png");
		//Image img = kit.getImage(getClass().getClassLoader().getResource(".\\image\\아이콘.png"));
		//getClass().getClassLoader().getResource("arrow1.png")
		//frame.setIconImage(img);
		
		Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/itwill/project01/image/아이콘.png"));
        frame.setIconImage(img);
		
		frame.setLocationRelativeTo(null);//화면 중앙에 뜨게 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelMainMenuBackground = new JPanel();
		panelMainMenuBackground.setBounds(226, 0, 1018, 961);
		frame.getContentPane().add(panelMainMenuBackground);
		panelMainMenuBackground.setLayout(null);
		
		btnSideMenu = new JButton("");
		btnSideMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSideMenu.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/사이드드래그.png")));
				//(new ImageIcon(".\\image\\사이드드래그.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSideMenu.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/사이드버튼.png")));
				//(new ImageIcon(".\\image\\사이드버튼.png"));
			}
		});
		btnSideMenu.setContentAreaFilled(false);
		btnSideMenu.setBorderPainted(false);
		btnSideMenu.setFocusPainted(false);
		btnSideMenu.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/사이드버튼.png")));
		//(new ImageIcon(".\\image\\사이드버튼.png"));
		
		btnSideMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOrderMenuBackground.setVisible(true);
				
				
				panelSideMenu.setVisible(true);
				btnSideConsommeSeasonedPotatoes.setVisible(true);
				btnSideGreenSalad.setVisible(true);
				btnSidePastaFullOfBacon.setVisible(true);
				btnSideSpaghettiFullOfPepperoni.setVisible(true);
				btnSideSweetRiceCheeseBalls.setVisible(true);
				
				panelDrinkMenu.setVisible(false);
				btnDrinkCoke.setVisible(false);
				btnDrinkFrogAde.setVisible(false);
				btnDrinkSprite.setVisible(false);
				btnDrinkZeroCoke.setVisible(false);
				
				panelPizzaMenu.setVisible(false);
				btnCheesePizza.setVisible(false);
				btnBananaPizza.setVisible(false);
				btnBulgogiPizza.setVisible(false);
				btnMalaFlavorPizza.setVisible(false);
				btnMintChocolatePizza.setVisible(false);
				btnMushroom.setVisible(false);
				btnPepperoniPizza.setVisible(false);
				btnPotatoPizza.setVisible(false);
				btnPrFrogPizza.setVisible(false);
				btnShrimpPizza.setVisible(false);
				btnSweetPotatoPizza.setVisible(false);
				btnTomatoPizza.setVisible(false);
				btnVegetablePizza.setVisible(false);
				btnWesternSpinachPizza.setVisible(false);
				btnPineapplePizza.setVisible(false);
				
				panelShoppinBasket.setVisible(false);
				
				
			}
		});
		
		panelOrderMenuBackground = new JPanel();
		panelOrderMenuBackground.setBounds(0, 96, 1018, 865);
		panelMainMenuBackground.add(panelOrderMenuBackground);
		panelOrderMenuBackground.setLayout(null);
		
		panelPizzaMenu = new JPanel();
		
		panelPizzaMenu.setBounds(0, 0, 1018, 618);
		panelOrderMenuBackground.add(panelPizzaMenu);
		panelPizzaMenu.setLayout(null);
		
		btnPrFrogPizza = new JButton("");
		//개구리피자 마우스 드래그시 실행되는 코드
		btnPrFrogPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPrFrogPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리피자이름가격.png")));
				//(new ImageIcon(".\\image\\개구리피자이름가격.png"));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPrFrogPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리피자.png")));
				//(new ImageIcon(".\\image\\개구리피자.png"));
			}
		});
		btnPrFrogPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리피자.png")));
		//(new ImageIcon(".\\image\\개구리피자.png"));
		btnPrFrogPizza.setContentAreaFilled(false);
		btnPrFrogPizza.setBorderPainted(false);
		btnPrFrogPizza.setFocusPainted(false);
		
		//프리미엄 개구리피자 버튼 클릭시 실행되는 코드
		btnPrFrogPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CkPizzaName = "♡개구리피자♡";
//				//나는 버튼 클릭하면 테이블에 피자 이름,가격,요리사 나오게 하고 싶어!
				showPizzaNameAndPriceTableOrderMenu(CkPizzaName);
//				showPizzaNameAndPriceTableOrderMenu();
				//이거 안됨 테이블에서 가져온값으로해야됨.
//				int frogPizzaPrice = 50000;
//				orderSum(frogPizzaPrice);
				orderSum();//계산합계
			}
		});
		btnPrFrogPizza.setBounds(10, 0, 200, 200);
		panelPizzaMenu.add(btnPrFrogPizza);
		
		btnBulgogiPizza = new JButton("");
		

		
		btnBulgogiPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBulgogiPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/불고기피자이름가격.png")));
				//(new ImageIcon(".\\image\\불고기피자이름가격.png"));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBulgogiPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/불고기피자.png")));
				//(new ImageIcon(".\\image\\불고기피자.png"));
			}
		});

		
		
		btnBulgogiPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CkPizzaName = "불고기피자";
				showPizzaNameAndPriceTableOrderMenu(CkPizzaName);
				orderSum();
			}
		});
		
		btnBulgogiPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/불고기피자.png")));
		//(new ImageIcon(".\\image\\불고기피자.png"));
		btnBulgogiPizza.setContentAreaFilled(false);
		btnBulgogiPizza.setBorderPainted(false);
		btnBulgogiPizza.setFocusPainted(false);
		
		btnBulgogiPizza.setBounds(221, 0, 200, 200);
		panelPizzaMenu.add(btnBulgogiPizza);
		
		btnMushroom = new JButton("");
		btnMushroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMushroom.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/버섯피자이름가격.png")));
				//(new ImageIcon(".\\image\\버섯피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMushroom.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/버섯피자.png")));
				//(new ImageIcon(".\\image\\버섯피자.png"));
			}
		});
		
		btnMushroom.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/버섯피자.png")));
		//(new ImageIcon(".\\image\\버섯피자.png"));
		
		btnMushroom.setContentAreaFilled(false);//-> 버튼 배경 채우기 안함.이게 사실상 투명으로
		btnMushroom.setBorderPainted(false); //->버튼의 외곽선 없애줌
		btnMushroom.setFocusPainted(false);//->선택되었을때 생기는 얇은 점선 테두리 사용 안함이라는데
		//-> 뭐가바뀐지는 몰겠음..
		//btnMushroom.setOpaque(false);//투명하게 하는데 뭐가바뀐지 몰겠음..
		//->이미지외의 영역 투명하게 라고함.
		
		btnMushroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "버섯피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnMushroom.setBounds(10, 201, 200, 200);
		panelPizzaMenu.add(btnMushroom);
		
		btnTomatoPizza = new JButton("");
		btnTomatoPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTomatoPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/토마토피자이름가격.png")));
				//(new ImageIcon(".\\image\\토마토피자이름가격.png"));
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnTomatoPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/토마토피자.png")));
				//(new ImageIcon(".\\image\\토마토피자.png"));
			}
		});
		btnTomatoPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/토마토피자.png")));
		//(new ImageIcon(".\\image\\토마토피자.png"));
		btnTomatoPizza.setContentAreaFilled(false);
		btnTomatoPizza.setBorderPainted(false);
		btnTomatoPizza.setFocusPainted(false);
		
		btnTomatoPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "토마토피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnTomatoPizza.setBounds(211, 201, 200, 200);
		panelPizzaMenu.add(btnTomatoPizza);
		
		btnShrimpPizza = new JButton("");
		btnShrimpPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnShrimpPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/슈림프피자이름가격.png")));
				//(new ImageIcon(".\\image\\슈림프피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnShrimpPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/슈림프피자.png")));
				//(new ImageIcon(".\\image\\슈림프피자.png"));
			}
		});
		btnShrimpPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/슈림프피자.png")));
		//(new ImageIcon(".\\image\\슈림프피자.png"));
		btnShrimpPizza.setContentAreaFilled(false);
		btnShrimpPizza.setBorderPainted(false); //->버튼의 외곽선 없애줌
		btnShrimpPizza.setFocusPainted(false);//->선택되었을때 생기는 얇은 점선 테두리 사용 안함이라는데
		
		
		btnShrimpPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "슈림프피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnShrimpPizza.setBounds(412, 0, 200, 200);
		panelPizzaMenu.add(btnShrimpPizza);
		
		btnPepperoniPizza = new JButton("");
		btnPepperoniPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPepperoniPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/페퍼로니피자이름가격.png")));
				//(new ImageIcon(".\\image\\페퍼로니피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPepperoniPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/페퍼로니피자.png")));
				//(new ImageIcon(".\\image\\페퍼로니피자.png"));
			}
		});
		btnPepperoniPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/페퍼로니피자.png")));
		//(new ImageIcon(".\\image\\페퍼로니피자.png"));
		btnPepperoniPizza.setContentAreaFilled(false);
		btnPepperoniPizza.setFocusPainted(false);
		btnPepperoniPizza.setBorderPainted(false);
		
	
		btnPepperoniPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "페퍼로니피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnPepperoniPizza.setBounds(412, 201, 200, 200);
		panelPizzaMenu.add(btnPepperoniPizza);
		
		btnPotatoPizza = new JButton("");
		btnPotatoPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPotatoPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/포테이토피자이름가격.png")));
				//(new ImageIcon(".\\image\\포테이토피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPotatoPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/포테이토피자.png")));
				//(new ImageIcon(".\\image\\포테이토피자.png"));
			}
		});
		btnPotatoPizza.setContentAreaFilled(false);
		btnPotatoPizza.setBorderPainted(false);
		btnPotatoPizza.setFocusPainted(false);
		btnPotatoPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/포테이토피자.png")));
		//(new ImageIcon(".\\image\\포테이토피자.png"));
		btnPotatoPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "포테이토피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnPotatoPizza.setBounds(613, 0, 200, 200);
		panelPizzaMenu.add(btnPotatoPizza);
		
		btnCheesePizza = new JButton("");
		btnCheesePizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCheesePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/치즈피자이름가격.png")));
				//(new ImageIcon(".\\image\\치즈피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCheesePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/치즈피자.png")));
				//(new ImageIcon(".\\image\\치즈피자.png"));
			}
		});
		btnCheesePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/치즈피자.png")));
		//(new ImageIcon(".\\image\\치즈피자.png"));
		btnCheesePizza.setContentAreaFilled(false);
		btnCheesePizza.setBorderPainted(false);
		btnCheesePizza.setFocusPainted(false);
		
		btnCheesePizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "치즈피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnCheesePizza.setBounds(603, 211, 200, 200);
		panelPizzaMenu.add(btnCheesePizza);
		
		btnVegetablePizza = new JButton("");
		btnVegetablePizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVegetablePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/야채피자이름가격.png")));
				//(new ImageIcon(".\\image\\야채피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVegetablePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/야채피자.png")));
				//(new ImageIcon(".\\image\\야채피자.png"));
			}
			
		});
		
		btnVegetablePizza.setContentAreaFilled(false);
		btnVegetablePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/야채피자.png")));
		//(new ImageIcon(".\\image\\야채피자.png"));
		btnVegetablePizza.setBorderPainted(false); //->버튼의 외곽선 없애줌
		btnVegetablePizza.setFocusPainted(false);//->선택되었을때 생기는 얇은 점선 테두리 사용 안함이라는데
		
		btnVegetablePizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "야채피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnVegetablePizza.setBounds(804, 211, 200, 200);
		panelPizzaMenu.add(btnVegetablePizza);
		
		btnSweetPotatoPizza = new JButton("");
		btnSweetPotatoPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSweetPotatoPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/고구마피자이름가격.png")));
				//(new ImageIcon(".\\image\\고구마피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSweetPotatoPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/고구마피자.png")));
				//(new ImageIcon(".\\image\\고구마피자.png"));
			}
		});
		btnSweetPotatoPizza.setContentAreaFilled(false);
		btnSweetPotatoPizza.setBorderPainted(false);
		btnSweetPotatoPizza.setFocusPainted(false);
		btnSweetPotatoPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/고구마피자.png")));
		//(new ImageIcon(".\\image\\고구마피자.png"));
		btnSweetPotatoPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "고구마피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnSweetPotatoPizza.setBounds(814, 0, 200, 200);
		panelPizzaMenu.add(btnSweetPotatoPizza);
		
		btnPineapplePizza = new JButton("");
		btnPineapplePizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPineapplePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/파인애플피자이름가격.png")));
				//(new ImageIcon(".\\image\\파인애플피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPineapplePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/파인애플피자.png")));
				//(new ImageIcon(".\\image\\파인애플피자.png"));
			}
		});
		btnPineapplePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/파인애플피자.png")));
		//(new ImageIcon(".\\image\\파인애플피자.png"));
		btnPineapplePizza.setContentAreaFilled(false);
		btnPineapplePizza.setFocusPainted(false);
		btnPineapplePizza.setBorderPainted(false);
		
		btnPineapplePizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "파인애플피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnPineapplePizza.setBounds(10, 402, 200, 200);
		panelPizzaMenu.add(btnPineapplePizza);
		
		btnWesternSpinachPizza = new JButton("");
		btnWesternSpinachPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnWesternSpinachPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/루꼴라피자이름가격.png")));
				//(new ImageIcon(".\\image\\루꼴라피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnWesternSpinachPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/루꼴라피자.png")));
				//(new ImageIcon(".\\image\\루꼴라피자.png"));
			}
		});
		btnWesternSpinachPizza.setContentAreaFilled(false);
		btnWesternSpinachPizza.setBorderPainted(false);
		btnWesternSpinachPizza.setFocusPainted(false);
		
		btnWesternSpinachPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/루꼴라피자.png")));
		//(new ImageIcon(".\\image\\루꼴라피자.png"));
		btnWesternSpinachPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "루꼴라피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnWesternSpinachPizza.setBounds(211, 402, 200, 200);
		panelPizzaMenu.add(btnWesternSpinachPizza);
		
		btnMintChocolatePizza = new JButton("");
		btnMintChocolatePizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMintChocolatePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/민트초코피자이름가격.png")));
				//(new ImageIcon(".\\image\\민트초코피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMintChocolatePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/민초피자.png")));
				//(new ImageIcon(".\\image\\민초피자.png"));
			}
		});
		btnMintChocolatePizza.setContentAreaFilled(false);
		btnMintChocolatePizza.setBorderPainted(false);
		btnMintChocolatePizza.setFocusPainted(false);
		
		btnMintChocolatePizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/민초피자.png")));
		//(new ImageIcon(".\\image\\민초피자.png"));
		btnMintChocolatePizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "민트초코피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnMintChocolatePizza.setBounds(412, 402, 200, 200);
		panelPizzaMenu.add(btnMintChocolatePizza);
		
		btnBananaPizza = new JButton("");
		btnBananaPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBananaPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/바나나피자이름가격.png")));
				//(new ImageIcon(".\\image\\바나나피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBananaPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/바나나피자.png")));
				//(new ImageIcon(".\\image\\바나나피자.png"));
			}
		});
		btnBananaPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/바나나피자.png")));
		//(new ImageIcon(".\\image\\바나나피자.png"));
		btnBananaPizza.setContentAreaFilled(false);
		btnBananaPizza.setBorderPainted(false);
		btnBananaPizza.setFocusPainted(false);
		btnBananaPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "바나나피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnBananaPizza.setBounds(613, 402, 200, 200);
		panelPizzaMenu.add(btnBananaPizza);
		
		btnMalaFlavorPizza = new JButton("");
		btnMalaFlavorPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMalaFlavorPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/마라맛피자이름가격.png")));
				//(new ImageIcon(".\\image\\마라맛피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMalaFlavorPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/마라맛피자.png")));
				//(new ImageIcon(".\\image\\마라맛피자.png"));
			}
		});
		btnMalaFlavorPizza.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/마라맛피자.png")));
		//(new ImageIcon(".\\image\\마라맛피자.png"));
		btnMalaFlavorPizza.setContentAreaFilled(false);
		btnMalaFlavorPizza.setFocusPainted(false);
		btnMalaFlavorPizza.setBorderPainted(false);
		
		btnMalaFlavorPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizzaName = "마라맛피자";
				showPizzaNameAndPriceTableOrderMenu(pizzaName);
				orderSum();
			}
		});
		btnMalaFlavorPizza.setBounds(814, 402, 200, 200);
		panelPizzaMenu.add(btnMalaFlavorPizza);
		
		lblOrderPizzaBackgroundImage = new JLabel("");
		
		lblOrderPizzaBackgroundImage.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/피자배경.png")));
		//(new ImageIcon(".\\image\\피자배경.png"));
		lblOrderPizzaBackgroundImage.setBounds(0, 0, 1258, 618);
		panelPizzaMenu.add(lblOrderPizzaBackgroundImage);
		
		panelDrinkMenu = new JPanel();
		panelDrinkMenu.setBounds(0, 0, 1018, 618);
		panelOrderMenuBackground.add(panelDrinkMenu);
		panelDrinkMenu.setLayout(null);
		
		btnDrinkFrogAde = new JButton("");
		btnDrinkFrogAde.setVisible(false);
		
		btnDrinkFrogAde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDrinkFrogAde.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리에이드이름가격.png")));
				//(new ImageIcon(".\\image\\개구리에이드이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDrinkFrogAde.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리에이드.png")));
				//(new ImageIcon(".\\image\\개구리에이드.png"));
			}
		});
		btnDrinkFrogAde.setContentAreaFilled(false);
		btnDrinkFrogAde.setBorderPainted(false);
		btnDrinkFrogAde.setFocusPainted(false);
		btnDrinkFrogAde.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리에이드.png")));
		//(new ImageIcon(".\\image\\개구리에이드.png"));
		btnDrinkFrogAde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String drinkName = "☆개구리에이드☆";
				showDrinkMenuOrder(drinkName);
				orderSum();
			}
		});
		btnDrinkFrogAde.setBounds(0, 0, 200, 200);
		panelDrinkMenu.add(btnDrinkFrogAde);
		
		btnDrinkCoke = new JButton("");
		btnDrinkCoke.setVisible(false);
		
		btnDrinkCoke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDrinkCoke.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/콜라이름가격.png")));
				//(new ImageIcon(".\\image\\콜라이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDrinkCoke.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/콜라.png")));
				//(new ImageIcon(".\\image\\콜라.png"));
			}
		});
		btnDrinkCoke.setContentAreaFilled(false);
		btnDrinkCoke.setBorderPainted(false);
		btnDrinkCoke.setFocusPainted(false);
		btnDrinkCoke.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/콜라.png")));
		//(new ImageIcon(".\\image\\콜라.png"));
		btnDrinkCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String drinkName = "콜라500ml";
				showDrinkMenuOrder(drinkName);
				orderSum();
			}
		});
		btnDrinkCoke.setBounds(201, 0, 200, 200);
		panelDrinkMenu.add(btnDrinkCoke);
		
		btnDrinkZeroCoke = new JButton("");
		btnDrinkZeroCoke.setVisible(false);
		
		btnDrinkZeroCoke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDrinkZeroCoke.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/제로콜라이름가격.png")));
				//(new ImageIcon(".\\image\\제로콜라이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDrinkZeroCoke.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/제로콜라.png")));
				//(new ImageIcon(".\\image\\제로콜라.png"));
			}
		});
		btnDrinkZeroCoke.setContentAreaFilled(false);
		btnDrinkZeroCoke.setBorderPainted(false);
		btnDrinkZeroCoke.setFocusPainted(false);
		btnDrinkZeroCoke.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/제로콜라.png")));
		//(new ImageIcon(".\\image\\제로콜라.png"));
		btnDrinkZeroCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String drinkName = "제로콜라500ml";
				showDrinkMenuOrder(drinkName);
				orderSum();
			}
		});
		btnDrinkZeroCoke.setBounds(402, 0, 200, 200);
		panelDrinkMenu.add(btnDrinkZeroCoke);
		
		btnDrinkSprite = new JButton("");
		btnDrinkSprite.setVisible(false);
		
		btnDrinkSprite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDrinkSprite.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/스프라이트이름가격.png")));
				//(new ImageIcon(".\\image\\스프라이트이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDrinkSprite.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/스프라이트.png")));
				//(new ImageIcon(".\\image\\스프라이트.png"));
			}
		});
		btnDrinkSprite.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/스프라이트.png")));
		//(new ImageIcon(".\\image\\스프라이트.png"));
		btnDrinkSprite.setContentAreaFilled(false);
		btnDrinkSprite.setBorderPainted(false);
		btnDrinkSprite.setFocusPainted(false);
		btnDrinkSprite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String drinkName = "스프라이트";
				showDrinkMenuOrder(drinkName);
				orderSum();
			}
		});
		btnDrinkSprite.setBounds(604, 0, 200, 200);
		panelDrinkMenu.add(btnDrinkSprite);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/피자배경.png")));
		//(new ImageIcon(".\\image\\피자배경.png"));
		lblNewLabel_1.setBounds(0, 0, 1018, 618);
		panelDrinkMenu.add(lblNewLabel_1);
		
		panelSideMenu = new JPanel();
		panelSideMenu.setLayout(null);
		panelSideMenu.setBounds(0, 0, 1018, 618);
		panelOrderMenuBackground.add(panelSideMenu);
		
		btnSideSpaghettiFullOfPepperoni = new JButton("");
		btnSideSpaghettiFullOfPepperoni.setVisible(false);
		
		btnSideSpaghettiFullOfPepperoni.setContentAreaFilled(false);
		btnSideSpaghettiFullOfPepperoni.setBorderPainted(false);
		btnSideSpaghettiFullOfPepperoni.setFocusPainted(false);
		btnSideSpaghettiFullOfPepperoni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSideSpaghettiFullOfPepperoni.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/페퍼로니가득스파게티이름가격.png")));
				//(new ImageIcon(".\\image\\페퍼로니가득스파게티이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSideSpaghettiFullOfPepperoni.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/페퍼로니가득스파게티.png")));
				//(new ImageIcon(".\\image\\페퍼로니가득스파게티.png"));
			}
		});
		btnSideSpaghettiFullOfPepperoni.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/페퍼로니가득스파게티.png")));
		//(new ImageIcon(".\\image\\페퍼로니가득스파게티.png"));
		btnSideSpaghettiFullOfPepperoni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sideName = "페퍼로니가득스파게티";
				showSideNamePriceRead(sideName);
				orderSum();
			}
		});
		btnSideSpaghettiFullOfPepperoni.setBounds(0, 0, 200, 200);
		panelSideMenu.add(btnSideSpaghettiFullOfPepperoni);
		
		btnSidePastaFullOfBacon = new JButton("");
		btnSidePastaFullOfBacon.setVisible(false);
		
		btnSidePastaFullOfBacon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSidePastaFullOfBacon.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/베이컨가득까르보나라이름가격.png")));
				//(new ImageIcon(".\\image\\베이컨가득까르보나라이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSidePastaFullOfBacon.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/베이컨가득까르보나라.png")));
				//(new ImageIcon(".\\image\\베이컨가득까르보나라.png"));
			}
		});
		btnSidePastaFullOfBacon.setContentAreaFilled(false);
		btnSidePastaFullOfBacon.setBorderPainted(false);
		btnSidePastaFullOfBacon.setFocusPainted(false);
		btnSidePastaFullOfBacon.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/베이컨가득까르보나라.png")));
		//(new ImageIcon(".\\image\\베이컨가득까르보나라.png"));
		btnSidePastaFullOfBacon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sideName = "베이컨가득까르보나라";
				showSideNamePriceRead(sideName);
				orderSum();
			}
		});
		btnSidePastaFullOfBacon.setBounds(201, 0, 200, 200);
		panelSideMenu.add(btnSidePastaFullOfBacon);
		
		btnSideConsommeSeasonedPotatoes = new JButton("");
		btnSideConsommeSeasonedPotatoes.setVisible(false);
		
		btnSideConsommeSeasonedPotatoes.setContentAreaFilled(false);
		btnSideConsommeSeasonedPotatoes.setBorderPainted(false);
		btnSideConsommeSeasonedPotatoes.setFocusPainted(false);
		btnSideConsommeSeasonedPotatoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSideConsommeSeasonedPotatoes.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/콘소메양념감자이름가격.png")));
				//(new ImageIcon(".\\image\\콘소메양념감자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSideConsommeSeasonedPotatoes.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/콘소메양념감자.png")));
				//(new ImageIcon(".\\image\\콘소메양념감자.png"));
			}
		});
		btnSideConsommeSeasonedPotatoes.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/콘소메양념감자.png")));
		//(new ImageIcon(".\\image\\콘소메양념감자.png"));
		btnSideConsommeSeasonedPotatoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sideName = "콘소메양념감자";
				showSideNamePriceRead(sideName);
				orderSum();
			}
		});
		btnSideConsommeSeasonedPotatoes.setBounds(402, 0, 200, 200);
		panelSideMenu.add(btnSideConsommeSeasonedPotatoes);
		
		btnSideSweetRiceCheeseBalls = new JButton("");
		btnSideSweetRiceCheeseBalls.setVisible(false);
		
		btnSideSweetRiceCheeseBalls.setContentAreaFilled(false);
		btnSideSweetRiceCheeseBalls.setBorderPainted(false);
		btnSideSweetRiceCheeseBalls.setFocusPainted(false);
		btnSideSweetRiceCheeseBalls.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSideSweetRiceCheeseBalls.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/찰지츠볼이름가격.png")));
				//(new ImageIcon(".\\image\\찰지츠볼이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSideSweetRiceCheeseBalls.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/찰치즈볼.png")));
				//(new ImageIcon(".\\image\\찰치즈볼.png"));
			}
		});
		btnSideSweetRiceCheeseBalls.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/찰치즈볼.png")));
				//(".\\image\\찰치즈볼.png"));
		btnSideSweetRiceCheeseBalls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sideName = "찰치즈볼";
				showSideNamePriceRead(sideName);
				orderSum();
			}
		});
		btnSideSweetRiceCheeseBalls.setBounds(603, 0, 200, 200);
		panelSideMenu.add(btnSideSweetRiceCheeseBalls);
		
		btnSideGreenSalad = new JButton("");
		btnSideGreenSalad.setVisible(false);
		
		btnSideGreenSalad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSideGreenSalad.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/그린샐러드이름가격.png")));
				//(new ImageIcon(".\\image\\그린샐러드이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSideGreenSalad.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/그린샐러드.png")));
				//(new ImageIcon(".\\image\\그린샐러드.png"));
			}
		});
		btnSideGreenSalad.setContentAreaFilled(false);
		btnSideGreenSalad.setBorderPainted(false);
		btnSideGreenSalad.setFocusPainted(false);
		btnSideGreenSalad.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/그린샐러드.png")));
		//(new ImageIcon(".\\image\\그린샐러드.png"));
		btnSideGreenSalad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sideName = "그린샐러드";
				showSideNamePriceRead(sideName);
				orderSum();
			}
		});
		btnSideGreenSalad.setBounds(804, 0, 200, 200);
		panelSideMenu.add(btnSideGreenSalad);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/피자배경.png")));
		//(new ImageIcon(".\\image\\피자배경.png"));
		lblNewLabel_2.setBounds(0, 0, 1018, 618);
		panelSideMenu.add(lblNewLabel_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 619, 305, 246);
		panelOrderMenuBackground.add(scrollPane);
		
		//사용자가 메뉴 클릭하면 메뉴 추가 
		tableOrderPizzaMenu = new JTable();//테이블 생성
		//컬럼 폰트 크기
		tableOrderPizzaMenu.getTableHeader().setFont(new Font("굴림",Font.PLAIN, 15));
		tableOrderPizzaMenu.setRowHeight(26);//행높이
		tableOrderPizzaMenu.setFont(new Font("굴림", Font.PLAIN, 15));
		pizzaModel = new DefaultTableModel(null, COLUMN_PIZZA);
		
		tableOrderPizzaMenu.setModel(pizzaModel);
		
		//컬럼 너비조절
		tableOrderPizzaMenu.getColumn("피자").setPreferredWidth(90);
		tableOrderPizzaMenu.getColumn("피자$가격").setPreferredWidth(40);
		tableOrderPizzaMenu.getColumn("요리사").setPreferredWidth(60);
		//table.getColumn("컬럼이름").setPreferredWidth(크기숫자로지정);
		
		
		//행 정렬
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		tableOrderPizzaMenu.getColumn("피자").setCellRenderer(celAlignCenter);
		tableOrderPizzaMenu.getColumn("피자$가격").setCellRenderer(celAlignCenter);
		tableOrderPizzaMenu.getColumn("요리사").setCellRenderer(celAlignCenter);
		
//		DefaultTableCellRenderer celAlignRIGHT = new DefaultTableCellRenderer();
//		celAlignRIGHT.setHorizontalAlignment(JLabel.RIGHT);
//		tableOrderPizzaMenu.getColumn("피자$가격").setCellRenderer(celAlignCenter);
		
//		tableOrderPizzaMenu.setModel(orderModel);
		//TODO
		scrollPane.setViewportView(tableOrderPizzaMenu);
		
		//실행시 사용자가 테이블 컬럼 이동 불가
		tableOrderPizzaMenu.getTableHeader().setReorderingAllowed(false); 
		
		
		btnPaymentButton = new JButton("");
		btnPaymentButton.setContentAreaFilled(false);
		btnPaymentButton.setBorderPainted(false);
		btnPaymentButton.setFocusPainted(false);
		btnPaymentButton.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리버튼.png")));
		//(new ImageIcon(".\\image\\개구리버튼.png"));
		//주문하기 버튼 클릭시 실행 되는 코드
		btnPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rowPizzaResult = tableOrderPizzaMenu.getRowCount();
				int rowDrinkResult = tableOrderDrink.getRowCount();
				int rowSideResult = tableOrderSide.getRowCount();
				
				if(rowPizzaResult == 0 && rowDrinkResult == 0 && rowSideResult == 0) {
					JOptionPane.showMessageDialog(frame, "주문 메뉴를 선택해주세요", "선택없음오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				OrderingFrame.showOrderingFrame(FrogPizzaFrame.this, lloginId);
				
//				//테이블 초기화
//				pizzaModel.setNumRows(0);
//				drinkModel.setNumRows(0);
//				sideModel.setNumRows(0);
				//TODO
				
			}
		});
		btnPaymentButton.setBounds(891, 765, 97, 85);
		panelOrderMenuBackground.add(btnPaymentButton);
		
		textTotalsum = new JTextField();
		textTotalsum.setHorizontalAlignment(SwingConstants.RIGHT);
		textTotalsum.setFont(new Font("굴림", Font.BOLD, 30));
		
		//TODO
		//textTotalsum.setText();
		
		
		textTotalsum.setBounds(787, 700, 213, 46);
		panelOrderMenuBackground.add(textTotalsum);
		textTotalsum.setColumns(10);
		
		lblPaymentAmount = new JLabel("");
		lblPaymentAmount.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/결제금액.png")));
		//(new ImageIcon(".\\image\\결제금액.png"));
		lblPaymentAmount.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		lblPaymentAmount.setBounds(790, 657, 100, 30);
		panelOrderMenuBackground.add(lblPaymentAmount);
		
		panelShoppinBasket = new JPanel();
		panelShoppinBasket.setVisible(false);
		panelShoppinBasket.setLayout(null);
		panelShoppinBasket.setBounds(0, 0, 1018, 618);
		panelOrderMenuBackground.add(panelShoppinBasket);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리주인장.png")));
		//(new ImageIcon(".\\image\\피자메인판넬.png"));
		lblNewLabel_6.setBounds(0, 0, 1018, 618);
		panelShoppinBasket.add(lblNewLabel_6);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(307, 619, 213, 246);
		panelOrderMenuBackground.add(scrollPane_1);
		
		//테이블에 컬럼 넣음
		tableOrderDrink = new JTable();

		
//		//컬럼 너비조절
//		tableOrderDrink.getColumn("음료").setPreferredWidth(30);
//		tableOrderDrink.getColumn("음료$가격").setPreferredWidth(10);
		//table.getColumn("컬럼이름").setPreferredWidth(크기숫자로지정);
//		
//		
//		//행 정렬
////		celAlignCenter = new DefaultTableCellRenderer();
////		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
//		tableOrderDrink.getColumn("음료").setCellRenderer(celAlignCenter);
//		tableOrderDrink.getColumn("음료$가격").setCellRenderer(celAlignCenter);

		

		
		scrollPane_1.setViewportView(tableOrderDrink);
		drinkModel = new DefaultTableModel(null, COLUMN_DRINK);
		tableOrderDrink.setModel(drinkModel);
		
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(523, 619, 252, 246);
		panelOrderMenuBackground.add(scrollPane_2);
		//컬럼 폰트 크기
		tableOrderDrink.getTableHeader().setFont(new Font("굴림",Font.PLAIN, 15));
		tableOrderDrink.setRowHeight(26);
		tableOrderDrink.setFont(new Font("굴림", Font.PLAIN, 15));
		
		//실행시 사용자가 컬럼이동 불가
		tableOrderDrink.getTableHeader().setReorderingAllowed(false); 
		
		//컬럼 너비조절
		tableOrderDrink.getColumn("음료").setPreferredWidth(80);
		tableOrderDrink.getColumn("음료$가격").setPreferredWidth(25);
//		table.getColumn("컬럼이름").setPreferredWidth(크기숫자로지정);
//		
//		
//		//행 정렬
////		celAlignCenter = new DefaultTableCellRenderer();
////		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		tableOrderDrink.getColumn("음료").setCellRenderer(celAlignCenter);
		tableOrderDrink.getColumn("음료$가격").setCellRenderer(celAlignCenter);
		
		
		
		//테이블에 컬럼 넣음
		tableOrderSide = new JTable();
		
		//컬럼 폰트 크기
		tableOrderSide.getTableHeader().setFont(new Font("굴림",Font.PLAIN, 15));
		
		tableOrderSide.setRowHeight(26);
		tableOrderSide.setFont(new Font("굴림", Font.PLAIN, 15));
		sideModel = new DefaultTableModel(null, COLUMN_SIDE);
		tableOrderSide.setModel(sideModel);
		
		scrollPane_2.setViewportView(tableOrderSide);
		
		//컬럼 너비조절
		tableOrderSide.getColumn("사이드").setPreferredWidth(80);
		tableOrderSide.getColumn("사이드$가격").setPreferredWidth(25);
		//table.getColumn("컬럼이름").setPreferredWidth(크기숫자로지정);
//		
//		
//		//행 정렬
////		celAlignCenter = new DefaultTableCellRenderer();
////		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		tableOrderSide.getColumn("사이드").setCellRenderer(celAlignCenter);
		tableOrderSide.getColumn("사이드$가격").setCellRenderer(celAlignCenter);
		
		
		lblOrderTableBackgroundImage = new JLabel("");
		lblOrderTableBackgroundImage.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/피자메인판넬.png")));
		//(new ImageIcon(".\\image\\피자메인판넬.png"));
		lblOrderTableBackgroundImage.setBounds(0, 0, 1018, 961);
		panelOrderMenuBackground.add(lblOrderTableBackgroundImage);
		btnSideMenu.setBounds(509, 0, 255, 96);
		panelMainMenuBackground.add(btnSideMenu);
		
		//실행시 사용자가 컬럼이동 불가
		tableOrderSide.getTableHeader().setReorderingAllowed(false); 
		
		btnShoppinBasket = new JButton("");
		btnShoppinBasket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnShoppinBasket.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리주인장버튼드래그.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnShoppinBasket.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리주인장버튼.png")));
			}
		});
		btnShoppinBasket.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/개구리주인장버튼.png")));
		btnShoppinBasket.setContentAreaFilled(false);
		btnShoppinBasket.setBorderPainted(false);
		btnShoppinBasket.setFocusPainted(false);
		btnShoppinBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelShoppinBasket.setVisible(true);
				panelPizzaMenu.setVisible(false);
				panelDrinkMenu.setVisible(false);
				panelSideMenu.setVisible(false);
				
			}
		});
		btnShoppinBasket.setBounds(762, 0, 255, 96);
		panelMainMenuBackground.add(btnShoppinBasket);
		
		btnPizzaMenu = new JButton("");
		btnPizzaMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPizzaMenu.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/피자드래그.png")));
				//(new ImageIcon(".\\image\\피자드래그.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPizzaMenu.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/피자버튼.png")));
				//(new ImageIcon(".\\image\\피자버튼.png"));
			}
		});
		btnPizzaMenu.setContentAreaFilled(false);
		btnPizzaMenu.setBorderPainted(false);
		btnPizzaMenu.setFocusPainted(false);
		btnPizzaMenu.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/피자버튼.png")));
		//(new ImageIcon(".\\image\\피자버튼.png"));
		
		btnPizzaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPizzaMenu.setVisible(true);
				
				btnCheesePizza.setVisible(true);
				btnBananaPizza.setVisible(true);
				btnBulgogiPizza.setVisible(true);
				btnMalaFlavorPizza.setVisible(true);
				btnMintChocolatePizza.setVisible(true);
				btnMushroom.setVisible(true);
				btnPepperoniPizza.setVisible(true);
				btnPotatoPizza.setVisible(true);
				btnPrFrogPizza.setVisible(true);
				btnShrimpPizza.setVisible(true);
				btnSweetPotatoPizza.setVisible(true);
				btnTomatoPizza.setVisible(true);
				btnVegetablePizza.setVisible(true);
				btnWesternSpinachPizza.setVisible(true);
				btnPineapplePizza.setVisible(true);
				
				
				panelDrinkMenu.setVisible(false);
				btnDrinkCoke.setVisible(false);
				btnDrinkFrogAde.setVisible(false);
				btnDrinkSprite.setVisible(false);
				btnDrinkZeroCoke.setVisible(false);
				
				panelSideMenu.setVisible(false);
				btnSideConsommeSeasonedPotatoes.setVisible(false);
				btnSideGreenSalad.setVisible(false);
				btnSidePastaFullOfBacon.setVisible(false);
				btnSideSpaghettiFullOfPepperoni.setVisible(false);
				btnSideSweetRiceCheeseBalls.setVisible(false);
				
				panelShoppinBasket.setVisible(false);
				panelOrderConfirmation.setVisible(false);
				
				
			}
		});
		btnPizzaMenu.setBounds(0, 0, 255, 96);
		panelMainMenuBackground.add(btnPizzaMenu);
		
		btnDrinkMenu = new JButton("");
		btnDrinkMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDrinkMenu.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/음료드래그.png")));
				//(new ImageIcon(".\\image\\음료드래그.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDrinkMenu.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/음료버튼.png")));
				//(new ImageIcon(".\\image\\음료버튼.png"));
			}
		});
		btnDrinkMenu.setContentAreaFilled(false);
		btnDrinkMenu.setBorderPainted(false);
		btnDrinkMenu.setFocusPainted(false);
		btnDrinkMenu.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/음료버튼.png")));
		//(new ImageIcon(".\\image\\음료버튼.png"));
		
		btnDrinkMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDrinkMenu.setVisible(true);
				btnDrinkCoke.setVisible(true);
				btnDrinkFrogAde.setVisible(true);
				btnDrinkSprite.setVisible(true);
				btnDrinkZeroCoke.setVisible(true);
				
				panelPizzaMenu.setVisible(false);
				
				btnCheesePizza.setVisible(false);
				btnBananaPizza.setVisible(false);
				btnBulgogiPizza.setVisible(false);
				btnMalaFlavorPizza.setVisible(false);
				btnMintChocolatePizza.setVisible(false);
				btnMushroom.setVisible(false);
				btnPepperoniPizza.setVisible(false);
				btnPotatoPizza.setVisible(false);
				btnPrFrogPizza.setVisible(false);
				btnShrimpPizza.setVisible(false);
				btnSweetPotatoPizza.setVisible(false);
				btnTomatoPizza.setVisible(false);
				btnVegetablePizza.setVisible(false);
				btnWesternSpinachPizza.setVisible(false);
				btnPineapplePizza.setVisible(false);
				
				panelSideMenu.setVisible(false);
				
				btnSideConsommeSeasonedPotatoes.setVisible(false);
				btnSideGreenSalad.setVisible(false);
				btnSidePastaFullOfBacon.setVisible(false);
				btnSideSpaghettiFullOfPepperoni.setVisible(false);
				btnSideSweetRiceCheeseBalls.setVisible(false);
				
				panelShoppinBasket.setVisible(false);
				
				
			}
		});
		btnDrinkMenu.setBounds(254, 0, 255, 96);
		panelMainMenuBackground.add(btnDrinkMenu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/메뉴선택배경.png")));
		//(new ImageIcon(".\\image\\메뉴선택배경.png"));
		lblNewLabel.setBounds(0, 0, 1018, 96);
		panelMainMenuBackground.add(lblNewLabel);
		
		//TODO - 테이블에 컬럼 집어 넣음.
		//orderModel = new DefaultTableModel(null,COLUMN_NAMES);
		
		panelSelectBtn = new JPanel();
		panelSelectBtn.setBounds(0, 0, 226, 961);
		frame.getContentPane().add(panelSelectBtn);
		panelSelectBtn.setLayout(null);
		
		btnOrderMenuButton = new JButton("");
		btnOrderMenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOrderMenuButton.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/메뉴드래그.png")));
				//(new ImageIcon(".\\image\\메뉴드래그.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOrderMenuButton.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/메뉴보기버튼.png")));
				//(new ImageIcon(".\\image\\메뉴보기버튼.png"));
			}
		});
		btnOrderMenuButton.setContentAreaFilled(false);
		btnOrderMenuButton.setBorderPainted(false);
		btnOrderMenuButton.setFocusPainted(false);
		btnOrderMenuButton.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/메뉴보기버튼.png")));
		//(new ImageIcon(".\\image\\메뉴보기버튼.png"));
		
		btnOrderMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelMainMenuBackground.setVisible(true);
				panelPizzaMenu.setVisible(true);
				
				btnCheesePizza.setVisible(true);
				btnBananaPizza.setVisible(true);
				btnBulgogiPizza.setVisible(true);
				btnMalaFlavorPizza.setVisible(true);
				btnMintChocolatePizza.setVisible(true);
				btnMushroom.setVisible(true);
				btnPepperoniPizza.setVisible(true);
				btnPotatoPizza.setVisible(true);
				btnPrFrogPizza.setVisible(true);
				btnShrimpPizza.setVisible(true);
				btnSweetPotatoPizza.setVisible(true);
				btnTomatoPizza.setVisible(true);
				btnVegetablePizza.setVisible(true);
				btnWesternSpinachPizza.setVisible(true);
				btnPineapplePizza.setVisible(true);
				
				
				panelDrinkMenu.setVisible(false);
				btnDrinkCoke.setVisible(false);
				btnDrinkFrogAde.setVisible(false);
				btnDrinkSprite.setVisible(false);
				btnDrinkZeroCoke.setVisible(false);
				
				panelSideMenu.setVisible(false);
				btnSideConsommeSeasonedPotatoes.setVisible(false);
				btnSideGreenSalad.setVisible(false);
				btnSidePastaFullOfBacon.setVisible(false);
				btnSideSpaghettiFullOfPepperoni.setVisible(false);
				btnSideSweetRiceCheeseBalls.setVisible(false);
				
				panelShoppinBasket.setVisible(false);
				panelOrderConfirmation.setVisible(false);
				
				
				
			}
		});
		
		JButton btnPizzaOrderCancle = new JButton("");
		btnPizzaOrderCancle.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/피자주문취소.png")));
		btnPizzaOrderCancle.setContentAreaFilled(false);
		btnPizzaOrderCancle.setBorderPainted(false);
		btnPizzaOrderCancle.setFocusPainted(false);
		btnPizzaOrderCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePizza();
				orderSum();
				
			}
		});
		
		btnSideOrderCancle = new JButton("");
		btnSideOrderCancle.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/사이드주문취소.png")));
		btnSideOrderCancle.setContentAreaFilled(false);
		btnSideOrderCancle.setBorderPainted(false);
		btnSideOrderCancle.setFocusPainted(false);
		btnSideOrderCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteSide();
				orderSum();
			}
		});
		btnSideOrderCancle.setBounds(50, 780, 120, 24);
		panelSelectBtn.add(btnSideOrderCancle);
		
		btnDrinkOrderCancle = new JButton("");
		btnDrinkOrderCancle.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/음료주문취소.png")));
		btnDrinkOrderCancle.setContentAreaFilled(false);
		btnDrinkOrderCancle.setBorderPainted(false);
		btnDrinkOrderCancle.setFocusPainted(false);
		btnDrinkOrderCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteDrink();
				orderSum();
			}
		});
		btnDrinkOrderCancle.setBounds(50, 750, 120, 24);
		panelSelectBtn.add(btnDrinkOrderCancle);
		btnPizzaOrderCancle.setBounds(50, 720, 120, 24);
		panelSelectBtn.add(btnPizzaOrderCancle);
		btnOrderMenuButton.setBounds(0, 97, 226, 96);
		panelSelectBtn.add(btnOrderMenuButton);
		
		btnOrderDetailsButton = new JButton("");
		btnOrderDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//showOrderHistory(lloginId);
				//showOrderHistory2(lloginId);
				//showOrderTable(lloginId);
				showOrderHistory(lloginId);
				
				panelOrderConfirmation.setVisible(true);
				lblOrderConfirmationB.setVisible(true);
				//showOrderHistory(lloginId);
				
				
				panelMainMenuBackground.setVisible(false);
				panelMain.setVisible(false);
				
				panelPizzaMenu.setVisible(false);
				
				btnCheesePizza.setVisible(false);
				btnBananaPizza.setVisible(false);
				btnBulgogiPizza.setVisible(false);
				btnMalaFlavorPizza.setVisible(false);
				btnMintChocolatePizza.setVisible(false);
				btnMushroom.setVisible(false);
				btnPepperoniPizza.setVisible(false);
				btnPotatoPizza.setVisible(false);
				btnPrFrogPizza.setVisible(false);
				btnShrimpPizza.setVisible(false);
				btnSweetPotatoPizza.setVisible(false);
				btnTomatoPizza.setVisible(false);
				btnVegetablePizza.setVisible(false);
				btnWesternSpinachPizza.setVisible(false);
				btnPineapplePizza.setVisible(false);
				
				
				panelDrinkMenu.setVisible(false);
				btnDrinkCoke.setVisible(false);
				btnDrinkFrogAde.setVisible(false);
				btnDrinkSprite.setVisible(false);
				btnDrinkZeroCoke.setVisible(false);
				
				panelSideMenu.setVisible(false);
				btnSideConsommeSeasonedPotatoes.setVisible(false);
				btnSideGreenSalad.setVisible(false);
				btnSidePastaFullOfBacon.setVisible(false);
				btnSideSpaghettiFullOfPepperoni.setVisible(false);
				btnSideSweetRiceCheeseBalls.setVisible(false);
				
				panelShoppinBasket.setVisible(false);
				
				
				

				
			}
		});
		btnOrderDetailsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOrderDetailsButton.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/주문내역드래그.png")));
				//(new ImageIcon(".\\image\\주문내역드래그.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOrderDetailsButton.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/주문내역버튼.png")));
				//(new ImageIcon(".\\image\\주문내역버튼.png"));
			}
		});
		btnOrderDetailsButton.setContentAreaFilled(false);
		btnOrderDetailsButton.setBorderPainted(false);
		btnOrderDetailsButton.setFocusPainted(false);
		btnOrderDetailsButton.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/주문내역버튼.png")));
		//(new ImageIcon(".\\image\\주문내역버튼.png"));
		btnOrderDetailsButton.setBounds(0, 192, 226, 96);
		panelSelectBtn.add(btnOrderDetailsButton);
		
		btnLogOut = new JButton("");
		btnLogOut.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/로그아웃.png")));
		btnLogOut.setContentAreaFilled(false);
		btnLogOut.setBorderPainted(false);
		btnLogOut.setFocusPainted(false);
		
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frogPizzaLoginFrame.showLogin();
				logOut();
			}
		});
		btnLogOut.setBounds(50, 370, 97, 24);
		panelSelectBtn.add(btnLogOut);
		
		lblIdName = new JLabel("");
		lblIdName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		String showLoginId = lloginId + "님";
		lblIdName.setText(showLoginId);
		
		lblIdName.setBounds(40, 310, 200, 30);
		panelSelectBtn.add(lblIdName);
		
		lblToday = new JLabel("");
		LocalDate now = LocalDate.now();         
		String showToday = now + "";
		
		JLabel lblNewLabel_3 = new JLabel("피자를 주문해주세요");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(40, 335, 200, 30);
		panelSelectBtn.add(lblNewLabel_3);
		lblToday.setText(showToday);
		lblToday.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblToday.setBounds(40, 290, 200, 30);
		panelSelectBtn.add(lblToday);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/로고메인.png")));
		//(new ImageIcon(".\\image\\로고메인.png"));
		lblNewLabel_4.setBounds(0, 0, 227, 94);
		panelSelectBtn.add(lblNewLabel_4);
		
		JLabel lblSideBackgroundImage = new JLabel("");
		lblSideBackgroundImage.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/왼쪽판넬메뉴배경.png")));
		//(new ImageIcon(".\\image\\왼쪽판넬메뉴배경.png"));
		lblSideBackgroundImage.setBounds(0, 0, 230, 961);
		panelSelectBtn.add(lblSideBackgroundImage);
		
		//TODO
		panelMain = new JPanel();
		//panelMain = new ImagePanel();
		panelMain.setBounds(0, 0, 1244, 961);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		JLabel lblMainBackgroundImage = new JLabel("");
		lblMainBackgroundImage.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/피자메인판넬.png")));
		//(new ImageIcon(".\\image\\피자메인판넬.png"));
		lblMainBackgroundImage.setBounds(0, 0, 1244, 961);
		panelMain.add(lblMainBackgroundImage);
		
		panelOrderConfirmation = new JPanel();
		
		panelOrderConfirmation.setLayout(null);
		panelOrderConfirmation.setBounds(226, 0, 1018, 961);
		frame.getContentPane().add(panelOrderConfirmation);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(35, 97, 944, 800);
		panelOrderConfirmation.add(scrollPane_3);
		
		tableOrderConfirmation = new JTable();
		
		//정렬
//		TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableOrderConfirmation.getModel());
//		tableOrderConfirmation.setRowSorter(sorter);
		//frame.pack();
		
		//사용자가 메뉴 클릭하면 메뉴 추가 
				
				//컬럼 폰트 크기
		tableOrderConfirmation.getTableHeader().setFont(new Font("굴림",Font.PLAIN, 20));
		tableOrderConfirmation.setRowHeight(26);//행높이
		tableOrderConfirmation.setFont(new Font("굴림", Font.PLAIN, 15));
		orderModel = new DefaultTableModel(null, COLUMN_ORDER_HISTORY);
				
		tableOrderConfirmation.setModel(orderModel);
		
		
		
		//private static final String[] COLUMN_ORDER_HISTORY = {"아이디","피자주문내역","음료주문내역","사이드주문내역","주문금액합계","식사방식","주문시간"};
				//컬럼 너비조절
		tableOrderConfirmation.getColumn("아이디").setPreferredWidth(5);
		tableOrderConfirmation.getColumn("피자주문내역").setPreferredWidth(90);
		tableOrderConfirmation.getColumn("음료주문내역").setPreferredWidth(90);
		tableOrderConfirmation.getColumn("사이드주문내역").setPreferredWidth(90);
		tableOrderConfirmation.getColumn("주문금액").setPreferredWidth(5);
//		tableOrderConfirmation.getColumn("식사방식").setPreferredWidth(30);
		tableOrderConfirmation.getColumn("주문시간").setPreferredWidth(100);
				//table.getColumn("컬럼이름").setPreferredWidth(크기숫자로지정);
				
				
				//행 정렬
				celAlignCenter = new DefaultTableCellRenderer();
				celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
				tableOrderConfirmation.getColumn("아이디").setCellRenderer(celAlignCenter);
//				tableOrderConfirmation.getColumn("피자주문내역").setCellRenderer(celAlignCenter);
//				tableOrderConfirmation.getColumn("음료주문내역").setCellRenderer(celAlignCenter);
//				tableOrderConfirmation.getColumn("사이드주문내역").setCellRenderer(celAlignCenter);
//				tableOrderConfirmation.getColumn("주문금액합계").setCellRenderer(celAlignCenter);
//				tableOrderConfirmation.getColumn("식사방식").setCellRenderer(celAlignCenter);
//				tableOrderConfirmation.getColumn("주문시간").setCellRenderer(celAlignCenter);
				
				DefaultTableCellRenderer celAlignRIGHT = new DefaultTableCellRenderer();
				celAlignRIGHT.setHorizontalAlignment(JLabel.RIGHT);
				tableOrderConfirmation.getColumn("주문금액").setCellRenderer(celAlignRIGHT);
//				tableOrderPizzaMenu.getColumn("피자$가격").setCellRenderer(celAlignCenter);
				//TODO
				//scrollPane.setViewportView(tableOrderPizzaMenu);
				
				//실행시 사용자가 테이블 컬럼 이동 불가
		tableOrderConfirmation.getTableHeader().setReorderingAllowed(false); 
		scrollPane_3.setViewportView(tableOrderConfirmation);
		
		lblNewLabel_5 = new JLabel("주문내역");
		lblNewLabel_5.setFont(new Font("새굴림", Font.BOLD, 30));
		lblNewLabel_5.setBounds(50, 30, 300, 70);
		panelOrderConfirmation.add(lblNewLabel_5);
		
		lblOrderConfirmationB = new JLabel("");
		
		lblOrderConfirmationB.setIcon(new ImageIcon(getClass().getResource("/com/itwill/project01/image/주문내역배경.png")));
		//(new ImageIcon(".\\image\\주문내역배경.png"));
		lblOrderConfirmationB.setBounds(0, 0, 1018, 961);
		panelOrderConfirmation.add(lblOrderConfirmationB);
		
		//ImagePanel panelMain =new ImagePanel(new ImageIcon(".\\image\\피자메인판넬.png").getImage());
	
	}
	
	

	private List<OrderMenuAll> showSideNamePriceRead(String sideName) {
		this.cKSideName = sideName;
		List<OrderMenuAll> orderFrogSide = new ArrayList<>();
		orderFrogSide = orderMenuDao.ckFrogSideMenuRead(sideName);
		//System.out.println(orderFrogSide);
		for(OrderMenuAll o : orderFrogSide) {
			Object[] row = {
					o.getSideName(),
					o.getSidePrice()
			};
			
			sideModel.addRow(row);
		}
		return orderFrogSide;
		
	}

	private List<OrderMenuAll> showPizzaNameAndPriceTableOrderMenu(String pizzaName) { //List<OrderMenuAll>
		
//	showPizzaNameAndPriceTableOrderMenu(ckPizzaName);
	this.ckPizzaName = pizzaName;
	List<OrderMenuAll> orderFrogPizza = new ArrayList<>();
	orderFrogPizza = orderMenuDao.ckFrogPizzaMenuRead(pizzaName);
	// TODO 프린트 주석 나중에 지우기
	//System.out.println(orderFrogPizza);
		for (OrderMenuAll o : orderFrogPizza) {
		
		Object[] row = {
				o.getPizzaName(),
				o.getPizzaPrice(),
				o.getPizzaCook()
			};
		pizzaModel.addRow(row);
	}
	return orderFrogPizza;
	}//orderFrogDrink;
		
	

	private List<OrderMenuAll> showDrinkMenuOrder(String drinkName) {
//		showPizzaNameAndPriceTableOrderMenu(ckPizzaName);
		this.cKDinkName = drinkName;
		List<OrderMenuAll> orderFrogDrink = new ArrayList<>();
		orderFrogDrink = orderMenuDao.ckFrogDrinkMenuRead(drinkName);
		// TODO 프린트 주석 나중에 지우기
		//System.out.println(orderFrogDrink);
		for (OrderMenuAll o : orderFrogDrink) {
			Object[] row = {
					o.getDrinkName(),
					o.getDrinkPrice()
//					,
//					o.getDrinkName(),
//					o.getDrinkPrice(),
//					o.getSideName(),
//					o.getSidePrice(),
//					o.getPizzaCook(),
//					o.getPizzaPopularity() 
					};
			drinkModel.addRow(row);
		}
		return orderFrogDrink;
		}
	
//	//TODO
//	private String valuesSum () {
//		int result = 0;
//		try {
//			System.out.println(tableOrderPizzaMenu.getValueAt(1, 2));
//			if(tableOrderPizzaMenu.getRowCount() != 0 ) {
//				for(int i = 0;i <= tableOrderPizzaMenu.getRowCount() ;i++) {
//					result += (int) tableOrderPizzaMenu.getValueAt(i, 2);
//				}
//				return result+"";
//			}
//		}
//		catch (Exception e) {
//			return "";
//		}
//		return "";
		
//		int result = 0;
//		
//		if(tableOrderPizzaMenu.getRowCount() == 0) {
//			return "";
//			}
//		else {
//			for(int i = 0 ; i <= tableOrderPizzaMenu.getRowCount() -1; i++) {
//			result += (int) tableOrderPizzaMenu.getValueAt(i, 1);
//		
//		}
//		
//		return "" + result;
//		}
//	}
		
//	//주문합계
//	private String orderSum(int ... values) {
//		int sum = 0;
//		for(int i = 0 ;i < values.length ; i++) {
//			sum += values[i];
//		}
//		return "" + sum;
//	}

	
	private void orderSum() {
		//TODO
		String result1 = "";
		String result2= "";
		String result3 = "";
		int resultPizzaSum = 0;
		int resultDrinkSum = 0;
		int resultSideSum = 0;
		int orderSum = 0;
		
		for(int p = 0;p <= tableOrderPizzaMenu.getRowCount()-1;p++) {
			result1 = tableOrderPizzaMenu.getValueAt(p, 1).toString();
			resultPizzaSum += Integer.parseInt(result1);
			//System.out.println(resultSum);
			//textTotalsum.setText(resultSum + "");
			
//			for(int d = 0;d <= tableOrderDrink.getRowCount()-1;d++) {
//				result2 = tableOrderDrink.getValueAt(d, 1).toString();
//				resultDrinkSum += Integer.parseInt(result2);
//				System.out.println(resultDrinkSum);
//				//textTotalsum.setText(resultSum + "");
//				for(int s = 0;s <= tableOrderSide.getRowCount()-1;s++) {
//					result3 = tableOrderSide.getValueAt(s, 1).toString();
//					resultSideSum += Integer.parseInt(result3);
//					//System.out.println(resultSum);
//					//textTotalsum.setText(resultSum + "");
//				}
//			}
				
		}
		
		for(int i = 0;i <= tableOrderDrink.getRowCount()-1;i++) {
			result2 = tableOrderDrink.getValueAt(i, 1).toString();
			resultDrinkSum += Integer.parseInt(result2);
			//System.out.println(resultDrinkSum);
			//textTotalsum.setText(resultSum + "");
		}
		
		for(int i = 0;i <= tableOrderSide.getRowCount()-1;i++) {
			result3 = tableOrderSide.getValueAt(i, 1).toString();
			resultSideSum += Integer.parseInt(result3);
			//System.out.println(resultSum);
			//textTotalsum.setText(resultSum + "");
		}
		
		orderSum = resultPizzaSum + resultDrinkSum + resultSideSum;
		textTotalsum.setText(" " + orderSum);
		return;
	}
	
	
	//TODO
//    private void deletePizza() { //피자 주문 취소 : 피자 테이블에서 선택해서 버튼 누르면 이거 호출되서 취소
//        int index = tableOrderPizzaMenu.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
//        if (index == -1) { // JTable에서 선택된 행이 없을 때
//            JOptionPane.showMessageDialog(
//                    frame, 
//                    "삭제할 행을 먼저 선택하세요.", 
//                    "경고", 
//                    JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        
//        int confirm = JOptionPane.showConfirmDialog(
//                frame, 
//                "해당 주문을 취소하시겠습니까?", 
//                "취소 확인", 
//                JOptionPane.YES_NO_OPTION);
//        if (confirm == JOptionPane.YES_OPTION) {
//            // 선택된 행에서 피자 이름 읽음.getValueAt메서드는 오브젝트 객체를 리셋함.
//            String pizzaName = pizzaModel.getValueAt(index, 0).toString();
//        	
//        	
//        	
//            // DAO의 delete 메서드 호출. - 오라클 DB에서 선택된거 삭제함
//            //int result = orderMenuDao.delete(pizzaName);
//           // if (result == 1) {
//                initializeTable(); // 테이블을 새로고침.
//                JOptionPane.showMessageDialog(frame, "삭제 성공!");
//        	//}
//              //else {
//               // JOptionPane.showMessageDialog(frame, "삭제 실패!");
//            //}
//        }
//        
//    }
//	
	
	
	
//	//주문취소 코드시작
//    private void initializeTable() {
//        // DAO를 사용해서 DB 테이블에서 검색.
//    	List<OrderMenuAll> orderPizza = orderMenuDao.ckFrogPizzaMenuRead(ckPizzaName);
//        resetTable(orderPizza); // 테이블 리셋
//    }
//	
//	
//	 private void resetTable(List<OrderMenuAll> orderPizza) {
//	        // 검색한 내용을 JTable에 보여줌 - JTable의 테이블 모델을 재설정.
//	       pizzaModel = new DefaultTableModel(null, COLUMN_PIZZA); // 테이블 모델 리셋.
//	        for (OrderMenuAll o : orderPizza) {
//	            // DB 테이블에서 검색한 레코드를 JTable에서 사용할 행 데이터로 변환.
//	            Object[] row = {
//	                    o.getPizzaName(),
//	                    o.getPizzaPrice(),
//	                    o.getPizzaCook()
//	            };
//	            pizzaModel.addRow(row); // 테이블 모델에 행 데이터를 추가.
//	        }
//	        tableOrderPizzaMenu.setModel(pizzaModel); // JTable의 모델을 다시 세팅.
//	    }
//	 
	 ////////////////////////
	 private void deletePizza() {
	        int index = tableOrderPizzaMenu.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
	       // System.out.println(index);
	        if (index == -1) { // JTable에서 선택된 행이 없을 때
	            JOptionPane.showMessageDialog(
	                    frame, 
	                    "취소할 피자테이블의 행을 선택하세요.", 
	                    "선택오류", 
	                    JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        
	        int confirm = JOptionPane.showConfirmDialog(
	                frame, 
	                "정말 취소할까요?", 
	                "취소 확인", 
	                JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {
	            // 선택된 행에서 블로그 번호(id)를 읽음.
	           // Integer id = (Integer) pizzaModel.getValueAt(index, 0);
	           pizzaModel.removeRow(index);
	            
	            // DAO의 delete 메서드 호출.
	           // int result = dao.delete(id);
	            //if (result == 1) {
	                //initializeTable(); // 테이블을 새로고침.
	                JOptionPane.showMessageDialog(frame, "해당 메뉴를 취소 하였습니다.");
	            //} else {
	            //    JOptionPane.showMessageDialog(frame, "삭제 실패!");
	           // }
	        }
	        
	    }
	 
	 private void deleteDrink() {
	        int index = tableOrderDrink.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
	       // System.out.println(index);
	        if (index == -1) { // JTable에서 선택된 행이 없을 때
	            JOptionPane.showMessageDialog(
	                    frame, 
	                    "취소할 음료테이블의 행을 선택하세요.", 
	                    "선택오류", 
	                    JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        
	        int confirm = JOptionPane.showConfirmDialog(
	                frame, 
	                "정말 취소할까요?", 
	                "취소 확인", 
	                JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {
	            // 선택된 행에서 블로그 번호(id)를 읽음.
	           // Integer id = (Integer) pizzaModel.getValueAt(index, 0);
	           drinkModel.removeRow(index);
	            
	            // DAO의 delete 메서드 호출.
	           // int result = dao.delete(id);
	            //if (result == 1) {
	                //initializeTable(); // 테이블을 새로고침.
	                JOptionPane.showMessageDialog(frame, "해당 메뉴를 취소 하였습니다.");
	            //} else {
	            //    JOptionPane.showMessageDialog(frame, "삭제 실패!");
	           // }
	        }
	        
	    }
	 
	 private void deleteSide() {
	        int index = tableOrderSide.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
	       // System.out.println(index);
	        if (index == -1) { // JTable에서 선택된 행이 없을 때
	            JOptionPane.showMessageDialog(
	                    frame, 
	                    "취소할 사이드 테이블의 행을 선택하세요.", 
	                    "선택오류", 
	                    JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        
	        int confirm = JOptionPane.showConfirmDialog(
	                frame, 
	                "정말 취소할까요?", 
	                "취소 확인", 
	                JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {
	            // 선택된 행에서 블로그 번호(id)를 읽음.
	           // Integer id = (Integer) pizzaModel.getValueAt(index, 0);
	           sideModel.removeRow(index);
	            
	            // DAO의 delete 메서드 호출.
	           // int result = dao.delete(id);
	            //if (result == 1) {
	                //initializeTable(); // 테이블을 새로고침.
	                JOptionPane.showMessageDialog(frame, "해당 메뉴를 취소 하였습니다.");
	            //} else {
	            //    JOptionPane.showMessageDialog(frame, "삭제 실패!");
	           // }
	        }
	        
	    }
	 
	 public void delete() {
			pizzaModel.setNumRows(0);
			drinkModel.setNumRows(0);
			sideModel.setNumRows(0);
			
			orderSum();
	 }
	 
	 public void logOut() {
		 frame.setVisible(false);
		 frogPizzaLoginFrame.showLogin();
	 }

	 
//	 //주문하기 -> 매장 or 포장 클릭시 실행되는 메서드. 
//	 //테이블에서 선택된 값들 읽어옴.
//	 public void saveOrder() {
//		 String getPizzaName = "";
//		 int getPizzaPrice = 0;
//		 String getPizzaCook = "";
//		 
//		 String getDrinkName = "";
//		 int getDrinkPrice = 0;
//		 
//		 String getSideName = "";
//		 int getSidePrice = 0;
//		 
//		 int pizzaSum = 0;//피자 총액
//		 int drinkSum = 0;//음료 총액
//		 int sideSum = 0;//사이드 총액
//		 int total = 0;//전체 총액
//		 
//		 //주문한 피자 정보를 저장하기 위한 리스트.
//		 List<String> orderPizzaResult =new ArrayList<>();
//		 //주문한 음료 정보를 저장하기 위한 리스트.
//		 List<String> orderDrinkResult =new ArrayList<>();
//		 //주문한 사이드 정보를 저장하기 위한 리스트.
//		 List<String> orderSideResult =new ArrayList<>();
//		
//				for(int p = 0;p <= tableOrderPizzaMenu.getRowCount()-1;p++) {
//		 			getPizzaName = tableOrderPizzaMenu.getValueAt(p, 0).toString();
//					getPizzaPrice = (Integer)tableOrderPizzaMenu.getValueAt(p, 1);
//					getPizzaCook = tableOrderPizzaMenu.getValueAt(p, 2).toString();
//					
//					pizzaSum += getPizzaPrice;
//					
//					orderPizzaResult.add(getPizzaName + getPizzaPrice + getPizzaCook);
//					
//					//System.out.println(getPizzaName+getPizzaPrice+getPizzaCook);
////					for(int d = 0;d <= tableOrderDrink.getRowCount()-1;d++) {
////						result2 = tableOrderDrink.getValueAt(d, 1).toString();
////
////
////						for(int s = 0;s <= tableOrderSide.getRowCount()-1;s++) {
////							result3 = tableOrderSide.getValueAt(s, 1).toString();
////
////
////						}
////					}
//						
//				}
////				
//				for(int i = 0;i <= tableOrderDrink.getRowCount()-1;i++) {
//					getDrinkName = tableOrderDrink.getValueAt(i, 0).toString();
//					getDrinkPrice = (Integer)tableOrderDrink.getValueAt(i, 1);
//					//System.out.println(getDrinkName+getDrinkPrice);
//					drinkSum += getDrinkPrice;
//					
//					orderDrinkResult.add(getDrinkName+getDrinkPrice);
//				}
////				
//				for(int i = 0;i <= tableOrderSide.getRowCount()-1;i++) {
//					getSideName = tableOrderSide.getValueAt(i, 0).toString();
//					getSidePrice = (Integer)tableOrderSide.getValueAt(i, 1);
//					
//					sideSum += getSidePrice;
//					
//					orderSideResult.add(getSideName+getSidePrice);
//				}
////				
//			total = pizzaSum + drinkSum + sideSum;//주문 총액
//
//	 }//메서드 끝
	 
	 
	 
	 //매장에서 식사시 DB에 저장시키는 코드.
	 //데이터 베이스에 저장.
	 private static final String SQL_ORDERMENU_INSERT = 
	 String.format(
	            "insert into %s (%s, %s, %s, %s, %s) values (?,?,?,?,?)"
	           // 접속날짜는 로그인시 자동으로 기본값으로 들어감 
	    	,TBL_ORDER_TB,COL_ORDER_ID,//COL_LOGIN_NAME,COL_LOGIN_PHONE,COL_ORDER_EMAIL,COL_ORDER_JOIN_DATE,
	    	COL_ORDER_PIZZA,COL_ORDER_DRINK,COL_ORDER_SIDE,COL_ORDER_TOTAL
			 
			 );

//insert문장 다시적기.->저장시키고,>select문장 만들어서 주문내역뽑아서 테이블에저장
	    public void loginInsertRestaurantEat() {//파라미터..(OrderMenuAll orderMenuAll),(Membership loginMembership)
			 String getPizzaName = "";
			 int getPizzaPrice = 0;
			 String getPizzaCook = "";
			 
			 String getDrinkName = "";
			 int getDrinkPrice = 0;
			 
			 String getSideName = "";
			 int getSidePrice = 0;
			 
			 int pizzaSum = 0;//피자 총액
			 int drinkSum = 0;//음료 총액
			 int sideSum = 0;//사이드 총액
			 int total = 0;//전체 총액
			 
			 //주문한 피자 정보를 저장하기 위한 리스트.
			 List<String> orderPizzaResult =new ArrayList<>();
			String oooderPizza = "";
			 //주문한 음료 정보를 저장하기 위한 리스트.
			 List<String> orderDrinkResult =new ArrayList<>();
			 String oooderDrink = "";
			 //주문한 사이드 정보를 저장하기 위한 리스트.
			 List<String> orderSideResult =new ArrayList<>();
			 String oooderSide = "";
			
					for(int p = 0;p <= tableOrderPizzaMenu.getRowCount()-1;p++) {
			 			getPizzaName = tableOrderPizzaMenu.getValueAt(p, 0).toString();
						getPizzaPrice = (Integer)tableOrderPizzaMenu.getValueAt(p, 1);
						getPizzaCook = tableOrderPizzaMenu.getValueAt(p, 2).toString();
						
						pizzaSum += getPizzaPrice;
						
						orderPizzaResult.add(getPizzaName + getPizzaPrice + getPizzaCook);
						for(String s: orderPizzaResult) {
							oooderPizza += (s + " ");
						}
							
					}
//					
					for(int i = 0;i <= tableOrderDrink.getRowCount()-1;i++) {
						getDrinkName = tableOrderDrink.getValueAt(i, 0).toString();
						getDrinkPrice = (Integer)tableOrderDrink.getValueAt(i, 1);
						//System.out.println(getDrinkName+getDrinkPrice);
						drinkSum += getDrinkPrice;
						
						orderDrinkResult.add(getDrinkName+getDrinkPrice);
						for(String s: orderDrinkResult) {
							oooderDrink += (s + " ");
						}
							
					}
					
//					}
//					
					for(int i = 0;i <= tableOrderSide.getRowCount()-1;i++) {
						getSideName = tableOrderSide.getValueAt(i, 0).toString();
						getSidePrice = (Integer)tableOrderSide.getValueAt(i, 1);
						
						sideSum += getSidePrice;
						
						orderSideResult.add(getSideName+getSidePrice);
						for(String s: orderSideResult) {
							oooderSide += (s + " ");
						}
							
					}
//					}
//					
				total = pizzaSum + drinkSum + sideSum;//주문 총액
	        
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        try {
	            conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속.
	            stmt = conn.prepareStatement(SQL_ORDERMENU_INSERT); // Statement 객체 생성.
	            stmt.setString(1, lloginId); // Statement의 첫번째 ? 채움.
//	            stmt.setString(2, loginMembership.getName()); // Statement의 두번째 ? 채움.
//	            stmt.setString(3, loginMembership.getPhone()); // Statement의 세번째 ? 채움.
//	            stmt.setString(4, loginMembership.getEmail());
//	            stmt.setTimestamp(5, Timestamp.valueOf(loginMembership.getJoinDate()));
	            stmt.setString(2,oooderPizza);
	            stmt.setString(3,oooderDrink);
	            stmt.setString(4,oooderSide);
	            stmt.setString(5,total+"");
	            //Timestamp.valueOf()메서드 안에 아규먼트로 LocalDateTime타입을 넣으면 타임스템프타입으로 변환해줌.
	            stmt.executeUpdate(); // SQL 실행.
	            
	           // LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(conn, stmt);
	        }
	        
	        return;
	    }
	    
	    /**
	     * CRUD 메서드들에서 사용했던 리소스들을 해제.
	     * @param conn Connection 객체
	     * @param stmt Statement 객체
	     * @param rs ResultSet 객체
	     */
	    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * CRUD 메서드들에서 사용했던 리소스들을 해제.
	     * @param conn Connection 객체
	     * @param stmt Statement 객체
	     */
	    private void closeResources(Connection conn, Statement stmt) {
	        closeResources(conn, stmt, null);
	    }
	    //////////////////////////////////////////////////////
	    
	    //포장하기 선택시 DB에 저장되는 코드
		 //데이터 베이스에 저장.
	    private static final String SQL_PACKAING_INSERT = "insert into PACKAING_ORDER_TB (order_id,order_pizza,order_drink,order_side,order_total) values (?,?,?,?,?)";
	    //String.format(
//	            "insert into %s (%s, %s, %s, %s, %s) values (?,?,?,?,?)"
//	           // 접속날짜는 로그인시 자동으로 기본값으로 들어감 
//	    	,TBL_PACKAING_ORDER_TB,//COL_LOGIN_NAME,COL_LOGIN_PHONE,COL_ORDER_EMAIL,COL_ORDER_JOIN_DATE,
//	    	COL_ORDER_ID,COL_ORDER_PIZZA,COL_ORDER_DRINK,COL_ORDER_SIDE,COL_ORDER_TOTAL
//			 
//			 );
	    //"insert into PACKAING_ORDER_TB (order_id,order_pizza,order_drink,order_side,order_total) "
//	    		+ "values (?,?,?,?,?)";
	    		
//	    		String.format(
//		            "insert into %s (%s, %s, %s, %s, %s) values (?,?,?,?,?)"
//		           // 접속날짜는 로그인시 자동으로 기본값으로 들어감 
//		    	,PACKAING_ORDER_TB//COL_LOGIN_NAME,COL_LOGIN_PHONE,COL_ORDER_EMAIL,COL_ORDER_JOIN_DATE,
//		    	,COL_ORDER_PIZZA,COL_ORDER_DRINK,COL_ORDER_SIDE,COL_ORDER_TOTAL
//				 
//				 );

	//insert문장 다시적기.->저장시키고,>select문장 만들어서 주문내역뽑아서 테이블에저장
	    /**
	     * 포장하기 선택하면 오라클에 주문정보가 저장되는 메서드.
	     */
		    public void loginInsertPackaging() {//파라미터..(OrderMenuAll orderMenuAll),(Membership loginMembership)
				 String getPizzaName = "";
				 int getPizzaPrice = 0;
				 String getPizzaCook = "";
				 
				 String getDrinkName = "";
				 int getDrinkPrice = 0;
				 
				 String getSideName = "";
				 int getSidePrice = 0;
				 
				 int pizzaSum = 0;//피자 총액
				 int drinkSum = 0;//음료 총액
				 int sideSum = 0;//사이드 총액
				 int total = 0;//전체 총액
				 
				 //주문한 피자 정보를 저장하기 위한 리스트.
				 List<String> orderPizzaResult =new ArrayList<>();
				String oooderPizza = "";
				 //주문한 음료 정보를 저장하기 위한 리스트.
				 List<String> orderDrinkResult =new ArrayList<>();
				 String oooderDrink = "";
				 //주문한 사이드 정보를 저장하기 위한 리스트.
				 List<String> orderSideResult =new ArrayList<>();
				 String oooderSide = "";
				
						for(int p = 0;p <= tableOrderPizzaMenu.getRowCount()-1;p++) {
				 			getPizzaName = tableOrderPizzaMenu.getValueAt(p, 0).toString();
							getPizzaPrice = (Integer)tableOrderPizzaMenu.getValueAt(p, 1);
							getPizzaCook = tableOrderPizzaMenu.getValueAt(p, 2).toString();
							
							pizzaSum += getPizzaPrice;
							
							orderPizzaResult.add(getPizzaName + getPizzaPrice + getPizzaCook);
							for(String s: orderPizzaResult) {
								oooderPizza += (s + " ");
							}
								
						}
//						
						for(int i = 0;i <= tableOrderDrink.getRowCount()-1;i++) {
							getDrinkName = tableOrderDrink.getValueAt(i, 0).toString();
							getDrinkPrice = (Integer)tableOrderDrink.getValueAt(i, 1);
							//System.out.println(getDrinkName+getDrinkPrice);
							drinkSum += getDrinkPrice;
							
							orderDrinkResult.add(getDrinkName+getDrinkPrice);
							for(String s: orderDrinkResult) {
								oooderDrink += (s + " ");
							}
								
						}
						
//						}
//						
						for(int i = 0;i <= tableOrderSide.getRowCount()-1;i++) {
							getSideName = tableOrderSide.getValueAt(i, 0).toString();
							getSidePrice = (Integer)tableOrderSide.getValueAt(i, 1);
							
							sideSum += getSidePrice;
							
							orderSideResult.add(getSideName+getSidePrice);
							for(String s: orderSideResult) {
								oooderSide += (s + " ");
							}
								
						}
//						}
//						
					total = pizzaSum + drinkSum + sideSum;//주문 총액
		        
		        Connection conn = null;
		        PreparedStatement stmt = null;
		        try {
		            conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속.
		            stmt = conn.prepareStatement(SQL_PACKAING_INSERT); // Statement 객체 생성.
		            stmt.setString(1, lloginId); // Statement의 첫번째 ? 채움.
//		            stmt.setString(2, loginMembership.getName()); // Statement의 두번째 ? 채움.
//		            stmt.setString(3, loginMembership.getPhone()); // Statement의 세번째 ? 채움.
//		            stmt.setString(4, loginMembership.getEmail());
//		            stmt.setTimestamp(5, Timestamp.valueOf(loginMembership.getJoinDate()));
		            stmt.setString(2,oooderPizza);
		            stmt.setString(3,oooderDrink);
		            stmt.setString(4,oooderSide);
		            stmt.setString(5,total+"");
		            //Timestamp.valueOf()메서드 안에 아규먼트로 LocalDateTime타입을 넣으면 타임스템프타입으로 변환해줌.
		            stmt.executeUpdate(); // SQL 실행.
		            
		           // LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            closeResources(conn, stmt);
		        }
		        
		        return;
		    }
	    ///////
		    
		    
		    
//		    ////////////////////////////////////////////////////////////////////////////////////////////
//			public List<OrderTb> showOrderHistory55 (String loginId) {
////				showPizzaNameAndPriceTableOrderMenu(ckPizzaName);
//				//this.loginId = loginId;
//				List<OrderTb> orderHistory = new ArrayList<>();
//				orderHistory = orderTbRead(loginId);
//				// TODO 프린트 주석 나중에 지우기
//				//System.out.println(orderFrogDrink);
//				for (OrderTb o : orderHistory) {
//					Object[] row = {
//							o.getOrderId(),
//							o.getOrderPizza(),
//							o.getOrderDrink(),
//							o.getOrderSide(),
//							o.getOrderTotal(),
//							//o.getOrderMealMethod(),
//							o.getOrderTime()
////							,
////							o.getDrinkName(),
////							o.getDrinkPrice(),
////							o.getSideName(),
////							o.getSidePrice(),
////							o.getPizzaCook(),
////							o.getPizzaPopularity() 
//							};
//					//orderModel.addRow(row);
//					panelHidig();
//				}
//				return orderHistory;
//				}
	    
		    
		    
		    
		    
		    
		    
	    ///////////////////////////////////
		    //주문내역 테이블에 행 추가하기
			public List<OrderTb> showOrderHistory(String loginId) {
//				showPizzaNameAndPriceTableOrderMenu(ckPizzaName);
				//this.loginId = loginId;
				 orderModel = new DefaultTableModel(null, COLUMN_ORDER_HISTORY);
				List<OrderTb> orderHistory = new ArrayList<>();
				orderHistory = orderTbRead(loginId);
				// TODO 프린트 주석 나중에 지우기
				//System.out.println(orderFrogDrink);
				for (OrderTb o : orderHistory) {
					Object[] row = {
							o.getOrderId(),
							o.getOrderPizza(),
							o.getOrderDrink(),
							o.getOrderSide(),
							o.getOrderTotal(),
							//o.getOrderMealMethod(),
							o.getOrderTime()
//							,
//							o.getDrinkName(),
//							o.getDrinkPrice(),
//							o.getSideName(),
//							o.getSidePrice(),
//							o.getPizzaCook(),
//							o.getPizzaPopularity() 
							};
					orderModel.addRow(row);
					panelHidig();
				}
				tableOrderConfirmation.setModel(orderModel);
				return orderHistory;
				}
	    
			
			private static final String SQL_SELECT_ORDER_MENU_RS = String.format(
					"select * from %s where %s = ?", // 주의 여기 sql문장에서는 ;안 붙여야함
					TBL_ORDER_TB, COL_ORDER_ID);
			private JLabel lblNewLabel_5;
				// "select * from FROG_DRINK_MENU_TB where DRINK_NAME = ?";
			
			public List<OrderTb> orderTbRead(String loginId) {
				
					List<OrderTb> result = new ArrayList<>();

					Connection conn = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;

					try {
						// 데이터베이스에 접속.
						conn = DriverManager.getConnection(URL, USER, PASSWORD);
						// 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
						stmt = conn.prepareStatement(SQL_SELECT_ORDER_MENU_RS);
						stmt.setString(1, loginId);
						// SQL 문장을 데이터베이스로 전송해서 실행.
						rs = stmt.executeQuery();
						// 결과 처리.
						while (rs.next()) {
//			            	FrogPizzaMenu frogPizzaMenu = makeFrogPizzaMenuFromResultSet(rs);
							String id = rs.getString(COL_ORDER_ID);
							String pizza = rs.getString(COL_ORDER_PIZZA);
							String drink = rs.getString(COL_ORDER_DRINK);
							String Side = rs.getString(COL_ORDER_SIDE);
							String total = rs.getString(COL_ORDER_TOTAL);
							String meal = rs.getString(COL_ORDER_MEAL_METHOD);
							LocalDateTime orderTime = rs.getTimestamp(COL_ORDER_TIME).toLocalDateTime();
							
							
							OrderTb getorder = new OrderTb(id, pizza, drink, Side, total, meal, orderTime);
							result.add(getorder); // 이름이 result인 리스트에 추가함.
						}

					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						closeResources(conn, stmt, rs);
					}
					//panelHidig();
					return result;
			}
	    
			//테이블 추가시 판넬 안보이게 하는 메서드
			private void panelHidig() {
				panelOrderConfirmation.setVisible(false);
			} 
}//클래스 끝