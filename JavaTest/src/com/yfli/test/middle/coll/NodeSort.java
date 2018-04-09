package com.yfli.test.middle.coll;

import java.util.ArrayList;
import java.util.List;

import com.yfli.test.middle.Hero;

public class NodeSort {
	
	// ���ӽڵ�
    public NodeSort leftNode;
    // ���ӽڵ�
    public NodeSort rightNode;
  
    // ֵ
    public Hero value;
	

 // ����������еĽڵ�
    public List<Hero> midOrder() {
        List<Hero> values = new ArrayList<>();
  
        // ��ڵ�ı������
        if (null != leftNode)
            values.addAll(leftNode.midOrder());
  
        // ��ǰ�ڵ�
        values.add(value);
  
        // �ҽڵ�ı������
        if (null != rightNode)
  
            values.addAll(rightNode.midOrder());
  
        return values;
    }
	
	// ���� ����
    public void add(Hero v) {
        // �����ǰ�ڵ�û��ֵ���Ͱ����ݷ��ڵ�ǰ�ڵ���
        if (null == value)
            value = v;
  
        // �����ǰ�ڵ���ֵ���ͽ����жϣ�������ֵ�뵱ǰֵ�Ĵ�С��ϵ
        else {
            // ������ֵ���ȵ�ǰֵС������ͬ
             
            if ( v.hp - value.hp <= 0) {
                if (null == leftNode)
                    leftNode = new NodeSort();
                leftNode.add(v);
            }
            // ������ֵ���ȵ�ǰֵ��
            else {
                if (null == rightNode)
                    rightNode = new NodeSort();
                rightNode.add(v);
            }
  
        }
  
    }
	
	public static void main(String[] args) {
		NodeSort roots = new NodeSort();
		for(int i = 0; i < 10; i++ ) {
			Hero h = new Hero("Hero "+i);
			h.hp = (float) (Math.random()*1000);
			roots.add(h);
		}
		
		List<Hero> list = roots.midOrder();
		for(Hero h : list) {
			System.out.println("name:" + h.name + " hp:" + h.hp);
		}
	}
}
