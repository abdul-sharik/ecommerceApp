package com.example.product.dao;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO  extends JpaRepository<Product,Integer> {

}
