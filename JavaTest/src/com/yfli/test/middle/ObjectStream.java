package com.yfli.test.middle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
  
    
public class ObjectStream {
    
    public static void main(String[] args) {
        //����һ��Hero garen
        //Ҫ��Hero����ֱ�ӱ������ļ��ϣ������Hero��ʵ��Serializable�ӿ�
        Hero h = new Hero();
        h.name = "garen";
        h.hp = 616;
          
        //׼��һ���ļ����ڱ���ö���
        File f =new File("C:/filetest/file/testStream.txt");
 
        try(
            //�������������
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            //��������������              
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois =new ObjectInputStream(fis);
        ) {
            oos.writeObject(h);
            Hero h2 = (Hero) ois.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
               
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    }
}