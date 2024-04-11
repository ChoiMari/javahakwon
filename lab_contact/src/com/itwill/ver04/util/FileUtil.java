package com.itwill.ver04.util;
//Dao�ȿ� ���� ������,, �ʹ� ��� ���ϱ�.. ���⿡��..

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itwill.ver04.model.Contact;

// ����� Ŭ����(helper class) : ���� ����(read, write, ���� ����) ����� �����ϴ� Ŭ����.
// ����� Ŭ������ ��ǥ���� ��) JDK�� mathŬ����
// ���� �̷� ����� Ŭ�������� ��ü���� ���ϰ� ���ƹ���

// ��ü�� �������� ���ϵ��� �ۼ�. ��� ��� �޼���� public static����
// ��ü ���� ���� ȣ�� �����ϰ� -> public static
public class FileUtil {
	public static final String DATA_DIR = "data"; //������ ������ ������ ���� �̸�. ��� ���
	public static final String DATA_FILE = "contacts.dat"; // ������ ���� �̸�
	
	// private ������ -> �ٸ� Ŭ�������� �����ڸ� ȣ�� �� �� ����(��ü ���� �Ұ�)
	private FileUtil() {}
	
	/**
	 *  ����ó ������ ������ �����ϴ� ������ �����Ǿ� ���� ������, ������ ���� �����ϰ�
	 *  file Ÿ�� ��ü�� ����.
	 *  ������ ������ �̹� ���� �ϸ�, �� ������ File ��ü�� ����.
	 *  
	 *  @return File ��ü
	 */
	public static File initializeDataDir() { //������ ���丮�� �ʱ�ȭ �Ѵ�
		File file = new File(DATA_DIR, DATA_FILE);
		
		if(file.exists()) { // ������ �̹� �ִ� ���
			System.out.println("������ ������ �̹� �ֽ��ϴ�...");
		} else { // ������ ���� ���
			file.mkdir();
			System.out.println("������ ���� ���� ����");
		}
		return file;
	}
	
	/**
	 * ����ó ����Ʈ�� ����� ������ ������ �а�, �� ����� List Ÿ������ ����.
	 * 
	 * @return ����ó ����Ʈ(List<Contact>)
	 */ 
	public static List<Contact> readDataFromFile(){
		List<Contact> list = null;
		File file = new File(DATA_DIR, DATA_FILE);
		try( 
				FileInputStream in = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(in);
				ObjectInputStream ois = new ObjectInputStream(bis);
		){
			list = (List<Contact>) ois.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	} 
	
	/**
	 * ����ó ����Ʈ�� ���Ͽ� ����.
	 * 
	 * @param list ����ó �����͸� �����ϴ� ����Ʈ(List<Contact>). //������ 
	 * 
	 */
	public static void writeDataToFile(List<Contact> list) {
		File file = new File(DATA_DIR, DATA_FILE);
		try(
				FileOutputStream out = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
		){
			oos.writeObject(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����ó ������ �ִ� �����ϸ�, ������ ������ �о ����Ʈ�� ����
	 * ����ó ������ ������, �� ����Ʈ(���Ұ� �ϳ��� ����) ����Ʈ�� ����
	 * 
	 * @param ����ó ����Ʈ(List<Contact>)
	 */
	 public static List<Contact> initializeData() {
	        List<Contact> list = new ArrayList<>();
	        
	        File file = new File(DATA_DIR, DATA_FILE);
	        if (file.exists()) {
	            list = readDataFromFile();
	        }
	        
	        return list;
	    }
	
}
