package com.marketplace.services;

import com.marketplace.models.dtos.ProductRequest;
import com.marketplace.models.dtos.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponse findById(Long id);

    List<ProductResponse> findByUserId(Long id);

    List<ProductResponse> findAll(Pageable pageable);
    ProductResponse save(ProductRequest request);
    ProductResponse update(Long id, ProductRequest request);
    void deleteById(Long id);
}
