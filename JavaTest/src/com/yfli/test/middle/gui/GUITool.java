package com.yfli.test.middle.gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
 
public class GUITool {
    public static void main(String[] args) {
 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // �˵�
        addMenu(f);
 
        // ������
        JToolBar tb = new JToolBar();
        // Ϊ���������Ӱ�ť
        JButton b1 = new JButton(new ImageIcon("C:/filetest/filecopy/1.jpg"));
        JButton b2 = new JButton(new ImageIcon("C:/filetest/filecopy/2.jpg"));
        JButton b3 = new JButton(new ImageIcon("C:/filetest/filecopy/3.jpg"));
        JButton b4 = new JButton(new ImageIcon("C:/filetest/filecopy/4.jpg"));
        JButton b5 = new JButton(new ImageIcon("C:/filetest/filecopy/5.jpg"));
        JButton b6 = new JButton(new ImageIcon("C:/filetest/filecopy/6.jpg"));
        tb.add(b1);
        tb.add(b2);
        tb.add(b3);
        tb.add(b4);
        tb.add(b5);
        tb.add(b6);
        // ����ť������ʾ��Ϣ
        b1.setToolTipText("�ӵ�Ӣ��");
        
        // ��ֹ�������϶�
        tb.setFloatable(false);
 
        // �ѹ���������north��λ��
        f.setLayout(new BorderLayout());
        f.add(tb, BorderLayout.NORTH);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
 
    private static void addMenu(JFrame f) {
        JMenuBar mb = new JMenuBar();
 
        JMenu mHero = new JMenu("Ӣ��");
        JMenu mItem = new JMenu("����");
        JMenu mWord = new JMenu("����");
        JMenu mSummon = new JMenu("�ٻ�ʦ");
        JMenu mTalent = new JMenu("�츳��");
 
        // �˵���
        mHero.add(new JMenuItem("��ս-Warriar"));
        mHero.add(new JMenuItem("Զ��-Range"));
        mHero.add(new JMenuItem("����-physical"));
        mHero.add(new JMenuItem("̹��-Tank"));
        mHero.add(new JMenuItem("��ϵ-Mage"));
        mHero.add(new JMenuItem("����-Support"));
        mHero.add(new JMenuItem("��Ұ-Jungle"));
        mHero.add(new JMenuItem("ͻ��-Charge"));
        mHero.add(new JMenuItem("����-Boy"));
        mHero.add(new JMenuItem("Ů��-Girl"));
 
        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        mb.add(mSummon);
        mb.add(mTalent);
 
        f.setJMenuBar(mb);
    }
}
