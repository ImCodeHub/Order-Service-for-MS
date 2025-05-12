package com.example.order_service.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetail {
    private Long productId;
    private String userName;
    private String productName;
    private double price;
    private int quantity;

}
