package com.onlineShoppingAPI.inventoryService.repository;

import com.onlineShoppingAPI.inventoryService.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    List<Inventory> findByCodeIn(List<String> codes);
}
