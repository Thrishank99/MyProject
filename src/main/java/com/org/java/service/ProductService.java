package com.org.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.java.dto.ProductDTO;

@Service
public interface ProductService {

	ProductDTO saveProductDetails(ProductDTO productDTO);

	List<ProductDTO> findAllProductsDetails();

}
