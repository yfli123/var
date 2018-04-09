package com.yfli.test.middle.gui;

import java.awt.Color;
import java.awt.FlowLayout;
  
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
  
public class GUISpiltPanel {
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
        JButton b4 = new JButton("Ӣ��4");
        JButton b5 = new JButton("Ӣ��5");
        JButton b6 = new JButton("Ӣ��6");
  
        pRight.add(b4);
        pRight.add(b5);
        pRight.add(b6);
  
        pRight.setBackground(Color.BLUE);
        pRight.setBounds(10, 150, 300, 60);
  
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
