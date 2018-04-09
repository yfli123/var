package com.yfli.test.middle.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
 
public class GUIThread{
    public static void main(String[] args){
        File f = new File("C:/filetest/file/location.txt");
         
        JFrame jf = new JFrame("lol");
        jf.setSize(400, 300);
         
        Thread getL = new Thread(){
            @Override
            public void run(){
                if(f.length() == 0){    //默认位置
                    jf.setLocation(200, 200);
                }
                else{
                    try(    FileReader fr = new FileReader(f);
                            BufferedReader pr = new BufferedReader(fr);
                        ){
                        char[] b = new char[(int)f.length()];
                        pr.read(b);
                        String str = new String(b);
                        String[] stra = str.split("%"); //%用来分割x和y
                        jf.setLocation(Integer.parseInt(stra[0]), Integer.parseInt(stra[1]));   //设新位置
                         
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        getL.start();
 
        jf.setLayout(null);
         
        JButton b = new JButton("一键秒杀");
        b.setBounds(50, 50, 280, 30);
         
        jf.add(b);
         
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
         
        Thread setL = new setLocation(jf,f);
        setL.start();
    }
     
}
 
class setLocation extends Thread{
    JFrame jf;
    private File f;
     
    public setLocation(JFrame jf, File f){
        this.jf = jf;
        this.f = f;
    }
     
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(100);  //每100好毫秒存一次
                setLocat(jf.getX(), jf.getY());
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
     
    private void setLocat(int x, int y){    //把x和y存入文档
        String str = String.valueOf(x) + "%" + String.valueOf(y);   //用%来分割x和y
        char[] c = str.toCharArray();
         
        try(    FileWriter fis = new FileWriter(f);
                PrintWriter bos = new PrintWriter(fis);
            ){
            bos.write(c);
             
        }catch(IOException e){
            e.printStackTrace();
        }
    }
     
}