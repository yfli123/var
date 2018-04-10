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
    //把 htm和 table设计为静态，后面在更新表格数据的时候，就很容易访问这个两个对象
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
 
        JButton bAdd = new JButton("增加");
        JButton bDel = new JButton("删除");
        JButton bModify = new JButton("修改");
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
					
                    // 当选择了某一行的时候触发该事件
                    public void valueChanged(ListSelectionEvent e) {
                        // 获取哪一行被选中了
                        int row = t.getSelectedRow();
                        // 根据选中的行，到HeroTableModel中获取对应的对象
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
            	// 使用selection监听器来监听table的哪个条目被选中
                
                new ModifyDialog(f).setVisible(true);
            }
        });
        
        
        bDel.addActionListener(new ActionListener() {
       	 
            @Override
            public void actionPerformed(ActionEvent e) {
            	// 获取哪一行被选中了
                int row = t.getSelectedRow();
                if(row < 0) {
                	JOptionPane.showMessageDialog(f, "请选中一行之后删除");
                	return;
                }
                
                int option = JOptionPane.showConfirmDialog(f, "确定要删除该条数据吗？");
                if(JOptionPane.OK_OPTION == option) {
                	// 根据选中的行，到HeroTableModel中获取对应的对象
                    Hero h = htm.heros.get(row);
                    //更新标签内容
                    //l.setText("当前选中的英雄是： " + h.name);
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
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");
         
        JTextField tfName =new JTextField();
        JTextField tfHp =new JTextField();
         
        JButton bSubmit =new JButton("提交");
         
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
                     
                    if(checkEmpty(tfName, "名称")){
                        if(checkNumber(tfHp, "hp")){
                         
                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());
                             
                            Hero h = new Hero();
                            h.name = name;
                            h.hp = hp;
                             
                            new JDBCHeroDAO().add(h);
                             
                            JOptionPane.showMessageDialog(f, "提交成功 ");
                             
                            AddDialog.this.setVisible(false);
                            updateTable();
                        }
                    }
                     
                }
            });
             
        }
    }
    
    
    static class ModifyDialog extends JDialog{
        JLabel lName = new JLabel("名称");
        JLabel lHp = new JLabel("血量");
         
        JTextField tfName =new JTextField(h.name);
        JTextField tfHp =new JTextField(""+h.hp);
         
        JButton bSubmit =new JButton("提交");
         
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
                	
                    if(checkEmpty(tfName, "名称")){
                        if(checkNumber(tfHp, "hp")){
                            String name = tfName.getText();
                            int hp = Integer.parseInt(tfHp.getText());
                            h.name = name;
                            h.hp = hp;
                            new JDBCHeroDAO().update(h);
                            JOptionPane.showMessageDialog(f, "提交成功 ");
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
            JOptionPane.showMessageDialog(null,msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    private static boolean checkNumber(JTextField tf, String msg) {
        String value = tf.getText();
        if(0==value.length()){
            JOptionPane.showMessageDialog(null,msg + " 不能为空");
            tf.grabFocus();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,msg + " 只能是整数");
            tf.grabFocus();
            return false;
        }
         
        return true;
    }
}