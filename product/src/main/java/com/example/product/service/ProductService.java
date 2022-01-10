package com.example.product.service;

import com.example.product.dao.ProductDAO;
import com.example.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public boolean createProduct(Product product) {
        Product result = productDAO.saveAndFlush(product);
        return result != null;
    }

    public List<Product> findAllProduct() {
        return productDAO.findAll();
    }

    public Optional<Product> findById(int productId) {

        return productDAO.findById(productId);
    }


    public boolean updateProduct(Product product) {
        Product result = productDAO.save(product);
        return result != null;
    }

    public void deleteUser(Product product) {
        productDAO.delete(product);
    }
}
