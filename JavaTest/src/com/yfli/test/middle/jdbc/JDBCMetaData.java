package com.yfli.test.middle.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
public class JDBCMetaData {
  
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrsystem?characterEncoding=UTF-8","root", "lyf910309");) {
  
            // �鿴���ݿ�����Ԫ����
            // �����ݿ�������汾�������汾��������Щ���ݿ�ȵ�
  
            DatabaseMetaData dbmd = c.getMetaData();
  
            // ��ȡ���ݿ��������Ʒ����
            System.out.println("���ݿ��Ʒ����:\t"+dbmd.getDatabaseProductName());
            // ��ȡ���ݿ��������Ʒ�汾��
            System.out.println("���ݿ��Ʒ�汾:\t"+dbmd.getDatabaseProductVersion());
            // ��ȡ���ݿ�������������ͱ���֮��ķָ��� ��test.user
            System.out.println("���ݿ�ͱ�ָ���:\t"+dbmd.getCatalogSeparator());
            // ��ȡ�����汾
            System.out.println("�����汾:\t"+dbmd.getDriverVersion());
  
            System.out.println("���õ����ݿ��б�");
            // ��ȡ���ݿ�����
            ResultSet rs = dbmd.getCatalogs();
  
            while (rs.next()) {
                System.out.println("���ݿ�����:\t"+rs.getString(1));
            }
  
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}
