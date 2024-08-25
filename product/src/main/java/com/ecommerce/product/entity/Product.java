package com.ecommerce.product.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private int quantity;
    private double vote;
    private List<String> comment;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}