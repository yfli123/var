package com.yfli.test.basic;

public class TestGiantDragon {
	 public static void main(String[] args) {
	        //ͨ��newʵ�����ᱨ��
//	      GiantDragon g = new GiantDragon();
	         
	        //ֻ��ͨ��getInstance�õ�����
	         
	        GiantDragon g1 = GiantDragon.getInstance();
	        GiantDragon g2 = GiantDragon.getInstance();
	        GiantDragon g3 = GiantDragon.getInstance();
	         
	        //����ͬһ������
	        System.out.println(g1==g2);
	        System.out.println(g1==g3);
	    }
}
