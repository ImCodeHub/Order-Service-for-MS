package com.example.order_service.Service;

import com.example.order_service.Client.ProductClient;
import com.example.order_service.Client.UserClient;
import com.example.order_service.Entity.Order;
import com.example.order_service.Model.OrderDetail;
import com.example.order_service.Model.ProductDto;
import com.example.order_service.Model.UserDto;
import com.example.order_service.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private final UserClient userClient;

    @Autowired
    private final ProductClient productClient;

    @Autowired
    private final OrderRepository orderRepository;

    public Order placeOrder(Long userId, Long productId, int quantity) {
        UserDto userDto = userClient.getUserById(userId);
        ProductDto productDto = productClient.getProductById(productId);
        if (productDto.getQuantity() < quantity) {
            throw new RuntimeException(" Insufficient product");
        }
        double total = productDto.getPrice() * quantity;

        Order order = Order.builder()
                .userId(userDto.getId())
                .productId(productDto.getId())
                .quantity(quantity)
                .totalPrice(total)
                .build();
        return orderRepository.save(order);
    }

    public List<OrderDetail> getAllOrders(){
        List<OrderDetail> list = new ArrayList<>();
        List<Order> orders = orderRepository.findAll();

        for(Order order : orders){
            UserDto userDto = userClient.getUserById(order.getUserId());
            ProductDto productDto = productClient.getProductById(order.getProductId());
            OrderDetail orderDetail = OrderDetail.builder()
                    .userName(userDto.getName())
                    .productName(productDto.getName())
                    .price(order.getTotalPrice())
                    .quantity(order.getQuantity())
                    .build();
            list.add(orderDetail);
        }
        return list;
    }
}