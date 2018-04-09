package com.yfli.test.middle.coll;

import java.util.ArrayList;
import java.util.List;

import com.yfli.test.middle.Hero;

public class NodeSort {
	
	// 左子节点
    public NodeSort leftNode;
    // 右子节点
    public NodeSort rightNode;
  
    // 值
    public Hero value;
	

 // 中序遍历所有的节点
    public List<Hero> midOrder() {
        List<Hero> values = new ArrayList<>();
  
        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.midOrder());
  
        // 当前节点
        values.add(value);
  
        // 右节点的遍历结果
        if (null != rightNode)
  
            values.addAll(rightNode.midOrder());
  
        return values;
    }
	
	// 插入 数据
    public void add(Hero v) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = v;
  
        // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同
             
            if ( v.hp - value.hp <= 0) {
                if (null == leftNode)
                    leftNode = new NodeSort();
                leftNode.add(v);
            }
            // 新增的值，比当前值大
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
