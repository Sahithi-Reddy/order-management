package com.dbs.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.order.common.dto.Orders;
import com.dbs.order.service.IOrderService;

@Validated
@RestController
@RequestMapping(value="/orders")
public class OrderController {

    Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private IOrderService orderService;

	@PostMapping
	public void createOrders(@RequestBody @Valid List<Orders> orders, HttpServletResponse response) {
	    LOGGER.info("Creating orders");
		orderService.createOrders(orders);
		response.setStatus(HttpServletResponse.SC_CREATED);
	}

	@GetMapping
	public List<Orders> retrieveOrders() {
		return orderService.retrieveOrders();
	}

	@GetMapping(path ="/{orderId}")
	public Orders retrieveOrders(@PathVariable String orderId) {
		return orderService.retrieveOrder(orderId);
	}
}
