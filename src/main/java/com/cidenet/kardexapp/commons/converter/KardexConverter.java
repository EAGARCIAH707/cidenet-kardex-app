package com.cidenet.kardexapp.commons.converter;

import com.cidenet.kardexapp.commons.domains.generic.KardexDTO;
import com.cidenet.kardexapp.model.entities.KardexEntity;
import com.cidenet.kardexapp.model.entities.ProductEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class KardexConverter {
    public KardexEntity converterKardexDTOToKardexEntity(KardexDTO kardexDTO) {
        return KardexEntity.builder()
                .productId(ProductEntity.builder().productId(kardexDTO.getProductId()).build())
                .minimumStock(kardexDTO.getMinimumStock())
                .maximumStock(kardexDTO.getMaximumStock())
                .quantity(kardexDTO.getQuantity())
                .reference(kardexDTO.getReference())
                .unitCost(kardexDTO.getUnitCost())
                .totalCost(kardexDTO.getTotalCost())
                .build();
    }

    public KardexDTO converterProductToKardexDTO(ProductEntity productEntity) {
        return KardexDTO.builder()
                .productId(productEntity.getProductId())
                .quantity(productEntity.getQuantity())
                .maximumStock(productEntity.getQuantity())
                .minimumStock(productEntity.getQuantity())
                .unitCost(productEntity.getPurchasePrice())
                .totalCost(productEntity.getPurchasePrice() * productEntity.getQuantity())
                .reference("Ref-Kardex".concat(productEntity.getReference()))
                .build();
    }
}
