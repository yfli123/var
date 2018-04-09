package com.yfli.test.middle.gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
 
public class GUIMenu {
    public static void main(String[] args) {
 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 400);
        f.setLocation(200, 200);
 
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
        // �ָ���
        mHero.addSeparator();
        mHero.add(new JMenuItem("����-All"));
 
        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        mb.add(mSummon);
        mb.add(mTalent);
 
        f.setJMenuBar(mb);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}
