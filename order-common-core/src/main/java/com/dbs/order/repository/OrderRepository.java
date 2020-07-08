package com.dbs.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.order.common.dto.Orders;

public interface OrderRepository extends CrudRepository<Orders, String> {
	List<Orders> findAll();
	Orders findByOrderId(String orderId);
}
