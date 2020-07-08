package com.dbs.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dbs.order.client.OrderItemServiceClient;
import com.dbs.order.common.dto.Item;
import com.dbs.order.common.dto.Orders;
import com.dbs.order.exception.ItemNotFoundException;
import com.dbs.order.exception.OrderNotFoundException;
import com.dbs.order.repository.OrderRepository;

@Service
public class OrderService implements IOrderService{

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemServiceClient orderItemServiceClient;

	@Override
	public void createOrders(List<Orders> orders) {
		orders.parallelStream().forEach(order -> {
		    List<Item> items = orderItemServiceClient.getOrderItemsByProductCodes(order.getProductCodes());
		    order.setItem(items);
		    orderRepository.save(order);
		});		
	}

	@Override
	public List<Orders> retrieveOrders() {
		List<Orders> orders = orderRepository.findAll();
		if (CollectionUtils.isEmpty(orders)) {
			throw new OrderNotFoundException("Orders not found");
		}
		return orderRepository.findAll();
	}

	@Override
	public Orders retrieveOrder(String orderId) {
	    Orders order = orderRepository.findByOrderId(orderId);
		if (order == null) {
			throw new OrderNotFoundException("Order not found : " + orderId);
		}
		return order;
	}
}
