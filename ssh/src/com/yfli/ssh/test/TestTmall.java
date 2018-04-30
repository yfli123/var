package com.yfli.ssh.test;
 
import java.util.List;
 
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yfli.ssh.dao.impl.DAOImpl;
import com.yfli.ssh.pojo.Category;
 
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTmall {
    @Autowired
    DAOImpl dao;
 
    @Test
    public void delete() {
        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
        List<Category> cs = dao.findByCriteria(dc);
        for (Category c : cs) {
            dao.delete(c);
        }
    }
 
    @Test
    public void test() {
    	System.out.println("1111");
        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
        List<Category> cs = dao.findByCriteria(dc);
        if (cs.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                Category c = new Category();
                c.setName("���Է���" + (i + 1));
                dao.save(c);
            }
            System.out.println("�ɹ����10�����Է���");
        }
    }
}