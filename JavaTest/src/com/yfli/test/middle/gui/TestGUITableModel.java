package com.yfli.test.middle.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
  
public class TestGUITableModel {
    public static void main(String[] args) {
  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        //����һ��TableModel
        GUITableModel htm= new GUITableModel();
         
        //���� TableModel������ Table
        JTable t = new JTable(htm);
  
        JScrollPane sp = new JScrollPane(t);
  
        f.add(sp, BorderLayout.CENTER);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
}
