package com.onlineShoppingAPI.notificationService;

import com.onlineShoppingAPI.notificationService.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic", groupId = "notificationGroup")
    public void pushNotification(OrderPlacedEvent orderPlacedEvent){
        log.info("Here is the email :- " + orderPlacedEvent.getOrderName());
    }
}
