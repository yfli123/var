package com.yfli.test.middle.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
  
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
  
public class GUIMouseListener {
    public static void main(String[] args) {
  
        final JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
  
        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("C:/filetest/file/shana_heiheihei.png");
        l.setIcon(i);
        l.setBounds(375, 275, i.getIconWidth(), i.getIconHeight());
  
        f.add(l);
  
        l.addMouseListener(new MouseListener() {
  
            // �ͷ����
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // �������
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // ����˳�
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // ������
            public void mouseEntered(MouseEvent e) {
  
                Random r = new Random();
  
                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());
  
                l.setLocation(x, y);
  
            }
  
            // �����ͷ���϶���Ϊ������
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
        });
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
}
