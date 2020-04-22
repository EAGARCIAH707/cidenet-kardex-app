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
                .productId(kardexDTO.getProductId())
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
                .productId(productEntity)
                .quantity(productEntity.getQuantity())
                .maximumStock(productEntity.getQuantity())
                .minimumStock(productEntity.getQuantity())
                .unitCost(productEntity.getPurchasePrice())
                .totalCost(productEntity.getPurchasePrice() * productEntity.getQuantity())
                .reference("Ref-Kardex".concat(productEntity.getReference()))
                .build();
    }

    public KardexDTO converterProdEntityToProdDTO(KardexEntity kardexEntity) {
        return KardexDTO.builder()
    .idKardex(kardexEntity.getIdKardex())
                .minimumStock(kardexEntity.getMinimumStock())
                .maximumStock(kardexEntity.getMaximumStock())
                .reference(kardexEntity.getReference())
                .unitCost(kardexEntity.getUnitCost())
                .totalCost(kardexEntity.getTotalCost())
                .quantity(kardexEntity.getQuantity())
                .productId(kardexEntity.getProductId())
                .outList(kardexEntity.getOutList())
                .inList(kardexEntity.getInList())
                .build();
    }
}
