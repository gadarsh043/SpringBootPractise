package com.adarsh.SpringBoot.services.impl;

import com.adarsh.SpringBoot.dto.Products;
import com.adarsh.SpringBoot.dto.ProductsRequest;
import com.adarsh.SpringBoot.dto.ProductsResponse;
import com.adarsh.SpringBoot.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductsResponse searchProduct(ProductsRequest productRequest)
    {
        ProductsResponse response=new ProductsResponse();
        Products product=new Products();
        product.setProductId(1);
        product.setProductName("Apple's Phone");
        product.setInStock(1);
        response.setProductsList(Arrays.asList(product));
        return response;
    }


}
