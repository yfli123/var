package com.yfli.test.middle.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
 
public class GUIModelDialog {
    public static void main(String[] args) {
        JFrame f = new JFrame("�ⲿ����");
        f.setSize(800, 600);
        f.setLocation(100, 100);
 
        // �����ⲿ����ʵ����JDialog
        JDialog d = new JDialog(f);
        // ����Ϊģ̬
        d.setModal(true);
 
        d.setTitle("ģ̬�ĶԻ���");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("һ����Է����ع�");
        b.setBounds(50, 50, 280, 30);
        d.add(b);
 
        f.setVisible(true);
        d.setVisible(true);
 
    }
}
