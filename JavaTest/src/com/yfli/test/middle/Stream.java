package com.yfli.test.middle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class Stream {
 
    public static void main(String[] args) {
        try {
            File f = new File("C:/filetest/file/testStream.txt");
            // 创建基于文件的输入流
            FileInputStream fis = new FileInputStream(f);
            byte[] all = new byte[(int)f.length()];
            fis.read(all);
            for(byte b : all) {
            	System.out.println(b);
            }
            
            byte[] b = {90,80};
            // 通过这个输入流，就可以把数据从硬盘，读取到Java的虚拟机中来，也就是读取到内存中
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(b); 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
}
