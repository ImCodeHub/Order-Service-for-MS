package com.example.order_service.Controller;

import com.example.order_service.Entity.Order;
import com.example.order_service.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("post-order")
    public ResponseEntity<Order> placeOrder(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity
                                            ){
        Order order = orderService.placeOrder(userId, productId, quantity);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }


}
