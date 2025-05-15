package com.example.order_service.Client;

import com.example.order_service.Model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("api/users/get-user/{id}")
    public UserDto getUserById(@PathVariable Long id);
}
