package com.yfli.test.middle.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.yfli.test.middle.jdbc.JDBCHeroDAO;
import com.yfli.test.middle.lambda.Hero;
  
public class TestGUIHeroTableModel {
    public static void main(String[] args) {
  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        //����һ��TableModel
        GUIHeroTableModel htm= new GUIHeroTableModel();
         
        //���� TableModel������ Table
        JTable t = new JTable(htm);
        
     // ׼��һ��Panel�����һ��Label������ʾ������ѡ����
        JPanel p = new JPanel();
        final JLabel l = new JLabel("��ʱδѡ����Ŀ");
        p.add(l);
        
     // ���� һ�� panel���ڷ������ƣ�Ѫ������������ ��ť
        JPanel p1 = new JPanel();
 
        final JLabel lName = new JLabel("����");
        final JTextField tfName = new JTextField("");
        final JLabel lHp = new JLabel("Ѫ��");
        final JTextField tfHp = new JTextField("");
        JButton bAdd = new JButton("����");
        tfName.setPreferredSize(new Dimension(80, 30));
        tfHp.setPreferredSize(new Dimension(80, 30));
 
        p1.add(lName);
        p1.add(tfName);
        p1.add(lHp);
        p1.add(tfHp);
        p1.add(bAdd);
 
        // Ϊ���Ӱ�ť��Ӽ���
        bAdd.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
 
                JDBCHeroDAO dao = new JDBCHeroDAO();
 
                // ������������ݴ���һ��Hero����
                Hero h = new Hero();
                
                String name = tfName.getText();
                
                // ͨ��name�����ж� �����Ƿ�Ϊ��
                if (name.length() == 0) {
                    // �����Ի�����ʾ�û�
                    JOptionPane.showMessageDialog(f, "���Ʋ���Ϊ��");
 
                    // ����������ȡ����
                    tfName.grabFocus();
                    return;
                }
 
                String hp = tfHp.getText().trim();
 
                try {
                    // ��hpת��Ϊ�����ͣ���������쳣NumberFormatException��ʾ���Ǹ����͸�ʽ
                    Float.parseFloat(hp);
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(f, "Ѫ��ֻ����С�� ");
                    tfHp.grabFocus();
                    return;
                }
                
                h.name = name;
                h.hp = Float.parseFloat(hp);
 
                // ͨ��dao�Ѹö�����뵽���ݿ�
                dao.add(h);
 
                // ͨ��dao����tablemodel�е�����
                htm.heros = dao.list();
                // ����JTable��updateUI��ˢ�½��档
                // ˢ�½����ʱ�򣬻ᵽtablemodel��ȥȡ���µ�����
                // ���ܿ����¼ӽ�ȥ��������
 
                t.updateUI();
                
                // ѡ�� ��һ�� ����Ϊ DAO�ǰ��� ID�������ѯ�����Ե�һ�о����¼��������
                t.getSelectionModel().setSelectionInterval(0, 0);
            }
        });
  
        JScrollPane sp = new JScrollPane(t);
        
     // ʹ��selection������������table���ĸ���Ŀ��ѡ��
        t.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
					
                    // ��ѡ����ĳһ�е�ʱ�򴥷����¼�
                    public void valueChanged(ListSelectionEvent e) {
                        // ��ȡ��һ�б�ѡ����
                        int row = t.getSelectedRow();
                        // ����ѡ�е��У���HeroTableModel�л�ȡ��Ӧ�Ķ���
                        Hero h = htm.heros.get(row);
                        // ���±�ǩ����
                        l.setText("��ǰѡ�е�Ӣ���ǣ� " + h.name);
  
                    }
                });
        f.add(p1, BorderLayout.NORTH);
        //f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
}
