package com.dbs.order.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbs.order.common.dto.Item;

@FeignClient(value = "orderItemServiceClient", url = "http://localhost:9090/order-item-service")
public interface OrderItemServiceClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/orderitems")
	void createOrders(List<Item> items);
	@RequestMapping(method = RequestMethod.GET, value = "/orderitems/productcodes", produces = "application/json")
	List<Item> getOrderItemsByProductCodes(@RequestParam List<String> productCodes);
	@RequestMapping(method = RequestMethod.GET, value = "/orderitems/productcodes/{productCode}", produces = "application/json")
	Item getOrderItemsByProductCode(@PathVariable String productCode);
}
