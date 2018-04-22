package com.yfli.test.middle.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class Client {
 
    public static void main(String[] args) {
 
        try {
            Socket s = new Socket("127.0.0.1", 8888);
 
            // 启动发送消息线程
            new NETSendThread(s,"w").start();
            // 启动接受消息线程
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
