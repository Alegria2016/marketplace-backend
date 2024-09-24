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
@Table(name = "Companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition="TEXT", length = 1000)
    private String description;
    @Column(name = "created_up")
    private LocalDateTime createdUp;
    @Column(name = "updated_up")
    private LocalDateTime updatedUp;
}
