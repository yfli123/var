package com.yfli.test.middle.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
 
public class GUIFlowLayout {
    public static void main(String[] args) {
 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // 设置布局器为FlowLayerout
        // 容器上的组件水平摆放
        f.setLayout(new FlowLayout());
 
        JButton b1 = new JButton("英雄1");
        JButton b2 = new JButton("英雄2");
        JButton b3 = new JButton("英雄3");
        JButton b4 = new JButton("英雄1");
        JButton b5 = new JButton("英雄2");
        JButton b6 = new JButton("英雄3");
 
        // 加入到容器即可，无需单独指定大小和位置
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}
