package com.yfli.ssh.service;

import com.yfli.ssh.pojo.Order;
import com.yfli.ssh.pojo.Review;

public interface ReviewService extends BaseService {
	void saveReviewAndUpdateOrderStatus(Review review, Order order);
}