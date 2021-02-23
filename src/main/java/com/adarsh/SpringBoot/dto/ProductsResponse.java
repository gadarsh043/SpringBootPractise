package com.adarsh.SpringBoot.dto;

import java.util.List;

public class ProductsResponse {
    private List<Products> productsList;
    private List<Products> locationList;

    public List<Products> getProductsList() {
        return productsList;
    }

    public List<Products> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Products> locationList) {
        this.locationList = locationList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
