package com.yfli.test.middle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
public class JDBCConnnect {
    public static void main(String[] args) {
    	Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
  
            // ���������ݿ��Connection����
            // ������Ҫ�ṩ��
            // ���ݿ������ڵ�ip:127.0.0.1 (����)
            // ���ݿ�Ķ˿ںţ� 3306 ��mysqlר�ö˿ںţ�
            // ���ݿ����� hrsystem
            // ���뷽ʽ UTF-8
            // �˺� root
            // ���� lyf910309
  
            c = DriverManager
            .getConnection(
            "jdbc:mysql://127.0.0.1:3306/hrsystem?characterEncoding=UTF-8",
            "root", "lyf910309");
  
            System.out.println("���ӳɹ�����ȡ���Ӷ��� " + c);
            // ע�⣺ʹ�õ��� java.sql.Statement
            // ��Ҫ��С��ʹ�õ��� com.mysql.jdbc.Statement;
            s = c.createStatement();
  
            System.out.println("��ȡ Statement���� " + s);
            
            
            // ׼��sql���
            // ע�⣺ �ַ���Ҫ�õ�����'
            String sql = "insert into hero values(null,"+"'��Ī'"+","+313.0f+","+50+")";
            s.execute(sql);
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.executeUpdate();
  
            System.out.println("ִ�в������ɹ�");
            
            String sql1 = "delete from hero where id = 5";
            s.execute(sql1);
            
            System.out.println("ִ��ɾ�����ɹ�");
            
            String sql2 = "update hero set name = 'name 5' where id = 3";
            s.execute(sql2);
            
            System.out.println("ִ�и������ɹ�");
            
            
            String sqlSel = "select * from hero";
            
            // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
            ResultSet rs = s.executeQuery(sqlSel);
            while (rs.next()) {
                int id = rs.getInt("id");// ����ʹ���ֶ���
                String name = rs.getString(2);// Ҳ����ʹ���ֶε�˳��
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            // ��һ��Ҫ������ر�ReultSet����ΪStatement�رյ�ʱ�򣬻��Զ��ر�ResultSet
            // rs.close();
            
            String name = "dashen";
            //��ȷ�������ǣ�thisispassword
            String password = "thisispassword1";
   
            String sqlPass = "select * from user where name = '" + name +"' and password = '" + password+"'";
              
            // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
            ResultSet rs1 = s.executeQuery(sqlPass);
            
              
            if(rs1.next())
                System.out.println("�˺�������ȷ");
            else
                System.out.println("�˺��������");
            
            
            sql = "select count(*) from hero";
            
            rs = s.executeQuery(sql);
            int total = 0;
            while (rs.next()) {
                total = rs.getInt(1);
            }
 
            System.out.println("��Hero���ܹ���:" + total+" ������");
            list(0,5);
            list(10,5);
            
  
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            // ���ݿ������ʱ������Դ����ز������������ɹر����ݿ�ĺ�ϰ��
            // �ȹر�Statement
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            // ��ر�Connection
            if (c != null)
                try {
                    c.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
 
        }
  
    }
    
    
    public static void list(int start,int count) {
    	Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
  
            // ���������ݿ��Connection����
            // ������Ҫ�ṩ��
            // ���ݿ������ڵ�ip:127.0.0.1 (����)
            // ���ݿ�Ķ˿ںţ� 3306 ��mysqlר�ö˿ںţ�
            // ���ݿ����� hrsystem
            // ���뷽ʽ UTF-8
            // �˺� root
            // ���� lyf910309
  
            c = DriverManager
            .getConnection(
            "jdbc:mysql://127.0.0.1:3306/hrsystem?characterEncoding=UTF-8",
            "root", "lyf910309");
  
            System.out.println("���ӳɹ�����ȡ���Ӷ��� " + c);
            // ע�⣺ʹ�õ��� java.sql.Statement
            // ��Ҫ��С��ʹ�õ��� com.mysql.jdbc.Statement;
            s = c.createStatement();
  
            System.out.println("��ȡ Statement���� " + s);
            
            String sqlSel = "select * from hero limit "+start+","+count;
            
            // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
            ResultSet rs = s.executeQuery(sqlSel);
            while (rs.next()) {
                int id = rs.getInt("id");// ����ʹ���ֶ���
                String name = rs.getString(2);// Ҳ����ʹ���ֶε�˳��
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            // ��һ��Ҫ������ر�ReultSet����ΪStatement�رյ�ʱ�򣬻��Զ��ر�ResultSet
            // rs.close();
            
            
  
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            // ���ݿ������ʱ������Դ����ز������������ɹر����ݿ�ĺ�ϰ��
            // �ȹر�Statement
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            // ��ر�Connection
            if (c != null)
                try {
                    c.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
 
        }
    }
}
