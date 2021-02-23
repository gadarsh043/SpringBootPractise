package com.adarsh.SpringBoot.controller;

import com.adarsh.SpringBoot.dto.ProductsRequest;
import com.adarsh.SpringBoot.dto.ProductsResponse;
import com.adarsh.SpringBoot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Customer {
    @Autowired
    ProductService productService;
    @PostMapping(value="/search")
    public ProductsResponse searchMethod(@RequestBody ProductsRequest request)
    {
        return productService.searchProduct(request);
    }
}
