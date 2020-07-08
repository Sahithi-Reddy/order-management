package com.dbs.order.common.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Orders {
	
	@Id
	@NotBlank(message = "orderId is mandatory")
	private String orderId;	
	
	@NotBlank(message = "customerName is mandatory")
	private String customerName;
	
	@NotBlank(message = "orderDate is mandatory")
	private String orderDate;
	
	@NotBlank(message = "shippingAddress is mandatory")
	private String shippingAddress;
	
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ORDER_ID")
	private List<Item> item;
	
	@NotBlank(message = "total is mandatory")
	private String total;
	
	@Transient
	private List<String> productCodes;
}
