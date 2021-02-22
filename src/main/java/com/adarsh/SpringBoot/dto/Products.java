package com.adarsh.SpringBoot.dto;

public class Products {
    private int productId;
    private String ProductName;
    private int inStock;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", ProductName='" + ProductName + '\'' +
                ", inStock=" + inStock +
                '}';
    }


}
