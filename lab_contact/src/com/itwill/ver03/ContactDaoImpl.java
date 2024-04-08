package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {
	// 싱글턴 디자인 패턴으로 만드는 방법
	// 1. private static field
	// 2. private constructor(생성자)
	// 3. public static method를 제공. 
	private List<Contact> contacts = new ArrayList<>();
//	private int count = 0;
	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {}
	
	public static ContactDaoImpl getInstance() {
		if(instance == null) {
			instance = new ContactDaoImpl();
			return instance;
		} else {
			return instance;
		}
	}
    @Override
    public int create(Contact contact) {
        try {
        	contacts.add(contact);
//        	count++;
        	return 1;
        } catch(Exception e) {
        	return 0;
        }
        
    }

    @Override
    public List<Contact> read() {
        
        return contacts;
    }

    @Override
    public Contact read(int index) {
        if(isValidIndex(index)) {
        	try { Contact contact = contacts.get(index);
        	return contact;
        	} catch(Exception e) {
        		System.out.println("연락처가 존재하지 않습니다.");
        	}
        }
		return null;
    }


    @Override
    public int update(int index, Contact contact) {
        if(isValidIndex(index)) {
        	contacts.set(index, contact);
        	return 1;
        	} else {
        		return 0;
        	}
    }

    @Override
    public int delete(int index) {
        try {contacts.remove(index);
        	return 1;
        } catch(Exception e) {
        	return 0;
        }
        
    }

	public boolean isValidIndex(int index) {
		
		return (index >= 0 && contacts.size() != 0 && index <= contacts.size()); 
	}

}






////package com.itwill.ver03;
////
////import java.util.ArrayList;
////
////import com.itwill.ver01.Contact;
////
////public class ContactDaoImpl implements ContactDao {
////    //----- singleton
//////    private static ContactDaoImpl instance = null;
////    
////    private ContactDaoImpl() {}
////    
//////    public static ContactDaoImpl getInstance() {
//////        if (instance == null) {
//////            instance = new ContactDaoImpl();
//////        }
//////        
//////        return instance;
//////    }
////    //----- singleton
////    private ArrayList<Integer> Contact =new ArrayList<>(); 
//////    private Contact[] contacts = new Contact[MAX_LENGTH];
////    
//////    private int count = 0;
////    
//////    public boolean isMemoryFull() {
//////        return (count == MAX_LENGTH);
//////    }
//////    
//////    public boolean isValidIndex(int index) {
//////        return (index >= 0) && (index < count);
//////    }
////    
////    
////    @Override
////    public int create(Contact contact) {
//////        if (isMemoryFull()) {
////            return 0;
//////        }
//////        
//////        contacts[count] = contact;
//////        count++;
////        
////        return 1;
////    }
////
////    @Override
////    public Contact[] read() {
////        return contacts;
////    }
////
////    @Override
////    public Contact read(int index) {
////        if (isValidIndex(index)) {
////            return contacts[index];
////        } else {
////            return null;
////        }
////    }
////
////    @Override
////    public int update(int index, Contact contact) {
////        if (isValidIndex(index) && contact != null) {
//////            contacts[index] = contact;
////            contacts[index].setName(contact.getName());
////            contacts[index].setPhone(contact.getPhone());
////            contacts[index].setEmail(contact.getEmail());
////            return 1;
////        } else {
////            return 0;
////        }
////    }
////
////	@Override
////	public int delete(int index) {
////		// TODO Auto-generated method stub
////		return 0;
////	}
////
////}
//
//
//
//
//package com.itwill.ver03;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.itwill.ver01.Contact;
//
//public class ContactDaoImpl implements ContactDao {
//
//	public ArrayList<Contact> contacts =new ArrayList<>();
//	
//	@Override
//	public int create(Contact contact) {
//		this.contacts.add(contact);
//		return 1;
//	}
//
//	@Override
//	public List<Contact> read() {
//		
//		return contacts;
//	}
//
//	@Override
//	public Contact read(int index) {
//		
//		return contacts.get(index);
//	}
//
//	@Override
//	public int update(int index, Contact contact) {
//		for(Contact c :contacts) {
//			contacts.set(index, contact);
//		}
//		return 1;
//	}
//
//	@Override
//	public int delete(int index) {
//		contacts.remove(index);
//		return 1;
//	}
//
//}
