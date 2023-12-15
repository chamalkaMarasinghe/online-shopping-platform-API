package com.onlineShoppingAPI.orderService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto {

    private String id;
    private String itemCode;
    private BigDecimal price;
    private Integer quantity;
}
