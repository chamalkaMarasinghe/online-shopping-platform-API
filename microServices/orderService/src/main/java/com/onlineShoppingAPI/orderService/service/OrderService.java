package com.onlineShoppingAPI.orderService.service;

import com.onlineShoppingAPI.orderService.dto.OrderRequest;
import com.onlineShoppingAPI.orderService.model.Item;
import com.onlineShoppingAPI.orderService.model.Order;
import com.onlineShoppingAPI.orderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void createOrder(OrderRequest orderRequest){
        Order order = new Order();
        List<Item> items = orderRequest.getItems().stream().map(itemDto -> {
                Item item = new Item();
                item.setId(itemDto.getId());
                item.setItemCode(itemDto.getItemCode());
                item.setPrice(itemDto.getPrice());
                item.setQuantity(itemDto.getQuantity());
                return item;
            }
        ).toList();

        order.setItems(items);

        orderRepository.save(order);

    }
}
