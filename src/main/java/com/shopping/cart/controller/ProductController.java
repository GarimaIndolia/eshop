package com.shopping.cart.controller;

import com.shopping.cart.bean.Product;
import com.shopping.cart.constant.Constant;
import com.shopping.cart.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = Constant.BASE_URL)
@Slf4j
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping(value = Constant.GET_PRODUCT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductDetails(@RequestParam(value="productId") Long productId)  {
        return new ResponseEntity(productService.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping(value = Constant.ADD_PRODUCT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProduct(@RequestBody Product product)  {
        return new ResponseEntity(productService.saveProduct(product).getProductId(), HttpStatus.CREATED);
    }

    @DeleteMapping(value= Constant.DELETE_PRODUCT)
    public ResponseEntity deleteProduct(@RequestParam(value="productId") Long productId){
        productService.deleteProductById(productId);
        return new ResponseEntity(HttpStatus.OK);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity handleError(HttpServletRequest req, Exception ex) {
        return new ResponseEntity("Internal Server Error has occurred... "+ex, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
