package com.ecommerce.trendyol_clone.dto;

// This is not a database table : It has no @Entity annotation
public class ProductDto {

    private String name;
    private Double price;
    // we didn't put stock info so that customer can't see

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }

}
