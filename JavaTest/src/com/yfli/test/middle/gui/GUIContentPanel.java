package com.yfli.test.middle.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
 
public class GUIContentPanel {
    public static void main(String[] args) {
 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        JButton b = new JButton("һ����Է����ع�");
        b.setBounds(50, 50, 280, 30);
 
        f.add(b);
        // JFrame����һ����壬����ContentPane
        // ƽʱͨ��f.add()��JFrame�����������ʵ����JFrame�ϵ� ContentPane�Ӷ���
        // f.add��ͬ��f.getContentPane().add(b);
        f.getContentPane().add(b);
 
        // b.getParent()��ȡ��ťb�����ڵ�����
        // ��ӡ�������Կ�����ʵ������ContentPane����JFrame
        System.out.println(b.getParent());
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}
