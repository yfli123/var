package com.yfli.test.middle.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
  
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
  
public class GUIKeyListenerPractice {
    public static void main(String[] args) {
  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
        
        
        final JLabel l = new JLabel();
  
        ImageIcon i = new ImageIcon("C:/filetest/file/shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
  
        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);
  
        // 给按钮 增加 监听
        b.addActionListener(new ActionListener() {
  
            // 当按钮被点击时，就会触发 ActionEvent事件
            // actionPerformed 方法就会被执行
            public void actionPerformed(ActionEvent e) {
            	if(b.getText().equals("隐藏图片")) {
            		l.setVisible(false);
                    b.setText("显示图片");
            	} else {
            		l.setVisible(true);
            		f.requestFocus();
                    b.setText("隐藏图片");
            	}
            	
            }
        });
  
        
        
        // 增加键盘监听
        f.addKeyListener(new KeyListener() {
  
            // 键被弹起
            public void keyReleased(KeyEvent e) {
  
                // 39代表按下了 “右键”
                if (e.getKeyCode() == 39) {
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    l.setLocation(l.getX() + 10, l.getY());
                } else if(e.getKeyCode() == 38) {//上
                	l.setLocation(l.getX(), l.getY() - 10);
                } else if(e.getKeyCode() == 40) {//下
                	l.setLocation(l.getX(), l.getY() + 10);
                } else if(e.getKeyCode() == 37) {//左
                	l.setLocation(l.getX() - 10, l.getY());
                }
            }
  
            //键被按下
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // 一个按下弹起的组合动作
            public void keyTyped(KeyEvent e) {
  
            }
        });
  
        f.add(l);
        f.add(b);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
}
