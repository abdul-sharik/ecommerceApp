package com.example.cart.model;

import lombok.Data;


@Data
public class Cart {

    private String username;
    private Product product;
    private int count;
}
