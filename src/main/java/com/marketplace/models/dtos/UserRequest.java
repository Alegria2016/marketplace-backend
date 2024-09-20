package com.marketplace.models.dtos;

import com.marketplace.models.enums.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private int status;
    private LocalDateTime createdUp;
    private LocalDateTime updatedUp;
    private Role role;
}
