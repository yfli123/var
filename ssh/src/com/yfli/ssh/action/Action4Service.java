package com.yfli.ssh.action;

import java.lang.reflect.Method;

import org.apache.commons.lang.xwork.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yfli.ssh.service.CategoryService;
import com.yfli.ssh.service.OrderItemService;
import com.yfli.ssh.service.OrderService;
import com.yfli.ssh.service.ProductImageService;
import com.yfli.ssh.service.ProductService;
import com.yfli.ssh.service.PropertyService;
import com.yfli.ssh.service.PropertyValueService;
import com.yfli.ssh.service.ReviewService;
import com.yfli.ssh.service.UserService;

public class Action4Service extends Action4Pojo{
 
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    PropertyService propertyService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    ProductImageService productImageService;
    
    @Autowired
    UserService userService;    
    
    @Autowired
    PropertyValueService propertyValueService; 
    
    @Autowired
    OrderService orderService; 
    
    @Autowired
    OrderItemService orderItemService; 
    
    @Autowired
    ReviewService reviewService; 
    /**
     * transient to persistent
     * 瞬时对象转换为持久对象
     * @param o
     */
    public void t2p(Object o){
            try {
                Class clazz = o.getClass();
                int id = (Integer) clazz.getMethod("getId").invoke(o);
                Object persistentBean = categoryService.get(clazz, id);
 
                String beanName = clazz.getSimpleName();
                Method setMethod = getClass().getMethod("set" + WordUtils.capitalize(beanName), clazz);
                setMethod.invoke(this, persistentBean);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}
 