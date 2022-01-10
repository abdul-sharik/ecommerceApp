package com.example.cart.controller;

import com.example.cart.exception.CartException;
import com.example.cart.model.Cart;
import com.example.cart.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private CartService cartService;

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getProductListWithUsername(@PathVariable String username) {
        try {
            List<Cart> carts = cartService.getProductListWithUsername(username);
            return new ResponseEntity<>(carts, HttpStatus.OK);
        } catch (CartException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }

/*
        @GetMapping("/product/{productName}")
        public ResponseEntity<?> getUserListWithProductName(@PathVariable String productName);{
            try {
                Map<String, Object> result = cartService.getUserListWithProductName(productName);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } catch (CartException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
            }

 */
        }



}
