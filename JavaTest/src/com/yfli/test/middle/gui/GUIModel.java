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
        
        //标签组件
        JLabel l = new JLabel("LOL文字");
        //文字颜色
        l.setForeground(Color.red);
        l.setBounds(300, 100, 280, 30);
  
        JLabel l1 = new JLabel();
        //根据图片创建ImageIcon对象
        ImageIcon i = new ImageIcon("C:/filetest/file/shana.png");
        //设置ImageIcon
        l1.setIcon(i);
        //label的大小设置为ImageIcon,否则显示不完整
        l1.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
 
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(200, 50, 200, 30);
        
        
        //复选框
        JCheckBox bCheckBox = new JCheckBox("物理英雄");
        //设置 为 默认被选中
        bCheckBox.setSelected(true);
        bCheckBox.setBounds(400, 50, 130, 30);
        JCheckBox bCheckBox2 = new JCheckBox("魔法 英雄");
        bCheckBox2.setBounds(400, 100, 130, 30);
        //判断 是否 被 选中
        System.out.println(bCheckBox2.isSelected());
        //单选框
        JRadioButton b1 = new JRadioButton("物理英雄");
        // 设置 为 默认被选中
        b1.setSelected(true);
        b1.setBounds(500, 50, 130, 30);
        JRadioButton b2 = new JRadioButton("魔法 英雄");
        b2.setBounds(500, 100, 130, 30);
        
        // 按钮分组
        ButtonGroup bg = new ButtonGroup();
        // 把b1，b2放在 同一个 按钮分组对象里 ，这样同一时间，只有一个 按钮 会被选中
        bg.add(b1);
        bg.add(b2);
        
        
        //下拉框出现的条目
        String[] heros = new String[] { "卡特琳娜", "库奇" };
        JComboBox<String[]> cb = new JComboBox(heros);
 
        cb.setBounds(50, 200, 80, 30);
        
        
        JLabel lName = new JLabel("账号：");
        // 输入框
        JTextField tfName = new JTextField("");
        tfName.setText("请输入账号");
        tfName.setPreferredSize(new Dimension(80, 30));
 
        JLabel lPassword = new JLabel("密码：");
        // 输入框
        JTextField tfPassword = new JTextField("");
        tfPassword.setText("请输入密码");
        tfPassword.setPreferredSize(new Dimension(80, 30));
        
        
        JLabel l2 = new JLabel("密码：");
        // 密码框
        JPasswordField pf = new JPasswordField("");
        pf.setText("&48kdh4@#");
        pf.setPreferredSize(new Dimension(80, 30));
 
        // 与文本框不同，获取密码框里的内容，推荐使用getPassword，该方法会返回一个字符数组，而非字符串
        char[] password = pf.getPassword();
        String p = String.valueOf(password);
        System.out.println(p);
        
        
        /*JTextArea：文本域。
        	和文本框JTextField不同的是，文本域可以输入多行数据
        	如果要给文本域初始文本，通过\n来实现换行效果
        JTextArea通常会用到append来进行数据追加
        	如果文本太长，会跑出去，可以通过setLineWrap(true) 来做到自动换行 */
        
        JLabel l3 = new JLabel("文本域：");
        
        JTextArea ta = new JTextArea();
        ta.setPreferredSize(new Dimension(200, 150));
        //\n换行符
        ta.setText("抢人头！\n抢你妹啊抢！\n");
        //追加数据
        ta.append("我去送了了了了了了了了了了了了了了了了了了了了了了了了");
        //设置自动换行
        ta.setLineWrap(true);
        
        
        JProgressBar pb = new JProgressBar();
        
        //进度条最大100
        pb.setMaximum(100);
        //当前进度是50
        pb.setValue(50);
        //显示当前进度
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
  
        JButton bOpen = new JButton("打开文件");
  
        JButton bSave = new JButton("保存文件");
  
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
        
        /*JOptionPane 用于弹出对话框

        JOptionPane.showConfirmDialog(f, "是否 使用外挂 ？");
        	表示询问，第一个参数是该对话框以哪个组件对齐
        JOptionPane.showInputDialog(f, "请输入yes，表明使用外挂后果自负");
        	接受用户的输入
        JOptionPane.showMessageDialog(f, "你使用外挂被抓住！ 罚拣肥皂3次！");
        	显示消息 */
        
        int option = JOptionPane.showConfirmDialog(f, "是否 使用外挂 ？");
        if (JOptionPane.OK_OPTION == option) {
            String answer = JOptionPane.showInputDialog(f, "请输入yes，表明使用外挂后果自负");
            if ("yes".equals(answer))
                JOptionPane.showMessageDialog(f, "你使用外挂被抓住！ 罚拣肥皂3次！");
        }
        
        
        bOpen.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                 int returnVal =  fc.showOpenDialog(f);
                 File file = fc.getSelectedFile();
                 if (returnVal == JFileChooser.APPROVE_OPTION) {
                     JOptionPane.showMessageDialog(f, "计划打开文件:" + file.getAbsolutePath());
                 }
                  
            }
        });
        bSave.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal =  fc.showSaveDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(f, "计划保存到文件:" + file.getAbsolutePath());
                }
            }
        });
        
    }
}
