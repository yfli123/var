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
	        
	        
	 
	        JButton b = new JButton("���");
	        b.setBounds(200, 50, 200, 30);
	        
	        // �����
	        JTextField tfName = new JTextField("");
	        //tfName.setText("�������˺�");
	        tfName.setPreferredSize(new Dimension(80, 30));
	        
	        b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String str = tfName.getText();
					if(str.equals("") || str == null) {
						/*int option = JOptionPane.showConfirmDialog(f, "�Ƿ� ʹ����� ��");
						JOptionPane.showInputDialog(f, "�ĵ�����Ϊ�գ�");
						JOptionPane.showInternalInputDialog(tfName, "�ĵ�����Ϊ�գ�");*/
						JOptionPane.showMessageDialog(f, "�ĵ�����Ϊ�գ�");
					} else if(!isNumeric(str)) {
						JOptionPane.showMessageDialog(f, "�ĵ����ݲ�Ϊ������");
					} else {
						JOptionPane.showMessageDialog(f, str);
					}
				}
			});
	        
	        f.add(tfName);
	        f.add(b);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);
	        
	        
	        /*JOptionPane ���ڵ����Ի���

	        JOptionPane.showConfirmDialog(f, "�Ƿ� ʹ����� ��");
	        	��ʾѯ�ʣ���һ�������ǸöԻ������ĸ��������
	        JOptionPane.showInputDialog(f, "������yes������ʹ����Һ���Ը�");
	        	�����û�������
	        JOptionPane.showMessageDialog(f, "��ʹ����ұ�ץס�� �������3�Σ�");
	        	��ʾ��Ϣ */
	        
	        /*int option = JOptionPane.showConfirmDialog(f, "�Ƿ� ʹ����� ��");
	        if (JOptionPane.OK_OPTION == option) {
	            String answer = JOptionPane.showInputDialog(f, "������yes������ʹ����Һ���Ը�");
	            if ("yes".equals(answer))
	                JOptionPane.showMessageDialog(f, "��ʹ����ұ�ץס�� �������3�Σ�");
	        }*/
	        
	    }
	 
	 	public static boolean isNumeric(String str){
		    Pattern pattern = Pattern.compile("[0-9]*");
		    return pattern.matcher(str).matches();   
		}
}
