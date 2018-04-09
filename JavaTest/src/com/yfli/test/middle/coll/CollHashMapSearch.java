package com.yfli.test.middle.coll;

import java.util.HashMap;

import com.yfli.test.middle.Hero;
  
public class CollHashMapSearch {
    public static void main(String[] args) {
          
        HashMap<String,Hero> heroMap = new HashMap<String,Hero>();
        for (int j = 0; j < 2000000; j++) {
            Hero h = new Hero("Hero " + j);
            heroMap.put(h.name, h);
        }
        System.out.println("����׼�����");
  
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
              
            //����������Hero 1000000�Ķ���
            Hero target = heroMap.get("Hero 1000000");
            System.out.println("�ҵ��� hero!" + target.name);
              
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("һ�����ˣ�" + elapsed + " ����");
        }
  
    }
}