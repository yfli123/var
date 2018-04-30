package com.yfli.ssh.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yfli.ssh.pojo.Order;
import com.yfli.ssh.pojo.Review;
import com.yfli.ssh.service.OrderService;
import com.yfli.ssh.service.ReviewService;
 
 
@Service
public class ReviewServiceImpl  extends BaseServiceImpl implements ReviewService {
@Autowired OrderService orderService;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void saveReviewAndUpdateOrderStatus(Review review, Order order) {
		orderService.update(order);
		save(review);
	}
}