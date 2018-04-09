package com.yfli.test.middle.coll;

import java.util.LinkedList;

public class MyHashMap implements IHashMap {
	
	private Object[] mhm = new Object[2000];
	
	public MyHashMap() {
		for(int i = 0; i < mhm.length; i++){
            mhm[i] = new LinkedList<Entry>();
        }
	}
	
	public static int hashCode(String str) {
		
		int hashCode = 0;
		char[] arrayChar = str.toCharArray();
		for(char car : arrayChar) {
			hashCode += car;
		}
		hashCode = hashCode*23;
		if(hashCode > 2000) {
			hashCode = hashCode%2000;
		}
		return hashCode;
	}
	
	
	public void put(String key,Object value) {
		int hashCode = hashCode(key);
		if(mhm[hashCode] == null){
            LinkedList<Entry> linkedList = new LinkedList<Entry>();
            linkedList.add(new Entry(key, value));
            mhm[hashCode] = linkedList;
        }
        else{
            LinkedList<Entry> linkedlist = (LinkedList<Entry>)mhm[hashCode];
            linkedlist.add(new Entry(key, value));
            mhm[hashCode] = linkedlist;
        }
		
	}
	
	
	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		int hashCode = hashCode(key);
		LinkedList<Entry> linkedlist = (LinkedList<Entry>)mhm[hashCode];
		
		if(linkedlist == null) {
			System.out.println("未找到对应的值！");
		}else {
			for(Entry e : linkedlist) {
				if(key.equals(e.key)) {
					return e.value;
				}
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		System.out.println(hashCode("abc"));
		MyHashMap myMap = new MyHashMap();
		myMap.put("123", "wer");
		myMap.put("1234", "wer1");
		myMap.put("123", "wer2");
		
		System.out.println(myMap.get("12345"));
	}


	
}
