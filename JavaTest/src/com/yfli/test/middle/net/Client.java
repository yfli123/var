package com.yfli.test.middle.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class Client {
 
    public static void main(String[] args) {
 
        try {
            Socket s = new Socket("127.0.0.1", 8888);
 
            // ����������Ϣ�߳�
            new NETSendThread(s,"w").start();
            // ����������Ϣ�߳�
            new NETRecieveThread(s,"w").start();
 
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
