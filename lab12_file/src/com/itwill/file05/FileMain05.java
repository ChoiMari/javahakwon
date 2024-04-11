package com.itwill.file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.file04.Product;

public class FileMain05 {

    public static void main(String[] args) {
        // 파일에 쓸(write) 더미 데이터
        ArrayList<Product> list  = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(new Product(i, "name_" + i, i));
        }
        System.out.println("dummy size = " + list.size());
        
        // ArrayList를 저장하는 파일 이름
        String fileName = "data/product_list.dat";
        
        // 1. Product 타입 객체 1,000,000개를 저장하는 ArrayList를 파일 쓰기
        // FOS, BOS, OOS을 이용.
        try ( // 예외가 발생하더라도 자동으로 close 해준다
                FileOutputStream out = new FileOutputStream(fileName);
                BufferedOutputStream bos = new BufferedOutputStream(out);
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                // 가장 마지막에 만들어진 stream을 호출하면 됨. oos
                // close()도 마찬가지 oos를 닫으면 된다(생성된 순서의 반대로 close();
                // 가장 마지막 객체를 닫으면 아규먼트로 사용된 것도 자동으로 close();된다고 함
        ) {
            long start = System.currentTimeMillis();
            
            oos.writeObject(list); //백 만개 저장되있는 list 저장
            
            long end = System.currentTimeMillis();
            
            System.out.println("파일 쓰기 시간: " + (end - start) + "ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 2. 파일에서 객체를 읽어서 ArrayList<Product>로 변환하기
        // FIS, BIS, OIS을 이용.
        try ( //최종적으로 읽는 건 Object여서 ObjectInputStream을 가장 마지막에 생성.
        //파일에서 읽는 거니까 FileInputStream을 가장 먼저 생성하기
                FileInputStream in = new FileInputStream(fileName);
                BufferedInputStream bis = new BufferedInputStream(in);
                ObjectInputStream ois = new ObjectInputStream(bis);
        ) {
            long start = System.currentTimeMillis();
            
            ArrayList<Product> products = (ArrayList<Product>) ois.readObject();
            // 읽어들인 객체를 ArrayList<Product>로 강제 변환. casting.
            long end = System.currentTimeMillis(); //read끝났을 때 시간 측정.
            
            //정상적으로 읽은 것이 맞는지 확인하기 위한 코드
            System.out.println("파일 읽기 시간: " + (end - start) + "ms");
            System.out.println("size = " + products.size());
            System.out.println(products.getFirst()); //자바 버전21에서 처음 생겼다고 함.
            //옛날 버전에서는 // products.get(0) 가장 처음 원소 찾기
            System.out.println(products.getLast());
            // products.get(products.size()-1) 가장 마지막 원소 찾기
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}