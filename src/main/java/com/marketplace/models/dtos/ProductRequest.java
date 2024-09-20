package com.marketplace.models.dtos;

import com.marketplace.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long id;
    private String name;
    private String sku;
    private int quantity;
    private double price;
    private LocalDateTime createdUp;
    private LocalDateTime updatedUp;
    private UserRequest user;
    private CategoryRequest category;
}
