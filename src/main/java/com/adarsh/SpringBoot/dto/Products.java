package com.adarsh.SpringBoot.dto;

public class Products {
    private boolean inStock;
    private int salesPrice;
    private String description;
    private String title;

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Products{" +
                "inStock=" + inStock +
                ", salesPrice=" + salesPrice +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
