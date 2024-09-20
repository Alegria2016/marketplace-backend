package com.marketplace.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "CREATED_UP", unique = false, nullable = true)
    private LocalDateTime createdUp;

    @Column(name = "UPDATED_UP", unique = false, nullable = true)
    private LocalDateTime updatedUp;
}
