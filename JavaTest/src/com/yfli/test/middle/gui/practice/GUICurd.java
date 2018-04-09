package com.yfli.test.middle.gui.practice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.yfli.test.middle.gui.GUIHeroTableModel;
import com.yfli.test.middle.jdbc.JDBCHeroDAO;
import com.yfli.test.middle.lambda.Hero;
  
public class GUICurd {
    public static void main(String[] args) {
  
        JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
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
        
        
        JDialog d = new JDialog(f);
        d.setTitle("LOL");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        
        
        final JLabel lName1 = new JLabel("����");
        final JTextField tfName1 = new JTextField("");
        final JLabel lHp1 = new JLabel("Ѫ��");
        final JTextField tfHp1 = new JTextField("");
        tfName1.setPreferredSize(new Dimension(80, 30));
        tfHp1.setPreferredSize(new Dimension(80, 30));
        JButton bAdd1 = new JButton("�ύ");
        bAdd1.setBounds(50, 50, 280, 30);
        
 
        JButton bAdd = new JButton("����");
        JButton bDel = new JButton("ɾ��");
        JButton bChange = new JButton("�޸�");
        p1.add(bAdd);
        p1.add(bDel);
        p1.add(bChange);
 
        // Ϊ���Ӱ�ť��Ӽ���
        bAdd.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
 
                JDBCHeroDAO dao = new JDBCHeroDAO();
 
                // ������������ݴ���һ��Hero����
                Hero h = new Hero();
                JPanel p2 = new JPanel();
                p2.add(lName1);
                p2.add(tfName1);
                p2.add(lHp1);
                p2.add(tfHp1);
                p2.add(bAdd1);
                d.add(p2);
                d.setVisible(true);
                
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
        
        //f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
        f.add(p1, BorderLayout.SOUTH);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
}

