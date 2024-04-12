package com.itwill.inner03;

public class Button {
    // public static 내부 인터페이스 -> static은 생략 가능.
    public interface OnClickListener {
        void onClick(); // public abstract 메서드
    }
    
    // field
    private String btnName;
    private OnClickListener listener;
    
    // constructor
    public Button(String btnName) {
        this.btnName = btnName;
    }
    
    // setter
    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }
    
    // method
    public void click() {
        System.out.print(btnName + " 버튼: ");
        listener.onClick(); //listene가 가지고 있는 onClick();클릭했을 때 메서드 호출
    }

}

//package com.itwill.inner03;
//
//public class Button {
//pr
//	//public static 내부 인터페이스 -> static 생략 가능(안써도 static으로 선언되어있음)
//	public interface OnclickListemer {
//		void onClick();//public abstract 메서드
//		
//		//필드
//		private String btnName;
//		private OnclickListemer listerner;
//		
//		//생성자
//		public Button(String bString);
//		
//		// setter
//		
//		//메서드
//		public void clikic() {
//			System.out.print();
//		}
//		
//		
//	}
//}
