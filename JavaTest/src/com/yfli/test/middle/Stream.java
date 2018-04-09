package com.yfli.test.middle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class Stream {
 
    public static void main(String[] args) {
        try {
            File f = new File("C:/filetest/file/testStream.txt");
            // ���������ļ���������
            FileInputStream fis = new FileInputStream(f);
            byte[] all = new byte[(int)f.length()];
            fis.read(all);
            for(byte b : all) {
            	System.out.println(b);
            }
            
            byte[] b = {90,80};
            // ͨ��������������Ϳ��԰����ݴ�Ӳ�̣���ȡ��Java�������������Ҳ���Ƕ�ȡ���ڴ���
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(b); 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
}
