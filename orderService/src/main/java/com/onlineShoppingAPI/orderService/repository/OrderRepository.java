package com.onlineShoppingAPI.orderService.repository;

import com.onlineShoppingAPI.orderService.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
