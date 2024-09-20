package com.marketplace.controllers;

import com.marketplace.models.dtos.ProductRequest;
import com.marketplace.models.dtos.ProductResponse;
import com.marketplace.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<Page<ProductResponse>> findAll(@PageableDefault Pageable pageable){
        return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody ProductRequest request){
        ProductResponse response = productService.save(request);
        return ResponseEntity.created(URI.create("api/products" +response.getId())).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request ){
        return new ResponseEntity<>(productService.update(id,request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }
}
