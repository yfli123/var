package com.yfli.test.middle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
  
public class JDBCTranaction {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrsystem?characterEncoding=UTF-8","root", "lyf910309");
            Statement s = c.createStatement();) {
  
            // �������ǰ����
            // �������еĶ��������Ҫô���ɹ���Ҫô��ʧ��
  
            c.setAutoCommit(false);
  
            // ��Ѫ��SQL
            String sql1 = "update hero set hp = hp +1 where id = 22";
            s.execute(sql1);
  
            // ��Ѫ��SQL
            // ��С��д��д���� updata(����update)
  
            String sql2 = "updata hero set hp = hp -1 where id = 22";
            s.execute(sql2);
  
            // �ֶ��ύ
            c.commit();
  
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}
