package com.shopping.cart.service;

import com.shopping.cart.bean.Product;

public interface ProductService {

public Product saveProduct(Product product);

public Product getProductById(Long id);

public void deleteProductById(Long id);

}