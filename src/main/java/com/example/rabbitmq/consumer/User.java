package com.example.rabbitmq.consumer;

import com.example.rabbitmq.config.MessagingConfig;
import com.example.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class User {

    private final List<OrderStatus> consumedMessages = new ArrayList<>();
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
        consumedMessages.add(orderStatus);
    }
    // Getter for consumed messages
    public List<OrderStatus> getConsumedMessages() {
        return new ArrayList<>(consumedMessages); // Return a copy to avoid modification
    }

    // Clear messages (optional)
    public void clearConsumedMessages() {
        consumedMessages.clear();
    }
}
