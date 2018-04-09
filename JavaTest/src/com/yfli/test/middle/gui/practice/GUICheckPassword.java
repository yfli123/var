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
	        
	        
	 
	        JLabel lName = new JLabel("�˺ţ�");
	        // �����
	        JTextField tfName = new JTextField("dashen");
	        tfName.setPreferredSize(new Dimension(80, 30));
	 
	        JLabel lPassword = new JLabel("���룺");
	        // �����
	        JPasswordField tfPassword = new JPasswordField("thisispassword");
	        //JTextField tfPassword = new JTextField("thisispassword");
	        tfPassword.setPreferredSize(new Dimension(80, 30));
	        
	        JButton b = new JButton("��½");
	        b.setBounds(200, 50, 200, 30);
	        
	        b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String strName = tfName.getText();
					String strPassword = tfPassword.getText();
					if(strName.equals("") || strName == null || strPassword.equals("") || strPassword == null) {
						JOptionPane.showMessageDialog(f, "�������û��������룡");
					} else if(!checkPassword(strName,strPassword)) {
						JOptionPane.showMessageDialog(f, "�û������������");
					} else {
						JOptionPane.showMessageDialog(f, "��½�ɹ���");
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
	 
			String sqlPass = "select * from user where name = '" + name +"' and password = '" + password+"'";
	        System.out.println(sqlPass);
	        // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
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
            // ���ݿ������ʱ������Դ����ز������������ɹر����ݿ�ĺ�ϰ��
            // �ȹر�Statement
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // ��ر�Connection
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

