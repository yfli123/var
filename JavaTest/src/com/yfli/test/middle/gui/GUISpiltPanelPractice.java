package com.yfli.test.middle.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
  
public class GUISpiltPanelPractice {
    public static void main(String[] args) {
  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
  
        f.setLayout(null);
  
        JPanel pLeft = new JPanel();
        pLeft.setBounds(50, 50, 300, 60);
  
        pLeft.setBackground(Color.RED);
  
        pLeft.setLayout(new FlowLayout());
  
        JButton b1 = new JButton("����");
        JButton b2 = new JButton("��Ī");
        JButton b3 = new JButton("����");
  
        pLeft.add(b1);
        pLeft.add(b2);
        pLeft.add(b3);
  
        JPanel pRight = new JPanel();
        
        JLabel l1 = new JLabel();
        //����ͼƬ����ImageIcon����
        ImageIcon i = new ImageIcon("C:/filetest/file/gareen.jpg");
        //����ImageIcon
        l1.setIcon(i);
        //label�Ĵ�С����ΪImageIcon,������ʾ������
        l1.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
        pRight.add(l1);
        pRight.setBounds(10, 150, 300, 60);
        
        b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ImageIcon i = new ImageIcon("C:/filetest/file/gareen.jpg");
		        //����ImageIcon
		        l1.setIcon(i);
		        //label�Ĵ�С����ΪImageIcon,������ʾ������
		        //l1.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		        //pRight.add(l1);
		        //pRight.setBounds(10, 150, 300, 60);
			}
		});
        
        
        b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ImageIcon i = new ImageIcon("C:/filetest/file/teemo.jpg");
		        //����ImageIcon
		        l1.setIcon(i);
		        //label�Ĵ�С����ΪImageIcon,������ʾ������
		        //l1.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		        //pRight.add(l1);
		       // pRight.setBounds(10, 150, 300, 60);
			}
		});

		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ImageIcon i = new ImageIcon("C:/filetest/file/annie.jpg");
		        //����ImageIcon
		        l1.setIcon(i);
		        //label�Ĵ�С����ΪImageIcon,������ʾ������
		        //l1.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		        //pRight.add(l1);
		        //pRight.setBounds(10, 150, 300, 60);
			}
		});

       
  
        // ����һ��ˮƽJSplitPane�������p1,�ұ���p2
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pLeft, pRight);
        // ���÷ָ�����λ��
        sp.setDividerLocation(80);
  
        // ��sp����ContentPane
        f.setContentPane(sp);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
}

