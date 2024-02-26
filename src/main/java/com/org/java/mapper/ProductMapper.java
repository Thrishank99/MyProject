package com.org.java.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.org.java.dto.ProductDTO;
import com.org.java.entity.Product;

@Mapper
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	    Product mapProductDTOToProduct(ProductDTO productDTO);
	    ProductDTO mapProductToProductDTO(Product order);

}
