package com.itwill.ver03;

import java.util.List;
import java.util.Scanner;

import com.itwill.ver01.Contact; // Model

// View
public class ContactMain03 {
    
    private final Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();
  //ContactDaoImpl.getInstance(); 은 객체생성(new)없이 클래스이름.으로 메서드 호출 가능
   // 이유 : getInstance()메서드가 static 붙은 메서드라서
  //getInstance()메서드 호출시 instance값 반환됨(instance = new ContactDaoImpl();
    //ContactDaoImpl의 객체가 생성된 번지 반환되어
  // dao에 저장됨. dao가 ContactDaoImpl을 참조. dao.으로 ContactDaoImpl의 필드,메서드 사용 가능
    // 싱글턴을 사용해서 getInstance();의 호출을 몇번 하든 
    // 메모리 heap에 생성된 ContactDaoImpl객체는 딱 1개
    
    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.3 ***");
        
        ContactMain03 app = new ContactMain03();
        // app이 ContactMain03 객체를 참조.(번지값 저장)
        // ContactMain03();에 있는 static 아닌 필드와 메서드 사용하려고
        // 메모리에 객체가 생성되어있어야 사용 가능.
        //app.하면  ContactMain03에 있는 필드와 메서드 사용가능.
        
        boolean run = true; 
        while (run) {
            int menu = app.selectMainMenu(); 
            //selectMainMenu()메서드 호출. 메인 메뉴 출력되고 사용자가 콘솔에 입력한
            //(예외처리 끝난 안전한 int 값) menu에 저장
            //(menu가 지역변수라서 이름 똑같아도 메서드 종료시 메모리에서 사라지기 때문에 
            // 같은 이름으로 사용가능)
            switch (menu) { //사용자가 콘솔에 입력한 값 검사
            case 0: // 사용자가 콘솔에 0입력시 밑의 코드 실행
                run = false; //while의 실행 조건으로 넣은 변수 값을 false로 변경해서 반복문 끝남. 
                break;
            case 1:
                app.saveNewContact();//사용자가 콘솔에 1 입력시 app.(ContactMain03에 있는)
                //saveNewContact(); 메서드 호출
                break;
            case 2:
                app.readAllContacts();
                break;
            case 3:
                app.readContactByIndex();
                break;
            case 4:
                app.updateContactByIndex();
                break;
            case 5:
            	app.deleteContactByIndex();
            	break;
            default:
                System.out.println("메뉴 번호(0 ~ 5)를 확인하세요.");
            }
        }
        
        System.out.println("*** 프로그램 종료 ***");
    }
    
    private void deleteContactByIndex() {
		System.out.println("\n --- 연락처 삭제 ---");
		System.out.print("인덱스 입력>> ");
		int index = inputInteger();
		 if (!dao.isValidIndex(index)) {
	            System.out.println("해당 인덱스에는 수정할 정보가 없습니다...");
	            return;
	        }
	        Contact old = dao.read(index);
	        if(old == null) {
	        	return;
	        }
	        System.out.println(old);
	        System.out.println("해당 연락처를 삭제 하시겠습니까?");
	        int deleteMenu = selectDeleteMenu(); 
	        switch (deleteMenu) {
	        	case 1 :
	        		int result = dao.delete(index);
	        		if(result == 1) {
	        			System.out.println("삭제 되었습니다.");
	        		} else {
	        			System.out.println("삭제에 실패 했습니다.");
	        		}
	        		break;
	        	case 2 :
	        		System.out.println("취소 되었습니다.");
	        		System.out.println("Main menu로 돌아갑니다.");
	        		break;
	        	default :
	        		System.out.println("1,2 외의 값은 입력하실 수 없습니다.");	
	        }
		
	}

	private void updateContactByIndex() {
        System.out.println("\n--- 연락처 수정 ---");
        
        System.out.print("인덱스 입력>> ");
        int index = inputInteger();
        
        if (!dao.isValidIndex(index)) {
            System.out.println("해당 인덱스에는 수정할 정보가 없습니다...");
            return;
        }
        
        Contact old = dao.read(index);
        System.out.println("수정전: " + old);
        
        System.out.print("이름 수정>> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 수정>> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 수정>> ");
        String email = scanner.nextLine();
        
        Contact updated = new Contact(name, phone, email);
        
        int result = dao.update(index, updated);
        if (result == 1) {
            System.out.println(">>> 연락처 수정 성공");
        } else {
            System.out.println(">>> 연락처 수정 실패");
        }
        
    }

    private void readContactByIndex() {
        System.out.println("\n--- 인덱스 검색 ---");
        
        System.out.print("인덱스 입력>> ");
        int index = inputInteger(); //inputInteger();메서드 호출
        // 리턴값으로 사용자가 콘솔에 입력한(안전한 int값 반환받음)
        
        if (!(dao.isValidIndex(index))) {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        }
        
        Contact contact = dao.read(index);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
        }
    }
    
    private void readAllContacts() {
        System.out.println("\n--- 연락처 목록 ---");
        
        List<Contact> contacts = dao.read();
        int index = 0;
        for (Contact c : contacts) {
            if (c != null) {
                System.out.println("[" + index + "] " + c);
                index++;
            }
        }
    }
    
    private void saveNewContact() {
        System.out.println("\n--- 새 연락처 저장 ---");
       
        
        System.out.print("이름 입력>> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 입력>> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 입력>> ");
        String email = scanner.nextLine();
        
        Contact contact = new Contact(name, phone, email);
        // 사용자가 콘솔에 입력한 이름, 전화번호, 이메일을 아규먼트로 넣어서 
        // Contact의 아규먼트가 있는 생성자 호출 - 이 아규먼트로 값을 초기화 시킴.
        //contact에  Contact객체의 주소 저장.
        
        int result = dao.create(contact);
        //ContactDaoImpl의 create메서드 호출 -  contact를 아규먼트로 넣어서
        
        if (result == 1) {
            System.out.println(">>> 연락처 저장 성공");
        } else {
            System.out.println(">>> 연락처 저장 실패");
        }
        
    }
    
    private int selectMainMenu() {
        System.out.println("\n-----------------------------------------------------");
        System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정 [5]삭제");
        System.out.println("-----------------------------------------------------");
        System.out.print("선택> ");
        
        int menu = inputInteger(); 
        // inputInteger();메서드 실행 되고 리턴값으로
        // result(사용자가 콘솔에 입력한 값 - 예외 처리된 안전한 값)돌려 받은걸
        // menu에 저장
        
        return menu; // 호출한 곳으로 menu(사용자가 콘솔에 입력한 안전한 값)반환.
    }
    
    private int selectDeleteMenu() {
        System.out.println("-----------------------------------------------------");
        System.out.println("[1]삭제 [2]취소");
        System.out.println("-----------------------------------------------------");
        System.out.print("선택> ");
        
        int deletMenu = inputInteger(); 
        // inputInteger();메서드 실행 되고 리턴값으로
        // result(사용자가 콘솔에 입력한 값 - 예외 처리된 안전한 값)돌려 받은걸
        // deletMenu에 저장
        
        return deletMenu; // 호출한 곳으로 deletMenu(사용자가 콘솔에 입력한 안전한 값)반환.
    }
    
    private int inputInteger() { //메인 메뉴 출력되고 호출됨 , 인덱스 목록보기 시 호출됨
        int result = 0;
        
        while(true) {
            try {
                result = Integer.parseInt(scanner.nextLine()); 
                // 사용자가 콘솔에 입력한값을 result에 저장 .
                // 사용자가 입력한 값에 예외없으면 
                break;// 반복문 while 빠져나옴.
            } catch (Exception e) { // 사용자가 콘솔에 입력한 값에
            	// NumberFormatException 예외가 생기면 실행
                System.out.println("입력값은 정수여야 합니다.");
                System.out.print("정수 입력>> ");
            }
        }
        
        return result; // 사용자가 콘솔에 입력한 값에 예외가 없을 시 
        // 반복문 빠져나와 사용자가 입력한 값을 호출한 곳으로 돌려줌.
    }

}







//package com.itwill.ver03;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import com.itwill.ver01.Contact; // Model
//
//// View
//public class ContactMain03 {
//    
//    private final Scanner scanner = new Scanner(System.in);
//    ContactDaoImpl dao = new ContactDaoImpl();
//    
//    public static void main(String[] args) {
//        System.out.println("*** 연락처 프로그램 v0.3 ***");
//        
//        ContactMain03 app = new ContactMain03();
//        
//        boolean run = true;
//        while (run) {
//            int menu = app.selectMainMenu();
//            switch (menu) {
//            case 0:
//                run = false;
//                break;
//            case 1:
//                app.saveNewContact();
//                break;
//            case 2:
//                app.readAllContacts();
//                break;
//            case 3:
//                app.readContactByIndex();
//                break;
//            case 4:
//                app.updateContactByIndex();
//                break;
//            case 5:
//            	app.deleteContactByIndex();
//            	break;
//            default:
//                System.out.println("메뉴 번호(0 ~ 5)를 확인하세요.");
//            }
//        }
//        
//        System.out.println("*** 프로그램 종료 ***");
//    }
//    
//    private void readContactByIndex() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private void readAllContacts() {
//		dao.read();
//		
//	}
//
//	private void saveNewContact() {
//		System.out.println("\n--- 새 연락처 저장 ---");
//		
//        System.out.print("이름 입력>> ");
//        String name = scanner.nextLine();
//        
//        System.out.print("전화번호 입력>> ");
//        String phone = scanner.nextLine();
//        
//        System.out.print("이메일 입력>> ");
//        String email = scanner.nextLine();
//        
////        ArrayList<Contact> contact = new ArrayList<>();
////        contact.add(new Contact(name,phone,email));
////        dao.create(contact);
//        
//        ArrayList<Contact> contact = new ArrayList<>();
//        contact.add(new Contact(name,phone,email));
//        System.out.println(contact);
//        
//        
//        
////        contact.add(name);
////        Contact contact = new Contact(name, phone, email);
////        int result = dao.create(contact);
////        if (result == 1) {
////            System.out.println(">>> 연락처 저장 성공");
////        } else {
////            System.out.println(">>> 연락처 저장 실패");
////        }
////        
////    }
//		
//	}
//
//	private void deleteContactByIndex() {
//		System.out.println("\n--- 연락처 삭제 ---");
//		
//		
//	}
//
//	private void updateContactByIndex() {}
////        System.out.println("\n--- 연락처 수정 ---");
////        
////        System.out.print("인덱스 입력>> ");
////        int index = inputInteger();
////        
////        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
////            System.out.println("해당 인덱스에는 수정할 정보가 없습니다...");
////            return;
////        }
////        
////        Contact old = dao.read(index);
////        System.out.println("수정전: " + old);
////        
////        System.out.print("이름 수정>> ");
////        String name = scanner.nextLine();
////        
////        System.out.print("전화번호 수정>> ");
////        String phone = scanner.nextLine();
////        
////        System.out.print("이메일 수정>> ");
////        String email = scanner.nextLine();
//        
////        Contact updated = new Contact(name, phone, email);
//        
////        int result = dao.update(index, updated);
////        if (result == 1) {
////            System.out.println(">>> 연락처 수정 성공");
////        } else {
////            System.out.println(">>> 연락처 수정 실패");
////        }
//        
////    }
////
////    private void readContactByIndex() {
////        System.out.println("\n--- 인덱스 검색 ---");
////        
////        System.out.print("인덱스 입력>> ");
////        int index = inputInteger();
//        
////        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
////            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
////            return;
////        }
//        
////        Contact contact = dao.read(index);
////        if (contact != null) {
////            System.out.println(contact);
////        } else {
////            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
////        }
////    }
////    
////    private void readAllContacts() {
////        System.out.println("\n--- 연락처 목록 ---");
////        
//////        Contact[] contacts = dao.read();
//////        int index = 0;
//////        for (Contact c : contacts) {
//////            if (c != null) {
//////                System.out.println("[" + index + "] " + c);
//////                index++;
//////            }
////        }
//////    }
////    
////    private void saveNewContact() {
////        System.out.println("\n--- 새 연락처 저장 ---");
////        
////        if (((ContactDaoImpl) dao).isMemoryFull()) {
////            System.out.println("저장 공간이 부족합니다...");
////            return; // 메서드 종료
////        }
////        
////        System.out.print("이름 입력>> ");
////        String name = scanner.nextLine();
////        
////        System.out.print("전화번호 입력>> ");
////        String phone = scanner.nextLine();
////        
////        System.out.print("이메일 입력>> ");
////        String email = scanner.nextLine();
////        
////        Contact contact = new Contact(name, phone, email);
////        int result = dao.create(contact);
////        if (result == 1) {
////            System.out.println(">>> 연락처 저장 성공");
////        } else {
////            System.out.println(">>> 연락처 저장 실패");
////        }
////        
////    }
//    
//    private int selectMainMenu() {
//        System.out.println("\n-----------------------------------------------------");
//        System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정 [5]삭제");
//        System.out.println("-----------------------------------------------------");
//        System.out.print("선택> ");
//        
//        int menu = inputInteger();
//        
//        return menu;
//    }
//    
//    private int inputInteger() {
//        int result = 0;
//        
//        while(true) {
//            try {
//                result = Integer.parseInt(scanner.nextLine());
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("입력값은 정수여야 합니다.");
//                System.out.print("정수 입력>> ");
//            }
//        }
//        
//        return result;
//    }
//
//}