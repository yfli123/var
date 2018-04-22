package com.yfli.test.middle.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
 
public class NETRecieveThread extends Thread {
 
    private Socket s;
    private String name;
 
    public NETRecieveThread(Socket s,String name) {
        this.s = s;
        this.name = name;
    }
 
    public void run() {
        try {
            InputStream is = s.getInputStream();
 
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                String msg = dis.readUTF();
                System.out.println(""+msg);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 
}
