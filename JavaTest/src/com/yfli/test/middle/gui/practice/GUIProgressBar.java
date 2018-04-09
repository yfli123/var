package com.yfli.test.middle.gui.practice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
 
public class GUIProgressBar {
 
    static long allFileSize = 0; // ������Ҫ���Ƶ��ļ���С
    static long currentFileSizeCopied = 0;// �Ѹ��Ƶ��ļ��ܴ�С
 
    /**
     * �����ļ��л�ȡ�ļ��������ܴ�С
     *
     * @param file
     */
    public static void calclateAllFilesize(File file) {
 
        if (file.isFile()) {
            allFileSize += file.length();
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                calclateAllFilesize(f);
            }
        }
 
    }
 
    public static void main(String[] args) {
 
        JFrame f = new JFrame("�����������ļ��и���");
        f.setSize(450, 140);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
 
        // �ļ���ַ
        JLabel lStr = new JLabel("Դ�ļ���ַ��");
        JTextField strTf = new JTextField("");
        strTf.setText("C:/filetest/file");
        strTf.setPreferredSize(new Dimension(100, 30));
        JLabel lDest = new JLabel("���Ƶ���");
        JTextField destTf = new JTextField("");
        destTf.setText("C:/filetest/filecopy");
        destTf.setPreferredSize(new Dimension(100, 30));
 
        f.add(lStr);
        f.add(strTf);
        f.add(lDest);
        f.add(destTf);
 
        JButton bStartCopy = new JButton("��ʼ����");
        bStartCopy.setPreferredSize(new Dimension(100, 30));
 
        JLabel l = new JLabel("�ļ����ƽ��ȣ�");
        JProgressBar pb = new JProgressBar();
        pb.setMaximum(100);
        pb.setStringPainted(true);
 
        f.add(bStartCopy);
        f.add(l);
        f.add(pb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
 
        // ������Ҫ���Ƶ��ļ����ܴ�С
        String srcPath = strTf.getText();
        File folder = new File(srcPath);
        calclateAllFilesize(folder);
 
        // �����ʼ����
        bStartCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentFileSizeCopied = 0;
                String srcPath = strTf.getText();
                String destPath = destTf.getText();
                new Thread(() -> copyFolder(srcPath, destPath)).start();
                bStartCopy.setEnabled(false);
            }
 
            public void copyFile(String srcPath, String destPath) {
 
                File srcFile = new File(srcPath);
                File destFile = new File(destPath);
 
                // ��������һ���Զ�ȡ1024�ֽ�
                byte[] buffer = new byte[1024];
 
                try (FileInputStream fis = new FileInputStream(srcFile);
                        FileOutputStream fos = new FileOutputStream(destFile);) {
                    while (true) {
                        // ʵ�ʶ�ȡ�ĳ����� actuallyReaded,�п���С��1024
                        int actuallyReaded = fis.read(buffer);
                        // -1��ʾû�пɶ���������
                        if (-1 == actuallyReaded)
                            break;
                        fos.write(buffer, 0, actuallyReaded);
                        fos.flush();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
 
            public void copyFolder(String srcPath, String destPath) {
                File srcFolder = new File(srcPath);
                File destFolder = new File(destPath);
 
                if (!srcFolder.exists())
                    return;
 
                if (!srcFolder.isDirectory())
                    return;
 
                if (destFolder.isFile())
                    return;
 
                if (!destFolder.exists())
                    destFolder.mkdirs();
 
                File[] files = srcFolder.listFiles();
                for (File srcFile : files) {
 
                    if (!(srcFile.isDirectory())) {
                        File newDestFile = new File(destFolder, srcFile.getName());
                        copyFile(srcFile.getAbsolutePath(), newDestFile.getAbsolutePath());
                        currentFileSizeCopied += srcFile.length();
 
                        double current = (double) currentFileSizeCopied / (double) allFileSize;
                        int progress = (int) (current * 100);
                        pb.setValue(progress);
                        if (progress == 100) {
                            JOptionPane.showMessageDialog(f, "�������");
                            bStartCopy.setEnabled(true);
                        }
 
                    }
 
                    if (srcFile.isDirectory()) {
                        File newDestFolder = new File(destFolder, srcFile.getName());
                        copyFolder(srcFile.getAbsolutePath(), newDestFolder.getAbsolutePath());
                    }
 
                }
            }
        });
    }
}
