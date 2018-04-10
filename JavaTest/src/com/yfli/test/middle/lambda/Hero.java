package com.yfli.test.middle.lambda;

public class Hero implements Comparable<Hero>{
    public String name;
    public float hp;
         
    public int damage;
    public int id;
         
    
	public Hero(){
            
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getHp() {
        return hp;
    }
    public void setHp(float hp) {
        this.hp = hp;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public Hero(String name) {
        this.name =name;
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
    //��ʼ��name,hp,damage�Ĺ��췽��
    public Hero(String name,float hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }
    
    @Override
    public int compareTo(Hero anotherHero) {
        if(damage<anotherHero.damage)
            return 1; 
        else
            return -1;
    }
    
    public boolean matched(){
    	return this.hp>100 && this.damage<50;
    }
    
    public synchronized void recover() {
    	if(hp > 1000){
    		try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
    		hp = hp + 1;
            System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
            // ֪ͨ��Щ�ȴ���this�����ϵ��̣߳������ѹ����ˣ����20�У��ȴ��ŵļ�Ѫ�̣߳����ѹ���
            this.notify();
    	}
        
    }
 
    public synchronized void hurt() {
        if (hp < 0) {
            try {
                // ��ռ��this�ļ�Ѫ�̣߳���ʱ�ͷŶ�this��ռ�У����ȴ�
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
        	hp = hp - 1;
            System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
            this.notify();
        }
 
        
    }
    
    public void attackHero(Hero h) {
        /*try {
            //Ϊ�˱�ʾ������Ҫʱ�䣬ÿ�ι�����ͣ1000����
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        h.hp-=damage;
        System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n",name,h.name,h.name,h.hp);
         
        if(h.isDead())
            System.out.println(h.name +"���ˣ�");
    }
 
    public boolean isDead() {
        return 0>=hp?true:false;
    }
    
    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }
        
}