package com.example.cart.dao;

import com.example.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDAO extends JpaRepository<Cart,String> {

    List<Cart> findByUsername(String username);
}
