package com.yfli.test.middle;

import java.io.File;
import java.io.IOException;
  
public class File1 {
  
    public static void main(String[] args) throws IOException {
  
        File f = new File("C:/filetest/file/filetest.docx");
  
        // ���ַ����������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
        f.list();
  
        // ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
        File[]fs= f.listFiles();
  
        // ���ַ�����ʽ���ػ�ȡ�����ļ���
        f.getParent();
  
        // ���ļ���ʽ���ػ�ȡ�����ļ���
        f.getParentFile();
        // �����ļ��У�������ļ���skin�����ڣ���������Ч
        f.mkdir();
  
        // �����ļ��У�������ļ���skin�����ڣ��ͻᴴ�����ļ���
        f.mkdirs();
  
        // ����һ�����ļ�,������ļ���skin�����ڣ��ͻ��׳��쳣
        f.createNewFile();
        // ���Դ���һ�����ļ�֮ǰ��ͨ�����ᴴ����Ŀ¼
        f.getParentFile().mkdirs();
  
        // �г����е��̷�c: d: e: �ȵ�
        f.listRoots();
  
        // �h���ļ�
        f.delete();
  
        // JVM������ʱ�򣬄h���ļ�����������ʱ�ļ���ɾ��
        f.deleteOnExit();
  
    }
}
