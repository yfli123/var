package com.yfli.test.middle.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 
public class GUIScrollPanel {
    public static void main(String[] args) {
 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
 
        f.setLayout(null);
        //׼��һ���ı���������źܶ�����
        JTextArea ta = new JTextArea();
        for (int i = 0; i < 1000; i++) {
            ta.append(String.valueOf(i));
        }
        //�Զ�����
        ta.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta);
 
        f.setContentPane(sp);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}
