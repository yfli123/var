package com.yfli.test.middle.gui.practice;


import java.awt.BorderLayout;
import java.awt.GridLayout;
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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.yfli.test.middle.gui.GUIHeroTableModel;
import com.yfli.test.middle.jdbc.JDBCHeroDAO;
import com.yfli.test.middle.lambda.Hero;
 
 
public class GUICurd {
    //�� htm�� table���Ϊ��̬�������ڸ��±�����ݵ�ʱ�򣬾ͺ����׷��������������
    static GUIHeroTableModel htm = new GUIHeroTableModel();
    static JTable t = new JTable(htm);
    static Hero h = null;
 
    public static void main(String[] args) {
 
        final JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        t.getSelectionModel().setSelectionInterval(0, 0);
 
        JPanel pOperation = new JPanel();
 
        JButton bAdd = new JButton("����");
        JButton bDel = new JButton("ɾ��");
        JButton bModify = new JButton("�޸�");
        pOperation.add(bAdd);
        pOperation.add(bDel);
        pOperation.add(bModify);
        
        /*t.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});*/
        
        t.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
					
                    // ��ѡ����ĳһ�е�ʱ�򴥷����¼�
                    public void valueChanged(ListSelectionEvent e) {
                        // ��ȡ��һ�б�ѡ����
                        int row = t.getSelectedRow();
                        // ����ѡ�е��У���HeroTableModel�л�ȡ��Ӧ�Ķ���
                        h = htm.heros.get(row);
                        JOptionPane.showMessageDialog(f, h.name);
  
                    }
                });
 
        bAdd.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDialog(f).setVisible(true);
            }
        });
        
        bModify.addActionListener(new ActionListener() {
        	 
            @Override
            public void actionPerformed(ActionEvent e) {
            	// ʹ��selection������������table���ĸ���Ŀ��ѡ��
                
                new ModifyDialog(f).setVisible(true);
            }
        });
        
        
        bDel.addActionListener(new ActionListener() {
       	 
            @Override
            public void actionPerformed(ActionEvent e) {
            	// ��ȡ��һ�б�ѡ����
                int row = t.getSelectedRow();
                if(row < 0) {
                	JOptionPane.showMessageDialog(f, "��ѡ��һ��֮��ɾ��");
                	return;
                }
                
                int option = JOptionPane.showConfirmDialog(f, "ȷ��Ҫɾ������������");
                if(JOptionPane.OK_OPTION == option) {
                	// ����ѡ�е��У���HeroTableModel�л�ȡ��Ӧ�Ķ���
                    Hero h = htm.heros.get(row);
                    //���±�ǩ����
                    //l.setText("��ǰѡ�е�Ӣ���ǣ� " + h.name);
                    //JOptionPane.showMessageDialog(f, h.id);
                    new JDBCHeroDAO().delete(h.id);
                    updateTable();
                }
                
            }
        });
        t.setRowSelectionInterval(0, 0);
        t.getSelectionModel().addSelectionInterval(0, 0);
        t.getSelectionModel().setSelectionInterval(0, 0);
        JScrollPane sp = new JScrollPane(t);
        
        f.add(sp, BorderLayout.CENTER);
        f.add(pOperation, BorderLayout.SOUTH);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.setVisible(true);
    }
     
    static class AddDialog extends JDialog{
        JLabel lName = new JLabel("����");
        JLabel lHp = new JLabel("Ѫ��");
         
        JTextField tfName =new JTextField();
        JTextField tfHp =new JTextField();
         
        JButton bSubmit =new JButton("�ύ");
         
        AddDialog(JFrame f){
            super(f);
            this.setModal(true);
            int gap = 50;
            this.setLayout(null);
             
            JPanel pInput= new JPanel();
            JPanel pSubmit= new JPanel();
             
            pInput.setLayout(new GridLayout(2, 2,gap,gap));
            pInput.add(lName);
            pInput.add(tfName);
            pInput.add(lHp);
            pInput.add(tfHp);
             
            pSubmit.add(bSubmit);
             
            pInput.setBounds(50,20,200,100);
            pSubmit.setBounds(0,130,300,150);
             
            this.add(pInput);
            this.add(pSubmit);
 
            this.setSize(300, 200);
            this.setLocationRelativeTo(f);
            bSubmit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                     
                    if(checkEmpty(tfName, "����")){
                        if(checkNumber(tfHp, "hp")){
                         
                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());
                             
                            Hero h = new Hero();
                            h.name = name;
                            h.hp = hp;
                             
                            new JDBCHeroDAO().add(h);
                             
                            JOptionPane.showMessageDialog(f, "�ύ�ɹ� ");
                             
                            AddDialog.this.setVisible(false);
                            updateTable();
                        }
                    }
                     
                }
            });
             
        }
    }
    
    
    static class ModifyDialog extends JDialog{
        JLabel lName = new JLabel("����");
        JLabel lHp = new JLabel("Ѫ��");
         
        JTextField tfName =new JTextField(h.name);
        JTextField tfHp =new JTextField(""+h.hp);
         
        JButton bSubmit =new JButton("�ύ");
         
        ModifyDialog(JFrame f){
            super(f);
            this.setModal(true);
            int gap = 50;
            this.setLayout(null);
            
            
            JPanel pInput= new JPanel();
            JPanel pSubmit= new JPanel();
             
            pInput.setLayout(new GridLayout(2, 2,gap,gap));
            pInput.add(lName);
            pInput.add(tfName);
            pInput.add(lHp);
            pInput.add(tfHp);
             
            pSubmit.add(bSubmit);
            
            
             
            pInput.setBounds(50,20,200,100);
            pSubmit.setBounds(0,130,300,150);
             
            this.add(pInput);
            this.add(pSubmit);
 
            this.setSize(300, 200);
            this.setLocationRelativeTo(f);
            
            
            
            bSubmit.addActionListener(new ActionListener(){
           	 
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                    if(checkEmpty(tfName, "����")){
                        if(checkNumber(tfHp, "hp")){
                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());
                            h.name = name;
                            h.hp = hp;
                            new JDBCHeroDAO().update(h);
                            JOptionPane.showMessageDialog(f, "�ύ�ɹ� ");
                            ModifyDialog.this.setVisible(false);
                            updateTable();
                        }
                    }
                     
                }
            });
            
            
             
        }
    }
    
     
    public static void updateTable(){
        htm.heros = new JDBCHeroDAO().list();
        t.updateUI();
        if(!htm.heros.isEmpty())
            t.getSelectionModel().setSelectionInterval(0, 0);
    }
     
    private static boolean checkEmpty(JTextField tf, String msg) {
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null,msg + " ����Ϊ��");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    private static boolean checkNumber(JTextField tf, String msg) {
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null,msg + " ����Ϊ��");
            tf.grabFocus();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,msg + " ֻ��������");
            tf.grabFocus();
            return false;
        }
         
        return true;
    }
}