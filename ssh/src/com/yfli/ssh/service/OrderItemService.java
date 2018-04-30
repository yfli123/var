package com.yfli.ssh.service;
import java.util.List;

import com.yfli.ssh.pojo.Order;
 
public interface OrderItemService extends BaseService {
     
    public void fill(List<Order> orders);
    public void fill(Order order);
         
}