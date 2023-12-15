package com.onlineShoppingAPI.inventoryService.controller;

import com.onlineShoppingAPI.inventoryService.dto.InventoryResponse;
import com.onlineShoppingAPI.inventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> inStock(@RequestParam List<String> codes){
        return inventoryService.inStock(codes);
    }
}
