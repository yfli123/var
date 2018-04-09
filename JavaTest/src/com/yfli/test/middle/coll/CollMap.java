package com.yfli.test.middle.coll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.yfli.test.middle.Hero;
  
  
public class CollMap {
    public static void main(String[] args) {
        List<Hero> hs =new ArrayList<>();
        System.out.println("��ʼ����ʼ");
        for (int i = 0; i < 3000000; i++) {
            Hero h = new Hero(   "hero-" + random());
            hs.add(h);
        }
        //������Ϊkey
        //������ͬ��hero������һ��List�У���Ϊvalue
        HashMap<String,List<Hero>> heroMap =new HashMap();
        for (Hero h : hs) {
            List<Hero> list= heroMap.get( h.name);
            if(list==null){
                list = new ArrayList<>();
                heroMap.put(h.name, list);
            }
            list.add(h);
        }
          
        System.out.println("��ʼ������");
        System.out.println("��ʼ����");
        findByIteration(hs);
        findByMap(heroMap);
          
    }
    private static List<Hero> findByMap(HashMap<String,List<Hero>> m) {
        long start =System.currentTimeMillis();
        List <Hero>result= m.get("hero-5555");
        long end =System.currentTimeMillis();
        System.out.printf("ͨ��map���ң�һ���ҵ�%d��Ӣ�ۣ���ʱ%d ����%n",result.size(),end-start);
        return result;
    }
    private static List<Hero> findByIteration (List<Hero> hs) {
        long start =System.currentTimeMillis();
        List<Hero> result =new ArrayList<>();
        for (Hero h : hs) {
            if(h.name.equals("hero-5555")){
                result.add(h);
            }
        }
        long end =System.currentTimeMillis();
        System.out.printf("ͨ��for���ң�һ���ҵ�%d��Ӣ�ۣ���ʱ%d ����%n", result.size(),end-start);
        return result;
    }
    public static int random(){
        return ((int)(Math.random()*9000)+1000);
    }
}
