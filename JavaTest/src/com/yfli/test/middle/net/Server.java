package com.yfli.test.middle.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server {
 
    public static void main(String[] args) {
        try {
 
            ServerSocket ss = new ServerSocket(8888);
 
            System.out.println("�����ڶ˿ں�:8888");
            Socket s = ss.accept();
 
            //����������Ϣ�߳�
            new NETSendThread(s,"w").start();
            //����������Ϣ�߳�
            new NETRecieveThread(s,"2").start();
 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
}
