package com.example.order_service.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String category;
    private double price;
    private int quantity;
}
