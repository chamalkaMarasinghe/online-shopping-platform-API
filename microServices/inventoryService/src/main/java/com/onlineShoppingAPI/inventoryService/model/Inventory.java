package com.onlineShoppingAPI.inventoryService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "inventories")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Inventory {

    @Id
    private String id;
    private String code;
    private Integer quantity;
}
