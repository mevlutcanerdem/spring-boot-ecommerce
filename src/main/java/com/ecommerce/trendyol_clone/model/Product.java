package com.ecommerce.trendyol_clone.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="products")
public class Product {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Product name can not be empty!")
    @Size(min = 3 , max = 50, message = "Product name should be between 3,50 characters")
    private String name;

    @NotNull(message = "Product price could not be empty!")
    @Positive(message = "Price should be bigger than zero!")
    private Double price;

    @NotNull(message = "Stock count could not be empty")
    @Min(value = 0, message = "Stock count is not allowed to be negative")
    private Integer stock;


    public Product(){

    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
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
    public Integer getStock(){
        return stock;
    }
    public void setStock(Integer stock){
        this.stock = stock;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory(){
        return category;
    }
    public void setCatogery(Category category){
        this.category = category;
    }

}
