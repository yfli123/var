package com.yfli.test.middle.jdbc;

public class JDBCTest {
    public static void main(String[] args) {
           
        //��ʼ������
        try {
            //������com.mysql.jdbc.Driver
            //���� mysql-connector-java-5.1.30-bin.jar��
            //��������˵�һ������ĵ������ͻ��׳�ClassNotFoundException
            Class.forName("com.mysql.jdbc.Driver");
              
            System.out.println("���ݿ��������سɹ� ��");
   
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
    }
}
