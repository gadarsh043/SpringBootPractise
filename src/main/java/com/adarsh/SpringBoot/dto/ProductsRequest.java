package com.adarsh.SpringBoot.dto;

public class ProductsRequest {
    private String searchTerm;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public String toString() {
        return "ProductsRequest{" +
                "searchTerm='" + searchTerm + '\'' +
                '}';
    }
}
