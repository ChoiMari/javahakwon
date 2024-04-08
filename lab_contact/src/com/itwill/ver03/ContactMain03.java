package com.itwill.ver03;

import java.util.List;
import java.util.Scanner;

import com.itwill.ver01.Contact; // Model

// View
public class ContactMain03 {
    
    private final Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();
  //ContactDaoImpl.getInstance(); �� ��ü����(new)���� Ŭ�����̸�.���� �޼��� ȣ�� ����
   // ���� : getInstance()�޼��尡 static ���� �޼����
  //getInstance()�޼��� ȣ��� instance�� ��ȯ��(instance = new ContactDaoImpl();
    //ContactDaoImpl�� ��ü�� ������ ���� ��ȯ�Ǿ�
  // dao�� �����. dao�� ContactDaoImpl�� ����. dao.���� ContactDaoImpl�� �ʵ�,�޼��� ��� ����
    // �̱����� ����ؼ� getInstance();�� ȣ���� ��� �ϵ� 
    // �޸� heap�� ������ ContactDaoImpl��ü�� �� 1��
    
    public static void main(String[] args) {
        System.out.println("*** ����ó ���α׷� v0.3 ***");
        
        ContactMain03 app = new ContactMain03();
        // app�� ContactMain03 ��ü�� ����.(������ ����)
        // ContactMain03();�� �ִ� static �ƴ� �ʵ�� �޼��� ����Ϸ���
        // �޸𸮿� ��ü�� �����Ǿ��־�� ��� ����.
        //app.�ϸ�  ContactMain03�� �ִ� �ʵ�� �޼��� ��밡��.
        
        boolean run = true; 
        while (run) {
            int menu = app.selectMainMenu(); 
            //selectMainMenu()�޼��� ȣ��. ���� �޴� ��µǰ� ����ڰ� �ֿܼ� �Է���
            //(����ó�� ���� ������ int ��) menu�� ����
            //(menu�� ���������� �̸� �Ȱ��Ƶ� �޼��� ����� �޸𸮿��� ������� ������ 
            // ���� �̸����� ��밡��)
            switch (menu) { //����ڰ� �ֿܼ� �Է��� �� �˻�
            case 0: // ����ڰ� �ֿܼ� 0�Է½� ���� �ڵ� ����
                run = false; //while�� ���� �������� ���� ���� ���� false�� �����ؼ� �ݺ��� ����. 
                break;
            case 1:
                app.saveNewContact();//����ڰ� �ֿܼ� 1 �Է½� app.(ContactMain03�� �ִ�)
                //saveNewContact(); �޼��� ȣ��
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
                System.out.println("�޴� ��ȣ(0 ~ 5)�� Ȯ���ϼ���.");
            }
        }
        
        System.out.println("*** ���α׷� ���� ***");
    }
    
    private void deleteContactByIndex() {
		System.out.println("\n --- ����ó ���� ---");
		System.out.print("�ε��� �Է�>> ");
		int index = inputInteger();
		 if (!dao.isValidIndex(index)) {
	            System.out.println("�ش� �ε������� ������ ������ �����ϴ�...");
	            return;
	        }
	        Contact old = dao.read(index);
	        if(old == null) {
	        	return;
	        }
	        System.out.println(old);
	        System.out.println("�ش� ����ó�� ���� �Ͻðڽ��ϱ�?");
	        int deleteMenu = selectDeleteMenu(); 
	        switch (deleteMenu) {
	        	case 1 :
	        		int result = dao.delete(index);
	        		if(result == 1) {
	        			System.out.println("���� �Ǿ����ϴ�.");
	        		} else {
	        			System.out.println("������ ���� �߽��ϴ�.");
	        		}
	        		break;
	        	case 2 :
	        		System.out.println("��� �Ǿ����ϴ�.");
	        		System.out.println("Main menu�� ���ư��ϴ�.");
	        		break;
	        	default :
	        		System.out.println("1,2 ���� ���� �Է��Ͻ� �� �����ϴ�.");	
	        }
		
	}

	private void updateContactByIndex() {
        System.out.println("\n--- ����ó ���� ---");
        
        System.out.print("�ε��� �Է�>> ");
        int index = inputInteger();
        
        if (!dao.isValidIndex(index)) {
            System.out.println("�ش� �ε������� ������ ������ �����ϴ�...");
            return;
        }
        
        Contact old = dao.read(index);
        System.out.println("������: " + old);
        
        System.out.print("�̸� ����>> ");
        String name = scanner.nextLine();
        
        System.out.print("��ȭ��ȣ ����>> ");
        String phone = scanner.nextLine();
        
        System.out.print("�̸��� ����>> ");
        String email = scanner.nextLine();
        
        Contact updated = new Contact(name, phone, email);
        
        int result = dao.update(index, updated);
        if (result == 1) {
            System.out.println(">>> ����ó ���� ����");
        } else {
            System.out.println(">>> ����ó ���� ����");
        }
        
    }

    private void readContactByIndex() {
        System.out.println("\n--- �ε��� �˻� ---");
        
        System.out.print("�ε��� �Է�>> ");
        int index = inputInteger(); //inputInteger();�޼��� ȣ��
        // ���ϰ����� ����ڰ� �ֿܼ� �Է���(������ int�� ��ȯ����)
        
        if (!(dao.isValidIndex(index))) {
            System.out.println("�ش� �ε������� ����ó ������ �����ϴ�.");
            return;
        }
        
        Contact contact = dao.read(index);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("�ش� �ε������� ����ó ������ �����ϴ�.");
        }
    }
    
    private void readAllContacts() {
        System.out.println("\n--- ����ó ��� ---");
        
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
        System.out.println("\n--- �� ����ó ���� ---");
       
        
        System.out.print("�̸� �Է�>> ");
        String name = scanner.nextLine();
        
        System.out.print("��ȭ��ȣ �Է�>> ");
        String phone = scanner.nextLine();
        
        System.out.print("�̸��� �Է�>> ");
        String email = scanner.nextLine();
        
        Contact contact = new Contact(name, phone, email);
        // ����ڰ� �ֿܼ� �Է��� �̸�, ��ȭ��ȣ, �̸����� �ƱԸ�Ʈ�� �־ 
        // Contact�� �ƱԸ�Ʈ�� �ִ� ������ ȣ�� - �� �ƱԸ�Ʈ�� ���� �ʱ�ȭ ��Ŵ.
        //contact��  Contact��ü�� �ּ� ����.
        
        int result = dao.create(contact);
        //ContactDaoImpl�� create�޼��� ȣ�� -  contact�� �ƱԸ�Ʈ�� �־
        
        if (result == 1) {
            System.out.println(">>> ����ó ���� ����");
        } else {
            System.out.println(">>> ����ó ���� ����");
        }
        
    }
    
    private int selectMainMenu() {
        System.out.println("\n-----------------------------------------------------");
        System.out.println("[0]���� [1]���� [2]��� [3]�ε����˻� [4]���� [5]����");
        System.out.println("-----------------------------------------------------");
        System.out.print("����> ");
        
        int menu = inputInteger(); 
        // inputInteger();�޼��� ���� �ǰ� ���ϰ�����
        // result(����ڰ� �ֿܼ� �Է��� �� - ���� ó���� ������ ��)���� ������
        // menu�� ����
        
        return menu; // ȣ���� ������ menu(����ڰ� �ֿܼ� �Է��� ������ ��)��ȯ.
    }
    
    private int selectDeleteMenu() {
        System.out.println("-----------------------------------------------------");
        System.out.println("[1]���� [2]���");
        System.out.println("-----------------------------------------------------");
        System.out.print("����> ");
        
        int deletMenu = inputInteger(); 
        // inputInteger();�޼��� ���� �ǰ� ���ϰ�����
        // result(����ڰ� �ֿܼ� �Է��� �� - ���� ó���� ������ ��)���� ������
        // deletMenu�� ����
        
        return deletMenu; // ȣ���� ������ deletMenu(����ڰ� �ֿܼ� �Է��� ������ ��)��ȯ.
    }
    
    private int inputInteger() { //���� �޴� ��µǰ� ȣ��� , �ε��� ��Ϻ��� �� ȣ���
        int result = 0;
        
        while(true) {
            try {
                result = Integer.parseInt(scanner.nextLine()); 
                // ����ڰ� �ֿܼ� �Է��Ѱ��� result�� ���� .
                // ����ڰ� �Է��� ���� ���ܾ����� 
                break;// �ݺ��� while ��������.
            } catch (Exception e) { // ����ڰ� �ֿܼ� �Է��� ����
            	// NumberFormatException ���ܰ� ����� ����
                System.out.println("�Է°��� �������� �մϴ�.");
                System.out.print("���� �Է�>> ");
            }
        }
        
        return result; // ����ڰ� �ֿܼ� �Է��� ���� ���ܰ� ���� �� 
        // �ݺ��� �������� ����ڰ� �Է��� ���� ȣ���� ������ ������.
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
//        System.out.println("*** ����ó ���α׷� v0.3 ***");
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
//                System.out.println("�޴� ��ȣ(0 ~ 5)�� Ȯ���ϼ���.");
//            }
//        }
//        
//        System.out.println("*** ���α׷� ���� ***");
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
//		System.out.println("\n--- �� ����ó ���� ---");
//		
//        System.out.print("�̸� �Է�>> ");
//        String name = scanner.nextLine();
//        
//        System.out.print("��ȭ��ȣ �Է�>> ");
//        String phone = scanner.nextLine();
//        
//        System.out.print("�̸��� �Է�>> ");
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
////            System.out.println(">>> ����ó ���� ����");
////        } else {
////            System.out.println(">>> ����ó ���� ����");
////        }
////        
////    }
//		
//	}
//
//	private void deleteContactByIndex() {
//		System.out.println("\n--- ����ó ���� ---");
//		
//		
//	}
//
//	private void updateContactByIndex() {}
////        System.out.println("\n--- ����ó ���� ---");
////        
////        System.out.print("�ε��� �Է�>> ");
////        int index = inputInteger();
////        
////        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
////            System.out.println("�ش� �ε������� ������ ������ �����ϴ�...");
////            return;
////        }
////        
////        Contact old = dao.read(index);
////        System.out.println("������: " + old);
////        
////        System.out.print("�̸� ����>> ");
////        String name = scanner.nextLine();
////        
////        System.out.print("��ȭ��ȣ ����>> ");
////        String phone = scanner.nextLine();
////        
////        System.out.print("�̸��� ����>> ");
////        String email = scanner.nextLine();
//        
////        Contact updated = new Contact(name, phone, email);
//        
////        int result = dao.update(index, updated);
////        if (result == 1) {
////            System.out.println(">>> ����ó ���� ����");
////        } else {
////            System.out.println(">>> ����ó ���� ����");
////        }
//        
////    }
////
////    private void readContactByIndex() {
////        System.out.println("\n--- �ε��� �˻� ---");
////        
////        System.out.print("�ε��� �Է�>> ");
////        int index = inputInteger();
//        
////        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
////            System.out.println("�ش� �ε������� ����ó ������ �����ϴ�.");
////            return;
////        }
//        
////        Contact contact = dao.read(index);
////        if (contact != null) {
////            System.out.println(contact);
////        } else {
////            System.out.println("�ش� �ε������� ����ó ������ �����ϴ�.");
////        }
////    }
////    
////    private void readAllContacts() {
////        System.out.println("\n--- ����ó ��� ---");
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
////        System.out.println("\n--- �� ����ó ���� ---");
////        
////        if (((ContactDaoImpl) dao).isMemoryFull()) {
////            System.out.println("���� ������ �����մϴ�...");
////            return; // �޼��� ����
////        }
////        
////        System.out.print("�̸� �Է�>> ");
////        String name = scanner.nextLine();
////        
////        System.out.print("��ȭ��ȣ �Է�>> ");
////        String phone = scanner.nextLine();
////        
////        System.out.print("�̸��� �Է�>> ");
////        String email = scanner.nextLine();
////        
////        Contact contact = new Contact(name, phone, email);
////        int result = dao.create(contact);
////        if (result == 1) {
////            System.out.println(">>> ����ó ���� ����");
////        } else {
////            System.out.println(">>> ����ó ���� ����");
////        }
////        
////    }
//    
//    private int selectMainMenu() {
//        System.out.println("\n-----------------------------------------------------");
//        System.out.println("[0]���� [1]���� [2]��� [3]�ε����˻� [4]���� [5]����");
//        System.out.println("-----------------------------------------------------");
//        System.out.print("����> ");
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
//                System.out.println("�Է°��� �������� �մϴ�.");
//                System.out.print("���� �Է�>> ");
//            }
//        }
//        
//        return result;
//    }
//
//}