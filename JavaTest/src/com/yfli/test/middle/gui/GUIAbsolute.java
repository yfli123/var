package com.yfli.test.middle.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
 
public class GUIAbsolute {
    public static void main(String[] args) {
 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // ���ò�����Ϊnull�������о��Զ�λ�������ϵ��������Ҫָ��λ�úʹ�С
        f.setLayout(null);
        JButton b1 = new JButton("Ӣ��1");
        // ָ��λ�úʹ�С
        b1.setBounds(50, 50, 80, 30);
        JButton b2 = new JButton("Ӣ��2");
        b2.setBounds(150, 50, 80, 30);
        JButton b3 = new JButton("Ӣ��3");
        b3.setBounds(250, 50, 80, 30);
        // û��ָ��λ�úʹ�С�����������������
        JButton b4 = new JButton("Ӣ��3");
 
        f.add(b1);
        f.add(b2);
        f.add(b3);
        // b4û��ָ��λ�úʹ�С�����������������
        f.add(b4);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}
