package com.adarsh.SpringBoot.dto;

import java.util.List;

public class ProductsResponse {
    private List<Products> productsList;

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
