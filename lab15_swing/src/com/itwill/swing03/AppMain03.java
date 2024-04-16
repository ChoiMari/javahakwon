package com.itwill.swing03;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AppMain03 {

	private static final String[] IMAGES = {
			"images/image1.jpg",
			"images/image2.jpg",
			"images/image3.jpg",
			"images/image4.jpg",
			"images/image5.jpg"
	};
	private int curIndex; // 현재 화면에 보여지는 이미지 아이콘의 인덱스
	
	private JFrame frame;
	private JLabel lblImage;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblImageName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain03 window = new AppMain03();
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
	public AppMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//lblImage = new JLabel(new ImageIcon("images/image1.jpg"));
		lblImage = new JLabel(new ImageIcon(IMAGES[curIndex]));
		lblImage.setBounds(95, -13, 400, 400);
		frame.getContentPane().add(lblImage);
		
		btnPrev = new JButton("<");
		btnPrev.addActionListener(new ActionListener() {// 익명(내부) 클래스
			//오버라이드 -> 이전 버튼이 클릭 되었을 때 할일을 만들어 주면 됨.
			public void actionPerformed(ActionEvent e) {
				//이전 이미지 보여주기 : 5 -> 4 -> 3 -> 2 -> 1 -> 5
				//lblImage.setIcon(...); 레이블에 이미지 바꿔주는 메서드 ()안에만 잘 바꿔주면 된다고 함.
				showPrevImage(); //메서드 이용해서 실행.

			}
		});
		btnPrev.setFont(new Font("굴림", Font.BOLD, 50));
		btnPrev.setBounds(73, 452, 108, 71);
		frame.getContentPane().add(btnPrev);
		
		btnNext = new JButton(">");
		btnNext.addActionListener((e) -> showNextImage()); //람다 표현식으로 만듬
//		btnNext.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// 다음 이미지 보여주기 123451
//				//lblImage.setIcon(...); 레이블에 이미지 바꿔주는 메서드 ()안에만 잘 바꿔주면 된다고 함.
//				//람다 표현식
//				
//				
//			}
//		});
		btnNext.setFont(new Font("굴림", Font.BOLD, 50));
		btnNext.setBounds(390, 452, 108, 71);
		frame.getContentPane().add(btnNext);
		
		lblImageName = new JLabel(IMAGES[curIndex]);
		////- 버튼 클릭해서 이미지 넘길 때 마다 라벨이름도 변경하려고 생성함.
		
		lblImageName.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageName.setBounds(126, 371, 337, 71);
		frame.getContentPane().add(lblImageName);
	}

	private void showNextImage() {
		if(curIndex < IMAGES.length-1) {//현재 인덱스가 배열의 마지막 인덱스 보다 작으면(마지막 이미지가 아닌 경우)
			curIndex++; //인덱스 1증가
		} else {
			// 현재 인덱스가 배열의 마지막 인덱스이면(마지막 이미지인 경우)
			curIndex = 0; //인덱스를 0으로 바꿈. 그래서 1번 이미지 부터 다시 나오도록.
		}
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
		
		lblImageName.setText(IMAGES[curIndex]);
	}
	
	private void showPrevImage(){
		if(curIndex > 0) { //현재 이미지의 인덱스가 0보다 크면 실행
			curIndex --; //인덱스를 1 감소시킨다. //5번이면 4번으로 4번이면 3번으로.. 1씩 줄이기
		} else { //현재 인덱스 curIndex가 0이 되면 실행(첫번째 이미지인 경우)
			curIndex = IMAGES.length -1; //인덱스 curIndex의 값을 다시 배열의 마지막 인덱스로 바꿔줌. 여기서는 인덱스(curIndex)를 4로 바꿈
		}
		//JLable의 이미지 아이콘을 이전 이미지 아이콘으로 변경.
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
		
        // JLabel의 텍스트를 이미지 경로(이름)으로 변경
        lblImageName.setText(IMAGES[curIndex]);
	}

}
