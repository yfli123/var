package com.yfli.ssh.service;

import java.util.List;

import com.yfli.ssh.pojo.Order;
import com.yfli.ssh.pojo.OrderItem;
import com.yfli.ssh.pojo.User;

public interface OrderService extends BaseService {
    public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";
    
    public float createOrder(Order order, List<OrderItem> ois);
    
    public List<Order> listByUserWithoutDelete(User user);
     
}