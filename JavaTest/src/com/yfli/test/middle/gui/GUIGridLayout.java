package com.yfli.test.middle.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class GUIGridLayout {
    public static void main(String[] args) {
 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        JPanel middlePanel = new JPanel();
        middlePanel.setBounds(3, 3, 300, 225);
        
        // 设置布局器为GridLayerout，即网格布局器
        // 该GridLayerout的构造方法表示该网格是2行3列
        middlePanel.setLayout(new GridLayout(4, 5 ,3 ,3));
        
        JButton b1 = new JButton("7");
        JButton b2 = new JButton("8");
        JButton b3 = new JButton("9");
        JButton b4 = new JButton("/");
        JButton b5 = new JButton("sq");
        
        JButton b6 = new JButton("4");
        JButton b7 = new JButton("5");
        JButton b8 = new JButton("6");
        JButton b9 = new JButton("*");
        JButton b10 = new JButton("%");
        
        JButton b11 = new JButton("1");
        JButton b12 = new JButton("2");
        JButton b13 = new JButton("3");
        JButton b14 = new JButton("-");
        JButton b15 = new JButton("1/x");
        
        JButton b16 = new JButton("0");
        JButton b17 = new JButton("+/-");
        JButton b18 = new JButton(".");
        JButton b19 = new JButton("+");
        JButton b20 = new JButton("=");
 
        middlePanel.add(b1);
        middlePanel.add(b2);
        middlePanel.add(b3);
        middlePanel.add(b4);
        middlePanel.add(b5);
        
        middlePanel.add(b6);
        middlePanel.add(b7);
        middlePanel.add(b8);
        middlePanel.add(b9);
        middlePanel.add(b10);
        
        middlePanel.add(b11);
        middlePanel.add(b12);
        middlePanel.add(b13);
        middlePanel.add(b14);
        middlePanel.add(b15);
        
        middlePanel.add(b16);
        middlePanel.add(b17);
        middlePanel.add(b18);
        middlePanel.add(b19);
        middlePanel.add(b20);
 
        /*JButton b1 = new JButton("洪七");
        JButton b2 = new JButton("段智兴");
        JButton b3 = new JButton("欧阳锋");
        JButton b4 = new JButton("黄药师");
        JButton b5 = new JButton("周伯通");
 
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);*/
        f.add(middlePanel);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}
