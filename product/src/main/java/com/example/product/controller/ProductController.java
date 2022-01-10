package com.example.product.controller;

import com.example.product.exception.ResourceNotFoundException;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        boolean isSuccess = productService.createProduct(product);
        if (isSuccess) {
            return new ResponseEntity<String>("Product has been added", HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Product addition failed", HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public ResponseEntity<?> findAllProduct() {
        return new ResponseEntity<>(productService.findAllProduct(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "id") int productId)
            throws ResourceNotFoundException {
        Product product = productService.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

        @PutMapping
        public ResponseEntity<?> updateProduct(@RequestBody Product product) {
            boolean isSuccess = productService.updateProduct(product);
            if (isSuccess) {
                return new ResponseEntity<String>("Product details has been updated", HttpStatus.OK);
            }
            return new ResponseEntity<String>("Product details updating failed", HttpStatus.BAD_REQUEST);
        }

        @DeleteMapping
        public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
            productService.deleteUser(product);
            return new ResponseEntity<String>("Product has been deleted.", HttpStatus.OK);
        }

    }
