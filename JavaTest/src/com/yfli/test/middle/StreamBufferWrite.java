package com.yfli.test.middle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
   
public class StreamBufferWrite {
   
    public static void main(String[] args) {
        // ���ļ�lol2.txt��д���������
        File f = new File("C:/filetest/file/testStream.txt");
          
        try (
                // �����ļ��ַ���
                FileWriter fw = new FileWriter(f);
                // ���������뽨����һ�����ڵ����Ļ�����              
                PrintWriter pw = new PrintWriter(fw);              
        ) {
            pw.println("garen kill teemo");
            pw.println("teemo revive after 1 minutes");
            pw.println("teemo try to garen, but killed again");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
    }
}
