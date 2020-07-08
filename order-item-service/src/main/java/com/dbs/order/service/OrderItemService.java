package com.dbs.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dbs.order.common.dto.Item;
import com.dbs.order.exception.ItemNotFoundException;
import com.dbs.order.repository.OrderItemRepository;

@Service
public class OrderItemService implements IOrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void createOrderItems(List<Item> items) {
		items.parallelStream().forEach(orderItem -> orderItemRepository.save(orderItem));
	}

	@Override
	public List<Item> retrieveOrderItems() {
		return orderItemRepository.findAll();
	}

	@Override
	public Item retrieveOrderItemByProductCode(String productCode) {
	    Item item = orderItemRepository.findByProductCode(productCode);
	    if (item == null) {
	        throw new ItemNotFoundException("Item Not found : "+productCode);
	    }
		return orderItemRepository.findByProductCode(productCode);
	}

	@Override
	public Item retrieveOrderItemByProductName(String productName) {
		return orderItemRepository.findByProductName(productName);
	}

    @Override
    public List<Item> retrieveOrderItemByProductCodes(List<String> productCodes) {
        List<Item> items = orderItemRepository.findAllByProductCodeIn(productCodes);
        if (CollectionUtils.isEmpty(items)) {
            throw new ItemNotFoundException("Items Not found : "+productCodes);
        }
        return items;
    }
}
