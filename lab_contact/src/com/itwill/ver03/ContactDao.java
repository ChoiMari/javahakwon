package com.itwill.ver03; // ���� �ٿ��ֱ� �ϸ� ��Ű�� ���� �ٲپ� �ش�.

import java.util.List;

import com.itwill.ver01.Contact; // Model

// Controller �������̽�
public interface ContactDao {
    
    int MAX_LENGTH = 3;
    
    /**
     * ���ο� ����ó ����(�̸�, ��ȭ��ȣ, �̸���)�� ����Ʈ�� ����.
     * 
     * @param contact ����Ʈ�� ������ Contact Ÿ�� ��ü.
     * @return ����Ʈ�� ����ó ������ ���������� 1, ���� �����ϸ� 0.
     */
    int create(Contact contact);
    
    /**
     * ����ó ��ü ��� �˻�. ��� ����ó ������ ����� ����Ʈ�� ����.
     * 
     * @return Contact Ÿ���� �����ϴ� ����Ʈ
     */
    List<Contact> read();
    
    /**
     * �ε����� ����� ����ó ���� �˻� ���.
     * 
     * @param index ����Ʈ���� ����ó ������ �˻��� �ε���. 0 �̻��� ����(int).
     * @return �ƱԸ�Ʈ index�� ����Ʈ�� �ε��� ���� �ȿ� ������ Contact Ÿ�� ��ü�� ����.
     * index�� ����Ʈ ���� �ۿ� �ְų�, �ش� �ε��� ����Ʈ ���Ұ� null�̸� null�� ����.
     */
    Contact read(int index);
    
    /**
     * ����ó ���� ������Ʈ ���.
     * ����Ʈ�� Ư�� �ε����� ����ó ����(�̸�, ��ȭ��ȣ, �̸���)�� ������Ʈ.
     * 
     * @param index ������ ����ó�� ����Ʈ �ε���. 0 �̻��� ����.
     * @param contact ������Ʈ�� �̸�, ��ȭ��ȣ, �̸����� �����ϰ� �ִ� Contact Ÿ�� ��ü.
     * @return ������Ʈ �����ϸ� 1, �����ϸ� 0.
     */
    int update(int index, Contact contact);

    /**
     * ����ó ���� ���.
     * @pram index ����Ʈ���� ������ ����ó�� �ε���. 0�̻��� ����.
     * @return ���� �����ϸ� 1, ���� �ϸ� 0
     */
    int delete(int index);
    
}