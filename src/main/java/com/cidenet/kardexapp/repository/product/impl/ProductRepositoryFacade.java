package com.cidenet.kardexapp.repository.product.impl;

import com.cidenet.kardexapp.model.entities.ProductEntity;

import java.util.Optional;

public interface ProductRepositoryFacade {
    Optional<ProductEntity> save(ProductEntity productEntity);
}
