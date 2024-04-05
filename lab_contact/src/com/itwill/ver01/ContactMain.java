package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain {
	private static final int MAX_LENGTH = 3; // 연락처 배열의 최대 길이(원소개수)

	private Scanner scanner = new Scanner(System.in);
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장하기 위한 배열
	private int count = 0; // 현재까지 연락처 배열에 저장된 개수.
	// 배열에 새로운 연락처가 저장될 때마다 count++을 실행.

	public static void main(String[] args) {

		System.out.println("*** 연락처 프로그램 v0.1");

		boolean run = true; // 프로그램 계속 실행(run=true) 또는 종료(run=false) 여부를 저장하기 위한 변수.

		ContactMain app = new ContactMain();

		while (run) {
			int menu = app.showMainMenu();

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
				app.updataContactByIndex();
				break;

			default:
				System.out.println("메뉴 번호를 확인하세요.");
			}
		}

		System.out.println("*** 프로그램 종료 ***");
	}

	private void updataContactByIndex() {
		System.out.println("\n----- 연락처 수정 -----");

		this.readAllContacts();
		System.out.println();
		
		System.out.print("인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());

		if (index < count) {

			System.out.println("수정전: " + contacts[index]);

			System.out.print("이름 수정>> ");
			String name = scanner.nextLine();

			System.out.print("전화번호 수정>> ");
			String phone = scanner.nextLine();

			System.out.print("이메일 수정>> ");
			String email = scanner.nextLine();

			// 입력한 내용으로 배열의 내용을 업데이트.
			contacts[index].setPhone(phone);
			contacts[index].setName(name);
			contacts[index].setEmail(email);
			
		} else if (MAX_LENGTH < index) {
			
			System.out.println("존재하지 않는 index 입니다");
			
		} else {
			
			System.out.println("해당 인덱스는 비어있습니다.");
			
		}
	}

	private void readContactByIndex() {
		System.out.println("\n--- 인덱스 검색 ---");
		System.out.print("인덱스 입력>>");
		int index = Integer.parseInt(scanner.nextLine());

		// 해당 인덱스의 연락처를 출력
		if (index < count) {
			System.out.println(contacts[index].toString());
		} else if (MAX_LENGTH < index) {
			System.out.println("존재하지 않는 index 입니다");
		} else {
			System.out.println("해당 인덱스는 비어있습니다.");
		}
	}

	private void readAllContacts() {
		System.out.println("\n--- 연락처 목록 ---");

		for (int i = 0; i < count; i++) {
			System.out.println("["+ i +"] "+contacts[i].toString());
		}
	}

	private void saveNewContact() {
		if (count < MAX_LENGTH) {
			System.out.println("\n--- 새 연락처 저장 ---");

			System.out.print("이름 입력>> ");
			String name = scanner.nextLine();

			System.out.print("전화번호 입력>> ");
			String phone = scanner.nextLine();

			System.out.print("이메일 입력>> ");
			String email = scanner.nextLine();

			Contact contact = new Contact(name, phone, email);

			// Contact 타입 객체를 연락처 배열 인덱스 count에 저장
			contacts[count] = contact;
			// 배열에 저장 후에는 연락처 저장 개수(인덱스)를 증가
			count++;
		} else {
			System.out.println("저장 공간이 부족합니다");
		}
	}

	private int showMainMenu() {
		System.out.println("\n---------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("---------------------------------------");
		System.out.print("선택> ");

		int menu = Integer.parseInt(scanner.nextLine());

		return menu;
	}

}