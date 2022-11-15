package com.shopping.cart.service;

import com.shopping.cart.bean.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface ProductService {

public Product saveProduct(Product product);

public Product getProductById(Long id);

public void deleteProductById(Long id);

}