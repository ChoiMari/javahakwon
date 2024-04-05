package com.itwill.view;

import java.util.Scanner;

import com.itwill.controller.MemberDao;
import com.itwill.controller.MemberDaoImpl;
import com.itwill.model.Member;

// MVC 아키텍쳐에서 뷰(UI: User Interface) 역할을 담당하는 클래스.
public class MemberMain {
    
    private final Scanner scanner = new Scanner(System.in);
    private MemberDao dao = MemberDaoImpl.getInstance(); // 컨트롤러(controller)
    //인터페이스는 객체생성 불가. 그런데 변수는 인터페이스 타입으로 함.(객체 생성은 구현하는 implements 하는 클래스가)
    //그래서 dao. 하면 인터페이스에 정의가 되어져 있는 상수나 메서드들이 보임.
    // 이 클래스가 가지고 있는 메서드들을 사용할 준비를 하는 거라고 함.(메모리에 객체가 생성이 되어있어야 쓸 수 있으니까)
    // 일부러 밑에 설명해주려고 이렇게 인터페이스 타입으로 dao를 선언 했다고 함.
    
    
    public static void main(String[] args) {
        System.out.println("*** 회원 관리 프로그램 ***");
        
        // MemberMain 타입 객체의 인스턴스 멤버(필드, 메서드)를 사용하기 위해서.
        MemberMain app = new MemberMain();
        
        boolean run = true; // 프로그램을 종료할 때 false로 변경.
        while (run) {
            int menu = app.selectMainMenu();
            switch (menu) { //menu 사용자가 콘솔에 입력한 값
            case 0:
                run = false;
                break;
            case 1:
                app.saveNewMember(); 
                break;
            case 2:
                app.readAllMembers();
                break;
            case 3:
                app.readMemberByIndex();
                break;
            case 4:
                app.updateMember();
                break;
            default:
                System.out.println("0~4 범위의 정수로 입력하세요...");
            }
        }
        
        System.out.println(">>> 프로그램 종료 >>>");
    }
    
    private void updateMember() {
        System.out.println("\n--- 회원 정보 업데이트 ---");
        
        System.out.print("업데이트할 인덱스>> ");
//        MemberDaoImpl daoImpl = (MemberDaoImpl) dao;
//        daoImpl. ->이렇게 하면 안보이던 메서드들이 보임
//        daoImpl.isValidIndex(index);
        
        int index = Integer.parseInt(scanner.nextLine());
        
        //if(index >=0 && index < (MemberDaoImpl)dao).getCount()){} 이렇게 해도 된다고 함.
        
        if (!((MemberDaoImpl) dao).isValidIndex(index)) { //dao를 MemberDaoImpl로 변환해서
        	// ! not 유효하지 않는 것(회원정보가 없는것) // 굳이 이렇게 검사한 이유 : casting 설명하기 위해서
        	// 밑에처럼 if문 member null체크로도 가능(이게 더 간단함) - 설명하기 위해서 어려운 방법 사용한 것
            System.out.println("업데이트할 회원 정보가 없습니다.");
            return;
        } 
        
        
        Member member = dao.read(index);
        // 여기에서 if문
        //if(member == null){
        //return;
        //} else{밑의 코드 실행되게.. 이렇게 해도 된다고 함. 
        System.out.println("수정 전: " + member);
        
        System.out.print("새 비밀번호>> ");
        String password = scanner.nextLine();
        
        // View에서 Controller의 기능을 사용해서 비밀번호를 업데이트
        int result = dao.update(index, password);
        if (result == 1) {
            System.out.println("비밀번호 업데이트 성공");
        } else {
            System.out.println("비밀번호 업데이트 실패");
        }
        
    }

    private void readMemberByIndex() {
        System.out.println("\n--- 인덱스 검색 ---");
        
        System.out.print("검색할 인덱스 입력>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        // View에서 Controller의 기능을 사용해서 해당 인덱스의 회원 정보를 가져옴.
        Member member = dao.read(index);
        if (member != null) {
            System.out.println(member);
        } else {
            System.out.println("해당 인덱스에는 회원 정보 없습니다.");
        }
    }

    private void readAllMembers() { //case 2번시 실행되는 코드.
        System.out.println("\n--- 회원 목록 ---");
        Member[] members = dao.read(); // dao에서 read();를 호출 하겠다.
        // View에서 Controller 기능을 사용, 출력할 데이터를 가져옴.
        int index = 0;//-> 인덱스도 같이 출력되게 하고 싶어서 인덱스 선언 & 0으로 초기화 하고 출력함.
        for (Member m : members) { // 반복문 안에서 null 체크 해도 되긴 하다고 함. 선생님은 read()안에서 체크.
            System.out.println("[" + index + "] " + m); 
            index++;
        }
    }

    private void saveNewMember() {
        System.out.println("\n----- 새 회원 정보 저장 ----");
        
        MemberDaoImpl daoImpl = (MemberDaoImpl) dao;
        // dao는 인터페이스 타입으로 선언해서 안 보이는 메서드가 있음... dao.해보면 쓸 수 있는거 보이는데..
        // 그래서 dao를 MemberDaoImpl타입으로 강제변환(casting)해서 daoImpl에 저장
        // 하이브리드 자동차인데 자동차 타입으로 강제변환하면 자동차에 있는 것 밖에는 안보임.
        // 그래서 캐스팅을 하고 나면 안보이던 메서드가 이제 보임.
        // 생성된 객체는 하나인데 같은 주소값을 보고 있는 것.
        // 상위 타입에 선언된걸 다시 하위타입으로 캐스팅하면 쓰고자 하는 게 보임.
        
        if (daoImpl.isMemoryFull()) { 
        	//isMemoryFull()메서드 호출. : 현재 저장된 count의 개수와 MAX_LENGTH가 같으면(배열의 최대길이) 실행
        	// 실행 안되면 배열에 저장된 회원정보가 가득차지 않았다는 의미.
            System.out.println("회원 정보를 저장할 메모리가 부족합니다.");
            return; 
        } //-> 배열이 가득 찼을 때 
        
        System.out.print("아이디 입력>> ");
        String id = scanner.nextLine();
        
        System.out.print("비밀번호 입력>> ");
        String password = scanner.nextLine();
        
        Member member = new Member(id, password);
        
        int result = dao.create(member); // View 객체에서 Controller 객체의 기능을 사용.
        if (result == 1) {
            System.out.println("회원 정보 저장 성공");
        } else {
            System.out.println("회원 정보 저장 실패");
        }
    }

    private int selectMainMenu() {
        System.out.println("\n---------------------------------------------");
        System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
        System.out.println("---------------------------------------------");
        System.out.print("선택> ");
        
        int menu = Integer.parseInt(scanner.nextLine());
        
        return menu;
    }

}




//package com.itwill.view;
//
//import java.util.Scanner;
//
//import com.itwill.controller.MemberDao;
//import com.itwill.controller.MemberDaoImpl;
//import com.itwill.model.Member; //다른 패키지에 있는 클래스여서 import문장 필요
//
////MVC 아키텍쳐에서 뷰(UI : User Interface) 역할을 담당하는 클래스. - 입출력 담당
//public class MemberMain {
//	
//	private final Scanner scanner = new Scanner(System.in); // final 재할당 불가능.
//	private MemberDao dao = MemberDaoImpl.getInstance(); //dao가 컨트롤러
//	
//	// private MemberDaoImpl dao = MemberDaoImpl.getInstance(); 
//	// static 메서드 호출.(이미 메모리에 만들어져 있어서 객체생성new필요 없음)
//	
//	public static void main(String[] args) {
//		
////		Member m = new Member("admin","1234");
////		System.out.println(m);//println은 toString()을 이용해서 화면에 문자열을 출력한다.
//		System.out.println("*** 회원 관리 프로그램 ***");
//		
//		//MemberMain이 가지고 있는(멤버 타입 객체의 인스턴스 멤버(필드,메서드)를 사용하기 위해서
//		////MemberMain객체가 생성되어 있어야 불러다 쓸 수 있어서. 
//		MemberMain app = new MemberMain();
//		
//		boolean run = true; //프로그램을 종료할 때 false로 변경하기 위한 변수.
//		while(run) {
//			int menu = app.selectMainmenu();
//			switch(menu) {
//			case 0 :
//				run = false;
//				break;
//			case 1 :
//				app.saveNewMember();
//				break;
//			case 2 :
//				app.readAllMembers();
//				break;
//			case 3 :
//				app.readMemberByIndex();
//				break;
//			case 4 :
//				app.updateMember();
//				break;
//			default :
//					System.out.println("0~4 범위의 정수로 입력하세요...");
//			}
//		}
//		
//		System.out.println(">>> 프로그램 종료 >>>");
//	}// main() 끝
//
//	
//	private void updateMember() {
//		System.out.println("\n--- 회원 정보 업데이트 ---");
//		
//		System.out.println("업데이트할 인덱스>> ");
//		int index = Integer.parseInt(scanner.nextLine());
//		
//		Member member = dao.read(index);
//		
//		if(member == null) {
//			System.out.println("업데이트 할 연락처가 없습니다.");
//		} else {
//		System.out.println("수정 전: " + member);
//		
//		System.out.print("새 비밀번호>> ");
//		String password = scanner.nextLine();
//		
//		//view에서 controller의 기능을 사용해서 비밀번호를 업데이트
//		int result = dao.update(index, password);
//		if(result == 1) {
//			System.out.println("비밀번호 업데이트 성공\n");
//			System.out.println("수정 후: " + member);
//		} else {
//			System.out.println("비밀번호 업데이트 실패");
//		}
//		
//	}
//
//	}
//	private void readMemberByIndex() {
//		System.out.println("\n--- 인덱스 검색 ---");
//		
//		System.out.print("검색할 인덱스 입력>> ");
//		int index = Integer.parseInt(scanner.nextLine());
//		
//		// View에서 controller의 기능을 사용해서 해당 인덱스의 회원 정보를 가져옴.
//		Member member = dao.read(index);
//		if(member != null) {
//		System.out.println(member);
//		} else {
//			System.out.println("해당 인덱스에는 회원 정보 없습니다.");
//		}
//		
//	}
//
//
//	private void readAllMembers() {
//		System.out.println("\n--- 회원 목록 ---");
//		Member[] members = dao.read();// View에서 컨트롤러 기능을 사용, 출력할 데이터를 가져옴
//		//화면에 출력할 수 있는 정보 가져온 것.
//		
//		for(Member m : members) { //main과 dao사이에서 정보를 주고 받는 것(상호작용)
//			if (m != null) {
//				System.out.println(m);				
//			} 
//			
//		}
//		
//		 
//		
//	}
//
//
//	private void saveNewMember() {
//		System.out.println("\n----- 새 회원 정보 저장 -----");
//
//		System.out.print("아이디를 입력>> ");
//		String id = scanner.nextLine();
//		
//		System.out.print("비밀번호 입력>> ");
//		String password = scanner.nextLine();
//		
//		Member member = new Member(id,password);
//		// 컨트롤러가 가지고 있음 - dao가 컨트롤러
//		int result = dao.create(member); //view 객체에서 컨트롤러 객체의 기능을 사용.
//		if(result == 1) {
//			System.out.println("회원 정보 저장 성공");
//		} else {
//			System.out.println("회원 정보 저장 실패");
//		}
//	}
//
//
//	private int selectMainmenu() {
//		System.out.println("\n---------------------------------");
//		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
//		System.out.println("---------------------------------");
//		System.out.print("선택> ");
//		
//		int menu = Integer.parseInt(scanner.nextLine());// 읽어 드린 문자열 정수 변환.
//		
//		return menu;
//	}
//	
//	
//	
//}// class 끝
