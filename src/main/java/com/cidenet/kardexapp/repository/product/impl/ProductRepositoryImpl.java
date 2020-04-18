package com.cidenet.kardexapp.repository.product.impl;

import com.cidenet.kardexapp.model.entities.ProductEntity;
import com.cidenet.kardexapp.repository.product.IProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductRepositoryFacade {
    private final IProductRepository productRepository;

    public ProductRepositoryImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductEntity> save(ProductEntity productEntity) {
        return Optional.of(productRepository.save(productEntity));
    }
}
