package com.yfli.test.middle.thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class MyStackThread{
	
	//��LinkedListͨ�� Collections.synchronizedListת������һ���̰߳�ȫ��List
    static List<Character> heros = (List<Character>) Collections.synchronizedList(new LinkedList<Character>());
   
    public static int length() {
		return heros.size();
	}
    //����Ҫ��push�ϼ�synchronized���η�
    //��Ȼ����߳̿���ͬʱ����push���������ǵ���heros.add������ʱ��
    //ͬһʱ�䣬ֻ��һ���߳̿��Խ���
    public void push(Character h) {
        heros.add(h);
    }
      
    public Character pull() {
        return heros.remove(heros.size()-1);
    }
      
    public Character peek() {
        return heros.get(heros.size()-1);
    }
    
    @Override
    public String toString() {
        return "MyStack [list=" + heros + "]";
    }
}