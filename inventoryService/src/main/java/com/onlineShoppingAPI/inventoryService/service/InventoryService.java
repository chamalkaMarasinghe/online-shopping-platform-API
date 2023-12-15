package com.onlineShoppingAPI.inventoryService.service;

import com.onlineShoppingAPI.inventoryService.model.Inventory;
import com.onlineShoppingAPI.inventoryService.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public boolean inStock(String code) {
        Optional<Inventory> inventory = inventoryRepository.findByCode(code);
        return inventory.isPresent() && inventory.get().getQuantity() > 0;
    }
}
