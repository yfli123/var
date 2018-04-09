package com.yfli.test.middle.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 
   
public class ConnectionPoolTest {
   
    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPool(3);
        for (int i = 0; i < 100; i++) {
            new WorkingThread("working thread" + i, cp).start();
        }
   
    }
}
   
class WorkingThread extends Thread {
    private ConnectionPool cp;
   
    public WorkingThread(String name, ConnectionPool cp) {
        super(name);
        this.cp = cp;
    }
   
    public void run() {
        Connection c = cp.getConnection();
        System.out.println(this.getName()+ ":\t ��ȡ��һ�����ӣ�����ʼ����"  );
        try (Statement st = c.createStatement()){
             
            //ģ��ʱ�ģ�������ݿ�ӣѣ����
            Thread.sleep(1000);
            st.execute("select * from hero");
   
        } catch (SQLException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}
