package com.yfli.test.middle.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
  
public class GUIModel {
    public static void main(String[] args) {
          
        JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
        
        //��ǩ���
        JLabel l = new JLabel("LOL����");
        //������ɫ
        l.setForeground(Color.red);
        l.setBounds(300, 100, 280, 30);
  
        JLabel l1 = new JLabel();
        //����ͼƬ����ImageIcon����
        ImageIcon i = new ImageIcon("C:/filetest/file/shana.png");
        //����ImageIcon
        l1.setIcon(i);
        //label�Ĵ�С����ΪImageIcon,������ʾ������
        l1.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
 
        JButton b = new JButton("һ����Է����ع�");
        b.setBounds(200, 50, 200, 30);
        
        
        //��ѡ��
        JCheckBox bCheckBox = new JCheckBox("����Ӣ��");
        //���� Ϊ Ĭ�ϱ�ѡ��
        bCheckBox.setSelected(true);
        bCheckBox.setBounds(400, 50, 130, 30);
        JCheckBox bCheckBox2 = new JCheckBox("ħ�� Ӣ��");
        bCheckBox2.setBounds(400, 100, 130, 30);
        //�ж� �Ƿ� �� ѡ��
        System.out.println(bCheckBox2.isSelected());
        //��ѡ��
        JRadioButton b1 = new JRadioButton("����Ӣ��");
        // ���� Ϊ Ĭ�ϱ�ѡ��
        b1.setSelected(true);
        b1.setBounds(500, 50, 130, 30);
        JRadioButton b2 = new JRadioButton("ħ�� Ӣ��");
        b2.setBounds(500, 100, 130, 30);
        
        // ��ť����
        ButtonGroup bg = new ButtonGroup();
        // ��b1��b2���� ͬһ�� ��ť��������� ������ͬһʱ�䣬ֻ��һ�� ��ť �ᱻѡ��
        bg.add(b1);
        bg.add(b2);
        
        
        //��������ֵ���Ŀ
        String[] heros = new String[] { "��������", "����" };
        JComboBox<String[]> cb = new JComboBox(heros);
 
        cb.setBounds(50, 200, 80, 30);
        
        
        JLabel lName = new JLabel("�˺ţ�");
        // �����
        JTextField tfName = new JTextField("");
        tfName.setText("�������˺�");
        tfName.setPreferredSize(new Dimension(80, 30));
 
        JLabel lPassword = new JLabel("���룺");
        // �����
        JTextField tfPassword = new JTextField("");
        tfPassword.setText("����������");
        tfPassword.setPreferredSize(new Dimension(80, 30));
        
        
        JLabel l2 = new JLabel("���룺");
        // �����
        JPasswordField pf = new JPasswordField("");
        pf.setText("&48kdh4@#");
        pf.setPreferredSize(new Dimension(80, 30));
 
        // ���ı���ͬ����ȡ�����������ݣ��Ƽ�ʹ��getPassword���÷����᷵��һ���ַ����飬�����ַ���
        char[] password = pf.getPassword();
        String p = String.valueOf(password);
        System.out.println(p);
        
        
        /*JTextArea���ı���
        	���ı���JTextField��ͬ���ǣ��ı�����������������
        	���Ҫ���ı����ʼ�ı���ͨ��\n��ʵ�ֻ���Ч��
        JTextAreaͨ�����õ�append����������׷��
        	����ı�̫�������ܳ�ȥ������ͨ��setLineWrap(true) �������Զ����� */
        
        JLabel l3 = new JLabel("�ı���");
        
        JTextArea ta = new JTextArea();
        ta.setPreferredSize(new Dimension(200, 150));
        //\n���з�
        ta.setText("����ͷ��\n�����ð�����\n");
        //׷������
        ta.append("��ȥ��������������������������������������������������");
        //�����Զ�����
        ta.setLineWrap(true);
        
        
        JProgressBar pb = new JProgressBar();
        
        //���������100
        pb.setMaximum(100);
        //��ǰ������50
        pb.setValue(50);
        //��ʾ��ǰ����
        pb.setStringPainted(true);
        
        
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
			
             
            @Override
            public String getDescription() {
                // TODO Auto-generated method stub
                return ".txt";
            }
             
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt");
            }
        });
  
        JButton bOpen = new JButton("���ļ�");
  
        JButton bSave = new JButton("�����ļ�");
  
        f.add(bOpen);
        f.add(bSave);
 
        f.add(pb);
        f.add(l);
        f.add(ta);
        f.add(l2);
        f.add(pf);
        f.add(lName);
        f.add(tfName);
        f.add(lPassword);
        f.add(tfPassword);
        f.add(cb);
        System.out.println(b2.isSelected());
        f.add(b1);
        f.add(b2);
        f.add(bCheckBox);
        f.add(bCheckBox2);
        f.add(l1);
        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        tfPassword.grabFocus();
        
        /*JOptionPane ���ڵ����Ի���

        JOptionPane.showConfirmDialog(f, "�Ƿ� ʹ����� ��");
        	��ʾѯ�ʣ���һ�������ǸöԻ������ĸ��������
        JOptionPane.showInputDialog(f, "������yes������ʹ����Һ���Ը�");
        	�����û�������
        JOptionPane.showMessageDialog(f, "��ʹ����ұ�ץס�� �������3�Σ�");
        	��ʾ��Ϣ */
        
        int option = JOptionPane.showConfirmDialog(f, "�Ƿ� ʹ����� ��");
        if (JOptionPane.OK_OPTION == option) {
            String answer = JOptionPane.showInputDialog(f, "������yes������ʹ����Һ���Ը�");
            if ("yes".equals(answer))
                JOptionPane.showMessageDialog(f, "��ʹ����ұ�ץס�� �������3�Σ�");
        }
        
        
        bOpen.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                 int returnVal =  fc.showOpenDialog(f);
                 File file = fc.getSelectedFile();
                 if (returnVal == JFileChooser.APPROVE_OPTION) {
                     JOptionPane.showMessageDialog(f, "�ƻ����ļ�:" + file.getAbsolutePath());
                 }
                  
            }
        });
        bSave.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal =  fc.showSaveDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(f, "�ƻ����浽�ļ�:" + file.getAbsolutePath());
                }
            }
        });
        
    }
}
