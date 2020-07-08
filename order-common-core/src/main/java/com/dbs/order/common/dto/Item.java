package com.dbs.order.common.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Item {

	@Id
	@NotBlank(message = "productCode is mandatory")
	private String productCode;
	
	@NotBlank(message = "productName is mandatory")
	private String productName;
	
	@NotBlank(message = "quantity is mandatory")
	private String quantity;

}
