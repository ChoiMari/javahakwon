package com.itwill.ver04.view;

import java.util.List;
import java.util.Scanner;

import com.itwill.ver04.model.Contact; // Model
import com.itwill.ver04.controller.ContactDao;
import com.itwill.ver04.controller.ContactDaoImpl;

// View
public class ContactMain04 {
    
    private final Scanner scanner = new Scanner(System.in);
    private ContactDao dao = ContactDaoImpl.getInstance();
    
    public static void main(String[] args) {
        System.out.println("*** ����ó ���α׷� v0.3 ***");
        
        ContactMain04 app = new ContactMain04();
        
        boolean run = true;
        while (run) {
            int menu = app.selectMainMenu();
            switch (menu) {
            case 0:
                run = false;
                break;
            case 1:
                app.saveNewContact();
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
        System.out.println("\n--- ����ó ���� ---");
        
        System.out.print("������ �ε���>> ");
        int index = inputInteger();
        
        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
            System.out.println("�ش� �ε������� ������ ������ �����ϴ�...");
            return;
        }
        
        int result = dao.delete(index);
        if (result == 1) {
            System.out.println(">>> ����ó ���� ����");
        } else {
            System.out.println(">>> ����ó ���� ����");
        }
    }
    
    private void updateContactByIndex() {
        System.out.println("\n--- ����ó ���� ---");
        
        System.out.print("�ε��� �Է�>> ");
        int index = inputInteger();
        
        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
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
        
        Contact updated = new Contact(0,name, phone, email);
        
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
        int index = inputInteger();
        
        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
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
            System.out.println("[" + index + "] " + c);
            index++;
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
        
        Contact contact = new Contact(0,name, phone, email);
        int result = dao.create(contact);
        if (result == 1) {
            System.out.println(">>> ����ó ���� ����");
        } else {
            System.out.println(">>> ����ó ���� ����");
        }
        
    }
    
    private int selectMainMenu() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("[0]���� [1]���� [2]��� [3]�ε����˻� [4]���� [5]����");
        System.out.println("---------------------------------------------------");
        System.out.print("����> ");
        
        int menu = inputInteger();
        
        return menu;
    }
    
    private int inputInteger() {
        int result = 0;
        
        while(true) {
            try {
                result = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("�Է°��� �������� �մϴ�.");
                System.out.print("���� �Է�>> ");
            }
        }
        
        return result;
    }

}