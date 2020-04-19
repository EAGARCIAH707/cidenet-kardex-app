package com.cidenet.kardexapp.service.product.impl;

import com.cidenet.kardexapp.commons.converter.ProductConverter;
import com.cidenet.kardexapp.commons.domains.generic.ProductDTO;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import com.cidenet.kardexapp.repository.product.impl.ProductRepositoryFacade;
import com.cidenet.kardexapp.service.kardex.impl.KardexServiceImpl;
import com.cidenet.kardexapp.service.product.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepositoryFacade productRepository;
    private final ProductConverter productConverter;
    private final KardexServiceImpl kardexService;

    public ProductServiceImpl(ProductRepositoryFacade productRepository, ProductConverter productConverter,
                              KardexServiceImpl kardexService) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.kardexService = kardexService;
    }

    @Override
    public ProductEntity createProduct(ProductDTO productDTO) throws SystemException {
        Optional<ProductEntity> product = productRepository
                .save(productConverter.converterProductDTOtoProductEntity(productDTO));
        if (product.isPresent()) {
            kardexService.createKardexFromProduct(product.get());
            return product.get();
        } else {
            throw new SystemException("Not possible create product");
        }
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
