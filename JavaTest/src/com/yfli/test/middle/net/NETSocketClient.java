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
            //���ӵ�������8888�˿�
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
            //���ӵ�������8888�˿�
    		Socket s = new Socket("127.0.0.1",8887);
    		
    		
    		
    		//��������
    		/*// �������
            OutputStream os = s.getOutputStream();
 
            // ��������110�������
            os.write(110);
            os.close();*/
    		
    		
    		/*//�����ַ���
    		OutputStream os = s.getOutputStream();
    		 
            //���������װ��DataOutputStream��
            DataOutputStream dos = new DataOutputStream(os);*/
            //ʹ��writeUTF�����ַ���
           // dos.writeUTF("Legendary!");
            /*while(true) {
	            Scanner sc = new Scanner(System.in);
	            String str = sc.next();
	            dos.writeUTF(str);
            }*/
            
            //int i = 0;
           // while(i < 100) {
           	 //i++;
	             //����������Ϣ�߳�
	             new NETSendThread(s).start();
	             //����������Ϣ�߳�
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
