package com.yfli.test.middle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
public class JDBCPrepareStatement1 {
    public static void main(String[] args) {
  
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
  
        String sql = "select * from hero where name = ?";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrsystem?characterEncoding=UTF-8","root", "lyf910309");
                Statement s = c.createStatement();
            PreparedStatement ps = c.prepareStatement(sql);
        ) {
            // ����name���û��ύ��������
            String name = "'����' OR 1=1";
            String sql0 = "select * from hero where name = " + name;
            // ƴ�ӳ�����SQL������
            // select * from hero where name = '����' OR 1=1
            // ��Ϊ��OR 1=1�����Ժ����
            // ��ô�ͻ�����е�Ӣ�۶������������ֻ�Ǹ���
            // ���Hero���������ʱ�����ģ����缸����������������������ȫ�������
            // �������ݿ⸺�ر�ߣ�CPU100%���ڴ����Ĺ⣬��Ӧ��ü��仺��
            System.out.println(sql0);
  
            ResultSet rs0 = s.executeQuery(sql0);
            while (rs0.next()) {
                String heroName = rs0.getString("name");
                System.out.println(heroName);
            }
  
            s.execute(sql0);
  
            // ʹ��Ԥ����Statement�Ϳ��Զž�SQLע��
  
            ps.setString(1, name);
  
            ResultSet rs = ps.executeQuery();
            // �鲻�����ݳ���
            while (rs.next()) {
                String heroName = rs.getString("name");
                System.out.println(heroName);
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}