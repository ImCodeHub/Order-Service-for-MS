package com.example.order_service.Controller;

import com.example.order_service.Entity.Order;
import com.example.order_service.Model.OrderDetail;
import com.example.order_service.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("get-all-order-details")
    public ResponseEntity<List<OrderDetail>> getAllOrders(){
        List<OrderDetail> allOrders = orderService.getAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }


}
