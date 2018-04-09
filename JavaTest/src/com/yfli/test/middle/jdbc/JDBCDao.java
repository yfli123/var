package com.yfli.test.middle.jdbc;

import java.util.List;

import com.yfli.test.middle.lambda.Hero;

  
public interface JDBCDao{
    //����
    public void add(Hero hero);
    //�޸�
    public void update(Hero hero);
    //ɾ��
    public void delete(int id);
    //��ȡ
    public Hero get(int id);
    //��ѯ
    public List<Hero> list();
    //��ҳ��ѯ
    public List<Hero> list(int start, int count);
}