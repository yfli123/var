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
  
        JButton b = new JButton("����ͼƬ");
        b.setBounds(150, 200, 100, 30);
  
        // ����ť ���� ����
        b.addActionListener(new ActionListener() {
  
            // ����ť�����ʱ���ͻᴥ�� ActionEvent�¼�
            // actionPerformed �����ͻᱻִ��
            public void actionPerformed(ActionEvent e) {
            	if(b.getText().equals("����ͼƬ")) {
            		l.setVisible(false);
                    b.setText("��ʾͼƬ");
            	} else {
            		l.setVisible(true);
            		f.requestFocus();
                    b.setText("����ͼƬ");
            	}
            	
            }
        });
  
        
        
        // ���Ӽ��̼���
        f.addKeyListener(new KeyListener() {
  
            // ��������
            public void keyReleased(KeyEvent e) {
  
                // 39�������� ���Ҽ���
                if (e.getKeyCode() == 39) {
                    // ͼƬ�����ƶ� ��y���겻�䣬x�������ӣ�
                    l.setLocation(l.getX() + 10, l.getY());
                } else if(e.getKeyCode() == 38) {//��
                	l.setLocation(l.getX(), l.getY() - 10);
                } else if(e.getKeyCode() == 40) {//��
                	l.setLocation(l.getX(), l.getY() + 10);
                } else if(e.getKeyCode() == 37) {//��
                	l.setLocation(l.getX() - 10, l.getY());
                }
            }
  
            //��������
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // һ�����µ������϶���
            public void keyTyped(KeyEvent e) {
  
            }
        });
  
        f.add(l);
        f.add(b);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
}
