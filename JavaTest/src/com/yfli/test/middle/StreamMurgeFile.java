package com.yfli.test.middle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import javax.security.auth.DestroyFailedException;
 
public class StreamMurgeFile {
 
    public static void main(String[] args) {
        murgeFile("C:/filetest/file", "mountain.JPG");
    }
 
    /**
     * �ϲ���˼·�����Ǵ�eclipse.exe-0��ʼ����ȡ��һ���ļ����Ϳ�ʼд���� eclipse.exe�У�ֱ��û���ļ����Զ�
     * @param folder
     *            ��Ҫ�ϲ����ļ������ڵ�Ŀ¼
     * @param fileName
     *            ��Ҫ�ϲ����ļ�������
     * @throws FileNotFoundException
     */
    private static void murgeFile(String folder, String fileName) {
 
        try {
            // �ϲ���Ŀ���ļ�
            File destFile = new File(folder, fileName);
            FileOutputStream fos = new FileOutputStream(destFile);
            int index = 0;
            while (true) {
                //���ļ�
                File eachFile = new File(folder, fileName + "-" + index++);
                //������ļ��������˾ͽ���
                if (!eachFile.exists())
                    break;
 
                //��ȡ���ļ�������
                FileInputStream fis = new FileInputStream(eachFile);
                byte[] eachContent = new byte[(int) eachFile.length()];
                fis.read(eachContent);
                fis.close();
                 
                //�����ļ�������д��ȥ
                fos.write(eachContent);
                fos.flush();
                System.out.printf("�����ļ� %sд����Ŀ���ļ���%n",eachFile);
            }
 
            fos.close();
            System.out.printf("���Ŀ���ļ��Ĵ�С��%,d�ֽ�" , destFile.length());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
 
}