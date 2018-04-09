package com.yfli.test.middle.gui.practice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUICheckPassword {
	 public static void main(String[] args) {
         
	        JFrame f = new JFrame("LoL");
	        f.setSize(800, 600);
	        f.setLocation(200, 200);
	        f.setLayout(new FlowLayout());
	        
	        
	 
	        JLabel lName = new JLabel("账号：");
	        // 输入框
	        JTextField tfName = new JTextField("dashen");
	        tfName.setPreferredSize(new Dimension(80, 30));
	 
	        JLabel lPassword = new JLabel("密码：");
	        // 输入框
	        JPasswordField tfPassword = new JPasswordField("thisispassword");
	        //JTextField tfPassword = new JTextField("thisispassword");
	        tfPassword.setPreferredSize(new Dimension(80, 30));
	        
	        JButton b = new JButton("登陆");
	        b.setBounds(200, 50, 200, 30);
	        
	        b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String strName = tfName.getText();
					String strPassword = tfPassword.getText();
					if(strName.equals("") || strName == null || strPassword.equals("") || strPassword == null) {
						JOptionPane.showMessageDialog(f, "请输入用户名和密码！");
					} else if(!checkPassword(strName,strPassword)) {
						JOptionPane.showMessageDialog(f, "用户名或密码错误！");
					} else {
						JOptionPane.showMessageDialog(f, "登陆成功！");
					}
				}
			});
	        f.add(lName);
	        f.add(tfName);
	        f.add(lPassword);
	        f.add(tfPassword);
	        f.add(b);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);
	        
	    }
	 
	 	public static boolean isNumeric(String str){
		    Pattern pattern = Pattern.compile("[0-9]*");
		    return pattern.matcher(str).matches();   
		}
	 	
	 @SuppressWarnings("finally")
	public static boolean checkPassword(String name,String password){
		 
		Connection c = null;
        Statement s = null;
        Boolean flag = false;
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
	 
			String sqlPass = "select * from user where name = '" + name +"' and password = '" + password+"'";
	        System.out.println(sqlPass);
	        // 执行查询语句，并把结果集返回给ResultSet
	        ResultSet rs1 = s.executeQuery(sqlPass);
	           
	        if(rs1.next())
	            flag = true;
	        else
	        	flag = false;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
        	flag = false;
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	flag = false;
            e.printStackTrace();
        }finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // 后关闭Connection
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return flag;
 
        }
	}
}

