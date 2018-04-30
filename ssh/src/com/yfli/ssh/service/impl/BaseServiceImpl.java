package com.yfli.ssh.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yfli.ssh.dao.impl.DAOImpl;
import com.yfli.ssh.pojo.Category;
import com.yfli.ssh.service.BaseService;
import com.yfli.ssh.util.Page;
  
  
@Service
public class BaseServiceImpl extends ServiceDelegateDAO  implements BaseService {
  
    @Autowired DAOImpl dao;
      
    protected Class clazz;;
    
    public static void main(String[] args) {
        new CategoryServiceImpl().showClass();
    }
     
    public void showClass(){
        System.out.println(clazz);
    }
     
    public BaseServiceImpl(){
        try{
            throw new Exception(); 
        }
        catch(Exception e){
            StackTraceElement stes[]= e.getStackTrace();
            String serviceImpleClassName=   stes[1].getClassName();
            try {
                Class  serviceImplClazz= Class.forName(serviceImpleClassName);
                String serviceImpleClassSimpleName = serviceImplClazz.getSimpleName();
                String pojoSimpleName = serviceImpleClassSimpleName.replaceAll("ServiceImpl", "");
                String pojoPackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
                String pojoFullName = pojoPackageName +"."+ pojoSimpleName;
                clazz=Class.forName(pojoFullName);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }      
    }
      
    @Override
    public List list() {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.addOrder(Order.desc("id"));
        return dao.findByCriteria(dc);
    }
    @Override
    public int total() {
        String hql = "select count(*) from " + clazz.getName() ;
        List<Long> l= dao.find(hql);
        if(l.isEmpty())
            return 0;
        Long result= l.get(0);
        return result.intValue();
    }
    @Override
    public List<Object> listByPage(Page page) {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.addOrder(Order.desc("id"));
        return dao.findByCriteria(dc,page.getStart(),page.getCount());
    }
    @Override
    public Integer save(Object object) {
        return (Integer) dao.save(object);
    }
/*    @Override
    public void delete(Object object) {
        dao.delete(object);
          
    }*/
    @Override
    public Object get(Class clazz, int id) {
        return dao.get(clazz, id);
    }
/*    @Override
    public void update(Object object) {
        dao.update(object);
    }*/
    @Override
    public Object get(int id) {
        return dao.get(clazz, id);
    }
    
    @Override
    public List listByParent(Object parent) {
        String parentName= parent.getClass().getSimpleName();
        String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.add(Restrictions.eq(parentNameWithFirstLetterLower, parent));
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc);
    }
 
    @Override
    public List list(Page page, Object parent) {
        String parentName= parent.getClass().getSimpleName();
        String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.add(Restrictions.eq(parentNameWithFirstLetterLower, parent));
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc,page.getStart(),page.getCount());
    }
 
    @Override
    public int total(Object parentObject) {
        String parentName= parentObject.getClass().getSimpleName();
        String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
         
        String sqlFormat = "select count(*) from %s bean where bean.%s = ?";
        String hql = String.format(sqlFormat, clazz.getName(), parentNameWithFirstLetterLower);
         
        List<Long> l= this.find(hql,parentObject);
        if(l.isEmpty())
            return 0;
        Long result= l.get(0);
        return result.intValue();
    }
    
    @Override
    public List list(Object... pairParms) {
        HashMap<String,Object> m = new HashMap<>();
        for (int i = 0; i < pairParms.length; i=i+2)
            m.put(pairParms[i].toString(), pairParms[i+1]);
 
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
 
        Set<String> ks = m.keySet();
        for (String key : ks) {
            if(null==m.get(key))
                dc.add(Restrictions.isNull(key));
            else
                dc.add(Restrictions.eq(key, m.get(key)));
        }
        dc.addOrder(Order.desc("id"));
        return this.findByCriteria(dc);
    }
}