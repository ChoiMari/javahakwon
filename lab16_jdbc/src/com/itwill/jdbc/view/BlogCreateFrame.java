package com.itwill.jdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogCreateFrame extends JFrame {

	public interface CreateNotify {
		void notifyCreateSuccess();
	}
	
	private static final long serialVersionUID = 1L;
	
	private BlogDao dao = BlogDao.getInstance();
	private CreateNotify app;
	
	private JPanel contentPane;
	
	private Component parent;
	private JLabel lblTitle;
	private JTextField textTitle;
	private JLabel lblContent;
	private JScrollPane scrollPane;
	private JTextArea textContent;
	private JTextField textWriter;
	private JLabel lbWriter;
	private JButton btnSave;
	private JButton btnCancle;

	/**
	 * Launch the application.
	 */
	public static void showBlogCreateFrame(Component parent, CreateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogCreateFrame frame = new BlogCreateFrame(parent, app);
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
	private BlogCreateFrame(Component parent, CreateNotify app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}
	public void initialize() {
		setTitle("새 블로그 작성");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x =0;
		int y =0;
		if(parent != null) {
			x=parent.getX(); //부모 컴포넌트의 x좌표
			y=parent.getY(); //부모 컴포넌트의 y좌표
		}
		setBounds(x, y, 345, 530);
		if(parent ==null) {
			setLocationRelativeTo(null);//화면 가운데 JFrame을 띄움.
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("제목");
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 20));
		lblTitle.setBounds(12, 10, 249, 35);
		contentPane.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("굴림", Font.PLAIN, 20));
		textTitle.setBounds(12, 51, 305, 47);
		contentPane.add(textTitle);
		textTitle.setColumns(10);
		
		lblContent = new JLabel("내용");
		lblContent.setFont(new Font("굴림", Font.PLAIN, 20));
		lblContent.setBounds(12, 108, 249, 35);
		contentPane.add(lblContent);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 149, 305, 186);
		contentPane.add(scrollPane);
		
		textContent = new JTextArea();
		scrollPane.setViewportView(textContent);
		
		textWriter = new JTextField();
		textWriter.setFont(new Font("굴림", Font.PLAIN, 20));
		textWriter.setColumns(10);
		textWriter.setBounds(12, 385, 305, 47);
		contentPane.add(textWriter);
		
		lbWriter = new JLabel("작성자");
		lbWriter.setFont(new Font("굴림", Font.PLAIN, 20));
		lbWriter.setBounds(12, 344, 249, 35);
		contentPane.add(lbWriter);
		
		btnSave = new JButton("작성 완료");
		btnSave.addActionListener((e)->createNewBlog());
		btnSave.setFont(new Font("굴림", Font.PLAIN, 15));
		btnSave.setBounds(12, 442, 126, 39);
		contentPane.add(btnSave);
		
		btnCancle = new JButton("취소");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnCancle.setFont(new Font("굴림", Font.PLAIN, 15));
		btnCancle.setBounds(191, 442, 126, 39);
		contentPane.add(btnCancle);
	}
	
	private void createNewBlog() {
		//제목, 내용, 작성자에 입력된 내용을 Blog 객체로 만들어서
		//DAO 메서드를 사용해서 DB 테이블에 insert.
		String title = textTitle.getText();
		String content = textContent.getText();
		String writer = textWriter.getText();
		if(title.equals("")|| content.equals("")|| writer.equals("")) { //빈 문자열 일 경우
			JOptionPane.showMessageDialog(
					BlogCreateFrame.this, //이 창을 기준으로 메세지 창이 뜸 
					"제목, 내용, 작성자는 반드시 입력해야 합니다.",
					"경고",
					JOptionPane.WARNING_MESSAGE);
			return; //->메서드 종료.
		}
		Blog blog = new Blog(0, title, content, writer, null, null);
		//아이디 자동증가여서 기본값 0으로 줌.
		
		int result = dao.create(blog);//dao가 실제로 DB에 입력.
		if(result == 1) {
			// BlogMain 프레임에게 테이블 삽입 성공을 알려줌
			app.notifyCreateSuccess();
			//JOptionPane.showMessageDialog(BlogCreateFrame.this, result + "개 행 삽입.");
			dispose();//현재 창 닫기
		} else {
			JOptionPane.showMessageDialog(BlogCreateFrame.this, "INSERT 실패");
		}

	}
	
	
}
