package com.yfli.test.middle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class StreamBufferFlush {
    public static void main(String[] args) {
        //���ļ�lol2.txt��д���������
        File f =new File("C:/filetest/file/testStream.txt");
        //�����ļ��ַ���
        //���������뽨����һ�����ڵ����Ļ�����
        try(
        	FileWriter fr = new FileWriter(f);
        	PrintWriter pw = new PrintWriter(fr);
        		) {
            pw.println("garen kill teemo");
            //ǿ�ưѻ����е�����д��Ӳ�̣����ۻ����Ƿ�����
                pw.flush();           
            pw.println("teemo revive after 1 minutes");
                pw.flush();
            pw.println("teemo try to garen, but killed again");
                pw.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}