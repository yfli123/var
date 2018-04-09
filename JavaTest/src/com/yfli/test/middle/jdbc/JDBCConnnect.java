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
  
            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 hrsystem
            // 编码方式 UTF-8
            // 账号 root
            // 密码 lyf910309
  
            c = DriverManager
            .getConnection(
            "jdbc:mysql://127.0.0.1:3306/hrsystem?characterEncoding=UTF-8",
            "root", "lyf910309");
  
            System.out.println("连接成功，获取连接对象： " + c);
            // 注意：使用的是 java.sql.Statement
            // 不要不小心使用到： com.mysql.jdbc.Statement;
            s = c.createStatement();
  
            System.out.println("获取 Statement对象： " + s);
            
            
            // 准备sql语句
            // 注意： 字符串要用单引号'
            String sql = "insert into hero values(null,"+"'提莫'"+","+313.0f+","+50+")";
            s.execute(sql);
            
            PreparedStatement ps = c.prepareStatement(sql);
            ps.executeUpdate();
  
            System.out.println("执行插入语句成功");
            
            String sql1 = "delete from hero where id = 5";
            s.execute(sql1);
            
            System.out.println("执行删除语句成功");
            
            String sql2 = "update hero set name = 'name 5' where id = 3";
            s.execute(sql2);
            
            System.out.println("执行更新语句成功");
            
            
            String sqlSel = "select * from hero";
            
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sqlSel);
            while (rs.next()) {
                int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
            // rs.close();
            
            String name = "dashen";
            //正确的密码是：thisispassword
            String password = "thisispassword1";
   
            String sqlPass = "select * from user where name = '" + name +"' and password = '" + password+"'";
              
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs1 = s.executeQuery(sqlPass);
            
              
            if(rs1.next())
                System.out.println("账号密码正确");
            else
                System.out.println("账号密码错误");
            
            
            sql = "select count(*) from hero";
            
            rs = s.executeQuery(sql);
            int total = 0;
            while (rs.next()) {
                total = rs.getInt(1);
            }
 
            System.out.println("表Hero中总共有:" + total+" 条数据");
            list(0,5);
            list(10,5);
            
  
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            // 后关闭Connection
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
  
            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 hrsystem
            // 编码方式 UTF-8
            // 账号 root
            // 密码 lyf910309
  
            c = DriverManager
            .getConnection(
            "jdbc:mysql://127.0.0.1:3306/hrsystem?characterEncoding=UTF-8",
            "root", "lyf910309");
  
            System.out.println("连接成功，获取连接对象： " + c);
            // 注意：使用的是 java.sql.Statement
            // 不要不小心使用到： com.mysql.jdbc.Statement;
            s = c.createStatement();
  
            System.out.println("获取 Statement对象： " + s);
            
            String sqlSel = "select * from hero limit "+start+","+count;
            
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sqlSel);
            while (rs.next()) {
                int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
            // rs.close();
            
            
  
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            // 后关闭Connection
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
