package com.example.rabbitexample.controller;

import com.example.rabbitexample.dto.Order;
import com.example.rabbitexample.dto.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderPublisherController {
    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/")
    public String bookOrder(@RequestBody Order order,@RequestParam String restourantName){
        order.setId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order,"PROCESS",String.format("processing %s", restourantName));
        rabbitTemplate.convertAndSend("exchange1","route1",orderStatus);
        return "Success!";
    }
}
