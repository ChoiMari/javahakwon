package com.itwill.ver05.controller;

import static com.itwill.ver05.util.FileUtil.*;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver05.model.Contact;
//import com.itwill.ver05.util.FileUtil;

// MVC 아키텍쳐에서 Controller 역할 담당 클래스. DAO(Data Access Object).
public class ContactDaoImpl implements ContactDao {
    //----- singleton
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {
        // 데이터 폴더 초기화: 폴더가 없으면 새로 만듦.
        initializeDataDir();
        
        // 연락처 데이터 초기화: 데이터 파일에서 리스트를 읽어오거나, 빈 리스트를 생성.
        contacts = initializeData();
    }
    
    public static ContactDaoImpl getInstance() { // getInstance()메서드는 몇번을 호출 하든 
    	// 처음 if{}이 실행되서 저장됐던 ContactDaoImpl()객체의 동일한 주소를 호출함.
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }
    //----- singleton
    
    private List<Contact> contacts;
    
    /**
     * 인덱스가 연락처 리스트의 유효한 범위 안에 있는 지를 리턴.
     * @param index 검사할 인덱스.
     * @return 유효한 인덱스이면 true, 그렇지 않으면 false.
     */
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < contacts.size());
    }

    @Override
    public int create(Contact contact) {
        contacts.add(contact); // 리스트(메모리)에 추가.
        writeDataToFile(contacts); // 파일에 씀.
        
        return 1;
    }

    @Override
    public List<Contact> read() {
        return contacts;
    }

    @Override
    public Contact read(int index) {
        if (isValidIndex(index)) {
            return contacts.get(index);
        } else {
            return null;
        }
    }

    @Override
    public int update(int index, Contact contact) {
        if (!isValidIndex(index)) {
            return 0;
        }
        
        contacts.set(index, contact);
        writeDataToFile(contacts);
        
        return 1;
    }

    @Override
    public int delete(int index) {
        if (isValidIndex(index)) {
            contacts.remove(index);
            writeDataToFile(contacts);
            return 1;
        } else {
            return 0;
        }
    }

    
    @Override
    public List<Contact> search(String keyword) {
        List<Contact> result = new ArrayList<>();
        
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    c.getPhone().toLowerCase().contains(keyword.toLowerCase()) ||
                    c.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(c);
            }
        }
        
        return result;
    }

}
    
//	@Override
//	public List<Contact> search(String keyword) {
//		List<Contact> result = new ArrayList<>();
//		for(Contact c : contacts) {// 전화에 포함되어 있는지, 이름에 포함되어있는지, 이메일에 포함되어있는지, 검사해야
//			//연락처가 저장되어있는 contacts리스트에서 원소를 순서대로 하나하나 꺼내서
//			if(c.getName().toLowerCase().contains(keyword.toLowerCase())
//					// 연락처 원소에서 이름만 리턴받아서
//					//c.getName().toLowerCase()이름을 소문자로 바꾸겠다는 뜻 그 소문자로 바꾼 이름이
//					//contains(keyword.toLowerCase() 소문자로 바꾼 keyword검색어에 포함되어있으면 contains메서드는
//					//true를 리턴. -> 조건에 만족하면 result.add(c);실행 리스트에 그 연락처 원소를 추가
//					||c.getPhone().toLowerCase().contains(keyword.toLowerCase())||
//							c.getEmail().toLowerCase().contains(keyword.toLowerCase())) { 
//				result.add(c);
//				
//			}
//			
//		}
//		return result;
//	}

//}