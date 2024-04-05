package com.itwill.controller;

import com.itwill.model.Member;

// MVC 아키텍쳐에서 컨트롤러 역할을 담당할 클래스 -> 싱글턴으로 구현.
public class MemberDaoImpl implements MemberDao {
    
    //----- singleton 구현
    private static MemberDaoImpl instance = null;
    
    private MemberDaoImpl() {} //이거 주석 처리하면 안된다.
    
    public static MemberDaoImpl getInstance() {
        if (instance == null) {
            instance = new MemberDaoImpl(); //처음에는 null이라서 실행 가능하지만 두번째 부터는 생성자 호출부분 건너뛰고
            //바로 주소값 리턴하게 됨. 그래서 항상 같은 객체의 주소값 리턴.몇 번을 호출하든 
        }
        
        return instance;
    }
    //----- singleton 구현 끝
    
    // 회원 정보를 저장할 배열 선언
    private Member[] members = new Member[MAX_LENGTH];
//private라서 읽어오려면 getter필요
    
    // 회원 배열에 현재까지 저장된 원소의 개수 -> 새로운 회원 정보를 저장할 위치(배열 인덱스)
    private int count = 0; // 배열에 원소가 추가될 때마다 ++.
    // 배열의 인덱스로 사용하려고 선언하고 0으로 초기화 한 변수
    // main()에서 private으로 선언된 걸 읽어오려면 getcount 만들어서 사용하면 됨.
    // private int getCount() {} 만들어서 메인에서 이용해도 됨 -> 메인 63번코드 참조.
    
    /**
     * 회원 정보를 저장하는 배열이 가득 차 있으면 true, 빈 공간(null)이 있으면 false를 리턴.
     * @return true/false
     */
    public boolean isMemoryFull() { 
        return (count == MAX_LENGTH); 
    }
    
    /**
     * 인덱스가 배열의 유효한 인덱스인 지를 검사.
     * 인덱스가 0 이상이고, 배열에 저장된 원소 개수보다 작으면 true, 그렇지 않으면 false를 리턴.
     * @param index 검사할 인덱스(정수).
     * @return true/false.
     */
    public boolean isValidIndex(int index) { //리턴값이 true면 적절한 인덱스, false면 적절하지 않은 인덱스
        return (index >= 0) && (index < count); // 조건에 만족하면 이 메서드를 호출한 곳에 true리턴, 만족안하면 false리턴
        // 배열의 인덱스는 항상 0보다 크거나 같아야 한다. 그리고
        // 배열이 만약 3개짜리인데 3개 다 null로 되어있으면 null인 거 찾을 경우 nullpointer~에러뜨니까 방지하기 위해서
        // null이 아닌게 어디까지 들어오느냐. 
        // 음수 인덱스 번호 들어오는 것도 꼭 방지해야!!
    }
    
    @Override
    public int create(Member member) {
        if (isMemoryFull()) { //현재 저장된 count(저장횟수) = MAX_LENGTH(배열 크기)면 저장 가득참.
            return 0; // 저장 실패시 0을 리턴 - 저장이 가득차면 저장 실패.
        }
        
        members[count] = member; //배열에 멤버를 저장하고 count++(저장된 횟수 count)
        count++;
        
        return 1; //(저장 성공시 1을 리턴.)
    }

    @Override
    public Member[] read() { //메인에서 출력할 때 null아닌걸로 출력하도록 바꿔도 상관 없음.
    	// 어차피 print출력이라 상관 없다고 함.
    	// 이건 한 번 보여줄려고 이렇게 작성 하셨다고..
    	
        // 배열 members의 원소들 중 null이 아닌 원소들로만 이루어진 배열을 리턴.
        Member[] result = new Member[count]; //원본배열에 객체가 한 개도 없으면 count는 0 그럼 원소를 한개도 저장 못한다고함.
        // count가 1인 경우 1개만 저장할 수 있는 배열 이런 뜻. 
        for (int i = 0; i < count; i++) { //count가 배열의 크기가 되는 것.
            result[i] = members[i]; //count가 0일 때 아무것도 저장 못한다 -> 조건이 i < count로 해놓아서
        } // 일종의 복사. 저장된 게 1개면 result이 1개짜리 배열이 되는 것.
        
        return result;
    }// 만약 삭제기능을 만든다고 하면 이런 로직이 필요하다고 함.
    // 만약 3개짜리 배열이 있는데 중간에 2번 위치를 삭제하고 싶으면 3번째 위치(뒷쪽에 있는 것들을) 앞으로 다 떙겨와야한다고함.
    //그래서 중간에 빈자리가 안 생기게 중간을 다 채워주고 마지막 위치를 빈자리로 만들어서 그 빈자리를 null로 해야 한다고...
    // 원본 배열에서 같은 위치로 하나씩 가져온다. 
    // 아니면 i+1번째에 있는 위치를 i번 째로 가져온다. // 배열의 크기 자동으로 늘려주거나, 중간에 삭제해서 비어진걸 삭제하거나
    // 새로운 배열을 new해서 배열의 크키를 늘림. 그리고 뒤에 빈자리를 null
    // 근데 굳이 이렇게 어렵게는 안한다고.. 리스트라고 하는 클래스?메서드? 이용하면 자동으로 해줘서...

    @Override
    public Member read(int index) { 
        if (isValidIndex(index)) { //isValidIndex : 인덱스가 0보다 크거나 같고(음수 방지) 
        	// 인덱스 위치에 있는 배열 원소가 null이 아닌 값이 들어오면(인덱스가 count보다 작으면)
            return members[index];
        } else {
            return null;
        }
    }

    @Override
    public int update(int index, String password) { // 패스워드 성공 1 , 실패 0 
        if (isValidIndex(index)) {  // 검사하는 코드 필요(NullPointer~~에러 방지)
            members[index].setPassword(password);
            return 1;
        } else {
            return 0;
        }
    }

}



//package com.itwill.controller;
//
//import com.itwill.model.Member;
//
////MVC 아키텍쳐에서 컨트롤러 역할을 담당할 클래스. - 싱글턴으로 구현.(heap에 객체 생성 오직 1개)
//// (객체 생성 전 미리 메모리에 올라와서 만들어져 와있어야 하니까 static)
//	
//public class MemberDaoImpl implements MemberDao {
//	
//	//싱글턴 구현 시작
//	private static MemberDaoImpl instance = null; //객체 생성 주소값을 저장하는 변수.
//	
//	// 객체 없는 상태에서 메소드 호출 해야 되니까 static
//	public static MemberDaoImpl getInstance() {
//		if(instance == null) {
//			instance = new MemberDaoImpl(); //instance에 MemberDaoImpl()객체 생성 주소값 저장.
//		}
//		return instance;
//	} // 싱글턴 구현 끝
//	
//	// 회원 정보를 저장할 배열 선언
//	private Member[] members = new Member[MAX_LENGTH]; 
//	//MAX_LENGTH는 MemberDao라고 하는 인터페이스에서 옴. 그래서 import문장 필요 없음.
//	// 상속 받아도 부모에서 private로 감춰버리면 안 보여서 못 씀.
//	
//	// 회원 배열에 현재까지 저장된 원소의 개수 -> 새로운 회원 정보를 저장할 위치(배열의 인덱스)로 count이용.
//	private int count = 0; //한 개도 저장되어 있지 않으면 배열의 인덱스 0 
//	// 새로운 회원 정보가 채워지면 count를 1증가 시켜서 인덱스 1로 저장되도록. 
//	// 배열에 원소를 넣을 때 마다 count 1씩 증가 시킬 것 ++
//	
//	@Override
//	public int create(Member member) {
//		
//		if(count < MAX_LENGTH) {
//		 members[count] = member; // 배열의 [새로운 회원정보를 넣을 위치 [count]에 회원정보 저장 
//		 count++; // 회원 정보를 저장할 때마다 인덱스 번호로 사용할 count ++ 증가
//		 return 1;
//		} else {
//			System.out.println("저장 공간이 부족합니다.");
//			return 0;
//		}
//		
//	}
//
//	@Override
//	public Member[] read() {
//		// 배열 members의 원소들 중 null이 아닌 원소들로만 이루어진 배열을 리턴.
//		// 원본 배열에서 개수만큼만 복사해서 리턴
//		// 목록에 있는 것 만큼만 출력..??
//		// 에러 발생 코드는 아니지만
//			return members;
//		//회원 정보를 저장하고 있는 배열 members 리턴
//	}
//
//	@Override
//	public Member read(int index) {
//		  //인덱스 if -else써서 범위 안에 있는것은 멤버배열 리턴
//		//인덱스에 음수값이나 배열 길이보다 큰값 들어오면 null리턴
//		if(index < 0 || index >= MAX_LENGTH) {
//			return null;
//		} else {
//		return members[index]; //배열의 음수 또는 배열 크기 범위 벗어나는 아규먼트값 들어 올 때의 오류는 나중에 수정.
//		}
//	}
//
//	@Override
//	public int update(int index, String password) {
//		// 리턴 1 else 리턴 0 ??
////		if(count == 0) {
////			System.out.println("업데이트 할 연락처가 없습니다.");
////			return 0;
////		} else {
//		 members[index].setPassword(password);
//		return 1;
////		}
//	}
//
//}
