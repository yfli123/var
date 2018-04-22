package com.yfli.test.middle.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
   
public class NETSocketServer extends Thread {
   
	
    public void run() {
    	 try {
             //服务端打开端口8888
             ServerSocket ss = new ServerSocket(8887);
             //在8888端口上监听，看是否有连接请求过来
             System.out.println("监听在端口号:8888");
             Socket s =  ss.accept();
             
             /*读取数字*/
             /*//打开输入流
             InputStream is = s.getInputStream();
  
             //读取客户端发送的数据
             int msg = is.read();*/
             
             
             /*读取字符串*/
             /*while(true) {
            	 Socket s =  ss.accept();
	             InputStream is = s.getInputStream();
	             //把输入流封装在DataInputStream
	             DataInputStream dis = new DataInputStream(is);
	             //使用readUTF读取字符串
	             String msg = dis.readUTF();
	             System.out.println(msg);
	             dis.close();
	             is.close();
             }*/
             //int i = 0;
            // while(i < 100) {
            	 //i++;
	             //启动发送消息线程
	             new NETSendThread(s,"server").start();
	             //启动接受消息线程
	             new NETRecieveThread(s,"server").start();
             //}
             
             /*System.out.println("有连接过来" + s);
             s.close();
             ss.close();*/
             
             
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
    }
}
