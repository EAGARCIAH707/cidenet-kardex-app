package com.cidenet.kardexapp.repository.product.impl;

import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import com.cidenet.kardexapp.repository.product.IProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductRepositoryFacade {
    private final IProductRepository productRepository;

    public ProductRepositoryImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductEntity> save(ProductEntity productEntity) throws SystemException {
        if (productEntity.getQuantity() < 0) {
            throw new SystemException("It is not possible to create a product with a negative amount");
        }
        return Optional.of(productRepository.save(productEntity));
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}
