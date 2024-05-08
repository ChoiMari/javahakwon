package com.itwill.project01.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.project01.model.Membership;

import oracle.jdbc.OracleDriver;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class OrderingFrame extends JFrame {
	
	
    //-----> singleton
    private static OrderingFrame instance = null;
    
    private OrderingFrame() {
        try {
            // Oracle 드라이버(라이브러리)를 등록.
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static OrderingFrame getInstance() {
        if (instance == null) {
            instance = new OrderingFrame();
        }
        
        return instance;
    }
    //<----- singleton
	
	

//	//싱글턴 객체호출함.
//	private FrogPizzaFrame frogPizzaFrame = FrogPizzaFrame.getInstance();
	private static FrogPizzaFrame frogPizzaFrame;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnShopEat;
	private JPanel panelPaymentBackground;
	private JButton btnPackaging;
	private JPanel panelEatinByChoice;

	//아규먼트로 받은값 저장 필드
	//private Membership loginMembership;
	
	
	//아규먼트로 로그인 값 받아와야함
	private String loginId;
	/**
	 * Launch the application.
	 */
	public static void showOrderingFrame(FrogPizzaFrame frogPizzaFrame, String loginId) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderingFrame frame = new OrderingFrame(frogPizzaFrame, loginId);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the frame.
	 */
	public OrderingFrame(FrogPizzaFrame frogPizzaFrame,String loginId) {
		
		this.frogPizzaFrame = frogPizzaFrame;
		this.loginId = loginId;
		initialize();
		

	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("주문 하기");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		//창 아이콘
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage(".\\image\\아이콘.png");
		setIconImage(img);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelEatinByChoice = new JPanel();
		panelEatinByChoice.setBounds(0, 0, 434, 261);
		contentPane.add(panelEatinByChoice);
		panelEatinByChoice.setLayout(null);
		
		btnShopEat = new JButton("매장에서 먹고가기");
		btnShopEat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "주문이 완료 되었습니다.","주문확인",JOptionPane.PLAIN_MESSAGE);
				//TODO 테이블에 있는 주문내역 저장하기. - 
				frogPizzaFrame.loginInsertRestaurantEat();
				//테이블에 검색해서 보여줌
				frogPizzaFrame.showOrderHistory(loginId);
				
				checkOrder();

				//TODO 테이블 리셋
				setVisible(false);
				
				
			}
		});
		btnShopEat.setBounds(12, 29, 200, 200);
		panelEatinByChoice.add(btnShopEat);
		
		btnPackaging = new JButton("포장하기");
		btnPackaging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,"주문이 완료 되었습니다.","주문확인",JOptionPane.PLAIN_MESSAGE);
				//TODO 테이블에 있는 주문내역 저장하기. - 
//				frogPizzaFrame.loginInsertPackaging();
//				//테이블에 검색해서 보여줌.
//				frogPizzaFrame.showOrderHistory2(loginId);
				frogPizzaFrame.loginInsertRestaurantEat();
				//테이블에 검색해서 보여줌
				frogPizzaFrame.showOrderHistory(loginId);
				
				checkOrder();
				//테이블 리셋
				setVisible(false);
			}
		});
		btnPackaging.setBounds(222, 29, 200, 200);
		panelEatinByChoice.add(btnPackaging);
		
		panelPaymentBackground = new JPanel();
		panelPaymentBackground.setBounds(0, 0, 434, 261);
		contentPane.add(panelPaymentBackground);
	}
	
	
	public int checkOrder() {
		frogPizzaFrame.delete();
		return 1;
	}

}