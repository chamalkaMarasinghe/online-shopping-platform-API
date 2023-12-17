package com.onlineShoppingAPI.orderService.service;

import com.onlineShoppingAPI.orderService.dto.InventoryResponse;
import com.onlineShoppingAPI.orderService.dto.OrderRequest;
import com.onlineShoppingAPI.orderService.model.Item;
import com.onlineShoppingAPI.orderService.model.Order;
import com.onlineShoppingAPI.orderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public OrderService(OrderRepository orderRepository, WebClient.Builder webClientBuilder){
        this.orderRepository = orderRepository;
        this.webClientBuilder = webClientBuilder;
    }

    @Transactional
    //in this method order is placed only if all requested items are available(qty > 0) in the inventory
    //communicate with inventory service
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

        List<String> itemCodes = order.getItems().stream().map(item -> item.getItemCode()).toList();

        //inter process communication with other service - inventory service
        InventoryResponse[] inventoryItems = webClientBuilder.build().get()
                .uri("http://inventoryService/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("codes", itemCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean isAllItemsAvailable = Arrays.stream(inventoryItems).allMatch(inventoryResponse -> inventoryResponse.getIsAvailable());

        if(isAllItemsAvailable){
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("There are some out of stock items!");
        }
    }
}
