package com.itwill.string;

public class StringEx {

    public static void main(String[] args) {
        // java.lang.String 클래스의 메서드 사용법
        
        System.out.println("ex1 -----");
        // ex1. 주민번호에서 성별을 표시하는 위치의 문자열 찾기
        String ssn = "990405-2000000";
        System.out.println(ssn.charAt(7));
        
        System.out.println("ex2 -----");
        // ex2. 문자열 자르기
        String date = "2024-04-05";
        String[] array = date.split("-");
        for (String s : array) {
            System.out.println(s);
        }
        
        System.out.println("ex3 -----");
        // ex3. 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력.
        // 결과: JavaScript Servlet Spring
        String[] languages = {"Java", "SQL", "JavaScript", "HTML", "CSS", "Servlet", "Spring"};
        for (String s : languages) {
            if (s.length() >= 5) { //s.하면 String 클래스가 가지고 있는 메서드 호출 가능
            	// 문자열의 길이 값 리턴 해주는 메서드 length()
            	// 문자열의 길이가 5이상이면 {}실행
                System.out.print(s + " ");
            }
        }
        System.out.println();
        
        System.out.println("ex4 -----");
        // ex4. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
        // 만약에 "홍길동"이 배열에 없는 경우에는 -1을 출력.
        // 결과: 2
        String[] names = {"오쌤", "John", "홍길동", "Gildong", "홍길동"};
        int index = -1; //인덱스 변수 선언
        for (int i = 0; i < names.length; i++) { //인덱스를 찾아야 해서 일반 for문 사용
            if (names[i].equals("홍길동")) { //equals("홍길동")가 핵심. 문자열에는 비교연산자(==)사용 X
            	//비교할 문자열.equals(아규먼트)는  .왼쪽에 있는 문자열이 아규먼트와 같은지 비교.
            	//equals메서드는 boolean타입으로 리턴
                index = i; 
                break;// 처음 등장하는 홍길동만 찾으면 되니까 찾으면 break;로 반복문 나감.
            }
        }
        System.out.println(index); // 출력을 코드 밖에 한 이유 : 배열 안에 홍길동이 없을 때는 
        // 문제에서-1을 출력하라고 했기 때문에.. // 출력을 if문{}안 break;위에 했으면 출력되는 문장 없다고 함.
        
        System.out.println("ex5 -----");
        // ex5. 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
        // 결과: TEST test TeSt tEsT
        String[] tests = {"TEST", "test", "TeSt", "tEsT", "테스트"};
        for (String s : tests) { //이런 패턴 자주 이용된다고 함. 
        	// 이렇게 변수 선언 하면 s.할 때 String이 가지고 있는 메서드 호출 가능
            if (s.toLowerCase().contains("est")) { //contains메서드 리턴타입 boolean est를 포함하고 있으면 true,포함X false
            	//toLowerCase()는 문자열을 소문자로 변환한 새로운 값을 리턴해주는 것
            	//다 소문자로 변환 뒤에 contains메서드로 est포함하는지 비교검사
            	//s.toUpperCase().contains("EST") 도 똑같은 결과 나옴 : 대문자로 변환한 값 리턴 받은 뒤에 
            	// 그 문자열이 EST를 포함하는지 비교
            	// 클래스 타입의 객체들만 .을 이요해서 메서드 호출 가능
                System.out.print(s + " ");
            }
        }
        System.out.println();
        
        System.out.println("ex6 -----");
        // ex6. 아래의 "YYYY-MM-DD" 형식의 문자열에서 년/월/일 정보를 "int" 타입 변수에 저장하고 출력.
        // 결과: year=2024, month=4, day=5
        String today = "2024-04-05";
        String[] stringArray = today.split("-"); // split("-") : -로 구분해서 잘라라.
        int year = Integer.parseInt(stringArray[0]); //stringArray의 인덱스 0번 원소를 정수로 변환해서 int타입의 year에 저장.
        int month = Integer.parseInt(stringArray[1]);//stringArray의 인덱스 1번 원소를 정수로 변환해서 int타입의 month에 저장.
        int day = Integer.parseInt(stringArray[2]);//stringArray의 인덱스 2번 원소를 정수로 변환해서 int타입의 day에 저장.
        System.out.printf("year=%d, month=%d, day=%d\n", year, month, day); // 출력
        
    }
}
//	}
//
//}

//package com.itwill.string;
//
//public class StringEx {
//
//	
//	public static void main(String[] args) {
//		// java.lang.Srting 클래스에 있는 메서드 사용법.
//			
//			//ex1. 주민번호에서 성별을 표시하는 위치의 문자열 찾기
//			String ssn = "990405-2000000";
//			System.out.println(ssn.charAt(7)); // charAt(7) 문자열의 7번째 자리에 있는 값을 리턴
//			
//			//ex2. 문자열 자르기
//			String date = "2024-04-05";
//			String[] array = date.split("-"); //-로 자르겠다는 의미
//			for(String s : array) { //배열의 원소를 순서대로 꺼내서 출력해 보려고 향상된 for문 사용
//			// 배열의 인덱스 0번 2024 , 1번 04 , 2번 05
//			System.out.println(s);
//				
//			// ex3. 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력.
//		    // 결과: JavaScript Servlet Spring
//		    String[] languages = {"Java", "SQL", "JavaScript", "HTML", "CSS", "Servlet", "Spring"};
//		    
//		    
//		    for(int i = 0;i < languages.length;i++) {
//		    	String f = languages[i];
//		    	int result = f.length();
//		    	if(result >= 5) {
//		    		System.out.println();
//		    	}
//		    }
////		    
////		    for(String f :languages) {
////		    	
////		    	if(f.length() >= 5) {
////		    		System.out.println(f);
////		    	}
////		    	
////		    }


		        
		        
//		    // ex4. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
//		    // 만약에 "홍길동"이 배열에 없는 경우에는 -1을 출력.
//		    // 결과: 2
//		    String[] names = {"오쌤", "John", "홍길동", "Gildong", "홍길동"};
//		    // TODO
//		        
//		        
//		    // ex5. 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
//		    // 결과: TEST test TeSt tEsT
//		    String[] tests = {"TEST", "test", "TeSt", "tEsT", "테스트"};
//		    // TODO
//		        
//		        
//		    // ex6. 아래의 "YYYY-MM-DD" 형식의 문자열에서 년/월/일 정보를 "int" 타입 변수에 저장하고 출력.
//		    // 결과: year=2023, month=4, day=5
//		    String today = "2024-04-05";
//		    // TODO
//			}
//		
//	}
//	
//}
