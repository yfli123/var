package com.yfli.test.middle.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
 
public class GUIModelDialogPractice {
    public static void main(String[] args) {
        JFrame f = new JFrame("�ⲿ����");
        f.setSize(800, 600);
        f.setLocation(100, 100);
 
        JButton b = new JButton("��һ��ģ̬����");
        b.setBounds(50, 50, 280, 30);
        
        b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// �����ⲿ����ʵ����JDialog
		        JDialog d = new JDialog(f);
		        // ����Ϊģ̬
		        d.setModal(true);
		        d.setTitle("ģ̬�ĶԻ���");
		        d.setSize(400, 300);
		        d.setLocation(200, 200);
		        d.setLayout(null);
		        d.setResizable(false);
		        JButton b1 = new JButton("������С");
		        b1.setBounds(50, 50, 280, 30);
		        b1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						d.setResizable(true);
					}
				});
				
				d.add(b1);
				d.setVisible(true);
				
			}
		});
        
        f.add(b);
 
        f.setVisible(true);
 
    }
}
