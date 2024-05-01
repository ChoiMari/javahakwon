package com.itwill.project01.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class FrogPizzaFrame {

	//private static final String[] COLUMN_NAMES = {"피자","장df"}
	
	private JFrame frame;
	private JButton btnPrFrogPizza;
	private JButton btnBulgogiPizza;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JButton btnNewButton_11;
	private JButton btnNewButton_12;
	private JButton btnNewButton_18;
	private JButton btnNewButton_18_1;
	private JPanel panelDrinkMenu;
	private JButton btnNewButton_13;
	private JButton btnNewButton_14;
	private JButton btnNewButton_15;
	private JButton btnNewButton_16;
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
	private JTable table;
	private JTextField textTotalsum;

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
	public FrogPizzaFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);//화면크기조절 못하게 설정
		frame.setBounds(100, 100, 1500, 1000);
		frame.setTitle("개굴 개굴");//창 타이틀
		frame.setLocationRelativeTo(null);//화면 중앙에 뜨게 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelMainMenuBackground = new JPanel();
		panelMainMenuBackground.setBounds(226, 0, 1258, 961);
		frame.getContentPane().add(panelMainMenuBackground);
		panelMainMenuBackground.setLayout(null);
		
		btnSideMenu = new JButton("사이드");
		btnSideMenu.setBounds(296, 0, 97, 23);
		panelMainMenuBackground.add(btnSideMenu);
		
		btnShoppinBasket = new JButton("개구리주머니");
		btnShoppinBasket.setBounds(430, 0, 132, 23);
		panelMainMenuBackground.add(btnShoppinBasket);
		
		btnPizzaMenu = new JButton("피자");
		btnPizzaMenu.setBounds(0, 0, 97, 23);
		panelMainMenuBackground.add(btnPizzaMenu);
		
		btnDrinkMenu = new JButton("음료");
		btnDrinkMenu.setBounds(134, 0, 97, 23);
		panelMainMenuBackground.add(btnDrinkMenu);
		
		panelOrderMenuBackground = new JPanel();
		panelOrderMenuBackground.setBounds(0, 96, 1258, 865);
		panelMainMenuBackground.add(panelOrderMenuBackground);
		panelOrderMenuBackground.setLayout(null);
		
		panelPizzaMenu = new JPanel();
		panelPizzaMenu.setBounds(0, 0, 1258, 618);
		panelOrderMenuBackground.add(panelPizzaMenu);
		panelPizzaMenu.setLayout(null);
		
		btnPrFrogPizza = new JButton("프리미엄 개구리피자");
		btnPrFrogPizza.setBounds(0, 0, 200, 200);
		panelPizzaMenu.add(btnPrFrogPizza);
		
		btnBulgogiPizza = new JButton("불고기피자");
		btnBulgogiPizza.setBounds(201, 0, 200, 200);
		panelPizzaMenu.add(btnBulgogiPizza);
		
		btnNewButton = new JButton("버섯 피자");
		btnNewButton.setBounds(0, 201, 200, 200);
		panelPizzaMenu.add(btnNewButton);
		
		btnNewButton_1 = new JButton("토마토피자");
		btnNewButton_1.setBounds(201, 201, 200, 200);
		panelPizzaMenu.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("윤정 추천 슈림프피자");
		btnNewButton_2.setBounds(402, 0, 200, 200);
		panelPizzaMenu.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("페퍼로니피자");
		btnNewButton_3.setBounds(402, 201, 200, 200);
		panelPizzaMenu.add(btnNewButton_3);
		
		btnNewButton_8 = new JButton("포테이토 피자");
		btnNewButton_8.setBounds(603, 0, 200, 200);
		panelPizzaMenu.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("치즈피자");
		btnNewButton_9.setBounds(603, 201, 200, 200);
		panelPizzaMenu.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("야채피자");
		btnNewButton_10.setBounds(804, 201, 200, 200);
		panelPizzaMenu.add(btnNewButton_10);
		
		btnNewButton_11 = new JButton("고구마피자");
		btnNewButton_11.setBounds(804, 0, 200, 200);
		panelPizzaMenu.add(btnNewButton_11);
		
		btnNewButton_12 = new JButton("파인애플 피자");
		btnNewButton_12.setBounds(0, 402, 200, 200);
		panelPizzaMenu.add(btnNewButton_12);
		
		btnNewButton_18 = new JButton("루꼴라 피자");
		btnNewButton_18.setBounds(201, 402, 200, 200);
		panelPizzaMenu.add(btnNewButton_18);
		
		btnNewButton_18_1 = new JButton("민초 피자");
		btnNewButton_18_1.setBounds(402, 402, 200, 200);
		panelPizzaMenu.add(btnNewButton_18_1);
		
		panelDrinkMenu = new JPanel();
		panelDrinkMenu.setBounds(0, 0, 1258, 618);
		panelOrderMenuBackground.add(panelDrinkMenu);
		panelDrinkMenu.setLayout(null);
		
		btnNewButton_13 = new JButton("New button");
		btnNewButton_13.setBounds(24, 10, 97, 23);
		panelDrinkMenu.add(btnNewButton_13);
		
		btnNewButton_14 = new JButton("New button");
		btnNewButton_14.setBounds(0, 0, 97, 23);
		panelDrinkMenu.add(btnNewButton_14);
		
		btnNewButton_16 = new JButton("New button");
		btnNewButton_16.setBounds(0, 0, 97, 23);
		panelDrinkMenu.add(btnNewButton_16);
		
		btnNewButton_15 = new JButton("New button");
		btnNewButton_15.setBounds(0, 0, 97, 23);
		panelDrinkMenu.add(btnNewButton_15);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 619, 739, 246);
		panelOrderMenuBackground.add(scrollPane);
		
		table = new JTable();
		
		//TODO

		scrollPane.setViewportView(table);
		
		JButton btnPaymentButton = new JButton("주문 하기");
		//주문하기 버튼 클릭시 실행 되는 코드
		btnPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderingFrame.showOrderingFrame();
				
			}
		});
		btnPaymentButton.setBounds(1102, 814, 97, 23);
		panelOrderMenuBackground.add(btnPaymentButton);
		
		textTotalsum = new JTextField();
		textTotalsum.setBounds(868, 734, 305, 46);
		panelOrderMenuBackground.add(textTotalsum);
		textTotalsum.setColumns(10);
		
		JLabel lblPaymentAmount = new JLabel("결제 금액");
		lblPaymentAmount.setBounds(774, 749, 57, 15);
		panelOrderMenuBackground.add(lblPaymentAmount);
		
		panelSelectBtn = new JPanel();
		panelSelectBtn.setBounds(0, 0, 230, 961);
		frame.getContentPane().add(panelSelectBtn);
		panelSelectBtn.setLayout(null);
		
		btnOrderMenuButton = new JButton("메뉴보기");
		btnOrderMenuButton.setBounds(15, 5, 97, 23);
		panelSelectBtn.add(btnOrderMenuButton);
		
		btnOrderDetailsButton = new JButton("주문내역");
		btnOrderDetailsButton.setBounds(15, 38, 97, 23);
		panelSelectBtn.add(btnOrderDetailsButton);
		
		btnMyProfileButton = new JButton("내정보");
		btnMyProfileButton.setBounds(15, 71, 97, 23);
		panelSelectBtn.add(btnMyProfileButton);
		
		btnFrogButton = new JButton("개구리");
		btnFrogButton.setBounds(15, 99, 97, 23);
		panelSelectBtn.add(btnFrogButton);
		
		panelMain = new JPanel();
		panelMain.setBounds(0, 0, 1484, 961);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
	}
}
