package com.cidenet.kardexapp.service.product.impl;

import com.cidenet.kardexapp.commons.converter.ProductConverter;
import com.cidenet.kardexapp.commons.domains.generic.ProductDTO;
import com.cidenet.kardexapp.commons.exceptions.SystemException;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import com.cidenet.kardexapp.repository.product.impl.ProductRepositoryFacade;
import com.cidenet.kardexapp.service.in.IInService;
import com.cidenet.kardexapp.service.kardex.impl.KardexServiceImpl;
import com.cidenet.kardexapp.service.product.IProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ProductServiceImpl implements IProductService {
    private final ProductRepositoryFacade productRepository;
    private final ProductConverter productConverter;
    private final KardexServiceImpl kardexService;
    private final IInService inService;

    public ProductServiceImpl(ProductRepositoryFacade productRepository, ProductConverter productConverter,
                              KardexServiceImpl kardexService, IInService inService) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.kardexService = kardexService;
        this.inService = inService;
    }

    @Override
    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) throws SystemException {
        log.info("Create product,{}", productDTO);
        Optional<ProductEntity> product = productRepository
                .save(productConverter.converterProductDTOtoProductEntity(productDTO));
        if (product.isPresent()) {
            Optional<KardexEntity> kardex = kardexService.createKardexFromProduct(product.get());
            if (kardex.isPresent()) {
                inService.createInFromKardex(kardex.get());
                return productConverter.converterProdEntityToProdDTO(product.get());
            } else {
                log.error("Not possible create kardex,{}", kardex);
                throw new SystemException("Not posible create kardex for product");
            }
        } else {
            log.error("Not possible create product,{}", product);
            throw new SystemException("Not possible create product");
        }
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
