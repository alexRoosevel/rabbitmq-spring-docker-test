package com.example.rabbitexample.consumer;

import com.example.rabbitexample.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {


    @RabbitListener(queues = "queue1")
    public void consumer(OrderStatus orderStatus){
        System.out.println(orderStatus);
    }
}
