package com.yfli.test.middle.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
 
public class GUIDialog {
    public static void main(String[] args) {
         
        //��ͨ�Ĵ��壬��������С����ť
        JDialog d = new JDialog();
        d.setTitle("LOL");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("һ����Է����ع�");
        b.setBounds(50, 50, 280, 30);
 
        d.add(b);
 
        d.setVisible(true);
    }
}
