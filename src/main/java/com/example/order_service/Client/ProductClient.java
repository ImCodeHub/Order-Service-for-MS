package com.example.order_service.Client;

import com.example.order_service.Model.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {
    /**the API should be match with exactly in Product-service's controller has.*/
    @GetMapping("api/products/get-product/{id}")
    public ProductDto getProductById(@PathVariable Long id);
}
