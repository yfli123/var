package com.yfli.test.middle.gui.practice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUICheckPractice {
	 public static void main(String[] args) {
         
	        JFrame f = new JFrame("LoL");
	        f.setSize(800, 600);
	        f.setLocation(200, 200);
	        f.setLayout(new FlowLayout());
	        
	        
	 
	        JButton b = new JButton("检测");
	        b.setBounds(200, 50, 200, 30);
	        
	        // 输入框
	        JTextField tfName = new JTextField("");
	        //tfName.setText("请输入账号");
	        tfName.setPreferredSize(new Dimension(80, 30));
	        
	        b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String str = tfName.getText();
					if(str.equals("") || str == null) {
						/*int option = JOptionPane.showConfirmDialog(f, "是否 使用外挂 ？");
						JOptionPane.showInputDialog(f, "文档内容为空！");
						JOptionPane.showInternalInputDialog(tfName, "文档内容为空！");*/
						JOptionPane.showMessageDialog(f, "文档内容为空！");
					} else if(!isNumeric(str)) {
						JOptionPane.showMessageDialog(f, "文档内容不为整数！");
					} else {
						JOptionPane.showMessageDialog(f, str);
					}
				}
			});
	        
	        f.add(tfName);
	        f.add(b);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);
	        
	        
	        /*JOptionPane 用于弹出对话框

	        JOptionPane.showConfirmDialog(f, "是否 使用外挂 ？");
	        	表示询问，第一个参数是该对话框以哪个组件对齐
	        JOptionPane.showInputDialog(f, "请输入yes，表明使用外挂后果自负");
	        	接受用户的输入
	        JOptionPane.showMessageDialog(f, "你使用外挂被抓住！ 罚拣肥皂3次！");
	        	显示消息 */
	        
	        /*int option = JOptionPane.showConfirmDialog(f, "是否 使用外挂 ？");
	        if (JOptionPane.OK_OPTION == option) {
	            String answer = JOptionPane.showInputDialog(f, "请输入yes，表明使用外挂后果自负");
	            if ("yes".equals(answer))
	                JOptionPane.showMessageDialog(f, "你使用外挂被抓住！ 罚拣肥皂3次！");
	        }*/
	        
	    }
	 
	 	public static boolean isNumeric(String str){
		    Pattern pattern = Pattern.compile("[0-9]*");
		    return pattern.matcher(str).matches();   
		}
}
