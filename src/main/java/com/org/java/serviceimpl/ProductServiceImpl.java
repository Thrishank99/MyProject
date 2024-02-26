package com.org.java.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.java.dto.ProductDTO;
import com.org.java.entity.Product;
import com.org.java.mapper.ProductMapper;
import com.org.java.repository.ProductRepository;
import com.org.java.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDTO saveProductDetails(ProductDTO productDTO) {
		Product saveProduct=productRepository.save(ProductMapper.INSTANCE.mapProductDTOToProduct(productDTO));
		return ProductMapper.INSTANCE.mapProductToProductDTO(saveProduct);
	}

	@Override
	public List<ProductDTO> findAllProductsDetails() {
	List<Product> productList=productRepository.findAll();
	List<ProductDTO> productDto=productList.stream().map(s1->ProductMapper.INSTANCE.mapProductToProductDTO(s1)).collect(Collectors.toList());
		return productDto;
	}

}
