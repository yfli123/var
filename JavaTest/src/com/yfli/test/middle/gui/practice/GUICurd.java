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
 
        //创建一个TableModel
        GUIHeroTableModel htm= new GUIHeroTableModel();
         
        //根据 TableModel来创建 Table
        JTable t = new JTable(htm);
        
     // 准备一个Panel上面放一个Label用于显示哪条被选中了
        JPanel p = new JPanel();
        final JLabel l = new JLabel("暂时未选中条目");
        p.add(l);
        
        
        
     // 增加 一个 panel用于放置名称，血量输入框和增加 按钮
        JPanel p1 = new JPanel();
        
        
        JDialog d = new JDialog(f);
        d.setTitle("LOL");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        
        
        final JLabel lName1 = new JLabel("名称");
        final JTextField tfName1 = new JTextField("");
        final JLabel lHp1 = new JLabel("血量");
        final JTextField tfHp1 = new JTextField("");
        tfName1.setPreferredSize(new Dimension(80, 30));
        tfHp1.setPreferredSize(new Dimension(80, 30));
        JButton bAdd1 = new JButton("提交");
        bAdd1.setBounds(50, 50, 280, 30);
        
 
        JButton bAdd = new JButton("增加");
        JButton bDel = new JButton("删除");
        JButton bChange = new JButton("修改");
        p1.add(bAdd);
        p1.add(bDel);
        p1.add(bChange);
 
        // 为增加按钮添加监听
        bAdd.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
 
                JDBCHeroDAO dao = new JDBCHeroDAO();
 
                // 根据输入框数据创建一个Hero对象
                Hero h = new Hero();
                JPanel p2 = new JPanel();
                p2.add(lName1);
                p2.add(tfName1);
                p2.add(lHp1);
                p2.add(tfHp1);
                p2.add(bAdd1);
                d.add(p2);
                d.setVisible(true);
                
                // 通过dao更新tablemodel中的数据
                htm.heros = dao.list();
                // 调用JTable的updateUI，刷新界面。
                // 刷新界面的时候，会到tablemodel中去取最新的数据
                // 就能看到新加进去的数据了
                t.updateUI();
                
                // 选中 第一行 ，因为 DAO是按照 ID倒排序查询，所以第一行就是新加入的数据
                t.getSelectionModel().setSelectionInterval(0, 0);
            }
        });
  
        JScrollPane sp = new JScrollPane(t);
        
     // 使用selection监听器来监听table的哪个条目被选中
        t.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
					
                    // 当选择了某一行的时候触发该事件
                    public void valueChanged(ListSelectionEvent e) {
                        // 获取哪一行被选中了
                        int row = t.getSelectedRow();
                        // 根据选中的行，到HeroTableModel中获取对应的对象
                        Hero h = htm.heros.get(row);
                        // 更新标签内容
                        l.setText("当前选中的英雄是： " + h.name);
  
                    }
                });
        
        //f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
        f.add(p1, BorderLayout.SOUTH);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
}

