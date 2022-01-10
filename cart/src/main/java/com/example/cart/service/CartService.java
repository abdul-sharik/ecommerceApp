package com.example.cart.service;

import com.example.cart.dao.CartDAO;
import com.example.cart.exception.CartException;
import com.example.cart.model.Cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class CartService {

    private CartDAO cartdao;


    public List<Cart> getProductListWithUsername(String username) {
        List<Cart> cartList = cartdao.findByUsername(username);
        if (cartList.isEmpty()) {
            throw new CartException("Cart is empty.");
        }

        return cartList;
    }
/*
    public Map<String, Object> getUserListWithProductName(String productName) {
        List<Cart> cartList = cartdao.findAll();
        if (cartList.isEmpty()) {
            throw new CartException("Cart is empty.");
        }


        Set<String> userList = cartList.stream()
                .filter(r -> r.getProduct().getName().equals(productName))
                .map(r -> r.getUsername()).collect(Collectors.toSet());

        Map<String, Object> map = new HashMap<>();
        map.put("product", productName);
        map.put("users", userList);



        return map;


    }



 */
}
