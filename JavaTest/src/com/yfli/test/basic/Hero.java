package com.yfli.test.basic;

public class Hero {
    
    String name; //����
     
    float hp; //Ѫ��
     
    float armor; //����
     
    int moveSpeed; //�ƶ��ٶ�
    
    
    public static void main(String[] args) {
        Hero garen =  new Hero();
        garen.name = "����";
        garen.hp = 616.28f;
        garen.armor = 27.536f;
        garen.moveSpeed = 350;
         
        Hero teemo =  new Hero();
        teemo.name = "��Ī";
        teemo.hp = 383f;
        teemo.armor = 14f;
        teemo.moveSpeed = 330;
    } 
}