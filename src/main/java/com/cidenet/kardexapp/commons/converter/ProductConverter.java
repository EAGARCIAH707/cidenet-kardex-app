package com.cidenet.kardexapp.commons.converter;

import com.cidenet.kardexapp.commons.domains.generic.ProductDTO;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@Log4j2
public class ProductConverter {
    public ProductEntity converterProductDTOtoProductEntity(ProductDTO productDTO) {
        return ProductEntity.builder()
                .name(productDTO.getName())
                .reference(productDTO.getReference())
                .salePrice(productDTO.getSalePrice())
                .purchasePrice(productDTO.getPurchasePrice())
                .description(productDTO.getDescription())
                .state(productDTO.getState() != null ? productDTO.getState() : true)
                .available(productDTO.getQuantity() > 0)
                .createdOn(new Timestamp(new Date().getTime()))
                .lastModified(new Timestamp(new Date().getTime()))
                .quantity(productDTO.getQuantity())
                .build();
    }

    public ProductDTO converterProdEntityToProdDTO(ProductEntity productEntity) {
        return ProductDTO.builder()
                .productId(productEntity.getProductId())
                .name(productEntity.getName())
                .reference(productEntity.getReference())
                .salePrice(productEntity.getSalePrice())
                .purchasePrice(productEntity.getPurchasePrice())
                .description(productEntity.getDescription())
                .state(productEntity.getState())
                .available(productEntity.getAvailable())
                .createdOn(productEntity.getCreatedOn())
                .lastModified(productEntity.getLastModified())
                .quantity(productEntity.getQuantity())
                .build();
    }
}
