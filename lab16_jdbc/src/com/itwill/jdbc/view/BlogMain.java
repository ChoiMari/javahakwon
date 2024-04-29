//package com.itwill.jdbc.view;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import java.awt.BorderLayout;
//import javax.swing.JComboBox;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//
package com.itwill.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;
import com.itwill.jdbc.view.BlogCreateFrame.CreateNotify;
import com.itwill.jdbc.view.BlogDetailsFrame.UpdateNotify;

import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogMain implements CreateNotify, UpdateNotify {
    
    private static final String[] SEARCH_TYPES  = { 
            "제목", "내용", "제목+내용", "작성자" 
    };
    private static final String[] COLUMN_NAMES = {
            "번호", "제목", "작성자", "수정시간"
    };

    private JFrame frame;
    private JPanel searchPanel;
    private JComboBox<String> comboBox;
    private JTextField textSearchKeyword;
    private JButton btnSearch;
    private JPanel buttonPanel;
    private JButton btnReadAll;
    private JButton btnCreate;
    private JButton btnDetails;
    private JButton btnDelete;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel tableModel;
    
    private BlogDao dao = BlogDao.getInstance();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogMain window = new BlogMain();
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
    public BlogMain() {
        initialize();
        initializeTable();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 640, 560);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("블로그 메인");
        
        searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
        
        comboBox = new JComboBox<>();
        final DefaultComboBoxModel<String> comboBoxModel = 
                new DefaultComboBoxModel<>(SEARCH_TYPES);
        comboBox.setModel(comboBoxModel);
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(comboBox);
        
        textSearchKeyword = new JTextField();
        textSearchKeyword.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(textSearchKeyword);
        textSearchKeyword.setColumns(10);
        
        btnSearch = new JButton("검색");
        btnSearch.addActionListener((e) -> search());
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 28));
        searchPanel.add(btnSearch);
        
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        btnReadAll = new JButton("목록보기");
        btnReadAll.addActionListener((e) -> initializeTable());
        btnReadAll.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnReadAll);
        
        btnCreate = new JButton("새 블로그");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 새 블로그 작성 창 띄우기
                BlogCreateFrame.showBlogCreateFrame(frame, BlogMain.this);
            }
        });
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCreate);
        
        btnDetails = new JButton("상세보기");
        btnDetails.addActionListener((e) -> showDetailsFrame());
        btnDetails.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnDetails);
        
        btnDelete = new JButton("삭제");
        btnDelete.addActionListener((e) -> deleteBlog());
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnDelete);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(tableModel);
        scrollPane.setViewportView(table);
    }
    
    private void showDetailsFrame() {
        int index = table.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
        if (index == -1) { // JTable에서 선택된 행이 없을 때
            JOptionPane.showMessageDialog(
                    frame, 
                    "상세보기할 행을 먼저 선택하세요.", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        Integer id = (Integer) tableModel.getValueAt(index, 0);
        
        BlogDetailsFrame.showBlogDetailsFrame(frame, id, BlogMain.this);
        
    }
    
    private void search() {
        int type = comboBox.getSelectedIndex(); // 콤보박스에서 선택된 아이템의 인덱스
        String keyword = textSearchKeyword.getText(); // 검색어
        if (keyword.equals("")) {
            JOptionPane.showMessageDialog(frame, 
                    "검색어를 입력하세요.", 
                    "경고", JOptionPane.WARNING_MESSAGE);
            textSearchKeyword.requestFocus();
            //-> 검색어 입력 JTextField에 포커스를 줌(커서 깜박깜박). 
            
            return;
        }
        
        // DAO 메서드를 호출해서 검색 결과를 가져옴.
        List<Blog> blogs = dao.search(type, keyword);
        resetTable(blogs); // 테이블 리셋.
    }

    private void initializeTable() {
        // DAO를 사용해서 DB 테이블에서 검색.
        List<Blog> blogs = dao.read();
        resetTable(blogs); // 테이블 리셋
    }
    
    private void resetTable(List<Blog> blogs) {
        // 검색한 내용을 JTable에 보여줌 - JTable의 테이블 모델을 재설정.
        tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 리셋.
        for (Blog b : blogs) {
            // DB 테이블에서 검색한 레코드를 JTable에서 사용할 행 데이터로 변환.
            Object[] row = {
                    b.getId(), b.getTitle(),
                    b.getWriter(), b.getModifiedTime(),
            };
            tableModel.addRow(row); // 테이블 모델에 행 데이터를 추가.
        }
        table.setModel(tableModel); // JTable의 모델을 다시 세팅.
    }
    
    private void deleteBlog() {
        int index = table.getSelectedRow(); // 테이블에서 선택된 행의 인덱스
        if (index == -1) { // JTable에서 선택된 행이 없을 때
            JOptionPane.showMessageDialog(
                    frame, 
                    "삭제할 행을 먼저 선택하세요.", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(
                frame, 
                "정말 삭제할까요?", 
                "삭제 확인", 
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // 선택된 행에서 블로그 번호(id)를 읽음.
            Integer id = (Integer) tableModel.getValueAt(index, 0);
            // DAO의 delete 메서드 호출.
            int result = dao.delete(id);
            if (result == 1) {
                initializeTable(); // 테이블을 새로고침.
                JOptionPane.showMessageDialog(frame, "삭제 성공!");
            } else {
                JOptionPane.showMessageDialog(frame, "삭제 실패!");
            }
        }
        
    }
    
    @Override
    public void notifyCreateSuccess() {
        // 테이블에 insert 성공했을 때 BlogCreateFrame이 호출하는 메서드.
        initializeTable();
        JOptionPane.showMessageDialog(frame, "새 블로그 등록 성공!");
    }

    @Override
    public void notifyUpdateSuccess() {
        // 테이블에 update 성공했을 때 BlogDetailsFrame이 호출하는 메서드.
        initializeTable();
        JOptionPane.showMessageDialog(frame, "블로그 업데이트 성공!");
    }
    
}

//import com.itwill.jdbc.controller.BlogDao;
//import com.itwill.jdbc.model.Blog;
//import com.itwill.jdbc.view.BlogCreateFrame.CreateNotify;
//
//import java.awt.Font;
//import java.util.List;
//
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JButton;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class BlogMain implements CreateNotify{
//	//상수 - 콤보박스에 들어갈 문자열 배열 -> private JComboBox<String> comboBox;안에 넣을 상수
//	private static final String[] SEARCH_TYPES = {"제목","내용","제목+내용","작성자"};
//	
//	//화면에 보여지는 J테이블에 들어갈 컬럼 이름
//	private static final String[] COLUMN_NAMES = {"번호","제목","작성자","수정시간"};
//	
//	private JFrame frame;
//	private JPanel searchPanel;
//	private JComboBox<String> comboBox;//private JComboBox comboBox;
//	private JTextField textSearchKeyword;
//	private JPanel buttonPanel;
//	private JButton btnSearch;
//	private JButton btnReadAll;
//	private JButton btnDelete;
//	private JButton btnDetails;
//	private JButton btnCreate;
//	private JTable table;
//	private JScrollPane scrollPane;
//	
//	private DefaultTableModel tableModel;
//	
//	private BlogDao dao = BlogDao.getInstance(); //->메서드 호출 가능
//	
//	
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BlogMain window = new BlogMain();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public BlogMain() {
//		initialize();
//		initializeTable();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 455, 508);//J프레임 좌표,크기
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("블로그 메인"); //-> 창 타이틀 문구
//		
//		searchPanel = new JPanel();
//		frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
//		
//		comboBox = new JComboBox<>(); //수정 전 comboBox = new JComboBox();
//		
//		//콤보박스 세팅 
//		final DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>(SEARCH_TYPES);
//		comboBox.setModel(comboBoxModel);
//		
//		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//		searchPanel.add(comboBox);
//		
//		textSearchKeyword = new JTextField();
//		textSearchKeyword.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
//		searchPanel.add(textSearchKeyword);
//		textSearchKeyword.setColumns(10);
//		
//		//검색단추 클릭시 실행
//		btnSearch = new JButton("검색");
//		btnSearch.addActionListener((e)->search());
//		
//		
//		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
//		searchPanel.add(btnSearch);
//		
//		buttonPanel = new JPanel();
//		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
//		
//		btnReadAll = new JButton("목록보기");
//		btnReadAll.addActionListener((e)->initializeTable());
//		
//		btnReadAll.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//		buttonPanel.add(btnReadAll);
//		
//		btnCreate = new JButton("새 블로그");
//		btnCreate.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// : 새 블로그 작성 창 띄우기
//				BlogCreateFrame.showBlogCreateFrame(frame, BlogMain.this); //BlogMain.this 는 CreateNotify타입
//				//BlogMain implements CreateNotify하고 있음.
//				
//			}
//		});
//		btnCreate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//		buttonPanel.add(btnCreate);
//		
//		btnDetails = new JButton("상세보기");
//		//상세보기 버튼 클릭시 실행.
//		btnDetails.addActionListener((e)->showDetailsFrame());
//		
//		btnDetails.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//		buttonPanel.add(btnDetails);
//		
//		//삭제 클릭시 실행 
//		btnDelete = new JButton("삭제");
//		btnDelete.addActionListener((e) -> deleteBlog());
//		
//		btnDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//		buttonPanel.add(btnDelete);
//		
//		scrollPane = new JScrollPane();
//		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
//		
//		table = new JTable();
//		
//		//테이블에 컬럼 추가 - 위에 필드 선언함. private DefaultTableModel tableModel;
//		tableModel = new DefaultTableModel(null,COLUMN_NAMES);
//		table.setModel(tableModel);
//		
//		scrollPane.setViewportView(table);
//	}
//	
//	private void showDetailsFrame(){
//		//TODO
//	}
//	
//	
//	private void search() {
//		int type = comboBox.getSelectedIndex();//콤보박스에서 선택된 아이템의 인덱스
//		String keyword = textSearchKeyword.getText();//검색어
//		if(keyword.equals("")) {
//			JOptionPane.showMessageDialog(frame,
//					"검색어를 입력하세요.",
//					"경고",
//					JOptionPane.WARNING_MESSAGE);
//			
//			textSearchKeyword.requestFocus();
//			//->검색어 입력 JTextField에 포커스를 줌(커서 깜박깜박).
//			
//			return;
//		}
//		//DAO 메서드를 호출해서 검색 결과를 가져옴
//		List<Blog> blogs = dao.search(type, keyword);
//		resetTable(blogs); //테이블 리셋.
//	}
//	
//	
//	
//	private void initializeTable() {
//		//DAO를 사용해서 DB 테이블에서 검색.
//		List<Blog> blogs = dao.read();
//		
//		//테이블 리셋  
//		resetTable(blogs);
//		
////		//검색한 내용을 JTable에 보여줌 -> JTable의 테이블 모델을 재설정.
////		tableModel = new DefaultTableModel(null, COLUMN_NAMES);//테이블 모델 리셋 - 데이터를 지움
////		for(Blog b : blogs) { 
////			//DB 테이블에서 검색한 레코드를 JTable에서 사용할 행 데이터로 변환
////			Object[] row = {
////					b.getId(),
////					b.getTitle(),
////					b.getWriter(),
////					b.getModifiedTime()
////					
////			};
////			tableModel.addRow(row); // 테이블 모델에 행 데이터를 추가
////		}
////		table.setModel(tableModel);//JTable의 모델을 다시 세팅.
//	}
//	
//	private void resetTable(List<Blog> blogs) { 
//		//검색한 내용을 JTable에 보여줌 -> JTable의 테이블 모델을 재설정.
//		tableModel = new DefaultTableModel(null, COLUMN_NAMES);// 테이블 모델 리셋 - 데이터를 지움
//		for (Blog b : blogs) {
//			// DB 테이블에서 검색한 레코드를 JTable에서 사용할 행 데이터로 변환
//			Object[] row = { b.getId(), b.getTitle(), b.getWriter(), b.getModifiedTime()
//
//			};
//			tableModel.addRow(row); // 테이블 모델에 행 데이터를 추가
//		}
//		table.setModel(tableModel);//JTable의 모델을 다시 세팅.
//	}
//
//	private void deleteBlog() {
//		int index = table.getSelectedRow();//테이블에서 선택된 행의 인덱스 
//		if(index == -1) {//JTable에서 선택된 행이 없을 때
//			JOptionPane.showMessageDialog(
//					frame,//어떤 창에서 메세지 창 뜰 건지 설정
//					"삭제할 행을 먼저 선택하세요",//메세지 문구
//					"경고",//메세지창 타이틀
//					JOptionPane.WARNING_MESSAGE);
//			return;//->더이상 코드 진행 되지 않도록 해당 메서드 종료시킴.
//			
//		}
//		int confirm = JOptionPane.showConfirmDialog(
//				frame,
//				"정말 삭제 할까요?",
//				"삭제 확인",
//				JOptionPane.YES_NO_OPTION //버튼 개수
//				);
//		if(confirm == JOptionPane.YES_OPTION) {//옵션이 yes와 같을 때. 메세지 창에서 yes를 눌렀을 때와 값이 같으면 실행
//			//***선택된 행에서 블로그 번호(id)를 읽음.
//			Integer id = (Integer) tableModel.getValueAt(index, 0); 
//			//id -> 데이터베이스의 중복값이 안들어가는 고유키(프라이머리 키 컬럼으로)로 삭제
//			// getValueAt(index, 0); 오브젝트로 리턴해줌. 
//			// 테이블 모델에서 value를 찾겠다. 첫번째 아규먼트가 행, 두번째 아규먼트가 컬럼
//			// 우리가 읽어야 될 값. 행 인덱스의 컬럼은 0번에 컬럼에 있는 값을 읽어야... 그래야 그 값이 id가 됨
//			// 오브젝트 객체 int로는 못바꿔서 Integer로 바꿈.
//			// Object javax.swing.table.DefaultTableModel.getValueAt(int row, int column)
//			
//			//DAO의 delete 메서드 호출.
//			int result = dao.delete(id);
//			if(result == 1) {
//				initializeTable();//테이블을 새로 고침.//->이게 있어야 삭제시 바로 변경된게 프레임에 보임.
//				JOptionPane.showMessageDialog(frame, "삭제 성공!");
//			} else {
//				JOptionPane.showMessageDialog(frame, "삭제 실패");
//				
//			}
//		}
//	}
//	
//	@Override
//	public void notifyCreateSuccess() {
//		//BlogCreateFrame에서 테이블에 insert문장 성공했을 때 BlogCreateFrame이 호출하는 메서드
//		initializeTable();
//		JOptionPane.showMessageDialog(frame, "새 블로그 등록 성공");
//		
//	}
//
//}
