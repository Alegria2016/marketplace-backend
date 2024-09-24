package com.marketplace.repositories;

import com.marketplace.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT P FROM Product P WHERE (P.user.id = :userId) ")
    List<Product> findByUserId(@Param("userId") Long userId);
}
