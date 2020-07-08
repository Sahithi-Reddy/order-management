package com.dbs.order.service;

import java.util.List;

import com.dbs.order.common.dto.Orders;

public interface IOrderService {

	void createOrders(List<Orders> orders);

	List<Orders> retrieveOrders();

	Orders retrieveOrder(String orderId);

}
