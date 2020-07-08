package com.dbs.order.service;

import java.util.List;

import com.dbs.order.common.dto.Item;

public interface IOrderItemService {

	void createOrderItems(List<Item> items);
	List<Item> retrieveOrderItems();
	Item retrieveOrderItemByProductCode(String productCode);
	Item retrieveOrderItemByProductName(String productName);
    List<Item> retrieveOrderItemByProductCodes(List<String> productCodes);
}
