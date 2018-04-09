package com.yfli.test.middle.gui.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
 
import static javax.swing.JFrame.EXIT_ON_CLOSE;
 
public class CopyBar {
 
 
  public static      double calAllFile(File file){
        double alllen=0;
        if(file.isFile())
          alllen =alllen+(int)  file.length();
        else if(file.isDirectory())
        {
            File[] files =file.listFiles();
            for (File f :files) {
                calAllFile(f);
            }
 
        }
        System.out.println("计算出来 的结果"+alllen);
        return alllen;
    }
 
    public static void main(String[] args) {
 
        JFrame jf = new JFrame("带进度条的文件夹复制");
        jf.setSize(450, 140);
        jf.setLocation(200, 200);
        jf.setLayout(new FlowLayout());
 
        // 文件地址
        JLabel lStr = new JLabel("源文件地址：");
        JTextField strTf = new JTextField("");
        strTf.setText("C:/filetest/file");
        strTf.setPreferredSize(new Dimension(100, 30));
        JLabel lDest = new JLabel("复制到：");
        JTextField destTf = new JTextField("");
        destTf.setText("C:/filetest/filecopy");
        destTf.setPreferredSize(new Dimension(100, 30));
 
        jf.add(lStr);
        jf.add(strTf);
        jf.add(lDest);
        jf.add(destTf);
 
        JButton bStartCopy = new JButton("开始复制");
        bStartCopy.setPreferredSize(new Dimension(100, 30));
 
        JLabel l = new JLabel("文件复制进度：");
        JProgressBar pb = new JProgressBar();
        pb.setMaximum(100);
        pb.setStringPainted(true);
 
        jf.add(bStartCopy);
        jf.add(l);
        jf.add(pb);
 
        bStartCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
 
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        copyFolder("C:/filetest/file", "C:/filetest/filecopy");
                    }
                }.start();
            }
    public  void copyFolder(String srcFolder, String destFolder) {
        File file = new File(srcFolder);
        File file2 = new File(destFolder);
        double allsrcLen1 = calAllFile(file);
         double curr =0;
//        System.out.println("纪工委"+allsrcLen);
        File[] files = file.listFiles();
        if (!file.isDirectory())
            return;
        if (file2.isFile())
            return;
        if (!file.exists())
            return;
        if (!file2.exists())
            file2.mkdirs();
        for (File f : files)
            if (f.isFile()) {
 
                File destFile = new File(file2, f.getName());
                copyFile(f.getAbsolutePath(), destFile.getAbsolutePath());
 
                curr = curr +(int)f.length();
                System.out.println("当前进度是： "+curr);
                System.out.println("所有的文件大小是: "+allsrcLen1);
                double progress = curr / allsrcLen1;
               int pro=(int)(progress*100);
                System.out.println("进度显示一下 "+progress);
                System.out.println("进度显示一下 "+pro);
                pb.setValue(pro);
                if(progress==100)
                    JOptionPane.showMessageDialog(jf,"复制完成");
 
            } else if (f.isDirectory()) {
                File destFoldernew = new File(file2, f.getName());
                copyFolder(f.getAbsolutePath(), destFoldernew.getAbsolutePath());
            }
    }
 
    public  void copyFile(String srcFilePath, String destFilePath) {
        File file = new File(srcFilePath);
        File file3 = new File(destFilePath);
        byte[] bytes = new byte[(int) file.length()];
        try (FileInputStream fi = new FileInputStream(file);
        ) {
            System.out.println(fi.read(bytes));
//            String a = new String(bytes);
 
        } catch (IOException e) {
 
            e.printStackTrace();
        }
        try (FileOutputStream fo = new FileOutputStream(file3);
 
        ) {
            fo.write(bytes);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
    });
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
}
}
