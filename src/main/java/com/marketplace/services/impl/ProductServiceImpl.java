package com.marketplace.services.impl;

import com.marketplace.exceptions.CategoryNotFoundException;
import com.marketplace.exceptions.ProductNotFoundException;
import com.marketplace.exceptions.UserNotFoundException;
import com.marketplace.models.dtos.ProductRequest;
import com.marketplace.models.dtos.ProductResponse;
import com.marketplace.models.entities.Product;
import com.marketplace.repositories.CategoryRepository;
import com.marketplace.repositories.ProductRepository;
import com.marketplace.repositories.UserRepository;
import com.marketplace.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public static final ModelMapper modelMapper = new ModelMapper();


    @Override
    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Page<ProductResponse> findAll(Pageable pageable) {
        int startIndex =(int) pageable.getOffset();

        List<Product> products = productRepository.findAll();

        int endIndex = Math.min(startIndex + pageable.getPageSize(), products.size());

        List<ProductResponse> pageContent = products.subList(startIndex,endIndex) .stream()
                .map(product -> modelMapper.map(product,ProductResponse.class))
                .toList();

        return new PageImpl<>(pageContent, pageable,products.size());
    }

    @Override
    public ProductResponse save(ProductRequest request) {
        return categoryRepository.findById(request.getCategory().getId())
                .map(category -> userRepository.findById(request.getUser().getId())
                        .map(user -> {
                            Product product = Product.builder()
                                    .name(request.getName())
                                    .sku(request.getSku())
                                    .quantity(request.getQuantity())
                                    .price(request.getPrice())
                                    .category(category)
                                    .user(user)
                                    .createdUp(LocalDateTime.now())
                                    .build();

                            return   productRepository.save(product);

                        }) .orElseThrow(UserNotFoundException::new)


                ).map(product -> modelMapper
                        .map(product, ProductResponse.class)).orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        return productRepository.findById(id)
                .map(product -> categoryRepository
                        .findById(request.getCategory().getId())
                        .map(category -> {
                            product.setName(request.getName());
                            product.setSku(request.getSku());
                            product.setQuantity(request.getQuantity());
                            product.setPrice(request.getPrice());
                            product.setCategory(category);
                            product.setUpdatedUp(LocalDateTime.now());

                            return productRepository.save(product);
                        })
                        .orElseThrow(CategoryNotFoundException::new)
                )
                .map(product -> modelMapper
                        .map(product,ProductResponse.class)).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(productRepository.findById(id).isEmpty()){
            throw new ProductNotFoundException();
        }

        productRepository.deleteById(id);

    }
}
