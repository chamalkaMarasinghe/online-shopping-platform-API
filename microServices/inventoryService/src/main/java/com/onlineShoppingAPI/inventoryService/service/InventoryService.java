package com.onlineShoppingAPI.inventoryService.service;

import com.onlineShoppingAPI.inventoryService.dto.InventoryResponse;
import com.onlineShoppingAPI.inventoryService.model.Inventory;
import com.onlineShoppingAPI.inventoryService.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> inStock(List<String> codes) {
//        Optional<Inventory> inventory = inventoryRepository.findByCodeIn(codes);
//        return inventory.isPresent() && inventory.get().getQuantity() > 0;
        return inventoryRepository.findByCodeIn(codes).stream().map(inventory -> {
            InventoryResponse inventoryResponse = InventoryResponse.builder()
                    .code(inventory.getCode())
                    .isAvailable(inventory.getQuantity() > 0)
                    .build();
            return inventoryResponse;
        }).toList();
    }
}
