package com.yfli.test.middle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
      
public class DataStream {
      
    public static void main(String[] args) {
        write();
        read();
    }
 
    private static void read() {
        File f =new File("C:/filetest/file/testStream.txt");
        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
        ){
            boolean b= dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();
            String str1 = dis.readUTF();
            
             
            System.out.println("读取到布尔值:"+b);
            System.out.println("读取到整数:"+i);
            System.out.println("读取到字符串:"+str);
            System.out.println("读取到字符串:"+str1);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
 
    private static void write() {
        File f =new File("C:/filetest/file/testStream.txt");
        try (
                FileOutputStream fos  = new FileOutputStream(f);
                DataOutputStream dos =new DataOutputStream(fos);
        ){
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
            dos.writeUTF("123 this is gareen1");
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
}
