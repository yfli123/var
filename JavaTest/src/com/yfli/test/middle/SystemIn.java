package com.yfli.test.middle;

import java.io.IOException;
import java.io.InputStream;
 
public class SystemIn {
 
    public static void main(String[] args) {
        // ����̨����
        try (InputStream is = System.in;) {
            while (true) {
                // ����a,Ȼ���ûس����Կ���
                // 97 13 10
                // 97��a��ASCII��
                // 13 10�ֱ��Ӧ�س�����
                int i = is.read();
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}