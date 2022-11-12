package com.shopping.cart.service.impl;

import com.shopping.cart.bean.Product;
import com.shopping.cart.repository.ProductRepository;
import com.shopping.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
