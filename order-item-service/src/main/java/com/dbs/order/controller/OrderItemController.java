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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.order.common.dto.Item;
import com.dbs.order.service.IOrderItemService;

@Validated
@RestController
@RequestMapping(value="/orderitems")
public class OrderItemController {

    Logger LOGGER = LoggerFactory.getLogger(OrderItemController.class);

	@Autowired
	private IOrderItemService orderItemService;

	@PostMapping
	public void createOrders(@RequestBody @Valid List<Item> items, HttpServletResponse response) {
		orderItemService.createOrderItems(items);
		response.setStatus(HttpServletResponse.SC_CREATED);
	}

	@GetMapping
	public List<Item> retrieveOrder() {
		return orderItemService.retrieveOrderItems();
	}

	@GetMapping(path="/productcodes")
	public List<Item> retrieveOrderByProductCodes(@RequestParam List<String> productCodes) {
	    LOGGER.info("product codes : " +productCodes.size());
		return orderItemService.retrieveOrderItemByProductCodes(productCodes);
	}

    @GetMapping(path="/productcodes/{productCode}")
    public Item retrieveOrderByProductCode(@PathVariable("productCode") String productCode) {
        return orderItemService.retrieveOrderItemByProductCode(productCode);
    }

	@GetMapping(path="/productnames/{productName}")
	public Item retrieveOrderByProductName(@PathVariable("productName") String productName) {
		return orderItemService.retrieveOrderItemByProductName(productName);
	}
}
