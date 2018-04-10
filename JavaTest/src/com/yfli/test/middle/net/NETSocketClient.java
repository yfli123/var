package com.yfli.test.middle.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
   
public class NETSocketClient  extends Thread {
   
    public static void main(String[] args)  {
           
        try {
            //连接到本机的8888端口
            Socket s = new Socket("127.0.0.1",8888);
            System.out.println(s);
            s.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void run() {
    	try {
            //连接到本机的8888端口
    		Socket s = new Socket("127.0.0.1",8887);
    		
    		
    		
    		//发送数字
    		/*// 打开输出流
            OutputStream os = s.getOutputStream();
 
            // 发送数字110到服务端
            os.write(110);
            os.close();*/
    		
    		
    		/*//发送字符串
    		OutputStream os = s.getOutputStream();
    		 
            //把输出流封装在DataOutputStream中
            DataOutputStream dos = new DataOutputStream(os);*/
            //使用writeUTF发送字符串
           // dos.writeUTF("Legendary!");
            /*while(true) {
	            Scanner sc = new Scanner(System.in);
	            String str = sc.next();
	            dos.writeUTF(str);
            }*/
            
            //int i = 0;
           // while(i < 100) {
           	 //i++;
	             //启动发送消息线程
	             new NETSendThread(s).start();
	             //启动接受消息线程
	             new NETRecieveThread(s).start();
           // }
            /*System.out.println(s);
            s.close();*/
            
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   }
}
