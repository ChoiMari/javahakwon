package com.itwill.ver05.controller;

import static com.itwill.ver05.util.FileUtil.*;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver05.model.Contact;
//import com.itwill.ver05.util.FileUtil;

// MVC ��Ű���Ŀ��� Controller ���� ��� Ŭ����. DAO(Data Access Object).
public class ContactDaoImpl implements ContactDao {
    //----- singleton
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {
        // ������ ���� �ʱ�ȭ: ������ ������ ���� ����.
        initializeDataDir();
        
        // ����ó ������ �ʱ�ȭ: ������ ���Ͽ��� ����Ʈ�� �о���ų�, �� ����Ʈ�� ����.
        contacts = initializeData();
    }
    
    public static ContactDaoImpl getInstance() { // getInstance()�޼���� ����� ȣ�� �ϵ� 
    	// ó�� if{}�� ����Ǽ� ����ƴ� ContactDaoImpl()��ü�� ������ �ּҸ� ȣ����.
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }
    //----- singleton
    
    private List<Contact> contacts;
    
    /**
     * �ε����� ����ó ����Ʈ�� ��ȿ�� ���� �ȿ� �ִ� ���� ����.
     * @param index �˻��� �ε���.
     * @return ��ȿ�� �ε����̸� true, �׷��� ������ false.
     */
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < contacts.size());
    }

    @Override
    public int create(Contact contact) {
        contacts.add(contact); // ����Ʈ(�޸�)�� �߰�.
        writeDataToFile(contacts); // ���Ͽ� ��.
        
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
//		for(Contact c : contacts) {// ��ȭ�� ���ԵǾ� �ִ���, �̸��� ���ԵǾ��ִ���, �̸��Ͽ� ���ԵǾ��ִ���, �˻��ؾ�
//			//����ó�� ����Ǿ��ִ� contacts����Ʈ���� ���Ҹ� ������� �ϳ��ϳ� ������
//			if(c.getName().toLowerCase().contains(keyword.toLowerCase())
//					// ����ó ���ҿ��� �̸��� ���Ϲ޾Ƽ�
//					//c.getName().toLowerCase()�̸��� �ҹ��ڷ� �ٲٰڴٴ� �� �� �ҹ��ڷ� �ٲ� �̸���
//					//contains(keyword.toLowerCase() �ҹ��ڷ� �ٲ� keyword�˻�� ���ԵǾ������� contains�޼����
//					//true�� ����. -> ���ǿ� �����ϸ� result.add(c);���� ����Ʈ�� �� ����ó ���Ҹ� �߰�
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