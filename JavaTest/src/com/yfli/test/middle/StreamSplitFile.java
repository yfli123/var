package com.yfli.test.middle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
  
public class StreamSplitFile {
  
    public static void main(String[] args) {
        int eachSize = 1000 * 1024; // 100k
        File srcFile = new File("C:/filetest/file/mountain.JPG");
        splitFile(srcFile, eachSize);
    }
  
    /**
     * ��ֵ�˼·���Ȱ�Դ�ļ����������ݶ�ȡ���ڴ��У�Ȼ����ڴ��а����ֵ����ļ���
     * @param srcFile Ҫ��ֵ�Դ�ļ�
     * @param eachSize ���������С�����
     */
    private static void splitFile(File srcFile, int eachSize) {
  
        if (0 == srcFile.length())
            throw new RuntimeException("�ļ�����Ϊ0�����ɲ��");
  
        byte[] fileContent = new byte[(int) srcFile.length()];
        // �Ȱ��ļ���ȡ��������
        try {
            FileInputStream fis = new FileInputStream(srcFile);
            fis.read(fileContent);
            fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // ������Ҫ�����ֳɶ��ٷ����ļ�
        int fileNumber;
        // �ļ��Ƿ��ܱ������õ������ļ������ǲ�һ����
        // (�����ļ�������25��ÿ�ݵĴ�С��5����ô��Ӧ����5��)
        // (�����ļ�������26��ÿ�ݵĴ�С��5����ô��Ӧ����6��)
        if (0 == fileContent.length % eachSize)
            fileNumber = (int) (fileContent.length / eachSize);
        else
            fileNumber = (int) (fileContent.length / eachSize) + 1;
  
        for (int i = 0; i < fileNumber; i++) {
            String eachFileName = srcFile.getName() + "-" + i;
            File eachFile = new File(srcFile.getParent(), eachFileName);
            byte[] eachContent;
  
            // ��Դ�ļ�����������Ʋ������ݵ����ļ�
            // �������һ���ļ��������ļ���С����100k
            // ���һ���ļ��Ĵ�С��ʣ���
            if (i != fileNumber - 1) // �������һ��
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, eachSize * (i + 1));
            else // ���һ��
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, fileContent.length);
  
            try {
                // д��ȥ
                FileOutputStream fos = new FileOutputStream(eachFile);
                fos.write(eachContent);
                // �ǵùر�
                fos.close();
                System.out.printf("������ļ�%s�����С�� %d�ֽ�%n", eachFile.getAbsoluteFile(), eachFile.length());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
