package com.yfli.test.middle.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
   
public class NETSocketServer extends Thread {
   
	
    public void run() {
    	 try {
             //����˴򿪶˿�8888
             ServerSocket ss = new ServerSocket(8887);
             //��8888�˿��ϼ��������Ƿ��������������
             System.out.println("�����ڶ˿ں�:8888");
             Socket s =  ss.accept();
             
             /*��ȡ����*/
             /*//��������
             InputStream is = s.getInputStream();
  
             //��ȡ�ͻ��˷��͵�����
             int msg = is.read();*/
             
             
             /*��ȡ�ַ���*/
             /*while(true) {
            	 Socket s =  ss.accept();
	             InputStream is = s.getInputStream();
	             //����������װ��DataInputStream
	             DataInputStream dis = new DataInputStream(is);
	             //ʹ��readUTF��ȡ�ַ���
	             String msg = dis.readUTF();
	             System.out.println(msg);
	             dis.close();
	             is.close();
             }*/
             //int i = 0;
            // while(i < 100) {
            	 //i++;
	             //����������Ϣ�߳�
	             new NETSendThread(s,"server").start();
	             //����������Ϣ�߳�
	             new NETRecieveThread(s,"server").start();
             //}
             
             /*System.out.println("�����ӹ���" + s);
             s.close();
             ss.close();*/
             
             
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
    }
}
