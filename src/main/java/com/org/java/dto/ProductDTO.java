package com.org.java.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	private int productId;
	private String name;
	private int price;
	private int qty;

}
