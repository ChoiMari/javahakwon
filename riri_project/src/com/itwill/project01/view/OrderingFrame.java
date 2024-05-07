package com.itwill.project01.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class OrderingFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnShopEat;
	private JPanel panelPaymentBackground;
	private JButton btnPackaging;
	private JPanel panelEatinByChoice;

	/**
	 * Launch the application.
	 */
	public static void showOrderingFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderingFrame frame = new OrderingFrame();
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
	public OrderingFrame() {
		initialize();

	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("주문 하기");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelEatinByChoice = new JPanel();
		panelEatinByChoice.setBounds(0, 0, 434, 261);
		contentPane.add(panelEatinByChoice);
		panelEatinByChoice.setLayout(null);
		
		btnShopEat = new JButton("매장에서 먹고가기");
		btnShopEat.setBounds(12, 29, 200, 200);
		panelEatinByChoice.add(btnShopEat);
		
		btnPackaging = new JButton("포장하기");
		btnPackaging.setBounds(222, 29, 200, 200);
		panelEatinByChoice.add(btnPackaging);
		
		panelPaymentBackground = new JPanel();
		panelPaymentBackground.setBounds(0, 0, 434, 261);
		contentPane.add(panelPaymentBackground);
	}

}