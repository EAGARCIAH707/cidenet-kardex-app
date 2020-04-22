package com.cidenet.kardexapp.repository.product.impl;

import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryFacade {
    Optional<ProductEntity> save(ProductEntity productEntity) throws SystemException;

    List<ProductEntity> findAll();
}
