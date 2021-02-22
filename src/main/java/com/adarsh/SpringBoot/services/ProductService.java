package com.adarsh.SpringBoot.services;

import com.adarsh.SpringBoot.dto.ProductsRequest;
import com.adarsh.SpringBoot.dto.ProductsResponse;

public interface ProductService{
    ProductsResponse searchProduct(ProductsRequest productRequest);
}
