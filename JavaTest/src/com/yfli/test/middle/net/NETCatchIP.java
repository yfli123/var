package com.yfli.test.middle.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
 
public class NETCatchIP {
 
    public static void main(String[] args) throws IOException {
        InetAddress host = InetAddress.getLocalHost();
        String ip =host.getHostAddress();
        System.out.println("����ip��ַ��" + ip);
        int count = 0;
        List<String> result = getIPs("172.16.41");
        for(String ip1:result) {
	        //Process p = Runtime.getRuntime().exec("ping " + "172.16.35.28");
	        Process p = Runtime.getRuntime().exec("ping " + ip1);
	        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line = null;
	        StringBuilder sb = new StringBuilder();
	        int i = 0;
	        while ((line = br.readLine()) != null) {
	        	i++;
	            if (line.length() != 0)
	                sb.append(line + "\r\n");
	        }
	        if(i > 8) {
	        	count++;
	        	System.out.println("��IP��ַ���ã�IP��"+ ip1 +"��"+count+"��");
	        } else {
	        	System.out.println("��IP��ַ�����ã�IP��"+ ip1);
	        }
	        //System.out.println("����ָ��ص���Ϣ�ǣ�");
	        //System.out.println(sb.toString());
        }
        
    }
    
    
    public static List<String> getIPs(String ip) {
    	List<String> resultList = new ArrayList<String>();
    	for(int i = 1 ; i < 256 ;i++) {
    		resultList.add(ip+"."+i);
    	}
    	return resultList;
    }
}
