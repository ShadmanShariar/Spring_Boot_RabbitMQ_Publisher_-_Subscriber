package com.example.rabbitmq.consumer;

import com.example.rabbitmq.dto.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private User userConsumer;

    @GetMapping
    public List<OrderStatus> getConsumedMessages() {
        return userConsumer.getConsumedMessages();
    }

    @GetMapping("/clear")
    public String clearMessages() {
        userConsumer.clearConsumedMessages();
        return "Consumed messages cleared!";
    }
}
