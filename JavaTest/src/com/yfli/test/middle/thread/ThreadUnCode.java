package com.yfli.test.middle.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreadUnCode {
	
	
	
	public static void main(String[] args) {
		unCode(getRandomString(3));
	}
	public static List<String> getSerialString() {
		List<String> list = new ArrayList<String>();
		String str = "abcdefghijklmnopqrstuvwzyz";
		String strResult = "";
		char[] charStr = str.toCharArray();
		for(char c1 : charStr) {
			for(char c2 : charStr) {
				for(char c3 : charStr) {
					strResult = String.valueOf(c1)+String.valueOf(c2)+String.valueOf(c3);
					list.add(strResult);
				}
			}
		}
		return list;
		
	}
	
	public static String getRandomString(int count) {
		String str = "abcdefghijklmnopqrstuvwzyz";
		String resultStr = "";
		char[] charStr = str.toCharArray();
		for(int i = 0;i < count;i++) {
			int index = (int)(Math.random()*(charStr.length - 1));
			resultStr += charStr[index];
		}
		
		return resultStr;
	}
	
	public static void unCode(String str) {
		System.out.println("初始密码为："+str);
		List<String> linkList = new LinkedList<String>();
		List<String> serialList = getSerialString();
		
		Thread logThread = new Thread() {
			public void run() {
				while(true) {
					if(linkList.size() == 0) {
						try {
							System.out.println("没有日志数据，暂停一秒钟！");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						String s = linkList.remove(0);
						System.out.println("日志字符串："+s);
					}
				}
			}
		};
		
		logThread.setDaemon(true);
		logThread.start();
		
		Thread unCodeThread = new Thread() {
			public void run() {
				int i = 0;
				Boolean bool = true;
				while(bool) {
					String serStr = serialList.get(i);
					if(serStr.equals(str)) {
						bool = false;
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("匹配到密码，密码为："+serStr);
					}else {
						i++;
						linkList.add(serStr);
					}
				}
			}
		};
		unCodeThread.start();
	}
	
}
