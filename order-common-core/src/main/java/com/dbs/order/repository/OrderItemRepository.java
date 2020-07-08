package com.dbs.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.order.common.dto.Item;

public interface OrderItemRepository extends CrudRepository<Item, String>{
	
	List<Item> findAll();
	Item findByProductCode(String productCode);
	Item findByProductName(String productName);
    List<Item> findAllByProductCodeIn(List<String> productCode);
}
