package com.org.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.java.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
