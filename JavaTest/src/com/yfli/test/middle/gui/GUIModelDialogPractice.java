package com.yfli.test.middle.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
 
public class GUIModelDialogPractice {
    public static void main(String[] args) {
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(100, 100);
 
        JButton b = new JButton("打开一个模态窗口");
        b.setBounds(50, 50, 280, 30);
        
        b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 根据外部窗体实例化JDialog
		        JDialog d = new JDialog(f);
		        // 设置为模态
		        d.setModal(true);
		        d.setTitle("模态的对话框");
		        d.setSize(400, 300);
		        d.setLocation(200, 200);
		        d.setLayout(null);
		        d.setResizable(false);
		        JButton b1 = new JButton("解锁大小");
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
