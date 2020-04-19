package com.cidenet.kardexapp.service.product;

import com.cidenet.kardexapp.commons.domains.generic.ProductDTO;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.ProductEntity;

import java.util.List;

public interface IProductService {
    ProductEntity createProduct(ProductDTO productDTO) throws SystemException;

    List<ProductEntity> getAllProducts();
}
