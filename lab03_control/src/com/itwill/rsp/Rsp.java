package com.itwill.rsp;

import java.util.Random;
import java.util.Scanner;

public class Rsp {

	public static void main(String[] args) {
		// 가위/바위/보 (Rock-Scissors-Paper) 게임:
        // 가위 - 0, 바위 - 1, 보 - 2
        
        // Random 타입 변수를 선언, 초기화.
        // Scanner 타입 변수를 선언, 초기화.
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
        System.out.println("가위바위보 게임");
        System.out.println("---------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.print("선택>>> ");
        
        // 사용자가 콘솔창에서 입력한 정수를 변수(user)에 저장.
        int user = sc.nextInt();
        // 0 이상 3 미만의 정수 난수 1개를 변수(computer)에 저장.
        int com = r.nextInt(3);
        
        String userst = (user == 0) ? "가위" : ((user==1) ? "바위" : "보");
        String comst = (com == 0) ? "가위" : ((com == 1) ? "바위" : "보");
        
        System.out.println("user = "+userst);
        System.out.println("com = "+comst);
        // 가위바위보 게임 결과(User win/Computer win/Tie)를 출력. 

        // else-if 
        if(user == com) {
        	System.out.println("Tie");
        }else if(user - com == -1 || user - com == 2) {
        	System.out.println("Computer win");
        }else if(user - com == 1 || user - com == -2) {
        	System.out.println("user win");
        }else {
        	System.out.println("error");
        }
        
       /*  switch-case구문
        
        switch(user-com) {
        case 0 :
        	System.out.println("Tie");
        	break;
        	
        case -1, 2:
        	System.out.println("Computer win");
        	break;
        	
        case 1, -2:
        	System.out.println("user win");
        	break;
        }
        */
        
        /* else-if 
         
        if(user==com) {
        	System.out.println("Tie");
        } else if(user==0 && com==1) {
        	System.out.println("Computer win");
        } else if(user==0 && com==2) {
        	System.out.println("user win");
        } else if(user==1 && com==0) {
        	System.out.println("user win");
        } else if (user==1 && com==2) {
        	System.out.println("Computer win");
        } else if (user==2 && com== 0) {
        	System.out.println("Computer win");
        } else if (user==2 && com==1) {
        	System.out.println("user win");
        }
        */
        
        /* if 중첩문
  
        if(user == 0) {
        	if(com==0) {
        		System.out.println("Tie");
        	} else if(com==1) {
        		System.out.println("Computer win");
        	} else if(com==2) {
        		System.out.println("user win");
        	}
        }else if (user == 1) {
        	if(com==0) {
        		System.out.println("user win");
        	} else if(com==1) {
        		System.out.println("Tie");
        	} else if(com==2) {
        		System.out.println("computer win");
        	}
        }else if (user == 2) {
        	if(com==0) {
        		System.out.println("Computer win");
        	} else if(com==1) {
        		System.out.println("user win");
        	} else if(com==2) {
        		System.out.println("Tie");
        	}
        }
        */
        
        sc.close();
	}

}
