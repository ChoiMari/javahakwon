package com.itwill.project01.view;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.itwill.project01.controller.OrderMenuDao;


import com.itwill.project01.model.OrderMenuAll;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrogPizzaFrame {
	
	//메뉴 테이블에 넣을 컬럼 상수 선언.
	private static final String[] COLUMN_PIZZA = {"피자","피자$가격","요리사"};
	private static final String[] COLUMN_DRINK = {"음료","음료$가격"};
	private static final String[] COLUMN_SIDE = {"사이드","사이드$가격"};
	
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
	private JButton btnMyProfileButton;
	private JButton btnFrogButton;
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
	private JButton btnNewButton_6;
	
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

	/**
	 * Launch the application.
	 */
	public static void showFrogPizzaFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrogPizzaFrame window = new FrogPizzaFrame(); 
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
	public FrogPizzaFrame() {
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
		Image img = kit.getImage(".\\image\\아이콘.png");
		frame.setIconImage(img);
		
		frame.setLocationRelativeTo(null);//화면 중앙에 뜨게 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelOrderConfirmation = new JPanel();
		
		panelOrderConfirmation.setLayout(null);
		panelOrderConfirmation.setBounds(226, 0, 1018, 961);
		frame.getContentPane().add(panelOrderConfirmation);
		
		lblOrderConfirmationB = new JLabel("");
		
		lblOrderConfirmationB.setIcon(new ImageIcon(".\\image\\주문내역배경.png"));
		lblOrderConfirmationB.setBounds(0, 0, 1018, 961);
		panelOrderConfirmation.add(lblOrderConfirmationB);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(35, 97, 944, 577);
		panelOrderConfirmation.add(scrollPane_3);
		
		tableOrderConfirmation = new JTable();
		scrollPane_3.setViewportView(tableOrderConfirmation);
		
		panelMainMenuBackground = new JPanel();
		panelMainMenuBackground.setBounds(226, 0, 1018, 961);
		frame.getContentPane().add(panelMainMenuBackground);
		panelMainMenuBackground.setLayout(null);
		
		btnSideMenu = new JButton("");
		btnSideMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSideMenu.setIcon(new ImageIcon(".\\image\\사이드드래그.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSideMenu.setIcon(new ImageIcon(".\\image\\사이드버튼.png"));
			}
		});
		btnSideMenu.setContentAreaFilled(false);
		btnSideMenu.setBorderPainted(false);
		btnSideMenu.setFocusPainted(false);
		btnSideMenu.setIcon(new ImageIcon(".\\image\\사이드버튼.png"));
		
		btnSideMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				btnPrFrogPizza.setIcon(new ImageIcon(".\\image\\개구리피자이름가격.png"));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPrFrogPizza.setIcon(new ImageIcon(".\\image\\개구리피자.png"));
			}
		});
		btnPrFrogPizza.setIcon(new ImageIcon(".\\image\\개구리피자.png"));
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
				btnBulgogiPizza.setIcon(new ImageIcon(".\\image\\불고기피자이름가격.png"));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBulgogiPizza.setIcon(new ImageIcon(".\\image\\불고기피자.png"));
			}
		});

		
		
		btnBulgogiPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CkPizzaName = "불고기피자";
				showPizzaNameAndPriceTableOrderMenu(CkPizzaName);
				orderSum();
			}
		});
		
		btnBulgogiPizza.setIcon(new ImageIcon(".\\image\\불고기피자.png"));
		btnBulgogiPizza.setContentAreaFilled(false);
		btnBulgogiPizza.setBorderPainted(false);
		btnBulgogiPizza.setFocusPainted(false);
		
		btnBulgogiPizza.setBounds(221, 0, 200, 200);
		panelPizzaMenu.add(btnBulgogiPizza);
		
		btnMushroom = new JButton("");
		btnMushroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMushroom.setIcon(new ImageIcon(".\\image\\버섯피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMushroom.setIcon(new ImageIcon(".\\image\\버섯피자.png"));
			}
		});
		
		btnMushroom.setIcon(new ImageIcon(".\\image\\버섯피자.png"));
		
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
				btnTomatoPizza.setIcon(new ImageIcon(".\\image\\토마토피자이름가격.png"));
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnTomatoPizza.setIcon(new ImageIcon(".\\image\\토마토피자.png"));
			}
		});
		btnTomatoPizza.setIcon(new ImageIcon(".\\image\\토마토피자.png"));
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
				btnShrimpPizza.setIcon(new ImageIcon(".\\image\\슈림프피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnShrimpPizza.setIcon(new ImageIcon(".\\image\\슈림프피자.png"));
			}
		});
		btnShrimpPizza.setIcon(new ImageIcon(".\\image\\슈림프피자.png"));
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
				btnPepperoniPizza.setIcon(new ImageIcon(".\\image\\페퍼로니피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPepperoniPizza.setIcon(new ImageIcon(".\\image\\페퍼로니피자.png"));
			}
		});
		btnPepperoniPizza.setIcon(new ImageIcon(".\\image\\페퍼로니피자.png"));
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
				btnPotatoPizza.setIcon(new ImageIcon(".\\image\\포테이토피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPotatoPizza.setIcon(new ImageIcon(".\\image\\포테이토피자.png"));
			}
		});
		btnPotatoPizza.setContentAreaFilled(false);
		btnPotatoPizza.setBorderPainted(false);
		btnPotatoPizza.setFocusPainted(false);
		btnPotatoPizza.setIcon(new ImageIcon(".\\image\\포테이토피자.png"));
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
				btnCheesePizza.setIcon(new ImageIcon(".\\image\\치즈피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCheesePizza.setIcon(new ImageIcon(".\\image\\치즈피자.png"));
			}
		});
		btnCheesePizza.setIcon(new ImageIcon(".\\image\\치즈피자.png"));
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
				btnVegetablePizza.setIcon(new ImageIcon(".\\image\\야채피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVegetablePizza.setIcon(new ImageIcon(".\\image\\야채피자.png"));
			}
			
		});
		
		btnVegetablePizza.setContentAreaFilled(false);
		btnVegetablePizza.setIcon(new ImageIcon(".\\image\\야채피자.png"));
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
				btnSweetPotatoPizza.setIcon(new ImageIcon(".\\image\\고구마피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSweetPotatoPizza.setIcon(new ImageIcon(".\\image\\고구마피자.png"));
			}
		});
		btnSweetPotatoPizza.setContentAreaFilled(false);
		btnSweetPotatoPizza.setBorderPainted(false);
		btnSweetPotatoPizza.setFocusPainted(false);
		btnSweetPotatoPizza.setIcon(new ImageIcon(".\\image\\고구마피자.png"));
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
				btnPineapplePizza.setIcon(new ImageIcon(".\\image\\파인애플피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPineapplePizza.setIcon(new ImageIcon(".\\image\\파인애플피자.png"));
			}
		});
		btnPineapplePizza.setIcon(new ImageIcon(".\\image\\파인애플피자.png"));
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
				btnWesternSpinachPizza.setIcon(new ImageIcon(".\\image\\루꼴라피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnWesternSpinachPizza.setIcon(new ImageIcon(".\\image\\루꼴라피자.png"));
			}
		});
		btnWesternSpinachPizza.setContentAreaFilled(false);
		btnWesternSpinachPizza.setBorderPainted(false);
		btnWesternSpinachPizza.setFocusPainted(false);
		
		btnWesternSpinachPizza.setIcon(new ImageIcon(".\\image\\루꼴라피자.png"));
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
				btnMintChocolatePizza.setIcon(new ImageIcon(".\\image\\민트초코피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMintChocolatePizza.setIcon(new ImageIcon(".\\image\\민초피자.png"));
			}
		});
		btnMintChocolatePizza.setContentAreaFilled(false);
		btnMintChocolatePizza.setBorderPainted(false);
		btnMintChocolatePizza.setFocusPainted(false);
		
		btnMintChocolatePizza.setIcon(new ImageIcon(".\\image\\민초피자.png"));
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
				btnBananaPizza.setIcon(new ImageIcon(".\\image\\바나나피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBananaPizza.setIcon(new ImageIcon(".\\image\\바나나피자.png"));
			}
		});
		btnBananaPizza.setIcon(new ImageIcon(".\\image\\바나나피자.png"));
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
				btnMalaFlavorPizza.setIcon(new ImageIcon(".\\image\\마라맛피자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMalaFlavorPizza.setIcon(new ImageIcon(".\\image\\마라맛피자.png"));
			}
		});
		btnMalaFlavorPizza.setIcon(new ImageIcon(".\\image\\마라맛피자.png"));
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
		
		lblOrderPizzaBackgroundImage.setIcon(new ImageIcon(".\\image\\피자배경.png"));
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
				btnDrinkFrogAde.setIcon(new ImageIcon(".\\image\\개구리에이드이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDrinkFrogAde.setIcon(new ImageIcon(".\\image\\개구리에이드.png"));
			}
		});
		btnDrinkFrogAde.setContentAreaFilled(false);
		btnDrinkFrogAde.setBorderPainted(false);
		btnDrinkFrogAde.setFocusPainted(false);
		btnDrinkFrogAde.setIcon(new ImageIcon(".\\image\\개구리에이드.png"));
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
				btnDrinkCoke.setIcon(new ImageIcon(".\\image\\콜라이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDrinkCoke.setIcon(new ImageIcon(".\\image\\콜라.png"));
			}
		});
		btnDrinkCoke.setContentAreaFilled(false);
		btnDrinkCoke.setBorderPainted(false);
		btnDrinkCoke.setFocusPainted(false);
		btnDrinkCoke.setIcon(new ImageIcon(".\\image\\콜라.png"));
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
				btnDrinkZeroCoke.setIcon(new ImageIcon(".\\image\\제로콜라이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDrinkZeroCoke.setIcon(new ImageIcon(".\\image\\제로콜라.png"));
			}
		});
		btnDrinkZeroCoke.setContentAreaFilled(false);
		btnDrinkZeroCoke.setBorderPainted(false);
		btnDrinkZeroCoke.setFocusPainted(false);
		btnDrinkZeroCoke.setIcon(new ImageIcon(".\\image\\제로콜라.png"));
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
				btnDrinkSprite.setIcon(new ImageIcon(".\\image\\스프라이트이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDrinkSprite.setIcon(new ImageIcon(".\\image\\스프라이트.png"));
			}
		});
		btnDrinkSprite.setIcon(new ImageIcon(".\\image\\스프라이트.png"));
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
		lblNewLabel_1.setIcon(new ImageIcon(".\\image\\피자배경.png"));
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
				btnSideSpaghettiFullOfPepperoni.setIcon(new ImageIcon(".\\image\\페퍼로니가득스파게티이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSideSpaghettiFullOfPepperoni.setIcon(new ImageIcon(".\\image\\페퍼로니가득스파게티.png"));
			}
		});
		btnSideSpaghettiFullOfPepperoni.setIcon(new ImageIcon(".\\image\\페퍼로니가득스파게티.png"));
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
				btnSidePastaFullOfBacon.setIcon(new ImageIcon(".\\image\\베이컨가득까르보나라이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSidePastaFullOfBacon.setIcon(new ImageIcon(".\\image\\베이컨가득까르보나라.png"));
			}
		});
		btnSidePastaFullOfBacon.setContentAreaFilled(false);
		btnSidePastaFullOfBacon.setBorderPainted(false);
		btnSidePastaFullOfBacon.setFocusPainted(false);
		btnSidePastaFullOfBacon.setIcon(new ImageIcon(".\\image\\베이컨가득까르보나라.png"));
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
				btnSideConsommeSeasonedPotatoes.setIcon(new ImageIcon(".\\image\\콘소메양념감자이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSideConsommeSeasonedPotatoes.setIcon(new ImageIcon(".\\image\\콘소메양념감자.png"));
			}
		});
		btnSideConsommeSeasonedPotatoes.setIcon(new ImageIcon(".\\image\\콘소메양념감자.png"));
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
				btnSideSweetRiceCheeseBalls.setIcon(new ImageIcon(".\\image\\찰지츠볼이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSideSweetRiceCheeseBalls.setIcon(new ImageIcon(".\\image\\찰치즈볼.png"));
			}
		});
		btnSideSweetRiceCheeseBalls.setIcon(new ImageIcon(".\\image\\찰치즈볼.png"));
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
				btnSideGreenSalad.setIcon(new ImageIcon(".\\image\\그린샐러드이름가격.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSideGreenSalad.setIcon(new ImageIcon(".\\image\\그린샐러드.png"));
			}
		});
		btnSideGreenSalad.setContentAreaFilled(false);
		btnSideGreenSalad.setBorderPainted(false);
		btnSideGreenSalad.setFocusPainted(false);
		btnSideGreenSalad.setIcon(new ImageIcon(".\\image\\그린샐러드.png"));
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
		lblNewLabel_2.setIcon(new ImageIcon(".\\image\\피자배경.png"));
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
		btnPaymentButton.setIcon(new ImageIcon("C:\\study\\workspace\\riri_project\\image\\개구리버튼.png"));
		//주문하기 버튼 클릭시 실행 되는 코드
		btnPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderingFrame.showOrderingFrame();
				
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
		lblPaymentAmount.setIcon(new ImageIcon("C:\\study\\workspace\\riri_project\\image\\결제금액.png"));
		lblPaymentAmount.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		lblPaymentAmount.setBounds(790, 657, 100, 30);
		panelOrderMenuBackground.add(lblPaymentAmount);
		
		panelShoppinBasket = new JPanel();
		panelShoppinBasket.setVisible(false);
		panelShoppinBasket.setLayout(null);
		panelShoppinBasket.setBounds(0, 0, 1258, 618);
		panelOrderMenuBackground.add(panelShoppinBasket);
		
		btnNewButton_6 = new JButton("개구리 주머니");
		btnNewButton_6.setBounds(0, 0, 95, 23);
		panelShoppinBasket.add(btnNewButton_6);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(".\\image\\피자메인판넬.png"));
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
		lblOrderTableBackgroundImage.setIcon(new ImageIcon(".\\image\\피자메인판넬.png"));
		lblOrderTableBackgroundImage.setBounds(0, 0, 1258, 865);
		panelOrderMenuBackground.add(lblOrderTableBackgroundImage);
		btnSideMenu.setBounds(509, 0, 255, 96);
		panelMainMenuBackground.add(btnSideMenu);
		
		//실행시 사용자가 컬럼이동 불가
		tableOrderSide.getTableHeader().setReorderingAllowed(false); 
		
		btnShoppinBasket = new JButton("개구리주머니");
		btnShoppinBasket.setContentAreaFilled(false);
		btnShoppinBasket.setBorderPainted(false);
		btnShoppinBasket.setFocusPainted(false);
		btnShoppinBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPizzaMenu.setVisible(false);
				panelDrinkMenu.setVisible(false);
				panelSideMenu.setVisible(false);
				panelShoppinBasket.setVisible(true);
			}
		});
		btnShoppinBasket.setBounds(762, 0, 255, 96);
		panelMainMenuBackground.add(btnShoppinBasket);
		
		btnPizzaMenu = new JButton("");
		btnPizzaMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPizzaMenu.setIcon(new ImageIcon(".\\image\\피자드래그.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPizzaMenu.setIcon(new ImageIcon(".\\image\\피자버튼.png"));
			}
		});
		btnPizzaMenu.setContentAreaFilled(false);
		btnPizzaMenu.setBorderPainted(false);
		btnPizzaMenu.setFocusPainted(false);
		btnPizzaMenu.setIcon(new ImageIcon(".\\image\\피자버튼.png"));
		
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
				btnDrinkMenu.setIcon(new ImageIcon(".\\image\\음료드래그.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDrinkMenu.setIcon(new ImageIcon(".\\image\\음료버튼.png"));
			}
		});
		btnDrinkMenu.setContentAreaFilled(false);
		btnDrinkMenu.setBorderPainted(false);
		btnDrinkMenu.setFocusPainted(false);
		btnDrinkMenu.setIcon(new ImageIcon(".\\image\\음료버튼.png"));
		
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
		lblNewLabel.setIcon(new ImageIcon(".\\image\\메뉴선택배경.png"));
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
				btnOrderMenuButton.setIcon(new ImageIcon(".\\image\\메뉴드래그.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOrderMenuButton.setIcon(new ImageIcon(".\\image\\메뉴보기버튼.png"));
			}
		});
		btnOrderMenuButton.setContentAreaFilled(false);
		btnOrderMenuButton.setBorderPainted(false);
		btnOrderMenuButton.setFocusPainted(false);
		btnOrderMenuButton.setIcon(new ImageIcon(".\\image\\메뉴보기버튼.png"));
		
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
		btnOrderMenuButton.setBounds(0, 97, 226, 96);
		panelSelectBtn.add(btnOrderMenuButton);
		
		btnOrderDetailsButton = new JButton("");
		btnOrderDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelOrderConfirmation.setVisible(true);
				lblOrderConfirmationB.setVisible(true);
				
				
				
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
				btnOrderDetailsButton.setIcon(new ImageIcon(".\\image\\주문내역드래그.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOrderDetailsButton.setIcon(new ImageIcon(".\\image\\주문내역버튼.png"));
			}
		});
		btnOrderDetailsButton.setContentAreaFilled(false);
		btnOrderDetailsButton.setBorderPainted(false);
		btnOrderDetailsButton.setFocusPainted(false);
		btnOrderDetailsButton.setIcon(new ImageIcon(".\\image\\주문내역버튼.png"));
		btnOrderDetailsButton.setBounds(0, 192, 226, 96);
		panelSelectBtn.add(btnOrderDetailsButton);
		
		btnMyProfileButton = new JButton("내정보");
		btnMyProfileButton.setBounds(47, 415, 97, 23);
		panelSelectBtn.add(btnMyProfileButton);
		
		btnFrogButton = new JButton("개구리");
		btnFrogButton.setBounds(47, 443, 97, 23);
		panelSelectBtn.add(btnFrogButton);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(".\\image\\로고메인.png"));
		lblNewLabel_4.setBounds(0, 0, 227, 94);
		panelSelectBtn.add(lblNewLabel_4);
		
		JLabel lblSideBackgroundImage = new JLabel("");
		lblSideBackgroundImage.setIcon(new ImageIcon(".\\image\\왼쪽판넬메뉴배경.png"));
		lblSideBackgroundImage.setBounds(0, 0, 230, 961);
		panelSelectBtn.add(lblSideBackgroundImage);
		
		//TODO
		panelMain = new JPanel();
		//panelMain = new ImagePanel();
		panelMain.setBounds(0, 0, 1244, 961);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		JLabel lblMainBackgroundImage = new JLabel("");
		lblMainBackgroundImage.setIcon(new ImageIcon(".\\image\\피자메인판넬.png"));
		lblMainBackgroundImage.setBounds(0, 0, 1244, 961);
		panelMain.add(lblMainBackgroundImage);
		
		//ImagePanel panelMain =new ImagePanel(new ImageIcon(".\\image\\피자메인판넬.png").getImage());
	
	}
	
	

	private List<OrderMenuAll> showSideNamePriceRead(String sideName) {
		this.cKSideName = sideName;
		List<OrderMenuAll> orderFrogSide = new ArrayList<>();
		orderFrogSide = orderMenuDao.ckFrogSideMenuRead(sideName);
		System.out.println(orderFrogSide);
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
	System.out.println(orderFrogPizza);
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
		System.out.println(orderFrogDrink);
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
}//클래스 끝