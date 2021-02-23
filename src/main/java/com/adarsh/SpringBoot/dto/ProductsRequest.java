package com.adarsh.SpringBoot.dto;

public class ProductsRequest {
    private String searchTerm;
    private String stockLocation;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getStockLocation() {
        return stockLocation;
    }

    public void setStockLocation(String stockLocation) {
        this.stockLocation = stockLocation;
    }

    @Override
    public String toString() {
        return "ProductsRequest{" +
                "searchTerm='" + searchTerm + '\'' +
                ", stockLocation='" + stockLocation + '\'' +
                '}';
    }
}
