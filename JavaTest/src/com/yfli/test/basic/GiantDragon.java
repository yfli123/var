package com.yfli.test.basic;

public class GiantDragon {
	//˽�л����췽��ʹ�ø����޷����ⲿͨ��new ����ʵ����
    private GiantDragon(){
         
    }
 
    //׼��һ�������ԣ�ָ��һ��ʵ�������� ��Ϊ�������ԣ�����ֻ��һ��
 
    //private static GiantDragon instance = new GiantDragon();
    
    private static GiantDragon instance;
     
    //public static �������ṩ�������߻�ȡ12�ж���Ķ���
    public static GiantDragon getInstance(){
    	if(null==instance){
            instance = new GiantDragon();
        }
    	return instance;
    }
}
