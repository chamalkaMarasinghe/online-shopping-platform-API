package com.onlineShoppingAPI.inventoryService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InventoryResponse {

    private String code;
    private Boolean isAvailable;
}
