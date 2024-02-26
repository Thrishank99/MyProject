package com.org.java.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.java.dto.ProductDTO;
import com.org.java.service.ProductService;


@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO){
		ProductDTO productAdded=productService.saveProductDetails(productDTO);
		return new ResponseEntity<>(productAdded,HttpStatus.CREATED);
	}
	@GetMapping("/findAllProduct")
	public ResponseEntity<List<ProductDTO>> findAllProducts(){
		List<ProductDTO> productAdded=productService.findAllProductsDetails();
		return new ResponseEntity(productAdded,HttpStatus.CREATED);
	}
}