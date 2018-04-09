package com.yfli.test.middle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
   
public class JDBCKeyIncrease {
   
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrsystem?characterEncoding=UTF-8","root", "lyf910309");
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);          
                ) {
  
            ps.setString(1, "盖伦");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);
   
            // 执行插入语句
            ps.execute();
   
            // 在执行完插入语句后，MySQL会为新插入的数据分配一个自增长id
            // JDBC通过getGeneratedKeys获取该id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println(id);
            }
   
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   
    }
}
